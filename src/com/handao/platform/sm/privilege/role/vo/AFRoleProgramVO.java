package com.handao.platform.sm.privilege.role.vo;

import com.handao.platform.framework.vo.AFValueObject;

public class AFRoleProgramVO extends AFValueObject {

	private static final long serialVersionUID = 1L;
	
	private long smrp_ROW_ID;  //row id
	private long smrp_ROLE_ID; //role id
	private long smrp_PROGRAM_ID;  //program id
	public long getSmrp_ROW_ID() {
		return smrp_ROW_ID;
	}
	public void setSmrp_ROW_ID(long smrp_ROW_ID) {
		this.smrp_ROW_ID = smrp_ROW_ID;
	}
	public long getSmrp_ROLE_ID() {
		return smrp_ROLE_ID;
	}
	public void setSmrp_ROLE_ID(long smrp_ROLE_ID) {
		this.smrp_ROLE_ID = smrp_ROLE_ID;
	}
	public long getSmrp_PROGRAM_ID() {
		return smrp_PROGRAM_ID;
	}
	public void setSmrp_PROGRAM_ID(long smrp_PROGRAM_ID) {
		this.smrp_PROGRAM_ID = smrp_PROGRAM_ID;
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