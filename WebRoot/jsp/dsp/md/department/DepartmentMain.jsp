<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/department/DepartmentMain.js"></script>
<script type="text/javascript">
<!--
	g_ctx = '<%=ctx%>';
//-->
</script>
<html>
	<head>
	</head>
	<frameset cols="20%,80%" >
		<frame align="left" name="treeArea" scrolling="no" noresize="noresize" onresize="document.frames['treeArea'].initBody('<%=ctx %>')" src="<%=ctx%>/jsp/dsp/md/department/TreeView.jsp">
		<frame align="left" name ='editArea' src="about:blank">
	</frameset>
</html>