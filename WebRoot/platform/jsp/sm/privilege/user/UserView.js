var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function returnPage() {
var viewType = document.getElementById("whereToBack").value;
var ctx = document.getElementById("ctx").value;

if (viewType=="userAuthorization")
    {
    	var url = ctx+"/sm/privilege/user/UserAuthorization.do?method=doSearch";
       
    }else if (viewType=="userProhibit")
    {
	   	
    	var url = ctx+"/sm/privilege/user/UserProhibit.do?method=doSearch";
    	
    }else if (viewType=="user")
    {

   	 	var url = ctx+"/sm/privilege/user/User.do?method=doSearch";
    }
    document.forms[0].action = url;
   	document.forms[0].submit();
}