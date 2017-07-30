package com.handao.dsp.sb.visit.visitplan.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitPlanDAO extends AFBizDAO{

    /**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace(){
        return "dsp.sb.visit.visitplan.VisitPlan";
    }
}