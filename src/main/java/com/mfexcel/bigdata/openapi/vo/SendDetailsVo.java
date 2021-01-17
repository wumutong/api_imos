package com.mfexcel.bigdata.openapi.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "发送详情查询参数", description = "发送详情查询参数")
public class SendDetailsVo extends  BaseVo{

	@ApiModelProperty(value = "消息类型")
	private String msg_kind;

	@ApiModelProperty(value = "批次号")
	private String send_batch;

	@ApiModelProperty(value = "手机号")
	private String mobile;

	@JsonProperty("templateTitle")
	@ApiModelProperty(value = "消息名称")
	private String templateTitle;

	@ApiModelProperty(value = "动态参数")
	private String vars;

	/*发送结果*/
	@ApiModelProperty(value = "状态：0-未知；1-成功；2-失败；3-回落成功；4-转短成功；5-已撤回")
	private String status;

	@JsonProperty(value = "retTime")
	@ApiModelProperty(value = "回执时间")
	private Date retTime;

	@JsonProperty("retSign")
	@ApiModelProperty(value = "回执签名")
	private String retSign;

	@JsonProperty("statusTypeExplain")
	@ApiModelProperty(value = "状态码说明")
	private String statusTypeExplain;

	@ApiModelProperty(value = "状态码")
	private String status_type;

	@ApiModelProperty(value = "状态码")
	private String revoke_result;

	/**5G消息发送详情 */
	@JsonProperty("fallbackChannel")
	@ApiModelProperty(value = "撤回结果")
	private Integer fallbackChannel;

	/**闪信发送详情*/
	@JsonProperty("targetNumber")
	@ApiModelProperty(value = "被叫号码")
	private String targetNumber;

	/**闪信发送详情*/
	@ApiModelProperty(value = "投递描述")
	private String message;

	/**短信发送详情*/
	@ApiModelProperty(value = "短信内容")
	private String message_template_content;
}
