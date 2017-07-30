var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

var g_code;
var g_shortCode;
var g_name;
function initCheckbox (ctx)
{
	var temp;
	temp = document.forms[0].DEPT_IS_LOCATION;
	if (temp.value=="Y")
		temp.value="Y";
	else temp.value="N";
	temp = document.forms[0].DEPT_IS_VISITSALES;
	if (temp.value=="Y")
		temp.value="Y";
	else temp.value="N";
	temp = document.forms[0].DEPT_IS_WAREHOUSE;
	if (temp.value=="Y")
		temp.value="Y";
	else temp.value="N";
	temp = document.forms[0].DEPT_STATUS;
	if (temp.value=="1")
		temp.value="1";
	else temp.value="0";
	
	g_code = document.forms[0].DEPT_DEPT_CODE.value;
	g_shortCode = document.forms[0].DEPT_SHORT_CODE.value;
	g_name = document.forms[0].DEPT_DEPT_NAME.value;
}
function saveAndNewRecord() {
	if (!uniqueCheck ())
		return ;
   showOperationProgress("±£´æ");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}
function saveRecord() {
	if (!uniqueCheck ())
		return ;
   showOperationProgress("±£´æ");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAdd":"doEdit");
   document.forms[0].submit();
}
function returnPage() {
   showOperationProgress("·µ»Ø");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}
function uniqueCheck(){
	var code = document.all("DEPT_DEPT_CODE").value;
	var shortCode = document.all("DEPT_SHORT_CODE").value;
	var name = document.all("DEPT_DEPT_NAME").value;
	var id = document.all("DEPT_ROW_ID").value;
	var dowhat = document.all("doWhat").value;
	var result=true;
	if("add"==dowhat)
	{
		result=isUniqueValueDefault("md_dept","dept_code",code,-1);
	}
	else{
		result=isUniqueValueDefault("md_dept","dept_code",code,id);
	}
	if(!result) {
		alert(getUniqueAlertMsg("±àÂë"));
		return false;
	}
	if("add"==dowhat)
	{
		result=isUniqueValueDefault("md_dept","short_code",shortCode,-1);
	}
	else{
		result=isUniqueValueDefault("md_dept","short_code",shortCode,id);
	}
	if(!result) {
		alert(getUniqueAlertMsg("¼òÂë"));
		return false;
	}
	if("add"==dowhat)
	{
		result=isUniqueValueDefault("md_dept","dept_name",name,-1);
	}
	else{
		result=isUniqueValueDefault("md_dept","dept_name",name,id);
	}
	if(!result) {
		alert(getUniqueAlertMsg("Ãû³Æ"));
		return false;
	}
	return result;
}