package com.handao.platform.framework.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.handao.platform.framework.ajax.AFAjax;
import com.handao.platform.framework.dao.AFDAOCommand;

/**
 * 通用校验类
 */
public class AFUniqueVerify implements AFAjax{
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map params = new HashMap();
		params.put("tableName", request.getParameter("tableName"));
		params.put("columnName", request.getParameter("columnName"));
		params.put("value", Base64Util.decodeStrByBASE64(request.getParameter("value")));
		params.put("rowid", request.getParameter("rowid"));
		
		boolean result = false;
		try{
			AFDAOCommand daoCommand = new AFDAOCommand();
			result = daoCommand.sm_searchList("framework.util.select.isUnique", params).size() == 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		PrintWriter writer = response.getWriter();
		writer.print(result?"Y":"N");
		writer.close();
	}
}
