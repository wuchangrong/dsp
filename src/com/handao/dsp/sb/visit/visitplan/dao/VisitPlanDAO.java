package com.handao.dsp.sb.visit.visitplan.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitPlanDAO extends AFBizDAO{

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace(){
        return "dsp.sb.visit.visitplan.VisitPlan";
    }
}