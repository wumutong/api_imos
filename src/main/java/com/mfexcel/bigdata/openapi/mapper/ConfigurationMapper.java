package com.mfexcel.bigdata.openapi.mapper;

import com.mfexcel.bigdata.openapi.domain.ConfigurationDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConfigurationMapper {

    int getCount();

    List<ConfigurationDomain> listConfiguration();

    ConfigurationDomain selectConfiguration(long id);

    int insertConfiguration(ConfigurationDomain configurationDomain);

    int updateConfiguration(ConfigurationDomain configurationDomain);

    int deleteConfiguration(long id);

}
