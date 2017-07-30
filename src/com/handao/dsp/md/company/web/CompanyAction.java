package com.handao.dsp.md.company.web;

import com.handao.platform.framework.biz.web.AFBizAction;

public class CompanyAction extends AFBizAction {

    /**
     * [父类抽象方法实现]
     * 返回Service的ClassName
     * @return String
     */
    protected String getServiceName() {
        return "com.handao.dsp.md.company.service.CompanyService";
    }
}