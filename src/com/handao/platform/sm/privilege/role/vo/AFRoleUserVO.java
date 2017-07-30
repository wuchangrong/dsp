package com.handao.platform.sm.privilege.role.vo;

import com.handao.platform.framework.vo.AFValueObject;

public class AFRoleUserVO extends AFValueObject {

	private static final long serialVersionUID = 1L;
	
	private long smur_ROW_ID;  //row id
	private long smur_USER_ID; //user id
	private long smur_ROLE_ID; //role id
	private String smur_USER_NAME;  //user name 
	private String smur_COMPANY_ID;
	
	public String getSmur_COMPANY_ID() {
		return smur_COMPANY_ID;
	}
	public void setSmur_COMPANY_ID(String smurCOMPANYID) {
		smur_COMPANY_ID = smurCOMPANYID;
	}
	public long getSmur_ROW_ID() {
		return smur_ROW_ID;
	}
	public void setSmur_ROW_ID(long smur_ROW_ID) {
		this.smur_ROW_ID = smur_ROW_ID;
	}
	public long getSmur_USER_ID() {
		return smur_USER_ID;
	}
	public void setSmur_USER_ID(long smur_USER_ID) {
		this.smur_USER_ID = smur_USER_ID;
	}
	public long getSmur_ROLE_ID() {
		return smur_ROLE_ID;
	}
	public void setSmur_ROLE_ID(long smur_ROLE_ID) {
		this.smur_ROLE_ID = smur_ROLE_ID;
	}
	private long _userID = -1;
    private long _langID = -1;
    private String _originFlag = "1";
    private String _originApp = "UniAF";
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
	public String getSmur_USER_NAME() {
		return smur_USER_NAME;
	}
	public void setSmur_USER_NAME(String smur_USER_NAME) {
		this.smur_USER_NAME = smur_USER_NAME;
	}
    
}