var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveAndNewRecord() {
   showOperationProgress("保存");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}

function saveRecord() {
   showOperationProgress("保存");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAdd":"doEdit");
   document.forms[0].submit();
}
function returnPage() {
   showOperationProgress("返回");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}

function addDetailRec_open() {
	document.getElementById("method").value = "doAddDetailRow";
	document.forms[0].submit();
}
function modifyDetailRec_open(){
}
function deleteDetailRec(){
}

function doAddDetailRow() {
	document.getElementById("method").value = "doAddRouteDailyDetailRow";
	document.forms[0].submit();
}

//todo:处理回车换行
//currCol:为列表中当前控件名称
//nextCol:回车换行后的定位控件名称
//todo:处理回车换行
//currCol:为列表中当前控件名称
//nextCol:回车换行后的定位控件名称
function on_keypress(http,id,currCol,nextCol)
{
  if (event.keyCode==13 )
  {
    window.event.keyCode=0;
    if(currCol == "END_TIME")
    {
       var rowCount = getShowRowCount("dataTable")-1;
       if ((id+2)>rowCount) //是否超过最大的显示行，是则显示隐藏的行
       {
         if (!showHiddenRow(id+1)) //是否能显示隐藏的行，不能则增加新的行
         {
          doAddDetailRow();
          return;
         }
       }
       setFocus("detailForm_RouteDailyDetail",id+1,nextCol);
       return;
    }
    else {
       setFocus("detailForm_RouteDailyDetail",id,nextCol);
       return;    
    }

  }

}


//显示隐藏的行 id：行ID
function showHiddenRow(id)
{
   var row= eval("document.all.dataRow"+id);
   if (typeof(row)!="object")
     return false;
   showRow(row);
   return true;
}


//删除一行 obj:行对象；isHiddenRow:是否隐藏行 true false
function deleteThisRow(obj,isHiddenRow)
{
   	var cell = obj.parentElement;//取this父对象为CELL
  	var row = cell.parentElement; //取cell父对象为ROW
	deleteRow(obj,isHiddenRow);
}
