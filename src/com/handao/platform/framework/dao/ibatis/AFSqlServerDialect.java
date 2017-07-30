package com.handao.platform.framework.dao.ibatis;

public class AFSqlServerDialect extends AFAbstractDialect {
    private static final String KEY_FROM = "FROM";
    private static final String KEY_ORDERBY = "ORDER BY";
    
    public boolean supportsPaging() {
        return true;
    }
    
    public String getCountSql(String sql) {
    	sql = trim(sql);
    	String _sql = sql.toUpperCase();
    	
    	int index = sql.length();
    	
	    int index_orderby = _sql.lastIndexOf(KEY_ORDERBY);
	    if(index_orderby != -1) {
	        String temp = sql.substring(index_orderby);
	        if(temp.indexOf(")") == -1) {
	        	index = index_orderby;
	        }
	    }
    	
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT COUNT(*) FROM ( ");
        sb.append(sql.substring(0, index));
        sb.append(" ) TEMP");
        return sb.toString();
    }

	public String getPagingSql(String sql, int skip, int max) {
		sql = trim(sql);
	    String _sql = sql.toUpperCase();
	    
	    int index_from = _sql.indexOf(KEY_FROM);
	    String str_select = sql.substring(0, index_from);
	    
	    String str_orderby = "ORDER BY ROW_ID";
	    boolean hasOrderby = false;
	    int index_orderby = _sql.lastIndexOf(KEY_ORDERBY);
	    if(index_orderby != -1) {
	        String temp = sql.substring(index_orderby);
	        if(temp.indexOf(")") == -1) {
	            str_orderby = temp;
	            hasOrderby = true;
	        }
	    }
	    
	    String str_from = hasOrderby?sql.substring(index_from, index_orderby):sql.substring(index_from);
	    
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append("SELECT * FROM (");
	    sb.append(str_select).append(", ROW_NUMBER() OVER(");
	    sb.append(str_orderby).append(") AS RN ");
	    sb.append(str_from);
	    sb.append(") AS TEMP WHERE TEMP.RN BETWEEN ").append(skip+1).append(" AND ").append(max);
		return sb.toString();
    }
}