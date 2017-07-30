var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function viewRecord() {
    var chk = hasOneRecord("chk");
    var whereToBack = document.getElementById("whereToBack").value;
    if(chk != -1) {
    	var url = document.forms[0].action + "?method=doView" + "&chk=" + chk+"&whereToBack=" + whereToBack+"&programId="+document.all.programId.value;
        document.forms[0].action = url;
       	document.forms[0].submit();
    }
    else {
    	alert(sm_selViewRecord);
    }
}

function queryRecord()
{
	document.getElementById("method").value = "doSearch";
    
    document.forms[0].submit();
}

function manageRole(){

	var chk = hasOneRecord("chk");
  	if(chk != -1)
    {
    	var userId = document.getElementById("userId").value;
       	//如果用户选择的是自己则不能授权
 //       if(userId!=hasOneRecord("chk"))
 //       {
 //           alert(sm_cheUserRole+" dui ma ?");
 //           return;
//        }
      var url = document.forms[0].action + "?method=doAssignRoleIni" + "&chk=" + chk;
      document.forms[0].action = url;
      document.forms[0].submit();
    }
    else
    {
        alert(sm_selUserRole);
    }
}