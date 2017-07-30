var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;


function saveRecord() { 
	var ctx = document.getElementById("ctx").value;
	var tableName = "SM_ROLE";
	var rowid = document.getElementById("smr_ROW_ID").value;
	if(rowid == null || rowid == "")
		rowid = "-1";
	var roleCode = document.getElementById("smr_ROLE_CODE").value;
	var roleName = document.getElementById("smr_ROLE_NAME").value;
	
   if (ispronull()==false) {
    		return;
   }   
    if(!isUniqueValue(ctx,tableName,"ROLE_CODE",roleCode,rowid))
    {
        alert(sm_cheRoleCode);
        document.forms[0].smr_ROLE_CODE.focus();
        return false;
    }
    if(!isUniqueValue(ctx,tableName,"ROLE_NAME",roleName,rowid))
    {
        alert(sm_cheRoleName);
        document.forms[0].smr_ROLE_NAME.focus();
        return false;
    }
   showOperationProgress(sm_save);
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAdd":"doEdit");
   document.forms[0].submit();
}

function returnPage() {
   showOperationProgress(sm_back);
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}

function ispronull()
 {
        var needadd=new Array(sm_role_code,sm_role_name);
        var needlength=needadd.length;
        
        for (i = 0; i < needlength; i++)
         {
           var procodedesc=needadd[i];
           var procode=procodedesc.substr(0,procodedesc.indexOf("@"));
           var prodesc=procodedesc.substr(procodedesc.indexOf("@")+1);
           
           if (document.forms[0].elements[procode].length==0||document.forms[0].elements[procode].value=="")
           {
              alert(sm_write+prodesc+"!");
              document.forms[0].elements[procode].focus();
              return(false);
           }
         }
 }