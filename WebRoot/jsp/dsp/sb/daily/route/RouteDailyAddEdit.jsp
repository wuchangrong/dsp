<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/sb/daily/route/RouteDailyAddEdit.js"></script>
<jsp:useBean id="sb_daily_RouteDailyForm" scope="request" class="com.handao.dsp.sb.daily.route.web.RouteDailyForm" />

<%
  String bundleKey = "dsp.sb.daily.route";

  com.handao.platform.framework.envelope.UserToken userToken = (com.handao.platform.framework.envelope.UserToken)session.getAttribute("userToken");
  String companyId = userToken.getCompanyId()+"";
  String deptId = userToken.getDeptId()+"";

	int rowNum = sb_daily_RouteDailyForm.getDetailSize_RouteDailyDetail();
	int showRowNum = 15;//显示的行数
	if (showRowNum<rowNum)
	{
          showRowNum = rowNum;
	}
	if(rowNum<40)
	{
          rowNum = 40;  //总行数
	}
 %>

<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody>

<%@include file="/platform/jsp/include/popIframe.jsp" %>

<html:form action="sb/daily/route/RouteDaily.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<html:hidden property="detailExtendSize"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.sb.daily.route.edit.title" bundle="<%=bundleKey%>">
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
<html:hidden property="COMPANY_ID" value="<%=companyId%>"/>
<html:hidden property="DEPT_ID" value="<%=deptId%>"/>

	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.visit_date" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:date property="VISIT_DATE"  /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.report_emp" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="REPORT_EMP" maxcharlength="32" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:textarea property="REMARK" maxcharlength="400" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.sb.daily.route.status" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="STATUS" maxcharlength="1" /></td>
	</tr>

</table>

<div style="text-align:center;width:100%">
<!--------------------------begin detail data table------------------------------------------->
<DIV align="center" id ="winbody" name ="winbody" style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 98%;">

<TABLE class=listTable id=dataTable style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1 width="100%" align=center border=0 name="dataTable">

<tr class="listTableTitle1" align="center">
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.emp_name" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.car_no" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.city" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.county" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.towns" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.village" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.visit_type" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.begin_time" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.sb.daily.route.detail.end_time" bundle="<%=bundleKey%>"/></td>		
<td width="1%" align=center>
</tr>
<%--todo:需要将数据行中主键和外键改为<html:hidden/>域,并删去<td>--%>
<% for(int i=0;i<rowNum;i++)
{
    if (i<showRowNum){%>  
<TR id=dataRow<%=i%>  class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';"onmouseout="this.style.backgroundColor='';" style="display:''" >
    <%} else{%>
<TR id=dataRow<%=i%>  class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';" onmouseout="this.style.backgroundColor='';" style="display:'none'">    <%}%>
<html:hidden property="<%="detailForm_RouteDailyDetail[" + i + "].EMP_ID"%>" value="0"/>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].EMP_NAME"%>' maxcharlength="50" onkeypress='<%="on_keypress(xmlhttp,"+i+",'EMP_NAME','CAR_NO')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].CAR_NO"%>' maxcharlength="32" onkeypress='<%="on_keypress(xmlhttp,"+i+",'CAR_NO','CITY')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].CITY"%>' maxcharlength="50" onkeypress='<%="on_keypress(xmlhttp,"+i+",'CITY','COUNTY')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].COUNTY"%>' maxcharlength="50" onkeypress='<%="on_keypress(xmlhttp,"+i+",'COUNTY','TOWNS')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].TOWNS"%>' maxcharlength="50" onkeypress='<%="on_keypress(xmlhttp,"+i+",'TOWNS','VILLAGE')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].VILLAGE"%>' maxcharlength="50" onkeypress='<%="on_keypress(xmlhttp,"+i+",'VILLAGE','VISIT_TYPE')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].VISIT_TYPE"%>' maxcharlength="32" onkeypress='<%="on_keypress(xmlhttp,"+i+",'VISIT_TYPE','BEGIN_TIME')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].BEGIN_TIME"%>' maxcharlength="8" onkeypress='<%="on_keypress(xmlhttp,"+i+",'BEGIN_TIME','END_TIME')"%>' styleClass="editTextNoBorder"/></td>
		<td><handao:text property='<%="detailForm_RouteDailyDetail[" + i + "].END_TIME"%>' maxcharlength="8" onkeypress='<%="on_keypress(xmlhttp,"+i+",'END_TIME','EMP_NAME')"%>' styleClass="editTextNoBorder"/></td>		
    <td align=center><a id="btnDelete" class="textRed" title="删除" style="cursor:hand"  onclick="deleteThisRow(this,false);  ">X</a></td>
</TR>
<%}%>
</TABLE>
</DIV></DIV>

</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>

<script language="javascript">
//todo:处理增加行后,定位问题
//name:需要定位的控件名
setFocus("detailForm_RouteDailyDetail",eval("<%=rowNum%>-1"),"d_ROW_ID");
</script>