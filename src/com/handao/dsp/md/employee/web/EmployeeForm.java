package com.handao.dsp.md.employee.web;

import com.handao.dsp.md.employee.vo.EmployeeVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class EmployeeForm extends AFForm implements AFSearchOperation {

    /*************************************** field ***************************************/
    private String EMP_ADDR;  //地址
    private String EMP_BIRTHDAY;  //出生日期
    private String EMP_COMPANYID;  //公司标识
    private String EMP_CREATED_BY;  //创建人:系统字段。
    private String EMP_CREATED_TIME;  //创建时间:系统字段。
    private String EMP_DEGREE;  //学历
    private String EMP_DEPTID;  //部门标识
    private String EMP_DUTY;  //职务
    private String EMP_EMAIL;  //邮件地址
    private String EMP_EMPLOYEECODE;  //工号:员工代码
    private String EMP_EMPLOYEENAME;  //姓名
    private String EMP_IDCARD;  //身份证号
    private String EMP_LAST_UPD_BY;  //修改人:系统字段。
    private String EMP_LAST_UPD_TIME;  //修改时间:系统字段。
    private String EMP_MODIFICATION_NUM;  //修改次数:系统字段。
    private String EMP_PASSWORD;  //密码
    private String EMP_PLACE;  //岗位
    private String EMP_ROW_ID;  //ROW_ID:系统字段。
    private String EMP_SEX;  //性别
    private String EMP_SHORT_CODE;  //助记码:用于快速代码输入搜索。
    private String EMP_STATUS;  //状态
    private String EMP_TEL;  //电话
    private String EMP_USER_NAME;  //用户名称
    
    private String EMP_PLACE_NAME;
    private String EMP_DEPT_NAME;
    private String EMP_DUTY_NAME;
    private String EMP_COMPANY_NAME;
    private String EMP_DEGREE_NAME;


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

    public String getEMP_BIRTHDAY() {
        return EMP_BIRTHDAY;
    }

    public void setEMP_BIRTHDAY(String EMP_BIRTHDAY) {
        this.EMP_BIRTHDAY = EMP_BIRTHDAY;
    }

    public String getEMP_COMPANYID() {
        return EMP_COMPANYID;
    }

    public void setEMP_COMPANYID(String EMP_COMPANYID) {
        this.EMP_COMPANYID = EMP_COMPANYID;
    }

    public String getEMP_CREATED_BY() {
        return EMP_CREATED_BY;
    }

    public void setEMP_CREATED_BY(String EMP_CREATED_BY) {
        this.EMP_CREATED_BY = EMP_CREATED_BY;
    }

    public String getEMP_CREATED_TIME() {
        return EMP_CREATED_TIME;
    }

    public void setEMP_CREATED_TIME(String EMP_CREATED_TIME) {
        this.EMP_CREATED_TIME = EMP_CREATED_TIME;
    }

    public String getEMP_DEGREE() {
        return EMP_DEGREE;
    }

    public void setEMP_DEGREE(String EMP_DEGREE) {
        this.EMP_DEGREE = EMP_DEGREE;
    }

    public String getEMP_DEPTID() {
        return EMP_DEPTID;
    }

    public void setEMP_DEPTID(String EMP_DEPTID) {
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

    public String getEMP_LAST_UPD_BY() {
        return EMP_LAST_UPD_BY;
    }

    public void setEMP_LAST_UPD_BY(String EMP_LAST_UPD_BY) {
        this.EMP_LAST_UPD_BY = EMP_LAST_UPD_BY;
    }

    public String getEMP_LAST_UPD_TIME() {
        return EMP_LAST_UPD_TIME;
    }

    public void setEMP_LAST_UPD_TIME(String EMP_LAST_UPD_TIME) {
        this.EMP_LAST_UPD_TIME = EMP_LAST_UPD_TIME;
    }

    public String getEMP_MODIFICATION_NUM() {
        return EMP_MODIFICATION_NUM;
    }

    public void setEMP_MODIFICATION_NUM(String EMP_MODIFICATION_NUM) {
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

    public String getEMP_ROW_ID() {
        return EMP_ROW_ID;
    }

    public void setEMP_ROW_ID(String EMP_ROW_ID) {
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

	



    /*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "WMS_BASE_EMPLOYEE_EmployeeForm";
    }

    /**
     * [接口方法实现]
     * 返回查询表单
     * @return AFSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }

    /**
     * [父类抽象方法实现]
     * 根据当前表单生成对应数据对象(VO)
     * 建议使用AFDataFormat.parseString()进行类型转换
     * @return AFValueObject
     */
    public AFValueObject transform() {
        EmployeeVO vo = new EmployeeVO();
        vo.setEMP_ADDR(AFDataFormat.parseString(EMP_ADDR, vo.getEMP_ADDR()));
        vo.setEMP_BIRTHDAY(AFDataFormat.parseString(EMP_BIRTHDAY, vo.getEMP_BIRTHDAY()));
        vo.setEMP_COMPANYID(AFDataFormat.parseString(EMP_COMPANYID, vo.getEMP_COMPANYID()));
        vo.setEMP_CREATED_BY(AFDataFormat.parseString(EMP_CREATED_BY, vo.getEMP_CREATED_BY()));
        vo.setEMP_CREATED_TIME(AFDataFormat.parseString(EMP_CREATED_TIME, vo.getEMP_CREATED_TIME()));
        vo.setEMP_DEGREE(AFDataFormat.parseString(EMP_DEGREE, vo.getEMP_DEGREE()));
        vo.setEMP_DEPTID(AFDataFormat.parseString(EMP_DEPTID, vo.getEMP_DEPTID()));
        vo.setEMP_DUTY(AFDataFormat.parseString(EMP_DUTY, vo.getEMP_DUTY()));
        vo.setEMP_EMAIL(AFDataFormat.parseString(EMP_EMAIL, vo.getEMP_EMAIL()));
        vo.setEMP_EMPLOYEECODE(AFDataFormat.parseString(EMP_EMPLOYEECODE, vo.getEMP_EMPLOYEECODE()));
        vo.setEMP_EMPLOYEENAME(AFDataFormat.parseString(EMP_EMPLOYEENAME, vo.getEMP_EMPLOYEENAME()));
        vo.setEMP_IDCARD(AFDataFormat.parseString(EMP_IDCARD, vo.getEMP_IDCARD()));
        vo.setEMP_LAST_UPD_BY(AFDataFormat.parseString(EMP_LAST_UPD_BY, vo.getEMP_LAST_UPD_BY()));
        vo.setEMP_LAST_UPD_TIME(AFDataFormat.parseString(EMP_LAST_UPD_TIME, vo.getEMP_LAST_UPD_TIME()));
        vo.setEMP_MODIFICATION_NUM(AFDataFormat.parseString(EMP_MODIFICATION_NUM, vo.getEMP_MODIFICATION_NUM()));
        vo.setEMP_PASSWORD(AFDataFormat.parseString(EMP_PASSWORD, vo.getEMP_PASSWORD()));
        vo.setEMP_PLACE(AFDataFormat.parseString(EMP_PLACE, vo.getEMP_PLACE()));
        vo.setEMP_ROW_ID(AFDataFormat.parseString(EMP_ROW_ID, vo.getEMP_ROW_ID()));
        vo.setEMP_SEX(AFDataFormat.parseString(EMP_SEX, vo.getEMP_SEX()));
        vo.setEMP_SHORT_CODE(AFDataFormat.parseString(EMP_SHORT_CODE, vo.getEMP_SHORT_CODE()));
        vo.setEMP_STATUS(AFDataFormat.parseString(EMP_STATUS, vo.getEMP_STATUS()));
        vo.setEMP_TEL(AFDataFormat.parseString(EMP_TEL, vo.getEMP_TEL()));
        vo.setEMP_USER_NAME(AFDataFormat.parseString(EMP_USER_NAME, vo.getEMP_USER_NAME()));

        vo.setEMP_DEPT_NAME(AFDataFormat.parseString(EMP_DEPT_NAME, vo.getEMP_DEPT_NAME()));
        vo.setEMP_PLACE_NAME(AFDataFormat.parseString(EMP_PLACE_NAME, vo.getEMP_PLACE_NAME()));
        vo.setEMP_COMPANY_NAME(AFDataFormat.parseString(EMP_COMPANY_NAME, vo.getEMP_COMPANY_NAME()));
        vo.setEMP_DUTY_NAME(AFDataFormat.parseString(EMP_DUTY_NAME, vo.getEMP_DUTY_NAME()));
        vo.setEMP_DEGREE_NAME(AFDataFormat.parseString(EMP_DEGREE_NAME, vo.getEMP_DEGREE_NAME()));
        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        EmployeeVO vo = (EmployeeVO)_vo;
        EMP_ADDR = AFDataFormat.toString(vo.getEMP_ADDR());
        EMP_BIRTHDAY = AFDataFormat.toString(vo.getEMP_BIRTHDAY());
        EMP_COMPANYID = AFDataFormat.toString(vo.getEMP_COMPANYID());
        EMP_CREATED_BY = AFDataFormat.toString(vo.getEMP_CREATED_BY());
        EMP_CREATED_TIME = AFDataFormat.toString(vo.getEMP_CREATED_TIME());
        EMP_DEGREE = AFDataFormat.toString(vo.getEMP_DEGREE());
        EMP_DEPTID = AFDataFormat.toString(vo.getEMP_DEPTID());
        EMP_DUTY = AFDataFormat.toString(vo.getEMP_DUTY());
        EMP_EMAIL = AFDataFormat.toString(vo.getEMP_EMAIL());
        EMP_EMPLOYEECODE = AFDataFormat.toString(vo.getEMP_EMPLOYEECODE());
        EMP_EMPLOYEENAME = AFDataFormat.toString(vo.getEMP_EMPLOYEENAME());
        EMP_IDCARD = AFDataFormat.toString(vo.getEMP_IDCARD());
        EMP_LAST_UPD_BY = AFDataFormat.toString(vo.getEMP_LAST_UPD_BY());
        EMP_LAST_UPD_TIME = AFDataFormat.toString(vo.getEMP_LAST_UPD_TIME());
        EMP_MODIFICATION_NUM = AFDataFormat.toString(vo.getEMP_MODIFICATION_NUM());
        EMP_PASSWORD = AFDataFormat.toString(vo.getEMP_PASSWORD());
        EMP_PLACE = AFDataFormat.toString(vo.getEMP_PLACE());
        EMP_ROW_ID = AFDataFormat.toString(vo.getEMP_ROW_ID());
        EMP_SEX = AFDataFormat.toString(vo.getEMP_SEX());
        EMP_SHORT_CODE = AFDataFormat.toString(vo.getEMP_SHORT_CODE());
        EMP_STATUS = AFDataFormat.toString(vo.getEMP_STATUS());
        EMP_TEL = AFDataFormat.toString(vo.getEMP_TEL());
        EMP_USER_NAME = AFDataFormat.toString(vo.getEMP_USER_NAME());
        
        EMP_PLACE_NAME = AFDataFormat.toString(vo.getEMP_PLACE_NAME());
        EMP_DEPT_NAME = AFDataFormat.toString(vo.getEMP_DEPT_NAME());
        EMP_DUTY_NAME = AFDataFormat.toString(vo.getEMP_DUTY_NAME());
        EMP_COMPANY_NAME = AFDataFormat.toString(vo.getEMP_COMPANY_NAME());
        EMP_DEGREE_NAME = AFDataFormat.toString(vo.getEMP_DEGREE_NAME());

    }

    /**
     * [父类抽象方法实现]
     * 初始化表单数据
     */
    public void initialize() {
        EMP_ADDR = "";
        EMP_BIRTHDAY = "";
        EMP_COMPANYID = "";
        EMP_CREATED_BY = "";
        EMP_CREATED_TIME = "";
        EMP_DEGREE = "";
        EMP_DEPTID = "";
        EMP_DUTY = "";
        EMP_EMAIL = "";
        EMP_EMPLOYEECODE = "";
        EMP_EMPLOYEENAME = "";
        EMP_IDCARD = "";
        EMP_LAST_UPD_BY = "";
        EMP_LAST_UPD_TIME = "";
        EMP_MODIFICATION_NUM = "";
        EMP_PASSWORD = "";
        EMP_PLACE = "";
        EMP_ROW_ID = "";
        EMP_SEX = "";
        EMP_SHORT_CODE = "";
        EMP_STATUS = "";
        EMP_TEL = "";
        EMP_USER_NAME = "";
        
        EMP_PLACE_NAME = "";
        EMP_DEPT_NAME = "";
        EMP_DUTY_NAME = "";
        EMP_COMPANY_NAME = "";

        EMP_DEGREE_NAME = "";
        
    }

    /*************************************** customer ***************************************/
    private EmployeeSearchForm searchForm = new EmployeeSearchForm();


    public String getEMP_DEGREE_NAME()
    {
        return EMP_DEGREE_NAME;
    }

    public void setEMP_DEGREE_NAME(String emp_degree_name)
    {
        EMP_DEGREE_NAME = emp_degree_name;
    }

	public void initSearchForm() {
        EMP_ADDR = "";
        EMP_BIRTHDAY = "";
        EMP_COMPANYID = "";
        EMP_CREATED_BY = "";
        EMP_CREATED_TIME = "";
        EMP_DEGREE = "";
        EMP_DEPTID = "";
        EMP_DUTY = "";
        EMP_EMAIL = "";
        EMP_EMPLOYEECODE = "";
        EMP_EMPLOYEENAME = "";
        EMP_IDCARD = "";
        EMP_LAST_UPD_BY = "";
        EMP_LAST_UPD_TIME = "";
        EMP_MODIFICATION_NUM = "";
        EMP_PASSWORD = "";
        EMP_PLACE = "";
        EMP_ROW_ID = "";
        EMP_SEX = "";
        EMP_SHORT_CODE = "";
        EMP_STATUS = "";
        EMP_TEL = "";
        EMP_USER_NAME = "";
        
        EMP_PLACE_NAME = "";
        EMP_DEPT_NAME = "";
        EMP_DUTY_NAME = "";
        EMP_COMPANY_NAME = "";

        EMP_DEGREE_NAME = "";
        		
	}

}