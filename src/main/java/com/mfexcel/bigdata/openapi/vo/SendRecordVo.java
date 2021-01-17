package com.mfexcel.bigdata.openapi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Copyright (C),2020,xy
 *
 * @author wangbeibei
 * @version 1.5
 */
@Data
public class SendRecordVo extends BaseVo{

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "消息类型")
    private String msg_kind;

    /**开始时间*/
    @ApiModelProperty(value = "开始时间")
    private String date_end;

    /**结束时间*/
    @ApiModelProperty(value = "结束时间")
    private String date_start;

    /**消息ID*/
    @ApiModelProperty(value = "消息ID")
    private String messageId;

    /**企业id*/
    @ApiModelProperty(value = "企业id")
    private String enterpriseId;

    /**企业名称*/
    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    /**发送批次号*/
    @ApiModelProperty(value = "发送批次号")
    private String batchNo;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private String messageTemplateName;


    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private java.util.Date sentTime;

    /**发送条数*/
    @ApiModelProperty(value = "发送消息数")
    private Integer sentCnt;

    /**发送成功条数*/
    @ApiModelProperty(value = "到达终端消息数")
    private Integer deliveredTerminalCnt;

    /**发送失败消息数*/
    @ApiModelProperty(value = "发送失败消息数")
    private Integer deliveryImpossibleCnt;

    /**未知条数*/
    @ApiModelProperty(value = "未知条数")
    private Integer sendUnknown;



    /**未知*/
    @ApiModelProperty(value = "未知")
    private String message_template_content;

    /**已阅条数*/
    @ApiModelProperty(value = "已阅条数")
    private String messageDisplayedCnt;

    /**5G消息 ID*/
    @ApiModelProperty(value = "5G消息 ID")
    private String messageSendAccountId;

    /**5G消息名称*/
    @ApiModelProperty(value = "5G消息名称")
    private String messageSendAccountName;


}
