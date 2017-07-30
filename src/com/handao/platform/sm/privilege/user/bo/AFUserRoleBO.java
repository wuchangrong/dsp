package com.handao.platform.sm.privilege.user.bo;

import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.sm.privilege.user.dao.AFUserRoleDAO;

public class AFUserRoleBO extends AFBizBO {

	private AFUserRoleDAO dao_AFUserRole = (AFUserRoleDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.privilege.user.dao.AFUserRoleDAO");
	protected AFBizDAO getActiveDAO() {
		return dao_AFUserRole;
	}

	public List doSearchListByMasterIdWhenSuper(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchListByMasterIdWhenSuper(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenAdmin(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchListByMasterIdWhenAdmin(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenDebug(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchListByMasterIdWhenDebug(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenOrdinary(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchListByMasterIdWhenOrdinary(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenSuper(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchAvailableListByMasterIdWhenSuper(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenAdmin(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchAvailableListByMasterIdWhenAdmin(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenDebug(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchAvailableListByMasterIdWhenDebug(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenOrdinary(long masterId) throws AFBOException {
        try {
            return ((AFUserRoleDAO)this.getActiveDAO()).doSearchAvailableListByMasterIdWhenOrdinary(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
}