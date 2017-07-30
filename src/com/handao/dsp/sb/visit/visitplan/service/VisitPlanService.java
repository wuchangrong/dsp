package com.handao.dsp.sb.visit.visitplan.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.dsp.sb.visit.visitplan.bo.VisitPlanBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitPlanService extends AFBizService {

   private VisitPlanBO bo_VisitPlan = (VisitPlanBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.sb.visit.visitplan.bo.VisitPlanBO");

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO(){
        return bo_VisitPlan;
    }
	
}