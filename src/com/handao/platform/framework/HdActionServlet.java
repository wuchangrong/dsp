package com.handao.platform.framework;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.handao.platform.framework.util.AFLogger;

import config.Configuration;

public class HdActionServlet extends ActionServlet{

	private static final long serialVersionUID = 1L;

    AFLogger logger = AFLogger.getLogger(this.getClass());

	public HdActionServlet(){}

	public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        String appConfig = getInitParameter("applications");
        if(appConfig == null || appConfig.trim().length() <= 0){
        	String msg = "applications 参数配置错误！";
        	logger.logError(msg);
        	throw new ServletException(msg);
        }            
        initApplicationConfig(appConfig);
    }

    private void initApplicationConfig(String strAppConfigPath) throws ServletException{
    	try{
	        DocumentBuilder appConfig = DocumentBuilderFactory.newInstance().newDocumentBuilder();        
	        InputStream is = getServletContext().getResourceAsStream(strAppConfigPath);
	        Document doc = appConfig.parse(is);
	        
	        StringBuffer configs = new StringBuffer();
	        NodeList appList = doc.getElementsByTagName("application");
	        for(int i = 0,appCount = appList.getLength(); i < appCount; i++)
	        {
	            Element app = (Element)appList.item(i);
	            logger.logDebug("init application configuration:" + app.getAttribute("name"));
	            NodeList configList = app.getElementsByTagName("config");
	            int j = 0;
	            for(int configCount = configList.getLength(); j < configCount; j++)
	            {
	                String url = configList.item(j).getFirstChild().getNodeValue();
	                InputStream tempIs = getServletContext().getResourceAsStream(url);
	                if(tempIs == null){
	                    logger.logError(url + " not exist!");
	                }else{
	                    configs.append(configs.length() <= 0 ? "" : ",").append(url);
	                    tempIs.close();
	                }
	            }	
	        }	
	        String strFullConfigPath = configs.toString();
	        if(strFullConfigPath.trim().length() > 0)
	        {
	            ModuleConfig moduleconfig = initModuleConfig("", strFullConfigPath);
	            initModuleMessageResources(moduleconfig);
	            initModuleDataSources(moduleconfig);
	            initModulePlugIns(moduleconfig);
	            moduleconfig.freeze();
	        }
	        is.close();
    	}catch(Exception e){
    		logger.logError(e);
    		throw new ServletException(e);
    	}
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
    	//session校验
        if(request.getSession() == null || request.getSession().getAttribute("userToken") == null)
        {
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(Configuration.getInstance().getRELOGIN_PAGE());
            rd.forward(request, response);
            return;
        }
        //字符集设置
        try
        {
            request.setCharacterEncoding(Configuration.getInstance().getENCODING());
        } catch(Exception e)
        {
            e.printStackTrace();
            logger.logError("error in setCharacterEncoding!");
        }
        super.process(request, response);
    }
}
