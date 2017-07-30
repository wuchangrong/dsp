<%@ page import="com.handao.platform.sm.login.LoginHandleImpl,com.handao.platform.sm.login.LoginResultBean,com.handao.platform.sm.login.LoginHandle"
%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<%
    boolean isSuccess = false;
    //初始化登陆返回信息bean
    LoginResultBean loginResultBean=null;
    //调用用户登陆方法，获得一个返回的登陆信息bean
    LoginHandle loginHandle = LoginHandleImpl.getInstance();
    loginResultBean=loginHandle.loginHandle(request,response);
    
    //判断成功标志
    if (loginResultBean.getResultCode().equals("1"))
    {
        isSuccess=true;
    }else
        isSuccess=false;
%>
<html>
</html>
<script language="javascript">
<%if(isSuccess){%>
   	window.location.href = "<%=ctx%>/main.jsp";
<%}else{
	out.print("alert(\""+ loginResultBean.getResultDescribe() +"\");");
%>
	window.location.href = "<%=ctx%>/index.jsp";
<%}%>
</script>
