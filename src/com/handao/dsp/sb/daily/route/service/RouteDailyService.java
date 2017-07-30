package com.handao.dsp.sb.daily.route.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.dsp.sb.daily.route.bo.RouteDailyBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class RouteDailyService extends AFBizService {

   private RouteDailyBO bo_RouteDaily = (RouteDailyBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.sb.daily.route.bo.RouteDailyBO");
    
    /**
     * @desc ���ص�ǰ�BO
     * @return AFBizBO
     * @author liguozhi
     */
    protected AFBizBO getActiveBO(){
        return bo_RouteDaily;
    }
    
	
}