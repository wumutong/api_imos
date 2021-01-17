package com.mfexcel.bigdata.openapi.load;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.mfexcel.bigdata.openapi.cache.SessionFactoryCache;
import com.mfexcel.bigdata.openapi.domain.MapperDomain;
import com.mfexcel.bigdata.openapi.mapper.MapperMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
public class LoadMapperData {

    private static final String MAPPER_NAME_PREFIX = "mapper-build-";
    private static AtomicBoolean running = new AtomicBoolean(false);
    @Value("${mybatis.mapper.build:mapper-build}")
    private String mapperBuild;
    @Autowired
    private MapperMapper mapperMapper;

    public void load(int id) {
        try {
            if (running.getAndSet(true)) {
                log.info("load mapper running...");
                return;
            }
            log.info("load mapper starting...");
            File file = new File(mapperBuild);
            String path = file.getAbsolutePath();
            log.info("mapper build path --> {}", path);
            if (!file.exists()) {
                file.mkdirs();
            }
            Map<String, SqlSessionFactory> factoryMap = new HashMap<>();
            List<MapperDomain> mapperDomains = new ArrayList<>();
            if (id <= 0) {
                mapperDomains = mapperMapper.listMapper();
            } else {
                MapperDomain mapperDomain = mapperMapper.selectMapper(id);
                if (mapperDomain != null) {
                    mapperDomains.add(mapperDomain);
                }
            }
            for (MapperDomain mapper : mapperDomains) {
                try{

                    String mapperName = MAPPER_NAME_PREFIX + mapper.getId() + ".xml";
                    File mapperFile = new File(path, mapperName);
                    if (mapperFile.exists()) {
                        mapperFile.delete();
                    }
                    if (!mapper.isEnable()) {
                        continue;
                    }
                    try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(mapperFile), "UTF-8");
                         BufferedWriter out = new BufferedWriter(osw)) {
                        out.write(mapper.getContent());
                    }
                    String config = String.format(mapper.getConfigurationDomain().getContent(), mapperFile.getAbsolutePath());
                    InputStream is = new ByteArrayInputStream(config.getBytes("UTF-8"));
                    XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(is);
                    Configuration configuration = xmlConfigBuilder.parse();
                    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
                    mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
                    configuration.addInterceptor(mybatisPlusInterceptor);
                    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
                    factoryMap.put(mapper.getUri(), sqlSessionFactory);
                    log.info("mapper build success --> {} [{}] {}", mapper.getId(), mapper.getUri(), sqlSessionFactory);
                } catch (Throwable e){
                    log.error("mapper build error --> {} [{}]", mapper.getId(), mapper.getUri());
                    log.error(e.getMessage(), e);
                }
            }
            SessionFactoryCache.factoryMap = factoryMap;
            log.info("load mapper finished...");
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            running.set(false);
        }
    }

}
