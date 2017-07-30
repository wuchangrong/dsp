package com.handao.dsp.md.department.vo;

import java.sql.Date;

import com.handao.platform.framework.vo.AFValueObject;

public class DepartmentVO extends AFValueObject {

    /*************************************** field ***************************************/
    private long DEPT_COMPANY_ID;  //公司
    private Date DEPT_CURRENT_DATE;  //当前日期
    private Date DEPT_CURRENT_MONTH;  //当前月份
    private String DEPT_DEFAULT_UNIT;  //单位
    private String DEPT_DEPT_CODE;  //编码
    private String DEPT_DEPT_NAME;  //名称
    private String DEPT_IS_LOCATION;  //是否仓储地点
    private String DEPT_IS_VISITSALES;  //是否访销
    private String DEPT_IS_WAREHOUSE;  //是否仓库
    private long DEPT_PARENT_DEPT;  //上级部门
    private long DEPT_ROW_ID;  //ROW_ID:系统字段。
    private String DEPT_SHORT_CODE;  //助记码
    private String DEPT_STATUS;  //状态
    private long DEPT_CREATED_BY;
    private long DEPT_LAST_UPD_BY;
    private Date DEPT_CREATED_TIME;
    private Date DEPT_LAST_UPD_TIME;
    private int DEPT_MODIFICATION_NUM;
    private String DEPT_RESERVED1;
    private String DEPT_RESERVED2;
    private String DEPT_RESERVED3;

    private String DEPT_COMPANY_NAME;
    private String DEPT_PARENT_NAME;
    
    private String DEPT_STATUS_desc;
    
    private String DEPT_IS_SERVICE;

    public String getDEPT_STATUS_desc()
	{
		return DEPT_STATUS_desc;
	}

	public void setDEPT_STATUS_desc(String dept_status_desc)
	{
		DEPT_STATUS_desc = dept_status_desc;
	}

	public long getDEPT_CREATED_BY()
	{
		return DEPT_CREATED_BY;
	}

	public void setDEPT_CREATED_BY(long dept_created_by)
	{
		DEPT_CREATED_BY = dept_created_by;
	}

	public Date getDEPT_CREATED_TIME()
	{
		return DEPT_CREATED_TIME;
	}

	public void setDEPT_CREATED_TIME(Date dept_created_time)
	{
		DEPT_CREATED_TIME = dept_created_time;
	}

	public long getDEPT_LAST_UPD_BY()
	{
		return DEPT_LAST_UPD_BY;
	}

	public void setDEPT_LAST_UPD_BY(long dept_last_upd_by)
	{
		DEPT_LAST_UPD_BY = dept_last_upd_by;
	}

	public Date getDEPT_LAST_UPD_TIME()
	{
		return DEPT_LAST_UPD_TIME;
	}

	public void setDEPT_LAST_UPD_TIME(Date dept_last_upd_time)
	{
		DEPT_LAST_UPD_TIME = dept_last_upd_time;
	}

	public int getDEPT_MODIFICATION_NUM()
	{
		return DEPT_MODIFICATION_NUM;
	}

	public void setDEPT_MODIFICATION_NUM(int dept_modification_num)
	{
		DEPT_MODIFICATION_NUM = dept_modification_num;
	}

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

	public long getDEPT_COMPANY_ID() {
        return DEPT_COMPANY_ID;
    }

    public void setDEPT_COMPANY_ID(long DEPT_COMPANY_ID) {
        this.DEPT_COMPANY_ID = DEPT_COMPANY_ID;
    }

    public Date getDEPT_CURRENT_DATE() {
        return DEPT_CURRENT_DATE;
    }

    public void setDEPT_CURRENT_DATE(Date DEPT_CURRENT_DATE) {
        this.DEPT_CURRENT_DATE = DEPT_CURRENT_DATE;
    }

    public Date getDEPT_CURRENT_MONTH() {
        return DEPT_CURRENT_MONTH;
    }

    public void setDEPT_CURRENT_MONTH(Date DEPT_CURRENT_MONTH) {
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

    public long getDEPT_PARENT_DEPT() {
        return DEPT_PARENT_DEPT;
    }

    public void setDEPT_PARENT_DEPT(long DEPT_PARENT_DEPT) {
        this.DEPT_PARENT_DEPT = DEPT_PARENT_DEPT;
    }

    public long getDEPT_ROW_ID() {
        return DEPT_ROW_ID;
    }

    public void setDEPT_ROW_ID(long DEPT_ROW_ID) {
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
        this.DEPT_STATUS_desc = "1".equals(DEPT_STATUS)?"启用":"未启用";
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


}