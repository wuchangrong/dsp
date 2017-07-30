var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function init()
{
    document.getElementById('area').value = parent.document.getElementById('area').value;
    document.getElementById('province').value = parent.document.getElementById('province').value;
}
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