 var xmlHttp;
    function stateChanged() 
	{ 
	    if (xmlHttp.readyState==4&&xmlHttp.status==200)
	    { 
	    var result=xmlHttp.responseText;
	    if(result.indexOf("JS:") == 0)
	    {
		     eval(result.substring(3));
	    }
	    else
	    {
	        //alert(result);
	    }
	    }
	}
 /**
��������proxyRequest
������action Ҫִ�е�ACTION��PATH
     method ACTION�еķ���
     params ����
����ֵ���Ӻ�̨ƴд����Ӧ����
����ʾ����var response = proxyRequest(document.forms[0].action,'doAdd',"arg="+arg)
 */
    function proxyRequest(action,method,params)
	{
		xmlHttp=GetXmlHttpObject();
		var act_url = action;
		if(method != null && method != ""){
	        act_url += "?method=" + method;
	    }
	    xmlHttp.open("POST",act_url,false);
	    //������
	    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	    xmlHttp.onreadystatechange=stateChanged;	
		xmlHttp.send(URLEncoding(params));
		if (xmlHttp.readyState==4&&xmlHttp.status==200)
		{
		    return xmlHttp.responseText;;
		}
	}

    function GetXmlHttpObject()
	{
	var xmlHttp=null;
	if (window.XMLHttpRequest) {
      	    xmlHttp = new XMLHttpRequest();
   	   } else if (window.ActiveXObject) {
       	 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
   	   }
	return xmlHttp;
	}
	 /**
��������isUnique
������sql Ҫִ�е�SQL���
����ֵ��1�����صĽ���������� 0�����صĽ����������
����ʾ����var response = isUnique('select * from dual');
 */
	function isUnique(sql)
	{
	    xmlHttp=GetXmlHttpObject();
		var act_url = "../../../isUnique.do?method=isUnique";
		var params = "sql="+sql;
	    xmlHttp.open("POST",act_url,false);
	    //������
	    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	    xmlHttp.onreadystatechange=stateChanged;	
		xmlHttp.send(URLEncoding(params));
		if(xmlHttp.readyState==4&&xmlHttp.status==200)
		{
		    var result = xmlHttp.responseText;
		    return result;
		}
	}
	 /**
��������isUnique
������sql Ҫִ�е�SQL���
����ֵ��1�����صĽ���������� 0�����صĽ����������
����ʾ����var response = isUnique('select * from dual');
 */
	function isUnique2(sql,ctx)
	{
	    xmlHttp=GetXmlHttpObject();
		var act_url = ctx+"/isUnique.do?method=isUnique";
		var params = "sql="+sql;
	    xmlHttp.open("POST",act_url,false);
	    //������
	    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	    xmlHttp.onreadystatechange=stateChanged;	
		xmlHttp.send(URLEncoding(params));
		if(xmlHttp.readyState==4&&xmlHttp.status==200)
		{
		    var result = xmlHttp.responseText;
		    return result;
		}
	}
/*
*��������getJsonData
*������sql Ҫִ�е�SQL���
*����ֵ JSON�ַ���
*ע�⣺����SQL��ָ������
*/
function getJsonData(sql)
{  
	xmlHttp=GetXmlHttpObject();
    var act_url = "../../../isUnique.do?method=getSimpleJsonData";
	var params = "sql="+sql;
	xmlHttp.open("POST",act_url,false);
	//������
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	xmlHttp.onreadystatechange=stateChanged;	
    xmlHttp.send(URLEncoding(params));
	if(xmlHttp.readyState==4&&xmlHttp.status==200)
	{
	   var result = xmlHttp.responseText;
	   return result;
	}
}
/*
*��������getJsonData
*������sql Ҫִ�е�SQL���
*����ֵ JSON�ַ���
*ע�⣺����SQL��ָ������
*/
function getJsonData2(sql, ctx)
{  
	xmlHttp=GetXmlHttpObject();
    var act_url = ctx+"/isUnique.do?method=getSimpleJsonData";
	var params = "sql="+sql;
	xmlHttp.open("POST",act_url,false);
	//������
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	xmlHttp.onreadystatechange=stateChanged;	
    xmlHttp.send(URLEncoding(params));
	if(xmlHttp.readyState==4&&xmlHttp.status==200)
	{
	   var result = xmlHttp.responseText;
	   return result;
	}
}


/*
*��������getNestedJsonData
*������main_table:�������
      main_condition����������
      flag:trueΪȡ���ӱ����ݣ�falseΪȡ��������
      sub_table���ӱ����
      sub_condition���ӱ�����
*����ֵ JSON�ַ���
*ע�⣺����SQL��ָ������
*/
function getNestedJsonData(main_table, main_condition, flag, sub_table, sub_condition)
{
    xmlHttp=GetXmlHttpObject();
    var act_url = "../../../isUnique.do?method=getNestedJsonData";
    var params = "table="+main_table+"&main_condition="+main_condition+"&flag="+flag+"&sub_table="+sub_table+"&sub_condition="+sub_condition;
    xmlHttp.open("POST",act_url,false);
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	xmlHttp.onreadystatechange=stateChanged;	
    xmlHttp.send(URLEncoding(params));
	if(xmlHttp.readyState==4&&xmlHttp.status==200)
	{
	   var result = xmlHttp.responseText;
	   return result;
	}
}


//�õ��ִ����ֽ���	 
String.prototype.lenb = function()
{
	return this.replace(/[^\x00-\xff]/g,"**").length;
}
//ȥ��ǰ��հ�    
String.prototype.trim = function()
{
    return this.replace(/(^[\s]*)|([\s]*$)/g, "");
}
//ȥ��FORM�������ı����ǰ��հ�
function trimAll(form)
{
	for(var i = 0; i < form.elements.length; i ++)
	{
		if((form.elements[i].type=="text"||form.elements[i].type=="textarea")&&form.elements[i].name!="")
		{
			form.elements[i].value=form.elements[i].value.trim();
		}
	}
}

//===========================ͨ��У����========================================//
/*
*ʾ������BODY�м���INIT����
*<body onload="init()">
*init:
*    function init()
*    {setCheckItem(new numberObj(document.forms[0],'id','����',false,0,100,16));
*    }
* ��SUBMITʱ���ã�
*submit:
*    function doxx()
*    {if(validForm(document.forms[0]))
*     document.forms[0].submit;
*     else alert('things go wrong!');
*    }   
*/



/*
 * ʵ��һ��������
 */
function collection()
{
	this.length = 0;
	this.add = add;
	this.get = get;
	
	function add(obj)
	{
		this[this.length ++] = obj;
	}
	function get(n)
	{
		return this[n];
	}
}

/*
 * ʵ�ּ��FORM�ڵ�
 * ��װ��һ��FORM�����е����е���ҪУ���ITEM
 * 
 */
function checkformnode(_oform)
{
	var oform = _oform;
	var ochecked = new collection();
	
	this.getform = function()//����FORM
	{
		return oform;
	}
	this.addItem = function(oitem)//����һ����ҪУ���ITEM
	{
		ochecked.add(oitem);
	}
	this.getItem = function(nindex)//�õ�����һ����У���ITEM
	{
		return ochecked.get(nindex);
	}
	this.getItemNums = function()//�������е�ITEM��
	{
		return ochecked.length;
	}
}

/*
*ȫ�ֵ�checkformnode����
*�������е�FORM�Ͷ�ӦFORM���µ���У��ؼ�
*/
var _page_check_forms = new collection();

/*
*getCheckFormItem
* ���oform�Ƿ���ȫ���������Ѿ����ڣ�oform����װ��checkformnode��
*/
function getCheckFormItem(oform)
{
	var itemform = null;
	
	for (var i = 0; i < _page_check_forms.length; i ++)
	{
		itemform = _page_check_forms.get(i);
		if (oform == itemform.getform())
			return itemform;
	}
	return null;
}
/*
*getCheckFormItemDefault
*ͨ��oform���ض�Ӧ�İ�װ�ɵ�checkformnode
*��������ھ�������ȫ��������
*/
function getCheckFormItemDefault(oform)
{
	itemform = getCheckFormItem(oform);
	if (itemform == null)
	{
		itemform = new checkformnode(oform);
		_page_check_forms.add(itemform);
	}
	return itemform;
}

/*
 * setCheckItem
 * ���ü����
 * ������oitem -- ��������
 */
function setCheckItem(oitem)
{
	var oform = oitem.getform();
	var itemform = getCheckFormItemDefault(oform);
	itemform.addItem(oitem);//��FORM�����ITEM
	oitem.init();
}

/*
 * validForm
 * У��FORM�����Ƿ�Ϸ�
 * ������oform -- FORM����
 * ����ֵ��true -- У��ͨ����false -- У��ûͨ��
 */
function validForm(oform)
{
	var itemform = getCheckFormItem(oform)
	if (itemform == null)
	{
		throw "valid item '" + oform.name + "' not found in validate chain��";
	}

	for (var i = 0; i < itemform.getItemNums(); i ++)
	{
		if (!itemform.getItem(i).validate())
			return false;
	}
	return true;
}


//========================================================================//
/*
 *������
 *       _oform -- ���ڵ�ҳ��FORM����
 *          _id -- ��Ӧ�༭���id
 *         _tip -- ��ʾ��Ϣ����
 *      _isnull -- �Ƿ����Ϊ��
 *    _minvalue -- ��Сֵ
 *    _maxvalue -- ���ֵ
 *     _maxbyte -- ����ֽ���(����)
 * ���󹫹�������
 *    getform() -- ����ȡ�ö�Ӧ��FORM����
 *       init() -- ���ڳ�ʼ��
 *   validate() -- ����У������Ϸ���
*/
function numberObj(_oform, _id, _tip, _isnull, _minvalue, _maxvalue, _maxbyte)
{
    var oform = _oform;
	var tip = _tip;
	var id = _id;
	
	var isnull = _isnull;
	var minvalue = _minvalue;
	var maxvalue = _maxvalue;
	var maxbyte = _maxbyte;
		
	var oedit = null;
	if (oform.tagName == null)				// ��idȡ�ö�Ӧ����������
		oedit = document.all(id);
	else
		oedit = oform.all(id);
    /*
	 * ȡ�ö�Ӧform
	 */
	this.getform = function()
	{
		return oform;
	}
	/*
	* ���г�ʼ��
	*/
	this.init = function()
	{
	    if(oedit == null)
		{
			return;
		}
		oedit.style.imeMode = "disabled";
		oedit.maxLength = maxbyte;   //������󳤶�
		oedit.onkeypress = function()//����ONKEYPRESS����
		{
		    var num = ( event.keyCode >= 48 && event.keyCode <= 57 );
			return num;
		}
		/*
		oedit.onblur = function()
		{
		    var obj = event.srcElement;
			var tmp = obj.value;
			if (tmp == "")
				return;
			var regex = new RegExp("^[0-9]+$", "ig");
			if (regex.test(obj.value))
			{
				obj.value = parseInt(tmp,10);
			}
		}
		*/
	}
	/*
	* ����ͨ��У��
	*/
	this.validate = function()//����ͨ��У��
	{
	    if(oedit == null)
		{
			return true;
		}
		if (oedit.disabled == true)
		{
			return true;
		}		
		oedit.value = oedit.value.trim();
		if (oedit.value == "")
		{
			if (isnull)
				return true;
			else
			{
				alert(tip + "����Ϊ�գ������롣");
				oedit.select();
				return false;
			}
		}
		var regex = new RegExp("^[0-9]+$", "ig");
		if (!regex.test(oedit.value))
		{
			alert(tip + "���벻�Ϸ������������롣");
			oedit.select();
			return false;
		}
		var val = parseInt(oedit.value,10);
		if (val < minvalue || val > maxvalue)
		{
			alert(tip + "������" + minvalue + "-" + maxvalue + "��Χ�ڣ����������롣");
			oedit.select();
			return false;
		}
		
		oedit.value = val;
		return true;
	}	
}

//�жϿؼ��Ƿ�Ϊ�ա�_ids:�ؼ�id�����á�;��������lookup�ؼ��������á�#����ʶ�����ڿؼ��á�@����ʶ,_alertNeed:�Ƿ���Ҫ��ʾ��true��ʾ��Ҫ
//���磺var ids = "product_PRODUCT_CODE;product_PRODUCT_DESC;plan_BIN_ID;plan_PRI"; //ҳ������ҪУ��Ŀؼ�id
//	   Ĭ�ϵ���ʾ���Ը��ݸÿؼ�td����һ���ֵ�td�е��������ɡ���Ҫ�Զ�����ʾ���ԣ��뽫_alertNeed����Ϊfalse
//     if(checkNull(ids,true))  //�����һ��Ϊ���򷵻أ�����ʾ�û����룬���ȫ��Ϊ�������ִ�к������
//     {
//   	   return;
//     }
function checkNull(_ids,_alertNeed)
{
	var id = _ids.split(";");
	var alertNeed = _alertNeed==null ? true : _alertNeed;
	var obj = null;
	var name = null;
	var lastChar = ""
	var focusNeed = true;
	var alertMode = 1;	//��ʾ��Ϣ�����࣬1��ʾ�������롱��2��ʾ����ѡ��
	var flag = 0;
	for(i=0;i<id.length;i++)
	{
		lastChar = id[i].charAt(id[i].length-1);
		if(lastChar == "#")
		{
			obj = document.all(id[i].substring(0,id[i].length-1));
			alertMode = 2;
		}
		else if(lastChar == "@")
		{
			obj = document.all(id[i].substring(0,id[i].length-1));
			alertMode = 2;
			focusNeed = false;
		}
		else
		{
			obj = document.all(id[i]);
		}
		if(typeof obj != 'undefined')
		{
			if(obj.value.trim()==null||obj.value.trim()=="")
			{
				if(alertNeed)
				{
					name = getChineseName(obj).trim();
					if(name == "")
					{
						name = "�ǿ��ֶ�";
					}
					if(obj.tagName == "SELECT")
					{
						alertMode = 2;
					}
					if(alertMode == 1)
					{
						alert(name+"����Ϊ�գ������롣");
					}else
					{
						alert(name+"����Ϊ�գ���ѡ��")
					}
					if(focusNeed)
					{
						obj.focus();
					}
				}
				flag = 1;
				break;
			}
		}
	}
	return flag == 1;
}

//������ݴ����б�ѡ���е�row_id
//������objName checkbox��name��������ɵ�Ĭ��nameΪ"chk"
//����ֵ����û��checkbox��ѡ�У�����0�����򷵻�һ��Array���󣬲��ҵ�ֻ��һ��checkboxѡ��ʱ��Array��lengthΪ1
	function getCheckedRowId(objName)
	{
		var objChk;
		var returnval="";
		var j=0;
		var elementLengh=getElementLen(objName);
		for(var i=0;i<elementLengh;i++)
		{
			objChk=getObj(objName,i);
			if(objChk.checked&&(!objChk.disabled))
			{
				j++;
				returnval += objChk.value;
				returnval += ";";
			}
		}
		returnval = returnval.substring(0,returnval.length-1);
		if (j>0)
			return returnval.split(";");
		else
			return 0;
	}

//	//���һ��������text���������ֵ obj:�ж���
//	//ɾ���ӱ�ʱ������commonThree.js����
//	function clearRow(obj)
//	{
//	  var row= obj;
//	  var cellchildren;
//	   for (j=0; j < row.cells.length; j++) {
//	       cellchildren = row.cells(j).children;
//		    for(m=0;m<cellchildren.length;m++)  {
//		       var child = cellchildren(m);
//		    	if (child.tagName=="INPUT") {
//		        	child.value = "";
//	       		}
//	       		if (child.tagName=="SELECT") {
//		        	child.value = "";
//	       		}
//	       	}
//	     }
//		return true;
//	}
	
	
/*
*TABLE �����һЩ���÷���
*@param:table object
*@method:getColumnSum(_index, _title)��Ҫ�ϼƵ��к��Ƿ��б����У����ڱ�������ΪTRUE�����غϼƵ�ֵ
*/
function Table(_table)
{
    var table = _table;
    var trs = table.rows;
    var len = trs.length;
    var regex = new RegExp("[^0-9.]", "ig");
    
    this.getColumnSum = function(_index , _titlt)//�ϼ�һ�е��ܺ�
    {
        var tr;
        var tds;
        var ind = _index;
        var total = 0;
        var i = 0;
        _titlt==true?i=1:i=0;
        for(var i;i<len;i++)
        {
            tr = trs[i];
            tds = tr.cells;
            
            
            if(tds[ind].firstChild.type == 'text')
            {
                if(!regex.test(tds[ind].firstChild.value)&&tds[ind].firstChild.value!='')//������
                {
                    total+=parseFloat(tds[ind].firstChild.value);
                }             
            }
            else
            {
                if(!regex.test(tds[ind].innerText.value)&&tds[ind].innerText.value!='')
                {
                    total+=parseFloat(tds[ind].innerText.value);
                }                
            }
        }
        return total;
    }
}


/**
 * ������:sumData
 * ����:obj Ҫ���ܵı�������;prefix ǰ׺: Ҫ�����е�������ǰ׺;sumColName �����е�����;setColName ��Ż���ֵ������;nDec ����ֵ�ľ���
 * ����ֵ:��
 * ����˵��:����ָ������е�ָ��sumColName��ֵ��setColName
 * ����ʾ������:sumData("dataTable","orderDetail","quantOrder","totQuantOrder",0)
 * add by di.zhou 
 * mail:zhoudi@neusoft.com
 */
function sumData(obj,prefix,sumColName,setColName,nDec)
{
   var colname ="";
   var nRow;		// Various table stats
   var table;
   var col;				// Table object
   var sumValue = 0;
   var colValue = 0;
	if (obj  != "")
	{
		table = eval(obj);  // Assumes that the obj is THE OBJECT
	}
	if (table == null) return;  // Check whether it's an object
	if (table.tagName != "TABLE") return;  // Check whether it's a table
	nRow = table.rows.length;// Setting the number of rows
	if (nRow < 1) return;// Should have at least 1 row
	// Loop through rows
//	if(Num!=""&&Num!=null)nRow=nRow-(1+Num);
//		else nRow=nRow-1;
	for (var i=0; i<nRow-1; i++)
	{
      if(prefix!="")
      {
        colname = prefix+"[" + i + "]." + sumColName;
      }
      col = document.getElementById(colname);
      if(typeof col == 'undefined')
      {
      	continue;
      }
      colValue = col.value; 
      if (checkNumber(colValue))
        {
          if (colValue == "") { colValue =0;}
         // sumValue = parseFloat(sumValue) + parseFloat(colValue);
		  sumValue = dcmAdd(parseFloat(sumValue),parseFloat(colValue));
         }
      else
      	{
          sumValue = -1;
          break;
        }
    }
   document.getElementById(setColName).value =  FormatNumber(parseFloat(sumValue),nDec);
}
/*
 * ��������getProductQuantity
 * ����:product_id ��Ʒ����;unit ��λ; ctx ��·��
 * ����ֵ��({"QUANTITY":"200"}) ����λ��Ӧ��֧��
 * ����ʾ�����£�getProductQuantity("1111","��")
 * add by di.zhou
 * 
 */
function getProductQuantity(product_id,unit)
{
    xmlHttp=GetXmlHttpObject();
    var act_url = _sys_ctx + "/systemDictionary.do?method=doGetProductPackage";
    var params = "PRODUCT_ID="+product_id+"&UNIT="+unit;
    xmlHttp.open("POST",act_url,false);
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	xmlHttp.onreadystatechange=stateChanged;	
    xmlHttp.send(URLEncoding(params));
	if(xmlHttp.readyState==4&&xmlHttp.status==200)
	{
	   var result = xmlHttp.responseText;
	   return result;
	}
}

//�жϵ���״̬����Ҫ����ѡ��һ�����ݣ��ж���״̬�Ƿ��������
//������_tableName: ���ݵ���������_statusSet: ״̬�ļ��ϣ�����('2','3')��_recordValue��Ҫ����¼��row_id�Ĵ�����"��"������_statusCol��Ҫ�жϵ�״̬������
//����ֵ�����õ��ݵ�״̬������������ʱ������true�����򷵻�false
function checkStatus(_tableName,_statusSet,_recordValue,_statusCol)
{
	var recordValue = _recordValue==null?getCheckedRowId("chk"):_recordValue.split(";");
	var statusCol = _statusCol==null?"status":_statusCol;
	var sql = "select row_id from " + _tableName + " where "+ statusCol + " in " + _statusSet + " and row_id in (";
	if(recordValue.length>1)
	{
		for(var i=0;i<recordValue.length;i++)
		{
			sql += recordValue[i]+",";
		}
		sql = sql.substring(0,sql.length-1)+")";
	}else
	{
		if(recordValue!=0)
		{
			sql += recordValue+")";
		}
	}
	return isUnique(sql)==0;
}
//==========================================================================//
/*
*��������  doubleFormat
*������    value:��Ҫ��ʽ����DOUBLE��
*����ֵ��  ��ʽ����ȥ�����з���Ч���ֺ�С�������Ч��Ϊ���λ
*ע�⣺
*ʾ����    var a = 3.1415000000
*        var b = doubleFormat(a);
*        alert(b);
*/
    function doubleFormat(value)
	{
		    if(value.indexOf('0E-') != -1 || value == 0)
		    {
		    	 return '0';
		    }
		    var value = recurse(value);
		    if(value.lastIndexOf('.') + 1 == value.length)
		    {		    
		    	return value.substring(0, value.length -1);
		    }
		    else
		    {
		    	return value;
		    }		    			 
	}
	function recurse(value)
	{
		if(value.length > 0 && value.lastIndexOf('0')+1 == value.length)
		{
			return recurse(value.substring(0,value.length-1));
		}
		else
			{
				return value;
			}
	}
//=============================================================================//

//���ҳ��Input��ǩ�е�ֵ
function allInClean(){
	var inputCol = document.all.tags("input");
	var textareaCol = document.all.tags("textarea");
	var selectCol = document.all.tags("select");
	var result = new RegExp("date","ig");
	for(var i=0;i<inputCol.length;i++){
		if(inputCol[i].type!="button")
		{
			var re = result.exec(inputCol[i].name);
			if(null==re&&inputCol[i].type!="hidden")
				inputCol[i].value="";
		}
			
	}
	for(var i=0;i<textareaCol.length;i++){
		textareaCol[i].value="";
	}
	
	for(var i=0;i<selectCol.length;i++){
		selectCol[i].disabled=false;
	}
	
}


/**
 * sumDataByColNum("maintbl",1,0,3,"GPICK_TOTAL_QTY_SHOW",2);
 * 
 * @param {Object} tableName ����
 * @param {Object} bStartRow ���㿪ʼ��
 * @param {Object} bEndRow   ĩβ����������
 * @param {Object} colNum   �����
 * @param {Object} sumName ����
 * @param {Object} nDec С��λ
 * add by di.zhou
 */
function sumDataByColNum(tableName,bStartRow,bEndRow,colNum,sumName,nDec){
	var table = eval(tableName);
	var rows = table.rows.length;
	var sumValue = 0;
	
	for(var i=bStartRow;i<rows-bEndRow;i++){
	 // sumValue = parseFloat(sumValue) + parseFloat(table.rows[i].childNodes[colNum].innerText);
	sumValue = dcmAdd(parseFloat(sumValue),parseFloat(table.rows[i].childNodes[colNum].innerText));
	}
	
	document.all(sumName).innerText = FormatNumber(parseFloat(sumValue),nDec);
		
}

//���õ�ǰ����
//mail: zhoudi@neusoft.com
function curDateInSet(name){
	var currentDate = new Date();
	var dateString = currentDate.getYear()+'-'+(parseInt(currentDate.getMonth())+1)+'-'+currentDate.getDate();
	document.all(name).value = dateString;	
	
}


function selectFirst(_id){
	var doWhat = document.all("doWhat").value;
	var IDs = _id.split(";");
	
		for(var i=0;i<IDs.length;i++){
			var select = document.all(IDs[i]);
			select.value = select.childNodes[1].value
		}
	
}

/**
* TIME�ؼ�
*
*/
function TimeObj(_oform, _id, _tip, _isnull )
{
	/* �����˽������ */
	var oform   = _oform;
	var tip     = _tip;
	var id      = _id;	
	var isnull  = _isnull;

	var maxbyte = 8;
	var splitchar = ":";
	var splitcharcode = splitchar.charCodeAt(0);
	
	var oedit = null;
	if (oform.tagName == null)				// ��idȡ�ö�Ӧ����������
		oedit = document.all(id);
	else
		oedit = oform.all(id);
		
	/*
	 * ȡ�ö�Ӧform
	 */
	this.getform = function()
	{
		return oform;
	}

	/*
	 * �����ʼ��
	 */
	this.init = function()
	{
		if(oedit == null)
		{
			return;
		}
		oedit.maxLength = maxbyte;
		oedit.style.imeMode = "disabled";
		oedit.onpaste = function()
		{
			return false;
		}
		oedit.ondrop = function()
		{
			return false;
		}
		
		oedit.onkeypress = function()
		{
			var objTime = oedit;
			var existstr = objTime.value;                      //�Ѿ�������ַ���			
			var curInput = String.fromCharCode(event.keyCode); //��ǰ������ַ�
						
			if (((event.keyCode < 48 || event.keyCode > 57) && event.keyCode != splitcharcode )
				|| (event.keyCode == splitcharcode && existstr.charCodeAt(existstr.length-1) == splitcharcode))
			{
				event.returnValue = false;
				return;	
			}			
			existstr += curInput;
			
			//���ֻ����������":"
			var aryTime = existstr.split(splitchar);
			if(aryTime.length > 3)
			{
				event.returnValue = false;
				return;
			}
			
			//hh,mm��2λ�Զ�¼��":"
			if (existstr.indexOf(splitchar) < 0 && existstr.length == 2)
			{
				objTime.value += (curInput + splitchar);
				event.returnValue = false;
				return;
			}
			else if (existstr.length > 2)
			{
				i = aryTime.length - 1;
				if (aryTime[i]!="" && aryTime[i].length==2 && i<2)	
				{
					objTime.value += (curInput + splitchar);
					event.returnValue = false;	
				}
			}
		}
		
		oedit.onkeyup = function()
		{
			var objTime = event.srcElement;
			if (objTime.value == "")
				return;
			var aryTime = objTime.value.split(splitchar);
			var errFlag = false;
			if (aryTime.length < 1)
				return;
			var hh = parseInt(aryTime[0],10);			
			if (hh > 23 || hh < 0)
			{
				errFlag = true;
				aryTime[0] = "00";
			}
			if (aryTime.length > 1)
			{
				var mm = parseInt(aryTime[1],10);
				if (mm < 0 || mm >59)
				{
					errFlag = true;
					aryTime[1] = "00";	
				}
				if (aryTime.length > 2)
				{
					var ss = parseInt(aryTime[2],10);
					if (ss < 0 || ss >59)
					{
						errFlag = true;
						aryTime[2] = "00";	
					}	
				}	
			}
			if (errFlag)
			{
				objTime.value = aryTime[0];
				for (i=1; i<aryTime.length; ++i)
					objTime.value += (splitchar + aryTime[i]);	
			}				
		}
		/*
		oedit.onblur = function()
		{
			var objTime = event.srcElement;
			if (objTime.value == "")
				return;
			objTime.value = formFullTime(objTime.value);
		}
		*/
	}
	
	/*
	 * ����У������Ϸ���
	 */
	this.validate = function()
	{
		if(oedit == null)
		{
			return true;
		}
		if (oedit.disabled == true)
		{
			return true;
		}
		oedit.value = oedit.value.trim();
				
		if(oedit.value == "")
		{
			if(isnull)
				return true;
			else
			{
				alert(tip + "����Ϊ�գ������롣");
				oedit.select();
				return false;
			}
		}
		
		var regex = /^\d{1,2}\:\d{1,2}\:\d{1,2}$/ig;
		if ( oedit.value.match(regex) == null )
		{
			alert(tip + "��ʽ���Ϸ������������롣");
			oedit.value = "";
			oedit.select();
			return false;	
		}		
		return true;
	}
	
	/*�Զ��ԡ�0����Сʱ�����ӣ���*/
	function formFullTime(vtime)
	{
		var aryTime = vtime.split(splitchar);
		for (var i=0; i<aryTime.length; ++i)
		{
			if (!/^\d+$/g.test(aryTime[i]))
			{
				if (aryTime[i] == "")
					aryTime[i] = "0";
				else return vtime;
			}
		}
		
		var hh = (aryTime.length > 0 && aryTime[0] != "" ? parseInt(aryTime[0],10) : 0);
		var mm = (aryTime.length > 1 && aryTime[1] != "" ? parseInt(aryTime[1],10) : 0);
		var ss = (aryTime.length > 2 && aryTime[2] != "" ? parseInt(aryTime[2],10) : 0);
		
		if (hh<0 || hh>23)
			hh = "00";
		else if (hh<10)
		{
			hh = "0" + hh;
		}
		var str = hh + splitchar;
		if (mm<0 || mm>59)
			mm = "00";
		else if (mm < 10)
		{
			mm = "0" + mm;
		}
		str += (mm + splitchar);
		if (ss<0 || ss>59)
			ss = "00";
		else if (ss < 10)
		{
			ss = "0" + ss;
		}				
		str += ss;
		
		return str;			
	}	
}
//��̬����select������
//������_this:�������this; sql:��Ҫ�б��������ұ�����CODE��NAME
function createSelectDynamic(_this,sql)
{
	while(_this.length!=0)
	{
		if(_this.hasChildNodes())
		{
			_this.removeChild(_this.lastChild);
		}
	}
	var jsonData = getJsonData(sql);
	if(typeof jsonData == 'undefined'|| ""==jsonData)
	{
		_this.add(new Option("--û�м�¼--","",true));
	}else
	{
		var jsonObj = eval(jsonData);
		_this.add(new Option("--��ѡ��--","",true));
		for(var i=0;i<jsonObj.length;i++)
		{
			_this.add(new Option(jsonObj[i].NAME,jsonObj[i].CODE));
		}
	}
}
//У��ʱ���Ƿ�Ϸ�
//����  _obj��У�����_timeType��HH:MM:SS(Ĭ��)��HH:MM
function checkTime(_obj,_timeType){
        var timeType = _timeType == null ? "HH:MM:SS" : _timeType;
        var timeObj = _obj == null ? this : _obj;
        var checkStr = timeType == "HH:MM:SS" ? timeObj.value : timeObj.value+":00";
        var checkStrArray = checkStr.split(':');
        var numberOnlyStr = "0123456789";
        
      	var hour,minute,second;
      	

        if(!(timeObj.value == null || timeObj.value=="" )){
	        for(var i=0;i<checkStrArray.length;i++)
	        {
	        	for(var j=0;j<checkStrArray[i].length;j++)
	        	{
		        	if(numberOnlyStr.indexOf(checkStrArray[i].charAt(j))<0)
		        	{
		        		alert("�����ʱ���ʽ���Ϸ���ʱ�������ȫ����������ɡ�");
		        		timeObj.value="";
		                timeObj.focus();
		        		return false;
		        	}
	        	}
	        }
	        hour = parseInt(checkStrArray[0],10);
	        minute = parseInt(checkStrArray[1],10);
	        if(hour>=0&&hour<=9&&checkStrArray[0].length==1)
	        {
	        	checkStr = "0"+checkStr;
	        }
          	if(checkStr.length == 8 && checkStr.charAt(2) == ":" && checkStr.charAt(5) == ":"){
          		
				second = parseInt(checkStr.split(':')[2],10);
                if(!(hour >= 0 && hour <= 23)){
                   	alert("�����ʱ���ʽ���Ϸ���Ҫ��Сʱ��00-23֮�䣡");
                   	timeObj.value="";
                   	timeObj.focus();
                  	return false;
  	            }
                if(!(minute >= 0 && minute <= 59)){
                   	alert("�����ʱ���ʽ���Ϸ���Ҫ�������00-59֮�䣡");
                   	timeObj.value="";
                   	timeObj.focus();
                   	return false;
                }
                if(!(second >= 0 && second <= 59)){
                	alert("�����ʱ���ʽ���Ϸ���Ҫ������00-59֮�䣡");
                   	timeObj.value="";
                   	timeObj.focus();
                	return false;
                }
          	}
           	else{
              	alert("�����ʱ���ʽ���Ϸ����Ϸ���ʽΪ"+timeType);
               	timeObj.value="";
               	timeObj.focus();
                return false;
           	}
        }
        return true;
}

/**
*�õ�ĳ��ĳ�µ�����
*@param:year ���
*@param:month ����
*@result:����
*@author:����
*/
function getDaysInMonth(year,month)
{
    var flag = false;
	var result = 0;
    if(parseInt(year)%4 == 0)
	{
	    flag = true;
	}
	switch(parseInt(month))
	{
	    case 1: result = 31;break;
		case 2: if(flag){result = 29;}else{result = 28;}break;
		case 3: result = 31; break;
		case 4: result = 30; break;
		case 5: result = 31; break;
		case 6: result = 30; break;
		case 7: result = 31; break;
		case 8: result = 31; break;
		case 9: result = 30; break;
		case 10: result = 31; break;
		case 11: result = 30; break;
		case 12: result = 31; break;
		default: result = 0;
	}
	return result;
}

/***
 * 
 * @param {Object} tableID ����
 * @param {Object} detailFormName �ӱ�form����
 * @param {Object} colNames ͬʱ����Ϊ�յ�����,��֮����;����
 * ���ӣ�detailIsNull("dataTable1","detailForm_InlistDetail","PDT_PRODUCT_CODE;MVD_QTY_U")
 */
function detailIsNull(tableID,detailFormName,colNames)
{
	var table = document.all(tableID);
	var colName = colNames.split(";");
	
	for(var i=0;i<table.rows.length-1;i++)
	{
		var result = true;
		for(var n=0;n<colName.length;n++){
		
			result &= document.all(detailFormName+"["+i+"]."+colName[n]).value!=null&&document.all(detailFormName+"["+i+"]."+colName[n]).value!=""&&doubleFormat(document.all(detailFormName+"["+i+"]."+colName[n]).value)!=0;
		
		}
		if(result)return false;
		
		
	}
	alert("�ӱ�������һ��������������Ϊ�㣡");
	return 	true;
}
/*
	���Ψһ��У�����ʾ��Ϣ��Ŀ����Ϊ��ϵͳ��ʾ��Ϣͳһ
*/
function getUniqueAlertMsg(_name)
{
	return (_name==null?"":_name)+"�����ظ������������롣"
}

/*
	ȥ������������ĩβ�� 0 
*/
function toFixedNumber (num)
{
	var result = num.toString ();
	
	if (result.match(/\d+\.\d+[1-9]0+$/g)) //ȷ���Ǹ�������
		return result;
	else return result.replace(/0+$|\.0+$/g, '');
}


function dateValidate(date_from, date_to)
{
    var yearfrom = parseInt(date_from.substring(0,date_from.indexOf('-')));
    var subfrom1 = date_from.substring(date_from.indexOf('-')+1);
    var monthfrom = parseInt(subfrom1.substring(0,subfrom1.indexOf('-')));
    var subfrom2 = subfrom1.substring(subfrom1.indexOf('-')+1);
    var dayfrom = parseInt(subfrom2.trim());

    var yearto = parseInt(date_to.substring(0,date_to.indexOf('-')));
    var subto1 = date_to.substring(date_to.indexOf('-')+1);
    var monthto = parseInt(subto1.substring(0,subto1.indexOf('-')));
    var subto2 = subto1.substring(subto1.indexOf('-')+1);
    var dayto = parseInt(subto2.trim());
    

    if(yearfrom - yearto > 0)
    {
        return false;
    }
    else if(yearfrom - yearto < 0)
    {
        return true;
    }
    else if(yearfrom == yearto)
    {
        if(monthfrom > monthto)
        {
            return false;
        }
        else if(monthfrom < monthto)
        {
            return true;
        }
        else 
        {
            if(dayfrom > dayto)
            {
                return false;
            }
            else
            {
                return true;
            }      
        }
    }
}

//��һ��ģ̬���ڣ�û��״̬����û�а�����ť��û�й�����
function openNoBarDlg(loc,width,height)
{
	return showModalDialog(loc,window,"scroll:no;status:no;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:yes;dialogWidth:"+width+"px;dialogHeight:"+height+"px");
}

 //���������
 function dcmAdd(arg1,arg2){
     var r1,r2,m;
     try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
     try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
     m=Math.pow(10,Math.max(r1,r2));
     return (dcmMul(arg1,m)+dcmMul(arg2,m))/m;
 }
 //���������
 function dcmSbt(arg1,arg2){
      return dcmAdd(arg1,-arg2);
 }

 //���������
 function dcmMul(arg1,arg2){
     var m=0,s1=arg1.toString(),s2=arg2.toString();
     try{m+=s1.split(".")[1].length}catch(e){}
     try{m+=s2.split(".")[1].length}catch(e){}
     return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
 }

 //��������
 function dcmDiv(arg1,arg2){
     return dcmMul(arg1,1/arg2);
 }