<%@ page contentType="text/html; charset=GBK" import="com.handao.platform.framework.util.*,config.Configuration"%>
<%@ taglib uri="/WEB-INF/platform/handao.tld" prefix="handao" %>
<%@include file="/platform/jsp/include/sessionValidate.jsp" %>
<html>
<head>
<handao:iniCtx id="ctx"/>
<handao:script />
    <script type="text/javascript" src="platform/js/ext2.0/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="platform/js/ext2.0/ext-all-debug.js"></script>    
	<script type="text/javascript">
    Ext.ctxPath = '<%=request.getContextPath()%>';
    var openTabMax =<%=AFAppContext.getInstance().getOpenTabMax()%>*1; 
    //           
    function optionMenu(){
       var iframeTest=document.frames("topIframe");
       var iframeTable=iframeTest.document.getElementById("menuTable");
       var topPanelHeight=null;          //topPanel的高度
       var hiddenValue=document.getElementById("hiddenValue").value;  //隐藏的标志
       var windowWidth=document.body.offsetWidth;         //ie窗口的宽度
   
       if(hiddenValue=="expand"){
       	topPanel.setHeight(1);
       	topPanelHeight=topPanel.getInnerHeight(); 
       	document.getElementById("hiddenValue").value="unexpand";
       	document.getElementById("flowdiv").style.top=topPanelHeight+7;
       	document.getElementById("flowdiv").style.left=windowWidth-30;
       	document.getElementById("picture").src="images/desk/down_arrow_head.gif";
       	iframeTable.style.display="none";
       }
       else if(hiddenValue=="unexpand"){
       	topPanel.setHeight(96);
       	topPanelHeight=topPanel.getInnerHeight(); 
       	document.getElementById("hiddenValue").value="expand";
       	document.getElementById("flowdiv").style.top=topPanelHeight+7;  
       	document.getElementById("flowdiv").style.left=windowWidth-30;
       	document.getElementById("picture").src="images/desk/up_arrow_head.gif";
       	iframeTable.style.display="";
       }
       viewport.doLayout();
	   topPanel.doLayout();
    }
       
    function onloadPicture()
    {
       	var windowWidth=document.body.offsetWidth;         //ie窗口的宽度
       	var topPanelHeight=topPanel.getInnerHeight();          //topPanel的高度
       	document.getElementById("flowdiv").style.left=windowWidth-30;
       	document.getElementById("flowdiv").style.top=topPanelHeight+7;
       	document.getElementById("flowdiv").style.display="";
       	
    }
    window.onresize=onloadPicture;
    </script>
    <script type="text/javascript" src="platform/js/uniext/source/UniEXT.js"></script>
    <link rel="stylesheet" type="text/css" href="platform/js/ext2.0/resources/css/ext-all.css" />
<style type="text/css">
.loading{
  position:absolute;
  width:2000px;
  height:2000px;
  background : #D6E3F3 ;  
  top:29px;
  left:0px;
}
.layer-loading{
	position:relative;
	top:expression(document.getElementById("_loading").parentElement.offsetHeight/2-10+"px");
	left:expression(document.getElementById("_loading").parentElement.offsetWidth/2-25+"px");
	width:250px;
	height:32px;
	padding:0px;
	overflow:hidden;
	display:block;	
}
.layer-loading-logo{
	width:32px;
	height:32px;
	background:url(images/pageLoading.gif);
	overflow:hidden;
	display:inline;	
}
.layer-loading-text{
	display:inline;
	height:38px;
	line-height:32px;
	text-align:left;	
	color:#393939;
	font-weight:bold;
	font-size:14px;
	font-family:"Myriad Pro","Myriad Web","Tahoma","Helvetica","Arial",sans-serif;	
	padding-left:4px;
}
</style>
<TITLE><%=Configuration.getInstance().getAPPLICATION_NAME()%></TITLE>
</head>
<body onload="onloadPicture()">
<script type="text/javascript">
function hideLoading(){
  document.getElementById("_loading").style.display="none";
}
function showLoading(){
  document.getElementById("_loading").style.display="block";
}
function isLoading(){
  return document.getElementById("_loading").style.display != "none";
}
</script>
<script>

var topPanel = new Ext.Panel({
    region:'north',
    id:'top-panel',
    height: 96,    //默认宽度
    margins:'0 0 0 0',
    autoScroll:false,
    html: '<iframe id=topIframe frameborder=0 scrolling=no style=width:100%;height:100% src=top.jsp></iframe>'
});


var leftActPanel = new Ext.Panel({
    region:'center',
    layout:'accordion',
    layoutConfig:{animate:true },//是否有类似qq的动画效果
    items: [{
        html: '<iframe id=leftFrame name=leftFrame frameborder=0 style=width:100%;height:100% src=navigateDetail.jsp?programId=10></iframe>',//Ext.example.shortBogusMarkup,
        title:'菜单导航',
        autoScroll:true,
        border:false,
        iconCls:'nav'
    }]
});

var leftPanel = new Ext.Panel({
    region:'west',
    id:'left-panel',
    layout:'border',
    title:' ',
    split: true,   //是否可拖拽改变大小
    width: 190,    //默认宽度
    minSize: 190,  //最小值
    maxSize: 250,  //最大值
    collapsible: true,  //是否可折叠最小化
    margins: '2 0 2 2',
    items: [leftActPanel]
});

Ext.ux.TabCloseMenu = function(){
    var tabs, menu, ctxItem;
    this.init = function(tp){
        tabs = tp;
        tabs.on('contextmenu', onContextMenu);
    }

    function onContextMenu(ts, item, e){
        if(!menu){ // create context menu on first right click
            menu = new Ext.menu.Menu([{
                id: tabs.id + '-close',
                text: '关闭标签',
                handler : function(){
                    tabs.remove(ctxItem);
                }
            },{
                id: tabs.id + '-close-others',
                text: '关闭其他标签',
                handler : function(){
                    tabs.items.each(function(item){
                        if(item.closable && item != ctxItem){
                            tabs.remove(item);
                        }
                    });
                }
            }]);
        }
        ctxItem = item;
        var items = menu.items;
        items.get(tabs.id + '-close').setDisabled(!item.closable);
        var disableOthers = true;
        tabs.items.each(function(){
            if(this != item && this.closable){
                disableOthers = false;
                return false;
            }
        });
        items.get(tabs.id + '-close-others').setDisabled(disableOthers);
        menu.showAt(e.getPoint());
    }
};

var tabs = new Ext.TabPanel({
    el:'main',
    region:'center',
    resizeTabs:true, // turn on tab resizing
    minTabWidth: 125,
    tabWidth: 125,
    maxTabWidth:150,
    enableTabScroll:true,
    activeTab: 0,
    margins:'2 2 2 0',
    defaults: {autoScroll:true},
    plugins: new Ext.ux.TabCloseMenu(),
    onStripDbMouseDown:Ext.emptyFn,
    initEvents : function(){
        Ext.TabPanel.superclass.initEvents.call(this);
        this.on('add', this.onAdd, this);
        this.on('remove', this.onRemove, this);
        this.strip.on('mousedown', this.onStripMouseDown, this);
        this.strip.on('dblclick', this.onStripDbMouseDown, this);
        this.strip.on('click', this.onStripClick, this);
        this.strip.on('contextmenu', this.onStripContextMenu, this);
    }, 
     autoSizeTabs : function(){
        var count = this.items.length;
        var ow = this.header.dom.offsetWidth;
        var aw = this.header.dom.clientWidth;

        if(!this.resizeTabs || count < 1 || !aw){             return;
        }        
         var lis = this.stripWrap.dom.getElementsByTagName('li');
        for(var i = 0, len = lis.length-1; i < len; i++) {             var li = lis[i];
            var inner = li.childNodes[1].firstChild.firstChild;        
            var tw = li.offsetWidth;
            var iw = inner.offsetWidth;
            var length = this.items.items[i].title.length*2;
          
            if((length*8) <= (this.minTabWidth - (tw-iw))){
            	inner.style.width = (this.minTabWidth - (tw-iw)) + 'px';
            }else {
                inner.style.width = (this.maxTabWidth - (tw-iw)) + 'px';
            }
        }
    },
    onStripDbMouseDown:function(e){
     document.all("txtSetFocus").focus();
      e.preventDefault();   
      var t = this.findTargets(e);      
      if(t.item&&t.item.closable){
        this.remove(t.item);
        return;
        }
    },    
    onStripMouseDown : function(e){
      document.all("txtSetFocus").focus();
      e.preventDefault();
      if(e.button != 0){
        return;
      }
      var t = this.findTargets(e);
      if(t.close){
        this.remove(t.item);
        return;
      }
      if(t.item){
        this.setActiveTab(t.item);
      }
    }
});

function addTab(pId, pName, pUrl, closable){
    var tab = tabs.getComponent(pId);
    if(tab) {
        tabs.setActiveTab(tab);
    } else {
	  if(tabs.items.length==openTabMax){
	         alert("<%=AFAppContext.getInstance().getOpenTabMaxMessage()%>");
	         return;
	  }    
      if("welcome.jsp"==pUrl) {
        tabs.add({
            id: pId,
            title: pName,
            iconCls: 'tabs',
            html: "<iframe id=mainFrame  name=mainFrame frameborder=0 scrolling=no style=\'width:100%;height:100%\' src="+builderUrl(pUrl,pId)+"></iframe>",
            closable: closable
        }).show();
      }else{
        tabs.add({
            id: pId,
            title: pName,
            iconCls: 'tabs',
            html: "<iframe frameborder=0  scrolling=no style=\'width:100%;height:100%\' src="+builderUrl(pUrl,pId)+"></iframe>",
            closable: closable
        }).show();
      
      }
        
    }
}

function builderUrl(url,id){
   var flag = url.indexOf("?")==-1?true:false;
   if(flag){
     return url+"?"+"programId="+id;
   }else{
     return url+"&"+"programId="+id;
   }
}

var viewport=null;
Ext.onReady(function(){
    addTab("-100000", "我的桌面", "mydesk.jsp", false);
    viewport = new Ext.Viewport({
        layout:'border',
        items:[topPanel,leftPanel,tabs]
    });
});
</script>
<input type="textbox" name="txtSetFocus" value="" style="width:0px"/>
<div id='flowdiv'  name='flowdiv' frameborder=0 allowTransparency="true"  scrolling="no" style="position: absolute;top:103px;left:994px;width:16px; height:16px; z-index: 9998;display:none">
	<input type="hidden" id="hiddenValue" value="expand"/>
<img id="picture" src="images/desk/up_arrow_head.gif" width="16" height="16" onMouseOver="this.style.cursor='hand'" onclick="optionMenu()">
</div>

<div id='main'>
<DIV class="loading" id="_loading" ><DIV class="layer-loading"><DIV class="layer-loading-logo"></DIV><DIV class="layer-loading-text">页面正在加载, 请稍候. . .</DIV></DIV></DIV>
</div>
</body>
</html>
