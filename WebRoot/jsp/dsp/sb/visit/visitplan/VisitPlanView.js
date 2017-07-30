var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function closePage() {
	window.close();
}
function viewRecord(){
}

function returnPage() {
   showOperationProgress("·µ»Ø");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}