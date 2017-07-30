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
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/daily/route/RouteDailyList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.sb.daily.route";
  ArrayList fieldList = new ArrayList();
	fieldList.add(new AFField("ROW_ID","dsp.sb.daily.route.row_id","3%","center",AFField.SHOW_TYPE_CHECKBOX,""));
	//fieldList.add(new AFField("COMPANY_ID","dsp.sb.daily.route.company_id","10%","center","",""));
	fieldList.add(new AFField("DEPT_ID","dsp.sb.daily.route.dept_id","10%","center","",""));
	fieldList.add(new AFField("VISIT_DATE","dsp.sb.daily.route.visit_date","15%","center",AFField.SHOW_TYPE_HREF,"viewRecordById",""));
	fieldList.add(new AFField("REPORT_EMP","dsp.sb.daily.route.report_emp","15%","center","",""));
	fieldList.add(new AFField("REMARK","dsp.sb.daily.route.remark","20%","center","",""));
	//fieldList.add(new AFField("RESERVE1","dsp.sb.daily.route.reserve1","10%","center","",""));
	//fieldList.add(new AFField("RESERVE2","dsp.sb.daily.route.reserve2","10%","center","",""));
	//fieldList.add(new AFField("RESERVE3","dsp.sb.daily.route.reserve3","10%","center","",""));
	//fieldList.add(new AFField("IS_USING","dsp.sb.daily.route.is_using","10%","center","",""));
	fieldList.add(new AFField("STATUS","dsp.sb.daily.route.status","10%","center","",""));
	fieldList.add(new AFField("ROW_ID","6%",AFField.SHOW_TYPE_OPRATION,"modify,delete"));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sb/daily/route/RouteDaily.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.sb.daily.route.list.title" bundle="<%=bundleKey%>">
    <handao:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <handao:headButton name="增加" accesskey="N" onClick="createRecord();"/>
    <!-- handao:headButton name="修改" accesskey="E" onClick="modifyRecord();"/ -->
    <handao:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <!-- handao:headButton name="查看" accesskey="V" onClick="viewRecord();"/ -->
</handao:headLink>

<handao:customQueryArea>
<%-- todo:可以自定义查询table--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.visit_date" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:date property="searchForm.VISIT_DATE_B"  />至<handao:date property="searchForm.VISIT_DATE_E"  /></td>
        <td colspan=1 class="singleDetailData"><html:select property="searchForm.STATUS"  styleClass="stedit" style="width:140px">
         <html:option value="">请选择</html:option>
         <html:option value="0">新建</html:option>
         <html:option value="1">提交</html:option>
        </html:select></td>
    </tr>

</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>