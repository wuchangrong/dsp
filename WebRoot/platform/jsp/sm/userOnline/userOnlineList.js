var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function queryRecord() {
    showOperationProgress("��ѯ");
    document.getElementById("method").value = "doSearch";
    document.forms[0].submit();
}

function shutdownUser() {
    if(hasSelectedRecord("chk")) {
    	if(confirm("�Ƿ�ȷ�������ѡ�е��û���")) {
			showOperationProgress("���²�ѯ");
    		document.getElementById("method").value = "doDelete";
    		document.forms[0].submit();
    	}
    }
    else {
        alert("��ѡ��Ҫ������û���");
    }
}