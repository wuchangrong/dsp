function gotoPage(pageNo, errMsg)
{
	var flag = false;
	if(checkNumber(pageNo))
	{
	    if(pageNo<=parseInt(document.getElementById("searchForm.totalPageNum").value) && pageNo>=1)
	    {
	   	    flag = true;
        }
    }
    if(!flag)
    {
	    alert(errMsg);
        return;
	}
    document.getElementById("searchForm.currentPageNo").value = pageNo;
    document.forms[0].target = "_self";
    document.forms[0].doWhat.value = "";
    document.forms[0].submit();
}

function gotoPageCommand(pageNo, errMsg,command)
{
	var flag = false;
	if(checkNumber(pageNo))
	{
	    if(pageNo<=parseInt(document.forms[0].totalPageNum.value) && pageNo>=1)
	    {
	   	    flag = true;
        }
    }
    if(!flag)
    {
	    alert(errMsg);
        return;
	}

    document.forms[0].currentPageNo.value=pageNo;
    document.forms[0].doWhat.value=command;
    document.forms[0].submit();
}

function _tag_SetCustomQueryAreaVisible(customQueryAreaId, img) {
    var customQueryArea = document.getElementById(customQueryAreaId);
    if(customQueryArea.style.display == "") {
		img.src = _sys_ctx + _sys_imgpath + img.hiddenImg;
		img.alt = img.hiddenAlt;
		customQueryArea.style.display = "none";
	}else {
		img.src = _sys_ctx + _sys_imgpath + img.showImg;
		img.alt = img.showAlt;
		customQueryArea.style.display = "";
	}
	_tag_ResizeTable(4);
}

function _tag_ResizeTable(officePlus) {
	var obj_Navigate = document.getElementById("AF_Navigate");
	if(obj_Navigate == null)
		return;

	var height = document.body.clientHeight;
	var obj_HeadLink = document.getElementById("AF_HeadLink");
	var height_HeadLink = obj_HeadLink!=null?obj_HeadLink.offsetHeight:0;

	var obj_CustomQueryArea = document.getElementById("AF_CustomQueryArea");
	var height_CustomQueryArea = obj_CustomQueryArea!=null?obj_CustomQueryArea.offsetHeight:0;

	var height_Navigate = obj_Navigate!=null?obj_Navigate.offsetHeight:0;
	var height_Winbody = height - height_HeadLink - height_CustomQueryArea - height_Navigate;

	if (height_Winbody < 0) {
		height_Winbody = 0;
	}

	var offset = 0;
	var count = 0;
	if(height_HeadLink != 0) {
		offset += 6;
    	count += 1;
	}
	if(height_CustomQueryArea != 0) {
		offset += 14;
    	count += 1;
	}
	if(count == 2)
		offset += -6;
    if(height_Winbody - offset <= 0) {
      document.getElementById("winbody").style.height = offset;
    }else {
      document.getElementById("winbody").style.height = height_Winbody - offset;
    }
	
}


function _tag_SetTabBodyVisible(tabPaneId, tabBodyId) {
	var tabTitle = document.getElementById("AF_TabTitle_"+tabPaneId);
	for(i=0;i<tabTitle.cells.length;i++)
		tabTitle.cells[i].className="tag_tabpane_unselected";

	document.getElementById("AF_TabTitle_"+tabPaneId+"."+tabBodyId).className="tag_tabpane_selected";

	var tabBody = document.getElementById("AF_TabBody_"+tabPaneId);
	for(i=0;i<tabBody.tBodies.length;i++)
		tabBody.tBodies[i].style.display="none";

	document.getElementById("AF_TabBody_"+tabPaneId+"."+tabBodyId).style.display="block";

}


function _tag_AddTabBody(tabPandId, arr) {
	var title = document.getElementById("AF_TabTitle_"+tabPandId);
	for(var i=0; i<arr.length; i++) {
		var td = title.insertCell();
		td.id = "AF_TabTitle_"+tabPandId+"."+arr[i][0];
		td.tabPandId = tabPandId;
		td.tabBodyId = arr[i][0];
		td.innerText = arr[i][1];
		//td.style.width=(arr[i][1].length*15)+"px";
              	td.style.width = arr[i][2];
		td.className="tag_tabpane_unselected";
		td.onclickFunction = arr[i][3];
		td.onclick = function() {
			var value = true;
			if(this.onclickFunction!="")
				value = eval(this.onclickFunction);
			if(value==true || value==undefined) {
				_tag_SetTabBodyVisible(this.tabPandId, this.tabBodyId);
			}
		};
	}
	var td = title.insertCell();
	//td.style.width="99%";
}



function _tag_ListTableOrder(obj) {

}



function _tag_ResizeTableNoNavigation(officePlus) {

	var height = document.body.clientHeight;
	var obj_HeadLink = document.getElementById("AF_HeadLink");
	var height_HeadLink = obj_HeadLink!=null?obj_HeadLink.offsetHeight:0;

	var obj_CustomQueryArea = document.getElementById("AF_CustomQueryArea");
	var height_CustomQueryArea = obj_CustomQueryArea!=null?obj_CustomQueryArea.offsetHeight:0;

	
	var height_Winbody = height - height_HeadLink - height_CustomQueryArea;

	if (height_Winbody < 0) {
		height_Winbody = 0;
	}

	var offset = 0;
	var count = 0;
	if(height_HeadLink != 0) {
		offset += 6;
    	count += 1;
	}
	if(height_CustomQueryArea != 0) {
		offset += 14;
    	count += 1;
	}
	if(count == 2)
		offset += -6;
    if(height_Winbody - offset <= 0) {
      document.getElementById("winbody").style.height = offset;
    }else {
      document.getElementById("winbody").style.height = height_Winbody - offset;
    }
	
}


function _tag_ResizeTableNoNavigationMDDetailList(officePlus) {

	var height = document.body.clientHeight;
	var obj_HeadLink = document.getElementById("AF_HeadLink");
	var height_HeadLink = obj_HeadLink!=null?obj_HeadLink.offsetHeight:0;

	var obj_CustomQueryArea = document.getElementById("AF_FormTable");
	var height_CustomQueryArea = obj_CustomQueryArea!=null?obj_CustomQueryArea.offsetHeight:0;

	
	var height_Winbody = height - height_HeadLink - height_CustomQueryArea;

	if (height_Winbody < 0) {
		height_Winbody = 0;
	}

	var offset = 0;
	var count = 0;
	if(height_HeadLink != 0) {
		offset += 6;
    	count += 1;
	}
	if(height_CustomQueryArea != 0) {
		offset += 14;
    	count += 1;
	}
	if(count == 2)
		offset += -6;
    if(height_Winbody - offset <= 0) {
      document.getElementById("winbody").style.height = offset;
    }else {
      document.getElementById("winbody").style.height = height_Winbody - offset;
    }
	
}

//date component start
var m_iDatePickerCount=0;
var cl_dpMaxYear=9999;
var cl_dpMaxMonth=11;
var cl_dpMaxDay=31;
var cl_dpMinYear=1600;
var cl_dpMinMonth=0;
var cl_dpMinDay=1;

var isFlag = true;
var isNullFlag = false;

function createDatePicker(txtName,lYear,lMonth,lDay,layout,isTime){
	initDateObject();
	//
	var dpID="dp_"+(m_iDatePickerCount++);
	var dt=dp_getValidDate(lYear,lMonth,lDay);
	
	var dpName = "dpN_" + txtName;

	if (lYear == "" || lMonth == "" || lDay == ""){
       isNullFlag = true;
       //isFlag = true;
	}
    
	if(dt==null)
      dt=new Date();


	var yearName = txtName+"_year";
	var monthName = txtName+"_month";
	var dayName = txtName+"_day";
	if (isNullFlag == true){
	document.write("<span class=DPFrame id="+dpID+" name="+dpName+">");
	document.write("<input id="+yearName+" class=DPYear type=text  size=4 maxlength=4 onfocus=\"return dp_focus('year');\" onblur=\"return dp_blur('year');\" onkeypress=\"return KeyFilter('number');\" onkeydown=\"return dp_keyDown('year');\">");
	document.write("<font class=DPYearDes>-</font>");
	document.write("<input id="+monthName+" class=DPMonth type=text  size=2 maxlength=2 onfocus=\"return dp_focus('month');\" onblur=\"return dp_blur('month');\" onkeypress=\"return KeyFilter('number');\" onkeydown=\"return dp_keyDown('month');\">");
	document.write("<font class=DPMonthDes>-</font>");
	document.write("<input id="+dayName+" class=DPDay type=text  size=2 maxlength=2 onfocus=\"return dp_focus('day');\" onblur=\"return dp_blur('day');\" onkeypress=\"return KeyFilter('number');\" onkeydown=\"return dp_keyDown('day');\">");
	document.write("<font class=DPDayDes></font>");
	document.write("<span class=DPSep></span>");
	if("popup"==layout) {
          document.write("<a class=DPDropBtn href=\"\" onclick=\"dp_DropClick1(this.parentElement);return false;\" title=\"选择日期\">▼</a>");
        }else{
          document.write("<a class=DPDropBtn href=\"\" onclick=\"dp_DropClick();return false;\" title=\"选择日期\">▼</a>");
        }
	if(typeof(txtName)=="string" && txtName.length>0)
	{
          if ((isTime != null) && (isTime != 'undefined') && (isTime == true)){
	    document.write("<input  onpropertychange=validTimeDate(this) type=hidden name="+txtName+">");
	   }else {
	    document.write("<input onpropertychange=setInputValueToDateValue(this) type=hidden  name="+txtName+">");
	   }
	   // document.write("<input type=hidden value='' name="+txtName+"2>");

	}
    document.write("</span>");

	}else{
		document.write("<span class=DPFrame id="+dpID+" name="+dpName+">");
	document.write("<input id="+yearName+" class=DPYear type=text value="+dt.getFullYear()+" size=4 maxlength=4 onfocus=\"return dp_focus('year');\" onblur=\"return dp_blur('year');\" onkeypress=\"return KeyFilter('number');\" onkeydown=\"return dp_keyDown('year');\">");
	document.write("<font class=DPYearDes>-</font>");
	document.write("<input id="+monthName+" class=DPMonth type=text value="+(dt.getMonth()+1)+" size=2 maxlength=2 onfocus=\"return dp_focus('month');\" onblur=\"return dp_blur('month');\" onkeypress=\"return KeyFilter('number');\" onkeydown=\"return dp_keyDown('month');\">");
	document.write("<font class=DPMonthDes>-</font>");
	document.write("<input id="+dayName+" class=DPDay type=text value="+dt.getDate()+" size=2 maxlength=2 onfocus=\"return dp_focus('day');\" onblur=\"return dp_blur('day');\" onkeypress=\"return KeyFilter('number');\" onkeydown=\"return dp_keyDown('day');\">");
	document.write("<font class=DPDayDes></font>");
	document.write("<span class=DPSep></span>");
	if("popup"==layout) {
          document.write("<a class=DPDropBtn href=\"\" onclick=\"dp_DropClick1(this.parentElement);return false;\" title=\"选择日期\">▼</a>");
        }else{
          document.write("<a class=DPDropBtn href=\"\" onclick=\"dp_DropClick();return false;\" title=\"选择日期\">▼</a>");
        }
	if(typeof(txtName)=="string" && txtName.length>0)
	{
          if ((isTime != null) && (isTime != 'undefined') && (isTime == true)){
	    document.write("<input   type=hidden onpropertychange=validTimeDate(this)  value='"+dt.format("yyyy-mm-dd")+"' name="+txtName+">");
	   }else {
	    document.write("<input  type=hidden onpropertychange=setInputValueToDateValue(this)  value='"+dt.format("yyyy-mm-dd")+"' name="+txtName+">");
	   }
	   // document.write("<input type=hidden value='' name="+txtName+"2>");

	}
    document.write("</span>");

	}
	


    var dp=document.all(dpID);
    dp_initDatePicker(dp,dt);
    isNullFlag = false;
    return dp;
}
function dtp_vs(chk,dtp,hdtpname)
{

	if(chk.checked==1)
	{
		document.all[dtp].style.visibility = "";
		document.all[hdtpname].value=document.all[hdtpname+"2"].value;

	}
else
	{
		document.all[dtp].style.visibility = "hidden";
		document.all[hdtpname+"2"].value=document.all[hdtpname].value;
		document.all[hdtpname].value="";

	}
}
function dp_getValidDate(lYear,lMonth,lDay)
{
	var dt=new Date();
	if(lYear==null || isNaN(parseInt(lYear,10)))
		lYear=dt.getFullYear();
	else
		lYear=parseInt(lYear,10);

	if(lMonth==null || isNaN(parseInt(lMonth,10)))
		lMonth=dt.getMonth();
	else
		lMonth=parseInt(lMonth,10)-1;

	if(lDay==null || isNaN(parseInt(lDay,10)))
		lDay=dt.getDate();
	else
		lDay=parseInt(lDay,10);
	dt=new Date(lYear,lMonth,lDay);
	var cdMax=new Date(cl_dpMaxYear,cl_dpMaxMonth,cl_dpMaxDay);
	var cdMin=new Date(cl_dpMinYear,cl_dpMinMonth,cl_dpMinDay);
	if(dt.compare(cdMax)>0 || dt.compare(cdMin)<0)
		dt=null;
	return dt;
}

function dp_initDatePicker(dp,dt)
{
	if(dp)
	{
		//Private Property
		dp.curDate=dt;
		dp.dpEnabled=true;
		dp.maxDay=cl_dpMaxDay;
		dp.maxMonth=cl_dpMaxMonth;
		dp.maxYear=cl_dpMaxYear;
		dp.minDay=cl_dpMinDay;
		dp.minMonth=cl_dpMinMonth;
		dp.minYear=cl_dpMinYear;
		dp.oldDate=dt.clone();

		//Private Method
		dp.getDropDownTable=dp_getDropDownTable;
		dp.getMonthName=dp_getMonthName;
		dp.hideDropDown=dp_hideDropDown;
		dp.initDropDown=dp_initDropDown;
		dp.onDateChange=dp_onDateChange;
		dp.refreshPostText=dp_refreshPostText;
		dp.showDropDown=dp_showDropDown;

		//Public Property
		//All Span Properties can be used;
		dp.offsetHor=0;

		//Public Method
		dp.setFocus=dp_setFocus;
		dp.format=dp_format;
		dp.getDateContent=dp_getDateContent;
		dp.getDay=dp_getDay;
		dp.getEnabled=dp_getEnabled;
		dp.getMonth=dp_getMonth;
		dp.getYear=dp_getYear;
		dp.refreshView=dp_refreshView;
		dp.setAccessKey=dp_setAccessKey;
		dp.setCurDate=dp_setCurDate;
		dp.setDateDes=dp_setDateDes;
		dp.setEnabled=dp_setEnabled;
		dp.setFormat=dp_setFormat;
		dp.setMaxDate=dp_setMaxDate;
		dp.setMinDate=dp_setMinDate;
		dp.setTabIndex=dp_setTabIndex;
		dp.setWeekName=dp_setWeekName;
                dp.setDateNull=dp_setDateNull;

		//Event
		dp.dateChanged=null;

		//Init View
		//dp.refreshView();
	}
}

function dp_createDropDown()
{
	var ddt=getDropDownTable();
	if(ddt)
		return ddt;
	document.body.insertAdjacentHTML("BeforeEnd",
					"<TABLE id=dpDropDownTable CELLSPACING=0 border=0  "+
					"onclick=\"dp_ddt_click();\" "+
					"ondblclick=\"dp_ddt_dblclick();\" >"+
					"<TR class=DPTitle>"+
					"<TD><span class=DPBtn onclick=\"dp_monthChange(-12);\" title=\"上年\"><<</span></TD>"+
					"<TD><span class=DPBtn onclick=\"dp_monthChange(-1);\" title=\"上月\"><-</span></TD>"+
					"<TD align=center colspan=3></TD>"+
					"<TD><span class=DPBtn onclick=\"dp_monthChange(1);\" title=\"下月\">-></span></TD>"+
					"<TD><span class=DPBtn onclick=\"dp_monthChange(12);\" title=\"下年\">>></span></TD>"+
					"</TR>"+
					"<TR>"+
					"<TD class=DPWeekName>日</TD>"+
					"<TD class=DPWeekName>一</TD>"+
					"<TD class=DPWeekName>二</TD>"+
					"<TD class=DPWeekName>三</TD>"+
					"<TD class=DPWeekName>四</TD>"+
					"<TD class=DPWeekName>五</TD>"+
					"<TD class=DPWeekName>六</TD>"+
					"</TR>"+
					"</TABLE>");
	ddt=getDropDownTable();
	if(ddt)
	{
		var row=null;
		var cell=null;
		for(var i=2; i<8; i++)
		{
			row=ddt.insertRow(i);
			if(row)
			{
				for(var j=0; j<7; j++)
				{
					cell=row.insertCell(j);
//					if(cell)
//					{
//					}
				}
			}
		}
	}
	if(ddt.rows.length!=8)
		ddt=null;
	return ddt;


}

function dp_getYear()
{
	var dp=this;
	return dp.curDate.getFullYear();
}

function dp_getMonth()
{
	var dp=this;
	return dp.curDate.getMonth()+1;
}

function dp_getDay()
{
	var dp=this;
	return dp.curDate.getDate();
}

function dp_format(sFormat)
{
	var dp=this;
	return dp.curDate.format(sFormat);
}

function dp_setAccessKey(sKey)
{
	var dp=this;
	var src=dp.children[0];
	if(src && src.tagName=="INPUT")
	{
		src.accessKey=sKey;
	}
}

function dp_getEnabled()
{
	var dp=this;
	var val=false;

	if(dp.dpEnabled)
		val=true;
	else
		val=false;
	return val;
}

function dp_setEnabled(val)
{
	var dp=this;
	var hr=false;

	var src=dp.children[0];
	if(src && src.tagName=="INPUT")
	{
		src.disabled=!val;
		src=dp.children[2];
		if(src && src.tagName=="INPUT")
		{
			src.disabled=!val;
			src=dp.children[4];
			if(src && src.tagName=="INPUT")
			{
				src.disabled=!val;
				dp.dpEnabled=val;
				hr=true;
			}
		}
	}
	return hr;
}

function dp_setFocus()
{
	var dp=this;
	var src=dp.children[0];
	if(src && src.tagName=="INPUT" && !src.disabled)
	{
		src.focus();
	}
}

function dp_getDateContent()
{
	var dp=this;
	var con="";
	var sYearDes="";
	var sMonthDes="";
	var sDayDes="";
	var src=dp.children[1];

	if(src && src.tagName=="FONT")
	{
		sYearDes=src.innerText;
		src=dp.children[3];
		if(src && src.tagName=="FONT")
		{
			sMonthDes=src.innerText;
			src=dp.children[5];
			if(src && src.tagName=="FONT")
			{
				sDayDes=src.innerText;
				var dt=dp.curDate;
				con=dt.getFullYear()+sYearDes+(dt.getMonth()+1)+sMonthDes+dt.getDate()+sDayDes;
			}
		}
	}
	return con;
}

function dp_setFormat(sFormat)
{
	this.formatString=sFormat;
	this.refreshPostText();
}

function dp_refreshPostText()
{
	var dp=this;
	var sFormat="yyyy-mm-dd";

	if(typeof(dp.formatString)=="string")
		sFormat=dp.formatString;
	var txt=dp.children[8];
	if(txt && txt.tagName=="INPUT")
		txt.value=dp.format(sFormat);
}

function dp_initDropDown()
{
	var dp=this;
	var ddt=dp.getDropDownTable();
	if(ddt)
	{
		ddt.curCell=null;
		var cell=null;
		var dt=new Date(dp.curDate.getFullYear(),dp.curDate.getMonth(),1);
		cell=ddt.rows[0].cells[2];
		if(cell)
		{
			cell.innerText=dp.getMonthName(dt.getMonth())+" "+dt.getFullYear();
		}

		var wd=dt.getDay();

		dt=new Date(dt.getFullYear(),dt.getMonth(),1-wd);
		var day=dt.getDate();
		for(var i=2; i<8; i++)
		{
			for(var j=0; j<7; j++)
			{
				cell=ddt.rows[i].cells[j];
				if(cell)
				{
					if(dp.curDate.getMonth()!=dt.getMonth())
						cell.className="DPCellOther";
					else if(dp.curDate.getDate()!=dt.getDate())
						cell.className="DPCell";
					else
					{
						cell.className="DPCell";
						dp_onCell(cell);
					}
					cell.innerText=day;
					cell.year=dt.getFullYear();
					cell.month=dt.getMonth();
					dt.setDate(day+1);
					day=dt.getDate();
				}
			}
		}
	}
}

function dp_getMonthName(lMonth)
{
	var mnArr=new Array("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月");
	return mnArr[lMonth];
}

function dp_setWeekName()
{
	var dp=this;
	var ddt=dp.getDropDownTable();
	if(ddt)
	{
		var cell=null;

		for(var j=0; j<7; j++)
		{
			cell=ddt.rows[1].cells[j];
			if(cell)
			{
				cell.innerText=arguments[j];
			}
		}
	}
}

function dp_showDropDown()
{
	var dp=this;
	var ddt=dp.getDropDownTable();
//	alert(ddt.innerHTML);

	if(ddt)
	{
		if(ddt.style.display=="block")
		{
			dp.hideDropDown();
		}
		else
		{
			dp.initDropDown();
			if(ddt.clientWidth==0)
			{
				ddt.style.pixelLeft=-500;
				ddt.style.pixelTop=-500;
				ddt.style.display="block";
			}

			var ddtWidth=ddt.clientWidth==0?266:ddt.clientWidth;
			var ddtHeight=ddt.clientHeight==0?133:ddt.clientHeight;

			var lLeft=getOffsetLeft(dp);
			var lTop=getOffsetTop(dp)+dp.offsetHeight;

			if((lTop+ddtHeight)>(document.body.clientHeight+document.body.scrollTop))
			{
				lTop-=(ddtHeight+dp.offsetHeight+2);
			}

			if((lLeft+ddtWidth)>(document.body.clientWidth+document.body.scrollLeft))
			{
				lLeft=document.body.clientWidth+document.body.scrollLeft-ddtWidth-2;
			}

			var off=parseInt(dp.offsetHor,10);
			if(isNaN(off))
				off=0;
			ddt.style.pixelLeft=lLeft+off;
			ddt.style.pixelTop=lTop;
			ddt.dpOldDocClick=document.onclick;
			ddt.dpOldDocKeyDown=document.onkeydown;

			event.cancelBubble=true;
			event.returnValue=false;
			document.onclick=dp_sub_docClick;
			document.onkeydown=dp_sub_dockeydown;

			ddt.style.display="block";
		}
	}
}

function getDropDownTable()
{
	var ddt=document.all("dpDropDownTable");
	if(!(ddt && ddt.tagName=="TABLE"))
		ddt=null;
	return ddt;
}

function dp_hideDropDown()
{
	var ddt=getDropDownTable();
	if(ddt)
	{
		ddt.style.display="none";
		document.onclick=ddt.dpOldDocClick;
		document.onkeydown=ddt.dpOldDocKeyDown;
		showElement("SELECT");
	}
}

function dp_getDropDownTable()
{
	var dp=this;
	dp.dropDownTable=dp_createDropDown();

	if(dp.dropDownTable && dp.dropDownTable.tagName=="TABLE")
	{
		dp.dropDownTable.dp=dp;
		return dp.dropDownTable;
	}
	else
		return null;
}

function dp_onDateChange()
{
  var dp=this;
  if(dp.curDate.compare(dp.oldDate)!=0){
    dp.oldDate=dp.curDate.clone();
    dp.refreshView();
    dp.refreshPostText();
    if(typeof(dp.dateChanged)=="function")
      dp.dateChanged(dp.curDate.getFullYear(),dp.curDate.getMonth()+1,dp.curDate.getDate());
    }else {
      isFlag = false;
      dp.refreshView();
      dp.refreshPostText();
      isFlag = true;
    }
}

function dp_refreshView()
{
	var dp=this;
	var hr=false;

	if(dp && dp.curDate)
	{
          var src=dp.children[0];
          if(src && src.tagName=="INPUT"){
            src.value=dp.curDate.getFullYear();
            src=dp.children[2];
            if(src && src.tagName=="INPUT"){
              src.value=dp.curDate.getMonth()+1;
              src=dp.children[4];
              if(src && src.tagName=="INPUT"){
                src.value=dp.curDate.getDate();
                hr=true;
              }
            }
          }
	}
	return hr;
}

function dp_setTabIndex(lTabIndex)
{
	var dp=this;
	var hr=false;

	if(dp)
	{
		var src=dp.children[0];
		if(src && src.tagName=="INPUT")
		{
			src.tabIndex=lTabIndex;
			src=dp.children[2];
			if(src && src.tagName=="INPUT")
			{
				src.tabIndex=lTabIndex;
				src=dp.children[4];
				if(src && src.tagName=="INPUT")
				{
					src.tabIndex=lTabIndex;
					src=dp.children[7];
					if(src && src.tagName=="A")
					{
						src.tabIndex=lTabIndex;
						hr=true;
					}
				}
			}
		}
	}
	return hr;
}

function dp_setDateDes(sYearDes,sMonthDes,sDayDes)
{
	if(sYearDes==null)
		sYearDes="-";
	if(sMonthDes==null)
		sMonthDes="-";
	if(sDayDes==null)
		sDayDes="";

	var dp=this;
	var hr=false;

	var src=dp.children[1];
	if(src && src.tagName=="FONT")
	{
		src.innerText=sYearDes;
		src=dp.children[3];
		if(src && src.tagName=="FONT")
		{
			src.innerText=sMonthDes;
			src=dp.children[5];
			if(src && src.tagName=="FONT")
			{
				src.innerText=sDayDes;
				hr=true;
			}
		}
	}
	return hr;
}

function dp_setMaxDate(lYear,lMonth,lDay)
{
	var dp=this;
	var hr=false;

	if(dp)
	{
		lYear=parseInt(lYear,10);
		lMonth=parseInt(lMonth,10);
		lDay=parseInt(lDay,10);

		if(!(isNaN(lYear) || isNaN(lMonth) || isNaN(lDay)))
		{
			lMonth--;
			var dt=new Date(lYear,lMonth,lDay);
			var dMin=new Date(dp.minYear,dp.minMonth,dp.minDay);
			var cdMax=new Date(cl_dpMaxYear,cl_dpMaxMonth,cl_dpMaxDay);

			if(dt.compare(cdMax)<=0 && dt.compare(dMin)>=0)
			{
				dp.maxYear=dt.getFullYear();
				dp.maxMonth=dt.getMonth();
				dp.maxDay=dt.getDate();
				hr=true;
			}
		}
	}
	return hr;
}

function dp_setMinDate(lYear,lMonth,lDay)
{
	var dp=this;
	var hr=false;

	if(dp)
	{
		lYear=parseInt(lYear,10);
		lMonth=parseInt(lMonth,10);
		lDay=parseInt(lDay,10);

		if(!(isNaN(lYear) || isNaN(lMonth) || isNaN(lDay)))
		{
			lMonth--;
			var dt=new Date(lYear,lMonth,lDay);
			var dMax=new Date(dp.maxYear,dp.maxMonth,dp.maxDay);
			var cdMin=new Date(cl_dpMinYear,cl_dpMinMonth,cl_dpMinDay);

			if(dt.compare(dMax)<=0 && dt.compare(cdMin)>=0)
			{
				dp.minYear=dt.getFullYear();
				dp.minMonth=dt.getMonth();
				dp.minDay=dt.getDate();
				hr=true;
			}
		}
	}
	return hr;
}

function dp_setCurDate(lYear,lMonth,lDay)
{
	var dp=this;
	var hr=false;

	lYear=parseInt(lYear,10);
	lMonth=parseInt(lMonth,10);
	lDay=parseInt(lDay,10);

	if(!(isNaN(lYear) || isNaN(lMonth) || isNaN(lDay)))
	{
		var dt=new Date(lYear,lMonth-1,lDay);
		var dMax=new Date(dp.maxYear,dp.maxMonth,dp.maxDay);
		var dMin=new Date(dp.minYear,dp.minMonth,dp.minDay);
		if(dt.compare(dMax)<=0 && dt.compare(dMin)>=0)
		{
			dp.curDate=dt;
			dp.onDateChange();
			hr=true;
		}
	}

	if(!hr)
		dp.refreshView();
	return hr;
}

function dp_DropClick()
{
	if (document.readyState=="complete") {//页面加载完成后才能打开
		var src=event.srcElement;
		var dp=getParentFromSrc(src,"SPAN")
		if(dp && dp.className=="DPFrame" && dp.dpEnabled)
		{
			dp.showDropDown();
		}
		hideElement("SELECT");
	}
}

function dp_focus(srcType)
{
	var src=event.srcElement;
	if(src && src.tagName=="INPUT")
	{
		switch(srcType)
		{
			case 'year':
				break;
			case 'month':
				break;
			case 'day':
				break;
			default:;
		}
		src.select();
	}
	return true;
}

function dp_blur(srcType)
{
	var src=event.srcElement;
	var dp=getParentFromSrc(src,"SPAN")
	if(src && src.tagName=="INPUT" && dp && dp.className=="DPFrame")
	{
		var lYear=dp.curDate.getFullYear();
		var lMonth=dp.curDate.getMonth()+1;
		var lDay=dp.curDate.getDate();

		var val=parseInt(src.value,10);
		if(isNaN(val)){
			val=-1;
			var txt=dp.children[8];
	    txt.value="";
			return true;
		}
		switch(srcType)
		{
			case 'year':
				lYear=val==-1?lYear:val;
				break;
			case 'month':
				lMonth=val==-1?lMonth:val;
				break;
			case 'day':
				lDay=val==-1?lDay:val;
				break;
			default:;
		}
		dp.setCurDate(lYear,lMonth,lDay);
		if(val==-1)
			dp.refreshView();
	}
	return true;
}

function dp_keyDown(srcType)
{
	var src=event.srcElement;
	var dp=getParentFromSrc(src,"SPAN")
	var bRefresh=true;

	if(dp && dp.className=="DPFrame")
	{
		var lYear=dp.curDate.getFullYear();
		var lMonth=dp.curDate.getMonth();
		var lDay=dp.curDate.getDate();
		var lStep=0;

		switch(event.keyCode)
		{
			case 38:
				lStep=1;
				break;
			case 40:
				lStep=-1;
				break;
			case 13:
				event.keyCode=9;
				break;
			default:
				bRefresh=false;
		}

		switch(srcType)
		{
			case 'year':
				lYear+=lStep;
				break;
			case 'month':
				lMonth+=lStep;
				break;
			case 'day':
				lDay+=lStep;
				break;
			default:;
		}
		if(bRefresh)
			dp.setCurDate(lYear,lMonth+1,lDay);
	}
	return true;
}

function dp_monthChange(lStep)
{
	var src=event.srcElement;
	if(src)
	{
		var ddt=getDropDownTable();
		if(ddt && ddt.dp)
		{
			var dt=ddt.dp.curDate.clone();
			var lOldMonth=dt.getMonth();
			var lOldDay=dt.getDate();

			dt.setDate(1);
			dt.setMonth(lOldMonth+lStep+1);
			dt.setDate(0);
			if(dt.getDate()>lOldDay)
				dt.setDate(lOldDay);
			if(ddt.dp.setCurDate(dt.getFullYear(),dt.getMonth()+1,dt.getDate()))
				ddt.dp.initDropDown();
		}
	}
}

function dp_ddt_click()
{
	var src=event.srcElement;
	if(src && src.tagName=="TD")
	{
		var ddt=getDropDownTable();
		if(ddt && ddt.dp)
		{
			var lOldMonth=ddt.dp.curDate.getMonth();
			if(ddt.dp.setCurDate(src.year,parseInt(src.month,10)+1,parseInt(src.innerText,10)))
			{
				if(src.month!=lOldMonth)
					ddt.dp.initDropDown();
				else
					dp_onCell(src);
			}
		}
	}
}

function dp_onCell(src)
{
	var row=src.parentElement;
	if(row && row.tagName=="TR" && row.rowIndex>1)
	{
		var ddt=getDropDownTable();
		if(ddt)
		{
			if(ddt.curCell)
				ddt.curCell.className=ddt.curCellOldClass;
			ddt.curCellOldClass=src.className;
			src.className="DPCellSelect";
			ddt.curCell=src;
		}
	}
}

function dp_ddt_dblclick()
{
	var src=event.srcElement;
	if(src && src.tagName=="TD")
	{
		var ddt=getDropDownTable();
		if(ddt && ddt.dp)
		{
			var lOldMonth=ddt.dp.curDate.getMonth();
			if(ddt.dp.setCurDate(src.year,parseInt(src.month,10)+1,parseInt(src.innerText,10)))
			{
				ddt.dp.hideDropDown();
				//showElement("SELECT");
			}
		}
	}
}

function dp_sub_docClick()
{
	var src=event.srcElement;
	var ddt=getParentFromSrc(src,"TABLE");
	if(!ddt || ddt.id!="dpDropDownTable")
	{
		dp_hideDropDown();
	}
	event.cancelBubble=true;
	event.returnValue=false;

	return false;
}

function dp_sub_dockeydown()
{
	dp_hideDropDown();
	return true;
}
function KeyFilter(type)
{
	var berr=false;

	switch(type)
	{
		case 'date':
			if (!(event.keyCode == 45 || event.keyCode == 47 || (event.keyCode>=48 && event.keyCode<=57)))
				berr=true;
			break;
		case 'number':
			if (!(event.keyCode>=48 && event.keyCode<=57))
				berr=true;
			break;
		case 'cy':
			if (!(event.keyCode == 46 || (event.keyCode>=48 && event.keyCode<=57)))
				berr=true;
			break;
		case 'long':
			if (!(event.keyCode == 45 || (event.keyCode>=48 && event.keyCode<=57)))
				berr=true;
			break;
		case 'double':
			if (!(event.keyCode == 45 || event.keyCode == 46 || (event.keyCode>=48 && event.keyCode<=57)))
				berr=true;
			break;
		default:
			if (event.keyCode == 35 || event.keyCode == 37 || event.keyCode==38)
				berr=true;
	}
	return !berr;
}

function getParentFromSrc(src,parTag)
{
	if(src && src.tagName!=parTag)
		src=getParentFromSrc(src.parentElement,parTag);
	return src;
}

function switchToOption(sel,newOption,byWhat)
{
	newOption=newOption.toString();
	if(newOption && sel && sel.tagName=="SELECT")
	{
		newOption=trim(newOption);
		var opts=sel.options;
		for(var i=0;i<opts.length;i++)
		{
			if(trim(opts[i][byWhat].toString())==newOption)
			{
				sel.selectedIndex=i;
				break;
			}
		}
	}
}

// Is a element visible?
function isElementVisible(src)
{
	if(src)
	{
		var x=getOffsetLeft(src)+2-document.body.scrollLeft;
		var y=getOffsetTop(src)+2-document.body.scrollTop;
		if(ptIsInRect(x,y,0,0,document.body.offsetWidth,document.body.offsetHeight))
		{
			var e=document.elementFromPoint(x,y);
			return src==e;
		}
	}

	return false;
}

function ptIsInRect(x,y,left,top,right,bottom)
{
	return (x>=left && x<right) && (y>=top && y<bottom);
}

function getOffsetLeft(src){
	var set=0;
	if(src)
	{
		if (src.offsetParent)
			set+=src.offsetLeft+getOffsetLeft(src.offsetParent);

		if(src.tagName!="BODY")
		{
			var x=parseInt(src.scrollLeft,10);
			if(!isNaN(x))
				set-=x;
		}
	}
	return set;
}
function getOffsetTop(src){
	var set=0;
	if(src)
	{
		if (src.offsetParent)
			set+=src.offsetTop+getOffsetTop(src.offsetParent);

		if(src.tagName!="BODY")
		{
			var y=parseInt(src.scrollTop,10);
			if(!isNaN(y))
				set-=y;
		}
	}
	return set;
}

function isAnyLevelParent(src,par)
{
	var hr=false;
	if(src==par)
		hr=true;
	else if(src!=null)
		hr=isAnyLevelParent(src.parentElement,par);

	return hr;
}

function isIE(version)
{
	var i0=navigator.appVersion.indexOf("MSIE")
	var i1=-1;
	var ver=0;
	if(i0>=0)
	{
		i1=navigator.appVersion.indexOf(" ",i0+1);
		if(i1>=0)
		{
			i0=i1;
			i1=navigator.appVersion.indexOf(";",i0+1);
			if(i1>=0)
			{
				ver=parseFloat(navigator.appVersion.substring(i0+1,i1));
				if(isNaN(ver))
					ver=0;
			}
		}
	}

	return (navigator.userAgent.indexOf("MSIE")!= -1
		&& navigator.userAgent.indexOf("Windows")!=-1
		&& ((ver<(version+1) && ver>=version) || version==0));
}

function getValidDate(str)
{
	var sDate=str.replace(/\//g,"-");
	var vArr=sDate.split("-");
	var sRet="";

	if(vArr.length>=3)
	{
		var year=parseInt(vArr[0],10);
		var month=parseInt(vArr[1],10);
		var day=parseInt(vArr[2],10);
		if(!(isNaN(year) || isNaN(month) || isNaN(day)))
			if(year>=1900 && year<9999 && month>=1 && month<=12)
			{
				var dt=new Date(year,month-1,day);
				year=dt.getFullYear();
				month=dt.getMonth()+1;
				day=dt.getDate();
				sRet=year+"-"+(month<10?"0":"")+month+"-"+(day<10?"0":"")+day;
			}
	}

	return sRet;
}

function getSafeValue(val,def)
{
	if(typeof(val)=='undefined' || val==null)
		return def;
	else
		return val;
}
function initDateObject()
{
	Date.prototype.compare=date_compare;
	Date.prototype.clone=date_clone;
	Date.prototype.format=date_format;
}

function date_format(sFormat)
{
	var dt=this;
	if(sFormat==null || typeof(sFormat)!="string")
		sFormat="";
	sFormat=sFormat.replace(/yyyy/ig,dt.getFullYear());
	var y=""+dt.getYear();
	if(y.length>2)
	{
		y=y.substring(y.length-2,y.length);
	}
	sFormat=sFormat.replace(/yy/ig,y);
	sFormat=sFormat.replace(/mm/ig,add2bit(dt.getMonth()+1));
	sFormat=sFormat.replace(/dd/ig,add2bit(dt.getDate()));
	return sFormat;
}

function date_clone()
{
	return new Date(this.getFullYear(),this.getMonth(),this.getDate());
}

function date_compare(dtCompare)
{
	var dt=this;
	var hr=0;

	if(dt && dtCompare)
	{
		if(dt.getFullYear()>dtCompare.getFullYear())
			hr=1;
		else if(dt.getFullYear()<dtCompare.getFullYear())
			hr=-1;
		else if(dt.getMonth()>dtCompare.getMonth())
			hr=1;
		else if(dt.getMonth()<dtCompare.getMonth())
			hr=-1;
		else if(dt.getDate()>dtCompare.getDate())
			hr=1;
		else if(dt.getDate()<dtCompare.getDate())
			hr=-1;
	}
	return hr;
}

function date_getDateFromVT_DATE(dt)
{

	dt=dt.replace(/\//g,"-");
	dt=Date.parse(dt);
	if(isNaN(dt))
		dt=null;
	else
		dt=new Date(dt);
	return dt;
}
//隐藏下拉框等控件
function hideElement(elmID)
{
	ddt=getDropDownTable();
	for (i = 0; i < document.all.tags(elmID).length; i++)
	{
		obj = document.all.tags(elmID)[i];
		if (! obj || ! obj.offsetParent)
			continue;

		// Find the element's offsetTop and offsetLeft relative to the BODY tag.
		objLeft   = obj.offsetLeft;
		objTop    = obj.offsetTop;
		objParent = obj.offsetParent;
		while (objParent.tagName.toUpperCase() != "BODY")
		{
			objLeft  += objParent.offsetLeft;
			objTop   += objParent.offsetTop;
			objParent = objParent.offsetParent;
		}
		// Adjust the element's offsetTop relative to the dropdown menu
		//objTop = objTop - ddt.offsetTop;

		if (ddt.offsetLeft > (objLeft + obj.offsetWidth) || objLeft > (ddt.offsetLeft + ddt.offsetWidth))
			;
		else if (objTop > ddt.offsetTop+ddt.offsetHeight)
			;
		else if (objTop< ddt.offsetTop)
			;
		else
			obj.style.visibility = "hidden";
	}
}
//显示下拉框等控件
function showElement(elmID)
{
	for (i = 0; i < document.all.tags(elmID).length; i++)
	{
		obj = document.all.tags(elmID)[i];
		if (! obj || ! obj.offsetParent)
			continue;
		obj.style.visibility = "";
	}
}

//Call the initialize function
initDateObject();


////////////////////////////////////////////


function dp_DropClick1(element){
	//alert("element:"+element);
	//alert(element.outerHTML);
	if (document.readyState=="complete") {//页面加载完成后才能打开
		elements = new Array (element,self);
		window.showModalDialog(ctx+"/platform/js/DatePanel.htm",elements,"dialogHeight: 165px; dialogWidth: 160px; dialogTop: "+event.screenY+"px; dialogLeft: "+event.screenX+"px; edge: Raised; center: no; help: no; resizable: yes; status: no;scroll:no;");
	}
} 

function show_calendar() {
	p_item = arguments[0];
	subWin = arguments[1];
	objWinCal = subWin;
	objWinCal.opener = self;
	var p_month,p_year,p_format;
//	p_month = new String(gNow.getMonth());
//	p_year = new String(gNow.getFullYear().toString());
//	p_format = "yyyy-MM-dd";
	Build();
}


function Build() {
	objWinCal.document.open();

	// Setup the page...
	objWinCal.document.write("<html>");
	objWinCal.document.write("<head>");
	//objWinCal.document.write("<META http-equiv=Content-Type content=\"text/html; charset=gb2312\">");
	objWinCal.document.write("<LINK href='"+ctx+"/css/DatePickerPopUp.css' type='text/css' rel='stylesheet'/>");

	objWinCal.document.write("</head>");
	objWinCal.document.write("<body>");

	objWinCal.document.write(
					"<TABLE id=dpDropDownTable CELLSPACING=0 border=0  "+
					"onclick=\"openerWin.dp_ddt_click1();\" "+
					"ondblclick=\"openerWin.dp_ddt_dblclick1();\" >"+
					"<TR class=DPTitle>"+
					"<TD><span class=DPBtn onclick=\"openerWin.dp_monthChange1(-12);\" title=\"上年\"><<</span></TD>"+
					"<TD><span class=DPBtn onclick=\"openerWin.dp_monthChange1(-1);\" title=\"上月\"><-</span></TD>"+
					"<TD align=center colspan=3></TD>"+
					"<TD><span class=DPBtn onclick=\"openerWin.dp_monthChange1(1);\" title=\"下月\">-></span></TD>"+
					"<TD><span class=DPBtn onclick=\"openerWin.dp_monthChange1(12);\" title=\"下年\">>></span></TD>"+
					"</TR>"+
					"<TR>"+
					"<TD class=DPWeekName> 日 </TD>"+
					"<TD class=DPWeekName> 一 </TD>"+
					"<TD class=DPWeekName> 二 </TD>"+
					"<TD class=DPWeekName> 三 </TD>"+
					"<TD class=DPWeekName> 四 </TD>"+
					"<TD class=DPWeekName> 五 </TD>"+
					"<TD class=DPWeekName> 六 </TD>"+
					"</TR>"+
					"</TABLE>");


		var row=null;
		var cell=null;
		var ddt = objWinCal.document.all("dpDropDownTable");

		for(var i=2; i<8; i++)
		{
			row=ddt.insertRow(i);
			if(row)
			{
				for(var j=0; j<7; j++)
				{
					cell=row.insertCell(j);

				}
			}
		}



 objWinCal.document.write("</body></html>");

objWinCal.document.close();

 dp_initDropDown1();
}

 function dp_initDropDown1(){
 	 var dp=p_item;
   var ddt= objWinCal.document.all("dpDropDownTable");

   if (ddt) {
		ddt.curCell=null;
		var cell=null;
		var dt=new Date(dp.curDate.getFullYear(),dp.curDate.getMonth(),1);
		cell=ddt.rows[0].cells[2];
		if(cell)
		{
			cell.innerText=dp.getMonthName(dt.getMonth())+" "+dt.getFullYear();
		}

		var wd=dt.getDay();
		dt=new Date(dt.getFullYear(),dt.getMonth(),1-wd);
		var day=dt.getDate();
		for(var i=2; i<8; i++)
		{
			for(var j=0; j<7; j++)
			{
				cell=ddt.rows[i].cells[j];
				if(cell)
				{
					if(dp.curDate.getMonth()!=dt.getMonth())
						cell.className="DPCellOther";
					else if(dp.curDate.getDate()!=dt.getDate())
						cell.className="DPCell";
					else
					{
						cell.className="DPCell";
						dp_onCell1(cell);
					}
					cell.innerText=day;
					cell.year=dt.getFullYear();
					cell.month=dt.getMonth();
			
					dt.setDate(day+1);
					day=dt.getDate();
				}
			}
		}


  }


}


function dp_ddt_dblclick1()
{
	var src=objWinCal.event.srcElement;
	if(src && src.tagName=="TD")
	{
		var dp=p_item;
    var ddt= objWinCal.document.all("dpDropDownTable");
		if(ddt && dp)
		{
			var lOldMonth=dp.curDate.getMonth();
			if(dp.setCurDate(src.year,parseInt(src.month,10)+1,parseInt(src.innerText,10)))
			{
				objWinCal.close();
				//showElement("SELECT");
			}
		}
	}
}

function dp_ddt_click1()
{

	var src=objWinCal.event.srcElement;
	if(src && src.tagName=="TD")
	{

		var dp=p_item;
    var ddt= objWinCal.document.all("dpDropDownTable");
		if(ddt && dp)
		{
			var lOldMonth=dp.curDate.getMonth();
			if(dp.setCurDate(src.year,parseInt(src.month,10)+1,parseInt(src.innerText,10)))
			{
				if(src.month!=lOldMonth)
					dp_initDropDown1();
				else
					dp_onCell1(src);
			}
		}
	}
}


function dp_onCell1(src)
{
	var row=src.parentElement;
	if(row && row.tagName=="TR" && row.rowIndex>1)
	{
		var ddt= objWinCal.document.all("dpDropDownTable");
		if(ddt)
		{
			if(ddt.curCell)
				ddt.curCell.className=ddt.curCellOldClass;
			ddt.curCellOldClass=src.className;
			src.className="DPCellSelect";
			ddt.curCell=src;
		}
	}
}


function dp_monthChange1(lStep)
{
	var src=objWinCal.event.srcElement;
	if(src)
	{
		var ddt= objWinCal.document.all("dpDropDownTable");
		var dp=p_item;
		if(ddt && dp)
		{
			var dt=dp.curDate.clone();
			var lOldMonth=dt.getMonth();
			var lOldDay=dt.getDate();

			dt.setDate(1);
			dt.setMonth(lOldMonth+lStep+1);
			dt.setDate(0);
			if(dt.getDate()>lOldDay)
				dt.setDate(lOldDay);
			if(dp.setCurDate(dt.getFullYear(),dt.getMonth()+1,dt.getDate()))
				dp_initDropDown1();
		}
	}
}

function setInputValueToDateValue(obj) {
  if (isFlag == false) return false;
  var strRes = getValidDate(obj.value);
  var strArray = strRes.split("-");
  var lYear = strArray[0];
  var lMonth = strArray[1];
  var lDay = strArray[2];
  var dp=getParentFromSrc(obj,"SPAN");
  if (strRes != "") {
    dp.setCurDate(lYear,lMonth,lDay);
  }else{
    dp.setDateNull();
  }

}
function dp_setDateNull() {

   var dp=this;
   var hr=false;

   if(dp && dp.curDate){
     var src=dp.children[0];
     if(src && src.tagName=="INPUT"){
       src.value="";
       src=dp.children[2];
       if(src && src.tagName=="INPUT"){
         src.value="";
         src=dp.children[4];
         if(src && src.tagName=="INPUT"){
           src.value="";
           hr=true;
         }
       }
     }
  }
  return hr;
}
//把值补成2位
function add2bit(value){
   if(value.toString().length==1){
     return "0"+value;
   }
   return value;
}
//date component end