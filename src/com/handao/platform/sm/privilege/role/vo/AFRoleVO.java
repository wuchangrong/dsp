package com.handao.platform.sm.privilege.role.vo;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.vo.AFCompositeValueObject;

public class AFRoleVO extends AFCompositeValueObject {

	private static final long serialVersionUID = 1L;
	
	private long smr_ROW_ID;  //row id
	private long smr_COMPANY_ID;  //company id
	private String smr_ROLE_CODE; //role code
	private String smr_ROLE_NAME; //role name
	private String smr_ATTR_FLAG; //attribute flag
	private String smr_REMARK;  //remark
	private String smr_COMPANY_NAME;  //company name
	//private String smr_ROLE_TYPE;  //role class
	
	public long getSmr_ROW_ID() {
		return smr_ROW_ID;
	}

	public void setSmr_ROW_ID(long smr_ROW_ID) {
		this.smr_ROW_ID = smr_ROW_ID;
	}

	public long getSmr_COMPANY_ID() {
		return smr_COMPANY_ID;
	}

	public void setSmr_COMPANY_ID(long smr_COMPANY_ID) {
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
		if("0".equals(smr_ATTR_FLAG)){
			return "普通角色";
		}else if("1".equals(smr_ATTR_FLAG)){
			return "系统管理角色";
		}else{
			return "";
		}
	}

	public void setSmr_ROLE_TYPE(String smr_ROLE_TYPE) {
		//this.smr_ROLE_TYPE = smr_ROLE_TYPE;
	}

	public List[] getDetailList() {
		return new List[] {dl_AFRoleProgram,dl_AFRoleUser};
	}

	public void setDetailList(String detailVOClass, List list) {
		if(AFRoleProgramVO.class.getName().equals(detailVOClass)) {
			dl_AFRoleProgram = list;
            return;
        }else if(AFRoleUserVO.class.getName().equals(detailVOClass)){
        	dl_AFRoleUser = list;
            return;
        }
	}
	
	private List dl_AFRoleProgram = new ArrayList();
	private List dl_AFRoleUser = new ArrayList();
	private List dl_AFAvailableUser = new ArrayList();  //可选用户

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
	
	private long _userID = -1;
    private long _langID = -1;
    private String _originFlag = "1";
    private String _originApp = "sys";

	public long get_userID() {
		return _userID;
	}

	public void set_userID(long _userid) {
		_userID = _userid;
	}

	public long get_langID() {
		return _langID;
	}

	public void set_langID(long _langid) {
		_langID = _langid;
	}

	public String get_originFlag() {
		return _originFlag;
	}

	public void set_originFlag(String flag) {
		_originFlag = flag;
	}

	public String get_originApp() {
		return _originApp;
	}

	public void set_originApp(String app) {
		_originApp = app;
	}
    
}