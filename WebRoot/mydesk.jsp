<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.handao.platform.framework.envelope.UserToken"%>
<%@page import="com.handao.platform.sm.userdesk.userdeskSet.service.UserdeskSetService"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%  
	UserToken userToken=(UserToken)session.getAttribute("userToken");
    long userID=userToken.getUserId();
    long companyID=userToken.getCompanyId();
    long employeeID=userToken.getPersonId();
    
    UserdeskSetService userDesk=new UserdeskSetService();
    
    List groupList=userDesk.doSearchGroup(userID);
    List messageList=userDesk.doSearchMessage(companyID);
%>
<head>
<handao:iniCtx id="ctx"/>
<handao:css />
<script type="text/javascript">
	top.leftPanel.collapse();
	var userID='<%=userID%>';
	var employeeID='<%=employeeID%>';
	var msgQueueID;
	
	/**
     *方法名：openModule
     *参数：
     *返回值：
     *方法说明：打开新模块
    */
	function openModule(moduleID,moduleName,a_START_PROGRAM)
	{
		//alert(a_START_PROGRAM);
		self.parent.addTab(moduleID, moduleName, '<%=ctx%>'+a_START_PROGRAM, true);
	}
	
	function tab(tabId, tabC)
	{
	   var len =document.getElementById('getId').getElementsByTagName('li').length;
	   for(i=1; i <= len; i++)
	   {
		   if ("tabId"+i==tabId)
		   {
		    document.getElementById(tabId).className="current";
		   }else
		   {
		    document.getElementById("tabId"+i).className="";
		   }
		   if ("tabC"+i==tabC)
		   {
		    	document.getElementById(tabC).className="show";
		   }else
		   {
		    	document.getElementById("tabC"+i).className="hidden";
		   }
		}
	}
	/**
     *方法名：openMsgDia
     *参数：
     *返回值：
     *方法说明：消息弹出框
    */
	function openMsgDia(row_id)
	{
	   msgQueueID=row_id;
		_DialogUtil.showDialog({
				name: "cmp_sample_unieap",
				action: "/mydeskDialog.jsp?row_id="+row_id,
				width: "400",
				height: "400",
				title: "弹出框",
				div: true,
				motion : false,
				onComplete:closeMsgDia
	 	 });
	}
	
	/**
     *方法名：closeMsgDia
     *参数：
     *返回值：
     *方法说明：关闭消息弹出框后，删除消息队列数据，归档表设置为已读
    */
	function closeMsgDia()
	{
		//alert(msgQueueID);		    
       unieap.Action.requestData({
	       	   url:  unieap.appPath+"/jsp/common/userdesk/UserDeskSetRia.do",
	       	   sync: true,
	       	   parameters: {"message_id":msgQueueID,"empID":employeeID,method:"deleteMsgAddress"},
	       	   load:loadCloseMsg
	       	   
	         })
	}
	function loadCloseMsg()
	{
		self.location.href = unieap.appPath +"/mydesk.jsp";
	}

	setTimeout(function(){
         var tab = parent;
		 if(tab.isLoading){
		     if(tab.isLoading()){
		       tab.hideLoading();

			 }
	     }
	   },500);	
</script>
<style type="text/css">
	#getId{width:400px;}
	.tabT {width:100px;float:right;padding:0;margin:0px;background:url(1.jpg) repeat-y;height:400px;}
	
	.tab ,.tab li{padding:0;margin:0;border:none}
	.tab{height:23px;display:block;}
	.tab li {display:block;height:18px;line-height:18px;padding:10px 2px;text-align:center;cursor:pointer;}
	.tab li.current {display:block;color:red;background-color:#fff;border-right:1px solid red;border-left:0px solid red;border-top:1px solid red;border-bottom:1px solid red;padding:10px 2px;}
	
	.show,hidden{float:left;width:299px;margin-top:0px;border-style:solid;border-width:1px 0px 1px 1px;border-color:red;text-align:left;height:400px;}
	.hidden{display:none;}
	.show{display:block;}
	.con {padding:10px;}
</style>

<title>个人桌面</title>
<link href="css/desk.css" rel="stylesheet" type="text/css">	
</head>

<body>

<table width="98%" height="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="57%" valign="top">
    <table width="98%" height="500" border="0" align="center" cellpadding="1" cellspacing="1" class="deskpanelTable">
      <tr>
        <td height="20" background="images/desk/panel_bg.gif"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td>自定义桌面</td>
            <td align="right" >
            <span onClick="openModule('-11','桌面设置','/jsp/common/userdesk/userdeskSet/UserDeskSetList.jsp?clear=true')" onmouseover="this.style.cursor='hand';this.style.color='red'" onmouseout="this.style.color='black'">
            <img src="images/desk/edit.gif" width="16"  height="16" align="absmiddle">设置</span>
            </td>
          </tr>
        </table>
      </td>
   </tr>
      <tr>
        <td valign="top" class="deskpanelContent">
        <%
        	  for(int i=0;i<groupList.size();i++)
    		 {
    			HashMap map=(HashMap)groupList.get(i);
    			String groupName=(String)map.get("M_LABEL");
    			long M_ROW_ID=((Number)map.get("M_ROW_ID")).longValue();
    			
    			
    	%>
    	 <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="deskTitleTable">
          <tr>
            <td width="7"><img src="images/desk/title_left.gif" width="7" height="25"></td>
            <td background="images/desk/title_center.gif" ><%=groupName%></td>
            <td width="7" align="right"><img src="images/desk/title_right.gif" width="7" height="25"></td>
          </tr>
        </table>
            <%
            	List moduleList=userDesk.doSearchProgram(M_ROW_ID);
            
            	
            	if(moduleList.size()<=3)
            	{
           %>
            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="deskTableline">
            <tr >
            <%	   for(int j=0;j<moduleList.size();j++)
            	   {
            	  	 HashMap moduleMap=(HashMap)moduleList.get(j);
            	  	 String moduleName=(String)moduleMap.get("D_LABEL");
            	  	 String a_START_PROGRAM=(String)moduleMap.get("A_START_PROGRAM");
            	  	 long moduleID=((Number)moduleMap.get("D_MODULE_ID")).longValue();
            	  	 String A_PICTURE=(String)moduleMap.get("A_PICTURE");
            	  	 
            	  	if(A_PICTURE==null || A_PICTURE.equals(""))
		            {
		            	  	 	A_PICTURE="images\\module\\m_temp.gif";
		            }
            	  	 
            	  	 
            %>
            	<td width="33%" height="30" >
            	<span onClick="openModule('<%=moduleID%>','<%=moduleName%>','<%=a_START_PROGRAM%>')"onmouseover="this.style.cursor='hand';this.style.color='red'" onmouseout="this.style.color='black'">
            	<img src="<%=A_PICTURE%>" width="16" height="16"  align="absmiddle"> <%=moduleName%>
            	</span>
            	</td>
            <%
            	   }
              	   for(int lessedtd=0;lessedtd<(3-moduleList.size());lessedtd++)
              	   {
	             %>
	          	<td width="33%" height="30"></td>
	          	<%	               	    	
	            	}
	           %> 
             </tr>
          	 </table>	
             <%	
            	 }
            	 else
            	 {
            	    int tdNum=moduleList.size()%3;         
            	    int tableNum=moduleList.size()/3;
	            	for(int k=0;k<tableNum;k++)
	            	{
	          %>
	          		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="deskTableline">	
	          		<tr >
	          <%
	          			for(int h=0;h<3;h++)
	          			{
	          				HashMap moduleMap=(HashMap)moduleList.get(k*3+h);
	          				String moduleName=(String)moduleMap.get("D_LABEL");
	          				String a_START_PROGRAM=(String)moduleMap.get("A_START_PROGRAM");
	          				long moduleID=((Number)moduleMap.get("D_MODULE_ID")).longValue();
	          				String A_PICTURE=(String)moduleMap.get("A_PICTURE");

	          				
	          				if(A_PICTURE==null || A_PICTURE.equals(""))
		            	  	 {
		            	  	 	A_PICTURE="images\\module\\m_temp.gif";
		            	  	 }

	          %>
	          	<td width="33%" height="30" >
	          	<span onClick="openModule('<%=moduleID%>','<%=moduleName%>','<%=a_START_PROGRAM%>')"onmouseover="this.style.cursor='hand';this.style.color='red'" onmouseout="this.style.color='black'">
	          	<img src="<%=A_PICTURE%>"  width="16" height="16" align="absmiddle"> <%=moduleName%>
	          	</span>
	          	</td>
	          <%
	          			}	          
	          %>
	          		</tr>
          			</table>         			
	          <%   		
	            	}
	            	if(tdNum>0)
	            	{
	            %>
	            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="deskTableline">	
	          		<tr >
	            <%
	            	    for(int p=0;p<tdNum;p++)
	            	    {
	            	    	HashMap moduleMap=(HashMap)moduleList.get(tableNum*3+p);
	            	    	String moduleName=(String)moduleMap.get("D_LABEL");
	            	    	String a_START_PROGRAM=(String)moduleMap.get("A_START_PROGRAM");
	            	    	long moduleID=((Number)moduleMap.get("D_MODULE_ID")).longValue();
	            	    	String A_PICTURE=(String)moduleMap.get("A_PICTURE");
	            	    	if(A_PICTURE==null || A_PICTURE.equals(""))
		            	  	 {
		            	  	 	A_PICTURE="images\\module\\m_temp.gif";
		            	  	 }
	            %>
	          	<td width="33%" height="30" >
	          	<span onClick="openModule('<%=moduleID%>','<%=moduleName%>','<%=a_START_PROGRAM%>')"onmouseover="this.style.cursor='hand';this.style.color='red'" onmouseout="this.style.color='black'">
	          	<img src="<%=A_PICTURE%>"  width="16" height="16" align="absmiddle"> <%=moduleName%>
	          	</span>
	          	</td>
	          	<%
	            	    }  
	            	    for(int lesstd=0;lesstd<(3-tdNum);lesstd++)
	             %>
	          	<td width="33%" height="30"></td>
	          	<%	    {
	            	    	
	            	    }
	           %> 
	           	    </tr>
          			</table>
	           <%
            	    }        		
            	}
             %>        
          <br>  	
    	<%
    		 }        	
         %>
          </td>
      </tr>
    </table></td>
    <td width="43%" valign="top"><table width="98%" height="280" border="0" align="center" cellpadding="1" cellspacing="1" class="deskpanelTable">
    </table>
      <table width="98%" height="215" border="0" align="center" cellpadding="1" cellspacing="1" class="deskpanelTable">
        <tr>
          <td height="20" background="images/desk/panel_bg.gif"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>公告</td>
                <td align="right">
                <span onClick="openModule('800201','公告','/jsp/common/sm/bulletin/viewBulletin/ViewBulletinList.jsp')"onmouseover="this.style.cursor='hand';this.style.color='red'" onmouseout="this.style.color='black'">
               		 更多&gt;&gt;
               	</span>
               	</td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td valign="top"  class="deskpanelContent" style="background-image:url(images/desk/bulletin_bg.gif);background-color: #ffffff;	background-repeat: no-repeat;background-position: right bottom;padding-top:5px;">
          
          <%
          	for(int messN=0;messN<messageList.size();messN++)
          	{
          		HashMap messMap=(HashMap)messageList.get(messN);
          		String TITLE=(String)messMap.get("TITLE");
          		Date RELEASE_DATE=(Date)messMap.get("RELEASE_DATE");
          		//Date dd=(Date)messMap.get("RELEASE_DATE");
          		
          %>
          	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr >
                  <td width="3%"><img src="images/desk/icon1.gif" width="3" height="5"></td>
                  
                  <td width="75%" height="22">
                  <span onClick="openModule('800201','公告','/sm/bulletin/viewBulletin/ViewBulletin.do?method=doView&chk=<%=messMap.get("ROW_ID")%>')"onmouseover="this.style.cursor='hand';this.style.color='red'" onmouseout="this.style.color='black'">
                  <%=TITLE%>
                  </span>
                 </td>
                <td width="22%" align="center"><%=RELEASE_DATE%></td>
                </tr>
              </table>
          <%
          	}          	
          %>
        
            </td></tr>
      </table></td>
       <td width="30" valign="top"  style="border-left:1px solid #5B83A6; padding-top:5px; background-color:#D5E1F1"><img src="images/desk/mydesk_tab.gif" border="0" usemap="#Map" ></td>
  </tr>
</table>
<map name="Map"><area shape="rect" coords="6,96,21,150" href="jsp/common/userdesk/myNote/myNoteList.jsp">
</map>
</body>
</html>