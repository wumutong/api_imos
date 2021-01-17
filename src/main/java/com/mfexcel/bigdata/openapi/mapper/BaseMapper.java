package com.mfexcel.bigdata.openapi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BaseMapper {
    List<Map<String, Object>> execute(Map<String, Object> paramMap);
}
