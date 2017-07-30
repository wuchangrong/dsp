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

function usingChange()
{
    var programId = document.forms[0].programId.value;
    document.getElementById("method").value="doUsingChange";
    if(hasOneRecord("chk")!=-1)
    {
    var s = document.getElementsByName("chk");
    var h = document.getElementsByName("using_flag");
    for(var i = 0;i<s.length;i++){

        if(s[i].checked)
        {
			if(h[i].value=="0"  || h[i].value=="2")
            {
                var getMsg=  window.confirm(sm_userRun);
                if (getMsg==false)
                {
                return;
                }
                //document.forms[0].action="<%=ctx%>/sm/privilege/user/UserAddEditIni.do?usingChange=1&programId="+programId;
                document.forms[0].submit();
            }
            if(h[i].value=="1")
            {	
                var getMsg=  window.confirm(sm_userStop);
                if (getMsg==false)
                {
                return;
                }
                //document.forms[0].action="<%=ctx%>/sm/privilege/user/UserAddEditIni.do?usingChange=2&programId="+programId;
                document.forms[0].submit();
            }
        }
    }
    }
    else
    {
         alert(sm_userProhibit);
    }
}