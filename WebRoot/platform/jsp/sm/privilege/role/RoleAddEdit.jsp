<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants,
com.handao.platform.framework.envelope.UserToken"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/RoleAddEdit.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/role/resource/Role_zh_CN.js"></script>

<%
  String bundleKey = "common.sm.privilege.role";  
  UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody>

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sm/privilege/role/AFRoleDefine.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<html:hidden property="doWhatPlus"/>
<input type="hidden" name="ctx" value="<%=ctx%>">
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<handao:headLink titleKey="common.sm.privilege.role.role_define.title" bundle="<%=bundleKey%>">
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord()"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>


<table id=AF_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
    <html:hidden property="smr_ROW_ID"/>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_type" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=3 class="singleDetailData" >
        <input type="hidden" name="smr_COMPANY_ID" value="-1"/>
        <html:select property="smr_ATTR_FLAG" >
            <%if("2".equals(userToken.getAttrFlag()))//如果超级用户，则只许建系统管理员，否则，只能建普通用户
            {%>
              <html:option value="0">普通角色</html:option>
              <html:option value="1">管理员角色</html:option>
            <%}else{%>
              <html:option value="0">普通角色</html:option>
             <%}%>
        </html:select>
        </td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_code" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="smr_ROLE_CODE" maxcharlength="10"/></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_name" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="smr_ROLE_NAME" maxcharlength="20"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" valign="middle"><handao:label><bean:message key="common.sm.privilege.role.data_list.role_remark" bundle="<%=bundleKey%>" /></handao:label></td>
        <td class="singleDetailData" colspan=3>
         <handao:textarea property="smr_REMARK" styleClass="editTextArea"  maxcharlength="250" rows="23" style="width:100%"/>
		</td>
    </tr>
    

</table>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp" %>