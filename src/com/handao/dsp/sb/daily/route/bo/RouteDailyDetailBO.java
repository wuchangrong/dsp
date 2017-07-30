package com.handao.dsp.sb.daily.route.bo;

import com.handao.dsp.sb.daily.route.dao.RouteDailyDetailDAO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailyDetailBO extends AFBizBO {

    private RouteDailyDetailDAO dao_RouteDailyDetail = (RouteDailyDetailDAO)AFDAOProvider.getDAOByClass(
             "com.handao.dsp.sb.daily.route.dao.RouteDailyDetailDAO");

    /**
	 * @desc 返回当前活动DAO
	 * @param AFUserToken，AFValueObject
	 * @return AFBizDAO
	 * @author liguozhi
	 */
    protected AFBizDAO getActiveDAO(){
        return dao_RouteDailyDetail;
    }
    
}