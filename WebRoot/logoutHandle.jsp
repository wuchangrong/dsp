<%@ page import="com.handao.platform.sm.login.LogoutHandleImpl"%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<%
   LogoutHandleImpl.getInstance().logoutHandle(request);
%>
<script language="javascript">
   window.location.href = "<%=ctx%>/index.jsp";
</script>