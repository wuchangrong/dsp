<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.handao.dsp.md.directory.direaut.web.DireautDetailForm" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<handao:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/directory/direaut/DireautAddEdit.js"></script>
<jsp:useBean id="md_directory_DireautForm" scope="request" class="com.handao.dsp.md.directory.direaut.web.DireautForm" />
<%
    String bundleKey = "dsp.md.directory.direaut";
%>
<HTML>

<HEAD>
<script type="text/javascript">
var ctx = '<%=ctx%>';

</script>

</HEAD>

<BODY class=singleDetailBody>
<html:form action="md/directory/direaut/Direaut.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>


<handao:headLink titleKey="dsp.md.directory.direaut.view.title" bundle="<%=bundleKey%>">
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>

</table>
<div style="text-align:center;width:100%">

<DIV align="center" id ="winbody" name ="winbody" style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 98%;">

<TABLE class=listTable id=dataTable style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1 width="100%" align=center border=0 name="dataTable">
<TBODY>
<tr class="listTableTitle1" align="center">

		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.directoryid" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.roleid" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.righadd" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.righdel" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.righedi" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.righvie" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.righaud" bundle="<%=bundleKey%>"/></td>
</tr>
<%--todo:需要将数据行中主键和外键改为<html:hidden/>域,并删去<td>--%>
<%
    java.util.List detailList = md_directory_DireautForm.getDetailList_DireautDetail();
    int detailSize = md_directory_DireautForm.getDetailSize_DireautDetail();
    for(int i=0; i<detailSize; i++) {
        DireautDetailForm detailForm = (DireautDetailForm)detailList.get(i);
%>
<tr id=dataRow0 class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';" onmouseout="this.style.backgroundColor='';">

		<td class="singleDetailData"><%=detailForm.getDIRECTORY_ID()%></td>
		<td class="singleDetailData"><%=detailForm.getROLE_ID()%></td>
		<td class="singleDetailData"><%=detailForm.getRIGHADD()%></td>
		<td class="singleDetailData"><%=detailForm.getRIGHDEL()%></td>
		<td class="singleDetailData"><%=detailForm.getRIGHEDI()%></td>
		<td class="singleDetailData"><%=detailForm.getRIGHVIE()%></td>
		<td class="singleDetailData"><%=detailForm.getRIGHAUD()%></td>
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