var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveAndNewRecord() {
   showOperationProgress("����");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}

function saveRecord() {
   showOperationProgress("����");
   var doWhat = document.getElementById("doWhat").value;
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
	document.getElementById("method").value = "doAddRouteDailyDetailRow";
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
    if(currCol == "END_TIME")
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
       setFocus("detailForm_RouteDailyDetail",id+1,nextCol);
       return;
    }
    else {
       setFocus("detailForm_RouteDailyDetail",id,nextCol);
       return;    
    }

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
