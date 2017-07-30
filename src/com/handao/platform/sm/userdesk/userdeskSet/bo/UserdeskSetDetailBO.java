package com.handao.platform.sm.userdesk.userdeskSet.bo;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.sm.userdesk.userdeskSet.dao.UserdeskSetDetailDAO;


public class UserdeskSetDetailBO extends AFBizBO {

    private UserdeskSetDetailDAO dao_UserdeskSetDetail = (UserdeskSetDetailDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.userdesk.userdeskSet.dao.UserdeskSetDetailDAO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动DAO
     * @return AFBizDAO
     */
    protected AFBizDAO getActiveDAO() {
        return dao_UserdeskSetDetail;
    }

}