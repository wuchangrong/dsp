package com.handao.platform.sm.privilege.role.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.sm.privilege.role.vo.AFRoleProgramVO;

public class AFRoleProgramForm extends AFForm {

	private static final long serialVersionUID = 1L;
	
	private String smrp_ROW_ID;
	private String smrp_ROLE_ID;
	private String smrp_PROGRAM_ID;
	
	public String getSmrp_ROW_ID() {
		return smrp_ROW_ID;
	}

	public void setSmrp_ROW_ID(String smrp_ROW_ID) {
		this.smrp_ROW_ID = smrp_ROW_ID;
	}

	public String getSmrp_ROLE_ID() {
		return smrp_ROLE_ID;
	}

	public void setSmrp_ROLE_ID(String smrp_ROLE_ID) {
		this.smrp_ROLE_ID = smrp_ROLE_ID;
	}

	public String getSmrp_PROGRAM_ID() {
		return smrp_PROGRAM_ID;
	}

	public void setSmrp_PROGRAM_ID(String smrp_PROGRAM_ID) {
		this.smrp_PROGRAM_ID = smrp_PROGRAM_ID;
	}

	public String getFormName() {
		return "SM_PRIVILEGE_ROLE_AFRoleProgramForm";
	}

	protected void initialize() {
		smrp_ROW_ID = "";
		smrp_ROLE_ID = "";
		smrp_PROGRAM_ID = "";
	}

	protected AFValueObject transform() {
		AFRoleProgramVO vo = new AFRoleProgramVO();
		vo.setSmrp_ROW_ID(AFDataFormat.parseString(smrp_ROW_ID, vo.getSmrp_ROW_ID()));
		vo.setSmrp_ROLE_ID(AFDataFormat.parseString(smrp_ROLE_ID, vo.getSmrp_ROLE_ID()));
		vo.setSmrp_PROGRAM_ID(AFDataFormat.parseString(smrp_PROGRAM_ID, vo.getSmrp_PROGRAM_ID()));
		
		return vo;
	}

	protected void transform(AFValueObject vo) {
		AFRoleProgramVO roleProgramVO = (AFRoleProgramVO)vo;
		smrp_ROW_ID = AFDataFormat.toString(roleProgramVO.getSmrp_ROW_ID());
		smrp_ROLE_ID = AFDataFormat.toString(roleProgramVO.getSmrp_ROLE_ID());
		smrp_PROGRAM_ID = AFDataFormat.toString(roleProgramVO.getSmrp_PROGRAM_ID());
	}

}