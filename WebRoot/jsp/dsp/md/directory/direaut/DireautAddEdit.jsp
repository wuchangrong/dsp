<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/directory/direaut/DireautAddEdit.js"></script>
<jsp:useBean id="md_directory_DireautForm" scope="request" class="com.handao.dsp.md.directory.direaut.web.DireautForm" />

<%
  String bundleKey = "dsp.md.directory.direaut";
	int rowNum = md_directory_DireautForm.getDetailSize_DireautDetail();
	int showRowNum = rowNum;
 %>

<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody>

<%@include file="/platform/jsp/include/popIframe.jsp" %>

<html:form action="md/directory/direaut/Direaut.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<html:hidden property="detailExtendSize"/>
<html:hidden property="isSubdir" value="0"/>
<html:hidden property="currentDirID" value="0"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.md.directory.direaut.edit.title" bundle="<%=bundleKey%>">
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="保存到子目录" accesskey="R" onClick="saveForSubdir()"/>
    <handao:headButton name="删除" accesskey="R" onClick="deleteRecord()"/>
    <handao:headButton name="删除到子目录" accesskey="R" onClick="deleteForSubdir()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>

</table>

<div style="text-align:center;width:100%">
<!--------------------------begin detail data table------------------------------------------->
<DIV align="center" id ="winbody" name ="winbody" style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 98%;">

<TABLE class=listTable id=dataTable style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1 width="100%" align=center border=0 name="dataTable">

<tr class="listTableTitle1" align="center">

		<td align="center" class="tableTitleTD"><bean:message key="dsp.md.directory.direaut.detail.roleid" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD" width="10%"><bean:message key="dsp.md.directory.direaut.detail.righadd" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD" width="10%"><bean:message key="dsp.md.directory.direaut.detail.righdel" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD" width="10%"><bean:message key="dsp.md.directory.direaut.detail.righedi" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD" width="10%"><bean:message key="dsp.md.directory.direaut.detail.righvie" bundle="<%=bundleKey%>"/></td>
		<td align="center" class="tableTitleTD" width="10%"><bean:message key="dsp.md.directory.direaut.detail.righaud" bundle="<%=bundleKey%>"/></td>
<td width="1%" align=center>
</tr>
<%--todo:需要将数据行中主键和外键改为<html:hidden/>域,并删去<td>--%>
<% for(int i=0;i<rowNum;i++)
{
    if (i<showRowNum){%>
<TR id=dataRow<%=i%>  class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';"onmouseout="this.style.backgroundColor='';" style="display:''" >
    <%} else{%>
<TR id=dataRow<%=i%>  class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';" onmouseout="this.style.backgroundColor='';" style="display:'none'">    <%}%>

		<html:hidden property='<%="detailForm_DireautDetail[" + i + "].DIRECTORY_ID"%>'/>
		<html:hidden property='<%="detailForm_DireautDetail[" + i + "].ROLE_ID"%>'/>
		<td><bean:write name="md_directory_DireautForm" property='<%="detailForm_DireautDetail[" + i + "].ROLE_NAME"%>' /></td>
		<td><handao:checkbox property='<%="detailForm_DireautDetail[" + i + "].RIGHADD"%>' checkValue="Y" unCheckValue="N"/></td>
		<td><handao:checkbox property='<%="detailForm_DireautDetail[" + i + "].RIGHDEL"%>' checkValue="Y" unCheckValue="N" /></td>
		<td><handao:checkbox property='<%="detailForm_DireautDetail[" + i + "].RIGHEDI"%>' checkValue="Y" unCheckValue="N" /></td>
		<td><handao:checkbox property='<%="detailForm_DireautDetail[" + i + "].RIGHVIE"%>' checkValue="Y" unCheckValue="N" /></td>
		<td><handao:checkbox property='<%="detailForm_DireautDetail[" + i + "].RIGHAUD"%>' checkValue="Y" unCheckValue="N" /></td>
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
setFocus("detailForm_DireautDetail",eval("<%=rowNum%>-1"),"d_ROW_ID");
</script>