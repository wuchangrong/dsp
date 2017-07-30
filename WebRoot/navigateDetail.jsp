<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.handao.platform.framework.envelope.UserToken"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/include"%>
<%@ taglib prefix="tree" tagdir="/WEB-INF/tags/tree"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao"%>
<handao:iniCtx id="ctx" />
<handao:css />
<handao:script />
<import:script />
<script language="javascript"
	src="<%=ctx%>/platform/js/uniext/source/components/tree/NavTreeFilter.js"></script>
<import:css />
<%
	UserToken userToken = (UserToken) request.getSession().getAttribute("userToken");
	if(userToken == null){
		request.getRequestDispatcher("/relogin.jsp").forward(request, response);
		return;
	}
	long programId = -1;
	if (request.getParameter("programId") != null) {
		programId = Long.parseLong(request.getParameter("programId"));
	}
	long userId = userToken.getUserId();
%>

<html>
	<head>
<script>
//wdq
window.onresize = function(){   
  var treeDiv = document.getElementById("tree-div");
  tree.setSize(document.body.clientWidth,document.body.clientHeight); 
}
function onNodeSelect(node){
  if(node.attributes["start_program"]!="#"&&node.attributes["start_program"]!="")
    self.parent.addTab(node.attributes["id"], node.attributes["pname"], '<%=ctx%>'+node.attributes["start_program"], true);
}
</script>
</head>
	<body style="overflow:hidden">
		<div id="tree-div" style="overflow: auto; height: 100%; width: 100%; border: 1px solid #c3daf9;"></div>
<script>
var tree = null;
Ext.onReady(function(){
	var baseConditions = [];
	var filterParams = null;
	var treeNodeBaseAttrs = null;
	var sortInfo = null;
			<!--过滤条件 -->
	baseConditions.push({param:"USER_ID",value:"<%=String.valueOf(userId)%>"});
	baseConditions.push({param:"fromLevelNum",value:"2"});
	baseConditions.push({param:"toLevelNum",value:"10"});
	baseConditions.push({param:"rowId",value:"<%=String.valueOf(programId)%>"});
	filterParams = eval({display:'',fields:[{name:'pcode',matchType:'*%'},{name:'pname',matchType:'%*%'}]});
			<!--指定对应 -->
	treeNodeBaseAttrs={"text":"{pname}"};
			<!--指定排序 -->
	sortInfo={field:"pcode",direction:"ASC"} ;
	tree = new UniEXT.tree.NavTree ({
	    applyTo:'tree-div',
	    sqlID:'common.sm.privilege.userPrivilege.UserPrivilege.SM_PROGRAM_TREE',
	    filterParam:filterParams,
	    expandLevel:1,
	    leafNodeFlag : 'true',
	    onSelect : onNodeSelect,
	    onlyLeafNodeSelectable : false,
	    treeNodeBaseAttrs : treeNodeBaseAttrs,
	    sortInfo : sortInfo,
	    baseConditions:baseConditions,
	    rootVisible:false,
	    node:<%=String.valueOf(programId)%>	    
	});

	if(typeof tree_init != 'undefined') {
		tree_init();
	}
});	
</script>	
</body>
</html>