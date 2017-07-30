<%@ page import="java.util.List,
				 java.util.ArrayList,
				 java.util.Set,
				 java.util.HashMap,
				 java.util.Map,
				 java.util.Iterator,
	             com.handao.platform.framework.util.AFAdvancedString,com.handao.platform.sm.privilege.user.dao.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:css />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/platform/style/default/css/smDtree.css">
<script language="javascript" src="<%=request.getContextPath()%>/platform/jsp/sm/privilege/user/ProgramTree.js"></script>
<html>
<head>
</head>
<body scroll="no">
<%
     
     String showDeep = AFAdvancedString.trim(request.getParameter("showDeep"));//展开深度չ�����ִ�������
     String imgPath = AFAdvancedString.trim(request.getParameter("imgPath"));//树节点图片路径 /images/img/
     String condition = AFAdvancedString.trim(request.getParameter("rolesID"));//查询时的where条件
     String baseRootName = AFAdvancedString.trim(request.getParameter("baseRootName"));//根节点名称���������
     String searchKey = AFAdvancedString.trim(request.getParameter("searchKey"));//根节点名称����
     String nodeCancelType = AFAdvancedString.trim(request.getParameter("nodeCancelType"));//根节点名称����
     String nodeSelectType = AFAdvancedString.trim(request.getParameter("nodeSelectType"));//根节点名称����
     String node_column = "ROW_ID";//节点对应数据库字段�
     String node_parent_column = "PARENT_MODULE_ID";//父节点对应数据库字段����
     String node_name_column = "PROGRAM_NAME";//节点显示名称对应数据库字段��
     List treeDataList = new ArrayList();

	AFUserRoleDAO dao=new AFUserRoleDAO();
	treeDataList=dao.doSearchProgramListByRoleIDs(condition);

     StringBuffer returnValueBuffer = new StringBuffer();
     StringBuffer treeIdBuffer = new StringBuffer();
     StringBuffer treeParentIdBuffer = new StringBuffer();
     StringBuffer treeShowNameBuffer =  new StringBuffer();
     StringBuffer findValueBuffer =  new StringBuffer();
     String returnValue = "";
     String treeId = "";
     String treeParentId = "";
     String treeShowName=  "";
     String findValue =  "";
     Set treeSet = null;
     String returnValueTemp = "";
     //组合数据
     Map returnMap = new HashMap();
     String columnName = "";
     if (treeDataList.size() > 0){
         for (int i = 0; i < treeDataList.size(); i++){
             returnMap = ((HashMap) treeDataList.get(i));
             treeIdBuffer.append("'"+returnMap.get(node_column) +"'" +',');//节点ID
             treeParentIdBuffer.append("'"+ returnMap.get(node_parent_column) + "'"+',');//上级节点�
             treeShowNameBuffer.append("'"+ returnMap.get(node_name_column) + "'"+',');//显示名称���
             findValueBuffer.append("'"+ returnMap.get(searchKey) + "'"+',');//查询值
             //returnValue为字段名称@字段值对应格式的字段，传回前台通过javascript与前台标签中的字段名称配对取值
             treeSet = returnMap.keySet();
             if(treeSet!=null&&treeSet.size()>0){
               returnValueTemp = "";
               for(Iterator iter = treeSet.iterator();iter.hasNext();){
                       columnName = iter.next().toString();
                       returnValueTemp += columnName+"@"+returnMap.get(columnName).toString()+"@";
                     }
                 }
              returnValueBuffer.append("'"+returnValueTemp.substring(0,returnValueTemp.length()-1)+"'"+',');//返回值
             }
         findValue = findValueBuffer.toString();
         findValue = findValue.substring(0,findValue.length()-1);
         treeId = treeIdBuffer.toString();
         treeId = treeId.substring(0,treeId.length()-1);
         treeShowName = treeShowNameBuffer.toString();
         treeShowName = treeShowName.substring(0,treeShowName.length()-1);
         treeParentId = treeParentIdBuffer.toString();
         treeParentId = treeParentId.substring(0,treeParentId.length()-1);
         returnValue = returnValueBuffer.toString();
         returnValue = returnValue.substring(0,returnValue.length()-1);

     }
%>
<script language="javascript">
function  queryNode(nodeQueryId){
 d.closeAll();
 d.openTo(nodeQueryId, false);
}
function getAcctItem(acctItem){
 var returnType = self.parent.getReturnType();
 self.parent.returnAcctValue(acctItem);
}
function initQueryNode(nodeid){
 d.closeAll();
 d.openToByDefault(nodeid, false);
}
</script>
<table width="100%" height="100%" cellspacing="1" cellpadding="3"  align="center"  >
<tr class=listTableOdd>
<td valign="top" >
<div  style=" WIDTH:100%; height:100%; OVERFLOW:auto;">
<script type="text/javascript">
var id =new Array(<%=treeId%>);
var name = new Array(<%=treeShowName%>) ;
var pid = new Array(<%=treeParentId%>);

var returnValue = new Array(<%=returnValue%>);
var findValue = new Array(<%=findValue%>);
var tempPid = new Array(<%=treeParentId%>);
<%--  var treeType='<%=treeType%>';--%>
var i;
d = new dTree('d','<%=request.getContextPath()+imgPath%>','<%=nodeSelectType%>','<%=nodeCancelType%>');
for(var j=0;j<tempPid.length;j++)
{
   if(tempPid[0]>tempPid[j])
   {
       tempValue = tempPid[0];
       tempPid[0] = tempPid[j];
       tempPid[j] = tempValue;
   }
}
<%--判断最小父节点的个数�ĸ���--%>
var minParentCount = 0;
for(var i =0;i<pid.length;i++){
if(pid[i]==tempPid[0]){
 minParentCount++;
}
}
<%-- 1 只有一个最小根节点的情况--%>
if(minParentCount==1){
for(var j=0;j<pid.length;j++){
 if(pid[j]==tempPid[0]){
   tempCount = j;
   d.add(id[j],-9999,name[j],'','',returnValue[j],findValue[j]) ;
 }
}
}
else if(minParentCount>1){
   d.add(tempPid[0],-9999,'<%=baseRootName%>') ;
}
if(id.length>0)
{
   for(i = 0;i<id.length;i++)
   {
       d.add(id[i],pid[i],name[i],'','',returnValue[i],findValue[i]) ;
   }
}
document.write(d);
d.closeAll();
initQueryNode('<%=showDeep%>');
</script>
</div>
</td>
</tr>
</table>
</body>
</html>
