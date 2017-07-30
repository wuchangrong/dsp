package com.handao.platform.framework.dao.ibatis;

public abstract class AFAbstractDialect implements AFSQLDialect {
    protected String trim(String sql) {
        sql = sql.trim();
        if(sql.endsWith(";")) {
            sql = sql.substring(0, sql.length()-2);
        }
        return sql;
    }
}