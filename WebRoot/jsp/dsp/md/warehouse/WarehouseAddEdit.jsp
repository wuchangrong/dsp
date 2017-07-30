<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<%
  String bundleKey = "dsp.md.warehouse";
%>
<HTML>

<HEAD>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/warehouse/WarehouseAddEdit.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" src="<%=ctx%>/platform/js/commonThree.js"></SCRIPT>
<script language="vbscript" src="<%=ctx%>/platform/vbs/common.vbs"></script>
</HEAD>

<BODY class=singleDetailBody">

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/warehouse/Warehouse.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>

<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
<af:headLink titleKey="dsp.md.warehouse.data_edit.title" bundle="<%=bundleKey%>">
    <af:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <af:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<af:hidden property="WH_ROW_ID"/>
<table id=EAP_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
        <td width="20%" align="right" class="singleDetailLabel"><af:label ><bean:message key="dsp.md.warehouse.data_edit.wh_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td width="30%"  colspan=1 class="singleDetailData"><af:text property="WH_WH_CODE" /> <font color="red">*</font></td>
        <td width="20%" align="right" class="singleDetailLabel"><af:label ><bean:message key="dsp.md.warehouse.data_edit.wh_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td width="30%" colspan=1 class="singleDetailData"><af:text property="WH_WH_NAME"/> <font color="red">*</font></td>
    </tr>
    <tr class="singleDetailRow">
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_edit.company_id" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:hidden property="WH_COMPANY_ID"/><af:text property="CP_COMPANY_NAME" readonly="true" style="readOnlyText"/></td>
        <td align="right" class="singleDetailLabel"><af:label ><bean:message key="dsp.md.warehouse.data_edit.location_id" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:select property="WH_LOCATION_ID" sql="select ROW_ID as CODE, LOCATION_NAME as NAME from MD_LOCATION order by ROW_ID"></af:select><font color="red">*</font></td>
    </tr>
    <tr class="singleDetailRow">     
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_edit.acreage" bundle="<%=bundleKey%>"  /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="WH_ACREAGE"  onkeypress="onlyNum(this)"/> <af:label><bean:message key="dsp.md.warehouse.data_edit.acreage.unit" bundle="<%=bundleKey%>"  /></af:label>&nbsp;</td>
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_edit.max_capacity" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><af:text property="WH_MAX_CAPACITY" onkeypress="onlyCheck(this)" /> <af:label><bean:message key="dsp.md.warehouse.data_edit.max_capacity.unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
    </tr>
    <tr class="singleDetailRow">
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_edit.address" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><af:text property="WH_ADDRESS" style="width:570"/></td>
     </tr>
    <tr class="singleDetailRow">
        <td align="right" valign="top" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_edit.remarks" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><af:textarea property="WH_REMARKS" cols="78" rows="3"/></td>
    </tr>

</table>
</html:form>
<div id="winbody"></div>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>