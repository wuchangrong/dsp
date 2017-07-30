package com.handao.platform.framework.biz.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.service.AFServiceBase;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFBizService extends AFServiceBase {


    private void initResultByException(Exception ex, AFResult result) {
        result.setBooleanValue(false);
        if(result.getResultMessageKey() == null)
            result.setResultMessageKey("af.operation.common.faile");
        if(result.getException() == null)
            result.setException(ex);
    }

    public void commonBizInvoke(AFRequest afReq, AFResponse afResp, AFBizServiceHandle handle) throws AFServiceException {
        boolean isTransaction = handle.isTransaction();
        if(isTransaction) {
            boolean result = false;
            try {
                beginTran();
                result = handle.process(afReq, afResp);
                if(result)
                    commitTran();
            } catch(Exception ex) {
                logger.logError(ex);
                initResultByException(ex, afResp.getResult());
            } finally {
                try {
                    endTran();
                }
                catch(AFServiceException ex) {
                    logger.logError(ex);
                    initResultByException(ex, afResp.getResult());
                }
            }
        } else {
            try {
                handle.process(afReq, afResp);
            } catch(Exception ex) {
                logger.logError(ex);
                initResultByException(ex, afResp.getResult());
            }
        }
    }

    public void doSave(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                boolean result = false;
                AFBizBO bo = getActiveBO();
                if(bo != null)
                    result = bo.doInsert(afReq.getUserToken(), (AFValueObject)afReq.getDefaultData());
                AFResult afResult = afResp.getResult();
                afResult.setBooleanValue(result);
                afResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }



    public void doFind(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(false) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                long[] idList = (long[])afReq.getDefaultData();
                AFValueObject vo = null;
                AFBizBO bo = getActiveBO();
                if(bo!=null && idList!=null)
                    vo = bo.doFind(afReq.getUserToken(), idList[0]);
                afResp.setDefaultData(vo);
                return true;
            }
        });
    }

    public void doUpdate(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                boolean result = false;
                AFBizBO bo = getActiveBO();
                if(bo != null)
                    result = bo.doUpdate(afReq.getUserToken(), (AFValueObject)afReq.getDefaultData());
                AFResult afResult = afResp.getResult();
                afResult.setBooleanValue(result);
                afResult.setResultMessageKey(result?"af.operation.save.success":"af.operation.save.faile");
                return result;
            }
        });
    }


    public void doDelete(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(true) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                boolean result = false;
                AFBizBO bo = getActiveBO();
                if(bo != null)
                    result = bo.doDelete(afReq.getUserToken(), (long[])afReq.getDefaultData());
                AFResult afResult = afResp.getResult();
                afResult.setBooleanValue(result);
                afResult.setResultMessageKey(result?"af.operation.delete.success":"af.operation.delete.faile");
                return result;
            }
        });
    }


    public void doSearch(AFRequest afReq, AFResponse afResp) throws AFServiceException {
        commonBizInvoke(afReq, afResp, new AFBizServiceHandleImpl(false) {
            public boolean process(AFRequest afReq, AFResponse afResp) {
                AFPage page = null;
                AFBizBO bo = getActiveBO();
                if(bo != null)
                    page = bo.doSearchPage(afReq.getUserToken(), afReq.getSearchCondition(), afReq.getSearchPage());
                afResp.setSearchResultPage(page);
                return true;
            }
        });
    }


    protected abstract AFBizBO getActiveBO();
}