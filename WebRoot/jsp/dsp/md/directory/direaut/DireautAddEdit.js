var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveForSubdir() {
   showOperationProgress("保存到子目录");
   document.getElementById("method").value = "doEdit";
   document.getElementById("isSubdir").value = "1";
   document.getElementById("currentDirID").value = parent.document.getElementById("currentDirID").value 
   document.forms[0].submit();
}
function saveRecord() {
   showOperationProgress("保存");
   document.getElementById("method").value = "doEdit";
   document.getElementById("isSubdir").value = "0";
   document.getElementById("currentDirID").value = parent.document.getElementById("currentDirID").value
   document.forms[0].submit();
}
function returnPage() {
   showOperationProgress("返回");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}
function deleteRecord() {
   showOperationProgress("删除");
	document.getElementById("method").value = "doDelete";
   document.getElementById("isSubdir").value = "0";
   document.getElementById("currentDirID").value = parent.document.getElementById("currentDirID").value 
	document.forms[0].submit();
}
function deleteForSubdir() {
   showOperationProgress("删除到子目录");
   document.getElementById("isSubdir").value = "1";
	document.getElementById("method").value = "doDelete";
   document.getElementById("currentDirID").value = parent.document.getElementById("currentDirID").value 
	document.forms[0].submit();
}