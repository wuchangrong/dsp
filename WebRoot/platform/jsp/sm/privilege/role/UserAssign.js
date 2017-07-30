var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;
var getBackString="";
var avListLen = 0;
var availableUserArray = new Array(avListLen);
var asListLen = 0;
var assignedUserArray = new Array(asListLen);

function returnPage() {
   showOperationProgress(sm_back);
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}

function saveRecord(){
	var obj_value="";
    var userString="";
    var userLength=document.forms[0].elements["rightUserOption"].length;
    for (var i=0;i< userLength;i++)
    {
        obj_value= document.forms[0].elements["rightUserOption"].options[i].value;
        userString=userString+obj_value+",";
    }
    userString=userString.substr(0,userString.length-1);
    if (userString.length<1)
    {
        alert(sm_selRoleUser);
        return;
    }else{
    	showOperationProgress(sm_save);
    	document.all.user_string.value=userString;
	    document.getElementById("method").value = "doAssignUser";
		document.forms[0].submit();
    }
}

function init(){
	if(availableUserArray.length > 0){
		for(var i = 0 ; i < availableUserArray.length; i++){
			var tmp = availableUserArray[i];
			var arrTmp = tmp.split("|");
			var oOption = document.createElement("option");
			oOption.text=arrTmp[1];
			oOption.value=arrTmp[0];
			document.all.leftUserOption.add(oOption);
		}
	}
	if(assignedUserArray.length > 0){
		for(var j = 0 ; j < assignedUserArray.length; j++){
			var tmp = assignedUserArray[j];
			var arrTmp = tmp.split("|");
			var oOption = document.createElement("option");
			oOption.text=arrTmp[1];
			oOption.value=arrTmp[0];
			document.all.rightUserOption.add(oOption);
		}
		
	}
}

function msel_MoveItems(moveType)
{
    if (moveType==1)
    {
        var obj_index=document.forms[0].elements["leftUserOption"].selectedIndex;
        if (obj_index==-1)
        {
            alert(sm_selNoneRecord);
            return;
        }
        var obj_name=document.forms[0].elements["leftUserOption"].options[obj_index].text;
        var obj_value= document.forms[0].elements["leftUserOption"].options[obj_index].value;
        var oOption = document.createElement("OPTION");
        oOption.text=obj_name;
        oOption.value=obj_value;
        document.forms[0].elements["rightUserOption"].add(oOption);
        document.forms[0].elements["leftUserOption"].remove(obj_index);
    }else if (moveType==2)
    {
        var obj_value="";
        var userString="";
        var userLength=document.forms[0].elements["leftUserOption"].length;
        for (var i=0;i< userLength;i++)
        {
            var obj_name=document.forms[0].elements["leftUserOption"].options[0].text;
            var obj_value= document.forms[0].elements["leftUserOption"].options[0].value;
            var oOption = document.createElement("OPTION");
            oOption.text=obj_name;
            oOption.value=obj_value;
            document.forms[0].elements["rightUserOption"].add(oOption);
            document.forms[0].elements["leftUserOption"].remove(0);
        }
    }else if (moveType==3)
    {
        var obj_index=document.forms[0].elements["rightUserOption"].selectedIndex;
        if (obj_index==-1)
        {
            alert(sm_selNoneRecord);
             return;
        }
        var obj_name=document.forms[0].elements["rightUserOption"].options[obj_index].text;
        var obj_value= document.forms[0].elements["rightUserOption"].options[obj_index].value;
        var oOption = document.createElement("OPTION");
        oOption.text=obj_name;
        oOption.value=obj_value;
		document.forms[0].elements["leftUserOption"].add(oOption);
        document.forms[0].elements["rightUserOption"].remove(obj_index);
        //companyChange();
    }else if(moveType==4)
    {
        var obj_value="";
        var userString="";
        var userLength=document.forms[0].elements["rightUserOption"].length;
        for (var i=0;i< userLength;i++)
        {
            var obj_name=document.forms[0].elements["rightUserOption"].options[0].text;
            var obj_value= document.forms[0].elements["rightUserOption"].options[0].value;
            var oOption = document.createElement("OPTION");
            oOption.text=obj_name;
            oOption.value=obj_value;
			document.forms[0].elements["leftUserOption"].add(oOption);
            document.forms[0].elements["rightUserOption"].remove(0);
        }
        //companyChange();
    }
}

function reloadThisPage(obj) {
	  var userarray = null;
	  var val = obj.value;	
	  var userLength=document.forms[0].elements["rightUserOption"].length;
	  var ids="";
	  for(var i=0;i< userLength;i++){
	    var obj_value= document.forms[0].elements["rightUserOption"].options[i].value;
	    var text_value = document.forms[0].elements["rightUserOption"].options[i].innerText;
	    ids=ids+obj_value+"|"+text_value+"|0,";
	  }
	  if(ids.length>1){
	  	ids = ids.substring(0,ids.length-1);
	  	userarray = ids.split(",");
	  }
	  else{
	  	ids="";
	  	userarray = new Array(0);
	  }      
          
	document.all.leftUserOption.length = 0;
	document.all.rightUserOption.length = 0;

	if(availableUserArray.length > 0){
		for(var i = 0 ; i < availableUserArray.length; i++){
			var tmp = availableUserArray[i];
			var arrTmp = tmp.split("|");
			var oOption = document.createElement("option");
			oOption.text=arrTmp[1];
			oOption.value=arrTmp[0];
			if(val == null || val == "" || arrTmp[2]==val){
				document.all.leftUserOption.add(oOption);
			}
		}
	}
	if(userarray.length > 0){
		for(var j = 0 ; j < userarray.length; j++){
			var tmp = userarray[j];
			var arrTmp = tmp.split("|");
			var oOption = document.createElement("option");
			oOption.text=arrTmp[1];
			oOption.value=arrTmp[0];
			document.all.rightUserOption.add(oOption);
		}
	}
}
