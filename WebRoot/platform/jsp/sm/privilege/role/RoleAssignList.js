var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function queryRecord() {
    showOperationProgress(sm_queryRecord);
    document.getElementById("method").value = "doSearch";
    document.forms[0].submit();
}

function manageUser(){
	var chk = hasOneRecord("chk");
    if(chk != -1) {
    	var url = document.forms[0].action + "?method=doAssignUserIni" + "&chk=" + chk+"&programId="+document.all.programId.value;
        document.forms[0].action = url;
        document.forms[0].submit();
    }
    else {
    	alert("请选择一条记录");
    }
}