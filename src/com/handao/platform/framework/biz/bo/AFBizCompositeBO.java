package com.handao.platform.framework.biz.bo;

import java.util.List;

import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFCompositeValueObject;
import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFBizCompositeBO extends AFBizBO {


    private String getDetailVOClass(List list) {
        if(list!=null && list.size()!=0) {
            for(int i=0; i<list.size(); i++) {
                AFValueObject vo = (AFValueObject)list.get(i);
                if(vo != null)
                    return vo.getClass().getName();
            }
        }
        return "";
    }

    public boolean doInsert(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeInsert(userToken, vo);

            if(result)
                result = this.getActiveDAO().doInsertByVO(vo);

            if(result) {
                List[] dList = ((AFCompositeValueObject)vo).getDetailList();
                for(int i=0; i<dList.length; i++) {
                    AFBizBO detailBO = this.getOperateBO(getDetailVOClass(dList[i]));
                    if(detailBO != null) {
                        result = detailBO.doInsert(userToken, dList[i]);
                        if(!result)
                            break;
                    }
                }
            }

            if(result && listener!=null)
                result = listener.afterInsert(userToken, vo);
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

            if(result) {
                List[] dList = ((AFCompositeValueObject)vo).getDetailList();
                for(int i=0; i<dList.length; i++) {
                    AFBizBO detailBO = this.getOperateBO(getDetailVOClass(dList[i]));
                    if(detailBO != null) {
                        result = this.doOperationByVOStatus(detailBO, userToken, dList[i]);
                        if(!result)
                            break;
                    }
                }
            }
            if(result && listener!=null)
                result = listener.afterUpdate(userToken, vo);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }


    public boolean doDelete(AFUserToken userToken, long id) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeDelete(userToken, id);

            if(result) {
                AFBizBO[] bo = this.getDetailBO();
                for(int i=0; i<bo.length; i++) {
                    result = bo[i].doDeleteByMaster(id);
                    if(!result)
                        break;
                }
                if(result)
                    result = this.getActiveDAO().doDeleteById(id);
            }
            if(result && listener!=null)
                result = listener.afterDelete(userToken, id);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }



    public AFValueObject doFind(AFUserToken userToken, long id) throws AFBOException {
        try {
            if(listener != null)
                listener.beforeFind(userToken, id);
            AFCompositeValueObject vo = (AFCompositeValueObject)this.getActiveDAO().doFindById(id);

            if(vo != null) {
                AFBizBO[] bo = this.getDetailBO();
                for(int i = 0; i < bo.length; i++) {
                    List list = bo[i].doSearchByMaster(id);
                    vo.setDetailList(getDetailVOClass(list), list);
                }
            }

            if(listener != null)
                listener.afterFind(userToken, id, vo);
            return vo;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    protected abstract AFBizBO getOperateBO(String detailVOCLass);

    protected abstract AFBizBO[] getDetailBO();
}