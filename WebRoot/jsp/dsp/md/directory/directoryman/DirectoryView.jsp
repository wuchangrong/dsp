<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<handao:iniCtx id="ctx"/>
<handao:css />
<%@ include file="/platform/jsp/include/sessionValidate.jsp"%>
<handao:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/directory/directoryman/DirectoryView.js"></script>

<jsp:useBean id="md_directory_DirectoryForm" scope="request" class="com.handao.dsp.md.directory.directoryman.web.DirectoryForm" />
<%
  String bundleKey = "dsp.md.directory.directoryman";
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody>
<html:form action="md/directory/directoryman/Directory.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>

<handao:headLink titleKey="dsp.md.directory.directoryman.view.title"  bundle="<%=bundleKey%>">
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="ROW_ID"/>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.dircode" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="DIR_CODE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.dirname" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="DIR_NAME" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.direclacode" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="DIRECLA_CODE" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.direlevno" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="DIRELEV_NO" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.parentdir" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="PARENT_DIR" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.path" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="PATH" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="REMARK" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.iconbigurl" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="ICONBIG_URL" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.iconsmaurl" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="ICONSMA_URL" /></td>
		<td class="singleDetailLabel"><handao:label><bean:message key="dsp.md.directory.directoryman.isvalid" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="md_directory_DirectoryForm" property="ISVALID" /></td>
	</tr>

</table>
</html:form>
</BODY>
</HTML>