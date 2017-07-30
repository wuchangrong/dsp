package com.handao.platform.framework.service;

import java.lang.reflect.Method;
import java.sql.SQLException;

import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.config.AFSqlMapConfig;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.ibatis.sqlmap.client.SqlMapClient;


public abstract class AFServiceBase implements AFService {

    private final String SQLMAP_NULL_MSG = "当前业务系统存在配置错误的SqlMap文件，请重新启动服务并检查应用服务器输出！";

    protected AFLogger logger = AFLogger.getLogger(this.getClass());

    public AFServiceBase() {
    }

    private SqlMapClient getSqlMap(String dbkey) {
        if(dbkey == null)
            return AFSqlMapConfig.getSqlMapInstance();
        else
            return AFSqlMapConfig.getSqlMapInstance(dbkey);
    }

    protected final void beginTran(String dbkey) throws AFServiceException {
        SqlMapClient sqlmap = getSqlMap(dbkey);
        if(sqlmap == null)
            throw new AFServiceException(SQLMAP_NULL_MSG);
        try {
            sqlmap.startTransaction(java.sql.Connection.TRANSACTION_READ_UNCOMMITTED);
        } catch(SQLException ex) {
            logger.logError(ex);
            throw new AFServiceException(ex);
        }
    }

    protected final void beginTran() throws AFServiceException {
        beginTran(null);
    }

    protected final void commitTran(String dbkey) throws AFServiceException {
        SqlMapClient sqlmap = getSqlMap(dbkey);
        if(sqlmap == null)
            throw new AFServiceException(SQLMAP_NULL_MSG);
        try {
            sqlmap.commitTransaction();
        } catch(SQLException ex) {
            logger.logError(ex);
            throw new AFServiceException(ex);
        }
    }

    protected final void commitTran() throws AFServiceException {
        commitTran(null);
    }

    protected final void endTran(String dbkey) throws AFServiceException {
        SqlMapClient sqlmap = getSqlMap(dbkey);
        if(sqlmap == null)
            throw new AFServiceException(SQLMAP_NULL_MSG);
        try {
            sqlmap.endTransaction();
        } catch(SQLException ex) {
            logger.logError(ex);
            throw new AFServiceException(ex);
        }
    }

    protected final void endTran() throws AFServiceException {
        endTran(null);
    }


    public void doService(AFRequest eapReq, AFResponse eapResp) throws AFServiceException {
        String methodName = eapReq.getMethodName();
        if(methodName == null || "".equals(methodName)) {
            throw new AFServiceException("no method name");
        }

        Method mothod = null;
        try {
            mothod = this.getClass().getMethod(methodName, new Class[] {AFRequest.class, AFResponse.class});
            mothod.invoke(this, new Object[] {eapReq, eapResp});
        } catch(Exception ex) {
            throw new AFServiceException(ex);
        }
    }

}