package com.handao.dsp.md.codelist.service;

import com.handao.dsp.md.codelist.bo.CodelistBO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

public class CodelistService extends AFBizService {

    private CodelistBO bo_Codelist = (CodelistBO)AFBOProvider.getBOByClass("com.handao.dsp.md.codelist.bo.CodelistBO");

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�BO
     * @return EAPBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_Codelist;
    }

}