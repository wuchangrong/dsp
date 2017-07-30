package com.handao.dsp.md.company.web;

import com.handao.dsp.md.company.vo.CompanyVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class CompanyForm extends AFForm implements AFSearchOperation {

    /**
     * <p>Discription:</p>
     */
    private static final long serialVersionUID = -99623733652730073L;
    /*************************************** field ***************************************/
    private String CPN_ACCCLOSE_DAY;  //结账日
    private String CPN_ACCOUNT_NO;  //银行账号
    private String CPN_BANK;  //开户银行
    private String CPN_BEGIN_DATE;  //启用日期
    private String CPN_CALC_MODE;  //成本计算
    private String CPN_COMPANY_CODE;  //公司代码
    private String CPN_COMPANY_NAME;  //公司名称
    private String CPN_CREATED_BY;  //创建人:系统字段。
    private String CPN_CREATED_TIME;  //创建时间:系统字段。
    private String CPN_CURRENT_DATE;  //当前日期
    private String CPN_CURRENT_MONTH;  //当前月份
    private String CPN_DEFAULT_UNIT;  //默认计量单位
    private String CPN_LAST_UPD_BY;  //修改人:系统字段。
    private String CPN_LAST_UPD_TIME;  //修改时间:系统字段。
    private String CPN_LEGAL_PERSON;  //法人
    private String CPN_MODIFICATION_NUM;  //修改次数:系统字段。
    private String CPN_PARENT_COMPANY;  //上级公司
    private String CPN_ROW_ID;  //ROW_ID
    private String CPN_SHORT_CODE;  //助记码
    private String CPN_STATUS;  //状态
    private String CPN_TAX_NO;  //税务登记号
    private String CPN_TAX_RATE;  //税率
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

    public String getCPN_ACCCLOSE_DAY() {
        return CPN_ACCCLOSE_DAY;
    }

    public void setCPN_ACCCLOSE_DAY(String CPN_ACCCLOSE_DAY) {
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

    public String getCPN_BEGIN_DATE() {
        return CPN_BEGIN_DATE;
    }

    public void setCPN_BEGIN_DATE(String CPN_BEGIN_DATE) {
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

    public String getCPN_CREATED_BY() {
        return CPN_CREATED_BY;
    }

    public void setCPN_CREATED_BY(String CPN_CREATED_BY) {
        this.CPN_CREATED_BY = CPN_CREATED_BY;
    }

    public String getCPN_CREATED_TIME() {
        return CPN_CREATED_TIME;
    }

    public void setCPN_CREATED_TIME(String CPN_CREATED_TIME) {
        this.CPN_CREATED_TIME = CPN_CREATED_TIME;
    }

    public String getCPN_CURRENT_DATE() {
        return CPN_CURRENT_DATE;
    }

    public void setCPN_CURRENT_DATE(String CPN_CURRENT_DATE) {
        this.CPN_CURRENT_DATE = CPN_CURRENT_DATE;
    }

    public String getCPN_CURRENT_MONTH() {
        return CPN_CURRENT_MONTH;
    }

    public void setCPN_CURRENT_MONTH(String CPN_CURRENT_MONTH) {
        this.CPN_CURRENT_MONTH = CPN_CURRENT_MONTH;
    }

    public String getCPN_DEFAULT_UNIT() {
        return CPN_DEFAULT_UNIT;
    }

    public void setCPN_DEFAULT_UNIT(String CPN_DEFAULT_UNIT) {
        this.CPN_DEFAULT_UNIT = CPN_DEFAULT_UNIT;
    }

    public String getCPN_LAST_UPD_BY() {
        return CPN_LAST_UPD_BY;
    }

    public void setCPN_LAST_UPD_BY(String CPN_LAST_UPD_BY) {
        this.CPN_LAST_UPD_BY = CPN_LAST_UPD_BY;
    }

    public String getCPN_LAST_UPD_TIME() {
        return CPN_LAST_UPD_TIME;
    }

    public void setCPN_LAST_UPD_TIME(String CPN_LAST_UPD_TIME) {
        this.CPN_LAST_UPD_TIME = CPN_LAST_UPD_TIME;
    }

    public String getCPN_LEGAL_PERSON() {
        return CPN_LEGAL_PERSON;
    }

    public void setCPN_LEGAL_PERSON(String CPN_LEGAL_PERSON) {
        this.CPN_LEGAL_PERSON = CPN_LEGAL_PERSON;
    }

    public String getCPN_MODIFICATION_NUM() {
        return CPN_MODIFICATION_NUM;
    }

    public void setCPN_MODIFICATION_NUM(String CPN_MODIFICATION_NUM) {
        this.CPN_MODIFICATION_NUM = CPN_MODIFICATION_NUM;
    }

    public String getCPN_PARENT_COMPANY() {
        return CPN_PARENT_COMPANY;
    }

    public void setCPN_PARENT_COMPANY(String CPN_PARENT_COMPANY) {
        this.CPN_PARENT_COMPANY = CPN_PARENT_COMPANY;
    }

    public String getCPN_ROW_ID() {
        return CPN_ROW_ID;
    }

    public void setCPN_ROW_ID(String CPN_ROW_ID) {
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

    public String getCPN_TAX_RATE() {
        return CPN_TAX_RATE;
    }

    public void setCPN_TAX_RATE(String CPN_TAX_RATE) {
        this.CPN_TAX_RATE = CPN_TAX_RATE;
    }

	



    /*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "WMS_BASE_COMPANY_CompanyForm";
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
        CompanyVO vo = new CompanyVO();
        vo.setCPN_ACCCLOSE_DAY(AFDataFormat.parseString(CPN_ACCCLOSE_DAY, vo.getCPN_ACCCLOSE_DAY()));
        vo.setCPN_ACCOUNT_NO(AFDataFormat.parseString(CPN_ACCOUNT_NO, vo.getCPN_ACCOUNT_NO()));
        vo.setCPN_BANK(AFDataFormat.parseString(CPN_BANK, vo.getCPN_BANK()));
        vo.setCPN_BEGIN_DATE(AFDataFormat.parseString(CPN_BEGIN_DATE, vo.getCPN_BEGIN_DATE()));
        vo.setCPN_CALC_MODE(AFDataFormat.parseString(CPN_CALC_MODE, vo.getCPN_CALC_MODE()));
        vo.setCPN_CALC_MODE_NAME(AFDataFormat.parseString(CPN_CALC_MODE_NAME, vo.getCPN_CALC_MODE_NAME()));
        
        vo.setCPN_COMPANY_CODE(AFDataFormat.parseString(CPN_COMPANY_CODE, vo.getCPN_COMPANY_CODE()));
        vo.setCPN_COMPANY_NAME(AFDataFormat.parseString(CPN_COMPANY_NAME, vo.getCPN_COMPANY_NAME()));
        vo.setCPN_CREATED_BY(AFDataFormat.parseString(CPN_CREATED_BY, vo.getCPN_CREATED_BY()));
        vo.setCPN_CREATED_TIME(AFDataFormat.parseString(CPN_CREATED_TIME, vo.getCPN_CREATED_TIME()));
        vo.setCPN_CURRENT_DATE(AFDataFormat.parseString(CPN_CURRENT_DATE, vo.getCPN_CURRENT_DATE()));
        vo.setCPN_CURRENT_MONTH(AFDataFormat.parseString(CPN_CURRENT_MONTH, vo.getCPN_CURRENT_MONTH()));
        vo.setCPN_DEFAULT_UNIT(AFDataFormat.parseString(CPN_DEFAULT_UNIT, vo.getCPN_DEFAULT_UNIT()));
        vo.setCPN_LAST_UPD_BY(AFDataFormat.parseString(CPN_LAST_UPD_BY, vo.getCPN_LAST_UPD_BY()));
        vo.setCPN_LAST_UPD_TIME(AFDataFormat.parseString(CPN_LAST_UPD_TIME, vo.getCPN_LAST_UPD_TIME()));
        vo.setCPN_LEGAL_PERSON(AFDataFormat.parseString(CPN_LEGAL_PERSON, vo.getCPN_LEGAL_PERSON()));
        vo.setCPN_MODIFICATION_NUM(AFDataFormat.parseString(CPN_MODIFICATION_NUM, vo.getCPN_MODIFICATION_NUM()));
        vo.setCPN_PARENT_COMPANY(AFDataFormat.parseString(CPN_PARENT_COMPANY, vo.getCPN_PARENT_COMPANY()));
        vo.setCPN_ROW_ID(AFDataFormat.parseString(CPN_ROW_ID, vo.getCPN_ROW_ID()));
        vo.setCPN_SHORT_CODE(AFDataFormat.parseString(CPN_SHORT_CODE, vo.getCPN_SHORT_CODE()));
        vo.setCPN_STATUS(AFDataFormat.parseString(CPN_STATUS, vo.getCPN_STATUS()));
        vo.setCPN_TAX_NO(AFDataFormat.parseString(CPN_TAX_NO, vo.getCPN_TAX_NO()));
        vo.setCPN_TAX_RATE(AFDataFormat.parseString(CPN_TAX_RATE, vo.getCPN_TAX_RATE()));
        
        
        vo.setCPN_PARENT_COMPANY_NAME(AFDataFormat.parseString(CPN_PARENT_COMPANY_NAME, vo.getCPN_PARENT_COMPANY_NAME()));
        
        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        CompanyVO vo = (CompanyVO)_vo;
        CPN_ACCCLOSE_DAY = AFDataFormat.toString(vo.getCPN_ACCCLOSE_DAY());
        CPN_ACCOUNT_NO = AFDataFormat.toString(vo.getCPN_ACCOUNT_NO());
        CPN_BANK = AFDataFormat.toString(vo.getCPN_BANK());
        CPN_BEGIN_DATE = AFDataFormat.toString(vo.getCPN_BEGIN_DATE());
        CPN_CALC_MODE = AFDataFormat.toString(vo.getCPN_CALC_MODE());
        CPN_CALC_MODE_NAME = AFDataFormat.toString(vo.getCPN_CALC_MODE_NAME());
        CPN_COMPANY_CODE = AFDataFormat.toString(vo.getCPN_COMPANY_CODE());
        CPN_COMPANY_NAME = AFDataFormat.toString(vo.getCPN_COMPANY_NAME());
        CPN_CREATED_BY = AFDataFormat.toString(vo.getCPN_CREATED_BY());
        CPN_CREATED_TIME = AFDataFormat.toString(vo.getCPN_CREATED_TIME());
        CPN_CURRENT_DATE = AFDataFormat.toString(vo.getCPN_CURRENT_DATE());
        CPN_CURRENT_MONTH = AFDataFormat.toString(vo.getCPN_CURRENT_MONTH());
        CPN_DEFAULT_UNIT = AFDataFormat.toString(vo.getCPN_DEFAULT_UNIT());
        CPN_LAST_UPD_BY = AFDataFormat.toString(vo.getCPN_LAST_UPD_BY());
        CPN_LAST_UPD_TIME = AFDataFormat.toString(vo.getCPN_LAST_UPD_TIME());
        CPN_LEGAL_PERSON = AFDataFormat.toString(vo.getCPN_LEGAL_PERSON());
        CPN_MODIFICATION_NUM = AFDataFormat.toString(vo.getCPN_MODIFICATION_NUM());
        CPN_PARENT_COMPANY = AFDataFormat.toString(vo.getCPN_PARENT_COMPANY());
        CPN_ROW_ID = AFDataFormat.toString(vo.getCPN_ROW_ID());
        CPN_SHORT_CODE = AFDataFormat.toString(vo.getCPN_SHORT_CODE());
        CPN_STATUS = AFDataFormat.toString(vo.getCPN_STATUS());
        CPN_TAX_NO = AFDataFormat.toString(vo.getCPN_TAX_NO());
        CPN_TAX_RATE = AFDataFormat.toString(vo.getCPN_TAX_RATE());
        
        CPN_PARENT_COMPANY_NAME = AFDataFormat.toString(vo.getCPN_PARENT_COMPANY_NAME());

    }

    /**
     * [父类抽象方法实现]
     * 初始化表单数据
     */
    public void initialize() {
        CPN_ACCCLOSE_DAY = "";
        CPN_ACCOUNT_NO = "";
        CPN_BANK = "";
        CPN_BEGIN_DATE = "";
        CPN_CALC_MODE = "";
        CPN_CALC_MODE_NAME = "";
        CPN_COMPANY_CODE = "";
        CPN_COMPANY_NAME = "";
        CPN_CREATED_BY = "";
        CPN_CREATED_TIME = "";
        CPN_CURRENT_DATE = "";
        CPN_CURRENT_MONTH = "";
        CPN_DEFAULT_UNIT = "";
        CPN_LAST_UPD_BY = "";
        CPN_LAST_UPD_TIME = "";
        CPN_LEGAL_PERSON = "";
        CPN_MODIFICATION_NUM = "";
        CPN_PARENT_COMPANY = "";
        CPN_ROW_ID = "";
        CPN_SHORT_CODE = "";
        CPN_STATUS = "";
        CPN_TAX_NO = "";
        CPN_TAX_RATE = "";
        
        
        CPN_PARENT_COMPANY_NAME = "";

    }

    /*************************************** customer ***************************************/
    private CompanySearchForm searchForm = new CompanySearchForm();

    public String getCPN_PARENT_COMPANY_NAME()
    {
        return CPN_PARENT_COMPANY_NAME;
    }

    public void setCPN_PARENT_COMPANY_NAME(String cpn_parent_company_name)
    {
        CPN_PARENT_COMPANY_NAME = cpn_parent_company_name;
    }

	public void initSearchForm() {
        CPN_ACCCLOSE_DAY = "";
        CPN_ACCOUNT_NO = "";
        CPN_BANK = "";
        CPN_BEGIN_DATE = "";
        CPN_CALC_MODE = "";
        CPN_CALC_MODE_NAME = "";
        CPN_COMPANY_CODE = "";
        CPN_COMPANY_NAME = "";
        CPN_CREATED_BY = "";
        CPN_CREATED_TIME = "";
        CPN_CURRENT_DATE = "";
        CPN_CURRENT_MONTH = "";
        CPN_DEFAULT_UNIT = "";
        CPN_LAST_UPD_BY = "";
        CPN_LAST_UPD_TIME = "";
        CPN_LEGAL_PERSON = "";
        CPN_MODIFICATION_NUM = "";
        CPN_PARENT_COMPANY = "";
        CPN_ROW_ID = "";
        CPN_SHORT_CODE = "";
        CPN_STATUS = "";
        CPN_TAX_NO = "";
        CPN_TAX_RATE = "";
        CPN_PARENT_COMPANY_NAME = "";
	}
    
}