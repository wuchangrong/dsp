var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;
function onlyCheck(obj){
	var checkStr = obj.value;
  if ( !((window.event.keyCode >= 48) && (window.event.keyCode <= 57)))
  {
       window.event.keyCode = 0 ;
       return false;
  }
}
function onlyNum(obj){
	var checkStr = obj.value;
  if ( !((window.event.keyCode >= 48) && (window.event.keyCode <= 57)|| (window.event.keyCode == 46)))
  {
       window.event.keyCode = 0 ;
       return false;
  }
}
function saveAndNewRecord() {
   showOperationProgress("±£´æ");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}
function uniqueCheck()
{
	var code=document.getElementById("WH_WH_CODE").value;
	var name=document.getElementById("WH_WH_NAME").value;
	var dowhat = document.all("doWhat").value;
	var id=document.getElementById("WH_ROW_ID").value;
	var result=false;
	if(dowhat=="add"){
		result=isUniqueValueDefault("MD_WAREHOUSE","WH_CODE",code,-1);
	}
	else{
		result=isUniqueValueDefault("MD_WAREHOUSE","WH_CODE",code,id);
	}
    if(!result)
    {
        alert(getUniqueAlertMsg('²Ö¿â±àÂë'));
        return false;
    }
	if(dowhat=="add"){
		result=isUniqueValueDefault("MD_WAREHOUSE","WH_NAME",name,-1);
	}
	else{
		result=isUniqueValueDefault("MD_WAREHOUSE","WH_NAME",name,id);
	}
    if(!result)
    {
        alert(getUniqueAlertMsg('²Ö¿âÃû³Æ'));
        return false;
    }
    return result;
}
function saveRecord() {
	if (checkNull("WH_WH_CODE;WH_WH_NAME;WH_LOCATION_ID",true))
		return;
	if (!uniqueCheck())
		return
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