var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function init(){
	document.getElementById("PARENT_DIR").value=parent.document.getElementById("currentDirID").value;
	document.getElementById("DIRELEV_NO").value=parseInt(parent.document.getElementById("currentLevel").value)+1;
}
function saveAndNewRecord() {
   showOperationProgress("±£´æ");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}

function saveRecord() {
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