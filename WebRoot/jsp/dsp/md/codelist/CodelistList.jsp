<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/codelist/CodelistList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage" />

<%
  String bundleKey = "dsp.md.codelist";
  ArrayList fieldList = new ArrayList();
    fieldList.add(new AFField("type_ROW_ID","dsp.md.codelist.data_list.row_id","25","center",AFField.SHOW_TYPE_CHECKBOX,""));
    fieldList.add(new AFField("type_TYPE_CODE","dsp.md.codelist.data_list.type_code","","center","",""));
    fieldList.add(new AFField("type_TYPE_NAME","dsp.md.codelist.data_list.type_name","","center","",""));
    fieldList.add(new AFField("type_COMMENTS","dsp.md.codelist.data_list.comments","","center","",""));
    fieldList.add(new AFField("code_LOV_NAME","dsp.md.codelist.data_list.lov_name","","center","",""));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>



</HEAD>

<BODY class="singleDetailBody">

<%@include file="/platform/jsp/include/popIframe.jsp" %>

<html:form action="/dsp/md/codelist/Codelist.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.codelist.quick_query.title"  bundle="<%=bundleKey%>">
    <af:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <af:headButton name="新增" accesskey="N" onClick="createRecord();"/>
    <af:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <af:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <af:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</af:headLink>

<af:customQueryArea>
<%-- todo:可以自定义查询table--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.codelist.quick_query.type_code"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="searchForm.type_TYPE_CODE"/></td>
        <td class="singleDetailLabel" width="20%" align="right"><af:label><bean:message key="dsp.md.codelist.quick_query.type_name"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=1 class="singleDetailData" width="30%"><af:text property="searchForm.type_TYPE_NAME"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right"><af:label><bean:message key="dsp.md.codelist.quick_query.status"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td colspan=3 class="singleDetailData"><af:select property="searchForm.type_STATUS" lovCode="MD_TRUEFAL"/></td>
    </tr>

</af:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>