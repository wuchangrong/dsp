var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function queryRecord() {
    showOperationProgress("��ѯ");
    document.getElementById("method").value = "doSearch";
    document.forms[0].submit();
}
function multiQueryRec() {
}

function createRecord() {
	showOperationProgress("����");
    document.getElementById("method").value = "doAddIni";
    document.getElementById("doWhat").value = "add";
    document.forms[0].submit();
}

function modifyById(rowid) {
		showOperationProgress("�޸�");
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
        alert("��ѡ��һ����¼�޸ģ�");
    }
}

function deleteRecord() {
    if(hasSelectedRecord("chk")) {
    	if(EAP_confirm("ɾ��", "��¼")) {
			showOperationProgress("ɾ��");
    		document.getElementById("method").value = "doDelete";
    		document.forms[0].submit();
    	}
    }
    else {
        alert("��ѡ���¼ɾ����");
    }
}

function deleteById(rowid) {
    if(EAP_confirm("ɾ��", "��¼")) {
		showOperationProgress("ɾ��");
		var url = document.forms[0].action + "?chk=" + rowid;
    	document.getElementById("method").value = "doDelete";
    	document.forms[0].action = url;
    	document.forms[0].submit();
    } 	
}

function viewRecord() {
    var chk = hasOneRecord("chk");
    if(chk != -1) {
    	var url = document.forms[0].action + "?method=doView" + "&chk=" + chk+"&programId="+document.all.programId.value;
        document.forms[0].action = url;
        document.forms[0].submit();
    }
    else {
    	alert("��ѡ��һ����¼�鿴��");
    }
}

