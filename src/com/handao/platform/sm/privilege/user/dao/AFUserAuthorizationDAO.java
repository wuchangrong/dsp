package com.handao.platform.sm.privilege.user.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class AFUserAuthorizationDAO extends AFBizDAO {
	
	private static final long serialVersionUID = 1L;

	/**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "common.sm.privilege.user.UserAuthorization";
    } 

}