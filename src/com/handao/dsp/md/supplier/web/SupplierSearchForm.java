package com.handao.dsp.md.supplier.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

public class SupplierSearchForm extends AFSearchForm {

    private String SUP_DISTRICTID;  //地区标识
    private String SUP_PROVINCEID;  //省份标识

    public String getSUP_DISTRICTID() {
        return SUP_DISTRICTID;
    }

    public void setSUP_DISTRICTID(String SUP_DISTRICTID) {
        this.SUP_DISTRICTID = SUP_DISTRICTID;
    }

    public String getSUP_PROVINCEID() {
        return SUP_PROVINCEID;
    }

    public void setSUP_PROVINCEID(String SUP_PROVINCEID) {
        this.SUP_PROVINCEID = SUP_PROVINCEID;
    }


    /**
     * [父类抽象方法实现]
     * 把自定义查询条件封装成AFSearchCustomerCondition，并返回
     * 注意 1：需要将查询字段转化为强类型
     * 注意 2：建议使用AFDataFormat类进行数据类型转换
     * @return AFSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("SUP_DISTRICTID", AFDataFormat.toInt(SUP_DISTRICTID));
        cc.put("SUP_PROVINCEID", AFDataFormat.toInt(SUP_PROVINCEID));
        return cc;
    }


}