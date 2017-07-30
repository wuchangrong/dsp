<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/ProgramAssign.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/resource/Role_zh_CN.js"></script>

<jsp:useBean id="SM_PRIVILEGE_ROLE_AFRoleForm" scope="request" class="com.handao.platform.sm.privilege.role.web.AFRoleForm" />
<%
  String bundleKey = "common.sm.privilege.role";
%>
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
</HEAD>
<BODY class=singleDetailBody>
<html:form action="sm/privilege/role/AFRoleDefine.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<input type="hidden" name="module_string"/>
<input type="hidden" name="role_id" value="<%=SM_PRIVILEGE_ROLE_AFRoleForm.getSmr_ROW_ID()%>"/>
<handao:headLink titleKey="common.sm.privilege.role.role_define.title"  bundle="<%=bundleKey%>">
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>
<table width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_code" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_ROLE_AFRoleForm" property="smr_ROLE_CODE"/></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_name" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><bean:write name="SM_PRIVILEGE_ROLE_AFRoleForm" property="smr_ROLE_NAME"/></td>
    </tr>
	<tr>
		<td  colspan="6">
		<iframe id="retrieve_program" frameBorder=no style="width:100%;height:421" src="<%=ctx%>/platform/jsp/sm/privilege/role/ProgramTree.jsp?rolesID=<%=SM_PRIVILEGE_ROLE_AFRoleForm.getSmr_ROW_ID()%>"></iframe>
		</td>
	</tr>
</table>
</html:form>
</BODY>
</HTML>