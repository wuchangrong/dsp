package com.handao.platform.framework.dao.ibatis;

public class MysqlDialect extends AFAbstractDialect{

    public MysqlDialect(){
    }

    public boolean supportsPaging()
    {
        return true;
    }

    public String getCountSql(String sql)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT COUNT(*) FROM ( ");
        sb.append(trim(sql));
        sb.append(" ) TEMP");
        return sb.toString();
    }

    public String getPagingSql(String sql, int skip, int max)
    {
        StringBuffer sb = new StringBuffer();
        if (skip<0) skip=0;
        sb.append(trim(sql));
        sb.append(" LIMIT ");
        sb.append(skip).append(",").append(max-skip);
        return sb.toString();
    }
}
