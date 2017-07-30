package com.handao.platform.sm.privilege.user.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.sm.privilege.user.vo.AFUserRoleVO;

public class AFUserRoleForm extends AFForm {
	
	private static final long serialVersionUID = 1L;
	
	private String smur_ROW_ID;
	private String smur_USER_ID;
	private String smur_ROLE_ID;
	private String smur_ROLE_NAME;


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
	



	public String getSmur_ROLE_NAME() {
		return smur_ROLE_NAME;
	}

	public void setSmur_ROLE_NAME(String smur_ROLE_NAME) {
		this.smur_ROLE_NAME = smur_ROLE_NAME;
	}

	public String getFormName() {
		return "SM_PRIVILEGE_ROLE_AFRoleUserForm";
	}

	protected void initialize() {
		smur_ROW_ID = "";
		smur_USER_ID = "";
		smur_ROLE_ID = "";
		smur_ROLE_NAME = "";
	}

	protected AFValueObject transform() {
		AFUserRoleVO vo = new AFUserRoleVO();
		vo.setSmur_ROW_ID(AFDataFormat.parseString(smur_ROW_ID, vo.getSmur_ROW_ID()));
		vo.setSmur_USER_ID(AFDataFormat.parseString(smur_USER_ID, vo.getSmur_USER_ID()));
		vo.setSmur_ROLE_ID(AFDataFormat.parseString(smur_ROLE_ID, vo.getSmur_ROLE_ID()));
		vo.setSmur_ROLE_NAME(AFDataFormat.parseString(smur_ROLE_NAME, vo.getSmur_ROLE_NAME()));
		return vo;
	}

	protected void transform(AFValueObject vo) {
		AFUserRoleVO roleUserVO = (AFUserRoleVO)vo;
		smur_ROW_ID = AFDataFormat.toString(roleUserVO.getSmur_ROW_ID());
		smur_USER_ID = AFDataFormat.toString(roleUserVO.getSmur_USER_ID());
		smur_ROLE_ID = AFDataFormat.toString(roleUserVO.getSmur_ROLE_ID());
		smur_ROLE_NAME = AFDataFormat.toString(roleUserVO.getSmur_ROLE_NAME());
	}

}