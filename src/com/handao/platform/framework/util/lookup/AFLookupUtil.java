package com.handao.platform.framework.util.lookup;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handao.platform.framework.dao.AFDAOCommand;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.tree.AFTreeNodeHandler;
import com.handao.platform.framework.util.tree.AFTreeUtil;

public class AFLookupUtil {
    private static AFLogger logger = AFLogger.getLogger(AFLookupUtil.class);
    
    public static String getWhereOrderbySql(AFPage page, List bList, List fList) {
    	StringBuffer sb = new StringBuffer(" WHERE 1=1");
    	
        if(bList!=null && bList.size()!=0) {
            for (int i = 0; i <bList.size(); i++) {
                Map map = (Map)bList.get(i);
                sb.append(" AND "+map.get("field")+" "+map.get("relation")+" "+map.get("value"));
            }
        }
        
        if(fList!=null && fList.size()!=0) {
            sb.append(" AND(");
            for (int i = 0; i <fList.size(); i++) {
                Map map = (Map)fList.get(i);
                sb.append(map.get("field")+" "+map.get("relation")+" "+map.get("value")+ " OR ");
            }
            sb.delete(sb.length()-4, sb.length());
            sb.append(")");
        }
        
        if(!AFDataFormat.isEmpty(page.getSortField()))
            sb.append(" ORDER BY " + page.getSortField() + " " + page.getSortType());
    	
    	return sb.toString();
    }

    public static Map getWhereOrderbyParam(AFPage page, List bList, List fList) {
        StringBuffer where = new StringBuffer();
        String orderby = "";
        if(bList!=null && bList.size()!=0) {
            for (int i = 0; i <bList.size(); i++) {
                Map map = (Map)bList.get(i);
                where.append(" AND "+map.get("field")+" "+map.get("relation")+" "+map.get("value"));
            }
        }
        if(fList!=null && fList.size()!=0) {
            where.append(" AND(");
            for (int i = 0; i <fList.size(); i++) {
                Map map = (Map)fList.get(i);
                where.append(map.get("field")+" "+map.get("relation")+" "+map.get("value")+ " OR ");
            }
            where.delete(where.length()-4, where.length());
            where.append(")");
        }
        if(!AFDataFormat.isEmpty(page.getSortField()))
            orderby = " ORDER BY " + page.getSortField() + " " + page.getSortType();

        Map map = new HashMap();
        map.put("WHERE_CONDITION", where.toString());
        map.put("ORDERBY_CONDITION", orderby);
        return map;
    }
       
    public static AFPage getDataBySqlId(String dbkey, AFPage page, String statementName, Object parameterObject) {
        AFDAOCommand command = new AFDAOCommand();
        AFPage p = null;
        try {
            p = command.sm_searchPage(dbkey, statementName, page, parameterObject);
        } catch(SQLException ex) {
            logger.logError(ex);
        }
        return p;
    }
   
    public static List getTreeDataBySqlIdWithNodeHandler(String dbkey, String statementName, Object parameterObject, AFTreeNodeHandler nodeHandler, long parentNodeID) {
    	return AFTreeUtil.getDataBySqlIdWithNodeHandler(dbkey, statementName, parameterObject, nodeHandler, parentNodeID);
    }
}