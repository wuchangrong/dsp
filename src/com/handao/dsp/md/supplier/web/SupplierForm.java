package com.handao.dsp.md.supplier.web;

import com.handao.dsp.md.supplier.vo.SupplierVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class SupplierForm extends AFForm implements AFSearchOperation {

    /*************************************** field ***************************************/
    private String SUP_ACCOUNT_NO;  //�ʺ�
    private String SUP_ADDR;  //��ַ
    private String SUP_CODE_P1;  //һ�Ź��̶�Ӧ�ı���
    private String SUP_CONTACTPERSON;  //��ϵ��
    private String SUP_CREATED_BY;  //������:ϵͳ�ֶΡ�
    private String SUP_CREATED_TIME;  //����ʱ��:ϵͳ�ֶΡ�
    private String SUP_DEPOSITARY_BANK;  //��������
    private String SUP_DISTRICTID;  //������ʶ
    private String SUP_LAST_UPD_BY;  //�޸���:ϵͳ�ֶΡ�
    private String SUP_LAST_UPD_TIME;  //�޸�ʱ��:ϵͳ�ֶΡ�
    private String SUP_LEGAL_PERSON;  //���˴���
    private String SUP_MODIFICATION_NUM;  //�޸Ĵ���:ϵͳ�ֶΡ�
    private String SUP_PROVINCEID;  //ʡ�ݱ�ʶ
    private String SUP_ROW_ID;  //ROW_ID:ϵͳ�ֶΡ�
    private String SUP_SHORT_CODE;  //������
    private String SUP_STATUS;  //״̬
    private String SUP_SUPPLIERCODE;  //��Ӧ�̴���
    private String SUP_SUPPLIERDESC;  //��Ӧ������
    private String SUP_SUPPLIERTYPE_ID;  //��Ӧ�����ͱ�ʶ
    private String SUP_TAX_NO;  //˰��
    private String SUP_TEL;  //��ϵ�绰
    private String SUP_THESYSTEM;  //����ϵͳ
    private String SUPPLIER_TYPE_DESC;
    private String STATUSNAME;
    

    public String getSUP_ACCOUNT_NO() {
        return SUP_ACCOUNT_NO;
    }

    public void setSUP_ACCOUNT_NO(String SUP_ACCOUNT_NO) {
        this.SUP_ACCOUNT_NO = SUP_ACCOUNT_NO;
    }

    public String getSUP_ADDR() {
        return SUP_ADDR;
    }

    public void setSUP_ADDR(String SUP_ADDR) {
        this.SUP_ADDR = SUP_ADDR;
    }

    public String getSUP_CODE_P1() {
        return SUP_CODE_P1;
    }

    public void setSUP_CODE_P1(String SUP_CODE_P1) {
        this.SUP_CODE_P1 = SUP_CODE_P1;
    }

    public String getSUP_CONTACTPERSON() {
        return SUP_CONTACTPERSON;
    }

    public void setSUP_CONTACTPERSON(String SUP_CONTACTPERSON) {
        this.SUP_CONTACTPERSON = SUP_CONTACTPERSON;
    }

    public String getSUP_CREATED_BY() {
        return SUP_CREATED_BY;
    }

    public void setSUP_CREATED_BY(String SUP_CREATED_BY) {
        this.SUP_CREATED_BY = SUP_CREATED_BY;
    }

    public String getSUP_CREATED_TIME() {
        return SUP_CREATED_TIME;
    }

    public void setSUP_CREATED_TIME(String SUP_CREATED_TIME) {
        this.SUP_CREATED_TIME = SUP_CREATED_TIME;
    }

    public String getSUP_DEPOSITARY_BANK() {
        return SUP_DEPOSITARY_BANK;
    }

    public void setSUP_DEPOSITARY_BANK(String SUP_DEPOSITARY_BANK) {
        this.SUP_DEPOSITARY_BANK = SUP_DEPOSITARY_BANK;
    }

    public String getSUP_DISTRICTID() {
        return SUP_DISTRICTID;
    }

    public void setSUP_DISTRICTID(String SUP_DISTRICTID) {
        this.SUP_DISTRICTID = SUP_DISTRICTID;
    }

    public String getSUP_LAST_UPD_BY() {
        return SUP_LAST_UPD_BY;
    }

    public void setSUP_LAST_UPD_BY(String SUP_LAST_UPD_BY) {
        this.SUP_LAST_UPD_BY = SUP_LAST_UPD_BY;
    }

    public String getSUP_LAST_UPD_TIME() {
        return SUP_LAST_UPD_TIME;
    }

    public void setSUP_LAST_UPD_TIME(String SUP_LAST_UPD_TIME) {
        this.SUP_LAST_UPD_TIME = SUP_LAST_UPD_TIME;
    }

    public String getSUP_LEGAL_PERSON() {
        return SUP_LEGAL_PERSON;
    }

    public void setSUP_LEGAL_PERSON(String SUP_LEGAL_PERSON) {
        this.SUP_LEGAL_PERSON = SUP_LEGAL_PERSON;
    }

    public String getSUP_MODIFICATION_NUM() {
        return SUP_MODIFICATION_NUM;
    }

    public void setSUP_MODIFICATION_NUM(String SUP_MODIFICATION_NUM) {
        this.SUP_MODIFICATION_NUM = SUP_MODIFICATION_NUM;
    }

    public String getSUP_PROVINCEID() {
        return SUP_PROVINCEID;
    }

    public void setSUP_PROVINCEID(String SUP_PROVINCEID) {
        this.SUP_PROVINCEID = SUP_PROVINCEID;
    }

    public String getSUP_ROW_ID() {
        return SUP_ROW_ID;
    }

    public void setSUP_ROW_ID(String SUP_ROW_ID) {
        this.SUP_ROW_ID = SUP_ROW_ID;
    }

    public String getSUP_SHORT_CODE() {
        return SUP_SHORT_CODE;
    }

    public void setSUP_SHORT_CODE(String SUP_SHORT_CODE) {
        this.SUP_SHORT_CODE = SUP_SHORT_CODE;
    }

    public String getSUP_STATUS() {
        return SUP_STATUS;
    }

    public void setSUP_STATUS(String SUP_STATUS) {
        this.SUP_STATUS = SUP_STATUS;
    }

    public String getSUP_SUPPLIERCODE() {
        return SUP_SUPPLIERCODE;
    }

    public void setSUP_SUPPLIERCODE(String SUP_SUPPLIERCODE) {
        this.SUP_SUPPLIERCODE = SUP_SUPPLIERCODE;
    }

    public String getSUP_SUPPLIERDESC() {
        return SUP_SUPPLIERDESC;
    }

    public void setSUP_SUPPLIERDESC(String SUP_SUPPLIERDESC) {
        this.SUP_SUPPLIERDESC = SUP_SUPPLIERDESC;
    }

    public String getSUP_SUPPLIERTYPE_ID() {
        return SUP_SUPPLIERTYPE_ID;
    }

    public void setSUP_SUPPLIERTYPE_ID(String SUP_SUPPLIERTYPE_ID) {
        this.SUP_SUPPLIERTYPE_ID = SUP_SUPPLIERTYPE_ID;
    }

    public String getSUP_TAX_NO() {
        return SUP_TAX_NO;
    }

    public void setSUP_TAX_NO(String SUP_TAX_NO) {
        this.SUP_TAX_NO = SUP_TAX_NO;
    }

    public String getSUP_TEL() {
        return SUP_TEL;
    }

    public void setSUP_TEL(String SUP_TEL) {
        this.SUP_TEL = SUP_TEL;
    }

    public String getSUP_THESYSTEM() {
        return SUP_THESYSTEM;
    }

    public void setSUP_THESYSTEM(String SUP_THESYSTEM) {
        this.SUP_THESYSTEM = SUP_THESYSTEM;
    }

	



    /*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "WMS_BASE_SUPPLIER_SupplierForm";
    }

    /**
     * [�ӿڷ���ʵ��]
     * ���ز�ѯ��
     * @return AFSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��AFDataFormat.parseString()��������ת��
     * @return AFValueObject
     */
    public AFValueObject transform() {
        SupplierVO vo = new SupplierVO();
        vo.setSUP_ACCOUNT_NO(AFDataFormat.parseString(SUP_ACCOUNT_NO, vo.getSUP_ACCOUNT_NO()));
        vo.setSUP_ADDR(AFDataFormat.parseString(SUP_ADDR, vo.getSUP_ADDR()));
        vo.setSUP_CODE_P1(AFDataFormat.parseString(SUP_CODE_P1, vo.getSUP_CODE_P1()));
        vo.setSUP_CONTACTPERSON(AFDataFormat.parseString(SUP_CONTACTPERSON, vo.getSUP_CONTACTPERSON()));
        vo.setSUP_CREATED_BY(AFDataFormat.parseString(SUP_CREATED_BY, vo.getSUP_CREATED_BY()));
        vo.setSUP_CREATED_TIME(AFDataFormat.parseString(SUP_CREATED_TIME, vo.getSUP_CREATED_TIME()));
        vo.setSUP_DEPOSITARY_BANK(AFDataFormat.parseString(SUP_DEPOSITARY_BANK, vo.getSUP_DEPOSITARY_BANK()));
        vo.setSUP_DISTRICTID(AFDataFormat.parseString(SUP_DISTRICTID, vo.getSUP_DISTRICTID()));
        vo.setSUP_LAST_UPD_BY(AFDataFormat.parseString(SUP_LAST_UPD_BY, vo.getSUP_LAST_UPD_BY()));
        vo.setSUP_LAST_UPD_TIME(AFDataFormat.parseString(SUP_LAST_UPD_TIME, vo.getSUP_LAST_UPD_TIME()));
        vo.setSUP_LEGAL_PERSON(AFDataFormat.parseString(SUP_LEGAL_PERSON, vo.getSUP_LEGAL_PERSON()));
        vo.setSUP_MODIFICATION_NUM(AFDataFormat.parseString(SUP_MODIFICATION_NUM, vo.getSUP_MODIFICATION_NUM()));
        vo.setSUP_PROVINCEID(AFDataFormat.parseString(SUP_PROVINCEID, vo.getSUP_PROVINCEID()));
        vo.setSUP_ROW_ID(AFDataFormat.parseString(SUP_ROW_ID, vo.getSUP_ROW_ID()));
        vo.setSUP_SHORT_CODE(AFDataFormat.parseString(SUP_SHORT_CODE, vo.getSUP_SHORT_CODE()));
        vo.setSUP_STATUS(AFDataFormat.parseString(SUP_STATUS, vo.getSUP_STATUS()));
        vo.setSUP_SUPPLIERCODE(AFDataFormat.parseString(SUP_SUPPLIERCODE, vo.getSUP_SUPPLIERCODE()));
        vo.setSUP_SUPPLIERDESC(AFDataFormat.parseString(SUP_SUPPLIERDESC, vo.getSUP_SUPPLIERDESC()));
        vo.setSUP_SUPPLIERTYPE_ID(AFDataFormat.parseString(SUP_SUPPLIERTYPE_ID, vo.getSUP_SUPPLIERTYPE_ID()));
        vo.setSUP_TAX_NO(AFDataFormat.parseString(SUP_TAX_NO, vo.getSUP_TAX_NO()));
        vo.setSUP_TEL(AFDataFormat.parseString(SUP_TEL, vo.getSUP_TEL()));
        vo.setSUP_THESYSTEM(AFDataFormat.parseString(SUP_THESYSTEM, vo.getSUP_THESYSTEM()));
        vo.setSUPPLIER_TYPE_DESC(AFDataFormat.parseString(SUPPLIER_TYPE_DESC,vo.getSUPPLIER_TYPE_DESC()));
        vo.setSTATUSNAME(AFDataFormat.parseString(STATUSNAME,vo.getSTATUSNAME()));
        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        SupplierVO vo = (SupplierVO)_vo;
        SUP_ACCOUNT_NO = AFDataFormat.toString(vo.getSUP_ACCOUNT_NO());
        SUP_ADDR = AFDataFormat.toString(vo.getSUP_ADDR());
        SUP_CODE_P1 = AFDataFormat.toString(vo.getSUP_CODE_P1());
        SUP_CONTACTPERSON = AFDataFormat.toString(vo.getSUP_CONTACTPERSON());
        SUP_CREATED_BY = AFDataFormat.toString(vo.getSUP_CREATED_BY());
        SUP_CREATED_TIME = AFDataFormat.toString(vo.getSUP_CREATED_TIME());
        SUP_DEPOSITARY_BANK = AFDataFormat.toString(vo.getSUP_DEPOSITARY_BANK());
        SUP_DISTRICTID = AFDataFormat.toString(vo.getSUP_DISTRICTID());
        SUP_LAST_UPD_BY = AFDataFormat.toString(vo.getSUP_LAST_UPD_BY());
        SUP_LAST_UPD_TIME = AFDataFormat.toString(vo.getSUP_LAST_UPD_TIME());
        SUP_LEGAL_PERSON = AFDataFormat.toString(vo.getSUP_LEGAL_PERSON());
        SUP_MODIFICATION_NUM = AFDataFormat.toString(vo.getSUP_MODIFICATION_NUM());
        SUP_PROVINCEID = AFDataFormat.toString(vo.getSUP_PROVINCEID());
        SUP_ROW_ID = AFDataFormat.toString(vo.getSUP_ROW_ID());
        SUP_SHORT_CODE = AFDataFormat.toString(vo.getSUP_SHORT_CODE());
        SUP_STATUS = AFDataFormat.toString(vo.getSUP_STATUS());
        SUP_SUPPLIERCODE = AFDataFormat.toString(vo.getSUP_SUPPLIERCODE());
        SUP_SUPPLIERDESC = AFDataFormat.toString(vo.getSUP_SUPPLIERDESC());
        SUP_SUPPLIERTYPE_ID = AFDataFormat.toString(vo.getSUP_SUPPLIERTYPE_ID());
        SUP_TAX_NO = AFDataFormat.toString(vo.getSUP_TAX_NO());
        SUP_TEL = AFDataFormat.toString(vo.getSUP_TEL());
        SUP_THESYSTEM = AFDataFormat.toString(vo.getSUP_THESYSTEM());
        SUPPLIER_TYPE_DESC = AFDataFormat.toString(vo.getSUPPLIER_TYPE_DESC());
        STATUSNAME = AFDataFormat.toString(vo.getSTATUSNAME());
    }

    /**
     * [������󷽷�ʵ��]
     * ��ʼ��������
     */
    public void initialize() {
        SUP_ACCOUNT_NO = "";
        SUP_ADDR = "";
        SUP_CODE_P1 = "";
        SUP_CONTACTPERSON = "";
        SUP_CREATED_BY = "";
        SUP_CREATED_TIME = "";
        SUP_DEPOSITARY_BANK = "";
        SUP_DISTRICTID = "";
        SUP_LAST_UPD_BY = "";
        SUP_LAST_UPD_TIME = "";
        SUP_LEGAL_PERSON = "";
        SUP_MODIFICATION_NUM = "";
        SUP_PROVINCEID = "";
        SUP_ROW_ID = "";
        SUP_SHORT_CODE = "";
        SUP_STATUS = "";
        SUP_SUPPLIERCODE = "";
        SUP_SUPPLIERDESC = "";
        SUP_SUPPLIERTYPE_ID = "";
        SUP_TAX_NO = "";
        SUP_TEL = "";
        SUP_THESYSTEM = "";
        SUPPLIER_TYPE_DESC = "";
        STATUSNAME = "";

    }

    /*************************************** customer ***************************************/
    private SupplierSearchForm searchForm = new SupplierSearchForm();

    public String getSUPPLIER_TYPE_DESC()
    {
        return SUPPLIER_TYPE_DESC;
    }

    public void setSUPPLIER_TYPE_DESC(String supplier_type_desc)
    {
        SUPPLIER_TYPE_DESC = supplier_type_desc;
    }

    public String getSTATUSNAME()
    {
        return STATUSNAME;
    }

    public void setSTATUSNAME(String statusname)
    {
        STATUSNAME = statusname;
    }

	public void initSearchForm() {
        SUP_ACCOUNT_NO = "";
        SUP_ADDR = "";
        SUP_CODE_P1 = "";
        SUP_CONTACTPERSON = "";
        SUP_CREATED_BY = "";
        SUP_CREATED_TIME = "";
        SUP_DEPOSITARY_BANK = "";
        SUP_DISTRICTID = "";
        SUP_LAST_UPD_BY = "";
        SUP_LAST_UPD_TIME = "";
        SUP_LEGAL_PERSON = "";
        SUP_MODIFICATION_NUM = "";
        SUP_PROVINCEID = "";
        SUP_ROW_ID = "";
        SUP_SHORT_CODE = "";
        SUP_STATUS = "";
        SUP_SUPPLIERCODE = "";
        SUP_SUPPLIERDESC = "";
        SUP_SUPPLIERTYPE_ID = "";
        SUP_TAX_NO = "";
        SUP_TEL = "";
        SUP_THESYSTEM = "";
        SUPPLIER_TYPE_DESC = "";
        STATUSNAME = "";		
	}

}