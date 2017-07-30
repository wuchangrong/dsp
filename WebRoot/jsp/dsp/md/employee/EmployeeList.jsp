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
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/employee/EmployeeList.js"></script>
<jsp:useBean id="searchResultPage" scope="request" class="com.handao.platform.framework.envelope.AFPage"/>

<%
  String bundleKey = "dsp.md.employee";
  ArrayList fieldList = new ArrayList();
    fieldList.add(new AFField("EMP_ROW_ID","dsp.md.employee.data_list.row_id","25","center",AFField.SHOW_TYPE_CHECKBOX,""));
    fieldList.add(new AFField("EMP_EMPLOYEECODE","dsp.md.employee.data_list.employeecode","","center","",""));
    fieldList.add(new AFField("EMP_EMPLOYEENAME","dsp.md.employee.data_list.employeename","","center","",""));
    fieldList.add(new AFField("EMP_DEPT_NAME","dsp.md.employee.data_list.deptid","","center","",""));
    fieldList.add(new AFField("EMP_SHORT_CODE","dsp.md.employee.data_list.short_code","","center","",""));
    fieldList.add(new AFField("EMP_PLACE_NAME","dsp.md.employee.data_list.place","","center","",""));

  request.setAttribute("fieldList",fieldList);
%>

<HTML>

<HEAD>


</HEAD>

<BODY class="singleDetailBody">
<%@include file="/platform/jsp/include/popIframe.jsp" %>
<html:form action="/dsp/md/employee/Employee.do">
<html:hidden property="method" />
<html:hidden property="doWhat" />
<input type="hidden" name="programId" value="<%=request.getParameter("programId")%>"/>
	
<af:headLink titleKey="dsp.md.employee.quick_query.title" bundle="<%=bundleKey%>">
    <af:headButton name="查询" accesskey="Q" onClick="queryRecord();"/>
    <af:headButton name="新增" accesskey="N" onClick="createRecord();"/>
    <af:headButton name="修改" accesskey="E" onClick="modifyRecord();"/>
    <af:headButton name="删除" accesskey="D" onClick="deleteRecord();"/>
    <af:headButton name="查看" accesskey="V" onClick="viewRecord();"/>
</af:headLink>

<af:customQueryArea>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.employee.quick_query.employeecode"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td  class="singleDetailData" style="width:30%"><af:text property="searchForm.EMP_EMPLOYEECODE"/></td>
        <td class="singleDetailLabel" align="right" style="width:20%"><af:label><bean:message key="dsp.md.employee.quick_query.employeename"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td  class="singleDetailData" style="width:30%"><af:text property="searchForm.EMP_EMPLOYEENAME"/></td>
        
    </tr>
    <tr class="singleDetailRow">
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.employee.quick_query.deptid"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td  class="singleDetailData" >
        <af:select property="searchForm.EMP_DEPT_ID" sql='select ROW_ID as CODE, DEPT_NAME as NAME from MD_DEPT order by ROW_ID'></af:select>
        </td>
        <td class="singleDetailLabel" align="right" ><af:label><bean:message key="dsp.md.employee.quick_query.place"  bundle="<%=bundleKey%>" /></af:label>&nbsp;</td>
        <td  class="singleDetailData">
        <af:select property="searchForm.EMP_PLACE" lovCode="PLACE"></af:select>
        </td>
    </tr>
</af:customQueryArea>

<%@include file="/platform/jsp/include/searchBody.jsp"%>
<%@include file="/platform/jsp/include/navigation.jsp"%>

</html:form>
</BODY>
</HTML>
<%@include file="/platform/jsp/include/msgDisplay.jsp" %>