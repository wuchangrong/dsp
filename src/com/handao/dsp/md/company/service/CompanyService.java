package com.handao.dsp.md.company.service;

import com.handao.dsp.md.company.bo.CompanyBO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

public class CompanyService extends AFBizService {

    private CompanyBO bo_Company = (CompanyBO)AFBOProvider.getBOByClass("com.handao.dsp.md.company.bo.CompanyBO");

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_Company;
    }

}