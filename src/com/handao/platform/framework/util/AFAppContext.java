package com.handao.platform.framework.util;

import config.Configuration;

public class AFAppContext{
    private static AFAppContext singleInstance = new AFAppContext();

    private Configuration configuration;
    private AFAppContext(){
    	configuration = Configuration.getInstance();
    }

    public static AFAppContext getInstance()
    {
        return singleInstance;
    }

    public String getURIEncoding(){
        return configuration.getURI_ENCODING();
    }

    public String getOpenTabMax(){
        return configuration.getOPENTAB_MAX();
    }

    public String getOpenTabMaxMessage(){
        return configuration.getOPENTAB_MAX_MESSAGE();
    }
}