var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;
var getBackString="";


function returnPage() {
   showOperationProgress(sm_back);
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}

function saveRecord(){
    if (getBackString.length<1)
    {
        alert(sm_selUserModule);
        return;
    }else{
    	showOperationProgress(sm_save);
    	document.all.module_string.value=getBackString;
	    document.getElementById("method").value = "doAssignProgram";
		document.forms[0].submit();
    }
}