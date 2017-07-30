var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function queryRecord() {
    showOperationProgress("查询");
    document.getElementById("method").value = "doSearch";
    document.forms[0].submit();
}
function multiQueryRec() {
}

function createRecord() {
	showOperationProgress("新增");
    document.getElementById("method").value = "doAddIni";
    document.getElementById("doWhat").value = "add";
    document.forms[0].submit();
}

function modifyById(rowid) {
		showOperationProgress("修改");
		var url = document.forms[0].action + "?chk=" + rowid;
    	document.getElementById("method").value = "doEditIni";
    	document.getElementById("doWhat").value = "edit";
    	document.forms[0].action = url;
    	document.forms[0].submit();

}

function modifyRecord() {
    var row_id = hasOneRecord("chk");
    if(row_id != -1) {
        modifyById(row_id);
    }
    else {
        alert("请选择一条记录修改！");
    }
}

function deleteRecord() {
    if(hasSelectedRecord("chk")) {
    	if(AF_confirm("删除", "记录")) {
			showOperationProgress("删除");
    		document.getElementById("method").value = "doDelete";
    		document.forms[0].submit();
    	}
    }
    else {
        alert("请选择记录删除！");
    }
}

function deleteById(rowid) {
    if(AF_confirm("删除", "记录")) {
		showOperationProgress("删除");
		var url = document.forms[0].action + "?chk=" + rowid;
    	document.getElementById("method").value = "doDelete";
    	document.forms[0].action = url;
    	document.forms[0].submit();
    } 	
}

function viewRecord() {
    var chk = hasOneRecord("chk");
    if(chk != -1) {
        viewRecordById(null,chk); 
    }
    else {
    	alert("请选择一条记录查看！");
    }
}

function viewRecordById(obj,rowId){
   //alert(obj.innerText);
   //alert(rowId);
   var url = document.forms[0].action + "?method=doView" + "&chk=" + rowId+"&programId="+document.all.programId.value;
   //openWindow(url, "查看", 600, 400);
   document.forms[0].action = url;
   document.forms[0].submit();   
}