<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.jsp.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>	
<handao:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/visit/visitrecord/VisitRecordList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.sb.visit.visitrecord";
  ArrayList fieldList = new ArrayList();
	fieldList.add(new AFField("ROW_ID","dsp.sb.visit.visitrecord.rowid","3%","center",AFField.SHOW_TYPE_CHECKBOX,""));
	//fieldList.add(new AFField("COMPANY_ID","dsp.sb.visit.visitrecord.companyid","10%","center","",""));
	fieldList.add(new AFField("DEPT_ID","dsp.sb.visit.visitrecord.deptid","7%","center","",""));
	fieldList.add(new AFField("VISIT_DATE","dsp.sb.visit.visitrecord.visitdate","9%","center","",""));
	//fieldList.add(new AFField("VISITOR_ID","dsp.sb.visit.visitrecord.visitorid","10%","center","",""));
	fieldList.add(new AFField("VISITOR_NAME","dsp.sb.visit.visitrecord.visitorname","7%","center","",""));
	//fieldList.add(new AFField("CUSTOMER_ID","dsp.sb.visit.visitrecord.customerid","10%","center","",""));
	fieldList.add(new AFField("CUSTOMER_CODE","dsp.sb.visit.visitrecord.customercode","8%","center",AFField.SHOW_TYPE_HREF,"viewRecordById",""));
	fieldList.add(new AFField("CUSTOMER_DESC","dsp.sb.visit.visitrecord.customerdesc","14%","left","",""));
	fieldList.add(new AFField("CUSTOMER_TEL","dsp.sb.visit.visitrecord.customertel","7%","left","",""));
	fieldList.add(new AFField("VISIT_TYPE","dsp.sb.visit.visitrecord.visittype","7%","center","","",AFValueProcessImpl.createByListCode("SB_VISIT_TYPE")));
	fieldList.add(new AFField("PRD_DESC","dsp.sb.visit.visitrecord.prddesc","8%","left","",""));
	//fieldList.add(new AFField("PRD_PRICE","dsp.sb.visit.visitrecord.prdprice","8%","center","",""));
	//fieldList.add(new AFField("EXISTING_PRD","dsp.sb.visit.visitrecord.existingprd","10%","center","",""));
	fieldList.add(new AFField("VISIT_RESULT","dsp.sb.visit.visitrecord.visitresult","8%","left","",""));
	//fieldList.add(new AFField("RET_VISIT_STATE","dsp.sb.visit.visitrecord.retvisitstate","10%","center","",""));
	fieldList.add(new AFField("ORIGIN_FLAG_DESC","dsp.sb.visit.visitrecord.originflag","8%","center","",""));
	//fieldList.add(new AFField("REMARK","dsp.sb.visit.visitrecord.remark","10%","center","",""));
	//fieldList.add(new AFField("IS_USING","dsp.sb.visit.visitrecord.isusing","6%","center","",""));
	//fieldList.add(new AFField("RESERVE1","dsp.sb.visit.visitrecord.reserve1","10%","center","",""));
	//fieldList.add(new AFField("RESERVE2","dsp.sb.visit.visitrecord.reserve2","10%","center","",""));
	//fieldList.add(new AFField("RESERVE3","dsp.sb.visit.visitrecord.reserve3","10%","center","",""));
	fieldList.add(new AFField("STATUS","dsp.sb.visit.visitrecord.status","6%","center","","",AFValueProcessImpl.createByListCode("SB_VISITREC_STATUS")));
	fieldList.add(new AFField("ROW_ID","8%",AFField.SHOW_TYPE_OPRATION,"modify,delete"));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sb/visit/visitrecord/VisitRecord.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.sb.visit.visitrecord.list.title" bundle="<%=bundleKey%>">
    <handao:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <handao:headButton name="增加" accesskey="N" onClick="createRecord();"/>
    <!-- handao:headButton name="修改" accesskey="E" onClick="modifyRecord();"/ -->
    <handao:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <!-- handao:headButton name="查看" accesskey="V" onClick="viewRecord();"/ -->
</handao:headLink>

<handao:customQueryArea>
<%-- todo:可以自定义查询table--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.visitdate" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:date property="searchForm.VISIT_DATE_B"  />至<handao:date property="searchForm.VISIT_DATE_E"  /></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.status" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:select property="searchForm.STATUS" lovCode="SB_VISITREC_STATUS"></handao:select></td>
    </tr> 
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customercode" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.CUSTOMER_CODE" maxcharlength="32" /></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitrecord.customerdesc" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.CUSTOMER_DESC" maxcharlength="50" /></td>
    </tr>

</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>