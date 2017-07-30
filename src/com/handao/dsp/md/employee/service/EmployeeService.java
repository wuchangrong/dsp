package com.handao.dsp.md.employee.service;

import com.handao.dsp.md.employee.bo.EmployeeBO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

public class EmployeeService extends AFBizService {

    private EmployeeBO bo_Employee = (EmployeeBO)AFBOProvider.getBOByClass("com.handao.dsp.md.employee.bo.EmployeeBO");

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_Employee;
    }

}