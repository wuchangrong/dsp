package com.handao.platform.framework.ajax.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public abstract class AFJsonTree extends AFJson {

	protected String getJsonString(HttpServletRequest request) throws ServletException, IOException {	
		List list = this.getData(request);
		StringBuffer sb = new StringBuffer(this.toJsonString(list));
		return sb.toString();
    }
	protected abstract List getData(HttpServletRequest request);
}