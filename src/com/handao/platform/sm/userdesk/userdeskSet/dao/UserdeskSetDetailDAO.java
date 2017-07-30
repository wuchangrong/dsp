package com.handao.platform.sm.userdesk.userdeskSet.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class UserdeskSetDetailDAO extends AFBizDAO {

    /**
	 * 字段功能描述
	 */
	private static final long serialVersionUID = 1L;

	/**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace() {
        return "common.userdesk.userdeskSet.userdeskSet.UserdeskSetDetail";
    }

}