<%@ page import="com.handao.platform.sm.login.LoginHandleImpl,com.handao.platform.sm.login.LoginResultBean,com.handao.platform.sm.login.LoginHandle"
%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<%
    boolean isSuccess = false;
    //��ʼ����½������Ϣbean
    LoginResultBean loginResultBean=null;
    //�����û���½���������һ�����صĵ�½��Ϣbean
    LoginHandle loginHandle = LoginHandleImpl.getInstance();
    loginResultBean=loginHandle.loginHandle(request,response);
    
    //�жϳɹ���־
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
