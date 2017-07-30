<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/company/CompanyAddEdit.js"></script>
<script language="javascript" src="<%=ctx%>/platform/js/commonThree.js"></script>
<script language=vbscript     src="<%=ctx%>/platform/vbs/common.vbs" ></script>
<%
  String bundleKey = "dsp.md.company";
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody onload="init()">

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/company/Company.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.company.data_edit.title" bundle="<%=bundleKey%>">
    <af:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table id=EAP_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
    <html:hidden property="CPN_ROW_ID"/>
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.company.data_edit.company_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><af:text property="CPN_COMPANY_CODE"/>&nbsp;<font color=red>*</font></td>
        <td class="singleDetailLabel"align="right" style="width:20%"><af:label><bean:message key="dsp.md.company.data_edit.company_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" style="width:30%"><af:text property="CPN_COMPANY_NAME"/>&nbsp;<font color=red>*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"  align="right" ><af:label><bean:message key="dsp.md.company.data_edit.short_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="CPN_SHORT_CODE"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.parent_company" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData">
         <af:select property="CPN_PARENT_COMPANY" sql='select ROW_ID as CODE, COMPANY_NAME as NAME from MD_COMPANY order by ROW_ID'></af:select>       
        </td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.begin_date" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:date property="CPN_BEGIN_DATE"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.accclose_day" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:double property="CPN_ACCCLOSE_DAY" precision="(4,0)"/>&nbsp;（日）</td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.legal_person" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="CPN_LEGAL_PERSON"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.bank" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="CPN_BANK"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.account_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="CPN_ACCOUNT_NO"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.tax_no" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="CPN_TAX_NO"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.tax_rate" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:double property="CPN_TAX_RATE" precision="(22,7)"/>&nbsp;<af:label><bean:message key="dsp.md.company.data_edit.tax_rate_unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.calc_mode" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData">
        <af:select property="CPN_CALC_MODE" lovCode="CALC_MODE"></af:select>       
        </td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.default_unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="CPN_DEFAULT_UNIT"/></td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.company.data_edit.status" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:checkbox property="CPN_STATUS" checkValue="1" unCheckValue="0"/></td>
    </tr>

</table>
<div id="winbody" name="winbody"></div>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>