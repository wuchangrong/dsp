package com.handao.dsp.md.supplier.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

public class SupplierSearchForm extends AFSearchForm {

    private String SUP_DISTRICTID;  //������ʶ
    private String SUP_PROVINCEID;  //ʡ�ݱ�ʶ

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
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��AFSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��AFDataFormat�������������ת��
     * @return AFSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("SUP_DISTRICTID", AFDataFormat.toInt(SUP_DISTRICTID));
        cc.put("SUP_PROVINCEID", AFDataFormat.toInt(SUP_PROVINCEID));
        return cc;
    }


}