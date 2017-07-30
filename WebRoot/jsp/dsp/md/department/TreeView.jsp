<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/include" %>
<%@ taglib prefix="tree" tagdir="/WEB-INF/tags/tree/treetags" %>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="af" %>
<af:iniCtx id="ctx"/>
<af:css />
<af:script />
<import:script />
<import:css />
<script language="javascript" src="<%=ctx%>/jsp/dsp/md/department/DepartmentMain.js"></script>
<html>
	<head>
	</head>
	<body onload="initBody('<%=ctx%>')">
		 <div id="tree-div" style="overflow:auto; height:450px;width:100%border:1px solid #c3daf9;"></div>		
 
		<tree:navtree id="tree" apply2="tree-div" sqlid="dsp.md.department.Department.navtree-department" 
		    expandlevel="1" leafflag="true" onlyleafselectable="false" onselect="onNodeSelect" >
			<!--过滤条件 -->
			<tree:basecondition name="CONTROL_FLAG" value="1" />
			<!--指定对应 -->
			<tree:baseattrs     name="text"         value="{pcode}-{pdesc}" />
			<!--指定排序 -->
			<tree:sortinfo      name="pcode" value="ASC" />
		</tree:navtree>		
	</body>
</html>