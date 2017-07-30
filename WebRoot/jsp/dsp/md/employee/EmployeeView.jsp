<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af"%>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/employee/EmployeeView.js"></script>

<jsp:useBean id="WMS_BASE_EMPLOYEE_EmployeeForm" scope="request" class="com.handao.dsp.md.employee.web.EmployeeForm" />
<%
  String bundleKey = "dsp.md.employee";
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody onload="init()">
<html:form action="/dsp/md/employee/Employee.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<af:headLink titleKey="dsp.md.employee.data_detail.title"  bundle="<%=bundleKey%>">
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<table id="subDetail" width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="EMP_ROW_ID"/>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.employee.data_detail.employeecode" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_EMPLOYEECODE"/></td>
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.employee.data_detail.employeename" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_EMPLOYEENAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_SHORT_CODE"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.companyid" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_COMPANY_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.deptid" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_DEPT_NAME"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.birthday" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_BIRTHDAY"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.addr" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_ADDR"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.tel" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_TEL"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.sex" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_SEX"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.idcard" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_IDCARD"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.email" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_EMAIL"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.degree" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_DEGREE_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.duty" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_DUTY_NAME"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.place" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_PLACE_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.employee.data_detail.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><bean:write name="WMS_BASE_EMPLOYEE_EmployeeForm" property="EMP_STATUS"/></td>
    </tr>

</table>
</html:form>
</BODY>
</HTML>