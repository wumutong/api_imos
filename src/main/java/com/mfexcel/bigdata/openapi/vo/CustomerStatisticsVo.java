package com.mfexcel.bigdata.openapi.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CustomerStatisticsVo extends BaseVo{

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "消息类型")
    private String msgKind;

    /**开始时间*/
    @ApiModelProperty(value = "开始时间")
    private String dateEnd;

    /**结束时间*/
    @ApiModelProperty(value = "结束时间")
    private String dateStart;


    /**企业id*/
    @ApiModelProperty(value = "企业id")
    private String enterpriseId;



    /**发送时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发送时间")
    private java.util.Date sentTime;

    /**发送批次号*/
    @ApiModelProperty(value = "发送批次号")
    private String batchNo;

    /**消息模板名称*/
    @ApiModelProperty(value = "消息模板名称")
    private String messageTemplateName;


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


    /**计费条数*/
    @ApiModelProperty(value = "计费条数")
    private Integer sendBilling;


    /**发送成功率*/
    @ApiModelProperty(value = "发送成功率")
    private Integer sendRadio;


    /**短信内容*/
    @ApiModelProperty(value = "短信内容")
    private String messageTemplateContent;

    /**
     * 当前页面
     */
    @TableField(exist = false)
    private Integer pageNo;
    /**
     * 每页数量
     */
    @TableField(exist = false)
    private Integer pageSize;
}
