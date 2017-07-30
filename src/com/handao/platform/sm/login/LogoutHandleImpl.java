package com.handao.platform.sm.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutHandleImpl implements LogoutHandle{
    private static LogoutHandle logoutHandle = new LogoutHandleImpl();
    
    private LogoutHandleImpl(){}
    
    public static LogoutHandle getInstance()
    {
        return logoutHandle;
    }

    public void logoutHandle(HttpServletRequest request)
    {
        if(request.getSession()!=null)
        {
            HttpSession session = request.getSession();
            destorySession(session);
        }
    }

    private void destorySession(HttpSession session){
        if(session.getAttribute("userToken")!=null){
            session.removeAttribute("userToken");
        }
        session.invalidate();
    }
}