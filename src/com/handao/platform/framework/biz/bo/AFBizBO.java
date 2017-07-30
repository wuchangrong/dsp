package com.handao.platform.framework.biz.bo;

import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.bo.AFBusinessObject;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFBizBO extends AFBusinessObject {

    protected AFBizBOListener listener = null;

    protected AFLogger logger = AFLogger.getLogger(this.getClass());

    public void addListener(AFBizBOListener listener) {
        this.listener = listener;
    }

    protected boolean doOperationByVOStatus(AFBizBO bo, AFUserToken userToken, List list) {
        boolean result = true;
        if(list!=null && list.size()!=0) {
            for(int i=0; i<list.size(); i++) {
                AFValueObject vo = (AFValueObject)list.get(i);
                switch (vo.getVOStatus()) {
                    case AFValueObject.STATUS_DELETE: result = bo.doDelete(userToken, vo);
                        break;
                    case AFValueObject.STATUS_MODIFY: result = bo.doUpdate(userToken, vo);
                        break;
                    case AFValueObject.STATUS_NEW: result = bo.doInsert(userToken, vo);
                        break;
                }
                if(!result)
                    return result;
            }
        }
        return result;
    }


    public boolean doInsert(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeInsert(userToken, vo);

            if(result)
                result = this.getActiveDAO().doInsertByVO(vo);

            if(result && listener!=null)
                result = listener.afterInsert(userToken, vo);

            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    public boolean doInsert(AFUserToken userToken, List list) throws AFBOException {
        try{
            boolean result = true;
            if(list!=null && list.size()!=0) {
                for(int i=0; i<list.size(); i++) {
                    AFValueObject vo = (AFValueObject)list.get(i);
                    result = doInsert(userToken, vo);
                    if(!result)
                        return result;
                }
            }
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    public boolean doUpdate(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeUpdate(userToken, vo);

            if(result)
                result = this.getActiveDAO().doUpdateByVO(vo);

            if(result && listener!=null)
                result = listener.afterUpdate(userToken, vo);

            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }


    public boolean doDelete(AFUserToken userToken, long[] idList) throws AFBOException {
        boolean result = false;
        try {
            for(int i = 0; i<idList.length; i++) {
                result = this.doDelete(userToken, idList[i]);
                if(!result)
                    return false;
            }
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }

        return result;
    }



    public boolean doDelete(AFUserToken userToken, long id) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeDelete(userToken, id);

            if(result)
                result = this.getActiveDAO().doDeleteById(id);

            if(result && listener != null)
                result = listener.afterDelete(userToken, id);

            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    private boolean doDelete(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            return this.getActiveDAO().doDeleteByVO(vo);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }


    public AFValueObject doFind(AFUserToken userToken, long id) throws AFBOException {
        try {
            if(listener != null)
                listener.beforeFind(userToken, id);
            AFValueObject vo = this.getActiveDAO().doFindById(id);

            if(listener != null)
                listener.afterFind(userToken, id, vo);
            return vo;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    public AFPage doSearchPage(AFUserToken userToken, AFSearchCondition sc, AFPage page) throws AFBOException {
        try {
            if(listener != null)
                listener.beforeSearch(userToken, sc);
            AFPage result = this.getActiveDAO().doSearchPageByCondition(page, sc.getCustomerCondition());
            if(listener != null)
                listener.afterSearch(userToken, sc, page);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    public boolean doDeleteByMaster(long masterId) throws AFBOException {
        try {
            return this.getActiveDAO().doDeleteByMasterId(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    public List doSearchByMaster(long masterId) throws AFBOException {
        try {
            return this.getActiveDAO().doSearchListByMasterId(masterId);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    public List doSearchByMaster(AFValueObject masterVO) throws AFBOException {
        try {
            return this.getActiveDAO().doSearchListByMasterVO(masterVO);
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
    
    protected abstract AFBizDAO getActiveDAO();
}