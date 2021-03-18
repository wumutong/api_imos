package com.mfexcel.bigdata.openapi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BaseMapper {
    //查询方法
    List<Map<String, Object>> execute(Map<String, Object> paramMap);
    //插入方法
    int insertExecute(Map<String, Object> paramMap);
    //更新方法
    int updateExecute(Map<String, Object> paramMap);
    //删除方法
    int deleteExecute(Map<String, Object> paramMap);
}
