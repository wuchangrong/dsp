<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<handao:iniCtx id="ctx"/>
<handao:css />
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/visit/visitplan/VisitPlanView.js"></script>

<jsp:useBean id="sb_visit_VisitPlanForm" scope="request" class="com.handao.dsp.sb.visit.visitplan.web.VisitPlanForm" />
<%
  String bundleKey = "dsp.sb.visit.visitplan";
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody>
<html:form action="sb/visit/visitplan/VisitPlan.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<handao:headLink titleKey="dsp.sb.visit.visitplan.view.title"  bundle="<%=bundleKey%>">
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
	<!-- tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.company_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="COMPANY_ID" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.dept_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="DEPT_ID" /></td>
	</tr -->
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visit_date" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="VISIT_DATE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visitor_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="VISITOR_ID" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visitor_name" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="VISITOR_NAME" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="CUSTOMER_ID" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_code" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="CUSTOMER_CODE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_desc" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="CUSTOMER_DESC" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.customer_tel" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="CUSTOMER_TEL" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.subject" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="SUBJECT" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.visit_type" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="VISIT_TYPE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.work_content" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="WORK_CONTENT" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.feedback" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="FEEDBACK" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.status" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitPlanForm" property="STATUS" /></td>
	</tr>

</table>
</html:form>
</BODY>
</HTML>