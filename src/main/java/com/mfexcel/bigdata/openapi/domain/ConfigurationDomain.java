package com.mfexcel.bigdata.openapi.domain;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ConfigurationDomain {
    private Long id;
    private String name;
    private String desc;
    private String content;
    private Timestamp addTime;
    private Timestamp updTIme;
}
