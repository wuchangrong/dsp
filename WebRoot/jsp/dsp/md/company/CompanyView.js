var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function init(){
	var tableList = eval("subDetail");
	var cell = tableList.rows(6).cells(3);
	if(cell.innerText==1){
		cell.innerText="∆Ù”√";
	}else{
		cell.innerText="Œ¥∆Ù”√";
	}	
}

function closePage() {
	window.close();
}
function viewRecord(){
}

function returnPage() {
   showOperationProgress("∑µªÿ");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}