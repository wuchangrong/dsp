package com.handao.platform.sm.privilege.role.web;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFCompositeForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;
import com.handao.platform.sm.privilege.role.vo.AFRoleVO;

public class AFRoleForm extends AFCompositeForm implements AFSearchOperation {

	private static final long serialVersionUID = 1L;
	
	private String smr_ROW_ID;
	private String smr_COMPANY_ID;
	private String smr_ROLE_CODE;
	private String smr_ROLE_NAME;
	private String smr_ATTR_FLAG;
	private String smr_REMARK;
	private String smr_COMPANY_NAME; 
	private String smr_ROLE_TYPE; 
	
	public AFRoleForm(){
		this.initSearchForm();
	}

	public String getSmr_ROW_ID() {
		return smr_ROW_ID;
	}

	public void setSmr_ROW_ID(String smr_ROW_ID) {
		this.smr_ROW_ID = smr_ROW_ID;
	}

	public String getSmr_COMPANY_ID() {
		return smr_COMPANY_ID;
	}

	public void setSmr_COMPANY_ID(String smr_COMPANY_ID) {
		this.smr_COMPANY_ID = smr_COMPANY_ID;
	}

	public String getSmr_ROLE_CODE() {
		return smr_ROLE_CODE;
	}

	public void setSmr_ROLE_CODE(String smr_ROLE_CODE) {
		this.smr_ROLE_CODE = smr_ROLE_CODE;
	}

	public String getSmr_ROLE_NAME() {
		return smr_ROLE_NAME;
	}

	public void setSmr_ROLE_NAME(String smr_ROLE_NAME) {
		this.smr_ROLE_NAME = smr_ROLE_NAME;
	}

	public String getSmr_ATTR_FLAG() {
		return smr_ATTR_FLAG;
	}

	public void setSmr_ATTR_FLAG(String smr_ATTR_FLAG) {
		this.smr_ATTR_FLAG = smr_ATTR_FLAG;
	}

	public String getSmr_REMARK() {
		return smr_REMARK;
	}

	public void setSmr_REMARK(String smr_REMARK) {
		this.smr_REMARK = smr_REMARK;
	}
	

	public String getSmr_COMPANY_NAME() {
		return smr_COMPANY_NAME;
	}

	public void setSmr_COMPANY_NAME(String smr_COMPANY_NAME) {
		this.smr_COMPANY_NAME = smr_COMPANY_NAME;
	}

	public String getSmr_ROLE_TYPE() {
		return smr_ROLE_TYPE;
	}

	public void setSmr_ROLE_TYPE(String smr_ROLE_TYPE) {
		this.smr_ROLE_TYPE = smr_ROLE_TYPE;
	}

	public List[] getDetailList() {
		return new List[] {dl_AFRoleProgram,dl_AFRoleUser};
	}

	public String getFormName() {
		return "SM_PRIVILEGE_ROLE_AFRoleForm";
	}

	protected void initialize() {
		smr_ROW_ID = "";
		smr_COMPANY_ID = "";
		smr_ROLE_CODE = "";
		smr_ROLE_NAME = "";
		smr_ATTR_FLAG = "";
		smr_REMARK = "";
		smr_COMPANY_NAME = "";
		smr_ROLE_TYPE = "";
	}

	protected AFValueObject transform() {
		AFRoleVO vo = new AFRoleVO();
		vo.setSmr_ROW_ID(AFDataFormat.parseString(smr_ROW_ID, vo.getSmr_ROW_ID()));
		vo.setSmr_COMPANY_ID(AFDataFormat.parseString(smr_COMPANY_ID, vo.getSmr_COMPANY_ID()));
		vo.setSmr_ROLE_CODE(AFDataFormat.parseString(smr_ROLE_CODE, vo.getSmr_ROLE_CODE()));
		vo.setSmr_ROLE_NAME(AFDataFormat.parseString(smr_ROLE_NAME, vo.getSmr_ROLE_NAME()));
		vo.setSmr_ATTR_FLAG(AFDataFormat.parseString(smr_ATTR_FLAG, vo.getSmr_ATTR_FLAG()));
		vo.setSmr_REMARK(AFDataFormat.parseString(smr_REMARK, vo.getSmr_REMARK()));
		vo.setSmr_COMPANY_NAME(AFDataFormat.parseString(smr_COMPANY_NAME, vo.getSmr_COMPANY_NAME()));
		vo.setSmr_ROLE_TYPE(AFDataFormat.parseString(smr_ROLE_TYPE, vo.getSmr_ROLE_TYPE()));
		
		vo.setDl_AFRoleProgram(this.transformDetail(dl_AFRoleProgram));
		vo.setDl_AFRoleUser(this.transformDetail(dl_AFRoleUser));
		return vo;
	}

	protected void transform(AFValueObject vo) {
		AFRoleVO roleVO = (AFRoleVO)vo;
		smr_ROW_ID = AFDataFormat.toString(roleVO.getSmr_ROW_ID());
		smr_COMPANY_ID = AFDataFormat.toString(roleVO.getSmr_COMPANY_ID());
		smr_ROLE_CODE = AFDataFormat.toString(roleVO.getSmr_ROLE_CODE());
		smr_ROLE_NAME = AFDataFormat.toString(roleVO.getSmr_ROLE_NAME());
		smr_ATTR_FLAG = AFDataFormat.toString(roleVO.getSmr_ATTR_FLAG());
		smr_REMARK = AFDataFormat.toString(roleVO.getSmr_REMARK());
		smr_COMPANY_NAME = AFDataFormat.toString(roleVO.getSmr_COMPANY_NAME());
		smr_ROLE_TYPE = AFDataFormat.toString(roleVO.getSmr_ROLE_TYPE());
		
		dl_AFRoleProgram = this.transformDetail(roleVO.getDl_AFRoleProgram(), AFRoleProgramForm.class.getName());
		dl_AFRoleUser = this.transformDetail(roleVO.getDl_AFRoleUser(), AFRoleUserForm.class.getName());
		dl_AFAvailableUser = this.transformDetail(roleVO.getDl_AFAvailableUser(), AFRoleUserForm.class.getName());
	}

	public AFSearchForm getSearchForm() {		
		return searchForm;
	}
	
	private AFRoleSearchForm searchForm = null;
    //≥ı ºªØsearchForm
    public void initSearchForm(){
    	searchForm = new AFRoleSearchForm();
    }
	
	private List dl_AFRoleProgram = new ArrayList();
	private List dl_AFRoleUser = new ArrayList();
	private List dl_AFAvailableUser = new ArrayList();

	public List getDl_AFRoleProgram() {
		return dl_AFRoleProgram;
	}

	public void setDl_AFRoleProgram(List dl_AFRoleProgram) {
		this.dl_AFRoleProgram = dl_AFRoleProgram;
	}

	public List getDl_AFRoleUser() {
		return dl_AFRoleUser;
	}

	public void setDl_AFRoleUser(List dl_AFRoleUser) {
		this.dl_AFRoleUser = dl_AFRoleUser;
	}
	
	
	public List getDl_AFAvailableUser() {
		return dl_AFAvailableUser;
	}

	public void setDl_AFAvailableUser(List dl_AFAvailableUser) {
		this.dl_AFAvailableUser = dl_AFAvailableUser;
	}

	public int getDetailSize_AFRoleProgram() {
        return getDetailSize(dl_AFRoleProgram);
    }
	
	public int getDetailSize_AFRoleUser(){
		return getDetailSize(dl_AFRoleUser);
	}
	
	public int getDetailSize_AFAvailableUser(){
		return getDetailSize(dl_AFAvailableUser);
	}

}