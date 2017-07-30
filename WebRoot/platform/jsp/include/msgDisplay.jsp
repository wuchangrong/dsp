<%@ page pageEncoding="GBK" import="com.handao.platform.framework.envelope.AFPage,
		com.handao.platform.framework.util.AFConstants,
                 com.handao.platform.framework.web.AFWebUtil,
                 com.handao.platform.framework.util.AFStringUtil"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%
	String booleanValue = (String)request.getAttribute(AFConstants.KEY_RESULT_BOOLEAN_VALUE);
	String intValue = (String)request.getAttribute(AFConstants.KEY_RESULT_INT_VALUE);
	String messagekey = (String)request.getAttribute(AFConstants.KEY_RESULT_MESSAGE_KEY);
	String exception = (String)request.getAttribute(AFConstants.KEY_RESULT_EXCEPTION);
%>
<script>
	var tab = parent;
	if(tab.isLoading){
	   if(!tab.isLoading()){
	       tab.showLoading();
	   }
    };
     function pageLoading() {
      var tab = parent;
      if(tab.isLoading){
        if(tab.isLoading()){
		  tab.hideLoading();
		}
	  }     
    }
   window.attachEvent("onload",function(){setTimeout(pageLoading,100)});
   var msg = "";
<%
if(messagekey!=null && !"".equals(messagekey)) {
    if(messagekey.startsWith("af.")) {
%>
	msg = "<bean:message bundle="af" key="<%=messagekey%>" />";
<%} else {%>
	msg = "<bean:message key="<%=messagekey%>" bundle="<%=bundleKey%>"/>";
<%}%>
	exception = "<%=exception%>";
<%}%>
	if(msg != "")
		showMessageHint(msg, exception);
</script>


<script>
  var obj = window.onresize;
  var winDiv = document.all("winbody");
  var formTable= document.all("AF_FormTable");
  if(obj == null && winDiv != null){
    if(formTable != null) {
      //主从表,从表list页面
      window.onresize = _tag_ResizeTableNoNavigationMDDetailList;
      _tag_ResizeTableNoNavigationMDDetailList();
    }else{
      //单表无分页情况,list页面
      window.onresize = _tag_ResizeTableNoNavigation;
      _tag_ResizeTableNoNavigation();
    }
  }
</script>


<script language="javascript" for="AF_CustomQueryArea" event="onkeydown">
  if(event.keyCode==13 && event.srcElement.type!='button' &&
     event.srcElement.type!='submit' && 
     event.srcElement.type!='reset' && 
     event.srcElement.type!=''&& 
     event.srcElement.type!='textarea'){
    event.keyCode=9;
  }
</script>


<script language="javascript" for="AF_FormTable" event="onkeydown">
  if(event.keyCode==13 && event.srcElement.type!='button' &&
     event.srcElement.type!='submit' && 
     event.srcElement.type!='reset' && 
     event.srcElement.type!=''&& 
     event.srcElement.type!='textarea'){
     event.keyCode=9;
  }
</script>