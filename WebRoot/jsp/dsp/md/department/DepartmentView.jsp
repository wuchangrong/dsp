<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af"%>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/department/DepartmentView.js"></script>

<jsp:useBean id="WMS_BASE_DEPARTMENT_DepartmentForm" scope="request" class="com.handao.dsp.md.department.web.DepartmentForm" />
<%
  String bundleKey = "dsp.md.department";
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody">
<html:form action="/dsp/md/department/Department.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<input type="hidden" name="DEPT_COMPANY_ID" value="<%=request.getParameter("DEPT_COMPANY_ID")%>" />
<input type="hidden" name="DEPT_PARENT_DEPT" value="<%=request.getParameter("DEPT_PARENT_DEPT")%>" />
<af:headLink titleKey="dsp.md.department.data_detail.title"  bundle="<%=bundleKey%>">
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="DEPT_ROW_ID"/>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.company_id" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_COMPANY_NAME"/></td>
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.dept_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_DEPT_CODE"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.dept_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_DEPT_NAME"/></td>
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_SHORT_CODE"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.default_unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_DEFAULT_UNIT"/></td>
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.is_location" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_IS_LOCATION_desc"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.is_visitsales" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_IS_VISITSALES_desc"/></td>
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.is_warehouse" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_IS_WAREHOUSE_desc"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.parent_dept" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_PARENT_NAME"/></td>
        <td class="singleDetailLabel" align="right" width="20%"><af:label><bean:message key="dsp.md.department.data_detail.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><bean:write name="WMS_BASE_DEPARTMENT_DepartmentForm" property="DEPT_STATUS_desc"/></td>
    </tr>

</table>
</html:form>
</BODY>
</HTML>