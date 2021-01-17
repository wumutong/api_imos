package com.mfexcel.bigdata.openapi.mapper;

import com.mfexcel.bigdata.openapi.domain.MapperDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapperMapper {

    int getCount();

    List<MapperDomain> listMapper();

    MapperDomain selectMapper(long id);

    int insertMapper(MapperDomain mapperDomain);

    int updateMapper(MapperDomain mapperDomain);

    int deleteMapper(long id);

}
