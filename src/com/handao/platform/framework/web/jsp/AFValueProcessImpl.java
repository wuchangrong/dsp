package com.handao.platform.framework.web.jsp;

import java.util.Map;

import javax.servlet.jsp.PageContext;

import com.handao.platform.framework.util.AFCodeListCache;

public class AFValueProcessImpl implements AFValueProcess{
	
	private Map codeNameMap = null;
    
    public static AFValueProcessImpl createByListCode(String listCode){
    	return new AFValueProcessImpl(listCode,null,null);
    }

    public static AFValueProcessImpl createBySqlId(String sqlId){
    	return new AFValueProcessImpl(null,sqlId,null);
    }
    
    public static AFValueProcessImpl createBySql(String sql){
    	return new AFValueProcessImpl(null,null,sql);
    }
    
    private AFValueProcessImpl(String listCode,String sqlId,String sql){
    	if(listCode != null)
    		codeNameMap = AFCodeListCache.getCodeNameMapByListCode(listCode);
    	else if(sqlId != null)
    		codeNameMap = AFCodeListCache.getCodeNameMapBySqlId(sqlId);
    	else
    		codeNameMap = AFCodeListCache.getCodeNameMapBySql(sql);
    }

    public void setPageContext(PageContext pageContext){}

    public String process(String code){
    	if(codeNameMap == null)
    		return "";
    	String name = (String)codeNameMap.get(code);
    	if(name == null)
    		return "";
    	return name;
    }
}
