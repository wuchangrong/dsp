package com.handao.platform.sm.privilege.role.dao;

import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;

public class AFRoleProgramDAO extends AFBizDAO {

	private static final long serialVersionUID = 1L;

	protected String getNameSpace() {
		return "common.sm.privilege.role.RoleProgram";
	}

	public List doSearchTreeListByRoleid(long roleID)
			throws AFDAOException {
		try {
            return daoCommand.sm_searchList(this.getNameSpace()+".[search-programs-by-roleid]", new Long(roleID));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
}