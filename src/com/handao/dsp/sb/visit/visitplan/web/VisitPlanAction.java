package com.handao.dsp.sb.visit.visitplan.web;

import com.handao.platform.framework.biz.web.AFBizAction;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class VisitPlanAction extends AFBizAction{
	
	protected String getServiceName(){
        return "com.handao.dsp.sb.visit.visitplan.service.VisitPlanService";
    }
}