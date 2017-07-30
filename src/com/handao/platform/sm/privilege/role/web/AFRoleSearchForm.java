package com.handao.platform.sm.privilege.role.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.web.AFSearchForm;

public class AFRoleSearchForm extends AFSearchForm {

	private static final long serialVersionUID = 1L;
	
	private String smr_COMPANY_ID;
	private String smr_ROLE_CODE;
	private String smr_ROLE_NAME;	
	
	public String getSmr_COMPANY_ID() {
		return smr_COMPANY_ID;
	}


	public void setSmr_COMPANY_ID(String smr_COMPANY_ID) {
		this.smr_COMPANY_ID = smr_COMPANY_ID;
	}
	public String getSmr_ROLE_CODE() {
		return smr_ROLE_CODE;
	}


	public void setSmr_ROLE_CODE(String smrROLECODE) {
		smr_ROLE_CODE = smrROLECODE;
	}


	public String getSmr_ROLE_NAME() {
		return smr_ROLE_NAME;
	}


	public void setSmr_ROLE_NAME(String smrROLENAME) {
		smr_ROLE_NAME = smrROLENAME;
	}



	protected AFSearchCustomerCondition getCustomCondition() {
		AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("smr_COMPANY_ID", smr_COMPANY_ID);
        cc.put("smr_ROLE_CODE", smr_ROLE_CODE);
        cc.put("smr_ROLE_NAME", smr_ROLE_NAME);
        
        return cc;
	}

}