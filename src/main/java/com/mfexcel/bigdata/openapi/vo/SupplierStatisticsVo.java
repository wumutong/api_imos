package com.mfexcel.bigdata.openapi.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SupplierStatisticsVo extends BaseVo{

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "消息类型")
    private String msgKind;

    /**开始时间*/
    @ApiModelProperty(value = "开始时间")
    private String dateEnd;

    /**结束时间*/
    @ApiModelProperty(value = "结束时间")
    private String dateStart;

    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private java.util.Date sentTime;

    /**发送批次号*/
    @ApiModelProperty(value = "发送批次号")
    private String batchNo;

    /**企业id*/
    @ApiModelProperty(value = "企业id")
    private String enterpriseId;

    /**企业名称*/
    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private String messageTemplateName;

    /**运营商*/
    @ApiModelProperty(value = "运营商")
    private String channel;

    /**供应商id*/
    @ApiModelProperty(value = "供应商")
    private String operator;

    /**供应商账号*/
    @ApiModelProperty(value = "供应商账号")
    private String supplierName;

    /**供应商账号*/
    @ApiModelProperty(value = "供应商账号")
    private String appId;

    /**供应商账号名称*/
    @ApiModelProperty(value = "供应商账号名称")
    private String supplierAccountName;

    /**签名*/
    @ApiModelProperty(value = "签名")
    private String  messageSign;

    @ApiModelProperty(value = "动态参数")
    private String vars;

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

    /**发送成功率*/
    @ApiModelProperty(value = "发送成功率")
    private Integer sendRadio;

    /**短信内容*/
    @ApiModelProperty(value = "短信内容")
    private String messageTemplateContent;


}
