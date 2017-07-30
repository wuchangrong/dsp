<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css /> 
<handao:script />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/UserView.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/resource/User_zh_CN.js"></script>
<jsp:useBean id="SM_PRIVILEGE_USER_AFUserForm" scope="request" class="com.handao.platform.sm.privilege.user.web.AFUserForm" />
<%
  String bundleKey = "common.sm.privilege.user";
  String viewType = request.getParameter("whereToBack");
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody>
<html:form action="sm/privilege/user/User.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<input type="hidden" name="ctx" value="<%=ctx%>">
<input type="hidden" name="whereToBack" value="<%=viewType%>" >
<handao:headLink titleKey="common.sm.privilege.user.data_detail.title"  bundle="<%=bundleKey%>">
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table id=AF_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="row_id"/>
    
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.user_code" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="user_code" /></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.user_name" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><bean:write  name="SM_PRIVILEGE_USER_AFUserForm" property="user_name"/></td>
    	<td class="singleDetailLabel" colspan=2>&nbsp;</td>
    </tr>
    <tr class="singleDetailRow">
		<td align="left" width="8%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.company_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" width="32%">			
			<bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="company_name" />
		</td>
		<td align="left" width="8%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.division_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" width="22%">
			<bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="division_name" />
		</td>
		<td align="left" width="8%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.person_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" width="22%">
			<bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="person_name" />
		</td>
	</tr>
	<tr class="singleDetailRow">
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.attr_flag" bundle="<%=bundleKey%>" /></handao:label></td>
		<td  colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="attr_flag_name" /></td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
	</tr>
	<tr class="singleDetailRow" style="display:none">
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.cert_yn" bundle="<%=bundleKey%>" /></handao:label></td>
		<td colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="cert_yn_name" /></td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.cert_serialno" bundle="<%=bundleKey%>" /></handao:label></td>
		<td  colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="cert_serialno" /></td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
	</tr>
	<tr class="singleDetailRow">
		<td align="left" width="6%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.mobile" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="mobile" /></td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.contact_phone" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="contact_phone" /></td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.fax" bundle="<%=bundleKey%>"/></handao:label></td>
		<td colspan=1  class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="fax" /></td>
	</tr>
	<tr class="singleDetailRow">
		<td align="left" width="7%"  class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.email" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" colspan="5"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="email"  /></td>
	</tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.inure_date" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="inure_date"/></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.abate_date" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="abate_date"/></td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
	</tr>
	<tr class="singleDetailRow" bgcolor="#FFFFFF">
		<td align="left" width="4%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" colspan="5"><bean:write name="SM_PRIVILEGE_USER_AFUserForm" property="remark" /></td>
    </tr>

</table>
</html:form>
</BODY>
</HTML>