package com.handao.platform.sm.userdesk.userdeskSet.vo;


import com.handao.platform.framework.vo.AFValueObject;

public class UserdeskSetDetailVO extends AFValueObject {

    /**
	 * 字段功能描述
	 */
	private static final long serialVersionUID = 1L;
	/*************************************** field ***************************************/
    private long d_ROW_ID;  //系统字段，插入记录时自动生成，数据库中数值唯一。
    private long d_CREATED_BY;  //系统字段，插入记录的用户ID。
    private long d_MODULE_ID;  //模块ID
    private String d_LABEL="";  //标题: 自定义的显示名称，不维护时使用模块名称。
    private String d_VISIABLE="";  //是否显示
    private int d_DISP_NO;  //显示顺序号: 在布局中的显示排序依据。
    private String d_STATUS="";  //状态 0：停用  1：启用.
    private long d_LAST_UPD_BY;  //系统字段，最后一次修改记录的用户ID。
    private long d_ROLE_ID;  //用户ID
    private long d_GROUP_ID;  //分组ID
    
    
    
	public long getD_ROW_ID() {
		return d_ROW_ID;
	}
	public void setD_ROW_ID(long d_row_id) {
		d_ROW_ID = d_row_id;
	}
	public long getD_CREATED_BY() {
		return d_CREATED_BY;
	}
	public void setD_CREATED_BY(long d_created_by) {
		d_CREATED_BY = d_created_by;
	}
	public long getD_MODULE_ID() {
		return d_MODULE_ID;
	}
	public void setD_MODULE_ID(long d_module_id) {
		d_MODULE_ID = d_module_id;
	}
	public String getD_LABEL() {
		return d_LABEL;
	}
	public void setD_LABEL(String d_label) {
		d_LABEL = d_label;
	}
	public String getD_VISIABLE() {
		return d_VISIABLE;
	}
	public void setD_VISIABLE(String d_visiable) {
		d_VISIABLE = d_visiable;
	}
	public int getD_DISP_NO() {
		return d_DISP_NO;
	}
	public void setD_DISP_NO(int d_disp_no) {
		d_DISP_NO = d_disp_no;
	}
	public String getD_STATUS() {
		return d_STATUS;
	}
	public void setD_STATUS(String d_status) {
		d_STATUS = d_status;
	}
	public long getD_LAST_UPD_BY() {
		return d_LAST_UPD_BY;
	}
	public void setD_LAST_UPD_BY(long d_last_upd_by) {
		d_LAST_UPD_BY = d_last_upd_by;
	}
	public long getD_ROLE_ID() {
		return d_ROLE_ID;
	}
	public void setD_ROLE_ID(long d_role_id) {
		d_ROLE_ID = d_role_id;
	}
	public long getD_GROUP_ID() {
		return d_GROUP_ID;
	}
	public void setD_GROUP_ID(long d_group_id) {
		d_GROUP_ID = d_group_id;
	}

    

}