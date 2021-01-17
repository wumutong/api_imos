package com.mfexcel.bigdata.openapi.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@TableName("运营侧客户统计")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="v_ads_customer_count_data", description="v_ads_customer_count_data")
public class CustomerStatistics {

    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private java.util.Date sentTime;

    /**发送批次号*/
    @ApiModelProperty(value = "发送批次号")
    private java.lang.String batchNo;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private java.lang.String messageTemplateName;


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


    /**计费条数*/
    @ApiModelProperty(value = "计费条数")
    private java.lang.Integer sendBilling;


    /**发送成功率*/
    @ApiModelProperty(value = "发送成功率")
    private java.lang.Integer sendRadio;

}
