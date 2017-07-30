package com.handao.dsp.md.supplier.service;

import com.handao.dsp.md.supplier.bo.SupplierBO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

public class SupplierService extends AFBizService {

    private SupplierBO bo_Supplier = (SupplierBO)AFBOProvider.getBOByClass("com.handao.dsp.md.supplier.bo.SupplierBO");

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_Supplier;
    }

}