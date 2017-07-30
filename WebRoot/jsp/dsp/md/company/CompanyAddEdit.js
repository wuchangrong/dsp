var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function init()
{
	curDateInSet("CPN_BEGIN_DATE");
}

function saveRecord() {
	if(checkAll()==true)return;
	
	if(UniCheck())return;
	if(UniCheckName())return;
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

function checkAll(){
	var ids = "CPN_COMPANY_CODE;CPN_COMPANY_NAME";
	return checkNull(ids,true);
	
}

function UniCheck(){
	var code = document.all("CPN_COMPANY_CODE").value;
	var id = document.all("CPN_ROW_ID").value;
	var dowhat = document.all("doWhat").value;
	var result=true;
	if("add"==dowhat)
	{
		result=isUniqueValueDefault("md_company","company_code",code,-1);
	}
	else{
		result=isUniqueValueDefault("md_company","company_code",code,id);
	}
	if(result=="1") return false;
	if(result=="0") 
	{
		alert(getUniqueAlertMsg("±àÂë"));
	return true;
	}
}

function UniCheckName(){
	var name = document.all("CPN_COMPANY_NAME").value;
	var id = document.all("CPN_ROW_ID").value;
	var dowhat = document.all("doWhat").value;
	var result=true;
	if("add"==dowhat)
	{
		result = isUniqueValueDefault("md_company","company_name",name,-1);
	}
	else{
		result = isUniqueValueDefault("md_company","company_name",name,id);
	}
	if(result=="1") return false;
	if(result=="0")
	{
		alert(getUniqueAlertMsg("Ãû³Æ"));
		return true;
	} 
}

