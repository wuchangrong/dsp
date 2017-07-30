package com.handao.dsp.md.company.vo;

import java.sql.Date;

import com.handao.platform.framework.vo.AFValueObject;

public class CompanyVO extends AFValueObject {

    /**
     * <p>Discription:</p>
     */
    private static final long serialVersionUID = -4545089251632670300L;
    /*************************************** field ***************************************/
    private int CPN_ACCCLOSE_DAY;  //结账日
    private String CPN_ACCOUNT_NO;  //银行账号
    private String CPN_BANK;  //开户银行
    private Date CPN_BEGIN_DATE;  //启用日期
    private String CPN_CALC_MODE;  //成本计算
    private String CPN_COMPANY_CODE;  //公司代码
    private String CPN_COMPANY_NAME;  //公司名称
    private long CPN_CREATED_BY;  //创建人:系统字段。
    private Date CPN_CREATED_TIME;  //创建时间:系统字段。
    private Date CPN_CURRENT_DATE;  //当前日期
    private Date CPN_CURRENT_MONTH;  //当前月份
    private String CPN_DEFAULT_UNIT;  //默认计量单位
    private long CPN_LAST_UPD_BY;  //修改人:系统字段。
    private Date CPN_LAST_UPD_TIME;  //修改时间:系统字段。
    private String CPN_LEGAL_PERSON;  //法人
    private int CPN_MODIFICATION_NUM;  //修改次数:系统字段。
    private long CPN_PARENT_COMPANY;  //上级公司
    private long CPN_ROW_ID;  //ROW_ID
    private String CPN_SHORT_CODE;  //助记码
    private String CPN_STATUS;  //状态
    private String CPN_TAX_NO;  //税务登记号
    private double CPN_TAX_RATE;  //税率
    private String CPN_PARENT_COMPANY_NAME;
    private String CPN_CALC_MODE_NAME;
    
    
    public String getCPN_CALC_MODE_NAME()
    {
        return CPN_CALC_MODE_NAME;
    }

    public void setCPN_CALC_MODE_NAME(String cpn_calc_mode_name)
    {
        CPN_CALC_MODE_NAME = cpn_calc_mode_name;
    }

    public int getCPN_ACCCLOSE_DAY() {
        return CPN_ACCCLOSE_DAY;
    }

    public void setCPN_ACCCLOSE_DAY(int CPN_ACCCLOSE_DAY) {
        this.CPN_ACCCLOSE_DAY = CPN_ACCCLOSE_DAY;
    }

    public String getCPN_ACCOUNT_NO() {
        return CPN_ACCOUNT_NO;
    }

    public void setCPN_ACCOUNT_NO(String CPN_ACCOUNT_NO) {
        this.CPN_ACCOUNT_NO = CPN_ACCOUNT_NO;
    }

    public String getCPN_BANK() {
        return CPN_BANK;
    }

    public void setCPN_BANK(String CPN_BANK) {
        this.CPN_BANK = CPN_BANK;
    }

    public Date getCPN_BEGIN_DATE() {
        return CPN_BEGIN_DATE;
    }

    public void setCPN_BEGIN_DATE(Date CPN_BEGIN_DATE) {
        this.CPN_BEGIN_DATE = CPN_BEGIN_DATE;
    }

    public String getCPN_CALC_MODE() {
        return CPN_CALC_MODE;
    }

    public void setCPN_CALC_MODE(String CPN_CALC_MODE) {
        this.CPN_CALC_MODE = CPN_CALC_MODE;
    }

    public String getCPN_COMPANY_CODE() {
        return CPN_COMPANY_CODE;
    }

    public void setCPN_COMPANY_CODE(String CPN_COMPANY_CODE) {
        this.CPN_COMPANY_CODE = CPN_COMPANY_CODE;
    }

    public String getCPN_COMPANY_NAME() {
        return CPN_COMPANY_NAME;
    }

    public void setCPN_COMPANY_NAME(String CPN_COMPANY_NAME) {
        this.CPN_COMPANY_NAME = CPN_COMPANY_NAME;
    }

    public long getCPN_CREATED_BY() {
        return CPN_CREATED_BY;
    }

    public void setCPN_CREATED_BY(long CPN_CREATED_BY) {
        this.CPN_CREATED_BY = CPN_CREATED_BY;
    }

    public Date getCPN_CREATED_TIME() {
        return CPN_CREATED_TIME;
    }

    public void setCPN_CREATED_TIME(Date CPN_CREATED_TIME) {
        this.CPN_CREATED_TIME = CPN_CREATED_TIME;
    }

    public Date getCPN_CURRENT_DATE() {
        return CPN_CURRENT_DATE;
    }

    public void setCPN_CURRENT_DATE(Date CPN_CURRENT_DATE) {
        this.CPN_CURRENT_DATE = CPN_CURRENT_DATE;
    }

    public Date getCPN_CURRENT_MONTH() {
        return CPN_CURRENT_MONTH;
    }

    public void setCPN_CURRENT_MONTH(Date CPN_CURRENT_MONTH) {
        this.CPN_CURRENT_MONTH = CPN_CURRENT_MONTH;
    }

    public String getCPN_DEFAULT_UNIT() {
        return CPN_DEFAULT_UNIT;
    }

    public void setCPN_DEFAULT_UNIT(String CPN_DEFAULT_UNIT) {
        this.CPN_DEFAULT_UNIT = CPN_DEFAULT_UNIT;
    }

    public long getCPN_LAST_UPD_BY() {
        return CPN_LAST_UPD_BY;
    }

    public void setCPN_LAST_UPD_BY(long CPN_LAST_UPD_BY) {
        this.CPN_LAST_UPD_BY = CPN_LAST_UPD_BY;
    }

    public Date getCPN_LAST_UPD_TIME() {
        return CPN_LAST_UPD_TIME;
    }

    public void setCPN_LAST_UPD_TIME(Date CPN_LAST_UPD_TIME) {
        this.CPN_LAST_UPD_TIME = CPN_LAST_UPD_TIME;
    }

    public String getCPN_LEGAL_PERSON() {
        return CPN_LEGAL_PERSON;
    }

    public void setCPN_LEGAL_PERSON(String CPN_LEGAL_PERSON) {
        this.CPN_LEGAL_PERSON = CPN_LEGAL_PERSON;
    }

    public int getCPN_MODIFICATION_NUM() {
        return CPN_MODIFICATION_NUM;
    }

    public void setCPN_MODIFICATION_NUM(int CPN_MODIFICATION_NUM) {
        this.CPN_MODIFICATION_NUM = CPN_MODIFICATION_NUM;
    }

    public long getCPN_PARENT_COMPANY() {
        return CPN_PARENT_COMPANY;
    }

    public void setCPN_PARENT_COMPANY(long CPN_PARENT_COMPANY) {
        this.CPN_PARENT_COMPANY = CPN_PARENT_COMPANY;
    }

    public long getCPN_ROW_ID() {
        return CPN_ROW_ID;
    }

    public void setCPN_ROW_ID(long CPN_ROW_ID) {
        this.CPN_ROW_ID = CPN_ROW_ID;
    }

    public String getCPN_SHORT_CODE() {
        return CPN_SHORT_CODE;
    }

    public void setCPN_SHORT_CODE(String CPN_SHORT_CODE) {
        this.CPN_SHORT_CODE = CPN_SHORT_CODE;
    }

    public String getCPN_STATUS() {
        return CPN_STATUS;
    }

    public void setCPN_STATUS(String CPN_STATUS) {
        this.CPN_STATUS = CPN_STATUS;
    }

    public String getCPN_TAX_NO() {
        return CPN_TAX_NO;
    }

    public void setCPN_TAX_NO(String CPN_TAX_NO) {
        this.CPN_TAX_NO = CPN_TAX_NO;
    }

    public double getCPN_TAX_RATE() {
        return CPN_TAX_RATE;
    }

    public void setCPN_TAX_RATE(double CPN_TAX_RATE) {
        this.CPN_TAX_RATE = CPN_TAX_RATE;
    }

    public String getCPN_PARENT_COMPANY_NAME()
    {
        return CPN_PARENT_COMPANY_NAME;
    }

    public void setCPN_PARENT_COMPANY_NAME(String cpn_parent_company_name)
    {
        CPN_PARENT_COMPANY_NAME = cpn_parent_company_name;
    }


}