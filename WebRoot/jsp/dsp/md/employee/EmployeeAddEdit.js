var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

/*
function init()
{
	var value = document.all('EMP_DEPTID').value;
	document.all('EMP_COMPANYID').onchange();
	if (value!=null)
		document.all('EMP_DEPTID').value = value;
	
}

function removeOptions(optionMenu)
{
  var n = optionMenu.options.length;
  for (var i=0; i < n-1; i++)
  {
	optionMenu.options.remove(1);
  }
  optionMenu.options[0].selected = 'true';
}

function addOptions(optionList, optionMenu)
{
	for (var i=0; i < optionList.length; i++)
	{
		optionMenu.options[i+1] = new Option(optionList[i].NAME, optionList[i].CODE);
	}
}

function getDept (obj)
{
	var company_id = obj.value;
	if (company_id==null) company_id=1;
	var sql = "select ROW_ID as CODE, DEPT_NAME as NAME from MD_DEPT where COMPANY_ID="+company_id+" order by ROW_ID";
	var json = getJsonData(sql);

	removeOptions(document.all("EMP_DEPTID"));
	if (json!='' && json!=null)
	{
		addOptions (eval(json), document.all("EMP_DEPTID"));
	}
}
*/

function saveAndNewRecord() {
	if(checkAll())return;
	
   showOperationProgress("保存");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}

function saveRecord() {
	if(checkAll())return;
	if(!uniCheck())return;
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

function checkAll(){
	var ids = "EMP_EMPLOYEECODE;EMP_EMPLOYEENAME;EMP_COMPANYID;EMP_DEPTID;EMP_DUTY;EMP_PLACE;EMP_DEGREE";
	return checkNull(ids,true);
}
function init1(){
	var dowhat = document.all("dowhat").value;
	if(dowhat=="add"){
		document.all("EMP_STATUS").value=1;
	}
}

function uniCheck()
{
	var code = document.all("EMP_EMPLOYEECODE").value.trim();
	var id = document.all("EMP_ROW_ID").value.trim();
	var dowhat = document.all("doWhat").value;
	var result = false;
	if("add"==dowhat)
	{
		result = isUniqueValueDefault('md_employee','employee_code',code,-1);
	}
	else
	{
		result = isUniqueValueDefault('md_employee','employee_code',code,id);
	}
	if(!result) 
	{
		alert(getUniqueAlertMsg("工号"));
		return false;
	}
	return result;
}