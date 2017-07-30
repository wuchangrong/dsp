package com.handao.platform.sm.privilege.role.bo;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.sm.privilege.role.dao.AFRoleProgramDAO;

public class AFRoleProgramBO extends AFBizBO {

	private AFRoleProgramDAO dao_AFRoleProgram = (AFRoleProgramDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.privilege.role.dao.AFRoleProgramDAO");
	protected AFBizDAO getActiveDAO() {
		// TODO Auto-generated method stub
		return dao_AFRoleProgram;
	}

}