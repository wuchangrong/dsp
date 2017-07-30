package com.handao.platform.framework.util.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import com.handao.platform.framework.dao.ibatis.AFDB2Dialect;
import com.handao.platform.framework.dao.ibatis.AFOracleDialect;
import com.handao.platform.framework.dao.ibatis.AFPagingSqlExecutor;
import com.handao.platform.framework.dao.ibatis.AFSQLDialect;
import com.handao.platform.framework.dao.ibatis.AFSqlServerDialect;
import com.handao.platform.framework.dao.ibatis.MysqlDialect;
import com.handao.platform.framework.util.AFConstants;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.util.AFReflectUtil;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;

public class AFSqlMapConfig {
    private static String DEFAULT_DBKEY = "default";

    private static Map sqlMap = new HashMap();

    static void addSqlMapConfig(String dbkey, String dbtype, String filePath, String isDefault, ServletContext sc) throws Exception {
        if(AFDataFormat.isEmpty(dbkey) || AFDataFormat.isEmpty(filePath))
            throw new RuntimeException("配置信息不完整！");

        SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(sc.getResourceAsStream(filePath));


        AFSQLDialect sqlDialect = null;
        if(AFConstants.DB_TYPE_ORACLE.equalsIgnoreCase(dbtype))
            sqlDialect = new AFOracleDialect();
        else if(AFConstants.DB_TYPE_DB2.equalsIgnoreCase(dbtype))
            sqlDialect = new AFDB2Dialect();
        else if(AFConstants.DB_TYPE_SQLSERVER.equalsIgnoreCase(dbtype))
            sqlDialect = new AFSqlServerDialect();
        else if(AFConstants.DB_TYPE_MYSQL.equalsIgnoreCase(dbtype))
        	sqlDialect = new MysqlDialect();
        else
        	throw new RuntimeException("数据库方言配置错误！");

        AFPagingSqlExecutor pagingSqlExecutor = new AFPagingSqlExecutor();
        pagingSqlExecutor.setDialect(sqlDialect);
        pagingSqlExecutor.setEnablePaging(true);
        if(sqlMapClient instanceof ExtendedSqlMapClient) {
            AFReflectUtil.setFieldValue(((ExtendedSqlMapClient)sqlMapClient).getDelegate(), "sqlExecutor", SqlExecutor.class, pagingSqlExecutor);
        }



        sqlMap.put(dbkey, sqlMapClient);
        if("true".equalsIgnoreCase(isDefault))
            DEFAULT_DBKEY = dbkey;

    }

    public static SqlMapClient getSqlMapInstance(String dbkey) {
    	return(SqlMapClient)sqlMap.get(dbkey);
    }

    public static SqlMapClient getSqlMapInstance() {
        return getSqlMapInstance(DEFAULT_DBKEY);
    }

}