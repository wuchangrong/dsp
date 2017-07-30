package com.handao.platform.sm.privilege.user.vo;

import com.handao.platform.framework.vo.AFValueObject;

public class AFUserRoleVO extends AFValueObject {

	private static final long serialVersionUID = 1L;
	
	private long smur_ROW_ID; //row_id
	private long smur_USER_ID; //user id
	private long smur_ROLE_ID; // role id
	private String smur_ROLE_NAME; // user name


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

	public String getSmur_ROLE_NAME() {
		return smur_ROLE_NAME;
	}

	public void setSmur_ROLE_NAME(String smur_ROLE_NAME) {
		this.smur_ROLE_NAME = smur_ROLE_NAME;
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
}