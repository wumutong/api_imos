package com.mfexcel.bigdata.openapi.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: imos
 * @description: 通用属性
 */
@Data
public class BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;
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
