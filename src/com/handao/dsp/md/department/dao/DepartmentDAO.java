package com.handao.dsp.md.department.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class DepartmentDAO extends AFBizDAO {

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "dsp.md.department.Department";
    }
}