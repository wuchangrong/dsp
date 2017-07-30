package com.handao.platform.sm.privilege.role.bo;

import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.sm.privilege.role.dao.AFRoleUserDAO;

public class AFRoleUserBO extends AFBizBO {

	private AFRoleUserDAO dao_AFRoleUser = (AFRoleUserDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.privilege.role.dao.AFRoleUserDAO");
	protected AFBizDAO getActiveDAO() {
		// TODO Auto-generated method stub
		return dao_AFRoleUser;
	}

	//2008-12-29 add by hechunjian start
	public List doSearchListByMasterIdWhenSuper(long masterId) throws AFBOException {
        try {
            return ((AFRoleUserDAO)this.getActiveDAO()).doSearchListByMasterIdWhenSuper(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenAdmin(long masterId) throws AFBOException {
        try {
            return ((AFRoleUserDAO)this.getActiveDAO()).doSearchListByMasterIdWhenAdmin(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenDebug(long masterId) throws AFBOException {
        try {
            return ((AFRoleUserDAO)this.getActiveDAO()).doSearchListByMasterIdWhenDebug(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenOrdinary(long masterId) throws AFBOException {
        try {
            return ((AFRoleUserDAO)this.getActiveDAO()).doSearchListByMasterIdWhenOrdinary(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	//2008-12-29 add by hechunjian end
}