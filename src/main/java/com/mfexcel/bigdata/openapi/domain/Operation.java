package com.mfexcel.bigdata.openapi.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C),2020,xy
 * @author wangbeibei
 * @version 1.5
 */
@Data
@TableName("运营侧发送明细")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="v_ads_user_sent_detailed_record_data", description="v_ads_user_sent_detailed_record_data")
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    /**企业id*/
    @ApiModelProperty(value = "企业id")
    private java.lang.String enterpriseId;

    /**企业名称*/
    @ApiModelProperty(value = "企业名称")
    private java.lang.String enterpriseName;

    /**手机号*/
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private String messageTemplateName;

    /**运营商*/
    @ApiModelProperty(value = "运营商")
    private String channel;

    /**供应商*/
    @ApiModelProperty(value = "供应商")
    private String operator;

    /**供应商账号*/
    @ApiModelProperty(value = "供应商账号")
    private String appId;

    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private java.util.Date sentTime;

    /**回执时间*/
    @ApiModelProperty(value = "回执时间")
    private Date retTime;

    /**发送状态*/
    @JsonProperty("statusType")
    @ApiModelProperty(value = "发送状态")
    private String status;

    /**状态码*/
    @JsonProperty("statusType")
    @ApiModelProperty(value = "状态码")
    private String statusType;

    /**状态码说明*/
    @JsonProperty("statusTypeExplain")
    @ApiModelProperty(value = "状态码说明")
    private String statusTypeExplain;

    /**5G消息名称*/
    @ApiModelProperty(value = "5G消息名称")
    private String messageSendAccountName;


    /**闪信参数 主叫号码*/
    @ApiModelProperty(value = "主叫号码")
    private String messag;

    /**闪信参数 被叫号码*/
    @ApiModelProperty(value = "被叫号码")
    private String mess;

    /**闪信参数 模板名称*/
    @ApiModelProperty(value = "模板名称")
    private String messageSee;


    /**
     * 闪信 投递描述
     */
    @ApiModelProperty(value = "投递描述")
    private String message;

    /**
     * 短信内容
     */
    @JsonProperty("smsContent")
    @ApiModelProperty(value = "短信内容")
    private String smsContent;



}
