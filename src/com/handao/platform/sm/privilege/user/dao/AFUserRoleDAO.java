package com.handao.platform.sm.privilege.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;

public class AFUserRoleDAO extends AFBizDAO {

	private static final long serialVersionUID = 1L;
	
	protected String getNameSpace() {
		return "common.sm.privilege.user.UserRole";
	}

	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_SUPER = "[search-by-masterid-whensuper]";
	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_ADMIN = "[search-by-masterid-whenadmin]";
	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_DEBUG = "[search-by-masterid-whendebug]";
	public static final String SQL_SEARCH_BY_MASTER_ID_WHEN_ORDINARY = "[search-by-masterid-whenordinary]";
	public static final String SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_SUPER = "[search-available-by-masterid-whensuper]";
	public static final String SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_ADMIN = "[search-available-by-masterid-whenadmin]";
	public static final String SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_DEBUG = "[search-available-by-masterid-whendebug]";
	public static final String SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_ORDINARY = "[search-available-by-masterid-whenordinary]";
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

	public List doSearchAvailableListByMasterIdWhenSuper(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_SUPER, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenAdmin(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_ADMIN, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenDebug(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_DEBUG, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchAvailableListByMasterIdWhenOrdinary(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_AVRIABLE_BY_MASTER_ID_WHEN_ORDINARY, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	public List doSearchProgramListByRoleIDs(String ids) throws AFDAOException {
        try {
        	Map map=new HashMap();
        	map.put("roleids", ids);
            return daoCommand.sm_searchList(null,this.getNameSpace()+".[search-programs-by-roleids]", map);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }	
}