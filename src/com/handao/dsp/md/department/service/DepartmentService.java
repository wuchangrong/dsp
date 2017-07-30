package com.handao.dsp.md.department.service;

import com.handao.dsp.md.department.bo.DepartmentBO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

public class DepartmentService extends AFBizService {

    private DepartmentBO bo_Department = (DepartmentBO)AFBOProvider.getBOByClass("com.handao.dsp.md.department.bo.DepartmentBO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_Department;
    }

}