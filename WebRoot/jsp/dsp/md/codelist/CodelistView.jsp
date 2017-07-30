<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.handao.dsp.md.codelist.web.CodelistDetailForm" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css/>
<af:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/codelist/CodelistView.js"></script>
<jsp:useBean id="WMS_BASE_CODELIST_CodelistForm" scope="request" class="com.handao.dsp.md.codelist.web.CodelistForm" />
<%
    String bundleKey = "dsp.md.codelist";
%>
<HTML>

<HEAD>


</HEAD>

<BODY class=singleDetailBody>
<html:form action="/dsp/md/codelist/Codelist.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<af:headLink titleKey="dsp.md.codelist.detail_view.title" bundle="<%=bundleKey%>">
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>



<table id="EAP_FormTable" width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.codelist.data_view.type_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_CODELIST_CodelistForm" property="type_TYPE_CODE"/></td>
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.codelist.data_view.type_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_CODELIST_CodelistForm" property="type_TYPE_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.codelist.data_view.lov_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><bean:write name="WMS_BASE_CODELIST_CodelistForm" property="code_LOV_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.codelist.data_view.comments" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><bean:write name="WMS_BASE_CODELIST_CodelistForm" property="type_COMMENTS"/></td>
    </tr>

</table>
<div style="text-align:center;width:100%">

<DIV align="center" id ="winbody" name ="winbody" style="height:380; OVERFLOW:auto;margin: 0 auto;width: 98%;">

<TABLE class=listTable id=dataTable style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1 width="100%" align=center border=0 name="dataTable">
<TBODY>
<tr class="listTableTitle1" align="center">
    <td align="center" class="tableTitleTD" width="150"><bean:message key="dsp.md.codelist.detail_list_view.code_name" bundle="<%=bundleKey%>" /></td>
    <td align="center" class="tableTitleTD" width="80"><bean:message key="dsp.md.codelist.detail_list_view.code_value" bundle="<%=bundleKey%>" /></td>
    <td align="center" class="tableTitleTD" width="40"><bean:message key="dsp.md.codelist.detail_list_view.sort_code" bundle="<%=bundleKey%>" /></td>
    <td align="center" class="tableTitleTD"><bean:message key="dsp.md.codelist.detail_list_view.comments" bundle="<%=bundleKey%>" /></td>
    <td align="center" class="tableTitleTD" width="60"><bean:message key="dsp.md.codelist.detail_list_view.lov_name" bundle="<%=bundleKey%>" /></td>
    <td align="center" class="tableTitleTD" width="60"><bean:message key="dsp.md.codelist.detail_list_view.is_defualt" bundle="<%=bundleKey%>" /></td>
</tr>
<%--todo:需要将数据行中主键和外键改为<html:hidden/>域,并删去<td>--%>
<%
    java.util.List detailList = WMS_BASE_CODELIST_CodelistForm.getDetailList_CodelistDetail();
    int detailSize = WMS_BASE_CODELIST_CodelistForm.getDetailSize_CodelistDetail();
    for(int i=0; i<detailSize; i++) {
        CodelistDetailForm detailForm = (CodelistDetailForm)detailList.get(i);
%>
<tr id=dataRow0 class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';" onmouseout="this.style.backgroundColor='';">
<td class="singleDetailData"><%=detailForm.getList_CODE_NAME()%></td>
<td class="singleDetailData"><%=detailForm.getList_CODE_VALUE()%></td>
<td class="singleDetailData"><%=detailForm.getList_SORT_CODE()%></td>
<td class="singleDetailData"><%=detailForm.getList_COMMENTS()%></td>
<td class="singleDetailData"><%=detailForm.getCode_LOV_NAME()%></td>
<td class="singleDetailData"><%="Y".equals(detailForm.getList_IS_DEFAULT())?"是":"否"%></td>
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
<script>
    //主从表查看从表数据列表,表头固定
    window.onresize = _tag_ResizeTableNoNavigationMDDetailList;
    _tag_ResizeTableNoNavigationMDDetailList();
</script>