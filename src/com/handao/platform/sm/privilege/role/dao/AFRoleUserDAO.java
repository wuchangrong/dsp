package com.handao.platform.sm.privilege.role.dao;

import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;

public class AFRoleUserDAO extends AFBizDAO {

	private static final long serialVersionUID = 1L;
	
	protected String getNameSpace() {
		return "common.sm.privilege.role.RoleUser";
	}

	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_SUPER = "[search-by-masterid-whensuper]";
	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_ADMIN = "[search-by-masterid-whenadmin]";
	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_DEBUG = "[search-by-masterid-whendebug]";
	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_ORDINARY = "[search-by-masterid-whenordinary]";
	public List doSearchListByMasterIdWhenSuper(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_MASTER_ID_WHEN_SUPER, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenAdmin(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_MASTER_ID_WHEN_ADMIN, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenDebug(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_MASTER_ID_WHEN_DEBUG, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchListByMasterIdWhenOrdinary(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_MASTER_ID_WHEN_ORDINARY, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
}