<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@ taglib prefix="include" tagdir="/WEB-INF/tags/include" %>
<%@ taglib prefix="gridlookup" tagdir="/WEB-INF/tags/lookuptags/gridlookup" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<include:script />
<include:css />
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>	
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/visit/visitrecord/VisitRecordAddEdit.js"></script>

<jsp:useBean id="sb_visit_VisitRecordForm" scope="request" class="com.handao.dsp.sb.visit.visitrecord.web.VisitRecordForm" />
	
<%
  String bundleKey = "dsp.sb.visit.visitrecord";
  com.handao.platform.framework.envelope.UserToken userToken = (com.handao.platform.framework.envelope.UserToken)session.getAttribute("userToken");
  String companyId = userToken.getCompanyId()+"";
  String deptId = userToken.getDeptId()+"";
  
  if (sb_visit_VisitRecordForm.getSTATUS().equals(""))
	  sb_visit_VisitRecordForm.setSTATUS("0");
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody>

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sb/visit/visitrecord/VisitRecord.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.sb.visit.visitrecord.edit.title" bundle="<%=bundleKey%>">
    <!-- handao:headButton name="保存并新增" accesskey="N" onClick="saveAndNewRecord();"/ -->
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="提交" accesskey="M" onClick="submitRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
<html:hidden property="COMPANY_ID" value="<%=companyId%>"/>
<html:hidden property="DEPT_ID" value="<%=deptId%>"/>
<html:hidden property="VISITOR_ID" value="0"/>
<html:hidden property="CUSTOMER_ID" value="0"/>
<html:hidden property="ORIGIN_FLAG" value="0"/>


	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitdate" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:date property="VISIT_DATE"  /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitorname" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="VISITOR_NAME" maxcharlength="50" /></td>
		<gridlookup:EMPLOYEE id="person" row_id_pro="VISITOR_ID" name_pro="VISITOR_NAME" beforepopup="beforePopupPerson()"/>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customercode" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="CUSTOMER_CODE" maxcharlength="32"/></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customerdesc" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="CUSTOMER_DESC" maxcharlength="50" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customertel" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="CUSTOMER_TEL" maxcharlength="32" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customeraddr" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="CUSTOMER_ADDR" maxcharlength="125" /></td>		

	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visittype" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:select property="VISIT_TYPE" lovCode="SB_VISIT_TYPE"></handao:select></td>	
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.prddesc" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="PRD_DESC" maxcharlength="254" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.prdprice" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:double property="PRD_PRICE" precision="(22,2)" /></td>	
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.existingprd" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="EXISTING_PRD" maxcharlength="254" /></td>

	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitresult" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="VISIT_RESULT" maxcharlength="254" /></td>	
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.retvisitstate" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="RET_VISIT_STATE" maxcharlength="400" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="REMARK" maxcharlength="200" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.status" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><html:hidden property="STATUS"/><handao:write name="sb_visit_VisitRecordForm" property="STATUS" listCode="SB_VISITREC_STATUS"/></td>
	</tr>

</table>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>