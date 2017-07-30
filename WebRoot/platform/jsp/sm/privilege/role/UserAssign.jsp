<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.List,com.handao.platform.sm.privilege.role.web.AFRoleUserForm"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/UserAssign.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/resource/Role_zh_CN.js"></script>

<jsp:useBean id="SM_PRIVILEGE_ROLE_AFRoleForm" scope="request" class="com.handao.platform.sm.privilege.role.web.AFRoleForm" />
<%
  String bundleKey = "common.sm.privilege.role";
  
  List availableUserList = SM_PRIVILEGE_ROLE_AFRoleForm.getDl_AFAvailableUser();  //可选用户
  List assignedUserList = SM_PRIVILEGE_ROLE_AFRoleForm.getDl_AFRoleUser();  //已经分配的用户
  AFRoleUserForm availableUserForm = new AFRoleUserForm();
  AFRoleUserForm assignedUserForm = new AFRoleUserForm();
  if(availableUserList != null && availableUserList.size() > 0){
  	for(int i = 0; i < availableUserList.size(); i++){
  		availableUserForm = (AFRoleUserForm)availableUserList.get(i);
  		out.println("<script language='javascript'>");
		out.println("avListLen = '" + availableUserList.size() + "';");
		out.println("availableUserArray['"+i+"'] = '" + availableUserForm.getSmur_USER_ID() + "' + '|' + '"+availableUserForm.getSmur_USER_NAME()+"' + '|' + '"+availableUserForm.getSmur_COMPANY_ID()+"';");
		out.println("</script>");
  	}
  }
  if(assignedUserList != null && assignedUserList.size() > 0){
  	for(int j = 0; j < assignedUserList.size(); j++){
  		assignedUserForm = (AFRoleUserForm)assignedUserList.get(j);
  		out.println("<script language='javascript'>");
		out.println("asListLen = '" + assignedUserList.size() + "';");
		out.println("assignedUserArray['"+j+"'] = '" + assignedUserForm.getSmur_USER_ID() + "' + '|' + '"+assignedUserForm.getSmur_USER_NAME()+"' + '|' + '"+availableUserForm.getSmur_COMPANY_ID()+"';");
		out.println("</script>");
  	}
  }
  
%>
<HTML>

<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

</HEAD>

<BODY class=singleDetailBody onload="init();">
<html:form action="sm/privilege/role/AFRoleAssign.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<input type="hidden" name="user_string"/>
<input type="hidden" name="role_id" value="<%=SM_PRIVILEGE_ROLE_AFRoleForm.getSmr_ROW_ID()%>"/>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>


<handao:headLink titleKey="common.sm.privilege.role.role_assign.title"  bundle="<%=bundleKey%>">
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<table  width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" colspan="4"><handao:label><bean:message key="common.sm.privilege.role.data_list.company" bundle="<%=bundleKey%>" /></handao:label>
        &nbsp;&nbsp;&nbsp;
        <handao:select property="smr_COMPANY_ID"  initValue="2" onchange="reloadThisPage(this);"
			sql="select cast(row_id as char) as code,company_name as name from md_company where status='1' order by sort_code"/>
        </td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" colspan = 2><handao:label><bean:message key="common.sm.privilege.role.data_list.role_code" bundle="<%=bundleKey%>" /></handao:label>
        :&nbsp;&nbsp;
        <bean:write name="SM_PRIVILEGE_ROLE_AFRoleForm" property="smr_ROLE_CODE"/></td>
        <td class="singleDetailLabel" colspan = 2><handao:label><bean:message key="common.sm.privilege.role.data_list.role_name" bundle="<%=bundleKey%>" /></handao:label>
        :&nbsp;&nbsp;
        <bean:write name="SM_PRIVILEGE_ROLE_AFRoleForm" property="smr_ROLE_NAME"/></td>
    </tr>
	<tr>
		<td WIDTH="45%" align="CENTER" class="queryConLabel"  NOWRAP><LABEL FOR="msel_SelectFrom0"   ACCESSKEY="u"><bean:message key="common.sm.privilege.role.role_assign.available_user" bundle="<%=bundleKey%>" /></LABEL></td>
        <td width='10%'  align="left" class="queryConLabel"  nowrap></td>
        <td width="45%" align="CENTER"  class="queryConLabel" NOWRAP><LABEL FOR="msel_SelectTo0" ACCESSKEY="i"><bean:message key="common.sm.privilege.role.role_assign.assigned_user" bundle="<%=bundleKey%>" /></LABEL></td>
	</tr>
	<tr>
		<td width='45%' class="queryConLabel" align="center" nowrap>
            <select name="leftUserOption" style=' width:300px'  SIZE='25' ondblclick=msel_MoveItems(1)   >
<%--				<option value=''>--请选择--</option>--%>
			</select>
        </td>
        <td width="10%" class="queryConLabel" nowrap align="center" STYLE="padding-left: 8; padding-right: 8;">
            <BUTTON  ID="msel_Add0"  TITLE="<bean:message key="common.sm.privilege.role.role_assign.button_title1" bundle="<%=bundleKey%>" />" class="butt1"   ONCLICK="msel_MoveItems(1);">></BUTTON><BR><BR>
            <BUTTON  ID="msel_AddAll0"  TITLE="<bean:message key="common.sm.privilege.role.role_assign.button_title2" bundle="<%=bundleKey%>" />" class="butt1"  ONCLICK="msel_MoveItems(2);">>></BUTTON><BR><BR>
            <BUTTON  ID="msel_Remove0"  TITLE="<bean:message key="common.sm.privilege.role.role_assign.button_title3" bundle="<%=bundleKey%>" />" class="butt1"  ONCLICK="msel_MoveItems(3);"><</BUTTON>	<br><br>
            <BUTTON  ID="msel_RemoveAll0"    TITLE="<bean:message key="common.sm.privilege.role.role_assign.button_title4" bundle="<%=bundleKey%>" />" class="butt1"  ONCLICK="msel_MoveItems(4);"><<</BUTTON>
        </td>
        <td width='45%' class="queryConLabel" align="center" nowrap>
            <select name="rightUserOption" style=' width:300px'  SIZE='25'  ondblclick=msel_MoveItems(3)   >
<%--				<option value=''>--请选择--</option>--%>
			</select>

        </td>
	</tr>
</table>
</html:form>
</BODY>
</HTML>