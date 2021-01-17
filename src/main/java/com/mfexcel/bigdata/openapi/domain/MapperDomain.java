package com.mfexcel.bigdata.openapi.domain;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class MapperDomain {
    private Integer id;
    private Long configurationId;
    private String uri;
    private String name;
    private String desc;
    private String content;
    private boolean enable;
    private Timestamp addTime;
    private Timestamp updTIme;

    private ConfigurationDomain configurationDomain;
}
