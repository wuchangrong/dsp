package com.handao.dsp.md.directory.direaut.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class DireautDetailVO extends AFValueObject{
    
	private long ROW_ID;  //行号
	private long CREATED_BY;  //创建人
	private Date CREATED_TIME;  //创建时间
	private long LAST_UPD_BY;  //最近修改人
	private Date LAST_UPD_TIME;  //最近修改时间
	private int MODIFICATION_NUM;  //修改次数
	private long DIRECTORY_ID;
	private long ROLE_ID;
	private String RIGHADD = "";
	private String RIGHDEL = "";
	private String RIGHEDI = "";
	private String RIGHVIE = "";
	private String RIGHAUD = "";
	private String ROLE_NAME="";
	
	public long getROW_ID() {
		return ROW_ID;
	}
	public void setROW_ID(long row_id) {
		ROW_ID = row_id;
	}
	public long getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(long created_by) {
		CREATED_BY = created_by;
	}
	public Date getCREATED_TIME() {
		return CREATED_TIME;
	}
	public void setCREATED_TIME(Date created_time) {
		CREATED_TIME = created_time;
	}
	public long getLAST_UPD_BY() {
		return LAST_UPD_BY;
	}
	public void setLAST_UPD_BY(long last_upd_by) {
		LAST_UPD_BY = last_upd_by;
	}
	public Date getLAST_UPD_TIME() {
		return LAST_UPD_TIME;
	}
	public void setLAST_UPD_TIME(Date last_upd_time) {
		LAST_UPD_TIME = last_upd_time;
	}
	public int getMODIFICATION_NUM() {
		return MODIFICATION_NUM;
	}
	public void setMODIFICATION_NUM(int modification_num) {
		MODIFICATION_NUM = modification_num;
	}
	public long getDIRECTORY_ID() {
		return DIRECTORY_ID;
	}
	public void setDIRECTORY_ID(long directory_id) {
		DIRECTORY_ID = directory_id;
	}
	public long getROLE_ID() {
		return ROLE_ID;
	}
	public void setROLE_ID(long role_id) {
		ROLE_ID = role_id;
	}
	public String getRIGHADD() {
		return RIGHADD;
	}
	public void setRIGHADD(String righadd) {
		RIGHADD = righadd;
	}
	public String getRIGHDEL() {
		return RIGHDEL;
	}
	public void setRIGHDEL(String righdel) {
		RIGHDEL = righdel;
	}
	public String getRIGHEDI() {
		return RIGHEDI;
	}
	public void setRIGHEDI(String righedi) {
		RIGHEDI = righedi;
	}
	public String getRIGHVIE() {
		return RIGHVIE;
	}
	public void setRIGHVIE(String righvie) {
		RIGHVIE = righvie;
	}
	public String getRIGHAUD() {
		return RIGHAUD;
	}
	public void setRIGHAUD(String righaud) {
		RIGHAUD = righaud;
	}
	public String getROLE_NAME() {
		return ROLE_NAME;
	}
	public void setROLE_NAME(String role_name) {
		ROLE_NAME = role_name;
	}

}