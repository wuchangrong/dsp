<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.util.AFConstants,
				com.handao.platform.framework.envelope.UserToken,com.handao.platform.sm.privilege.user.web.AFUserForm,
				java.util.Date,
                java.text.SimpleDateFormat"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@ taglib prefix="include" tagdir="/WEB-INF/tags/include" %>
<%@ taglib prefix="gridlookup" tagdir="/WEB-INF/tags/lookuptags/gridlookup" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<handao:css />
<handao:script />
<include:script />
<include:css />
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/UserAddEdit.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/resource/User_zh_CN.js"></script>
<%
  String bundleKey = "common.sm.privilege.user";
  UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
  SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
  Date currentDate = new Date();
  String date = dateformat.format(currentDate);
  AFUserForm userForm = (AFUserForm)request.getAttribute("SM_PRIVILEGE_USER_AFUserForm");
  String inure_date = "";
  String abate_date = "";
  if(userForm != null){
  	inure_date = userForm.getInure_date();
  	abate_date = userForm.getAbate_date();
  }
  if("".equals(inure_date)){ 
  	inure_date = date;
  }
  if("".equals(abate_date)){
  	abate_date = "2999-12-30";
  }
  
%>
<HTML>

<HEAD>

</HEAD>

<BODY class=singleDetailBody>

<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="sm/privilege/user/User.do">
<html:hidden property="method"/>
<html:hidden property="doWhat"/>
<input type="hidden" name="ctx" value="<%=ctx%>">
	
<handao:headLink titleKey="common.sm.privilege.user.data_edit.title" bundle="<%=bundleKey%>">
    <handao:headButton name="保存" accesskey="S" onClick="saveRecord();"/>
    <handao:headButton name="返回" accesskey="R" onClick="returnPage()"/>
</handao:headLink>

<%--
  todo:需要将标题行中主键改为<html:hidden/>域，并删去<td>
--%>
<table id=AF_FormTable width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="singleDetailTable">
<html:hidden property="row_id"/>
<html:hidden property="division_id"/>
<html:hidden property="person_id"/>

    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.user_code" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="user_code" maxcharlength="32"/></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.user_name" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="user_name" maxcharlength="100"/></td>
    	<td class="singleDetailLabel" colspan=2>&nbsp;</td>
    </tr>
    <tr class="singleDetailRow">
		<td align="left" width="6%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.company_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData">
			<handao:select style="width:170px;" property="company_id" onchange="companyChange()" sql="select cast(row_id as char) as code,company_name as name from md_company where status='1' order by sort_code"/>
		</td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.division_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData"><handao:text property="division_name" styleClass="editTextLine" onchange="divisionChange()"/></td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.person_id" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData"><handao:text property="person_name" styleClass="editTextLine"/></td>
		<gridlookup:DEPT id="division" row_id_pro="division_id" name_pro="division_name" beforepopup="beforePopupDivision()" valueChange="divisionChange()"/>
		<gridlookup:EMPLOYEE id="person" row_id_pro="person_id" name_pro="person_name" beforepopup="beforePopupPerson()"/>
	</tr>
	<tr class="singleDetailRow">
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.attr_flag" bundle="<%=bundleKey%>" /></handao:label></td>
		<td  class="singleDetailData">
         <html:select property="attr_flag"  styleClass="stedit" style="width:140px">
            <%if("2".equals(userToken.getAttrFlag()))//如果超级用户，则只许建系统管理员，否则只能建普通用户?????????
            {%>
              <html:option value="1">管理员</html:option>
            <%}else{%>
              <html:option value="0">普通用户</html:option>
             <%}%>
        </html:select>
        
        </td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
	</tr>
    <tr class="singleDetailRow">
		<td align="left" width="4%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.password" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData"><html:password property="password" styleClass="editTextLine"/> </td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.passwordJudge" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" colspan=3><html:password property="passwordJudge" styleClass="editTextLine"  /> </td>
	</tr>
	<tr class="singleDetailRow" style="display:none">
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.cert_yn" bundle="<%=bundleKey%>" /></handao:label></td>
		<td  class="singleDetailData">
        <html:select property="cert_yn"  styleClass="stedit" style="width:140px">
         <html:option value="N">不需验证</html:option>
         <html:option value="Y">验证</html:option>
        </html:select>
        </td>
		<td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.cert_serialno" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="cert_serialno" maxcharlength="100"/></td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
	</tr>
	<tr class="singleDetailRow">
		<td align="left" width="6%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.mobile" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData"><handao:text property="mobile" styleClass="editTextLine"/></td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.contact_phone" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData"><handao:text property="contact_phone" styleClass="editTextLine"/></td>
		<td align="left" width="7%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.fax" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData"><handao:text property="fax" styleClass="editTextLine"/></td>
	</tr>
	<tr class="singleDetailRow">
		<td align="left" width="7%"  class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.email" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" colspan="5"><handao:text property="email" size="75" styleClass="editTextLineLong" style='WIDTH: 432px' /></td>
	</tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.inure_date" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:date property="inure_date" value="<%=inure_date%>"/></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.abate_date" bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:date property="abate_date" value="<%=abate_date%>"/></td>
        <td class="singleDetailLabel" colspan=2>&nbsp;</td>
	</tr>
	<tr class="singleDetailRow" bgcolor="#FFFFFF">
		<td align="left" width="4%" class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_edit.remark" bundle="<%=bundleKey%>"/></handao:label></td>
		<td  class="singleDetailData" colspan="5"><handao:text property="remark" maxlength="100" style='WIDTH: 717px' styleClass="editTextLineLong"/></td>
   		
    </tr>
<tr>

</tr>
</table>
</html:form>
</BODY>
</HTML>

<%@include file="/platform/jsp/include/msgDisplay.jsp"%>