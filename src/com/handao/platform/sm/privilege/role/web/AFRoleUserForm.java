package com.handao.platform.sm.privilege.role.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.sm.privilege.role.vo.AFRoleUserVO;

public class AFRoleUserForm extends AFForm {

	private static final long serialVersionUID = 1L;
	
	private String smur_ROW_ID;
	private String smur_USER_ID;
	private String smur_ROLE_ID;
	private String smur_USER_NAME;
	private String smur_COMPANY_ID;
	
	public String getSmur_COMPANY_ID() {
		return smur_COMPANY_ID;
	}

	public void setSmur_COMPANY_ID(String smurCOMPANYID) {
		smur_COMPANY_ID = smurCOMPANYID;
	}

	public String getSmur_ROW_ID() {
		return smur_ROW_ID;
	}

	public void setSmur_ROW_ID(String smur_ROW_ID) {
		this.smur_ROW_ID = smur_ROW_ID;
	}

	public String getSmur_USER_ID() {
		return smur_USER_ID;
	}

	public void setSmur_USER_ID(String smur_USER_ID) {
		this.smur_USER_ID = smur_USER_ID;
	}

	public String getSmur_ROLE_ID() {
		return smur_ROLE_ID;
	}

	public void setSmur_ROLE_ID(String smur_ROLE_ID) {
		this.smur_ROLE_ID = smur_ROLE_ID;
	}
	

	public String getSmur_USER_NAME() {
		return smur_USER_NAME;
	}

	public void setSmur_USER_NAME(String smur_USER_NAME) {
		this.smur_USER_NAME = smur_USER_NAME;
	}

	public String getFormName() {
		return "SM_PRIVILEGE_ROLE_AFRoleUserForm";
	}

	protected void initialize() {
		smur_ROW_ID = "";
		smur_USER_ID = "";
		smur_ROLE_ID = "";
		smur_USER_NAME = "";
		smur_COMPANY_ID = "";
	}

	protected AFValueObject transform() {
		AFRoleUserVO vo = new AFRoleUserVO();
		vo.setSmur_ROW_ID(AFDataFormat.parseString(smur_ROW_ID, vo.getSmur_ROW_ID()));
		vo.setSmur_USER_ID(AFDataFormat.parseString(smur_USER_ID, vo.getSmur_USER_ID()));
		vo.setSmur_ROLE_ID(AFDataFormat.parseString(smur_ROLE_ID, vo.getSmur_ROLE_ID()));
		vo.setSmur_USER_NAME(AFDataFormat.parseString(smur_USER_NAME, vo.getSmur_USER_NAME()));
		vo.setSmur_COMPANY_ID(AFDataFormat.parseString(smur_COMPANY_ID, vo.getSmur_COMPANY_ID()));
		return vo;
	}

	protected void transform(AFValueObject vo) {
		AFRoleUserVO roleUserVO = (AFRoleUserVO)vo;
		smur_ROW_ID = AFDataFormat.toString(roleUserVO.getSmur_ROW_ID());
		smur_USER_ID = AFDataFormat.toString(roleUserVO.getSmur_USER_ID());
		smur_ROLE_ID = AFDataFormat.toString(roleUserVO.getSmur_ROLE_ID());
		smur_USER_NAME = AFDataFormat.toString(roleUserVO.getSmur_USER_NAME());
		smur_COMPANY_ID = AFDataFormat.toString(roleUserVO.getSmur_COMPANY_ID());
	}

}