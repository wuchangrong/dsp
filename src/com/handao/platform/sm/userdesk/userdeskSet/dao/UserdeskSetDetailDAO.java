package com.handao.platform.sm.userdesk.userdeskSet.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class UserdeskSetDetailDAO extends AFBizDAO {

    /**
	 * �ֶι�������
	 */
	private static final long serialVersionUID = 1L;

	/**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "common.userdesk.userdeskSet.userdeskSet.UserdeskSetDetail";
    }

}