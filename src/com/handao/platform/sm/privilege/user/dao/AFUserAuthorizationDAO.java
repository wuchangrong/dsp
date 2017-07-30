package com.handao.platform.sm.privilege.user.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class AFUserAuthorizationDAO extends AFBizDAO {
	
	private static final long serialVersionUID = 1L;

	/**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace() {
        return "common.sm.privilege.user.UserAuthorization";
    } 

}