<%@ page pageEncoding="GBK" import="com.handao.platform.framework.envelope.AFPage,
                 com.handao.platform.framework.web.AFWebUtil,
                 com.handao.platform.framework.util.AFStringUtil"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:hidden property="searchForm.currentPageNo" />
<html:hidden property="searchForm.pageSize" />
<html:hidden property="searchForm.totalPageNum" />
<%
    //get parameter, initial some variable
    AFPage resultPage_navigation = (AFPage)request.getAttribute("searchResultPage");
    int totalRecordNum_navigation = resultPage_navigation.getTotalRecordNum();
    int totalPageNum_navigation = resultPage_navigation.getTotalPageNum();
    int currentPageNo_navigation = resultPage_navigation.getCurrentPageNo();
    int pageSize_navigation = resultPage_navigation.getPageSize();

    //String errMsg = AFWebUtil.getResource("common.search.error.page");

    //set a flog, indicate how many times this page have bean included. and use this to generate page txt box value.
    String indicate = (String)request.getAttribute("INDICATE_FLAG");
    if(AFStringUtil.isEmpty(indicate))
    {
        indicate="0";
    }
    int intInd = Integer.parseInt(indicate);
    intInd++;
    indicate = String.valueOf(intInd);
    indicate = indicate.trim();
    request.setAttribute("INDICATE_FLAG",indicate);

%>

<table id="AF_Navigate" width="98%" border="0" cellspacing="1" cellpadding="1" align="center" class="pageTable">
	<tr class="pageTR">
		<td width="15%" align="center">
    		<p><bean:message bundle="af" key="common.search.label.perpage"/><span class="hot"><%=pageSize_navigation%></span><bean:message bundle="af" key="common.search.label.row"/><bean:message bundle="af" key="common.search.label.record"/></p>
    	</td>
    	<td width="15%" align="center">
    		<p><bean:message bundle="af" key="common.search.label.total"/><span class="hot"><%=totalRecordNum_navigation%></span><bean:message bundle="af" key="common.search.label.row"/><bean:message bundle="af" key="common.search.label.record"/></p>
    	</td>
    	<td width="10%" align="center">
    		<bean:message bundle="af" key="common.search.label.total"/><span class="hot"><%=totalPageNum_navigation%></span><bean:message bundle="af" key="common.search.label.page"/>
    	</td>
    	<td width="10%" align="center">
    		<bean:message bundle="af" key="common.search.label.current"/><span class="hot"><%=currentPageNo_navigation%></span><bean:message bundle="af" key="common.search.label.page"/>
    	</td>
		<td width="5%" align="center" class="pageSec1" onMouseover="this.className='pageSec2'" onMouseout="this.className='pageSec1'">
			<img id="tofirstpage" value='<bean:message bundle="af" key="common.search.label.tofirstpage"/>' src="<%=_sys_imgpath%>/page/firstPage.gif"  onclick="gotoPage('1', errMsg);" width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.tofirstpage"/>'>
    	</td>
    	<td width="5%" align="center" class="pageSec1" onMouseover="this.className='pageSec2'" onMouseout="this.className='pageSec1'">
    		<logic:lessEqual name="searchResultPage" property="currentPageNo" value="1" >
				<img id="tobeforepage" value='<bean:message bundle="af" key="common.search.label.tobeforepage"/>' src="<%=_sys_imgpath%>/page/prePage.gif"   width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.tobeforepage"/>'>
        	</logic:lessEqual>
        	<logic:greaterThan name="searchResultPage" property="currentPageNo" value="1" >
				<img id="tobeforepage" value='<bean:message bundle="af" key="common.search.label.tobeforepage"/>' src="<%=_sys_imgpath%>/page/prePage.gif"  onclick="gotoPage('<%=currentPageNo_navigation-1%>',errMsg);"  width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.tobeforepage"/>'>
        	</logic:greaterThan>
    	</td>
    	<td width="5%" align="center" class="pageSec1" onMouseover="this.className='pageSec2'" onMouseout="this.className='pageSec1'">
			<logic:greaterEqual name="searchResultPage" property="currentPageNo" value="<%=String.valueOf(totalPageNum_navigation)%>">
				<img id="tonextpage" value='<bean:message bundle="af" key="common.search.label.tonextpage"/>' src="<%=_sys_imgpath%>/page/nextPage.gif"    width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.tonextpage"/>'>
			</logic:greaterEqual>
			<logic:lessThan name="searchResultPage" property="currentPageNo" value="<%=String.valueOf(totalPageNum_navigation)%>">
				<img id="tonextpage" value='<bean:message bundle="af" key="common.search.label.tonextpage"/>' src="<%=_sys_imgpath%>/page/nextPage.gif"   onclick="gotoPage('<%=currentPageNo_navigation+1%>',errMsg);" width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.tonextpage"/>'>
			</logic:lessThan>
		</td>
		<td width="5%" align="center" class="pageSec1" onMouseover="this.className='pageSec2'" onMouseout="this.className='pageSec1'">
			<img id="tolastpage" value='<bean:message bundle="af" key="common.search.label.tolastpage"/>' src="<%=_sys_imgpath%>/page/lastPage.gif"    onclick="gotoPage('<%=totalPageNum_navigation%>',errMsg);"  width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.tolastpage"/>'>
		</td>
		<td width="15%">
    		<bean:message bundle="af" key="common.search.label.topage"/>:<input type="text" name="current_<%=indicate%>" size="4" class="editText"><img id="gotopage" value='<bean:message bundle="af" key="common.search.label.gotopage"/>' src="<%=_sys_imgpath%>/page/goto.gif"    onclick="gotoPage(document.forms[0].current_<%=indicate%>.value, errMsg);"   width="16" height="16" border="0" align="absmiddle" style="cursor:hand" alt='<bean:message bundle="af" key="common.search.label.gotopage"/>'>
		</td>
	</tr>
</table>

<script>
	var errMsg = '<bean:message bundle="af" key="common.search.error.page"/>';
 	window.onresize = _tag_ResizeTable;
	_tag_ResizeTable();
</script>
