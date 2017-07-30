var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function closePage() {
	window.close();
}
function viewDetailRec_open(){
}

function returnPage() {
//   showOperationProgress("·µ»Ø");
//   document.getElementById("method").value = "doSearch";
//   document.forms[0].submit();
    window.history.back(-1);
}