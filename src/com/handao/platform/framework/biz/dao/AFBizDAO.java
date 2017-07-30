package com.handao.platform.framework.biz.dao;

import java.util.List;
import java.util.Map;

import com.handao.platform.framework.dao.AFDAOBase;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.exception.AFDAOException;
import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFBizDAO extends AFDAOBase {

    public static final String SQL_SEARCH_BY_CONDITION = "[search-by-condition]";
    public static final String SQL_INSERT_BY_VO = "[insert-by-vo]";
    public static final String SQL_INSERT_BY_MAP = "[insert-by-map]";
    public static final String SQL_UPDATE_BY_VO = "[update-by-vo]";
    public static final String SQL_UPDATE_BY_MAP = "[update-by-map]";
    public static final String SQL_DELETE_BY_ID = "[delete-by-id]";
    public static final String SQL_DELETE_BY_VO = "[delete-by-vo]";
    public static final String SQL_DELETE_BY_MAP = "[delete-by-map]";
    public static final String SQL_FIND_BY_ID = "[find-by-id]";
    public static final String SQL_FIND_BY_VO = "[find-by-vo]";
    public static final String SQL_FIND_BY_MAP = "[find-by-map]";
    public static final String SQL_SEARCH_BY_MASTER_ID = "[search-by-masterid]";
    public static final String SQL_SEARCH_BY_MASTER_VO = "[search-by-mastervo]";
    public static final String SQL_DELETE_BY_MASTER_ID = "[delete-by-masterid]";
    public static final String SQL_DELETE_BY_MASTER_VO = "[delete-by-mastervo]";

    protected AFLogger logger = AFLogger.getLogger(this.getClass());


    public AFPage doSearchPageByCondition(AFPage page, AFSearchCustomerCondition cc) throws AFDAOException {
        try {
            return daoCommand.sm_searchPage(this.getNameSpace()+"."+SQL_SEARCH_BY_CONDITION, cc, page);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }


    public List doSearchListByCondition(AFSearchCustomerCondition cc) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_CONDITION, cc);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public AFValueObject doFindByVO(AFValueObject vo) throws AFDAOException {
        try {
            return (AFValueObject)daoCommand.sm_find(this.getNameSpace()+"."+SQL_FIND_BY_VO, vo);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public AFValueObject doFindByMap(Map map) throws AFDAOException {
        try {
            return (AFValueObject)daoCommand.sm_find(this.getNameSpace()+"."+SQL_FIND_BY_MAP, map);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }


    public AFValueObject doFindById(long id) throws AFDAOException {
        try {
            return (AFValueObject)daoCommand.sm_find(this.getNameSpace()+"."+SQL_FIND_BY_ID, new Long(id));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }


    public boolean doInsertByVO(AFValueObject vo) throws AFDAOException {
        try {
            return daoCommand.sm_insert(this.getNameSpace()+"."+SQL_INSERT_BY_VO, vo);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public boolean doInsertByMap(Map map) throws AFDAOException {
        try {
            return daoCommand.sm_insert(this.getNameSpace()+"."+SQL_INSERT_BY_MAP, map);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public boolean doUpdateByVO(AFValueObject vo) throws AFDAOException {
        try {
            return daoCommand.sm_update(this.getNameSpace()+"."+SQL_UPDATE_BY_VO, vo);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public boolean doUpdateByMap(Map map) throws AFDAOException {
        try {
            return daoCommand.sm_update(this.getNameSpace()+"."+SQL_UPDATE_BY_MAP, map);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public boolean doDeleteByVO(AFValueObject vo) throws AFDAOException {
        try {
            return daoCommand.sm_delete(this.getNameSpace()+"."+SQL_DELETE_BY_VO, vo);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public boolean doDeleteByMap(Map map) throws AFDAOException {
        try {
            return daoCommand.sm_delete(this.getNameSpace()+"."+SQL_DELETE_BY_MAP, map);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }


    public boolean doDeleteById(long id) throws AFDAOException {
        try {
            return daoCommand.sm_delete(this.getNameSpace()+"."+SQL_DELETE_BY_ID, new Long(id));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }


    public boolean doDeleteByMasterId(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_delete(this.getNameSpace()+"."+SQL_DELETE_BY_MASTER_ID, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public boolean doDeleteByMasterVO(AFValueObject masterVO) throws AFDAOException {
        try {
            return daoCommand.sm_delete(this.getNameSpace()+"."+SQL_DELETE_BY_MASTER_VO, masterVO);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }


    public List doSearchListByMasterId(long masterId) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_MASTER_ID, new Long(masterId));
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }

    public List doSearchListByMasterVO(AFValueObject masterVO) throws AFDAOException {
        try {
            return daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_SEARCH_BY_MASTER_ID, masterVO);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
    protected abstract String getNameSpace();
}