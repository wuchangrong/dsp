var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveAndNewRecord() {
	if(checkNull("type_TYPE_CODE"))
	{
		return;
	}
   showOperationProgress("����");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}

function saveRecord() {
	if(checkNull("type_TYPE_CODE;type_STATUS")) return;
	if (UniCheck()) return;
	var doWhat = document.getElementById("doWhat").value;
	var codeObj = document.all("type_TYPE_CODE");
	if(!checkDetailTabel())
	{
		return;
	}
   showOperationProgress("����");
   document.getElementById("method").value = (doWhat=="add"?"doAdd":"doEdit");
   document.forms[0].submit();
}
function returnPage() {
   showOperationProgress("����");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}

function addDetailRec_open() {
	document.getElementById("method").value = "doAddDetailRow";
	document.forms[0].submit();
}
function modifyDetailRec_open(){
}
function deleteDetailRec(){
}

function doAddDetailRow() {
	document.getElementById("method").value = "doAddCodelistDetailRow";
	document.forms[0].submit();
}

//todo:����س�����
//currCol:Ϊ�б��е�ǰ�ؼ�����
//nextCol:�س����к�Ķ�λ�ؼ�����
//todo:����س�����
//currCol:Ϊ�б��е�ǰ�ؼ�����
//nextCol:�س����к�Ķ�λ�ؼ�����
function on_keypress(http,id,currCol,nextCol)
{
  if (event.keyCode==13 )
  {
    window.event.keyCode=0;
    if(currCol == "list_STATUS")
    {
       var rowCount = getShowRowCount("dataTable")-1;
       if ((id+2)>rowCount) //�Ƿ񳬹�������ʾ�У�������ʾ���ص���
       {
         if (!showHiddenRow(id+1)) //�Ƿ�����ʾ���ص��У������������µ���
         {
          doAddDetailRow();
          return;
         }
       }
       setFocus("detailForm_CodelistDetail",id+1,nextCol);
       return;
    }
    if(currCol == "list_COMMENTS")
    {
    	document.all("checkbox_detailForm_CodelistDetail[" + id + "].list_STATUS").focus();
    }
	setFocus("detailForm_CodelistDetail",id,nextCol);
  }

}


//��ʾ���ص��� id����ID
function showHiddenRow(id)
{
   var row= eval("document.all.dataRow"+id);
   if (typeof(row)!="object")
     return false;
   showRow(row);
   return true;
}


//ɾ��һ�� obj:�ж���isHiddenRow:�Ƿ������� true false
function deleteThisRow(obj,isHiddenRow)
{
   	var cell = obj.parentElement;//ȡthis������ΪCELL
  	var row = cell.parentElement; //ȡcell������ΪROW
	deleteRow(obj,isHiddenRow);
}

function checkDetailTabel()
{
	var tabObj = document.all("dataTable");
	var count = 0;
	var codeName;
	var codeValue;
	for(var i=0;i<tabObj.rows.length-1;i++)
	{
		codeName = document.all("detailForm_CodelistDetail["+i+"].list_CODE_NAME").value.trim();
		if(codeName != null && codeName != "")
		{
			count++;
			codeValue = document.all("detailForm_CodelistDetail["+i+"].list_CODE_VALUE");
			if(codeValue.value == null || codeValue.value.trim() == "")
			{
				alert("����д���Ƶ�ֵ��");
				codeValue.focus();
				return false;
			}
		}
	}
	if(count == 0)
	{
		alert("����д���ƺ�ֵ��");
		return false;
	}else
	{
		return true;
	}
}
function UniCheck(){
	var code = document.all("type_TYPE_CODE").value;
	var id = document.all("type_ROW_ID").value;
	var dowhat = document.all("doWhat").value;
	var result=true;
	if("add"==dowhat)
	{
		result=isUniqueValueDefault("sm_code_type","type_code",code,-1);
	}
	else{
		result=isUniqueValueDefault("sm_code_type","type_code",code,id);
	}
	if(result=="1") return false;
	if(result=="0") 
	{
		alert(getUniqueAlertMsg("����"));
	return true;
	}
}
