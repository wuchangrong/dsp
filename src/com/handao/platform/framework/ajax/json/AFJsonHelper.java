package com.handao.platform.framework.ajax.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.util.AFJsonUtil;

public class AFJsonHelper {
	public static final String REQUEST_KEY_DBKEY = "dbkey";
	public static final String REQUEST_KEY_LOOKUPCODE = "lookupcode";
	public static final String REQUEST_KEY_SQLID = "sqlid";
	public static final String REQUEST_KEY_BASECONDITION = "bcondition";
	public static final String REQUEST_KEY_FILTERCONDITION = "fcondition";
	public static final String REQUEST_KEY_PARENT_NODE_ID = "node";
	public static final String REQUEST_KEY_PAGE_SIZE = "pagesize";
	public static final String REQUEST_KEY_PAGE_START = "start";
	public static final String REQUEST_KEY_SORT_FIELD = "sort";
	public static final String REQUEST_KEY_SORT_DIR = "dir";
	
	public static final String REQUEST_KEY_LEAF_FLAG_VALUE = "leafflag";
	
	public static final String REQUEST_KEY_CONDITION_PARAM = "param";
	public static final String REQUEST_KEY_CONDITION_VALUE = "value";
	
	public static final String SQL_KEY_FILTER_PARAM = "FILTER";
	public static final String SQL_KEY_SORT_PARAM = "SORT";
	public static final String SQL_KEY_SORT_FIELD = "FIELD";
	public static final String SQL_KEY_SORT_DIR = "DIR";
	
	
    public static AFPage getPage(HttpServletRequest request) {
        int pageSize = -1;
        int index = 0;
        try {
            pageSize = Integer.parseInt(request.getParameter(REQUEST_KEY_PAGE_SIZE));
        }
        catch (Exception ex) {
            pageSize = -1;
        }
        try {
            index = Integer.parseInt(request.getParameter(REQUEST_KEY_PAGE_START));
        }
        catch (Exception ex) {
            index = 0;
        }
        AFPage page = new AFPage();
        page.setPageSize(pageSize);
        page.setCurrentPageNo((index+pageSize)/pageSize);
        page.setSortField(request.getParameter(REQUEST_KEY_SORT_FIELD));
        page.setSortType(request.getParameter(REQUEST_KEY_SORT_DIR));
        return page;
    }
    
    public static String getDbkey(HttpServletRequest request) {
    	return request.getParameter(REQUEST_KEY_DBKEY);
    }
    
    public static String getLookupCode(HttpServletRequest request) {
    	return request.getParameter(REQUEST_KEY_LOOKUPCODE);
    }

    public static String getSqlId(HttpServletRequest request) {
    	return request.getParameter(REQUEST_KEY_SQLID);
    }
    
    public static String getLeafFlagValue(HttpServletRequest request) {
    	return request.getParameter(REQUEST_KEY_LEAF_FLAG_VALUE);
    }    
    
    public static List getBaseCondition(HttpServletRequest request) {
    	String s = request.getParameter(REQUEST_KEY_BASECONDITION);
        if(!AFDataFormat.isEmpty(s))
            return AFJsonUtil.toList(s);
    	return null;
    }

    public static List getFilterCondition(HttpServletRequest request) {
    	String s = request.getParameter(REQUEST_KEY_FILTERCONDITION);
        if(!AFDataFormat.isEmpty(s)) {
        	try {
        		s = new String(s.getBytes(request.getCharacterEncoding()), "UTF-8");
        	}catch(Exception e) {
        	}
            return AFJsonUtil.toList(s);
        }
    	return null;
    }
    
    public static long getParentNodeID(HttpServletRequest request) {
    	long id = -1;
        try {
        	id = Long.parseLong(request.getParameter(REQUEST_KEY_PARENT_NODE_ID));
        }
        catch (Exception ex) {
        }
    	return id;
    }
    
    public static Map getSqlParameter(AFPage page, List bList, List fList) {
    	Map param = new HashMap();
    	
    	if(bList!=null && bList.size()!=0) {
            for (int i = 0; i <bList.size(); i++) {
                Map map = (Map)bList.get(i);
                param.put(map.get(REQUEST_KEY_CONDITION_PARAM), map.get(REQUEST_KEY_CONDITION_VALUE));
            }
    	}
    	if(fList!=null && fList.size()!=0) {
    		Map filterMap = new HashMap();
    		BASE64Decoder decoder = new BASE64Decoder();
    		try {
	            for (int i = 0; i <fList.size(); i++) {
	                Map map = (Map)fList.get(i);
	                String value = (String)map.get(REQUEST_KEY_CONDITION_VALUE);
	                value = new String(decoder.decodeBuffer(value), "UTF-8");
	                filterMap.put(map.get(REQUEST_KEY_CONDITION_PARAM), value);
	            }
    		} catch(IOException e) {
    			e.printStackTrace();
    		}
            param.put(SQL_KEY_FILTER_PARAM, filterMap);
    	}
    	
        if(!AFDataFormat.isEmpty(page.getSortField())) {
        	Map sort = new HashMap();
        	sort.put(SQL_KEY_SORT_FIELD, page.getSortField());
        	sort.put(SQL_KEY_SORT_DIR, page.getSortType());
        	param.put(SQL_KEY_SORT_PARAM, sort);
        }
        return param;
    }
    public static Map getFilterParameterDojo(String filter){
    	Map map = new HashMap();
    	List filterList = AFJsonUtil.toList(filter);
    	for(int i=0;i<filterList.size();i++){
    		Map filterObject = (Map)filterList.get(i);
    		map.put(filterObject.get("name"),"%"+filterObject.get("value")+"%");
    	}
    	return map;
    }
}