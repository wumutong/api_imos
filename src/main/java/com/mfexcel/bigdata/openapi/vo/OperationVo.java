package com.mfexcel.bigdata.openapi.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Copyright (C),2020,xy
 * @author wangbeibei
 * @version 1.5
 */
@Data
public class OperationVo extends BaseVo{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息类型")
    private String msg_kind;

    /**开始时间*/
    @ApiModelProperty(value = "开始时间")
    private String date_end;

    /**结束时间*/
    @ApiModelProperty(value = "结束时间")
    private String date_start;


    /**企业id*/
    @ApiModelProperty(value = "企业id")
    private String enterpriseId;

    /**企业名称*/
    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    /**手机号 被叫号码*/
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private String messageTemplateName;

    /**供应商id*/
    @ApiModelProperty(value = "供应商")
    private String operator;

    /**供应商账号*/
    @ApiModelProperty(value = "供应商账号")
    private String supplierName;

    /**运营商*/
    @ApiModelProperty(value = "运营商")
    private String channel;

    /**供应商账号*/
    @ApiModelProperty(value = "供应商账号")
    private String appId;

    /**供应商账号名称*/
    @ApiModelProperty(value = "供应商账号名称")
    private String supplierAccountName;

    /**签名*/
    @ApiModelProperty(value = "签名")
    private String  messageSign;

    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private Date sentTime;

   /**回执时间*/
    @ApiModelProperty(value = "回执时间")
    private Date retTime;

    /**发送状态*/
    @ApiModelProperty(value = "发送状态")
    private String status;

    /**状态码  (闪信投递描述)*/

    @ApiModelProperty(value = "状态码")
    private String statusType;

    /**状态码说明*/
    @ApiModelProperty(value = "状态码说明")
    private String statusTypeExplain;

    /**5G消息 ID*/
    @ApiModelProperty(value = "5G消息 ID")
    private String messageSendAccountId;

    /**5G消息名称*/
    @ApiModelProperty(value = "5G消息名称")
    private String messageSendAccountName;

    /**短信内容*/
    @ApiModelProperty(value = "短信内容")
    private String messageTemplateContent;



    /**闪信参数 主叫号码*/
    @ApiModelProperty(value = "主叫号码")
    private String enterpriseNum;

    @ApiModelProperty(value = "动态参数")
    private String vars;










}
