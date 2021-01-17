package com.mfexcel.bigdata.openapi.cache;

import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

public class SessionFactoryCache {
    public static Map<String, SqlSessionFactory> factoryMap = new HashMap<>();
}
