var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveAndNewRecord() {
	if(checkNull("type_TYPE_CODE"))
	{
		return;
	}
   showOperationProgress("保存");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}

function saveRecord() {
	if(checkNull("type_TYPE_CODE;type_STATUS")) return;
	if (UniCheck()) return;
	var doWhat = document.getElementById("doWhat").value;
	var codeObj = document.all("type_TYPE_CODE");
	if(!checkDetailTabel())
	{
		return;
	}
   showOperationProgress("保存");
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
	document.getElementById("method").value = "doAddCodelistDetailRow";
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
    if(currCol == "list_STATUS")
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
       setFocus("detailForm_CodelistDetail",id+1,nextCol);
       return;
    }
    if(currCol == "list_COMMENTS")
    {
    	document.all("checkbox_detailForm_CodelistDetail[" + id + "].list_STATUS").focus();
    }
	setFocus("detailForm_CodelistDetail",id,nextCol);
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

function checkDetailTabel()
{
	var tabObj = document.all("dataTable");
	var count = 0;
	var codeName;
	var codeValue;
	for(var i=0;i<tabObj.rows.length-1;i++)
	{
		codeName = document.all("detailForm_CodelistDetail["+i+"].list_CODE_NAME").value.trim();
		if(codeName != null && codeName != "")
		{
			count++;
			codeValue = document.all("detailForm_CodelistDetail["+i+"].list_CODE_VALUE");
			if(codeValue.value == null || codeValue.value.trim() == "")
			{
				alert("请填写名称的值。");
				codeValue.focus();
				return false;
			}
		}
	}
	if(count == 0)
	{
		alert("请填写名称和值。");
		return false;
	}else
	{
		return true;
	}
}
function UniCheck(){
	var code = document.all("type_TYPE_CODE").value;
	var id = document.all("type_ROW_ID").value;
	var dowhat = document.all("doWhat").value;
	var result=true;
	if("add"==dowhat)
	{
		result=isUniqueValueDefault("sm_code_type","type_code",code,-1);
	}
	else{
		result=isUniqueValueDefault("sm_code_type","type_code",code,id);
	}
	if(result=="1") return false;
	if(result=="0") 
	{
		alert(getUniqueAlertMsg("编码"));
	return true;
	}
}
