<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/userOnline/userOnlineList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage" />
<%
	String bundleKey = "common.sm.useronline";
  ArrayList fieldList = new ArrayList();
  
  fieldList.add(new AFField("sessionId","common.sm.userOnline.userId","3%","center",AFField.SHOW_TYPE_CHECKBOX,""));
  fieldList.add(new AFField("entityName","common.sm.userOnline.entityName","25%","left",""));
  fieldList.add(new AFField("userCode","common.sm.userOnline.userCode","10%","left",""));
  fieldList.add(new AFField("userName","common.sm.userOnline.userName","12%","left",""));
  fieldList.add(new AFField("loginIP","common.sm.userOnline.loginIP","18%","center",""));
  fieldList.add(new AFField("loginDateTime","common.sm.userOnline.loginDate","17%","center",""));
  fieldList.add(new AFField("insistTime","common.sm.userOnline.insistTime","15%","center",""));
  
  request.setAttribute("fieldList",fieldList);
%>
<HTML>
<HEAD></HEAD>
<BODY class="singleDetailBody">
<html:form action="/sm/userOnline/UserOnlineList.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>	
<handao:headLink titleKey="common.sm.userOnline.title" bundle="<%=bundleKey%>">
    <handao:headButton name="Ë¢ÐÂ" accesskey="N" onClick="queryRecord();"/>
    <handao:headButton name="Çå³ý" accesskey="D" onClick="shutdownUser();"/>
</handao:headLink>
<%@include file="/platform/jsp/include/searchBody.jsp"%>
</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>