package com.mfexcel.bigdata.openapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mfexcel.bigdata.openapi.domain.CustomerStatistics;
import com.mfexcel.bigdata.openapi.domain.SupplierStatistics;
import com.mfexcel.bigdata.openapi.mapper.CustomerStatisticsMapper;
import com.mfexcel.bigdata.openapi.utils.AjaxResult;
import com.mfexcel.bigdata.openapi.vo.CustomerStatisticsVo;
import com.mfexcel.bigdata.openapi.vo.SupplierStatisticsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "运营侧-统计分析")
@Slf4j
@RestController
public class CustomerStatisticsController {


    @Autowired
    private CustomerStatisticsMapper customerStatisticsMapper;

    /**
     *
     * 运营侧客户统计全部查询-分页查询
     * 视频短信、闪信
     */
/*    @ApiOperation(value = "运营侧客户统计-分页查询", notes = "运营侧客户统计-分页查询")
    @RequestMapping(value = "/yyCustomerCount", method = RequestMethod.POST)
    public AjaxResult operationSendingDetails(@RequestBody CustomerStatisticsVo customerStatisticsVo) {
        Integer pageNo = 1;
        Integer pageSize = 10;
        if (customerStatisticsVo.getPageNo() != null) {
            pageNo = customerStatisticsVo.getPageNo();
        }
        if (customerStatisticsVo.getPageSize() != null) {
            pageSize = customerStatisticsVo.getPageSize();
        }
        Page<CustomerStatistics> page = new Page(pageNo, pageSize);
        IPage<CustomerStatisticsVo> CustomerStatisticsVoIPage = customerStatisticsMapper.queryCustomerStatisticsList(page,customerStatisticsVo);
        return AjaxResult.success(CustomerStatisticsVoIPage);
    }*/

    /**
     *
     * 运营侧供应商统计全部查询-分页查询
     * 视频短信、短信
     */
   /* @ApiOperation(value = "运营侧供应商统计-分页查询", notes = "运营侧供应商统计-分页查询")
    @RequestMapping(value = "/yySupplierCount", method = RequestMethod.POST)
    public AjaxResult supplierStatistics(@RequestBody SupplierStatisticsVo supplierStatisticsVo){
        Integer pageNo = 1;
        Integer pageSize = 10;
        if (supplierStatisticsVo.getPageNo() != null) {
            pageNo = supplierStatisticsVo.getPageNo();
        }
        if (supplierStatisticsVo.getPageSize() != null) {
            pageSize = supplierStatisticsVo.getPageSize();
        }
        Page<SupplierStatistics> page = new Page(pageNo, pageSize);
        IPage<SupplierStatisticsVo> supplierStatisticsVoIPage= customerStatisticsMapper.querySupplierStatisticsList(page,supplierStatisticsVo);
        return AjaxResult.success(supplierStatisticsVoIPage);
    }*/



}
