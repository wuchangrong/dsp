var availWidthScreen = screen.availWidth / 1.2;
var availHeightScreen = screen.availHeight / 1.2 ;
var availWidthScreenDifference = 300;
var availHeightScreenDifference = 100;

function saveAndNewRecord() {
   showOperationProgress("保存");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAddAndNew":"doEditAndNew");
   document.forms[0].submit();
}
function returnPage() {
   showOperationProgress("返回");
   document.getElementById("method").value = "doSearch";
   document.forms[0].submit();
}
function isvalidate()
{
    var row_id = document.getElementById('SUP_ROW_ID').value;
    var code = document.getElementById('SUP_SUPPLIERCODE').value;
    if(checkNull('SUP_SUPPLIERCODE;SUP_SUPPLIERDESC'))
    {
        return false;
    }
    var result = false;
    if(row_id == 'null'||row_id <=0)
    {
        result = isUniqueValueDefault('MD_SUPPLIER','SUPPLIERCODE',code,-1);
    }
    else
    {
        result = isUniqueValueDefault('MD_SUPPLIER','SUPPLIERCODE',code,row_id);
    }      
    if(!result)
    {
        alert(getUniqueAlertMsg('供应商编码'));
        return false;
    }
    return result;
}
function saveRecord() {
   if(!isvalidate())
   {
       return;
   }
   document.getElementById('SUP_PROVINCEID').value = parent.document.getElementById('province').value;
   document.getElementById('SUP_DISTRICTID').value = parent.document.getElementById('area').value;
   showOperationProgress("保存");
   var doWhat = document.getElementById("doWhat").value;
   document.getElementById("method").value = (doWhat=="add"?"doAdd":"doEdit");
   document.forms[0].submit();
}
function init()
{
    if('<%=WMS_BASE_SUPPLIER_SupplierForm.getSUP_STATUS()%>'=='1')
    {
        document.getElementById('SUP_STATUS').value = '1';
    }
    else
    {
        document.getElementById('SUP_STATUS').value = '0';
    }
    document.getElementById('area').value = parent.document.getElementById('area').value;
    document.getElementById('province').value = parent.document.getElementById('province').value;
}
