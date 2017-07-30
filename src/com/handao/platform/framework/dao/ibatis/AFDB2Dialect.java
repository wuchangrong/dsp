package com.handao.platform.framework.dao.ibatis;

public class AFDB2Dialect extends AFAbstractDialect {
    public boolean supportsPaging() {
        return true;
    }

    public String getCountSql(String sql) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT COUNT(*) FROM ( ");
        sb.append(trim(sql));
        sb.append(" ) TEMP");
        return sb.toString();
    }

    public String getPagingSql(String sql, int skip, int max) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ( SELECT ROWNUMBER() OVER() AS ROW_NEXT,T.*  FROM (");
        sb.append(trim(sql));
        sb.append(") AS T) AS TEMP WHERE ROW_NEXT BETWEEN ");
        sb.append(skip+1).append(" AND ").append(max);
        return sb.toString();
    }
}