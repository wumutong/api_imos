package com.mfexcel.bigdata.openapi.load;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.mfexcel.bigdata.openapi.cache.SessionFactoryCache;
import com.mfexcel.bigdata.openapi.domain.ConfigurationDomain;
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
import java.util.regex.Pattern;

@Slf4j
@Component
public class LoadMapperData {

    private static final String MAPPER_NAME_PREFIX = "mapper-build-";
    private static AtomicBoolean running = new AtomicBoolean(false);
    @Value("${mybatis.mapper.build:mapper-build}")
    private String mapperBuild;
    @Autowired
    private MapperMapper mapperMapper;

    private final Pattern replacePattern = Pattern.compile("(?<=<mapper url=\"file:///)%s(?=\"/>)");

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
            Map<String, MapperDomain> mapperDomainMap = new HashMap<>();
            Map<Long, SqlSessionFactory> factoryMap = new HashMap<>();
            List<MapperDomain> mapperDomains = new ArrayList<>();
            if (id <= 0) {
                mapperDomains = mapperMapper.listMapper();
            } else {
                MapperDomain mapperDomain = mapperMapper.selectMapper(id);
                if (mapperDomain != null) {
                    mapperDomains.add(mapperDomain);
                }
            }
            Map<Long, List<String>> mapperMap = new HashMap<>();
            Map<Long, ConfigurationDomain> configurationDomainMap = new HashMap<>();
            for (MapperDomain mapper : mapperDomains) {

                String mapperName = MAPPER_NAME_PREFIX + mapper.getId() + ".xml";
                File mapperFile = new File(path, mapperName);
                if (mapperFile.exists()) {
                    mapperFile.delete();
                }
                if (!mapper.isEnable()) {
                    continue;
                }

                // add configurations
                if (!configurationDomainMap.containsKey(mapper.getConfigurationDomain().getId())) {
                    configurationDomainMap.put(mapper.getConfigurationDomain().getId(), mapper.getConfigurationDomain());
                }

                // add mappers
                mapperDomainMap.put(mapper.getUri(), mapper);
                String content = mapper.getContent()
                        .replace("select id=\"execute\"", "select id=\"execute_" + mapper.getId() + "\"")
                        .replace("resultMap=\"execute\"", "resultMap=\"execute_" + mapper.getId() + "\"")
                        .replace("resultMap id=\"execute\"", "resultMap id=\"execute_" + mapper.getId() + "\"");
                try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(mapperFile), "UTF-8");
                     BufferedWriter out = new BufferedWriter(osw)) {
                    out.write(content);
                }
                List mapperNames =  mapperMap.get(mapper.getConfigurationDomain().getId());
                if (mapperNames == null) {
                    mapperNames = new ArrayList();
                    mapperMap.put(mapper.getConfigurationDomain().getId(), mapperNames);
                }
                mapperNames.add(mapperFile.getAbsolutePath());

            }

            for (Map.Entry<Long, ConfigurationDomain> entry : configurationDomainMap.entrySet()) {
                try{
                    String mappers = buildMappersXml(mapperMap.get(entry.getKey()));
                    if (mappers == null) {
                        continue;
                    }
                    String config = entry.getValue().getContent().replace("<mapper url=\"file:///%s\"/>", mappers);
                    InputStream is = new ByteArrayInputStream(config.getBytes("UTF-8"));
                    XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(is);
                    Configuration configuration = xmlConfigBuilder.parse();
                    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
                    mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
                    configuration.addInterceptor(mybatisPlusInterceptor);
                    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

                    factoryMap.put(entry.getKey(), sqlSessionFactory);
                    log.info("mapper build success --> configuration id {} {}", entry.getKey(), sqlSessionFactory);
                } catch (Throwable e){
                    log.error("mapper build error --> configuration id {}", entry.getKey());
                    log.error(e.getMessage(), e);
                }
            }
            SessionFactoryCache.mapperDomainMap = mapperDomainMap;
            SessionFactoryCache.factoryMap = factoryMap;
            log.info("load mapper finished...");
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            running.set(false);
        }
    }

    private String buildMappersXml(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append("<mapper url=\"file:///");
            sb.append(str);
            sb.append("\"/>");
            sb.append("\n");
        }
        return sb.toString();
    }

}
