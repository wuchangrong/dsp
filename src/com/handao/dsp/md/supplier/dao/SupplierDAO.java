package com.handao.dsp.md.supplier.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class SupplierDAO extends AFBizDAO {

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "dsp.md.supplier.Supplier";
    }
}