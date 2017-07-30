package com.handao.dsp.md.codelist.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.web.AFSearchForm;

public class CodelistSearchForm extends AFSearchForm {

    private String type_TYPE_CODE;  //����
    private String type_TYPE_NAME;  //����
    private String type_STATUS;  //״̬

    public String getType_TYPE_CODE() {
        return type_TYPE_CODE;
    }

    public void setType_TYPE_CODE(String type_TYPE_CODE) {
        this.type_TYPE_CODE = type_TYPE_CODE;
    }

    public String getType_TYPE_NAME() {
        return type_TYPE_NAME;
    }

    public void setType_TYPE_NAME(String type_TYPE_NAME) {
        this.type_TYPE_NAME = type_TYPE_NAME;
    }

    public String getType_STATUS() {
        return type_STATUS;
    }

    public void setType_STATUS(String type_STATUS) {
        this.type_STATUS = type_STATUS;
    }


    /**
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��EAPSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��EAPDataFormat�������������ת��
     * @return EAPSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("type_TYPE_CODE", ("").equals(type_TYPE_CODE)?"":""+type_TYPE_CODE+"%");
        cc.put("type_TYPE_NAME", ("").equals(type_TYPE_NAME)?"":"%"+type_TYPE_NAME+"%");
        cc.put("type_STATUS", type_STATUS);
        return cc;
    }

}