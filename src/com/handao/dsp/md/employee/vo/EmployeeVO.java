package com.handao.dsp.md.employee.vo;

import java.sql.Date;

import com.handao.platform.framework.vo.AFValueObject;

public class EmployeeVO extends AFValueObject {

    /*************************************** field ***************************************/
    private String EMP_ADDR;  //��ַ
    private Date EMP_BIRTHDAY;  //��������
    private long EMP_COMPANYID;  //��˾��ʶ
    private long EMP_CREATED_BY;  //������:ϵͳ�ֶΡ�
    private Date EMP_CREATED_TIME;  //����ʱ��:ϵͳ�ֶΡ�
    private String EMP_DEGREE;  //ѧ��
    private long EMP_DEPTID;  //���ű�ʶ
    private String EMP_DUTY;  //ְ��
    private String EMP_EMAIL;  //�ʼ���ַ
    private String EMP_EMPLOYEECODE;  //����:Ա������
    private String EMP_EMPLOYEENAME;  //����
    private String EMP_IDCARD;  //���֤��
    private long EMP_LAST_UPD_BY;  //�޸���:ϵͳ�ֶΡ�
    private Date EMP_LAST_UPD_TIME;  //�޸�ʱ��:ϵͳ�ֶΡ�
    private int EMP_MODIFICATION_NUM;  //�޸Ĵ���:ϵͳ�ֶΡ�
    private String EMP_PASSWORD;  //����
    private String EMP_PLACE;  //��λ
    private long EMP_ROW_ID;  //ROW_ID:ϵͳ�ֶΡ�
    private String EMP_SEX;  //�Ա�
    private String EMP_SHORT_CODE;  //������:���ڿ��ٴ�������������
    private String EMP_STATUS;  //״̬
    private String EMP_TEL;  //�绰
    private String EMP_USER_NAME;  //�û�����
    
    private String EMP_PLACE_NAME;
    private String EMP_DEPT_NAME;
    private String EMP_DUTY_NAME;
    private String EMP_COMPANY_NAME;
    private String EMP_DEGREE_NAME;

    public String getEMP_DEGREE_NAME()
    {
        return EMP_DEGREE_NAME;
    }

    public void setEMP_DEGREE_NAME(String emp_degree_name)
    {
        EMP_DEGREE_NAME = emp_degree_name;
    }

    public String getEMP_COMPANY_NAME()
    {
        return EMP_COMPANY_NAME;
    }

    public void setEMP_COMPANY_NAME(String emp_company_name)
    {
        EMP_COMPANY_NAME = emp_company_name;
    }

    public String getEMP_DUTY_NAME()
    {
        return EMP_DUTY_NAME;
    }

    public void setEMP_DUTY_NAME(String emp_duty_name)
    {
        EMP_DUTY_NAME = emp_duty_name;
    }

    public String getEMP_DEPT_NAME()
    {
        return EMP_DEPT_NAME;
    }

    public void setEMP_DEPT_NAME(String emp_dept_name)
    {
        EMP_DEPT_NAME = emp_dept_name;
    }

    public String getEMP_PLACE_NAME()
    {
        return EMP_PLACE_NAME;
    }

    public void setEMP_PLACE_NAME(String emp_place_name)
    {
        EMP_PLACE_NAME = emp_place_name;
    }

    public String getEMP_ADDR() {
        return EMP_ADDR;
    }

    public void setEMP_ADDR(String EMP_ADDR) {
        this.EMP_ADDR = EMP_ADDR;
    }

    public Date getEMP_BIRTHDAY() {
        return EMP_BIRTHDAY;
    }

    public void setEMP_BIRTHDAY(Date EMP_BIRTHDAY) {
        this.EMP_BIRTHDAY = EMP_BIRTHDAY;
    }

    public long getEMP_COMPANYID() {
        return EMP_COMPANYID;
    }

    public void setEMP_COMPANYID(long EMP_COMPANYID) {
        this.EMP_COMPANYID = EMP_COMPANYID;
    }

    public long getEMP_CREATED_BY() {
        return EMP_CREATED_BY;
    }

    public void setEMP_CREATED_BY(long EMP_CREATED_BY) {
        this.EMP_CREATED_BY = EMP_CREATED_BY;
    }

    public Date getEMP_CREATED_TIME() {
        return EMP_CREATED_TIME;
    }

    public void setEMP_CREATED_TIME(Date EMP_CREATED_TIME) {
        this.EMP_CREATED_TIME = EMP_CREATED_TIME;
    }

    public String getEMP_DEGREE() {
        return EMP_DEGREE;
    }

    public void setEMP_DEGREE(String EMP_DEGREE) {
        this.EMP_DEGREE = EMP_DEGREE;
    }

    public long getEMP_DEPTID() {
        return EMP_DEPTID;
    }

    public void setEMP_DEPTID(long EMP_DEPTID) {
        this.EMP_DEPTID = EMP_DEPTID;
    }

    public String getEMP_DUTY() {
        return EMP_DUTY;
    }

    public void setEMP_DUTY(String EMP_DUTY) {
        this.EMP_DUTY = EMP_DUTY;
    }

    public String getEMP_EMAIL() {
        return EMP_EMAIL;
    }

    public void setEMP_EMAIL(String EMP_EMAIL) {
        this.EMP_EMAIL = EMP_EMAIL;
    }

    public String getEMP_EMPLOYEECODE() {
        return EMP_EMPLOYEECODE;
    }

    public void setEMP_EMPLOYEECODE(String EMP_EMPLOYEECODE) {
        this.EMP_EMPLOYEECODE = EMP_EMPLOYEECODE;
    }

    public String getEMP_EMPLOYEENAME() {
        return EMP_EMPLOYEENAME;
    }

    public void setEMP_EMPLOYEENAME(String EMP_EMPLOYEENAME) {
        this.EMP_EMPLOYEENAME = EMP_EMPLOYEENAME;
    }

    public String getEMP_IDCARD() {
        return EMP_IDCARD;
    }

    public void setEMP_IDCARD(String EMP_IDCARD) {
        this.EMP_IDCARD = EMP_IDCARD;
    }

    public long getEMP_LAST_UPD_BY() {
        return EMP_LAST_UPD_BY;
    }

    public void setEMP_LAST_UPD_BY(long EMP_LAST_UPD_BY) {
        this.EMP_LAST_UPD_BY = EMP_LAST_UPD_BY;
    }

    public Date getEMP_LAST_UPD_TIME() {
        return EMP_LAST_UPD_TIME;
    }

    public void setEMP_LAST_UPD_TIME(Date EMP_LAST_UPD_TIME) {
        this.EMP_LAST_UPD_TIME = EMP_LAST_UPD_TIME;
    }

    public int getEMP_MODIFICATION_NUM() {
        return EMP_MODIFICATION_NUM;
    }

    public void setEMP_MODIFICATION_NUM(int EMP_MODIFICATION_NUM) {
        this.EMP_MODIFICATION_NUM = EMP_MODIFICATION_NUM;
    }

    public String getEMP_PASSWORD() {
        return EMP_PASSWORD;
    }

    public void setEMP_PASSWORD(String EMP_PASSWORD) {
        this.EMP_PASSWORD = EMP_PASSWORD;
    }

    public String getEMP_PLACE() {
        return EMP_PLACE;
    }

    public void setEMP_PLACE(String EMP_PLACE) {
        this.EMP_PLACE = EMP_PLACE;
    }

    public long getEMP_ROW_ID() {
        return EMP_ROW_ID;
    }

    public void setEMP_ROW_ID(long EMP_ROW_ID) {
        this.EMP_ROW_ID = EMP_ROW_ID;
    }

    public String getEMP_SEX() {
        return EMP_SEX;
    }

    public void setEMP_SEX(String EMP_SEX) {
        this.EMP_SEX = EMP_SEX;
    }

    public String getEMP_SHORT_CODE() {
        return EMP_SHORT_CODE;
    }

    public void setEMP_SHORT_CODE(String EMP_SHORT_CODE) {
        this.EMP_SHORT_CODE = EMP_SHORT_CODE;
    }

    public String getEMP_STATUS() {
        return EMP_STATUS;
    }

    public void setEMP_STATUS(String EMP_STATUS) {
        this.EMP_STATUS = EMP_STATUS;
    }

    public String getEMP_TEL() {
        return EMP_TEL;
    }

    public void setEMP_TEL(String EMP_TEL) {
        this.EMP_TEL = EMP_TEL;
    }

    public String getEMP_USER_NAME() {
        return EMP_USER_NAME;
    }

    public void setEMP_USER_NAME(String EMP_USER_NAME) {
        this.EMP_USER_NAME = EMP_USER_NAME;
    }


}