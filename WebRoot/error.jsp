<%@page language="java" contentType="text/html;charset=GBK"%>
<html>
<%
  out.println("<Script Language=\"javaScript\">");
  out.println("top.location.href=\""+request.getContextPath()+"/index.jsp\";");
  out.println("</Script>");    
%> 
</html>
