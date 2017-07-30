package com.handao.platform.framework.dao.ibatis;

import java.sql.Connection;
import java.sql.SQLException;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.AFReflectUtil;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.result.AutoResultMap;
import com.ibatis.sqlmap.engine.mapping.result.BasicResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.RequestScope;

public class AFPagingSqlExecutor extends SqlExecutor {

    private static final AFLogger logger = AFLogger.getLogger(AFPagingSqlExecutor.class);

    private AFSQLDialect dialect;

    private boolean enablePaging = true;

    public AFSQLDialect getDialect() {
        return dialect;
    }

    public void setDialect(AFSQLDialect dialect) {
        this.dialect = dialect;
    }

    public boolean isEnablePaging() {
        return enablePaging;
    }

    public void setEnablePaging(boolean enablePaging) {
        this.enablePaging = enablePaging;
    }

    public void executeQuery(RequestScope request, Connection conn, String sql, Object[] parameters, int skipResults, int maxResults, RowHandlerCallback callback) throws SQLException {

        if ((skipResults != NO_SKIPPED_RESULTS || maxResults != NO_MAXIMUM_RESULTS) && supportsPaging()) {
            sql = dialect.getPagingSql(sql, skipResults, maxResults);
            logger.logDebug(sql);
            skipResults = NO_SKIPPED_RESULTS;
            maxResults = NO_MAXIMUM_RESULTS;
        }
        else {
            Object obj = AFReflectUtil.getAttribute(callback, "resultObject", Object.class);
            if(obj instanceof AFPage) {
                sql = dialect.getCountSql(sql);
                logger.logDebug(sql);
                BasicResultMap resultMap = new AutoResultMap(((BasicResultMap)request.getResultMap()).getDelegate(), false);
                resultMap.setId(request.getStatement().getId() + "-AutoResultMap");
                resultMap.setResultClass(Integer.class);
                AFReflectUtil.setFieldValue(request, "resultMap", ResultMap.class, resultMap);
                AFReflectUtil.setFieldValue(callback, "resultMap", ResultMap.class, resultMap);
            }
        }
        super.executeQuery(request, conn, sql, parameters, skipResults, maxResults, callback);
    }

    public boolean supportsPaging() {
        if (enablePaging && dialect != null) {
            return dialect.supportsPaging();
        }
        return false;
    }


}