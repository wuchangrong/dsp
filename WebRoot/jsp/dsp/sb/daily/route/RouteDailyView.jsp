<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.handao.dsp.sb.daily.route.web.RouteDailyDetailForm" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<handao:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/daily/route/RouteDailyAddEdit.js"></script>
<jsp:useBean id="sb_daily_RouteDailyForm" scope="request" class="com.handao.dsp.sb.daily.route.web.RouteDailyForm" />
<%
    String bundleKey = "dsp.sb.daily.route";
%>
<HTML>

<HEAD>
<script type="text/javascript">
var ctx = '<%=ctx%>';

</script>

</HEAD>

<BODY class=singleDetailBody>
<html:form action="sb/daily/route/RouteDaily.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>


<handao:headLink titleKey="dsp.sb.daily.route.view.title" bundle="<%=bundleKey%>">
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.visit_date" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_daily_RouteDailyForm" property="VISIT_DATE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.report_emp" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_daily_RouteDailyForm" property="REPORT_EMP" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_daily_RouteDailyForm" property="REMARK" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.status" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="sb_daily_RouteDailyForm" property="STATUS" /></td>
	</tr>

</table>
<div style="text-align:center;width:100%">

<DIV align="center" id ="winbody" name ="winbody" style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 98%;">

<TABLE class=listTable id=dataTable style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1 width="100%" align=center border=0 name="dataTable">
<TBODY>
<tr class="listTableTitle1" align="center">

		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.visit_date" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.emp_name" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.begin_time" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.end_time" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.car_no" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.city" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.county" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.towns" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.village" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.visit_type" bundle="<%=bundleKey%>"/></td>
</tr>
<%--todo:需要将数据行中主键和外键改为<html:hidden/>域,并删去<td>--%>
<%
    java.util.List detailList = sb_daily_RouteDailyForm.getDetailList_RouteDailyDetail();
    int detailSize = sb_daily_RouteDailyForm.getDetailSize_RouteDailyDetail();
    for(int i=0; i<detailSize; i++) {
        RouteDailyDetailForm detailForm = (RouteDailyDetailForm)detailList.get(i);
%>
<tr id=dataRow0 class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';" onmouseout="this.style.backgroundColor='';">

		<td class="singleDetailData"><%=detailForm.getVISIT_DATE()%></td>
		<td class="singleDetailData"><%=detailForm.getEMP_NAME()%></td>
		<td class="singleDetailData"><%=detailForm.getBEGIN_TIME()%></td>
		<td class="singleDetailData"><%=detailForm.getEND_TIME()%></td>
		<td class="singleDetailData"><%=detailForm.getCAR_NO()%></td>
		<td class="singleDetailData"><%=detailForm.getCITY()%></td>
		<td class="singleDetailData"><%=detailForm.getCOUNTY()%></td>
		<td class="singleDetailData"><%=detailForm.getTOWNS()%></td>
		<td class="singleDetailData"><%=detailForm.getVILLAGE()%></td>
		<td class="singleDetailData"><%=detailForm.getVISIT_TYPE()%></td>
</TR>
<%
}
%>



</TBODY>
</TABLE>
</div>
</div>
</html:form>
</BODY>
</HTML>