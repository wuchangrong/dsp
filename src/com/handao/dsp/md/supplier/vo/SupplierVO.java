package com.handao.dsp.md.supplier.vo;

import java.sql.Date;

import com.handao.platform.framework.vo.AFValueObject;

public class SupplierVO extends AFValueObject
{

    /*************************************** field ***************************************/
    private String SUP_ACCOUNT_NO; //�ʺ�

    private String SUP_ADDR; //��ַ

    private String SUP_CODE_P1; //һ�Ź��̶�Ӧ�ı���

    private String SUP_CONTACTPERSON; //��ϵ��

    private long SUP_CREATED_BY; //������:ϵͳ�ֶΡ�

    private Date SUP_CREATED_TIME; //����ʱ��:ϵͳ�ֶΡ�

    private String SUP_DEPOSITARY_BANK; //��������

    private long SUP_DISTRICTID; //������ʶ

    private long SUP_LAST_UPD_BY; //�޸���:ϵͳ�ֶΡ�

    private Date SUP_LAST_UPD_TIME; //�޸�ʱ��:ϵͳ�ֶΡ�

    private String SUP_LEGAL_PERSON; //���˴���

    private int SUP_MODIFICATION_NUM; //�޸Ĵ���:ϵͳ�ֶΡ�

    private long SUP_PROVINCEID; //ʡ�ݱ�ʶ

    private long SUP_ROW_ID; //ROW_ID:ϵͳ�ֶΡ�

    private String SUP_SHORT_CODE; //������

    private String SUP_STATUS; //״̬

    private String SUP_SUPPLIERCODE; //��Ӧ�̴���

    private String SUP_SUPPLIERDESC; //��Ӧ������

    private long SUP_SUPPLIERTYPE_ID; //��Ӧ�����ͱ�ʶ

    private String SUP_TAX_NO; //˰��

    private String SUP_TEL; //��ϵ�绰

    private String SUP_THESYSTEM; //����ϵͳ
    
    private String SUPPLIER_TYPE_DESC;
    
    private String STATUSNAME;

    public String getSUP_ACCOUNT_NO()
    {
        return SUP_ACCOUNT_NO;
    }

    public void setSUP_ACCOUNT_NO(String SUP_ACCOUNT_NO)
    {
        this.SUP_ACCOUNT_NO = SUP_ACCOUNT_NO;
    }

    public String getSUP_ADDR()
    {
        return SUP_ADDR;
    }

    public void setSUP_ADDR(String SUP_ADDR)
    {
        this.SUP_ADDR = SUP_ADDR;
    }

    public String getSUP_CODE_P1()
    {
        return SUP_CODE_P1;
    }

    public void setSUP_CODE_P1(String SUP_CODE_P1)
    {
        this.SUP_CODE_P1 = SUP_CODE_P1;
    }

    public String getSUP_CONTACTPERSON()
    {
        return SUP_CONTACTPERSON;
    }

    public void setSUP_CONTACTPERSON(String SUP_CONTACTPERSON)
    {
        this.SUP_CONTACTPERSON = SUP_CONTACTPERSON;
    }

    public Date getSUP_CREATED_TIME()
    {
        return SUP_CREATED_TIME;
    }

    public void setSUP_CREATED_TIME(Date SUP_CREATED_TIME)
    {
        this.SUP_CREATED_TIME = SUP_CREATED_TIME;
    }

    public String getSUP_DEPOSITARY_BANK()
    {
        return SUP_DEPOSITARY_BANK;
    }

    public void setSUP_DEPOSITARY_BANK(String SUP_DEPOSITARY_BANK)
    {
        this.SUP_DEPOSITARY_BANK = SUP_DEPOSITARY_BANK;
    }

    public Date getSUP_LAST_UPD_TIME()
    {
        return SUP_LAST_UPD_TIME;
    }

    public void setSUP_LAST_UPD_TIME(Date SUP_LAST_UPD_TIME)
    {
        this.SUP_LAST_UPD_TIME = SUP_LAST_UPD_TIME;
    }

    public String getSUP_LEGAL_PERSON()
    {
        return SUP_LEGAL_PERSON;
    }

    public void setSUP_LEGAL_PERSON(String SUP_LEGAL_PERSON)
    {
        this.SUP_LEGAL_PERSON = SUP_LEGAL_PERSON;
    }

    public int getSUP_MODIFICATION_NUM()
    {
        return SUP_MODIFICATION_NUM;
    }

    public void setSUP_MODIFICATION_NUM(int SUP_MODIFICATION_NUM)
    {
        this.SUP_MODIFICATION_NUM = SUP_MODIFICATION_NUM;
    }

    public String getSUP_SHORT_CODE()
    {
        return SUP_SHORT_CODE;
    }

    public void setSUP_SHORT_CODE(String SUP_SHORT_CODE)
    {
        this.SUP_SHORT_CODE = SUP_SHORT_CODE;
    }

    public String getSUP_STATUS()
    {
        return SUP_STATUS;
    }

    public void setSUP_STATUS(String SUP_STATUS)
    {
        this.SUP_STATUS = SUP_STATUS;
    }

    public String getSUP_SUPPLIERCODE()
    {
        return SUP_SUPPLIERCODE;
    }

    public void setSUP_SUPPLIERCODE(String SUP_SUPPLIERCODE)
    {
        this.SUP_SUPPLIERCODE = SUP_SUPPLIERCODE;
    }

    public String getSUP_SUPPLIERDESC()
    {
        return SUP_SUPPLIERDESC;
    }

    public void setSUP_SUPPLIERDESC(String SUP_SUPPLIERDESC)
    {
        this.SUP_SUPPLIERDESC = SUP_SUPPLIERDESC;
    }

    public String getSUP_TAX_NO()
    {
        return SUP_TAX_NO;
    }

    public void setSUP_TAX_NO(String SUP_TAX_NO)
    {
        this.SUP_TAX_NO = SUP_TAX_NO;
    }

    public String getSUP_TEL()
    {
        return SUP_TEL;
    }

    public void setSUP_TEL(String SUP_TEL)
    {
        this.SUP_TEL = SUP_TEL;
    }

    public String getSUP_THESYSTEM()
    {
        return SUP_THESYSTEM;
    }

    public void setSUP_THESYSTEM(String SUP_THESYSTEM)
    {
        this.SUP_THESYSTEM = SUP_THESYSTEM;
    }

    /**
     * sUP_CREATED_BY�� get() ����
     * @return long sUP_CREATED_BY.
     */
    public long getSUP_CREATED_BY()
    {
        return SUP_CREATED_BY;
    }

    /**
     * sUP_CREATED_BY�� set() ����
     * @param sup_created_by The sUP_CREATED_BY to set.
     */
    public void setSUP_CREATED_BY(long sup_created_by)
    {
        SUP_CREATED_BY = sup_created_by;
    }

    /**
     * sUP_DISTRICTID�� get() ����
     * @return long sUP_DISTRICTID.
     */
    public long getSUP_DISTRICTID()
    {
        return SUP_DISTRICTID;
    }

    /**
     * sUP_DISTRICTID�� set() ����
     * @param sup_districtid The sUP_DISTRICTID to set.
     */
    public void setSUP_DISTRICTID(long sup_districtid)
    {
        SUP_DISTRICTID = sup_districtid;
    }

    /**
     * sUP_LAST_UPD_BY�� get() ����
     * @return long sUP_LAST_UPD_BY.
     */
    public long getSUP_LAST_UPD_BY()
    {
        return SUP_LAST_UPD_BY;
    }

    /**
     * sUP_LAST_UPD_BY�� set() ����
     * @param sup_last_upd_by The sUP_LAST_UPD_BY to set.
     */
    public void setSUP_LAST_UPD_BY(long sup_last_upd_by)
    {
        SUP_LAST_UPD_BY = sup_last_upd_by;
    }

    /**
     * sUP_PROVINCEID�� get() ����
     * @return long sUP_PROVINCEID.
     */
    public long getSUP_PROVINCEID()
    {
        return SUP_PROVINCEID;
    }

    /**
     * sUP_PROVINCEID�� set() ����
     * @param sup_provinceid The sUP_PROVINCEID to set.
     */
    public void setSUP_PROVINCEID(long sup_provinceid)
    {
        SUP_PROVINCEID = sup_provinceid;
    }

    /**
     * sUP_ROW_ID�� get() ����
     * @return long sUP_ROW_ID.
     */
    public long getSUP_ROW_ID()
    {
        return SUP_ROW_ID;
    }

    /**
     * sUP_ROW_ID�� set() ����
     * @param sup_row_id The sUP_ROW_ID to set.
     */
    public void setSUP_ROW_ID(long sup_row_id)
    {
        SUP_ROW_ID = sup_row_id;
    }

    /**
     * sUP_SUPPLIERTYPE_ID�� get() ����
     * @return long sUP_SUPPLIERTYPE_ID.
     */
    public long getSUP_SUPPLIERTYPE_ID()
    {
        return SUP_SUPPLIERTYPE_ID;
    }

    /**
     * sUP_SUPPLIERTYPE_ID�� set() ����
     * @param sup_suppliertype_id The sUP_SUPPLIERTYPE_ID to set.
     */
    public void setSUP_SUPPLIERTYPE_ID(long sup_suppliertype_id)
    {
        SUP_SUPPLIERTYPE_ID = sup_suppliertype_id;
    }

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

}