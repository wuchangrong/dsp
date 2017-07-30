<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af"%>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/supplier/SupplierView.js"></script>

<jsp:useBean id="WMS_BASE_SUPPLIER_SupplierForm" scope="request" class="com.handao.dsp.md.supplier.web.SupplierForm" />
<%
  String bundleKey = "dsp.md.supplier";
%>
<HTML>

<HEAD>
</HEAD>

<BODY class=singleDetailBody onload="init()">
<html:form action="dsp/md/supplier/Supplier.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<input type="hidden" name="area">	
<input type="hidden" name="province">

<af:headLink titleKey="dsp.md.supplier.data_detail.title"  bundle="<%=bundleKey%>">
    <af:headButton name="·µ»Ø" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="SUP_ROW_ID"/>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.suppliercode" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"  width="30%"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_SUPPLIERCODE"/></td>
        <td class="singleDetailLabel"  width="20%" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.supplierdesc" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"  width="30%"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_SUPPLIERDESC"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_SHORT_CODE"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.suppliertype_id" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUPPLIER_TYPE_DESC"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.addr" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_ADDR"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.tax_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_TAX_NO"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.depositary_bank" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_DEPOSITARY_BANK"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.account_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_ACCOUNT_NO"/></td>            
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.legal_person" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_LEGAL_PERSON"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.contactperson" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_CONTACTPERSON"/></td>        
    </tr>
    <tr class="singleDetailRow">        
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.tel" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_TEL"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_detail.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="STATUSNAME"/></td>
    </tr>
</table>
</html:form>
</BODY>
</HTML>