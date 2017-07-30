<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>	
<handao:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/directory/directoryman/DirectoryList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.md.directory.directoryman";
  ArrayList fieldList = new ArrayList();
	fieldList.add(new AFField("ROW_ID","dsp.md.directory.directoryman.rowid","3%","center",AFField.SHOW_TYPE_CHECKBOX,""));
	fieldList.add(new AFField("DIR_CODE","dsp.md.directory.directoryman.dircode","10%","center","",""));
	fieldList.add(new AFField("DIR_NAME","dsp.md.directory.directoryman.dirname","10%","center","",""));
	fieldList.add(new AFField("DIRECLA_VALUE","dsp.md.directory.directoryman.direclacode","10%","center","",""));
	fieldList.add(new AFField("DIRELEV_NO","dsp.md.directory.directoryman.direlevno","10%","center","",""));
	fieldList.add(new AFField("PARENT_DIR_NAME","dsp.md.directory.directoryman.parentdir","10%","center","",""));
	fieldList.add(new AFField("PATH","dsp.md.directory.directoryman.path","10%","center","",""));
	fieldList.add(new AFField("ISVALID_VALUE","dsp.md.directory.directoryman.isvalid","10%","center","",""));
	fieldList.add(new AFField("REMARK","dsp.md.directory.directoryman.remark","10%","center","",""));
  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="md/directory/directoryman/Directory.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.md.directory.directoryman.list.title" bundle="<%=bundleKey%>">
    <handao:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <handao:headButton name="增加" accesskey="N" onClick="createRecord();"/>
    <handao:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <handao:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <handao:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</handao:headLink>

<handao:customQueryArea>
<%-- todo:可以自定义查询table--%>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.parentdir" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.PARENT_DIR_ID" maxcharlength="10" /></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.direclacode" bundle="<%=bundleKey%>"/></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.DIRECLA_CODE" maxcharlength="10" /></td>
    </tr>

</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>