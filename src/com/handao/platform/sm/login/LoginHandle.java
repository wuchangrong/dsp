package com.handao.platform.sm.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginHandle
{
    //两个传入参数，一个是用户编码，一个是通过index.jsp用户点击确认按钮后加密后的密码
    public LoginResultBean loginHandle(HttpServletRequest request,HttpServletResponse response);
}