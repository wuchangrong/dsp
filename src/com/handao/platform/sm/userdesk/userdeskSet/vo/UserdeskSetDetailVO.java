package com.handao.platform.sm.userdesk.userdeskSet.vo;


import com.handao.platform.framework.vo.AFValueObject;

public class UserdeskSetDetailVO extends AFValueObject {

    /**
	 * �ֶι�������
	 */
	private static final long serialVersionUID = 1L;
	/*************************************** field ***************************************/
    private long d_ROW_ID;  //ϵͳ�ֶΣ������¼ʱ�Զ����ɣ����ݿ�����ֵΨһ��
    private long d_CREATED_BY;  //ϵͳ�ֶΣ������¼���û�ID��
    private long d_MODULE_ID;  //ģ��ID
    private String d_LABEL="";  //����: �Զ������ʾ���ƣ���ά��ʱʹ��ģ�����ơ�
    private String d_VISIABLE="";  //�Ƿ���ʾ
    private int d_DISP_NO;  //��ʾ˳���: �ڲ����е���ʾ�������ݡ�
    private String d_STATUS="";  //״̬ 0��ͣ��  1������.
    private long d_LAST_UPD_BY;  //ϵͳ�ֶΣ����һ���޸ļ�¼���û�ID��
    private long d_ROLE_ID;  //�û�ID
    private long d_GROUP_ID;  //����ID
    
    
    
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