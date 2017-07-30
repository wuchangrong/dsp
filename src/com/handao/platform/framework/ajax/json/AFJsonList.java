package com.handao.platform.framework.ajax.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.handao.platform.framework.envelope.AFPage;

public abstract class AFJsonList extends AFJson{
	private static final String NAME_TOTALCOUNT = "totalCount";
	private static final String NAME_DATAROOT = "data";
	
	protected String getJsonString(HttpServletRequest request) throws ServletException, IOException {
        AFPage page = this.getData(request);

        StringBuffer sb = new StringBuffer();
        sb.append("{\"").append(this.getTotalCountName()).append("\":\"").append(page.getTotalRecordNum()).append("\",\"").append(this.getDataRootname()).append("\":");
        sb.append(this.toJsonString(page.getList()));
        sb.append("}");
        return sb.toString();
    }
    
    protected String getTotalCountName() {
    	return NAME_TOTALCOUNT;
    }
    
    protected String getDataRootname() {
    	return NAME_DATAROOT;
    }
    
    protected abstract AFPage getData(HttpServletRequest request);
}