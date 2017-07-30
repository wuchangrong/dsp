<%@ page pageEncoding="GBK" import="com.handao.platform.framework.envelope.AFUserToken"%>
<%  
AFUserToken afUserToken = (AFUserToken) request.getSession().getAttribute("userToken");
if(afUserToken == null){
	request.getRequestDispatcher("/relogin.jsp").forward(request, response);	
}
%>
