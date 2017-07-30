<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.ArrayList,
                 com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.jsp.AFField"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css/>
<af:script/>
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/department/DepartmentList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.md.department";
  ArrayList fieldList = new ArrayList();
    fieldList.add(new AFField("DEPT_ROW_ID","dsp.md.department.data_list.row_id","25","center",AFField.SHOW_TYPE_CHECKBOX,""));
    fieldList.add(new AFField("DEPT_DEPT_CODE","dsp.md.department.data_list.dept_code","","center","",""));
    fieldList.add(new AFField("DEPT_DEPT_NAME","dsp.md.department.data_list.dept_name","","center","",""));
    fieldList.add(new AFField("DEPT_SHORT_CODE","dsp.md.department.data_list.short_code","","center","",""));
    fieldList.add(new AFField("DEPT_DEFAULT_UNIT","dsp.md.department.data_list.default_unit","","center","",""));
    fieldList.add(new AFField("DEPT_STATUS_desc","dsp.md.department.data_list.status","","center","",""));

  request.setAttribute("fieldList",fieldList);
  
  String parentDept = (String)request.getParameter("DEPT_PARENT_DEPT");
  if (parentDept == null)
  	parentDept = "";
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/department/Department.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="DEPT_COMPANY_ID" value="<%=request.getParameter("DEPT_COMPANY_ID")%>" />
<input type="hidden" name="DEPT_PARENT_DEPT" value="<%=request.getParameter("DEPT_PARENT_DEPT")%>" />
<%--<input type="hidden" name="IS_COMPANY" value="<%=request.getParameter("IS_COMPANY")%>" />--%>
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.department.quick_query.title" bundle="<%=bundleKey%>">
    <af:headButton name="新增" accesskey="N" onClick='<%="".equals(parentDept)?"alert(\'请先选择公司再新增！\');":"createRecord();"%>'/>
    <af:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <af:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <af:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</af:headLink>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>


</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>
<%@include file="/jsp/dsp/md/department/DepartmentAddEditInclude.jsp" %>