<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script type="text/javascript">
var ctx="<%=ctx%>";
</script>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/employee/EmployeeAddEdit.js"></script>
<script language="javascript" src="<%=ctx%>/platform/js/commonThree.js"></script>
<script language="vbscript" src="<%=ctx%>/platform/vbs/common.vbs"></script>
<%
  String bundleKey = "dsp.md.employee";
String doWhat = (String)request.getParameter("doWhat");
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody">

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/employee/Employee.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.employee.data_edit.title" bundle="<%=bundleKey%>">
    <af:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table id=EAP_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
      <html:hidden property="EMP_ROW_ID"/>
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.employee.data_edit.employeecode" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><af:text property="EMP_EMPLOYEECODE"/>&nbsp;<font color=red>*</font></td>
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.employee.data_edit.employeename" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><af:text property="EMP_EMPLOYEENAME"/>&nbsp;<font color=red>*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="EMP_SHORT_CODE"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.companyid" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="EMP_COMPANYID" sql='select ROW_ID as CODE, COMPANY_NAME as NAME from MD_COMPANY order by ROW_ID'></af:select>&nbsp;<font color=red>*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.deptid" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="EMP_DEPTID" sql='select ROW_ID as CODE, DEPT_NAME as NAME from MD_DEPT order by ROW_ID'></af:select>&nbsp;<font color=red>*</font></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.birthday" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:date property="EMP_BIRTHDAY"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.addr" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="EMP_ADDR"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.tel" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="EMP_TEL"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.sex" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="EMP_SEX" lovCode="MD_SEXTYP"></af:select></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.idcard" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="EMP_IDCARD"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.email" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="EMP_EMAIL"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.degree" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="EMP_DEGREE" 
							lovCode="DEGREE"></af:select>&nbsp;<font color=red>*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.duty" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="EMP_DUTY"
							lovCode="DUTY"></af:select>&nbsp;<font color=red>*</font></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.place" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="EMP_PLACE" 
							lovCode="PLACE"></af:select>&nbsp;<font color=red>*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_edit.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><af:checkbox property="EMP_STATUS" checkValue="1" unCheckValue="0"/></td>
    </tr>

</table>
<div id="winbody" name="winbody"></div>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>