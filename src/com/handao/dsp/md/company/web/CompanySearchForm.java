package com.handao.dsp.md.company.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.web.AFSearchForm;

public class CompanySearchForm extends AFSearchForm {

    private String CPN_COMPANY_NAME;  

    public String getCPN_COMPANY_NAME() {
        return CPN_COMPANY_NAME;
    }

    public void setCPN_COMPANY_NAME(String CPN_COMPANY_NAME) {
        this.CPN_COMPANY_NAME = CPN_COMPANY_NAME;
    }


    /**
     * [������󷽷�ʵ��]
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("CPN_COMPANY_NAME", CPN_COMPANY_NAME);
        return cc;
    }


}