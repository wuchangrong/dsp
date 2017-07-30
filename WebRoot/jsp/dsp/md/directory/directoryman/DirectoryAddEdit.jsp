<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>	
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/directory/directoryman/DirectoryAddEdit.js"></script>

<jsp:useBean id="md_directory_DirectoryForm" scope="request" class="com.handao.dsp.md.directory.directoryman.web.DirectoryForm" />
	
<%
  String bundleKey = "dsp.md.directory.directoryman";
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody onLoad="init()">

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="md/directory/directoryman/Directory.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="dsp.md.directory.directoryman.edit.title" bundle="<%=bundleKey%>">
    <handao:headButton name="保存并新增" accesskey="N" onClick="saveAndNewRecord();"/>
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域,并删去<td>
--%>
<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.dircode" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="DIR_CODE" size="10" maxcharlength="5" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.dirname" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="DIR_NAME" maxcharlength="50" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.direclacode" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:select property="DIRECLA_CODE" lovCode="MD_DIRECLA" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.direlevno" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="DIRELEV_NO" readonly="true" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.parentdir" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="PARENT_DIR"  readonly="true"/></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.path" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><handao:text property="PATH"  readonly="true"/></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.isvalid" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=5 class="singleDetailData"><handao:select property="ISVALID" lovCode="MD_TRUEFAL" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=5 class="singleDetailData"><handao:textarea property="REMARK" maxcharlength="400" /></td>
	</tr>

</table>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>