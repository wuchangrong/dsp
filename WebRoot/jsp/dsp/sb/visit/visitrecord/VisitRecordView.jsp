<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<handao:iniCtx id="ctx"/>
<handao:css />
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/visit/visitrecord/VisitRecordView.js"></script>

<jsp:useBean id="sb_visit_VisitRecordForm" scope="request" class="com.handao.dsp.sb.visit.visitrecord.web.VisitRecordForm" />
<%
  String bundleKey = "dsp.sb.visit.visitrecord";
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody>
<html:form action="sb/visit/visitrecord/VisitRecord.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<handao:headLink titleKey="dsp.sb.visit.visitrecord.view.title"  bundle="<%=bundleKey%>">
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
	<!-- tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.companyid" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="COMPANY_ID" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.deptid" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="DEPT_ID" /></td>
	</tr -->
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitdate" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="VISIT_DATE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitorname" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="VISITOR_NAME" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customercode" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="CUSTOMER_CODE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customerdesc" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="CUSTOMER_DESC" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customertel" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="CUSTOMER_TEL" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visittype" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="VISIT_TYPE" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visittype" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:write name="sb_visit_VisitRecordForm" property="VISIT_TYPE" listCode="SB_VISIT_TYPE" /></td>	
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.prddesc" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="PRD_DESC" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.prdprice" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="PRD_PRICE" /></td>	
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.existingprd" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="EXISTING_PRD" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitresult" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="VISIT_RESULT" /></td>	
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.retvisitstate" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="RET_VISIT_STATE" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_visit_VisitRecordForm" property="REMARK" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.status" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:write name="sb_visit_VisitRecordForm" property="STATUS" listCode="SB_VISITREC_STATUS"/></td>
	</tr>

</table>
</html:form>
</BODY>
</HTML>