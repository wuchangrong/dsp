<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.handao.util.AFConstants,
                 com.handao.platform.handao.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<handao:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/directory/direaut/DireautList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.handao.envelope.AFPage"/>

<%
  String bundleKey = "dsp.md.directory.direaut";
  ArrayList fieldList = new ArrayList();
	fieldList.add(new AFField("ROW_ID","dsp.md.directory.direaut.rowid","3%","center",AFField.SHOW_TYPE_CHECKBOX,""));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="md/directory/direaut/Direaut.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.md.directory.direaut.list.title" bundle="<%=bundleKey%>">
    <handao:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <handao:headButton name="增加" accesskey="N" onClick="createRecord();"/>
    <handao:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <handao:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <handao:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</handao:headLink>

<handao:customQueryArea>
<%-- todo:可以自定义查询table--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.direaut.rowid" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.ROW_ID" maxcharlength="10" /></td>
        <td class="singleDetailLabel"></td>
        <td colspan=1 class="singleDetailData"></td>
    </tr>

</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>