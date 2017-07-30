package com.handao.platform.framework.service;

import javax.servlet.http.HttpServletRequest;

import com.handao.platform.framework.util.AFLogger;

public class AFServiceManager {

    private static AFLogger logger = AFLogger.getLogger(AFServiceManager.class);

    private final static String LAST_INVOCED_SERVICE = "last.invoced.service";

    private AFServiceManager() {
    }

    public static AFService getService(String serviceName, HttpServletRequest request) {
        AFService service = (AFService)request.getSession().getAttribute(LAST_INVOCED_SERVICE);
        if(service==null || !serviceName.equals(service.getClass().getName())) {
            try {
                service = (AFService)(Class.forName(serviceName)).newInstance();
                logger.logDebug("create instance: "+serviceName);
                request.getSession().setAttribute(LAST_INVOCED_SERVICE, service);
                logger.logDebug("cache instance: "+serviceName);
            } catch(Exception ex) {
                logger.logDebug(ex);
                return null;
            }
        }
        else {
            logger.logDebug("find cache: " + serviceName);
        }
        return service;
    }

}