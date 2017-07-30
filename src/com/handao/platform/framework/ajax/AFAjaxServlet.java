package com.handao.platform.framework.ajax;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.handao.platform.framework.util.AFLogger;

public class AFAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AFLogger logger = AFLogger.getLogger(AFAjaxServlet.class);

    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    public void destroy() {
        super.destroy();
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    	logger.logDebug(((HttpServletRequest)request).getQueryString());
        String implClass = request.getParameter("implcls");
        AFAjax ajax = AFAjaxProvider.getAjax(implClass);
        ajax.process((HttpServletRequest)request, (HttpServletResponse)response);
    }
}