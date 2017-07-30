package com.handao.dsp.sb.daily.route.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class RouteDailyDAO extends AFBizDAO{

    /**
	 * @desc 返回当前DAO在SQLMap中的命名空间
	 * @return String
	 * @author liguozhi
	 */
    protected String getNameSpace() {
        return "dsp.sb.daily.route.RouteDaily";
    }
    
}