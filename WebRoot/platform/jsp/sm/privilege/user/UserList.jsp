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
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/UserList.js"></script>
<script language="javascript" src="<%=ctx%>/platform/jsp/sm/privilege/user/resource/User_zh_CN.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
	String bundleKey = "common.sm.privilege.user";

    ArrayList fieldList = new ArrayList();
	fieldList.add(new AFField("row_id","common.sm.privilege.user.data_list.row_id","2%","center",AFField.SHOW_TYPE_CHECKBOX,""));
	fieldList.add(new AFField("user_code","common.sm.privilege.user.data_list.user_code","6%","left",""));
	fieldList.add(new AFField("user_name","common.sm.privilege.user.data_list.user_name","10%","left",""));
   	//fieldList.add(new AFField("cert_yn_name","common.sm.privilege.user.data_list.cert_yn","8%","center",""));
	fieldList.add(new AFField("create_date","common.sm.privilege.user.data_list.create_date","8%","center",""));
	fieldList.add(new AFField("inure_date","common.sm.privilege.user.data_list.inure_date","8%","center",""));
	fieldList.add(new AFField("abate_date","common.sm.privilege.user.data_list.abate_date","8%","center",""));
	fieldList.add(new AFField("using_flag_name","common.sm.privilege.user.data_list.using_flag","8%","center",""));
	fieldList.add(new AFField("using_flag","common.sm.privilege.user.data_list.using_flag","8%","center",AFField.SHOW_TYPE_HIDDENINPUT,""));
	fieldList.add(new AFField("remark","common.sm.privilege.user.data_list.remark","14%","left",""));
   
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
<html:form action="/sm/privilege/user/User.do">
<html:hidden property="method" value="doSearch"/>
<html:hidden property="doWhat" />
<input type="hidden" name="whereToBack" value="user" />
<input type="hidden" name="ctx" value="<%=ctx%>">
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
<handao:headLink titleKey="common.sm.privilege.user.quick_query.title" bundle="<%=bundleKey%>">
    <handao:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <handao:headButton name="新增" accesskey="N" onClick="createRecord();"/>
    <handao:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <handao:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <handao:headButton name="查看明细" accesskey="V" onClick="viewRecord();"/>
</handao:headLink>

<handao:customQueryArea>
	<tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_list.user_code"  bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.user_code" maxcharlength="10" /></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_list.user_name"  bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:text property="searchForm.user_name" maxcharlength="10"/></td>
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_list.inure_date"  bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData"><handao:date property="searchForm.inure_date"/></td>
        <td class="singleDetailLabel"><handao:label><bean:message key="common.sm.privilege.user.data_list.using_flag"  bundle="<%=bundleKey%>" /></handao:label></td>
        <td colspan=1 class="singleDetailData">
        <html:select property="searchForm.using_flag"  styleClass="stedit" style="width:140px">
		<html:option value="">--请选择--</html:option>
         <html:option value="1">启用</html:option>
         <html:option value="2">停用</html:option>
        </html:select>
		</td>
    </tr>
</handao:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>

