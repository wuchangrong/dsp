package com.handao.dsp.md.warehouse.vo;


import com.handao.platform.framework.vo.AFValueObject;

public class WarehouseVO extends AFValueObject {

    private String WH_WH_CODE;  //����
    private String WH_WH_NAME;  //����
    private long WH_COMPANY_ID;  //��˾ID
    private long WH_LOCATION_ID;  //�ִ��ص�
    private String WH_ADDRESS;  //��ַ
    private double WH_ACREAGE;  //���(ƽ����)
    private double WH_MAX_CAPACITY;  //����(��)
    private String WH_REMARKS;  //��ע
    private long WH_ROW_ID;  //ROW_ID:ϵͳ�ֶΡ�
    private String CP_COMPANY_NAME;  //����
    private String LT_LOCATION_NAME;  //�ֿ�ص�
    private long CREATED_BY;
    private long LAST_UPD_BY;
    

    public long getCREATED_BY()
	{
		return CREATED_BY;
	}

	public void setCREATED_BY(long created_by)
	{
		CREATED_BY = created_by;
	}

	public long getLAST_UPD_BY()
	{
		return LAST_UPD_BY;
	}

	public void setLAST_UPD_BY(long last_upd_by)
	{
		LAST_UPD_BY = last_upd_by;
	}

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

    public long getWH_COMPANY_ID() {
        return WH_COMPANY_ID;
    }

    public void setWH_COMPANY_ID(long WH_COMPANY_ID) {
        this.WH_COMPANY_ID = WH_COMPANY_ID;
    }

    public long getWH_LOCATION_ID() {
        return WH_LOCATION_ID;
    }

    public void setWH_LOCATION_ID(long WH_LOCATION_ID) {
        this.WH_LOCATION_ID = WH_LOCATION_ID;
    }

    public String getWH_ADDRESS() {
        return WH_ADDRESS;
    }

    public void setWH_ADDRESS(String WH_ADDRESS) {
        this.WH_ADDRESS = WH_ADDRESS;
    }

    public double getWH_ACREAGE() {
        return WH_ACREAGE;
    }

    public void setWH_ACREAGE(double WH_ACREAGE) {
        this.WH_ACREAGE = WH_ACREAGE;
    }

    public double getWH_MAX_CAPACITY() {
        return WH_MAX_CAPACITY;
    }

    public void setWH_MAX_CAPACITY(double WH_MAX_CAPACITY) {
        this.WH_MAX_CAPACITY = WH_MAX_CAPACITY;
    }

    public String getWH_REMARKS() {
        return WH_REMARKS;
    }

    public void setWH_REMARKS(String WH_REMARKS) {
        this.WH_REMARKS = WH_REMARKS;
    }

    public long getWH_ROW_ID() {
        return WH_ROW_ID;
    }

    public void setWH_ROW_ID(long WH_ROW_ID) {
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


}