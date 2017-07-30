package com.handao.platform.sm.login.vo;

import com.handao.platform.framework.vo.AFValueObject;

public class UserVO extends AFValueObject{
	
	private static final long serialVersionUID = 1L;
	
	private int row_id;  //ROW_ID
	private String user_code;  //�û�����
	private String user_name;  //�û�����
	private String password;   //�û�����
	private String attr_flag;  //�������Ա�־
	private int company_id;  //��˾ID
    private int division_id;
	private int person_id;  //��ԱID
    private String resultFlag;//�������־���û�����֤����֤���
    private String resultMsg;//���ؽ����Ϣ
    //
    private String company_name;//��˾����

	public int getRow_id() {
		return row_id;
	}
	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAttr_flag() {
		return attr_flag;
	}
	public void setAttr_flag(String attr_flag) {
		this.attr_flag = attr_flag;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getDivision_id() {
		return division_id;
	}
	public void setDivision_id(int division_id) {
		this.division_id = division_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getResultFlag() {
		return resultFlag;
	}
	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
}