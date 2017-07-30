<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/department/DepartmentAddEdit.js"></script>
<script language="javascript" src="<%=ctx%>/platform/js/commonThree.js"></script>
<script language="vbscript" src="<%=ctx%>/platform/vbs/common.vbs"></script>
<%
  String bundleKey = "dsp.md.department";
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody onload="initCheckbox('<%=ctx %>')">

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/department/Department.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="DEPT_COMPANY_ID" value="<%=request.getParameter("DEPT_COMPANY_ID")%>" />
<input type="hidden" name="DEPT_PARENT_DEPT" value="<%=request.getParameter("DEPT_PARENT_DEPT")%>" />
<%--<input type="hidden" name="IS_COMPANY" value="<%=request.getParameter("IS_COMPANY")%>" />--%>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.department.data_edit.title" bundle="<%=bundleKey%>">
<%--    <af:headButton name="保存并新增" accesskey="N" onClick="saveAndNewRecord();"/>--%>
    <af:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table id=EAP_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
	<html:hidden property="DEPT_ROW_ID"/>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_edit.dept_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="DEPT_DEPT_CODE"/><font color="red">&nbsp;*</font></td>
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_edit.dept_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="DEPT_DEPT_NAME"/><font color="red">&nbsp;*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.department.data_edit.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="DEPT_SHORT_CODE"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.department.data_edit.default_unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData">
        	<af:select property="DEPT_DEFAULT_UNIT" lovCode="MD_UNIT"></af:select><font color="red">&nbsp;*</font>
        </td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.department.data_edit.is_location" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:checkbox property="DEPT_IS_LOCATION" checkValue="Y" unCheckValue="N"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.department.data_edit.is_visitsales" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:checkbox property="DEPT_IS_VISITSALES" checkValue="Y" unCheckValue="N"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.department.data_edit.is_warehouse" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:checkbox property="DEPT_IS_WAREHOUSE" checkValue="Y" unCheckValue="N"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.department.data_edit.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:checkbox property="DEPT_STATUS" checkValue="1" unCheckValue="0"/></td>
    </tr>

</table>
<div style="text-align:center;width:100%">
<!--------------------------begin detail data table------------------------------------------->
<DIV align="center" id ="winbody" name ="winbody" style="height:auto; OVERFLOW:auto;margin: 0 auto;width: 98%;">
</DIV></div>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>
<%@include file="/jsp/dsp/md/department/DepartmentAddEditInclude.jsp" %>