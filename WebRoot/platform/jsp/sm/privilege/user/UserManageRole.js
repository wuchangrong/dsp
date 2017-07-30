var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;
var getBackString="";
var avListLen = 0;
var availableRoleArray = new Array(avListLen);
var asListLen = 0;
var assignedRoleArray = new Array(asListLen);

function returnPage() {
   showOperationProgress(sm_back);
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}

function saveRecord(){
	var obj_value="";
    var roleString="";
    var roleLength=document.forms[0].elements["rightRoleOption"].length;
    for (var i=0;i< roleLength;i++)
    {
        obj_value= document.forms[0].elements["rightRoleOption"].options[i].value;
        roleString=roleString+obj_value+",";
    }
    roleString=roleString.substr(0,roleString.length-1);
  
	showOperationProgress(sm_save);
	document.all.role_string.value=roleString;
    document.getElementById("method").value = "doAssignRole";
	document.forms[0].submit();
}

function init(){
	if(availableRoleArray.length > 0){
		for(var i = 0 ; i < availableRoleArray.length; i++){
			var tmp = availableRoleArray[i];
			if(tmp!=""){
				var arrTmp = tmp.split("|");
				var oOption = document.createElement("option");
				oOption.text=arrTmp[1];
				oOption.value=arrTmp[0];
				document.all.leftRoleOption.add(oOption);
			}
			
		}
	}
	if(assignedRoleArray.length > 0){

		for(var j = 0 ; j < assignedRoleArray.length; j++){
			var tmp = assignedRoleArray[j];
			var arrTmp = tmp.split("|");
			var oOption = document.createElement("option");
			oOption.text=arrTmp[1];
			oOption.value=arrTmp[0];
			document.all.rightRoleOption.add(oOption);
		}
	}
}


function msel_MoveItems(moveType)
{
    if (moveType==1)
    {
        var obj_index=document.forms[0].elements["leftRoleOption"].selectedIndex;
        if (obj_index==-1)
        {
            alert(sm_selNoneRecord);
            return;
        }
        var obj_name=document.forms[0].elements["leftRoleOption"].options[obj_index].text;
        var obj_value= document.forms[0].elements["leftRoleOption"].options[obj_index].value;
        if (obj_name ==sm_pleaseSelect)
        {
            alert(sm_selectRightRecord);
            return;
        }
        var oOption = document.createElement("OPTION");
        oOption.text=obj_name;
        oOption.value=obj_value;
        document.forms[0].elements["rightRoleOption"].add(oOption);
        document.forms[0].elements["leftRoleOption"].remove(obj_index);
        refrashTree();
    }else if (moveType==2)
    {
        var obj_value="";
        var userString="";
        var userLength=document.forms[0].elements["leftRoleOption"].length;
        for (var i=0;i< userLength;i++)
        {
            var obj_name=document.forms[0].elements["leftRoleOption"].options[0].text;
            var obj_value= document.forms[0].elements["leftRoleOption"].options[0].value;
            var oOption = document.createElement("OPTION");
            oOption.text=obj_name;
            oOption.value=obj_value;
            document.forms[0].elements["rightRoleOption"].add(oOption);
            document.forms[0].elements["leftRoleOption"].remove(0);
        }
        refrashTree();
    }else if (moveType==3)
    {
        var obj_index=document.forms[0].elements["rightRoleOption"].selectedIndex;
        if (obj_index==-1)
        {
            alert(sm_selNoneRecord);
             return;
        }
        var obj_name=document.forms[0].elements["rightRoleOption"].options[obj_index].text;
        var obj_value= document.forms[0].elements["rightRoleOption"].options[obj_index].value;
        if (obj_name ==sm_pleaseSelect)
        {
            alert(sm_selectRightRecord);
            return;
        }
        var oOption = document.createElement("OPTION");
        oOption.text=obj_name;
        oOption.value=obj_value;
		document.forms[0].elements["leftRoleOption"].add(oOption);
        document.forms[0].elements["rightRoleOption"].remove(obj_index);
        refrashTree();
       
    }else if(moveType==4)
    {
        var obj_value="";
        var userString="";
        var userLength=document.forms[0].elements["rightRoleOption"].length;
        for (var i=0;i< userLength;i++)
        {
            var obj_name=document.forms[0].elements["rightRoleOption"].options[0].text;
            var obj_value= document.forms[0].elements["rightRoleOption"].options[0].value;
            var oOption = document.createElement("OPTION");
            oOption.text=obj_name;
            oOption.value=obj_value;
			document.forms[0].elements["leftRoleOption"].add(oOption);
            document.forms[0].elements["rightRoleOption"].remove(0);
        }
        refrashTree();
    }
}

function refrashTree()
 {
	 var ctx = document.getElementById("ctx").value; 
     
     var rolesID="";
     var rightUserLength=document.forms[0].elements["rightRoleOption"].length;
     for (var i=0;i< rightUserLength;i++)
     {
         var right_obj_value= document.forms[0].elements["rightRoleOption"].options[i].value;
         rolesID=rolesID+right_obj_value+",";
     }
     rolesID=rolesID.substr(0,rolesID.length-1);
     if (rolesID.length==0)
     {
         rolesID="-1";
     }
    document.getElementById("ifrLoad").src =ctx+"/platform/jsp/common/sm/privilege/user/ProgramTree.jsp?rolesID="+rolesID;
    //self.ifrLoad.location =ctx+"/platform/jsp/common/sm/privilege/user/ProgramTree.jsp?rolesID="+rolesID;
    //document.all.ifrLoad.refresh;
    //location =ctx+"/platform/jsp/common/sm/privilege/user/ProgramTree.jsp?rolesID="+rolesID;
 }
