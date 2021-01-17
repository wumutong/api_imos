package com.mfexcel.bigdata.openapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mfexcel.bigdata.openapi.domain.Operation;
import com.mfexcel.bigdata.openapi.domain.SendDetails;
import com.mfexcel.bigdata.openapi.domain.SendRecord;
import com.mfexcel.bigdata.openapi.vo.OperationVo;
import com.mfexcel.bigdata.openapi.vo.SendDetailsVo;
import com.mfexcel.bigdata.openapi.vo.SendRecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * Copyright (C),2020,xy
 *
 * @author wangbeibei
 */
@Mapper
public interface SendDetailsMapper extends BaseMapper<SendDetails> {

   /**
    *
    * 客户侧发送详情-分页查询  视频短信、5G消息、闪信、短信 共用接口
    *
    */
   IPage<SendDetailsVo> querySendDetailList(Page<SendDetails> page, @Param("send")SendDetailsVo param);

   /**
    *
    * 运营侧侧发送记录全部查询-分页查询 视频短信、5G消息、闪信 共用接口
    */
   IPage<SendRecordVo> querySentRecordlList(Page<SendRecord> page, @Param("SentRecord")SendRecordVo param);

   /**
    *
    *运营侧发送明细全部查询-分页查询 视频短信、5G消息、闪信、短信 共用接口
    */
   IPage<OperationVo> queryOperationSendingDetailsList(Page<Operation> page, @Param("SendingDetails") OperationVo param);
}
