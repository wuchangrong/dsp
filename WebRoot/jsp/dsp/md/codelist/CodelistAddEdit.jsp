<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.handao.platform.framework.util.AFConstants,com.handao.dsp.md.codelist.web.CodelistDetailForm"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/platform/js/commonThree.js"></script>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/codelist/CodelistAddEdit.js"></script>
<jsp:useBean id="WMS_BASE_CODELIST_CodelistForm" scope="request" class="com.handao.dsp.md.codelist.web.CodelistForm" />

  
<%
    String bundleKey = "dsp.md.codelist";
	int rowNum = WMS_BASE_CODELIST_CodelistForm.getDetailSize_CodelistDetail();
	int showRowNum = 10;//显示的行数
	if (showRowNum<rowNum)
	{
          showRowNum = rowNum;
	}
	if(rowNum<20)
	{
          rowNum = 20;  //总行数
	}
 %>

<HTML>

<HEAD>
<script type="text/javascript">
function checkCodeValue(id)
{
	var codeValue = document.all("detailForm_CodelistDetail[" + id + "].list_CODE_VALUE");
	if(codeValue.value == "" ||codeValue.value == null)
	{
		return;
	}
	for(var i=0;i<<%=showRowNum%>;i++)
	{
		if(i != id)
		{
			if(codeValue.value.trim() == document.all("detailForm_CodelistDetail[" + i + "].list_CODE_VALUE").value.trim())
			{
				alert("不能出现重复的值，请重新输入。");
				codeValue.value = "";
				codeValue.focus();
				return;
			}
		}
	}
}

function clickDefaultVal(id)
{
	var rowNum = <%=rowNum%>;
	for(i=0;i<rowNum;i++)
	{
		if(document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK").checked)
		{
			if(i != id)
			{
				document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK").checked=false;
				document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT").value='N';
			}else
			{
				document.all("detailForm_CodelistDetail[" + id + "].list_IS_DEFAULT").value = 'Y';
			}
		}
		else
		{
			document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT").value='N';
		}
	}
}

function init()
{
	if(document.getElementById("doWhat").value == "add")
	{
		var rowNum = <%=rowNum%>;
		for(i=0;i<rowNum;i++)
		{
			document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK").checked=false;
			document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT").value='N';	
		}
	}else
	{
		var rowNum = <%=rowNum%>;
		for(i=0;i<rowNum;i++)
		{
			if(document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT").value=='Y')
			{
				document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK").checked=true;
			}else
			{
				document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT").value='N';
				document.all("detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK").checked=false;
			}
		}
	}
}
</script>
</HEAD>

<BODY class=singleDetailBody onload="init()">

<%@include file="/platform/jsp/include/popIframe.jsp" %>

<html:form action="/dsp/md/codelist/Codelist.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<html:hidden property="detailExtendSize"/>
<html:hidden property="type_ROW_ID"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.codelist.data_edit.title" bundle="<%=bundleKey%>">
    <af:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<table id=EAP_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.codelist.data_edit.type_code" bundle="<%=bundleKey%>"/></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="type_TYPE_CODE"/>&nbsp;<font color="red">*</font></td>
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.codelist.data_edit.type_name" bundle="<%=bundleKey%>"/></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="type_TYPE_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.codelist.data_edit.status" bundle="<%=bundleKey%>"/></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><af:select property="type_STATUS" lovCode="MD_TRUEFAL"/>&nbsp;<font color="red">*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" valign="top"><af:label><bean:message key="dsp.md.codelist.data_edit.comments" bundle="<%=bundleKey%>"/></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><af:textarea property="type_COMMENTS" rows="3" cols="78"/></td>
    </tr>

</table>

<div style="text-align:center;width:100%;margin-left:1%;margin-right:1%">
<!--------------------------begin detail data table------------------------------------------->
<DIV align="center" id ="winbody" name ="winbody" style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 100%;float: left">

<TABLE class=listTable id=dataTable
style="TABLE-LAYOUT: fixed; WORD-WRAP: break-word" cellSpacing=1 cellPadding=1
width="100%" align=center border=0 name="dataTable">
<%--
  todo:需要将标题行中主键和外键的<td>删去
--%>
<tr class="listTableTitle1" align="center">
    <td align="center" class="tableTitleTD" width="150"><bean:message key="dsp.md.codelist.detail_list.code_name" bundle="<%=bundleKey%>"/></td>
    <td align="center" class="tableTitleTD" width="80"><bean:message key="dsp.md.codelist.detail_list.code_value" bundle="<%=bundleKey%>"/></td>
    <td align="center" class="tableTitleTD" width="40"><bean:message key="dsp.md.codelist.detail_list.sort_code" bundle="<%=bundleKey%>"/></td>
    <td align="center" class="tableTitleTD"><bean:message key="dsp.md.codelist.detail_list.comments" bundle="<%=bundleKey%>"/></td>
    <td align="center" class="tableTitleTD" width="60"><bean:message key="dsp.md.codelist.detail_list.status" bundle="<%=bundleKey%>"/></td>
    <td align="center" class="tableTitleTD" width="60"><bean:message key="dsp.md.codelist.detail_list.is_defualt" bundle="<%=bundleKey%>"/></td>
<td width="1%" align=center>
</tr>
<%--todo:需要将数据行中主键和外键改为<html:hidden/>域,并删去<td>--%>
<% for(int i=0;i<rowNum;i++)
{
    if (i<showRowNum){%>
<TR id=dataRow<%=i%>  class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';"onmouseout="this.style.backgroundColor='';" style="display:''" >
    <%} else{%>
<TR id=dataRow<%=i%>  class=listTableOdd onMouseOver="this.style.backgroundColor='#F1F1F1';" onmouseout="this.style.backgroundColor='';" style="display:'none'">    <%}%>
<html:hidden property='<%="detailForm_CodelistDetail[" + i + "].list_ROW_ID"%>' />
    <td><af:text property='<%="detailForm_CodelistDetail[" + i + "].list_CODE_NAME"%>' onkeypress='<%="on_keypress(xmlhttp,"+i+",\'list_CODE_NAME\',\'list_CODE_VALUE\')"%>' styleClass="editTextNoBorder"/></td>
    <td><af:text property='<%="detailForm_CodelistDetail[" + i + "].list_CODE_VALUE"%>' onkeypress='<%="on_keypress(xmlhttp,"+i+",\'list_CODE_VALUE\',\'list_SORT_CODE\')"%>' styleClass="editTextNoBorder" onblur='<%="checkCodeValue("+i+")"%>'/></td>
    <td><af:text property='<%="detailForm_CodelistDetail[" + i + "].list_SORT_CODE"%>' onkeypress='<%="on_keypress(xmlhttp,"+i+",\'list_SORT_CODE\',\'list_COMMENTS\')"%>' styleClass="editTextNoBorder"/></td>
    <td><af:text property='<%="detailForm_CodelistDetail[" + i + "].list_COMMENTS"%>' onkeypress='<%="on_keypress(xmlhttp,"+i+",\'list_COMMENTS\',\'list_STATUS\')"%>' styleClass="editTextNoBorder"/></td>
    <td align="center"><af:checkbox property='<%="detailForm_CodelistDetail[" + i + "].list_STATUS"%>' checkValue="0" unCheckValue="1" onkeypress='<%="on_keypress(xmlhttp,"+i+",\'list_STATUS\',\'list_CODE_NAME\')"%>'/></td>
    <td align="center"><input type="checkbox" name='<%="detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK"%>' id='<%="detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT_CHK"%>' onclick='<%="clickDefaultVal("+i+")"%>' />
    <html:hidden property='<%="detailForm_CodelistDetail[" + i + "].list_IS_DEFAULT"%>'/></td>
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
setFocus("detailForm_CodelistDetail",eval("<%=rowNum%>-1"),"list_CODE_NAME");
</script>