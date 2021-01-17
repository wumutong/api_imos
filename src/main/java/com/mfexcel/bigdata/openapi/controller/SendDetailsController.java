package com.mfexcel.bigdata.openapi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mfexcel.bigdata.openapi.domain.Operation;
import com.mfexcel.bigdata.openapi.domain.SendDetails;
import com.mfexcel.bigdata.openapi.domain.SendRecord;
import com.mfexcel.bigdata.openapi.mapper.SendDetailsMapper;
import com.mfexcel.bigdata.openapi.utils.AjaxResult;
import com.mfexcel.bigdata.openapi.vo.OperationVo;
import com.mfexcel.bigdata.openapi.vo.SendDetailsVo;
import com.mfexcel.bigdata.openapi.vo.SendRecordVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C),2020,xy
 * @author wangbeibei
 * @version 1.5.0
 */

@Api(tags = "发送管理")
@Slf4j
@RestController
public class SendDetailsController {

    @Autowired
    private SendDetailsMapper   sendDetailsMapper;

    /**
     *
     * 客户侧发送详情-分页查询  视频短信、5G消息、闪信、短信 共用接口
     *
     */

   /* @ApiOperation(value = "客户侧发送详情-分页查询", notes = "客户侧发送详情-分页查询")
    @RequestMapping(value = "/customerSentDetail", method = RequestMethod.POST)
    public AjaxResult detail(@RequestBody SendDetailsVo param) {
        Integer pageNo = 1;
        Integer pageSize = 10;
        if (param.getPageNo() != null) {
            pageNo = param.getPageNo();
        }
        if (param.getPageSize() != null) {
            pageSize = param.getPageSize();
        }
        Page<SendDetails> page = new Page(pageNo, pageSize);
        IPage<SendDetailsVo> sendDetailsVoIPage = sendDetailsMapper.querySendDetailList(page,param);
        return AjaxResult.success(sendDetailsVoIPage);
    }*/

    /**
     *
     * 运营侧侧发送记录全部查询-分页查询 视频短信、5G消息、闪信 共用接口
     */
/*

    @ApiOperation(value = "运营侧发送详情-分页查询", notes = "运营侧发送详情-分页查询")
    @RequestMapping(value = "/yySentRecord", method = RequestMethod.POST)
    public AjaxResult sentRecord(@RequestBody SendRecordVo param) {
        Integer pageNo = 1;
        Integer pageSize = 10;
        if (param.getPageNo() != null) {
            pageNo = param.getPageNo();
        }
        if (param.getPageSize() != null) {
            pageSize = param.getPageSize();
        }
        Page<SendRecord> page = new Page(pageNo, pageSize);
        IPage<SendRecordVo> SendRecordVoIPage = sendDetailsMapper.querySentRecordlList(page,param);
        return AjaxResult.success(SendRecordVoIPage);
    }
*/


    /**
     *
     * 运营侧发送明细全部查询-分页查询 视频短信、5G消息、闪信、短信 共用接口
     */
 /*   @ApiOperation(value = "运营侧发送明细-分页查询", notes = "运营侧发送明细-分页查询")
    @RequestMapping(value = "/yySentDetail", method = RequestMethod.POST)
    public AjaxResult operationSendingDetails(@RequestBody OperationVo param) {
        Integer pageNo = 1;
        Integer pageSize = 10;
        if (param.getPageNo() != null) {
            pageNo = param.getPageNo();
        }
        if (param.getPageSize() != null) {
            pageSize = param.getPageSize();
        }
        Page<Operation> page = new Page(pageNo, pageSize);
        IPage<OperationVo> OperationVoVoIPage = sendDetailsMapper.queryOperationSendingDetailsList(page,param);
        return AjaxResult.success(OperationVoVoIPage);
    }*/



}
