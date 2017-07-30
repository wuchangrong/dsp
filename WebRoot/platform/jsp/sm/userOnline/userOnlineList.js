var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function queryRecord() {
    showOperationProgress("查询");
    document.getElementById("method").value = "doSearch";
    document.forms[0].submit();
}

function shutdownUser() {
    if(hasSelectedRecord("chk")) {
    	if(confirm("是否确认清除所选中的用户？")) {
			showOperationProgress("重新查询");
    		document.getElementById("method").value = "doDelete";
    		document.forms[0].submit();
    	}
    }
    else {
        alert("请选择要清除的用户！");
    }
}