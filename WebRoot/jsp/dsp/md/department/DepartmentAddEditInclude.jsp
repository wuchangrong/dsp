<%@ page import="com.handao.platform.framework.envelope.AFPage,
		com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.AFWebUtil,
                 com.handao.platform.framework.util.AFStringUtil"%>
<%
	String booleanValue1 = (String)request.getAttribute(AFConstants.KEY_RESULT_BOOLEAN_VALUE);
//	System.out.println (booleanValue1);
%>
<%
if (booleanValue1!=null &&"true".equals(booleanValue1))
{
%>
<script type="text/javascript">
<!--
	window.parent.document.all("treeArea").src="<%=ctx%>/jsp/dsp/md/department/TreeView.jsp";
//-->
</script>
<%
}
%>