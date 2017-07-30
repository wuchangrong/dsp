package com.handao.platform.framework.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.config.AFSqlMapConfig;
import com.handao.platform.framework.util.exception.AFDAOException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.event.RowHandler;

public class AFDAOCommand implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private final String SQLMAP_NULL_MSG = "可能存在以下错误：\n1：当前业务系统存在配置错误的SqlMap文件，请重新启动服务并检查应用服务器输出！\n2：调用EAODaoCommand方法的时候传入了错误的dbkey参数！";

    AFLogger logger = AFLogger.getLogger(AFDAOCommand.class);
    public AFDAOCommand() {
    }

    public Connection sm_getDBConnection(String dbkey) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        return sqlMap.getCurrentConnection();
    }

    public Connection sm_getDBConnection() throws SQLException {
        return sm_getDBConnection(null);
    }

    private SqlMapClient getSqlMap(String dbkey) {
        if(AFDataFormat.isEmpty(dbkey))
            return AFSqlMapConfig.getSqlMapInstance();
        else
            return AFSqlMapConfig.getSqlMapInstance(dbkey);
    }

    public AFPage sm_searchPage(String dbkey, String statementName, AFPage page, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);

        AFPage result = page;
        int currentPage = page.getCurrentPageNo();
        int pageSize = page.getPageSize();
        List list = null;

        if(pageSize > 0) {
            int total = ((Integer)sqlMap.queryForObject(statementName, parameterObject, page)).intValue();
            result.setTotalRecordNum(total);
            if(currentPage > result.getTotalPageNum()) {
                currentPage = result.getTotalPageNum();
                result.setCurrentPageNo(currentPage);
            }
            int skip = (currentPage - 1) * pageSize;
            int max = skip + pageSize;
            list = sqlMap.queryForList(statementName, parameterObject, skip, max);
        } else {
            list = sqlMap.queryForList(statementName, parameterObject);
        }

        result.setList(list);
        return result;
    }

    public AFPage sm_searchPage(String dbkey, String statementName, AFPage page) throws SQLException {
        return sm_searchPage(dbkey, statementName, page, null);
    }

    public AFPage sm_searchPage(String statementName, AFPage page) throws SQLException {
        return sm_searchPage(null, statementName, page, null);
    }

    public AFPage sm_searchPage(String dbkey, String statementName, AFSearchCustomerCondition cc, AFPage page) throws SQLException {
        return sm_searchPage(dbkey, statementName, page, cc);
    }

    public AFPage sm_searchPage(String statementName, AFSearchCustomerCondition cc, AFPage page) throws SQLException {
        return sm_searchPage(null, statementName, page, cc);
    }

    public AFPage sm_searchPage(String statementName, AFPage page, Object parameterObject) throws SQLException {
        return sm_searchPage(null, statementName, page, parameterObject);
    }

    public List sm_searchList(String dbkey, String statementName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        List list = sqlMap.queryForList(statementName, parameterObject);
        return list;
    }

    public List sm_searchList(String dbkey, String statementName) throws SQLException {
        return sm_searchList(dbkey, statementName, null);
    }

    public List sm_searchList(String statementName) throws SQLException {
        return sm_searchList(null, statementName, null);
    }

    public List sm_searchList(String statementName, Object parameterObject) throws SQLException {
        return sm_searchList(null, statementName, parameterObject);
    }

    public Object sm_find(String dbkey, String statementName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        return sqlMap.queryForObject(statementName, parameterObject);
    }

    public Object sm_find(String statementName, Object parameterObject) throws SQLException {
        return sm_find(null, statementName, parameterObject);
    }

    public boolean sm_insert(String dbkey, String statementName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        sqlMap.insert(statementName, parameterObject);
        return true;
    }

    public boolean sm_insert(String statementName, Object parameterObject) throws SQLException {
        return sm_insert(null, statementName, parameterObject);
    }
    
    public boolean sm_update(String dbkey, String statementName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        int rows = sqlMap.update(statementName, parameterObject);
        return rows >= 0;
    }

    public boolean sm_update(String statementName, Object parameterObject) throws SQLException {
        return sm_update(null, statementName, parameterObject);
    }

    public boolean sm_update_exists(String dbkey, String statementName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        int rows = sqlMap.update(statementName, parameterObject);
        return rows > 0;
    }

    public boolean sm_update_exists(String statementName, Object parameterObject) throws SQLException {
        return sm_update_exists(null, statementName, parameterObject);
    }
    
    public boolean sm_delete(String dbkey, String statementName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        int rows = sqlMap.delete(statementName, parameterObject);
        return rows >= 0;
    }

    public boolean sm_delete(String statementName, Object parameterObject) throws SQLException {
        return sm_delete(null, statementName, parameterObject);
    }

    public void sm_execProcedure(String dbkey, String procedureName, Object parameterObject) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        sqlMap.update(procedureName, parameterObject);
    }

    public void sm_execProcedure(String procedureName, Object parameterObject) throws SQLException {
        sm_execProcedure(null, procedureName, parameterObject);
    }
    
    public void sm_searchWithRowHandler(String dbkey, String statementName, Object parameterObject, RowHandler rowHandler) throws SQLException {
        SqlMapClient sqlMap = getSqlMap(dbkey);
        if(sqlMap == null)
            throw new AFDAOException(SQLMAP_NULL_MSG);
        sqlMap.queryWithRowHandler(statementName, parameterObject, rowHandler);	
    }

    public void sm_searchWithRowHandler(String statementName, Object parameterObject, RowHandler rowHandler) throws SQLException {
    	sm_searchWithRowHandler(null, statementName, parameterObject, rowHandler);
    }
}