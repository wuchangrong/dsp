package com.handao.dsp.sb.daily.route.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.dsp.sb.daily.route.bo.RouteDailyBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class RouteDailyService extends AFBizService {

   private RouteDailyBO bo_RouteDaily = (RouteDailyBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.sb.daily.route.bo.RouteDailyBO");
    
    /**
     * @desc 返回当前活动BO
     * @return AFBizBO
     * @author liguozhi
     */
    protected AFBizBO getActiveBO(){
        return bo_RouteDaily;
    }
    
	
}