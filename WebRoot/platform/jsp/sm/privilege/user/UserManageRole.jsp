<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.List,com.handao.platform.sm.privilege.user.web.AFUserRoleForm"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/UserManageRole.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/resource/User_zh_CN.js"></script>

<jsp:useBean id="SM_PRIVILEGE_USER_AFUserForm" scope="request" class="com.handao.platform.sm.privilege.user.web.AFUserForm" />
<%
	String bundleKey = "common.sm.privilege.user";
	String roleID=" -111,";
	List availableRoleList = SM_PRIVILEGE_USER_AFUserForm.getDl_AFAvailableRole(); //可选角色
	List assignedRoleList = SM_PRIVILEGE_USER_AFUserForm.getDl_AFUserRole(); // 可分配角色
	AFUserRoleForm availableRoleForm = new AFUserRoleForm();
	AFUserRoleForm assignedRoleForm = new AFUserRoleForm();
	if (availableRoleList != null && availableRoleList.size() > 0) {
		for (int i = 0; i < availableRoleList.size(); i++) {
			availableRoleForm = (AFUserRoleForm) availableRoleList.get(i);
			out.println("<script language='javascript'>");
			out.println("avListLen = '" + availableRoleList.size()+ "';");
			out.println("availableRoleArray['" + i + "'] = '"+ availableRoleForm.getSmur_ROLE_ID()+ "' + '|' + '"+ availableRoleForm.getSmur_ROLE_NAME() + "';");
			out.println("</script>");
		}
	}
	if (assignedRoleList != null && assignedRoleList.size() > 0) {
		for (int j = 0; j < assignedRoleList.size(); j++) {
			assignedRoleForm = (AFUserRoleForm) assignedRoleList.get(j);
			out.println("<script language='javascript'>");
			out.println("asListLen = '" + assignedRoleList.size()+ "';");
			out.println("assignedRoleArray['" + j + "'] = '"+ assignedRoleForm.getSmur_ROLE_ID() + "' + '|' + '"+ assignedRoleForm.getSmur_ROLE_NAME() + "';");
			out.println("</script>");
			roleID=roleID+assignedRoleForm.getSmur_ROLE_ID()+",";
		}
	}
	roleID=roleID.substring(0,roleID.length()-1);
     if (roleID.trim().length()==0)
     {
         roleID="-111";
     }

%>

<HTML>

	<HEAD>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">

	</HEAD>

	<BODY class=singleDetailBody onload="init();">
		<html:form action="/sm/privilege/user/UserAuthorization.do">
			<html:hidden property="method" />
			<html:hidden property="doWhat" />
			<input type="hidden" name="ctx" value="<%=ctx%>">
			<input type="hidden" name="role_string" />
			<input type="hidden" name="user_id"
				value="<%=SM_PRIVILEGE_USER_AFUserForm.getRow_id()%>" />
				
			<handao:headLink titleKey="common.sm.privilege.role.role_assign.title" bundle="<%=bundleKey%>">
				<handao:headButton name="保存" accesskey="S" onClick="saveRecord();" />
				<handao:headButton name="返回" accesskey="R" onClick="returnPage()" />
			</handao:headLink>
			
			<table id="queryPanelTable" width="98%" border="0" cellspacing="1"
				cellpadding="1" align="center" class="singleDetailTable">
				<html:hidden property="row_id" />
				<html:hidden property="company_id" />
				<tr class="singleDetailRow">
					<td class="singleDetailLabel">
						<handao:label>
							<bean:message key="common.sm.privilege.user.data_list.user_code"
								bundle="<%=bundleKey%>" />
						</handao:label>
					</td>
					<td colspan=1 class="singleDetailData">
						<bean:write name="SM_PRIVILEGE_USER_AFUserForm"
							property="user_code" />
					</td>
					<td class="singleDetailLabel">
						<handao:label>
							<bean:message key="common.sm.privilege.user.data_list.user_name"
								bundle="<%=bundleKey%>" />
						</handao:label>
					</td>
					<td colspan=1 class="singleDetailData">
						<bean:write name="SM_PRIVILEGE_USER_AFUserForm"
							property="user_name" />
					</td>
				</tr>
			</table>
			<table id="queryPanelTable" width="98%" border="0" cellspacing="0"
				cellpadding="0" align="center" class="singleDetailTable">
				<tr class="singleDetailRow">
					<td width="50%" class="queryConLabel">
						<table border="0" width="100%" align="center">
							<tr>
								<td WIDTH="100%" align="CENTER" NOWRAP>
									<br>
									<LABEL FOR="msel_SelectFrom0" ACCESSKEY="u">
									未选角色
									</LABEL>
								</td>
							</tr>

							<tr>
								<td width='45%' class="queryConLabel" align="center" nowrap>
									<select name="leftRoleOption" style='width: 280px' SIZE='9'
										ondblclick=msel_MoveItems(1)>
									</select>
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td width="100%" nowrap align="center">
									<br>
									<img src="<%=ctx%>\images\toolbar\allDown.gif" height="16"
										width="16" alt="将上面列表中选中的条目全部添加到下面列表中！" style="cursor:hand"
										ONCLICK="msel_MoveItems(2);">
									&nbsp;&nbsp;
									<img src="<%=ctx%>\images\toolbar\down.gif" height="16"
										width="16" style="cursor: hand" alt="将上面列表中选中的条目添加到下面列表中！"
										ONCLICK="msel_MoveItems(1);">
									&nbsp;&nbsp;
									
									<img src="<%=ctx%>\images\toolbar\up.gif"
										alt="将下面列表中选中的条目添加到上面列表中！" height="16" width="16"
										style="cursor: hand" ONCLICK="msel_MoveItems(3);">
									&nbsp;&nbsp;
									<img src="<%=ctx%>\images\toolbar\allUp.gif"
										alt="将下面列表中选中的条目全部添加到上面列表中！" height="16" width="16"
										style="cursor: hand" ONCLICK="msel_MoveItems(4);">
								</td>
							</tr>
							<tr>
								<td width="100%" align="CENTER" NOWRAP>
									<br>
									<LABEL FOR="msel_SelectTo0" ACCESSKEY="i">
									已选角色
									</LABEL>
								</td>
							</tr>
							<tr>
								<td width='70%' class="queryConLabel" align="center" nowrap>
									<select name="rightRoleOption" style='width: 280px' SIZE='9'
										ondblclick=msel_MoveItems(3)>
									</select>

								</td>
							</tr>
						</table>
						<br>

					</td>
					<td class="queryConLabel" align="CENTER" valign="top" width="50%">
						<table border="0" width="98%">
							<tr>
								<br>
								<td align="LEFT">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									已分配模块
									</td>
							</tr>
						<tr>
								<td colspan="6">
								<iframe id="ifrLoad"  style=" width:350px;height:365px" src="<%=ctx%>/platform/jsp/sm/privilege/user/ProgramTree.jsp?rolesID=<%=roleID%>"></iframe>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
		</html:form>
</BODY>
</HTML>