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
    
    if((parent.document.getElementById('province').value=='-1'|| parent.document.getElementById('province').value=='undefined'
        || parent.document.getElementById('province').value=='') 
        && parent.document.getElementById('code').value!='710000'
        && parent.document.getElementById('code').value!='810000'
        && parent.document.getElementById('code').value!='820000')
    {
        alert('�������������ӹ�Ӧ��');
        return;
    }
	showOperationProgress("����");
    document.getElementById("method").value = "doAddIni";
    document.getElementById("doWhat").value = "add";
    document.forms[0].submit();
}

function modifyRecord() {
    if(hasOneRecord("chk") != -1) {
		showOperationProgress("�޸�");
    	document.getElementById("method").value = "doEditIni";
    	document.getElementById("doWhat").value = "edit";
    	document.forms[0].submit();
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

function viewRecord() {
    var chk = hasOneRecord("chk");
    if(chk != -1) {
    	var url = document.forms[0].action + "?method=doView" + "&chk=" + chk+"&programId="+document.all.programId.value;
    	//openWindow(url, "�鿴", 600, 400);
        document.forms[0].action = url;
        document.forms[0].submit();
    }
    else {
    	alert("��ѡ��һ����¼�鿴��");
    }
}