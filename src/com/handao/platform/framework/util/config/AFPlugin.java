package com.handao.platform.framework.util.config;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.config.PlugInConfig;

public class AFPlugin implements PlugIn {
    public void destroy() {

    }


    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        try {
            PlugInConfig[] pConfigs = config.findPlugInConfigs();
            for(int i=0; i<pConfigs.length; i++) {
                PlugInConfig pConfig = pConfigs[i];
                if(pConfig.getClassName().equals(AFPlugin.class.getName())) {
                    String configFilePath = (String)pConfig.getProperties().get("config");
                    AFConfigManager instance = AFConfigManager.getInstance();
                    instance.setServletContext(servlet.getServletContext());
                    instance.init(configFilePath);
                    break;
                }
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}