package com.handao.dsp.md.employee.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class EmployeeDAO extends AFBizDAO {

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "dsp.md.employee.Employee";
    }
}