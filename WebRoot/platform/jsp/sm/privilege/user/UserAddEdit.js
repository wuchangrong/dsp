var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveRecord()
{
	if (ispronull()==false)
    {
        return;
    }
  	if (judgePassword()==false)
    {
        return;
    }
    var inureDate=document.all.inure_date.value;
    var abateDate=document.all.abate_date.value;

    if (dateCompare(inureDate,abateDate,sm_cheUserDate)==false)
    {
        return;
    }
     var email = document.forms[0].email.value;
    if(email&&!checkEmail(email))
    {
        alert(sm_cheUserEmail);
        document.forms[0].email.focus();
        return false;
    }

    var mobile = document.forms[0].mobile.value;
    if(mobile&&!checkMobile(mobile))
    {
        alert(sm_cheUserMobile);
        document.forms[0].mobile.focus();
        return false;
    }
    
    var tel = document.forms[0].contact_phone.value;
    if (tel&&!checkTelNumber(tel)){
       alert(sm_cheUserPhone);
        document.forms[0].fax.focus();
        return false;
    }
    var fax = document.forms[0].fax.value;
    if (fax&&!checkTelNumber(fax)){
       alert(sm_cheUserFax);
        document.forms[0].email.focus();
        return false;
    }
    
    
	var ctx = document.getElementById("ctx").value;
	var tableName = "SM_USER";
	var rowid = document.getElementById("row_id").value;
	if(rowid == null || rowid == "")
		rowid = "-1";
	var userCode = document.getElementById("user_code").value;
    
    if(!isUniqueValue(ctx,tableName,"USER_CODE",userCode,rowid))
    {
        alert(sm_cheUserCode);
        document.forms[0].user_code.focus();
        return false;
    }
 	var doWhat = document.getElementById("doWhat").value;
   	document.getElementById("method").value = (doWhat=="add"?"doAdd":"doEdit");
   	document.forms[0].submit();
}
function returnPage()
{
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}
function judgePassword()
{
    if (document.all.password.value != document.all.passwordJudge.value)
    {
        alert(sm_cheUserPassword);
        document.all.passwordJudge.select();
        document.all.passwordJudge.focus();
        return(false);
    }
}
function ispronull()
 {
        var needadd=new Array(sm_user_code,sm_user_name,sm_attr_flag,sm_password,sm_passwordJudge,sm_cert_yn,sm_inure_date,sm_abate_date);
        var needlength=needadd.length;
        for (i = 0; i < needlength; i++)
         {
           var procodedesc=needadd[i];
           var procode=procodedesc.substr(0,procodedesc.indexOf("@"));
           var prodesc=procodedesc.substr(procodedesc.indexOf("@")+1);
           if (document.forms[0].elements[procode].length==0||document.forms[0].elements[procode].value==""||document.forms[0].elements[procode].value=="null")
           {
              alert(sm_write+prodesc+"!");
              document.forms[0].elements[procode].focus();
              return(false);
           }
         }
 }
 
function beforePopupDivision(){
	if(!document.forms[0].company_id.value){
		alert(sm_chooseCompany);
		return false;
	}else{
	  return [{param:'company_id',value:document.forms[0].company_id.value}];
	}
}

function beforePopupPerson(){
	if(!document.forms[0].company_id.value){
		alert(sm_chooseCompany);
		return false;
	}
	if(!document.forms[0].division_id.value){
		alert(sm_chooseDivision);
		return false;
	}else{
	  return [{param:'company_id',value:document.forms[0].company_id.value},{param:'division_id',value:document.forms[0].division_id.value}];
	}
}

function companyChange(){
  if(division != null){
    division.clean();
  }
  if(person != null){
    person.clean();
  }
}

function divisionChange(){
  if(person != null){
    person.clean();
  }
}