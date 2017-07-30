<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af"%>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/company/CompanyView.js"></script>

<jsp:useBean id="WMS_BASE_COMPANY_CompanyForm" scope="request" class="com.handao.dsp.md.company.web.CompanyForm" />
<%
  String bundleKey = "dsp.md.company";
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody onload="init()">
<html:form action="/dsp/md/company/Company.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<af:headLink titleKey="dsp.md.company.data_detail.title"  bundle="<%=bundleKey%>">
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<table id=subDetail width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="CPN_ROW_ID"/>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.company.data_detail.company_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_COMPANY_CODE"/></td>
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.company.data_detail.company_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_COMPANY_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"  align="right"><af:label><bean:message key="dsp.md.company.data_detail.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_SHORT_CODE"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.parent_company" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_PARENT_COMPANY_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.begin_date" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_BEGIN_DATE"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.accclose_day" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_ACCCLOSE_DAY"/>&nbsp;（日）</td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.legal_person" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_LEGAL_PERSON"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.bank" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_BANK"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.account_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_ACCOUNT_NO"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.tax_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_TAX_NO"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.tax_rate" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_TAX_RATE"/>&nbsp;<af:label><bean:message key="dsp.md.company.data_edit.tax_rate_unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.calc_mode" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_CALC_MODE_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.default_unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_DEFAULT_UNIT"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.company.data_detail.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_COMPANY_CompanyForm" property="CPN_STATUS"/></td>
    </tr>

</table>
</html:form>
</BODY>
</HTML>