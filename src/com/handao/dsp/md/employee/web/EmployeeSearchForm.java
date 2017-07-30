package com.handao.dsp.md.employee.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.web.AFSearchForm;

public class EmployeeSearchForm extends AFSearchForm {

    /**
     * <p>Discription:[�ֶι�������]</p>
     */
    private static final long serialVersionUID = -1812893928640606008L;
    private String EMP_EMPLOYEECODE;  //��������
    private String EMP_EMPLOYEENAME;
    private String EMP_DEPT_ID;
    private String EMP_PLACE;
 

 


    public String getEMP_DEPT_ID()
    {
        return EMP_DEPT_ID;
    }


    public void setEMP_DEPT_ID(String emp_dept_id)
    {
        EMP_DEPT_ID = emp_dept_id;
    }


    public String getEMP_EMPLOYEECODE()
    {
        return EMP_EMPLOYEECODE;
    }


    public void setEMP_EMPLOYEECODE(String emp_employeecode)
    {
        EMP_EMPLOYEECODE = emp_employeecode;
    }


    public String getEMP_EMPLOYEENAME()
    {
        return EMP_EMPLOYEENAME;
    }


    public void setEMP_EMPLOYEENAME(String emp_employeename)
    {
        EMP_EMPLOYEENAME = emp_employeename;
    }



    public String getEMP_PLACE()
    {
        return EMP_PLACE;
    }


    public void setEMP_PLACE(String emp_place)
    {
        EMP_PLACE = emp_place;
    }


    /**
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��AFSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��AFDataFormat�������������ת��
     * @return AFSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("EMP_EMPLOYEECODE", EMP_EMPLOYEECODE);
        cc.put("EMP_EMPLOYEENAME", EMP_EMPLOYEENAME);
        cc.put("EMP_DEPT_ID", EMP_DEPT_ID);
        cc.put("EMP_PLACE", EMP_PLACE);
        return cc;
    }


}