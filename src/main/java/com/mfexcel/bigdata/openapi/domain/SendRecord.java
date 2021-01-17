package com.mfexcel.bigdata.openapi.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * Copyright (C),2020,xy
 *
 * @author wangbeibei
 * @version 1.5
 */
@Data
@TableName("运营侧发送详情")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="dm_sent_record_all_data_d对象", description="dm_sent_record_all_data_d")
public class SendRecord implements Serializable {

    private static final long serialVersionUID = 1L;


    /**消息ID*/
    @ApiModelProperty(value = "消息ID")
    private java.lang.String messageId;

    /**企业id*/
    @ApiModelProperty(value = "企业id")
    private java.lang.String enterpriseId;

    /**企业名称*/
    @ApiModelProperty(value = "企业名称")
    private java.lang.String enterpriseName;

    /**发送批次号*/
    @ApiModelProperty(value = "发送批次号")
    private java.lang.String batchNo;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private java.lang.String messageTemplateName;


    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private java.util.Date sentTime;

    /**发送条数*/
    @ApiModelProperty(value = "发送消息数")
    private java.lang.Integer sentCnt;

    /**发送成功条数*/
    @ApiModelProperty(value = "到达终端消息数")
    private java.lang.Integer deliveredTerminalCnt;

    /**发送失败消息数*/
    @ApiModelProperty(value = "发送失败消息数")
    private java.lang.Integer deliveryImpossibleCnt;

    /**未知条数*/
    @ApiModelProperty(value = "未知条数")
    private java.lang.Integer sendUnknown;







}
