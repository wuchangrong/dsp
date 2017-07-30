<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af"%>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/warehouse/WarehouseView.js"></script>

<jsp:useBean id="WMS_BASE_WAREHOUSE_WarehouseForm" scope="request" class="com.handao.dsp.md.warehouse.web.WarehouseForm" />
<%
  String bundleKey = "dsp.md.warehouse";
%>
<HTML>

<HEAD>
</HEAD>

<BODY class=singleDetailBody>
<html:form action="dsp/md/warehouse/Warehouse.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<af:headLink titleKey="dsp.md.warehouse.data_detail.title"  bundle="<%=bundleKey%>">
    <af:headButton name="·µ»Ø" accesskey="R" onClick="returnPage()"/>
</af:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="WH_ROW_ID"/>
    <tr class="singleDetailRow">
        <td  width="20%" align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.wh_code" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td  width="30%" colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="WH_WH_CODE"/></td>
        <td  width="20%" align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.wh_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td  width="30%" colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="WH_WH_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.company_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="CP_COMPANY_NAME"/></td>
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.location_name" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="LT_LOCATION_NAME"/></td>
    </tr>

    <tr class="singleDetailRow">   
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.acreage" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="WH_ACREAGE"/> <af:label><bean:message key="dsp.md.warehouse.data_edit.acreage.unit" bundle="<%=bundleKey%>"  /></af:label>&nbsp;</td>

        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.max_capacity" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="WH_MAX_CAPACITY"/> <af:label><bean:message key="dsp.md.warehouse.data_edit.max_capacity.unit" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
    </tr>
   <tr class="singleDetailRow">
        <td align="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.address" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="WH_ADDRESS"/></td>
   </tr>   
    <tr class="singleDetailRow">    
        <td align="right" valign="right" class="singleDetailLabel"><af:label><bean:message key="dsp.md.warehouse.data_detail.remarks" bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><bean:write name="WMS_BASE_WAREHOUSE_WarehouseForm" property="WH_REMARKS"/></td>
    </tr>

</table>
</html:form>
</BODY>
</HTML>