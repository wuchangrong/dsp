package com.handao.dsp.md.department.web;

import com.handao.dsp.md.department.vo.DepartmentVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class DepartmentForm extends AFForm implements AFSearchOperation {

    /*************************************** field ***************************************/
    private String DEPT_COMPANY_ID;  //公司
    private String DEPT_CURRENT_DATE;  //当前日期
    private String DEPT_CURRENT_MONTH;  //当前月份
    private String DEPT_DEFAULT_UNIT;  //单位
    private String DEPT_DEPT_CODE;  //编码
    private String DEPT_DEPT_NAME;  //名称
    private String DEPT_IS_LOCATION;  //是否仓储地点
    private String DEPT_IS_VISITSALES;  //是否访销
    private String DEPT_IS_WAREHOUSE;  //是否仓库
    private String DEPT_PARENT_DEPT;  //上级部门
    private String DEPT_ROW_ID;  //ROW_ID:系统字段。
    private String DEPT_SHORT_CODE;  //助记码
    private String DEPT_STATUS;  //状态
    private String DEPT_RESERVED1;  //
    private String DEPT_RESERVED2;  //
    private String DEPT_RESERVED3;  //
    
    private String DEPT_COMPANY_NAME;
    private String DEPT_PARENT_NAME;
    
    private String DEPT_STATUS_desc;
    private String DEPT_IS_LOCATION_desc;  //是否仓储地点
    private String DEPT_IS_VISITSALES_desc;  //是否访销
    private String DEPT_IS_WAREHOUSE_desc;  //是否仓库
    
    private String DEPT_IS_SERVICE;
    private String DEPT_IS_SERVICE_desc;

    public String getDEPT_RESERVED1()
	{
		return DEPT_RESERVED1;
	}

	public void setDEPT_RESERVED1(String dept_reserved1)
	{
		DEPT_RESERVED1 = dept_reserved1;
	}

	public String getDEPT_RESERVED2()
	{
		return DEPT_RESERVED2;
	}

	public void setDEPT_RESERVED2(String dept_reserved2)
	{
		DEPT_RESERVED2 = dept_reserved2;
	}

	public String getDEPT_RESERVED3()
	{
		return DEPT_RESERVED3;
	}

	public void setDEPT_RESERVED3(String dept_reserved3)
	{
		DEPT_RESERVED3 = dept_reserved3;
	}

	public String getDEPT_STATUS_desc()
	{
		return DEPT_STATUS_desc;
	}

	public void setDEPT_STATUS_desc(String dept_status_desc)
	{
		DEPT_STATUS_desc = dept_status_desc;
	}

	public String getDEPT_COMPANY_ID() {
        return DEPT_COMPANY_ID;
    }

    public void setDEPT_COMPANY_ID(String DEPT_COMPANY_ID) {
        this.DEPT_COMPANY_ID = DEPT_COMPANY_ID;
    }

    public String getDEPT_CURRENT_DATE() {
        return DEPT_CURRENT_DATE;
    }

    public void setDEPT_CURRENT_DATE(String DEPT_CURRENT_DATE) {
        this.DEPT_CURRENT_DATE = DEPT_CURRENT_DATE;
    }

    public String getDEPT_CURRENT_MONTH() {
        return DEPT_CURRENT_MONTH;
    }

    public void setDEPT_CURRENT_MONTH(String DEPT_CURRENT_MONTH) {
        this.DEPT_CURRENT_MONTH = DEPT_CURRENT_MONTH;
    }

    public String getDEPT_DEFAULT_UNIT() {
        return DEPT_DEFAULT_UNIT;
    }

    public void setDEPT_DEFAULT_UNIT(String DEPT_DEFAULT_UNIT) {
        this.DEPT_DEFAULT_UNIT = DEPT_DEFAULT_UNIT;
    }

    public String getDEPT_DEPT_CODE() {
        return DEPT_DEPT_CODE;
    }

    public void setDEPT_DEPT_CODE(String DEPT_DEPT_CODE) {
        this.DEPT_DEPT_CODE = DEPT_DEPT_CODE;
    }

    public String getDEPT_DEPT_NAME() {
        return DEPT_DEPT_NAME;
    }

    public void setDEPT_DEPT_NAME(String DEPT_DEPT_NAME) {
        this.DEPT_DEPT_NAME = DEPT_DEPT_NAME;
    }

    public String getDEPT_IS_LOCATION() {
        return DEPT_IS_LOCATION;
    }

    public void setDEPT_IS_LOCATION(String DEPT_IS_LOCATION) {
        this.DEPT_IS_LOCATION = DEPT_IS_LOCATION;
    }

    public String getDEPT_IS_VISITSALES() {
        return DEPT_IS_VISITSALES;
    }

    public void setDEPT_IS_VISITSALES(String DEPT_IS_VISITSALES) {
        this.DEPT_IS_VISITSALES = DEPT_IS_VISITSALES;
    }

    public String getDEPT_IS_WAREHOUSE() {
        return DEPT_IS_WAREHOUSE;
    }

    public void setDEPT_IS_WAREHOUSE(String DEPT_IS_WAREHOUSE) {
        this.DEPT_IS_WAREHOUSE = DEPT_IS_WAREHOUSE;
    }

    public String getDEPT_PARENT_DEPT() {
        return DEPT_PARENT_DEPT;
    }

    public void setDEPT_PARENT_DEPT(String DEPT_PARENT_DEPT) {
        this.DEPT_PARENT_DEPT = DEPT_PARENT_DEPT;
    }

    public String getDEPT_ROW_ID() {
        return DEPT_ROW_ID;
    }

    public void setDEPT_ROW_ID(String DEPT_ROW_ID) {
        this.DEPT_ROW_ID = DEPT_ROW_ID;
    }

    public String getDEPT_SHORT_CODE() {
        return DEPT_SHORT_CODE;
    }

    public void setDEPT_SHORT_CODE(String DEPT_SHORT_CODE) {
        this.DEPT_SHORT_CODE = DEPT_SHORT_CODE;
    }

    public String getDEPT_STATUS() {
        return DEPT_STATUS;
    }

    public void setDEPT_STATUS(String DEPT_STATUS) {
        this.DEPT_STATUS = DEPT_STATUS;
    }

	



    /*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "WMS_BASE_DEPARTMENT_DepartmentForm";
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
        DepartmentVO vo = new DepartmentVO();
        vo.setDEPT_COMPANY_ID(AFDataFormat.parseString(DEPT_COMPANY_ID, vo.getDEPT_COMPANY_ID()));
        vo.setDEPT_CURRENT_DATE(AFDataFormat.parseString(DEPT_CURRENT_DATE, vo.getDEPT_CURRENT_DATE()));
        vo.setDEPT_CURRENT_MONTH(AFDataFormat.parseString(DEPT_CURRENT_MONTH, vo.getDEPT_CURRENT_MONTH()));
        vo.setDEPT_DEFAULT_UNIT(AFDataFormat.parseString(DEPT_DEFAULT_UNIT, vo.getDEPT_DEFAULT_UNIT()));
        vo.setDEPT_DEPT_CODE(AFDataFormat.parseString(DEPT_DEPT_CODE, vo.getDEPT_DEPT_CODE()));
        vo.setDEPT_DEPT_NAME(AFDataFormat.parseString(DEPT_DEPT_NAME, vo.getDEPT_DEPT_NAME()));
        vo.setDEPT_IS_LOCATION(AFDataFormat.parseString(DEPT_IS_LOCATION, vo.getDEPT_IS_LOCATION()));
        vo.setDEPT_IS_VISITSALES(AFDataFormat.parseString(DEPT_IS_VISITSALES, vo.getDEPT_IS_VISITSALES()));
        vo.setDEPT_IS_WAREHOUSE(AFDataFormat.parseString(DEPT_IS_WAREHOUSE, vo.getDEPT_IS_WAREHOUSE()));
        vo.setDEPT_PARENT_DEPT(AFDataFormat.parseString(DEPT_PARENT_DEPT, vo.getDEPT_PARENT_DEPT()));
        vo.setDEPT_ROW_ID(AFDataFormat.parseString(DEPT_ROW_ID, vo.getDEPT_ROW_ID()));
        vo.setDEPT_SHORT_CODE(AFDataFormat.parseString(DEPT_SHORT_CODE, vo.getDEPT_SHORT_CODE()));
        vo.setDEPT_STATUS(AFDataFormat.parseString(DEPT_STATUS, vo.getDEPT_STATUS()));

        vo.setDEPT_RESERVED1("N");
        vo.setDEPT_RESERVED2("N");
        vo.setDEPT_RESERVED3("N");
        
        vo.setDEPT_IS_SERVICE(AFDataFormat.parseString(DEPT_IS_SERVICE, vo.getDEPT_IS_SERVICE()));

        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        DepartmentVO vo = (DepartmentVO)_vo;
        DEPT_COMPANY_ID = AFDataFormat.toString(vo.getDEPT_COMPANY_ID());
        DEPT_CURRENT_DATE = AFDataFormat.toString(vo.getDEPT_CURRENT_DATE());
        DEPT_CURRENT_MONTH = AFDataFormat.toString(vo.getDEPT_CURRENT_MONTH());
        DEPT_DEFAULT_UNIT = AFDataFormat.toString(vo.getDEPT_DEFAULT_UNIT());
        DEPT_DEPT_CODE = AFDataFormat.toString(vo.getDEPT_DEPT_CODE());
        DEPT_DEPT_NAME = AFDataFormat.toString(vo.getDEPT_DEPT_NAME());
        DEPT_IS_LOCATION = AFDataFormat.toString(vo.getDEPT_IS_LOCATION());
        DEPT_IS_VISITSALES = AFDataFormat.toString(vo.getDEPT_IS_VISITSALES());
        DEPT_IS_WAREHOUSE = AFDataFormat.toString(vo.getDEPT_IS_WAREHOUSE());
        DEPT_PARENT_DEPT = AFDataFormat.toString(vo.getDEPT_PARENT_DEPT());
        DEPT_ROW_ID = AFDataFormat.toString(vo.getDEPT_ROW_ID());
        DEPT_SHORT_CODE = AFDataFormat.toString(vo.getDEPT_SHORT_CODE());
        DEPT_STATUS = AFDataFormat.toString(vo.getDEPT_STATUS());
        
        DEPT_COMPANY_NAME = AFDataFormat.toString(vo.getDEPT_COMPANY_NAME());
        DEPT_PARENT_NAME = AFDataFormat.toString(vo.getDEPT_PARENT_NAME());
        
        DEPT_STATUS_desc = "1".equals(DEPT_STATUS)?"启用":"未启用";
        DEPT_IS_LOCATION_desc = "Y".equals(DEPT_IS_LOCATION)?"是":"否";
        DEPT_IS_VISITSALES_desc = "Y".equals(DEPT_IS_VISITSALES)?"是":"否";
        DEPT_IS_WAREHOUSE_desc = "Y".equals(DEPT_IS_WAREHOUSE)?"是":"否";
        
        DEPT_IS_SERVICE = AFDataFormat.toString(vo.getDEPT_IS_SERVICE());
        DEPT_IS_SERVICE_desc = "Y".equals(DEPT_IS_SERVICE)?"是":"否";
    }

    /**
     * [父类抽象方法实现]
     * 初始化表单数据
     */
    public void initialize() {
        DEPT_COMPANY_ID = "";
        DEPT_CURRENT_DATE = "";
        DEPT_CURRENT_MONTH = "";
        DEPT_DEFAULT_UNIT = "";
        DEPT_DEPT_CODE = "";
        DEPT_DEPT_NAME = "";
        DEPT_IS_LOCATION = "";
        DEPT_IS_VISITSALES = "";
        DEPT_IS_WAREHOUSE = "";
        DEPT_PARENT_DEPT = "";
        DEPT_ROW_ID = "";
        DEPT_SHORT_CODE = "";
        DEPT_STATUS = "";
        DEPT_STATUS_desc = "";
        DEPT_IS_SERVICE ="";

    }

    /*************************************** customer ***************************************/
    private DepartmentSearchForm searchForm = new DepartmentSearchForm();

	public String getDEPT_IS_LOCATION_desc()
	{
		return DEPT_IS_LOCATION_desc;
	}

	public void setDEPT_IS_LOCATION_desc(String dept_is_location_desc)
	{
		DEPT_IS_LOCATION_desc = dept_is_location_desc;
	}

	public String getDEPT_IS_VISITSALES_desc()
	{
		return DEPT_IS_VISITSALES_desc;
	}

	public void setDEPT_IS_VISITSALES_desc(String dept_is_visitsales_desc)
	{
		DEPT_IS_VISITSALES_desc = dept_is_visitsales_desc;
	}

	public String getDEPT_IS_WAREHOUSE_desc()
	{
		return DEPT_IS_WAREHOUSE_desc;
	}

	public void setDEPT_IS_WAREHOUSE_desc(String dept_is_warehouse_desc)
	{
		DEPT_IS_WAREHOUSE_desc = dept_is_warehouse_desc;
	}

	public String getDEPT_COMPANY_NAME()
	{
		return DEPT_COMPANY_NAME;
	}

	public void setDEPT_COMPANY_NAME(String dept_company_name)
	{
		DEPT_COMPANY_NAME = dept_company_name;
	}

	public String getDEPT_PARENT_NAME()
	{
		return DEPT_PARENT_NAME;
	}

	public void setDEPT_PARENT_NAME(String dept_parent_name)
	{
		DEPT_PARENT_NAME = dept_parent_name;
	}

	public String getDEPT_IS_SERVICE() {
		return DEPT_IS_SERVICE;
	}

	public void setDEPT_IS_SERVICE(String dept_is_service) {
		DEPT_IS_SERVICE = dept_is_service;
	}

	public String getDEPT_IS_SERVICE_desc() {
		return DEPT_IS_SERVICE_desc;
	}

	public void setDEPT_IS_SERVICE_desc(String dept_is_service_desc) {
		DEPT_IS_SERVICE_desc = dept_is_service_desc;
	}

	public void initSearchForm() {
        DEPT_COMPANY_ID = "";
        DEPT_CURRENT_DATE = "";
        DEPT_CURRENT_MONTH = "";
        DEPT_DEFAULT_UNIT = "";
        DEPT_DEPT_CODE = "";
        DEPT_DEPT_NAME = "";
        DEPT_IS_LOCATION = "";
        DEPT_IS_VISITSALES = "";
        DEPT_IS_WAREHOUSE = "";
        DEPT_PARENT_DEPT = "";
        DEPT_ROW_ID = "";
        DEPT_SHORT_CODE = "";
        DEPT_STATUS = "";
        DEPT_STATUS_desc = "";
        DEPT_IS_SERVICE ="";		
	}

	
}