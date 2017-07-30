var g_ctx;

function tree_init ()
{
	tree.root.setText ("全部");
	tree.rootTitle = "全部";
}

function initBody (ctx)
{
	g_ctx = ctx;
	var divHeight = "450px";
	var divWidth = "150px";
	if (window.innerHeight)
	{
		divHeight = window.innerHeight;
		divWidth = window.innerWidth;
	}
	else if (((document.body) && (document.body.clientHeight)))
	{
		divHeight = document.body.clientHeight;
		divWidth = document.body.clientWidth;
	}
	if (document.documentElement  && document.documentElement.clientHeight)
	{
		divHeight = document.documentElement.clientHeight;
		divWidth = document.documentElement.clientWidth;
	}	
	document.all("tree-div").style.height = divHeight;
	document.all("tree-div").style.width = divWidth;
}

function onNodeSelect (node)
{
//	for (att in node)
//		alert (att);
//	for (attr in tree.root)
//		document.writeln(attr);
//	return ;

	var param = "";
	if (typeof node.attributes['pid'] == 'undefined') //根节点选择无效
	{	
		param += "&DEPT_COMPANY_ID="+"";
		param += "&DEPT_PARENT_DEPT="+"";
	}
	else 
	{
		param += "&DEPT_COMPANY_ID="+node.attributes['company_id'];
		param += "&DEPT_PARENT_DEPT="+node.attributes['id'];
	}
//	param += "&IS_COMPANY"+node.arrtibutes['is_company'];
	window.parent.document.all ("editArea").src = g_ctx+"/dsp/md/department/Department.do?method=doSearch"+param;
	
}