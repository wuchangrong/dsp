package com.handao.platform.framework.ajax.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.handao.platform.framework.ajax.AFAjax;
import com.handao.platform.framework.util.AFJsonUtil;
import com.handao.platform.framework.vo.AFValueObject;


public abstract class AFJson implements AFAjax {
	
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean scriptTag = false;
        String cb = request.getParameter("callback");
        if(cb != null) {
            scriptTag = true;
            response.setContentType("text/javascript; charset=GBK");
        } else {
            response.setContentType("application/x-json; charset=GBK");
        }
        StringBuffer sb = new StringBuffer();
        if(scriptTag) {
            sb.append(cb + "(");
        }
        sb.append(this.getJsonString(request));
        if(scriptTag) {
            sb.append(");");
        }
        response.getOutputStream().write(sb.toString().getBytes("GBK"));
    }
    
    protected String toJsonString(List list) {
    	return AFJsonUtil.toJsonString(list);
    }
    
    protected String toJsonString(Map map) {
    	return AFJsonUtil.toJsonString(map);
    }
    
    protected String toJsonString(AFValueObject vo) {
    	return AFJsonUtil.toJsonString(vo);
    }
    
    protected List toList(String str) {
    	return AFJsonUtil.toList(str);
    }
    
    protected Map toMap(String str) {
    	return AFJsonUtil.toMap(str);
    }
    
    protected AFValueObject toVO(String str) {
    	return AFJsonUtil.toVO(str);
    }
    
    protected abstract String getJsonString(HttpServletRequest request) throws ServletException, IOException;
        
}
