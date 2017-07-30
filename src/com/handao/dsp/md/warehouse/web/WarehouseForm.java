package com.handao.dsp.md.warehouse.web;

import com.handao.dsp.md.warehouse.vo.WarehouseVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class WarehouseForm extends AFForm implements AFSearchOperation {

    private String WH_WH_CODE;  //编码
    private String WH_WH_NAME;  //名称
    private String WH_COMPANY_ID;  //公司ID
    private String WH_LOCATION_ID;  //仓储地点
    
    private String WH_ADDRESS;  //地址
    private String WH_ACREAGE;  //面积(平方米)
    private String WH_MAX_CAPACITY;  //容量(箱)
    private String WH_REMARKS;  //备注
    private String WH_ROW_ID;  //ROW_ID:系统字段。
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

    public String getWH_ROW_ID() {
        return WH_ROW_ID;
    }

    public void setWH_ROW_ID(String WH_ROW_ID) {
        this.WH_ROW_ID = WH_ROW_ID;
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

	



    /*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "WMS_BASE_WAREHOUSE_WarehouseForm";
    }

    /**
     * [接口方法实现]
     * 返回查询表单
     * @return AFSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }

    /**
     * [父类抽象方法实现]
     * 根据当前表单生成对应数据对象(VO)
     * 建议使用AFDataFormat.parseString()进行类型转换
     * @return AFValueObject
     */
    public AFValueObject transform() {
        WarehouseVO vo = new WarehouseVO();
        vo.setWH_WH_CODE(AFDataFormat.parseString(WH_WH_CODE, vo.getWH_WH_CODE()));
        vo.setWH_WH_NAME(AFDataFormat.parseString(WH_WH_NAME, vo.getWH_WH_NAME()));
        vo.setWH_COMPANY_ID(AFDataFormat.parseString(WH_COMPANY_ID, vo.getWH_COMPANY_ID()));
        vo.setWH_LOCATION_ID(AFDataFormat.parseString(WH_LOCATION_ID, vo.getWH_LOCATION_ID()));
        vo.setWH_ADDRESS(AFDataFormat.parseString(WH_ADDRESS, vo.getWH_ADDRESS()));
        vo.setWH_ACREAGE(AFDataFormat.parseString(WH_ACREAGE, vo.getWH_ACREAGE()));
        vo.setWH_MAX_CAPACITY(AFDataFormat.parseString(WH_MAX_CAPACITY, vo.getWH_MAX_CAPACITY()));
        vo.setWH_REMARKS(AFDataFormat.parseString(WH_REMARKS, vo.getWH_REMARKS()));
        vo.setWH_ROW_ID(AFDataFormat.parseString(WH_ROW_ID, vo.getWH_ROW_ID()));
        vo.setCP_COMPANY_NAME(AFDataFormat.parseString(CP_COMPANY_NAME, vo.getCP_COMPANY_NAME()));
        vo.setLT_LOCATION_NAME(AFDataFormat.parseString(LT_LOCATION_NAME, vo.getLT_LOCATION_NAME()));

        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        WarehouseVO vo = (WarehouseVO)_vo;
        WH_WH_CODE = AFDataFormat.toString(vo.getWH_WH_CODE());
        WH_WH_NAME = AFDataFormat.toString(vo.getWH_WH_NAME());
        WH_COMPANY_ID = AFDataFormat.toString(vo.getWH_COMPANY_ID());
        WH_LOCATION_ID = AFDataFormat.toString(vo.getWH_LOCATION_ID());
        WH_ADDRESS = AFDataFormat.toString(vo.getWH_ADDRESS());
        WH_ACREAGE = AFDataFormat.toString(vo.getWH_ACREAGE());
        WH_MAX_CAPACITY = AFDataFormat.toString(vo.getWH_MAX_CAPACITY());
        WH_REMARKS = AFDataFormat.toString(vo.getWH_REMARKS());
        WH_ROW_ID = AFDataFormat.toString(vo.getWH_ROW_ID());
        CP_COMPANY_NAME = AFDataFormat.toString(vo.getCP_COMPANY_NAME());
        LT_LOCATION_NAME = AFDataFormat.toString(vo.getLT_LOCATION_NAME());

    }

    /**
     * [父类抽象方法实现]
     * 初始化表单数据
     */
    public void initialize() {
        WH_WH_CODE = "";
        WH_WH_NAME = "";
        WH_COMPANY_ID = "";
        WH_LOCATION_ID = "";
        WH_ADDRESS = "";
        WH_ACREAGE = "";
        WH_MAX_CAPACITY = "";
        WH_REMARKS = "";
        WH_ROW_ID = "";
        CP_COMPANY_NAME = "";
        LT_LOCATION_NAME = "";

    }

    /*************************************** customer ***************************************/
    private WarehouseSearchForm searchForm = new WarehouseSearchForm();

	public void initSearchForm() {
        WH_WH_CODE = "";
        WH_WH_NAME = "";
        WH_COMPANY_ID = "";
        WH_LOCATION_ID = "";
        WH_ADDRESS = "";
        WH_ACREAGE = "";
        WH_MAX_CAPACITY = "";
        WH_REMARKS = "";
        WH_ROW_ID = "";
        CP_COMPANY_NAME = "";
        LT_LOCATION_NAME = "";
		
	}


}