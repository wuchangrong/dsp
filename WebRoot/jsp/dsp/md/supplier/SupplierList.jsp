<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css/>
<af:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/supplier/SupplierList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.md.supplier";
  ArrayList fieldList = new ArrayList();
    fieldList.add(new AFField("SUP_ROW_ID","dsp.md.supplier.data_list.row_id","25","center",AFField.SHOW_TYPE_CHECKBOX,""));
    fieldList.add(new AFField("SUP_SUPPLIERCODE","dsp.md.supplier.data_list.suppliercode","","center","",""));
    fieldList.add(new AFField("SUP_SUPPLIERDESC","dsp.md.supplier.data_list.supplierdesc","30%","center","",""));
    fieldList.add(new AFField("SUP_SHORT_CODE","dsp.md.supplier.data_list.short_code","","center","",""));
    fieldList.add(new AFField("SUP_CONTACTPERSON","dsp.md.supplier.data_list.contactperson","","center","",""));
    fieldList.add(new AFField("SUP_TEL","dsp.md.supplier.data_list.tel","","center","",""));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>
<script type="text/javascript">
function init()
{
    document.getElementById('area').value = parent.document.getElementById('area').value;
    document.getElementById('province').value = parent.document.getElementById('province').value;
}
</script>
<HEAD>


</HEAD>

<BODY class="singleDetailBody" onload="init()">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/supplier/Supplier.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="area">	
<input type="hidden" name="province">
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.supplier.quick_query.title" bundle="<%=bundleKey%>">
    <af:headButton name="新增" accesskey="N" onClick="createRecord();"/>
    <af:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <af:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <af:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</af:headLink>


<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>