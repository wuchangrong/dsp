<%@ page language="java" contentType="text/html; charset=GBK" import="config.Configuration"%>
<%
	try{
		com.handao.platform.sm.login.LogoutHandleImpl.getInstance().logoutHandle(request);
	}catch(Throwable t){}
%>
<HTML>
<HEAD>
<TITLE><%=Configuration.getInstance().getAPPLICATION_NAME()%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=GBK">
<link rel="stylesheet" href="css/default.css" type="text/css">
</HEAD>
<SCRIPT language=javascript>
var a=0;var b=1;
function login(){
	var userObj = document.Form1.userID;
	var passwdObj = document.Form1.passwd;
    if(userObj.value.length==0){
		alert("请输入用户名!");
		userObj.focus();
		return false;
	}else{
		if(passwdObj.value.length==0){
			if(a < b){
				passwdObj.focus();
				a++;
				return false;
			}else{
				alert("请输入密码!");
				passwdObj.focus();
				b++;
				return false;
			}
		}else{
			document.Form1.action = "<%=request.getContextPath()+"/loginHandle.jsp"%>";
			document.Form1.submit();
		}
	}
}
 //回车时，设置下一个焦点
function setMainFocus(col){
   var keyCode=window.event.keyCode;
   if(keyCode==13||window.event.type=='propertychange'){
      var obj=document.getElementById(col);
      if(obj){
          if(obj.tagName=='IMG'){
            obj.click();
          }else{
            obj.focus();
          }
      }
   }
}
function initFocus(){
    document.forms[0].userID.focus();
}
</SCRIPT>
<BODY onLoad="initFocus()">
<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="921" height="547" border="0" align="center" cellpadding="0" cellspacing="0" background="images/index_bg.jpg">
      <tr>
        <td height="494"><br><br><br><br><br><br>
              <table width="262" height="162" border=0 align="center" cellpadding=0
				cellspacing=0 background="images/login/body.gif">
                <tbody>
                  <tr>
                    <td align=center><form id=Form1 name=Form1 action="" method=post
							onSubmit="return false">
                        <br>
                        <br>
                        <table cellspacing=0 cellpadding=0 width="41%" border=0>
                          <tbody>
                            <tr>
                              <td class=font-10pt width="26%" height=25>用户名&nbsp;</td>
                              <td width="74%"><input id=userID name=userID value=""
										class="editTextLine"></td>
                            </tr>
                            <tr>
                              <td class=font-10pt width="26%" height=25>密&nbsp;&nbsp;码&nbsp;&nbsp;</td>
                              <td width="74%"><input id=passwd name=passwd value=""
										type=password class="editTextLine"></td>
                            </tr>
                            <tr>
                              <td height=45 colspan="2" align="center"><input type=image src="images/login/confirm-password.gif"
										border=0 name=Image1 onClick="javascript:login()">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                              <input type=image
										src="images/login/cancel.gif" border=0 name=Image12
										onClick="javascript:resetInfo()"></td>
                            </tr>
                          </tbody>
                        </table>
                    </form></td>
                  </tr>
                </tbody>
            </table></td>
      </tr>
      <tr>
        <td align="center">版权所有&copy;东软集团有限公司</td>
      </tr>
    </table></td>
  </tr>
</table>
</BODY>
</HTML>
<script language=javascript>
function resetInfo(){
    document.Form1.userID.value="";
    document.Form1.passwd.value="";
}
</script>