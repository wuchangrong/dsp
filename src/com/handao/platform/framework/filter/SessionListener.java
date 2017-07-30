package com.handao.platform.framework.filter;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.sm.userOnline.UserOnlineManager;

public class SessionListener implements HttpSessionListener
{
    public void sessionCreated(HttpSessionEvent e){
    }

    public void sessionDestroyed(HttpSessionEvent e)
    {
        HttpSession session = e.getSession();
        //清除在线用户
        AFLogger logger = AFLogger.getLogger(this.getClass());
        logger.logDebug("清除当前session用户!");
        UserOnlineManager.getInstance().shutdownUser(session.getId(),1);
    }
}