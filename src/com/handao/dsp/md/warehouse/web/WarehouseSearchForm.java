package com.handao.dsp.md.warehouse.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

public class WarehouseSearchForm extends AFSearchForm {

	private String WH_WH_CODE;  //编码
    private String WH_WH_NAME;  //名称
    private String WH_COMPANY_ID;  //公司ID
    private String WH_LOCATION_ID;  //仓储地点
    private String WH_ADDRESS;  //地址
    private String WH_ACREAGE;  //面积(平方米)
    private String WH_MAX_CAPACITY;  //容量(箱)
    private String WH_REMARKS;  //备注
    private String CP_COMPANY_NAME;  //名称
    private String LT_LOCATION_NAME;  //仓库地点

    public String getWH_WH_CODE() {
        return WH_WH_CODE;
    }

    public void setWH_WH_CODE(String WH_WH_CODE) {
        this.WH_WH_CODE = WH_WH_CODE;
    }

    public String getWH_WH_NAME() {
        return WH_WH_NAME;
    }

    public void setWH_WH_NAME(String WH_WH_NAME) {
        this.WH_WH_NAME = WH_WH_NAME;
    }

    public String getWH_COMPANY_ID() {
        return WH_COMPANY_ID;
    }

    public void setWH_COMPANY_ID(String WH_COMPANY_ID) {
        this.WH_COMPANY_ID = WH_COMPANY_ID;
    }

    public String getWH_LOCATION_ID() {
        return WH_LOCATION_ID;
    }

    public void setWH_LOCATION_ID(String WH_LOCATION_ID) {
        this.WH_LOCATION_ID = WH_LOCATION_ID;
    }

    public String getWH_ADDRESS() {
        return WH_ADDRESS;
    }

    public void setWH_ADDRESS(String WH_ADDRESS) {
        this.WH_ADDRESS = WH_ADDRESS;
    }

    public String getWH_ACREAGE() {
        return WH_ACREAGE;
    }

    public void setWH_ACREAGE(String WH_ACREAGE) {
        this.WH_ACREAGE = WH_ACREAGE;
    }

    public String getWH_MAX_CAPACITY() {
        return WH_MAX_CAPACITY;
    }

    public void setWH_MAX_CAPACITY(String WH_MAX_CAPACITY) {
        this.WH_MAX_CAPACITY = WH_MAX_CAPACITY;
    }

    public String getWH_REMARKS() {
        return WH_REMARKS;
    }

    public void setWH_REMARKS(String WH_REMARKS) {
        this.WH_REMARKS = WH_REMARKS;
    }

    public String getCP_COMPANY_NAME() {
        return CP_COMPANY_NAME;
    }

    public void setCP_COMPANY_NAME(String CP_COMPANY_NAME) {
        this.CP_COMPANY_NAME = CP_COMPANY_NAME;
    }

    public String getLT_LOCATION_NAME() {
        return LT_LOCATION_NAME;
    }

    public void setLT_LOCATION_NAME(String LT_LOCATION_NAME) {
        this.LT_LOCATION_NAME = LT_LOCATION_NAME;
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
        cc.put("WH_WH_CODE", WH_WH_CODE);
        cc.put("WH_WH_NAME", WH_WH_NAME);
        cc.put("WH_COMPANY_ID", AFDataFormat.toInt(WH_COMPANY_ID));
        cc.put("WH_LOCATION_ID", AFDataFormat.toInt(WH_LOCATION_ID));
        cc.put("WH_ADDRESS", WH_ADDRESS);
        cc.put("WH_ACREAGE", AFDataFormat.toDouble(WH_ACREAGE));
        cc.put("WH_MAX_CAPACITY", AFDataFormat.toDouble(WH_MAX_CAPACITY));
        cc.put("WH_REMARKS", WH_REMARKS);
        cc.put("CP_COMPANY_NAME", CP_COMPANY_NAME);
        cc.put("LT_LOCATION_NAME", LT_LOCATION_NAME);
        return cc;
    }


}