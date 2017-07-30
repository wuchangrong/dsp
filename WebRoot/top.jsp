<%@page language="java" contentType="text/html;charset=GBK"%>
<%@page import="java.util.*,
				java.text.SimpleDateFormat,
                config.Configuration,
                com.handao.platform.sm.login.bo.LoginBO,com.handao.platform.sm.login.vo.UserPrivilegeVO,com.handao.platform.framework.envelope.UserToken"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<handao:iniCtx id="ctx"/>
<%
  UserToken userToken = (UserToken)session.getAttribute("userToken");
  //用户的顶级菜单
  long userId = userToken.getUserId();  
  
  LoginBO loginBO = new LoginBO();
  List programList  = loginBO.getUserPrivilegeByLevel(userId,1,"ROW_ID");

  String loginUserName = userToken.getUserName();
  
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  String sysDate = dateFormat.format(new Date());

  int subsystemDisplayNum= Configuration.getInstance().getFIRST_LEVEL_MENU_SHOW_NUM();//显示的子系统个数
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="css/default.css" type="text/css">
</head>
<script language="javascript">
<!--
var selectIndex = 0;//选中一级菜单
var selectProgramId = 0;//选中的程序
var selectApplicationId = 0;//选中程序所在应用
var menuCount = <%=programList.size() %>;//可访问的一级菜单数
var menuDispCount = 10;
//显示二级菜单
var xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
function showSubModule(applicationId, programId){
 self.parent.leftPanel.expand();
 self.parent.document.getElementById("leftFrame").src ="<%=ctx%>/navigateDetail.jsp?programId="+programId;
}

//点击一级菜单事件
function TopMenuHandle(applicationId,programId,selectMenu,menuName,startProgram){
  //将失去焦点菜单置为未选中
  var leftImg = document.getElementById("menuleft"+selectIndex);
  var centerImg = document.getElementById("topmenu"+selectIndex);
  var rightImg = document.getElementById("menuright"+selectIndex);
  leftImg.src = "images/unselect_left.gif";
  centerImg.background = "images/unselect_center.gif";
  rightImg.src = "images/unselect_right.gif";
  centerImg.style.color="#ffffff";
  //将选中菜单置为选中
  selectIndex = selectMenu;
  var leftImg = document.getElementById("menuleft"+selectIndex);
  var centerImg = document.getElementById("topmenu"+selectIndex);
  var rightImg = document.getElementById("menuright"+selectIndex);
  leftImg.src = "images/menu_on_left.gif";
  centerImg.background = "images/menu_on_center.gif";
  rightImg.src = "images/menu_on_right.gif";
  centerImg.style.color="#21386B";
  if(startProgram&&startProgram!=""&&startProgram!="#"&&startProgram!="null")
  {
        parent.document.getElementById("mainFrame").src = "<%=ctx%>/"+startProgram;
  }
  //获取并显示二级菜单
  showSubModule(applicationId, programId);
  
}
//注销
function logout(){
  if(confirm("确定要注销吗？")){
  	var url = "logoutHandle.jsp";
    url = "<%=ctx%>/" + url;
    parent.location.href = url;
  }
}
//修改密码
function changePassword(){
  self.parent.addTab(100202,'修改密码','<%=ctx%>/pw/setup/changepwd/ChangePwdAddEditIni.do',true);
}
//单击主页
function toWelcome(){
    parent.document.getElementById("mainFrame").src ="<%=ctx%>/welcome.jsp";
}

function customer(){
    parent.document.getElementById("mainFrame").src ="<%=ctx%>/sm/fastLink/fastLink/FastLinkAddEditIni.do?fromMenu=true&programId=200301";
}
</script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<TABLE width="100%"  border=0 cellPadding=0 cellSpacing=0 background="images/log_bg.gif">
  <TR id="upAndDownTR">
    <TD><table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tr>
        <td width="30%" rowspan="2" ><img src="images/system_logo.gif"></td>
        <td rowspan="2" align="center" nowrap >&nbsp;</td>
        <td width="30%" height="28"  align="right"><table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" >
          <tr>
            <td align="right" nowrap><img src="images/icon_user.gif" align="absmiddle">&nbsp;欢迎您，<%=loginUserName%>&nbsp;&nbsp;<img src="images/icon_password.gif" align="absmiddle"><span style="cursor:hand" onClick="changePassword()">&nbsp;修改密码&nbsp;</span></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="27" align="right">业务日期：<%=sysDate%>
        &nbsp;&nbsp;<img src="images/icon_logout.gif" width="16" height="16" align="absmiddle"><span style="cursor:hand" onClick="logout()">&nbsp;&nbsp;注&nbsp;&nbsp;销&nbsp;&nbsp;</span></td>
      </tr>
    </table></TD>
  </TR>
</TABLE>

<table id="menuTable" width="100%" height="24" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="bottom" background="images/menu_bg.gif"><table width="100%" height="32" border="0" cellpadding="0" cellspacing="0" id="menutbl" name="menutbl" >
      <tr>
        <td width="5" valign="middle" align="left"></td>
        <%
                   int subsystemNum = programList.size();
                   for(int i=0;i<subsystemNum;i++)
			       {
                	   UserPrivilegeVO userPrivilegeVO = (UserPrivilegeVO)programList.get(i);
			           //是否为默认选中菜单
                       if("Y".equalsIgnoreCase(userPrivilegeVO.getDefault_yn())){
                %>
        <script language="javascript">
		                <!--
		                       selectIndex = <%=i%>;//默认选中一级菜单
		                       selectProgramId = <%=userPrivilegeVO.getRow_id()%>
                        	  selectApplicationId = <%=userPrivilegeVO.getApplication_id()%>;
		                 -->
		                 </script>
        <td  width="60" align="center" valign="bottom" nowrap id=scrollTd<%=i%>><table width="60" height="24" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="5"><img id=menuleft<%=i%> src="images/menu_on_left.gif" width="5" height="26" border="0" ></td>
              <td id=topmenu<%=i%> align="center" nowrap background="images/menu_on_center.gif" style="color:#21386B"  onclick="javascript:TopMenuHandle(<%=userPrivilegeVO.getApplication_id()%>,<%=userPrivilegeVO.getRow_id()%>,<%=i%>,'<%=userPrivilegeVO.getMenu_name()%>','<%=userPrivilegeVO.getStart_program()%>');" onMouseOver="this.style.cursor='hand';"><img src=<%=userPrivilegeVO.getPicture()%> align="absmiddle">&nbsp;<%=userPrivilegeVO.getMenu_name()%></td>
              <td width="5"><img id=menuright<%=i%> src="images/menu_on_right.gif" width="5" height="26" border="0"></td>
            </tr>
        </table></td>
        <%}else
			          {
		                if(i<subsystemDisplayNum){
                        %>
        <td  width="40" align="center" valign="bottom" nowrap id="scrollTd<%=i%>"><%} else {%>
        <td  width="60" align="center" valign="bottom" nowrap id="scrollTd<%=i%>"  style="display:none"><%}%>
            <table width="60" height="24" border="0" cellpadding="0" cellspacing="0" style="margin-left:3px;">
              <tr>
                <td width="5"><img id=menuleft<%=i%> src="images/unselect_left.gif" width="5" height="26" border="0" ></td>
                <td id=topmenu<%=i%> align="center" nowrap background="images/unselect_center.gif" style="color:#ffffff" onClick="javascript:TopMenuHandle(<%=userPrivilegeVO.getApplication_id()%>,<%=userPrivilegeVO.getRow_id()%>,<%=i%>,'<%=userPrivilegeVO.getMenu_name()%>');" onMouseOver="this.style.cursor='hand';"><img src=<%=userPrivilegeVO.getPicture()%>  align="absmiddle">&nbsp;<%=userPrivilegeVO.getMenu_name()%></td>
                <td width="5"><img id=menuright<%=i%> src="images/unselect_right.gif" width="5" height="26" border="0"></td>
              </tr>
          </table></td>
        <%}
			        }%>
        <td>&nbsp;</td>
        <%if(subsystemDisplayNum<subsystemNum){%>
        <td align="right"><img  id="leftScrollImg" src="<%=ctx%>/images/left.gif" onMouseOver="this.style.cursor='hand'"  onclick="moveToLeft()" style="display:none" ><img src="<%=ctx%>/images/right.gif" onMouseOver="this.style.cursor='hand'" id="rightscrollImg" onClick="moveToRight()"></td>
        <%}%>
        </tr>
    </table></td>
    <td width="30"><img src="images/menu_right.gif" width="74" height="32"></td>
  </tr>
</table>
</body>
</html>
<script language="javascript">

//下面是移动子菜单 JS
var accountLeftTd=0;
var rightBlurTd;
function moveToLeft(){
   if(accountLeftTd>0){
      accountLeftTd=accountLeftTd-1;
      setTdObjectDispaly(accountLeftTd,true);
      rightBlurTd=accountLeftTd+<%=subsystemDisplayNum%>
      setTdObjectDispaly(rightBlurTd,false);
   } else {

   }
   setImgStatus();
}
//显示或者不显示某个菜单
function setTdObjectDispaly(blurTd,display){
	var blurTdObj=document.getElementById('scrollTd'+blurTd);
   if(blurTdObj){
      if(display)
   		blurTdObj.style.display="";
      else
      	blurTdObj.style.display="none";
   }
}
function moveToRight(){
   if(<%=subsystemNum%>-accountLeftTd><%=subsystemDisplayNum%>){
      setTdObjectDispaly(accountLeftTd,false);
      rightBlurTd=accountLeftTd+<%=subsystemDisplayNum%>
      setTdObjectDispaly(rightBlurTd,true);
      accountLeftTd=accountLeftTd+1;
   } else {

   }
   setImgStatus();
}
function setImgStatus(){
   var leftScrollImg=document.getElementById('leftScrollImg');
   var rightscrollImg=document.getElementById('rightscrollImg');

   if(accountLeftTd>0){
      leftScrollImg.style.display='';
   } else {
      leftScrollImg.style.display='none';
   }
   if(<%=subsystemNum%>-accountLeftTd><%=subsystemDisplayNum%>){
      rightscrollImg.style.display='';
   } else {
      rightscrollImg.style.display='none';
   }
}
</script>