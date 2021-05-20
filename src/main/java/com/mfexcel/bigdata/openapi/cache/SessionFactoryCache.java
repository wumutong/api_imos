package com.mfexcel.bigdata.openapi.cache;

import com.mfexcel.bigdata.openapi.domain.MapperDomain;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

public class SessionFactoryCache {

    public static Map<String, MapperDomain> mapperDomainMap = new HashMap<>();

    public static Map<Long, SqlSessionFactory> factoryMap = new HashMap<>();
}
