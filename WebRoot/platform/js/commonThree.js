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
方法名：proxyRequest
参数：action 要执行的ACTION的PATH
     method ACTION中的方法
     params 参数
返回值：从后台拼写的响应函数
调用示例：var response = proxyRequest(document.forms[0].action,'doAdd',"arg="+arg)
 */
    function proxyRequest(action,method,params)
	{
		xmlHttp=GetXmlHttpObject();
		var act_url = action;
		if(method != null && method != ""){
	        act_url += "?method=" + method;
	    }
	    xmlHttp.open("POST",act_url,false);
	    //这句必须
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
方法名：isUnique
参数：sql 要执行的SQL语句
返回值：1：返回的结果集无数据 0：返回的结果集有数据
调用示例：var response = isUnique('select * from dual');
 */
	function isUnique(sql)
	{
	    xmlHttp=GetXmlHttpObject();
		var act_url = "../../../isUnique.do?method=isUnique";
		var params = "sql="+sql;
	    xmlHttp.open("POST",act_url,false);
	    //这句必须
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
方法名：isUnique
参数：sql 要执行的SQL语句
返回值：1：返回的结果集无数据 0：返回的结果集有数据
调用示例：var response = isUnique('select * from dual');
 */
	function isUnique2(sql,ctx)
	{
	    xmlHttp=GetXmlHttpObject();
		var act_url = ctx+"/isUnique.do?method=isUnique";
		var params = "sql="+sql;
	    xmlHttp.open("POST",act_url,false);
	    //这句必须
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
*方法名：getJsonData
*参数：sql 要执行的SQL语句
*返回值 JSON字符串
*注意：请在SQL中指定别名
*/
function getJsonData(sql)
{  
	xmlHttp=GetXmlHttpObject();
    var act_url = "../../../isUnique.do?method=getSimpleJsonData";
	var params = "sql="+sql;
	xmlHttp.open("POST",act_url,false);
	//这句必须
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
*方法名：getJsonData
*参数：sql 要执行的SQL语句
*返回值 JSON字符串
*注意：请在SQL中指定别名
*/
function getJsonData2(sql, ctx)
{  
	xmlHttp=GetXmlHttpObject();
    var act_url = ctx+"/isUnique.do?method=getSimpleJsonData";
	var params = "sql="+sql;
	xmlHttp.open("POST",act_url,false);
	//这句必须
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
*方法名：getNestedJsonData
*参数：main_table:主表表名
      main_condition：主表条件
      flag:true为取主从表数据，false为取单表数据
      sub_table：从表表名
      sub_condition：从表条件
*返回值 JSON字符串
*注意：请在SQL中指定别名
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


//得到字串的字节数	 
String.prototype.lenb = function()
{
	return this.replace(/[^\x00-\xff]/g,"**").length;
}
//去掉前后空白    
String.prototype.trim = function()
{
    return this.replace(/(^[\s]*)|([\s]*$)/g, "");
}
//去掉FORM中所有文本域的前后空白
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

//===========================通用校验链========================================//
/*
*示例：在BODY中加上INIT方法
*<body onload="init()">
*init:
*    function init()
*    {setCheckItem(new numberObj(document.forms[0],'id','代号',false,0,100,16));
*    }
* 在SUBMIT时调用：
*submit:
*    function doxx()
*    {if(validForm(document.forms[0]))
*     document.forms[0].submit;
*     else alert('things go wrong!');
*    }   
*/



/*
 * 实现一个集合类
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
 * 实现检查FORM节点
 * 封装了一个FORM和其中的所有的需要校验的ITEM
 * 
 */
function checkformnode(_oform)
{
	var oform = _oform;
	var ochecked = new collection();
	
	this.getform = function()//返回FORM
	{
		return oform;
	}
	this.addItem = function(oitem)//增加一个需要校验的ITEM
	{
		ochecked.add(oitem);
	}
	this.getItem = function(nindex)//得到其中一个需校验的ITEM
	{
		return ochecked.get(nindex);
	}
	this.getItemNums = function()//返回其中的ITEM数
	{
		return ochecked.length;
	}
}

/*
*全局的checkformnode数组
*包括所有的FORM和对应FORM底下的需校验控件
*/
var _page_check_forms = new collection();

/*
*getCheckFormItem
* 检查oform是否在全局数组中已经存在（oform被包装成checkformnode）
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
*通过oform返回对应的包装成的checkformnode
*如果不存在就新增到全局数组中
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
 * 设置检查项
 * 参数：oitem -- 检查项对象
 */
function setCheckItem(oitem)
{
	var oform = oitem.getform();
	var itemform = getCheckFormItemDefault(oform);
	itemform.addItem(oitem);//在FORM中添加ITEM
	oitem.init();
}

/*
 * validForm
 * 校验FORM输入是否合法
 * 参数：oform -- FORM对象
 * 返回值：true -- 校验通过；false -- 校验没通过
 */
function validForm(oform)
{
	var itemform = getCheckFormItem(oform)
	if (itemform == null)
	{
		throw "valid item '" + oform.name + "' not found in validate chain。";
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
 *参数：
 *       _oform -- 所在的页面FORM对象
 *          _id -- 对应编辑框的id
 *         _tip -- 提示信息名称
 *      _isnull -- 是否可以为空
 *    _minvalue -- 最小值
 *    _maxvalue -- 最大值
 *     _maxbyte -- 最大字节数(长度)
 * 对象公共方法：
 *    getform() -- 用于取得对应的FORM对象
 *       init() -- 用于初始化
 *   validate() -- 用于校验输入合法性
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
	if (oform.tagName == null)				// 由id取得对应的输入框对象
		oedit = document.all(id);
	else
		oedit = oform.all(id);
    /*
	 * 取得对应form
	 */
	this.getform = function()
	{
		return oform;
	}
	/*
	* 进行初始化
	*/
	this.init = function()
	{
	    if(oedit == null)
		{
			return;
		}
		oedit.style.imeMode = "disabled";
		oedit.maxLength = maxbyte;   //设置最大长度
		oedit.onkeypress = function()//设置ONKEYPRESS动作
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
	* 进行通用校验
	*/
	this.validate = function()//进行通用校验
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
				alert(tip + "不能为空，请输入。");
				oedit.select();
				return false;
			}
		}
		var regex = new RegExp("^[0-9]+$", "ig");
		if (!regex.test(oedit.value))
		{
			alert(tip + "输入不合法，请重新输入。");
			oedit.select();
			return false;
		}
		var val = parseInt(oedit.value,10);
		if (val < minvalue || val > maxvalue)
		{
			alert(tip + "必须在" + minvalue + "-" + maxvalue + "范围内，请重新输入。");
			oedit.select();
			return false;
		}
		
		oedit.value = val;
		return true;
	}	
}

//判断控件是否为空。_ids:控件id串，用“;”隔开，lookup控件名后面用“#”标识，日期控件用“@”标识,_alertNeed:是否需要提示，true表示需要
//例如：var ids = "product_PRODUCT_CODE;product_PRODUCT_DESC;plan_BIN_ID;plan_PRI"; //页面上需要校验的控件id
//	   默认的提示语言根据该控件td的上一个兄弟td中的内容生成。若要自定义提示语言，请将_alertNeed设置为false
//     if(checkNull(ids,true))  //如果有一个为空则返回，并提示用户输入，如果全不为空则继续执行后续语句
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
	var alertMode = 1;	//提示信息的种类，1提示“请输入”，2提示“请选择”
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
						name = "非空字段";
					}
					if(obj.tagName == "SELECT")
					{
						alertMode = 2;
					}
					if(alertMode == 1)
					{
						alert(name+"不能为空，请输入。");
					}else
					{
						alert(name+"不能为空，请选择。")
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

//获得数据窗口中被选中行的row_id
//参数：objName checkbox的name，框架生成的默认name为"chk"
//返回值：当没有checkbox被选中，返回0；否则返回一个Array对象，并且当只有一个checkbox选中时该Array的length为1
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

//	//清除一行中所有text和下拉框的值 obj:行对象
//	//删除从表时，引入commonThree.js即可
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
*TABLE 对象的一些公用方法
*@param:table object
*@method:getColumnSum(_index, _title)需要合计的列和是否有标题行（存在标题行则为TRUE）返回合计的值
*/
function Table(_table)
{
    var table = _table;
    var trs = table.rows;
    var len = trs.length;
    var regex = new RegExp("[^0-9.]", "ig");
    
    this.getColumnSum = function(_index , _titlt)//合计一列的总和
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
                if(!regex.test(tds[ind].firstChild.value)&&tds[ind].firstChild.value!='')//是数字
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
 * 方法名:sumData
 * 参数:obj 要汇总的表格的名字;prefix 前缀: 要汇总列的列名的前缀;sumColName 汇总列的列名;setColName 存放汇总值的列名;nDec 汇总值的精度
 * 返回值:无
 * 方法说明:汇总指定表格中的指定sumColName的值到setColName
 * 调用示例如下:sumData("dataTable","orderDetail","quantOrder","totQuantOrder",0)
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
 * 方法名：getProductQuantity
 * 参数:product_id 商品代码;unit 单位; ctx 根路径
 * 返回值：({"QUANTITY":"200"}) ，单位对应的支数
 * 调用示例如下：getProductQuantity("1111","条")
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

//判断单据状态，主要用于选中一条单据，判断其状态是否符合条件
//参数：_tableName: 单据的主表名；_statusSet: 状态的集合，形如('2','3')；_recordValue：要检查记录的row_id的串，用"，"隔开；_statusCol：要判断的状态的列名
//返回值：当该单据的状态符合输入条件时，返回true；否则返回false
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
*方法名：  doubleFormat
*参数：    value:需要格式化的DOUBLE串
*返回值：  格式化成去掉所有非有效数字和小数点后无效的为零的位
*注意：
*示例：    var a = 3.1415000000
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

//清空页面Input标签中的值
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
 * @param {Object} tableName 表名
 * @param {Object} bStartRow 计算开始行
 * @param {Object} bEndRow   末尾不计算行数
 * @param {Object} colNum   列序号
 * @param {Object} sumName 汇总
 * @param {Object} nDec 小树位
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

//设置当前日期
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
* TIME控件
*
*/
function TimeObj(_oform, _id, _tip, _isnull )
{
	/* 必须的私有属性 */
	var oform   = _oform;
	var tip     = _tip;
	var id      = _id;	
	var isnull  = _isnull;

	var maxbyte = 8;
	var splitchar = ":";
	var splitcharcode = splitchar.charCodeAt(0);
	
	var oedit = null;
	if (oform.tagName == null)				// 由id取得对应的输入框对象
		oedit = document.all(id);
	else
		oedit = oform.all(id);
		
	/*
	 * 取得对应form
	 */
	this.getform = function()
	{
		return oform;
	}

	/*
	 * 对象初始化
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
			var existstr = objTime.value;                      //已经输入的字符串			
			var curInput = String.fromCharCode(event.keyCode); //当前输入的字符
						
			if (((event.keyCode < 48 || event.keyCode > 57) && event.keyCode != splitcharcode )
				|| (event.keyCode == splitcharcode && existstr.charCodeAt(existstr.length-1) == splitcharcode))
			{
				event.returnValue = false;
				return;	
			}			
			existstr += curInput;
			
			//最多只可以有两个":"
			var aryTime = existstr.split(splitchar);
			if(aryTime.length > 3)
			{
				event.returnValue = false;
				return;
			}
			
			//hh,mm满2位自动录入":"
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
	 * 进行校验输入合法性
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
				alert(tip + "不能为空，请输入。");
				oedit.select();
				return false;
			}
		}
		
		var regex = /^\d{1,2}\:\d{1,2}\:\d{1,2}$/ig;
		if ( oedit.value.match(regex) == null )
		{
			alert(tip + "格式不合法，请重新输入。");
			oedit.value = "";
			oedit.select();
			return false;	
		}		
		return true;
	}
	
	/*自动以“0”补小时，分钟，秒*/
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
//动态生成select下拉框
//参数：_this:下拉框的this; sql:需要有别名，而且必须是CODE和NAME
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
		_this.add(new Option("--没有记录--","",true));
	}else
	{
		var jsonObj = eval(jsonData);
		_this.add(new Option("--请选择--","",true));
		for(var i=0;i<jsonObj.length;i++)
		{
			_this.add(new Option(jsonObj[i].NAME,jsonObj[i].CODE));
		}
	}
}
//校验时间是否合法
//参数  _obj：校验对象；_timeType：HH:MM:SS(默认)或HH:MM
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
		        		alert("输入的时间格式不合法，时分秒必须全部由数字组成。");
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
                   	alert("输入的时间格式不合法，要求小时在00-23之间！");
                   	timeObj.value="";
                   	timeObj.focus();
                  	return false;
  	            }
                if(!(minute >= 0 && minute <= 59)){
                   	alert("输入的时间格式不合法，要求分钟在00-59之间！");
                   	timeObj.value="";
                   	timeObj.focus();
                   	return false;
                }
                if(!(second >= 0 && second <= 59)){
                	alert("输入的时间格式不合法，要求秒在00-59之间！");
                   	timeObj.value="";
                   	timeObj.focus();
                	return false;
                }
          	}
           	else{
              	alert("输入的时间格式不合法，合法格式为"+timeType);
               	timeObj.value="";
               	timeObj.focus();
                return false;
           	}
        }
        return true;
}

/**
*得到某年某月的月数
*@param:year 年份
*@param:month 月数
*@result:天数
*@author:秦涛
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
 * @param {Object} tableID 表名
 * @param {Object} detailFormName 从表form名称
 * @param {Object} colNames 同时不能为空的列名,列之间用;隔开
 * 例子：detailIsNull("dataTable1","detailForm_InlistDetail","PDT_PRODUCT_CODE;MVD_QTY_U")
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
	alert("从表至少有一条数据且量不能为零！");
	return 	true;
}
/*
	获得唯一性校验的提示信息，目的是为了系统提示信息统一
*/
function getUniqueAlertMsg(_name)
{
	return (_name==null?"":_name)+"不能重复，请重新输入。"
}

/*
	去掉浮点数数的末尾的 0 
*/
function toFixedNumber (num)
{
	var result = num.toString ();
	
	if (result.match(/\d+\.\d+[1-9]0+$/g)) //确定是个浮点数
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

//打开一个模态窗口，没有状态栏，没有帮助按钮，没有滚动条
function openNoBarDlg(loc,width,height)
{
	return showModalDialog(loc,window,"scroll:no;status:no;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:yes;dialogWidth:"+width+"px;dialogHeight:"+height+"px");
}

 //浮点数相加
 function dcmAdd(arg1,arg2){
     var r1,r2,m;
     try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
     try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
     m=Math.pow(10,Math.max(r1,r2));
     return (dcmMul(arg1,m)+dcmMul(arg2,m))/m;
 }
 //浮点数相减
 function dcmSbt(arg1,arg2){
      return dcmAdd(arg1,-arg2);
 }

 //浮点数相乘
 function dcmMul(arg1,arg2){
     var m=0,s1=arg1.toString(),s2=arg2.toString();
     try{m+=s1.split(".")[1].length}catch(e){}
     try{m+=s2.split(".")[1].length}catch(e){}
     return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
 }

 //浮点数除
 function dcmDiv(arg1,arg2){
     return dcmMul(arg1,1/arg2);
 }