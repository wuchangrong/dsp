package com.handao.platform.sm.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginHandle
{
    //�������������һ�����û����룬һ����ͨ��index.jsp�û����ȷ�ϰ�ť����ܺ������
    public LoginResultBean loginHandle(HttpServletRequest request,HttpServletResponse response);
}