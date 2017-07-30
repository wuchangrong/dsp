package com.handao.platform.framework.dao.ibatis;

public class AFOracleDialect extends AFAbstractDialect {
    public String getCountSql(String sql) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT COUNT(*) FROM ( ");
        sb.append(trim(sql));
        sb.append(" )");
        return sb.toString();
    }

    public String getPagingSql(String sql, int skip, int max) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ( SELECT TEMP_TABLE.*, ROWNUM AS RN FROM ( ");
        sb.append(trim(sql));
        sb.append(" ) TEMP_TABLE WHERE ROWNUM <=");
        sb.append(max);
        sb.append(" ) WHERE RN > ");
        sb.append(skip);
        return sb.toString();
    }

    public boolean supportsPaging() {
        return true;
    }
}