<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>	
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/visit/visitplan/VisitPlanAddEdit.js"></script>

<jsp:useBean id="sb_visit_VisitPlanForm" scope="request" class="com.handao.dsp.sb.visit.visitplan.web.VisitPlanForm" />
	
<%
  String bundleKey = "dsp.sb.visit.visitplan";
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody>

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sb/visit/visitplan/VisitPlan.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.sb.visit.visitplan.edit.title" bundle="<%=bundleKey%>">
    <handao:headButton name="保存并新增" accesskey="N" onClick="saveAndNewRecord();"/>
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.company_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="COMPANY_ID" maxlength="10" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.dept_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="DEPT_ID" maxlength="10" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visit_date" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:date property="VISIT_DATE"  /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visitor_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="VISITOR_ID" maxlength="10" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visitor_name" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="VISITOR_NAME" maxcharlength="50" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="CUSTOMER_ID" maxlength="10" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_code" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="CUSTOMER_CODE" maxlength="10" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_desc" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="CUSTOMER_DESC" maxlength="10" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_tel" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:integer property="CUSTOMER_TEL" maxlength="10" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.subject" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="SUBJECT" maxcharlength="254" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visit_type" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="VISIT_TYPE" maxcharlength="32" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.work_content" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="WORK_CONTENT" maxcharlength="400" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.feedback" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="FEEDBACK" maxcharlength="400" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.status" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="STATUS" maxcharlength="1" /></td>
	</tr>

</table>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>