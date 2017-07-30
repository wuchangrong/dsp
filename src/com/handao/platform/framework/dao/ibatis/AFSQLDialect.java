package com.handao.platform.framework.dao.ibatis;

public interface AFSQLDialect {

    public boolean supportsPaging();

    public String getCountSql(String sql);

    public String getPagingSql(String sql, int skip, int max);

}