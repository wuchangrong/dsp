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

function submitRecord() {   
   if (window.confirm("确定要提交吗?")){
	   showOperationProgress("提交");
	   document.forms[0].STATUS.value="1";   //提交状态   
	   var doWhat = document.getElementById("doWhat").value;
	   document.getElementById("method").value = "doUpdateStatusByVO";
	   document.forms[0].submit();
    }	   
}

function beforePopupPerson(){
    return true;
	  //return [{param:'company_id',value:document.forms[0].company_id.value},{param:'division_id',value:document.forms[0].DEPT_ID.value}];
}