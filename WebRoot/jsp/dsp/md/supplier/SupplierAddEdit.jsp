<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script type="text/javascript">
<!--
var ctx="<%=ctx%>";
//-->
</script>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/supplier/SupplierAddEdit.js"></script>
<script language="javascript" src="<%=ctx%>/platform/js/commonThree.js"></script>
<script language="vbscript" src="<%=ctx%>/platform/vbs/common.vbs"></script>

<jsp:useBean id="WMS_BASE_SUPPLIER_SupplierForm" scope="request" class="com.handao.dsp.md.supplier.web.SupplierForm" />
<%
  String bundleKey = "dsp.md.supplier";
%>
<HTML>

<HEAD>
</HEAD>

<BODY class=singleDetailBody onload="init()">

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<div id="winbody" style="display:none"></div>
<html:form action="/dsp/md/supplier/Supplier.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="area">	
<input type="hidden" name="province">
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
<input type="hidden" name="SUP_ROW_ID" value="<bean:write name="WMS_BASE_SUPPLIER_SupplierForm" property="SUP_ROW_ID"/>" />
<af:headLink titleKey="dsp.md.supplier.data_edit.title" bundle="<%=bundleKey%>">
    <af:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.suppliercode" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="SUP_SUPPLIERCODE"/>&nbsp;<font color="red">*</font></td>
        <td class="singleDetailLabel" width="20%" align="right" ><af:label><bean:message key="dsp.md.supplier.data_edit.supplierdesc" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="SUP_SUPPLIERDESC"/>&nbsp;<font color="red">*</font></td>              
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_SHORT_CODE"/></td>
         
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.addr" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_ADDR"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.tax_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_TAX_NO"/></td>       
    </tr>
    
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.depositary_bank" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_DEPOSITARY_BANK"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.account_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_ACCOUNT_NO"/></td>
        
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.legal_person" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_LEGAL_PERSON"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.contactperson" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_CONTACTPERSON"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.tel" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="SUP_TEL"/></td>
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.supplier.data_edit.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData">
        <af:checkbox property="SUP_STATUS" checkValue="1" unCheckValue="0"></af:checkbox></td>       
    </tr>
    <af:hidden property="SUP_PROVINCEID"></af:hidden>
    <af:hidden property="SUP_DISTRICTID"></af:hidden>
</table>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>