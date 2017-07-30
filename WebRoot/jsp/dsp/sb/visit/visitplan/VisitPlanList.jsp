<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>	
<handao:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/visit/visitplan/VisitPlanList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.sb.visit.visitplan";
  ArrayList fieldList = new ArrayList();
	fieldList.add(new AFField("ROW_ID","dsp.sb.visit.visitplan.row_id","3%","center",AFField.SHOW_TYPE_CHECKBOX,""));
	//fieldList.add(new AFField("COMPANY_ID","dsp.sb.visit.visitplan.company_id","10%","center","",""));
	fieldList.add(new AFField("DEPT_ID","dsp.sb.visit.visitplan.dept_id","10%","center","",""));
	fieldList.add(new AFField("VISIT_DATE","dsp.sb.visit.visitplan.visit_date","10%","center","",""));
	//fieldList.add(new AFField("VISITOR_ID","dsp.sb.visit.visitplan.visitor_id","10%","center","",""));
	fieldList.add(new AFField("VISITOR_NAME","dsp.sb.visit.visitplan.visitor_name","10%","center","",""));
	//fieldList.add(new AFField("CUSTOMER_ID","dsp.sb.visit.visitplan.customer_id","10%","center","",""));
	fieldList.add(new AFField("CUSTOMER_CODE","dsp.sb.visit.visitplan.customer_code","10%","center","",""));
	fieldList.add(new AFField("CUSTOMER_DESC","dsp.sb.visit.visitplan.customer_desc","10%","center","",""));
	fieldList.add(new AFField("CUSTOMER_TEL","dsp.sb.visit.visitplan.customer_tel","10%","center","",""));
	fieldList.add(new AFField("SUBJECT","dsp.sb.visit.visitplan.subject","10%","center","",""));
	fieldList.add(new AFField("VISIT_TYPE","dsp.sb.visit.visitplan.visit_type","10%","center","",""));
	//fieldList.add(new AFField("WORK_CONTENT","dsp.sb.visit.visitplan.work_content","10%","center","",""));
	//fieldList.add(new AFField("FEEDBACK","dsp.sb.visit.visitplan.feedback","10%","center","",""));
	//fieldList.add(new AFField("RESERVE1","dsp.sb.visit.visitplan.reserve1","10%","center","",""));
	//fieldList.add(new AFField("RESERVE2","dsp.sb.visit.visitplan.reserve2","10%","center","",""));
	//fieldList.add(new AFField("RESERVE3","dsp.sb.visit.visitplan.reserve3","10%","center","",""));
	//fieldList.add(new AFField("IS_USING","dsp.sb.visit.visitplan.is_using","10%","center","",""));
	fieldList.add(new AFField("STATUS","dsp.sb.visit.visitplan.status","10%","center","",""));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sb/visit/visitplan/VisitPlan.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.sb.visit.visitplan.list.title" bundle="<%=bundleKey%>">
    <handao:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <handao:headButton name="增加" accesskey="N" onClick="createRecord();"/>
    <handao:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <handao:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <handao:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</handao:headLink>

<handao:customQueryArea>
<%-- todo:可以自定义查询table--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.visit.visitplan.row_id" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.ROW_ID" maxcharlength="10" /></td>
        <td class="singleDetailLabel"></td>
        <td colspan=1 class="singleDetailData"></td>
    </tr>

</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>