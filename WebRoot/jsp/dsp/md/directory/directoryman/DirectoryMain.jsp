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
<html>
	<head>
	<script type="text/javascript">	
	function tree_init(obj)
	{
	   tree.root.setText ("资源目录");
	   tree.rootTitle = "资源目录";
	}	
	function onNodeSelect(node)
	{
	    var param = "";
	    var currentDirID=node.attributes['id'];
	    param+="searchForm.PARENT_DIR_ID="+currentDirID;
	    document.getElementById('currentDirID').value=currentDirID;
	    document.getElementById('currentLevel').value=node.attributes['level'];	    
	    document.getElementById('editArea').src = "<%=ctx%>/md/directory/directoryman/Directory.do?method=doSearch&"+param+"&date="+new Date();
	}
	</script>
	</head>
	<body class="singleDetailBody" >
		<table border="0" class=listTable width="100%" cellpadding="0" cellspacing="0" height="100%">
			<tr width="100%">
				<td width="20%" height="100%">
    				<div id="tree-div" style="overflow:auto; height:100%;width:25%border:1px solid #c3daf9;"></div>
				</td>
				<td width="80%" height="100%">
					<iframe align="left" width="100%" height="100%" name ='editArea' src="<%=ctx%>/md/directory/directoryman/Directory.do?method=doSearch">   </iframe>
				</td>
			</tr>
		</table>
 <tree:navtree id="tree" apply2="tree-div" sqlid="dsp.md.directory.directoryman.Directory.[navtree-directory]" 
	    expandlevel="1" leafflag="true" onlyleafselectable="false" onselect="onNodeSelect" >
		<!--过滤条件 -->
		<tree:basecondition name="CONTROL_FLAG" value="1" />
		<!--指定对应 -->
		<tree:baseattrs     name="text"         value="{pcode}-{pdesc}" />
		<!--指定排序 -->
		<tree:sortinfo      name="pcode" value="ASC" />
	</tree:navtree>	
	<input type="hidden" name="currentDirID">
	<input type="hidden" name="currentLevel">	
	<input type="hidden" name="code">
	</body>
</html>
