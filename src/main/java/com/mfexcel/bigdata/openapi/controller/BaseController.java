package com.mfexcel.bigdata.openapi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mfexcel.bigdata.openapi.cache.SessionFactoryCache;
import com.mfexcel.bigdata.openapi.domain.MapperDomain;
import com.mfexcel.bigdata.openapi.load.LoadMapperData;
import com.mfexcel.bigdata.openapi.mapper.BaseMapper;
import com.mfexcel.bigdata.openapi.utils.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/**")
@RestController
public class BaseController {

    @Value("${defalt.page.no:1}")
    private int pageNo;
    @Value("${defalt.page.size:10}")
    private int pageSize;

    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private LoadMapperData loadMapperData;

    @PostMapping
    public AjaxResult handler(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) throws Throwable {
        //获取接口地址
        String uri = request.getRequestURI();
        MapperDomain mapperDomain = SessionFactoryCache.mapperDomainMap.get(uri);
        if (mapperDomain == null) {
            throw new NoHandlerFoundException(request.getMethod(), uri, (new ServletServerHttpRequest(request)).getHeaders());
        }
        //读取XML配置文件
        SqlSessionFactory sqlSessionFactory = SessionFactoryCache.factoryMap.get(mapperDomain.getConfigurationId());
        if (sqlSessionFactory == null) {
            throw new NoHandlerFoundException(request.getMethod(), uri, (new ServletServerHttpRequest(request)).getHeaders());
        }
        //通过SqlsessionFactory打开一个数据库会话
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPage page = buildIPage(paramMap);
            if (page != null) {
                paramMap.put("_PAGE_", page);
            }
            List<Map<String, Object>> result = session.selectList("execute_" + mapperDomain.getId(), paramMap);
            if(result.size() == 1 && result.get(0) == null){
                result = new ArrayList<>();
            }
            if (page != null) {
                page.setRecords(result);
                return AjaxResult.success(page);
            }
            return AjaxResult.success(result);
        }
    }

    private IPage buildIPage(Map<String, Object> paramMap) {
        Object pageNoStr = paramMap.get("pageNo");
        if (pageNoStr == null) {
            pageNoStr = paramMap.get("pageIndex");
        }
        Object pageSizeStr = paramMap.get("pageSize");
        if (pageSizeStr != null) {
            int pageNo = this.pageNo;
            try{
                if (pageNoStr != null) {
                    pageNo = Integer.parseInt(pageNoStr.toString());
                }
            } catch (Throwable e) {
                log.error(e.getMessage(), e);
            }
            int pageSize = this.pageSize;
            try{
                pageSize = Integer.parseInt(pageSizeStr.toString());
            } catch (Throwable e) {
                log.error(e.getMessage(), e);
            }
            return new Page(pageNo,pageSize);
        }
        return null;
    }

    @RequestMapping("/_reload")
    private boolean reload(String uri) {
        loadMapperData.load(-1);
        return true;
    }
}
