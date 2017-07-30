package com.handao.dsp.md.department.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.web.AFSearchForm;

public class DepartmentSearchForm extends AFSearchForm {

    private String DEPT_DEPT_CODE;  //编码
    private String DEPT_DEPT_NAME;  //名称
    private String DEPT_SHORT_CODE;  //助记码
    private String DEPT_DEFAULT_UNIT;  //单位
    private String DEPT_STATUS;  //状态
    private String DEPT_PARENT_DEPT;

    public String getDEPT_PARENT_DEPT()
	{
		return DEPT_PARENT_DEPT;
	}

	public void setDEPT_PARENT_DEPT(String dept_parent_dept)
	{
		DEPT_PARENT_DEPT = dept_parent_dept;
	}

	public String getDEPT_DEPT_CODE() {
        return DEPT_DEPT_CODE;
    }

    public void setDEPT_DEPT_CODE(String DEPT_DEPT_CODE) {
        this.DEPT_DEPT_CODE = DEPT_DEPT_CODE;
    }

    public String getDEPT_DEPT_NAME() {
        return DEPT_DEPT_NAME;
    }

    public void setDEPT_DEPT_NAME(String DEPT_DEPT_NAME) {
        this.DEPT_DEPT_NAME = DEPT_DEPT_NAME;
    }

    public String getDEPT_SHORT_CODE() {
        return DEPT_SHORT_CODE;
    }

    public void setDEPT_SHORT_CODE(String DEPT_SHORT_CODE) {
        this.DEPT_SHORT_CODE = DEPT_SHORT_CODE;
    }

    public String getDEPT_DEFAULT_UNIT() {
        return DEPT_DEFAULT_UNIT;
    }

    public void setDEPT_DEFAULT_UNIT(String DEPT_DEFAULT_UNIT) {
        this.DEPT_DEFAULT_UNIT = DEPT_DEFAULT_UNIT;
    }

    public String getDEPT_STATUS() {
        return DEPT_STATUS;
    }

    public void setDEPT_STATUS(String DEPT_STATUS) {
        this.DEPT_STATUS = DEPT_STATUS;
    }


    /**
     * [父类抽象方法实现]
     * 把自定义查询条件封装成AFSearchCustomerCondition，并返回
     * 注意 1：需要将查询字段转化为强类型
     * 注意 2：建议使用AFDataFormat类进行数据类型转换
     * @return AFSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("DEPT_DEPT_CODE", DEPT_DEPT_CODE);
        cc.put("DEPT_DEPT_NAME", DEPT_DEPT_NAME);
        cc.put("DEPT_SHORT_CODE", DEPT_SHORT_CODE);
        cc.put("DEPT_DEFAULT_UNIT", DEPT_DEFAULT_UNIT);
        cc.put("DEPT_STATUS", DEPT_STATUS);
        cc.put("DEPT_PARENT_DEPT", DEPT_PARENT_DEPT);
        return cc;
    }


}