package com.handao.dsp.md.company.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class CompanyDAO extends AFBizDAO {

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "dsp.md.company.Company";
    }
}