package com.mfexcel.bigdata.openapi.initialize;

import com.mfexcel.bigdata.openapi.load.LoadMapperData;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class initService implements InitializingBean {

    @Autowired
    LoadMapperData loadMapperData;

    @Override
    public void afterPropertiesSet() {
        loadMapperData.load(-1);
    }
}
