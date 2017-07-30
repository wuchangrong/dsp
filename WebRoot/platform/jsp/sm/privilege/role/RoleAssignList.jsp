<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css/>
<handao:script/>


<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/RoleAssignList.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/resource/Role_zh_CN.js"></script>

<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
	String bundleKey = "common.sm.privilege.role";
  ArrayList fieldList = new ArrayList();
  fieldList.add(new AFField("smr_ROW_ID","common.sm.privilege.role.data_list.row_id","25","center",AFField.SHOW_TYPE_CHECKBOX,""));
  fieldList.add(new AFField("smr_ROLE_CODE","common.sm.privilege.role.data_list.role_code","","center","",""));
  fieldList.add(new AFField("smr_ROLE_NAME","common.sm.privilege.role.data_list.role_name","","center","",""));
  fieldList.add(new AFField("smr_REMARK","common.sm.privilege.role.data_list.role_remark","","left","",""));
  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>
<script language="javascript">
var ctx = "<%=ctx%>";
</script>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sm/privilege/role/AFRoleAssign.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="common.sm.privilege.role.role_assign.title" bundle="<%=bundleKey%>">
	<input type=button id="queryButton" class=tb_Button style="CURSOR: hand" value="查询(Q)" accesskey="Q" onClick="queryRecord();">
	<input type=button id="userButton" class=tb_Button style="CURSOR: hand" value="用户授权(U)" accesskey="U" onClick="manageUser();">
</handao:headLink>

<handao:customQueryArea>
	<tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_code"  bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.smr_ROLE_CODE" maxcharlength="10" /></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_name"  bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.smr_ROLE_NAME" maxcharlength="10"/></td>
    </tr>
</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>

