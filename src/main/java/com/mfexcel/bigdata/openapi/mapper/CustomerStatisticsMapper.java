package com.mfexcel.bigdata.openapi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mfexcel.bigdata.openapi.domain.CustomerStatistics;
import com.mfexcel.bigdata.openapi.domain.SupplierStatistics;
import com.mfexcel.bigdata.openapi.vo.CustomerStatisticsVo;
import com.mfexcel.bigdata.openapi.vo.SupplierStatisticsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CustomerStatisticsMapper extends BaseMapper<CustomerStatistics> {



    /**
     *
     * 运营侧客户统计全部查询-分页查询
     * 视频短信、闪信
     */
    IPage<CustomerStatisticsVo> queryCustomerStatisticsList(Page<CustomerStatistics> page, @Param("Customer")CustomerStatisticsVo customerStatisticsVo);


    /**
     *
     * 运营侧供应商统计全部查询-分页查询
     * 视频短信、短信
     */
   IPage<SupplierStatisticsVo> querySupplierStatisticsList(Page<SupplierStatistics> page, @Param("Statistics")SupplierStatisticsVo supplierStatisticsVo);

}
