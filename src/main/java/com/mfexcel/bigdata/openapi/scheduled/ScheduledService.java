package com.mfexcel.bigdata.openapi.scheduled;

import com.mfexcel.bigdata.openapi.load.LoadMapperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledService {


    @Autowired
    LoadMapperData loadMapperData;
/*
    @Scheduled(cron = "${schedule.load.mapper}")
    public void loadMapperData() {
        loadMapperData.load(-1);
    }*/
}
