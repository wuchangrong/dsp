/**---------------------------全局常量定义开始-----------------------------------*/

/**
 * 常量名:行高亮显示背景颜色
 * 常量说明:当用鼠标双击选中GRID表格的行时,行呈现出高亮显示的背景颜色.
 */
var VAR_HighLightColor = "#00bfff";

/**
 * 常量名:Grid是编辑模式时的行分割符
 * 常量说明:Grid是可编辑时,提交时需要将GRID中的行数据进行,拼成字符串,此常量用于定义,行拼接时的分割符
 */
var ROW_SPLIT_FLAG = "\"\\;";

/**
 * 常量名:Grid是编辑模式时的列分割符
 * 常量说明:Grid是可编辑时,提交时需要将GRID中的列数据进行,拼成字符串,此常量用于定义,列拼接时的分割符.
 */
var COL_SPLIT_FLAG = "\"\\,";

/**
 * 常量名:定义XMLHTTP对象
 * 常量说明:定义全局xmlhttp对象,在所有共通的JS中可以调用.
 */
function getXmlHttp()
{
    var xmlHttpObj;
    try
    {
        xmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch(e)
    {
        try
        {
            xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch(e)
        {
            try
            {
               xmlHttpObj = window.XMLHttpRequest();
            }
            catch(e)
            {
            }
         }
     }
     return xmlHttpObj;
}
var xmlhttp = getXmlHttp();
/**
 * 常量名:等号替换符号
 * 常量说明:在执行更新操作SQL函数,用于替换SQL中的=号
 */
var EQUAL_FLAG = "<equal>";

/**
 * 常量名:分割符控件标志位避免循环调用
 * 常量说明:在带分割符控件中,避免循环调用的标志位
 */
var spoint = "true";

/**
 * 方法名:dateCompare
 * 参数:date1 起始日期;date2 截止日期;msg 要提示的字符串信息
 * 返回值:true or false
 * 方法说明:校验两个日期或时间比较,要求第一个日期或时间要小于第二个日期或时间.
 * 调用示例如下:dateCompare("2004-12-08","2004-10-10"," 起始日期要小于截止日期")
 */
function dateCompare(date1,date2,msg)
{
  	if(date1 != "" && date2 != ""){
  		if(date1 > date2){
            alert(msg);
       	    return false;
  		}
      	else{
            return true;
      	}
  	}
    else{
      return true;
    }
}

/**
 * 方法名:checkNumberPlus
 * 参数:str 要校检的字符串
 * 返回值:true or false
 * 方法说明:校检字符串,是不是全部是由数字组成
 * 调用示例如下:checkNumberPlus("232323")
 */
function checkNumberPlus(str) {
    var i;
    var len = str.length;
    var chkStr = "-1234567890.";
    if (len == 1) {
	if (chkStr.indexOf(str.charAt(i)) < 0) {
	    return false;
	}
    } else {
	if ((chkStr.indexOf(str.charAt(0)) < 0) || ((str.charAt(0) == "0")&&(str.charAt(1)!="."))) {
	    return false;
	}
	for (i = 1; i < len; i++) {
	  if (chkStr.indexOf(str.charAt(i)) < 0) {
		return false;
	  }
	}
    }
    return true;
}

/**
 * 方法名:checkInteger
 * 参数:str 要校检的字符串
 * 返回值:true or false
 * 方法说明:校验整数
 * 调用示例如下:checkInteger("2222");
 */
function checkInteger(str) {
    if(checkNumberPlus(str)) {
        return str.indexOf('.') < 0;
    }
	return false;
}

/**
 * 方法名:checkPNumber
 * 参数:str 要校检的字符串
 * 返回值:true or false
 * 方法说明:校验正数
 * 调用示例如下:checkPNumber("232.22");
 */
function checkPNumber(str) {
	if(checkNumberPlus(str)) {
		return str.indexOf('-') < 0;
	}
	return false;
}

/**
 * 方法名:checkPInteger
 * 参数:str 要校检的字符串
 * 返回值:true or false
 * 方法说明:校验正整数
 * 调用示例如下:checkPInteger("2222")
 */
function checkPInteger(str) {
	if(checkInteger(str)) {
		return str.indexOf('-') < 0;
	}
	return false;
}

/**
 * 方法名:onlyNumber
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:控制输入框中内容为Number,只允许输入数字和小数点,负号.
 * 调用示例如下:onlyNumber(obj)
 */
function onlyNumber(obj){
	var checkStr = obj.value;

    if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57))|| (window.event.keyCode == 13) || (window.event.keyCode == 46)|| (window.event.keyCode == 45)))
   	{
       window.event.keyCode = 0 ;
       return false;
    }

  	if(window.event!=null){
      		//第一位不允许输入小数点“.”
      		if(checkStr == null || checkStr=="" ){
                	if(window.event.keyCode == 46)
                        	window.event.keyCode = 0 ;
                }
                //如果第一位是负号，第二位禁止输入“.”
                if(checkStr=="-"){
                        if(window.event.keyCode == 46)
                                window.event.keyCode = 0 ;
                }
                //如果第一位输入负号，其他位不允许输入负号“-”
                if(checkStr.indexOf("-")>-1 || checkStr.length>1){
                        if(window.event.keyCode == 45)
                                window.event.keyCode = 0 ;
                }
                //如果已经输入“.”，则其他位不允许输入“.”
                if(checkStr.indexOf(".")>-1){
                        if(window.event.keyCode == 46)
                                window.event.keyCode = 0 ;
                }
  	}
    return true;
}


/**
 * 方法名:isInNumber
 * 参数:str 字符串
 * 返回值:true or false
 * 方法说明:判断字符是否仅在-1234567890.之间
 * 调用示例如下:isInNumber(str)
 */
function isInNumber(str) {
  var len = str.length;
  var chkStr = "-1234567890.";
  for(i = 0; i < len; i++) {
    if(chkStr.indexOf(str.charAt(i)) < 0) {
      return false;
    }
  }
  return true;
}


/**
 * 方法名:validNumber
 * 参数:obj 输入框对象;colSize 数字的总长度;precision 小数位的长度
 * 返回值:true or false
 * 方法说明:校验输入框中内容为合法的Number
 * 调用示例如下:validNumber(this,8,3)
 */
function validNumber(obj,colSize,precision){
	var checkStr = obj.value;
        if(checkNumber(checkStr) == false) {
          obj.focus();
          return false;
        }
        colSize = parseInt(colSize);
        precision = parseInt(precision);
        var m = checkStr.length;                      //输入值的位置
        var n = checkStr.indexOf(".");                //“.”的位置
        var k = checkStr.indexOf("-");                //“-”的位置
        var j;                                        //整数长度
        var i;                                        //小数长度

	//如果输入值中含有“.”；获取输入值的整数长度；
 	if(n > -1){
           	//如果输入值中含有“－”
           	if(k > -1){
        		j = n - 1;
                      	i = m - n - 1;
           	}
                else{
                  	j = n;
                      	i = m - n - 1;
                }
 	}
 	else{
           	//如果输入值中含有“－”
           	if(k > -1){
  			j = m - 1;
           	}
                else{
                  	j = m;
                }
                i = 0;
 	}
      	//检验输入值的整数长度和小数长度
      	if((j > colSize - precision) || (i > precision)){
                alert(checkStr + "的精度不符，要求整数长度小于等于" + (colSize - precision) + "、小数长度小于等于" + precision + "！");
                obj.focus();
                return false
      	}
        return true;
}


/**
 * 方法名:onlyCalendar
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:控制输入框中内容为日期:如1999-02-07
 * 调用示例如下:onlyCalendar(this)
 */
function onlyCalendar(obj){
	var checkStr = obj.value;
    var m =  checkStr.length;

    if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57)) || (window.event.keyCode == 13) || (window.event.keyCode == 45)))
   	{
     	window.event.keyCode = 0 ;
        return false;
    }

  	if(window.event!=null){
              	//如果字符长度未达到四位或7位不允许输入“-”，反之则必须输入“-”
              	if(m < 4){
                	if(window.event.keyCode == 45)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if(m == 4){
                	if(window.event.keyCode != 45)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if(m > 4 && m < 7){
                	if(window.event.keyCode == 45)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if(m == 7){
                	if(window.event.keyCode != 45)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if((m > 7) && (m < 10)){
                	if(window.event.keyCode == 45)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
  	}
    return true;
}


/**
 * 方法名:validCalendar
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:校验输入框中内容为合法的日期
 * 调用示例如下:validCalendar(this)
 */
function validCalendar(obj){
	var checkStr = obj.value;
    var m = checkStr.length;
    var year;
    var month;
    var day;

        if(!(checkStr == null || checkStr=="" )){
          	if(m == 10 && checkStr.charAt(4) == "-" && checkStr.charAt(7) == "-"){
          		year = parseInt(checkStr.split('-')[0],10);
              		month = parseInt(checkStr.split('-')[1],10);
              		day = parseInt(checkStr.split('-')[2],10);

                        if(month > 12 || month == 0){
                        	alert(checkStr + "的格式不符，要求月份在1-12之间！");
                              	obj.focus();
                        	return false;
                        }
                        if(day > 31 || day ==0){
                        	alert(checkStr + "的格式不符，要求日在1-31之间！");
                              	obj.focus();
                        	return false;
                        }
                        else if((month == 2 || month == 4 || month ==6 || month ==9 || month ==11) && day == 31){
                          	alert(checkStr + "的格式不符，" + month + "月无31日！");
                              	obj.focus();
                        	return false;
                        }
                        else if(month == 2  && day == 30){
                          	alert(checkStr + "的格式不符，"+year+"月" +month+"月无30日！");
                              	obj.focus();
                        	return false;
                        }
                        else if((year%100==0)&&(year%400!=0) && month == 2  && day == 29){
                          	alert(checkStr + "的格式不符，"+year+"月" +month+"月无29日！");
                              	obj.focus();
                        	return false;
                        }
                        else if((year%4)!=0 && month == 2  && day == 29){
                          	alert(checkStr + "的格式不符，"+year+"月" +month+"月无29日！");
                              	obj.focus();
                        	return false;
                        }
          	}
              	else{
                 	alert(checkStr + "的格式不符，要求YYYY-MM-DD！");
                      	obj.focus();
                        return false;
              	}
        }
   return true;
}


/**
 * 方法名:onlyTime
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:控制Time类型中的时间输入框中内容为时间
 * 调用示例如下:onlyTime(this)
 */
function onlyTime(obj){
	var checkStr = obj.value;
    var m =  checkStr.length;

    if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57)) || (window.event.keyCode == 13) || (window.event.keyCode == 58)))
   	{
     		window.event.keyCode = 0 ;
                return false;
    }

  	if(window.event!=null){
              	//如果字符长度未达到2或5位不允许输入“:”，反之则必须输入“:”
              	if(m < 2){
                	if(window.event.keyCode == 58)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if(m == 2){
                	if(window.event.keyCode != 58)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if(m > 2 && m < 5){
                	if(window.event.keyCode == 58)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if(m == 5){
                	if(window.event.keyCode != 58)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
              	else if((m > 5) && (m < 8)){
                	if(window.event.keyCode == 58)
                        	window.event.keyCode = 0 ;
                              	return false;
              	}
  	}
    return true;
}


/**
 * 方法名:validTimeDate
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:校验Time类型中的时分秒输入框中内容为合法的时分秒
 * 调用示例如下:validTimeDate(this)
 */
function validTimeDate(obj){
  	var hidden_name = obj.name.substr(0,obj.name.indexOf("_date"));     //获取隐藏字段的名称
    var checkStr = obj.value;                                           //日期输入框值
    var hms_value = getObjValue(hidden_name + "_hms")                   //时间输入框值

    //如果日期输入框内容合法，然后判断日期输入框的内容是否为空，然后再判断时间输入框的内容是否为空；
  	if(true){
            	//如果日期输入值不为空并且时间的输入值不为空，则赋予隐藏字段的值，否则赋予隐藏字段的值为空值；
       if(!(checkStr == null || checkStr == "" ) && !(hms_value == null || hms_value=="" )){
              getWholeTime(hidden_name);
       }
       else{
              setObjValue(hidden_name,"");
       }
  	}

	return true;
}


/**
 * 方法名:validHMS
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:校验Time类型中的时分秒输入框中内容为合法的时分秒
 * 调用示例如下:validHMS(this)
 */
function validHMS(obj){
        var checkStr = obj.value;
      	var m = checkStr.length;
      	var hour;
      	var minute;
      	var second;

        if(!(checkStr == null || checkStr=="" )){
          	if(m == 8 && checkStr.charAt(2) == ":" && checkStr.charAt(5) == ":"){
          		hour = parseInt(checkStr.split(':')[0],10);
              		minute = parseInt(checkStr.split(':')[1],10);
              		second = parseInt(checkStr.split(':')[2],10);

                        if(hour > 23){
                        	alert(checkStr + "的格式不符，要求小时在00-23之间！");
                              	obj.focus();
                        	return false;
                        }
                        if(minute > 59){
                        	alert(checkStr + "的格式不符，要求分钟在00-59之间！");
                              	obj.focus();
                        	return false;
                        }
                        if(second > 59){
                        	alert(checkStr + "的格式不符，要求秒在00-59之间！");
                              	obj.focus();
                        	return false;
                        }
          	}
              	else{
                 	alert(checkStr + "的格式不符，要求HH:MI:SS！");
                      	obj.focus();
                        return false;
              	}
        }
        return true;
}


/**
 * 方法名:validTime
 * 参数:obj 输入框对象
 * 返回值:true or false
 * 方法说明:校验Time类型中的时分秒输入框中内容为合法的时分秒，并赋予隐藏字段的值
 * 调用示例如下:validTime(this)
 */
function validTime(obj){
  	var hidden_name = obj.name.substr(0,obj.name.indexOf("_hms"));      //获取隐藏字段的名称
    var checkStr = obj.value;                                           //时间输入框值
    var date_value = getObjValue(hidden_name + "_date")                 //日期输入框值

     //如果时分秒输入框内容合法，然后判断时分秒输入框的内容是否为空，然后再判断日期输入框的内容是否为空；
  	if(validHMS(obj)){
        //如果时分秒输入值不为空并且日期的输入值不为空，则赋予隐藏字段的值，否则赋予隐藏字段的值为空值；
        if(!(checkStr == null || checkStr == "" ) && !(date_value == null || date_value=="" )){
            getWholeTime(hidden_name);
        }
        else{
            setObjValue(hidden_name,"");
        }
  	}
    return true;
}

//校验Time(没有秒)类型中的时分输入框中内容为合法的时分秒，并赋予隐藏字段的值；
function validTimeNS(obj){
var hidden_name = obj.name.substr(0,obj.name.indexOf("_hms"));      //获取隐藏字段的名称
var checkStr = obj.value;                                           //时间输入框值
var date_value = getObjValue(hidden_name + "_date")                 //日期输入框值

//如果时分秒输入框内容合法，然后判断时分秒输入框的内容是否为空，然后再判断日期输入框的内容是否为空；
if(validHM(obj)){
   //如果时分秒输入值不为空并且日期的输入值不为空，则赋予隐藏字段的值，否则赋予隐藏字段的值为空值；
   if(!(checkStr == null || checkStr == "" ) && !(date_value == null || date_value=="" )){
     //getWholeTime(hidden_name);
     var hmsValue = getObjValue(hidden_name+"_hms");
     if(hmsValue.length==5){
        setObjValue(hidden_name,getObjValue(hidden_name+"_date") + " " + hmsValue+":00");
     }
   }else{
     setObjValue(hidden_name,"");
   }
}
return true;
}


//校验Time(没有秒)类型中的时分输入框中内容为合法的时分秒；
function validHM__(obj){
    var checkStr = obj.value;
   var m = checkStr.length;
   var hour;
   var minute;
   var second;

    if(!(checkStr == null || checkStr=="" )){
       if(m == 5 && checkStr.charAt(2) == ":"){
        hour = parseInt(checkStr.split(':')[0],10);
            minute = parseInt(checkStr.split(':')[1],10);
                    if(hour > 23){
                     alert(checkStr + "的格式不符，要求小时在00-23之间！");
                           obj.focus();
                     return false;
                    }
                    if(minute > 59){
                     alert(checkStr + "的格式不符，要求分钟在00-59之间！");
                           obj.focus();
                     return false;
                    }
       }
           else{
              alert(checkStr + "的格式不符，要求HH:MI！");
                   obj.focus();
                    return false;
           }
    }
    return true;
}

function validHM(obj) {
	var str = obj.value;
	var checking = /^(?:[01]?\d|2[0-3])(?::[0-5]?\d){1}$/;
	if(checking.exec(str) == obj.value) {
		return true;
	} else {
		alert("时间格式非法！");
		obj.focus();
		return false;
	}
}

/**--------------------------------校验时间输入，不带秒end---------------------------×/

/**
 * 方法名:validFormText
 * 参数:name 要判断的控件的名字;isMustInput 是否是必输项
 * 返回值:true or false
 * 方法说明:判断form中文本控件是否满足必输的需求
 * 调用示例如下:validFormText(name,"true")
 */
function validFormText(name,isMustInput) {
  //获取被检验的文本控件的输入值
  TextValue = getObjValue(name);
  //如果该数值控件必输
  if(isMustInput == "false") {
    return true;
  }
  if(isMustInput == "true" && TextValue==""){
     	alert("请输入值！");
        setInputFocus(name);
        return false;
  }
  return true;
}

/**
 * 方法名:validGridText
 * 参数:name 要判断的控件的名字;isMustInput 是否是必输项
 * 返回值:true or false
 * 方法说明:判断grid中文本控件是否满足配置的必输的需求
 * 调用示例如下:validGridText(name,"true")
 */
function validGridText(name,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //获取objTable的行数

        //循环判断，如果行显示类型不是为“none”，则调用validFromText方法；
	for (var i = 1;i < strTableTotalRows;i++) {
		if(objTable.rows(i).style.display != "none") {
                	if(!validFormText("DATA[" + (i-1) + "]." + name,isMustInput)){
                          	return false;
                	}
		}
	}
	return true;
}


/**
 * 方法名:validFormNumber
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;isMustInput 是否必输
 * 返回值:true or false
 * 方法说明:判断form中数值控件是否满足配置的最大值和最小值和必输的需求
 * 调用示例如下:validFormNumber(name,100,1,"true")
 */
function validFormNumber(name,maxValue,minValue,isMustInput){
  	//获取被检验数值的输入值；
  	numberValue = parseFloat(getObjValue(name));
    maxValue = parseFloat(maxValue);
    minValue = parseFloat(minValue);

    //如果该数值控件必输
     if(isMustInput == "true" && isNaN(numberValue)){
        	alert("请输入值！");
              	setInputFocus(name);
              	return false;
      	}
      	else if(!isNaN(numberValue)){
         	if(!isNaN(maxValue) && numberValue > maxValue){
                	alert("您输入的值大于允许输入的最大值！");
              		setInputFocus(name);
                      	return false;
         	}
              	if(!isNaN(minValue) && numberValue < minValue){
                	alert("您输入的值小于允许输入的最小值！");
              		setInputFocus(name);
                      	return false;
         	}
      	}
      	return true;
}


/**
 * 方法名:validGridNumber
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;isMustInput 是否必输
 * 返回值:true or false
 * 方法说明:判断grid中数值控件是否满足配置的最大值和最小值和必输的需求
 * 调用示例如下:validGridNumber(name,100,1,"false")
 */
function validGridNumber(name,maxValue,minValue,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //获取objTable的行数

        //循环判断，如果行显示类型不是为“none”，则调用validFormNumber方法；
	for (var i = 1;i < strTableTotalRows;i++) {
		if(objTable.rows(i).style.display != "none") {
                	if(!validFormNumber("DATA[" + (i-1) + "]." + name,maxValue,minValue,isMustInput)){
                		return false;
                        }
		}
	}
	return true;
}


/**
 * 方法名:validFormDate
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;isMustInput 是否必输
 * 返回值:true or false
 * 方法说明:判断form中日期控件是否满足配置的最大值和最小值和必输的需求
 * 调用示例如下:validFormDate (name,"2004-09-01","2004-08-09","false")
 */
function validFormDate(name,maxValue,minValue,isMustInput){
	//获取被检验数日期的输入值；
  	dateValue = getObjValue(name);

      	//如果该日期控件必输
      	if(isMustInput == "true" && dateValue ==""){
        	alert("请输入日期！");
              	setInputFocus(name);
              	return false;
      	}
      	else if(dateValue !=""){
         	if(maxValue !="" && dateValue > maxValue){
                	alert("您输入的日期大于允许输入的最大日期！");
              		setInputFocus(name);
                      	return false;
         	}
              	if(minValue !="" && dateValue < minValue){
                	alert("您输入的日期小于允许输入的最小日期！");
              		setInputFocus(name);
                      	return false;
         	}
      	}
      	return true;
}

/**
 * 方法名:validGridDate
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;isMustInput 是否必输
 * 返回值:true or false
 * 方法说明:判断grid中日期控件是否满足配置的最大值和最小值和必输的需求
 * 调用示例如下:validGridDate (name,"2004-09-01","2004-08-09","false")
 */
function validGridDate(name,maxValue,minValue,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //获取objTable的行数

    //循环判断，如果行显示类型不是为“none”，则调用validFormDate方法；
	for (var i = 1;i < strTableTotalRows;i++) {
		if(objTable.rows(i).style.display != "none") {
                	if(!validFormDate("DATA[" + (i-1) + "]." + name,maxValue,minValue,isMustInput)){
                          	return false;
                	}
		}
	}
	return true;
}


/**
 * 方法名:validFormTime
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;isMustInput 是否必输
 * 返回值:true or false
 * 方法说明:判断form中时间控件是否满足配置的最大值和最小值和必输的需求
 * 调用示例如下:validFormTime (name,"2004-09-01 23:22:22","2004-08-09 23:22:22","false")
 */
function validFormTime(name,maxValue,minValue,isMustInput){
	//获取被检验数时间的输入值；
  	timeValue = getObjValue(name);

      	//如果该日期控件必输
      	if(isMustInput == "true" && timeValue ==""){
        	alert("请输入时间！");
              	if(getObjValue(name + "_date") == ""){
              		setInputFocus(name + "_date");
                      	return false;
              	}
              	else if(getObjValue(name + "_hms") == ""){
                	setInputFocus(name + "_hms");
                      	return false;
              	}
              	return false;
      	}
      	else if(timeValue !=""){
         	if(maxValue != "" && timeValue > maxValue){
                	alert("您输入的时间大于允许输入的最大时间！");
              		setInputFocus(name);
                      	return false;
         	}
              	if(minValue != "" && timeValue < minValue){
                	alert("您输入的时间小于允许输入的最小时间！");
              		setInputFocus(name);
                      	return false;
         	}
      	}
      	return true;
}

/**
 * 方法名:validGridTime
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;isMustInput 是否必输
 * 返回值:true or false
 * 方法说明:判断grid中时间控件是否满足配置的最大值和最小值和必输的需求
 * 调用示例如下:validGridTime (name,"2004-09-01 23:22:22","2004-08-09 23:22:22","false")
 */
function validGridTime(name,maxValue,minValue,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //获取objTable的行数

        //循环判断，如果行显示类型不是为“none”，则调用validFormTime方法；
	for (var i = 1;i < strTableTotalRows;i++) {
		if(objTable.rows(i).style.display != "none") {
                	if(!validFormTime("DATA[" + (i-1) + "]." + name,maxValue,minValue,isMustInput)){
                          	return false;
                	}
		}
	}
	return true;
}

/**
 * 方法名:GetDay
 * 参数:varYear 输入的年;varMonth 输入的月
 * 返回值:该年,月的天数
 * 方法说明:输入,年和月,获得该年,月的天数
 * 调用示例如下:GetDay("2000", "2")为29天
 */
function GetDay(varYear, varMonth)
{
var lngDay

varYear = parseInt(varYear)
varMonth = parseInt(varMonth)
switch (varMonth) {
case 1 :
case 3 :
case 5 :
case 7 :
case 8 :
case 10 :
case 12 :
lngDay = 31
break
case 4 :
case 6 :
case 9 :
case 11 :
lngDay = 30
break
case 2 :
if ((varYear % 4 == 0 && varYear % 100 != 0) || (varYear % 400 == 0))
lngDay = 29
else
lngDay = 28
break
} // switch
return lngDay
}

/**
 * 方法名:validateDate
 * 参数:year 输入的年;month 输入的月;day 输入的日
 * 返回值:true or false
 * 方法说明:校验日期的年四位,月,日为两位或者一位.
 * 调用示例如下:validateDate("2000", "2", "31")
 */
function validateDate(year, month, day)
{

var strDate, arrDate
var lngYear, lngMonth, lngDay
var strReg
var strError
strError = ""
strReg = /^\d{4}-\d{1,2}-\d{1,2}$/;
strDate = year+'-'+month+'-'+day;
arrDate = strDate.split("-")
if (strReg.test(strDate)) {
lngYear = parseInt(arrDate[0], 10)
lngMonth = parseInt(arrDate[1], 10)
lngDay = parseInt(arrDate[2], 10)
}

if (!strReg.test(strDate)) {
  return false
}
else if (lngMonth < 1 || lngMonth > 12) {
 return false
}
else if (lngDay < 1 || lngDay > GetDay(lngYear, lngMonth)) {
 return false
}
  return true;
}

/**
 * 方法名:checkValidate
 * 参数:msg 输出名称;element 页面元素名称
 * 返回值:false or 无
 * 方法说明:校验页面的某个控件是否为必输项.如果校验失败返回false,并弹出提示框
 * 调用示例如下:checkValidate(msg,element)
 */
function checkValidate(msg,element)
{
    if(document.getElementById(element).value==null||document.getElementById(element).value=='')
    {
        alert('请输入'+msg) ;
        return false;
    }
}

/**
 * 方法名:objCheckLen2
 * 参数:obj 对象引用;maxLength 字符串长度
 * 返回值:无
 * 方法说明:用于在onblur事件时,检验文本框中的字符个数
 * 调用示例如下:objCheckLen2(obj,maxLength)
 */
function objCheckLen2(obj,maxLength){
  var len = StrLen(obj.value);
  if(len > maxLength){
	 alert("输入超出最大允许长度!!!");
  	//alert("{" + getChineseName(obj) + "}已输入" + len + "字，最多允许输入" + maxLength + "字！");
    obj.focus();
    //obj.select();
  }
}

/**
 * 方法名:objCheckLen2_onkeypress
 * 参数:obj 对象引用;maxLength 字符串长度
 * 返回值:无
 * 方法说明:用于在onkeypress事件时,检验文本框中的字符个数
 * 调用示例如下:objCheckLen2_onkeypress(obj,maxLength)
 */
function objCheckLen2_onkeypress(obj,maxLength){

  var len = StrLen(obj.value);
  if(len >= maxLength){
	window.event.keyCode = 0 ;
  	//alert("{" + getChineseName(obj) + "}已输入" + len + "字，最多允许输入" + maxLength + "字！");
    obj.focus();
    //obj.select();
  }
}

/**
 * 方法名:validNumber2
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;minexp 最小值比较符号;maxexp 最大值比较符号;validate 检验标志位
 * 返回值:true or false
 * 方法说明:判断数值控件是否满足配置的最大值和最小值
 * 调用示例如下:validNumber2(name,100,1,"<",">","true")
 */
function validNumber2(obj,minValue,minexp,maxValue,maxexp,validate){
  	//获取被检验数值的输入值；
  	numberValue = parseFloat(obj.value);
    maxValue = parseFloat(maxValue);
    minValue = parseFloat(minValue);

	//alert(numberValue);
	if(!isNaN(numberValue)) {
	  obj.value = numberValue;
	}
    if (validate=="true"){
      if (!isNaN(maxValue)){
		  if(maxexp=="<") {
			  if(numberValue >= maxValue){
                alert("您输入的值大于允许输入的最大值！");
                obj.focus();
				return false;
			  }
		  }
		  if(maxexp=="<="){
			  if(numberValue > maxValue){
			    alert("您输入的值大于允许输入的最大值！");
				obj.focus();
				return false;
			  }
		  }
	  }
	  if (!isNaN(minValue)){
		  if(minexp==">") {
			  if(numberValue <= minValue){
                alert("您输入的值小于允许输入的最小值！");
                obj.focus();
				return false;
			  }
		  }
		  if(minexp==">="){
			  if(numberValue < minValue){
				 alert("您输入的值小于允许输入的最小值！");
				 obj.focus();
				 return false;
			  }
		  }
	  }
    }
    return true;
}

/**
 * 方法名:validNumber3
 * 参数:name 控件的名字;maxValue 最大值;minValue 最小值;
 * 返回值:true or false
 * 方法说明:判断数值控件是否满足配置的最大值和最小值,专为带分割符的控件使用,用于取隐藏控件的值
 * 调用示例如下:validNumber3(name,100,1,"<",">","true")
 */
function validNumber3(obj,minValue,minexp,maxValue,maxexp,validate){
  	//获取被检验数值的输入值；
  	var objhidden = document.getElementById(obj.name.replace("money_", ""));
  	numberValue = parseFloat(objhidden.value);
    maxValue = parseFloat(maxValue);
    minValue = parseFloat(minValue);

	//alert(numberValue);
	if(!isNaN(numberValue)) {
	  objhidden.value = numberValue;
	}
    if (validate=="true"){
      if (!isNaN(maxValue)){
		  if(maxexp=="<") {
			  if(numberValue >= maxValue){
                alert("您输入的值大于允许输入的最大值！");
                obj.focus();
				return false;
			  }
		  }
		  if(maxexp=="<="){
			  if(numberValue > maxValue){
			    alert("您输入的值大于允许输入的最大值！");
				obj.focus();
				return false;
			  }
		  }
	  }
	  if (!isNaN(minValue)){
		  if(minexp==">") {
			  if(numberValue <= minValue){
                alert("您输入的值小于允许输入的最小值！");
                obj.focus();
				return false;
			  }
		  }
		  if(minexp==">="){
			  if(numberValue < minValue){
				 alert("您输入的值小于允许输入的最小值！");
				 obj.focus();
				 return false;
			  }
		  }
	  }
    }
    return true;
}

/**
 * 方法名:onlyInteger
 * 参数:obj 控件的对象引用
 * 返回值:无 or false
 * 方法说明:数值控件只允许输入数字,和负号,回车
 * 调用示例如下:onlyInteger(this)
 */
function onlyInteger(obj){
	var checkStr = obj.value;
  //alert(checkStr);
  if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57))|| (window.event.keyCode == 13) || (window.event.keyCode == 45))){
       window.event.keyCode = 0 ;
       return false;
  }

  if(window.event!=null){
  	//负号只能在第一位
  	if (window.event.keyCode == 45){
  		if(checkStr!="" && getCaret(obj) != 0) {
  			window.event.keyCode = 0
  			//alert("负号只能在第一位!!!");
  		}
  	}

  }
    return true;
}


/**
 * 方法名:onlyDouble
 * 参数:obj 控件的对象引用
 * 返回值:true or false
 * 方法说明:浮点数值控件只允许输入数字,和负号,回车,小数点
 * 调用示例如下:onlyDouble(this)
 */
function onlyDouble(obj){
	var checkStr = obj.value;

  if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57))|| (window.event.keyCode == 13) || (window.event.keyCode == 46)|| (window.event.keyCode == 45))){
    window.event.keyCode = 0 ;
    return false;
  }

  if(window.event!=null){
  	if(window.event.keyCode == 46 && getCaret(obj) == 0 ){
  		window.event.keyCode = 0
  		//alert("第一位不允许输入小数点“.”!!!");
  	}
  	//负号只能在第一位
  	if (window.event.keyCode == 45){
      if(checkStr!="" && getCaret(obj) != 0) {
  			window.event.keyCode = 0
  			//alert("负号只能在第一位!!!");
  		}
  	}
    //第一位不允许输入小数点“.”
    if(checkStr == null || checkStr=="" ){
      if(window.event.keyCode == 46)
        window.event.keyCode = 0 ;
    }
    //如果第一位是负号，第二位禁止输入“.”
    if(checkStr=="-"){
      if(window.event.keyCode == 46)
        window.event.keyCode = 0 ;
    }

    //如果已经输入“.”，则其他位不允许输入“.”
    if(checkStr.indexOf(".")>-1){
      if(window.event.keyCode == 46)
        window.event.keyCode = 0 ;
    }
  }
  return true;
}

/**
 * 方法名:checkNumber
 * 参数:str 控件的对象值
 * 返回值:true or false
 * 方法说明:校验浮点数值控件只允许输入数字,和负号,回车,小数点
 * 调用示例如下:checkNumber(obj.value)
 */
function checkNumber(str) {
    var i;
    var len = str.length;
    var chkStr = "-1234567890.";
    if (len == 1) {
	if (chkStr.indexOf(str.charAt(i)) < 0) {
	    return false;
	}
    } else {
	if ((chkStr.indexOf(str.charAt(0)) < 0) || ((str.charAt(0) == "0")&&(str.charAt(1)!="."))) {
	    return false;
	}
	 for (i = 1; i < len; i++) {
		if (chkStr.indexOf(str.charAt(i)) < 0) {
			    return false;
		}
	}
    }
    return true;
}


/**
 * 方法名:formatIntegerToSepInteger
 * 参数:this 控件对象
 * 返回值:无
 * 方法说明:格式化整形为带分割符的整形
 * 调用示例如下:formatIntegerToSepInteger(this)
 */
function formatIntegerToSepInteger(money) {
		var dValue = money.value;
		money.value = doMoneyGroup(dValue);
   	sPoint = false;
   	document.getElementById(money.name.replace("money_", "")).value = dValue;
   	sPoint = true;
}


/**
 * 方法名:formatSepIntegerToInteger
 * 参数:money 控件对象
 * 返回值:无
 * 方法说明:格式化带分割符的整形为整形
 * 调用示例如下:formatSepIntegerToInteger(this)
 */
function formatSepIntegerToInteger(money) {
//	var d = money.value.replace(",", "");
//updated by liu.cj 修改当金额中千分符多于一个不能完全去除的问题
   var d = money.value;
   while(d.indexOf(',') >=0)
   {
		d = d.replace(",", "");
   }
    money.value = d;
}

/**
 * 方法名:IntegerToSepInteger_OnPropertyChange
 * 参数:money 控件对象
 * 返回值:无
 * 方法说明:用于在带分割符的整形和浮点中,当隐藏控件的值改变了以后,去相应更新显示控件的值
 * 调用示例如下:IntegerToSepInteger_OnPropertyChange(this)
 */
function IntegerToSepInteger_OnPropertyChange(obj) {
	//alert("sPoint"+sPoint);
	if(!sPoint)
		return;
	if(obj.value == "")
		return;
	var dValue =  obj.value.replace(",", "");

	sPoint = false;
	obj.value = dValue;
	sPoint = true;

	var money ;
	
    if (obj.name.indexOf("].")>0) {
  	  var strNames = obj.name.split("].");
  	  //money = document.getElementById(strNames[0]+"]."+"money_" + strNames[1]);
  	  money = document.getElementById("money_" + obj.name);
    }else{
  	  money = document.getElementById("money_" + obj.name);
	}
	money.value = doMoneyGroup(dValue);
}

/**
 * 方法名:doMoneyGroup
 * 参数:value 要加分割符的字符串
 * 返回值:字符串
 * 方法说明:加分割符
 * 调用示例如下:doMoneyGroup(100000)为100,000
 */
function doMoneyGroup(value) {
	if(value == "")
		return "";
	var minusFlag = value.indexOf("-") == 0;
	if(minusFlag)
		value = value.substring(1, value.length);
	var pointIndex = value.indexOf(".");
	var intPart = pointIndex<0?value:value.substring(0, pointIndex);
	var pointPart = pointIndex<0?"":value.substring(pointIndex, value.length);
	if(intPart.length <= 3)
		return (minusFlag?"-":"") + value;
	else {
		var newDataArray = new Array();
		var ys = intPart.length%3;
		var dotNumber = parseInt(intPart.length/3);

		var newArrayNumber = 0;
		for(var i=dotNumber;i>0;i--)
		{
			var start = ys+(i-1)*3;
			var dot = (start==0)?"":","
			newDataArray[newArrayNumber] = dot+intPart.substr(start,3);
			newArrayNumber++;
		}

		var foreData = "";

		newData = intPart.substr(0,ys);

		for(var i=newDataArray.length-1;i>=0;i--)
		{
			newData = newData + newDataArray[i];
		}
	}
	return (minusFlag?"-":"") + newData + pointPart;
}


/**
 * 方法名:validNumber_sep
 * 参数:obj 输入框对象;colSize 数字的总长度;precision 小数位的长度
 * 返回值:true or false
 * 方法说明:校验输入框中内容为合法的Number,专用带分割符的控件使用
 * 调用示例如下:validNumber_sep(this,8,3)
 */
function validNumber_sep(obj,colSize,precision){
  	var objhidden = document.getElementById(obj.name.replace("money_", ""));
	var checkStr = objhidden.value;
        if(checkNumber(checkStr) == false) {
          obj.focus();
          return false;
        }
        colSize = parseInt(colSize);
        precision = parseInt(precision);
        var m = checkStr.length;                      //输入值的位置
        var n = checkStr.indexOf(".");                //“.”的位置
        var k = checkStr.indexOf("-");                //“-”的位置
        var j;                                        //整数长度
        var i;                                        //小数长度

	//如果输入值中含有“.”；获取输入值的整数长度；
 	if(n > -1){
           	//如果输入值中含有“－”
           	if(k > -1){
        		j = n - 1;
                      	i = m - n - 1;
           	}
                else{
                  	j = n;
                      	i = m - n - 1;
                }
 	}
 	else{
           	//如果输入值中含有“－”
           	if(k > -1){
  			j = m - 1;
           	}
                else{
                  	j = m;
                }
                i = 0;
 	}
      	//检验输入值的整数长度和小数长度
      	if((j > colSize - precision) || (i > precision)){
                alert(checkStr + "的精度不符，要求整数长度小于等于" + (colSize - precision) + "、小数长度小于等于" + precision + "！");
                obj.focus();
                return false
      	}
        return true;
}
/**---------------------------校验函数结束---------------------------------------*/





/**---------------------------运算函数开始---------------------------------------*/

/**
 * 方法名:mpcFormatNumber
 * 参数:srcStr 要进行格式化的字符串;nAfterDot 平均多少位以一个","分割
 * 返回值:格式化后的字符串
 * 方法说明:对字符串进行格式化,多少位以一个","分割
 * 调用示例如下:Var Str1 = mpcFormatNumber("10000000",3) Str1的值为 "10,000,000";
 */
function mpcFormatNumber(srcStr,nAfterDot){
    var srcStr,nAfterDot;
    var resultStr,nTen;
    srcStr = ""+srcStr+"";
    strLen = srcStr.length;
    dotPos = srcStr.indexOf(".",0);
    if(srcStr==''){
        resultStr='0.'
        for(var k=0;k<nAfterDot;k++){
            resultStr=resultStr+'0';
        }
        return resultStr;
    }
    if (dotPos == -1){
        resultStr = srcStr+".";
        for (i=0;i<nAfterDot;i++){
            resultStr = resultStr+"0";
        }
        return resultStr;
    }
    else{
        if ((strLen - dotPos - 1) >nAfterDot){
            nAfter = dotPos + nAfterDot + 1;
            nTen =1;
            for(j=0;j<nAfterDot;j++){
                nTen = nTen*10;
            }
            resultStr = Math.round(parseFloat(srcStr)*nTen)/nTen;

            var dotPos2=(""+resultStr+"").indexOf(".",0);

            return resultStr;
        }
        else{
            resultStr = srcStr;
            for (i=0;i<(nAfterDot - strLen + dotPos + 1);i++){
                resultStr = resultStr+"0";
            }
            return resultStr;
        }
    }
}



/**
 * 方法名:putUniqueSql
 * 参数:fieldCode 字段代码;inputValue 字段值;fieldType 拼接类型;relation 比较关系
 * 返回值:拼接好的sql语句
 * 方法说明:用于根据字段类型拼SQL语句
 * fieldType为1,2,3
 * "1"表示inputValue为字符串值
 * "2"表示inputValue为数值
 * "3"表示inputValue为日期
 * 调用示例如下:Var str1 = putUniqueSql("rowid","1001","1","=") Str1 为 rowed = '1001'
 */
function putUniqueSql(fieldCode,inputValue,fieldType,relation)
{
  	switch(fieldType){
  		case "1": return fieldCode+relation+"'"+inputValue+"'";break;
  		case "2": return fieldCode+relation+inputValue;break;
  		case "3": return to_char(fieldCode,'yyyy-mm-dd')+relation+"'"+inputValue+"'";break;
  	}
}

/**
 * 方法名:.trim()
 * 参数:无
 * 返回值:被去除左右空格的字符串
 * 方法说明:定义js中的string类型的原型函数,用于去除左右空格
 * 调用示例如下:Var String1 = "  sdsd   ";String1.trim();
 */
String.prototype.trim = function()
{
    return this.replace(/(^[\s|　]*)|([\s|　]*$)/g, "");
}

/**
 * 方法名:ltrim
 * 参数:s 待去空格的字符串
 * 返回值:被去了左空格的字符串
 * 方法说明:去左空格
 * 调用示例如下:ltrim("   ssss")
 */
function ltrim(s){
 return s.replace( /^\s*/, "");
}

/**
 * 方法名:rtrim
 * 参数:s 待去空格的字符串
 * 返回值:被去了右空格的字符串
 * 方法说明:去右空格
 * 调用示例如下:rtrim("ssss   ")
 */
function rtrim(s){
 return s.replace( /\s*$/, "");
}

/**
 * 方法名:trim
 * 参数:s 待去空格的字符串
 * 返回值:被去了左右空格的字符串
 * 方法说明:去字符串的左右空格
 * 调用示例如下:trim("  ssssssss  ")
 */
function trim(s){
 return rtrim(ltrim(s));
}

/**
 * 方法名:trimNC
 * 参数:s 待截取字符串
 * 返回值:截取后的字符串
 * 方法说明:截取字符串前后的空字符回车符和换行符
 * 调用示例如下:trimNC("sd
 *  sd
 *  ")
 */
function trimNC(strValue)
{
	var  i=0;
	var intLen;
	if (strValue.length == 0)return ""
	while (i == 0)
	  {
	    i = strValue.indexOf("\r",0);
	    strValue=strValue.replace("\r","")
	  }
    i=0;
	while (i == 0)
	  {
	    i = strValue.indexOf(" ",0);
	    strValue=strValue.replace(" ","")
	  }
    i=0;
	while (i == 0)
	  {
	    i = strValue.indexOf("\n",0);
	    strValue=strValue.replace("\n","")
	  }

    intLen = (strValue.length - 1)
    while (strValue.lastIndexOf(" ") == intLen)
      {
        strValue=strValue.substr(0,intLen-1)
        intLen = strValue.length
	  }
	return strValue;
}

/**
 * 方法名:replaceStr
 * 参数:str 被置换的字符串
 * 返回值:被置换后的字符串
 * 方法说明:在GET方法进行提交时,用于特殊字符串置换
 * 调用示例如下:replaceStr("sdsd=+-sdsd")
 */
function replaceStr(str)
{
    str = str.replace(/%/g,"%25");
    str = str.replace(/&/g,"%26");
    str = str.replace(/\n/g,"%0A");
    str = str.replace(/\+/g,"%2B");
    str = str.replace(/#/g,"%23");
    str = str.replace(/=/g,"~");
    //str = str.replace(/</g,"&#60;");
    //str = str.replace(/>/g,"&#62;");
    //str = str.replace(/\\/g,"&#92;");
    //str = str.replace(/</g,"&#60;");
    //str = str.replace(/>/g,"&#62;");
    //str = str.replace(/\"/g,"&#34;");
    //str = str.replace(/ /g,"&nbsp;");

    return str;
}

/**
 * 方法名:strLength
 * 参数:s 需要得到长度的字符串
 * 返回值:得到的字符串长度
 * 方法说明:得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
 * 调用示例如下:strLength("工了112")值为7
 */
function strLength(s){
	var i,str1,str2,str3,nLen;
	str1 = s;
	nLen = 0;
	for(i=1;i<=str1.length;i++){
		str2=str1.substring(i-1,i)
		str3=escape(str2);
		if(str3.length>3){
			nLen = nLen + 2;
		}
		else{
			nLen = nLen + 1;
		}
	}
	return nLen;
}



/**---------------------------运算函数结束---------------------------------------*/






/**---------------------------取值函数开始---------------------------------------*/

/**
 * 方法名:getClientSysDate
 * 参数:无
 * 返回值:返回客户端的系统日期
 * 方法说明:获得客户端的系统日期 ;年月日之间用"-"隔开
 * 调用示例如下:getClientSysDate()
 */
function getClientSysDate()
{
 var sysDate,year,month,date;
 sysDate = new Date();
 year = String(sysDate.getFullYear());
 month = String(sysDate.getMonth()+1);
 date = String(sysDate.getDate());
 if(month.length<2)
  month = "0"+month;
 if(date.length<2)
  date = "0"+date;
 return(year+"-"+month+"-"+date);
}

/**
 * 方法名:getClientSysTime
 * 参数:无
 * 返回值:获得客户端的系统时间;年月日之间用"-"隔开,时分秒之间用":"隔开
 * 方法说明:返回客户端的系统时间
 * 调用示例如下:getClientSysTime()
 */
function getClientSysTime()
{
 var hour,minute,second,sysDate;
 sysDate = new Date();
 hour = String(sysDate.getHours());
 minute = String(sysDate.getMinutes());
 second = String(sysDate.getSeconds());
 if(hour.length<2)
  hour = "0"+hour;
 if(minute.length<2)
  minute = "0"+minute;
 if(second.length<2)
  second = "0"+second;
 return(hour+":"+minute+":"+second);
}

/**
 * 方法名:getCheckedValue
 * 参数:objName grid中的radio或checkbox的名字
 * 返回值:字符串
 * 方法说明:获得grid中的radio或checkbox的值，如果是radio则返回一个字符串，如果是checkbox则返回多个字符串，中间用逗号隔开；
 * 调用示例如下:getCheckedValue(document.all.checkbox)
 */
function getCheckedValue(objName)
{
  	var objChk;
  	var CheckedValue = "";
  	var j=1;
  	for(var i=0;i<getElementLen(objName);i++)
  	{
          	objChk=getObj(objName,i);
          	if(objChk.checked&&(!objChk.disabled))
          	{
                  	if(j==1){
                  		CheckedValue = objChk.value;
                  	}
                  	else{
                    		CheckedValue = CheckedValue + "," + objChk.value;
                  	}
                  	j = j + 1;
          	}
  	}
  	return CheckedValue;
}

/**
 * 方法名:getCheckedIndex
 * 参数:objName grid中的radio或checkbox的名字
 * 返回值:字符串
 * 方法说明:获得被选中radio或checkbox的索引,如果是radio则返回一个索引，如果是checkbox则返回索引串，中间用逗号隔开；
 * 调用示例如下:getCheckedIndex(document.all.checkbox)
 */
function getCheckedIndex(objName)
{
  	var objChk
  	var j = 1;
        var indexValue = "";
  	for(var i=0;i<getElementLen(objName);i++){
          	objChk=getObj(objName,i);
          	if(objChk.checked&&(!objChk.disabled)){
			if(j==1){
                  		indexValue = i;
                      	}
                  	else{
                    		indexValue = indexValue + "," + i;
                  	}
                  	j = j + 1;
          	}
  	}
      	return indexValue;
}

/**
 * 方法名:getObjValue
 * 参数:objName 组件的名字
 * 返回值:组件去除左右空格后的值
 * 方法说明:获得页面中组件的值,并且去除左右空格
 * 调用示例如下:getObjValue("rowId")
 */
function getObjValue(objName)
{
	//alert();
	var obj = eval("document.all('" + objName + "')");
        if(obj == null) return "null";
      	return obj.value.trim();
}

/**
 * 方法名:getObjInnerHtml
 * 参数:objName 组件的名字
 * 返回值:组件的innerHTML值
 * 方法说明:获得页面中id的innerHTML值,如果innerHTML值中包含label则取label中的innerHTML值；
 * 调用示例如下:getObjInnerHtml("userName")
 */
function getObjInnerHtml(objName)
{
  	var innelHtmlValue = "";
	var obj = eval("document.all('" + objName + "')");
      	if(!(typeof(obj) == "object")) return '';
      	if((obj.innerHTML).indexOf("LABEL") < 0){
                innelHtmlValue = obj.innerHTML;
      	}
        else{
          	var i = (obj.innerHTML).indexOf(">",0);
              	var j = (obj.innerHTML).indexOf("</",0);
              	innelHtmlValue = (obj.innerHTML).substr(i+1,j-i-1);
        }
      	return innelHtmlValue;
}


/**
 * 方法名:getCellValue
 * 参数:checkObjName Checkbox的名字;cellObjName 行的字段的名字
 * 返回值:字段的值
 * 方法说明:获得页面table中被选择行中表格的字段值的值，如果是单选则返回一个字符串，如果是多选则返回多个字符串，中间用逗号隔开;
 * 调用示例如下:getCellValue("checkboxName","userName")
 */
function getCellValue(checkObjName,cellObjName)
{
  	var objChk;
  	var cellValue = "";
      	var indexValue;

      	indexValue = getCheckedIndex(checkObjName) + "";
      	if(indexValue != "" && indexValue.indexOf(",") < 0){
                cellValue = getObjInnerHtml(cellObjName + indexValue);
      	}
      	else if(indexValue != "" && indexValue.indexOf(",") > 0){
         	var indexCount =  indexValue.indexOf(",");
              	var indexAarry = indexValue.split(",");
              	var j = 1;

              	for(var i=0;i<indexCount+1;i++){
                        if(j==1){
                  		cellValue = getObjInnerHtml(cellObjName + indexAarry[i]);
                      	}
                  	else{
                    		cellValue = cellValue + "," + getObjInnerHtml(cellObjName + indexAarry[i]);
                  	}
                  	j = j + 1;
              	}

      	}
        return cellValue;
}

/**
 * 方法名:getSelectObjName
 * 参数:objName 组件的名字
 * 返回值:组件的显示值
 * 方法说明:获得页面中select组件的显示值
 * 调用示例如下:getSelectObjName("下拉框名字")
 */
function getSelectObjName(objName)
{
	var obj = eval("document.all('" + objName + "')");
      	var selfSelectedIndex = obj.selectedIndex;
      	selectObjName = obj[selfSelectedIndex].innerHTML;
      	if(selectObjName == "请选择"){
                selectObjName = "&nbsp;";
      	}
      	return selectObjName;
}

/**
 * 方法名:getObjType
 * 参数:objName 组件的名字
 * 返回值:组件的类型
 * 方法说明:获得页面中组件的类型
 * 调用示例如下:getObjType(objName)
 */
function getObjType(objName)
{
	var obj = eval("document.all('" + objName + "')");
    return obj.type;
}

/**
 * 方法名:getObjDisplayValue
 * 参数:objName 组件的名字
 * 返回值:组件的显示值
 * 方法说明:获得页面中组件的显示值，目前专为便捷增加修改
 * 调用示例如下:getObjDisplayValue(objName)
 */
function getObjDisplayValue(objName)
{
	var typeValue = getObjType(objName);
      	var displayValue;
      	if(typeValue == "select-one"){
                displayValue = getSelectObjName(objName);
      	}
      	else{
        	displayValue = getObjValue(objName);
      	}
      	return displayValue;
}

/**
 * 方法名:setObjValue
 * 参数:objName 要赋值的组件名字;objNameValue 要赋的值
 * 返回值:无
 * 方法说明:赋给页面中组件的值
 * 调用示例如下:setObjValue(objName,objNameValue)
 */
function setObjValue(objName,objNameValue)
{
	var obj = eval("document.all('" + objName + "')");
	if(!(typeof(obj)=="object"))return '';
	obj.value = objNameValue;
}

/**
 * 方法名:setNoChecked
 * 参数:objName Radio的名字
 * 返回值:无
 * 方法说明:使得grid中的radio都不被选中
 * 调用示例如下:setNoChecked(objName)
 */
function setNoChecked(objName)
{
  var objChk
  for(var i=0;i<getElementLen(objName);i++)
  {
          objChk=getObj(objName,i);
          objChk.checked = false;
  }
}

/**
 * 方法名:getPostValue
 * 参数:objName Checkbox或radio的名字
 * 返回值:字符串
 * 方法说明:组合选中对象的post值,如果是radio返回单个值，如果是checkbox返回多个用逗号隔开的值
 * 调用示例如下:getPostValue(objName)
 */
function getPostValue(objName){
  var objChk;
  var chkPostValue;
  var j=1;
  for(var i=0;i<getElementLen(objName);i++)
  {
          objChk=getObj(objName,i);
          if(objChk.checked&&(!objChk.disabled))
          {
                  if(j==1){
                  	chkPostValue = objName + "=" + objChk.value;
                  }
                  else{
                    	chkPostValue = chkPostValue + "&" + objName + "=" + objChk.value;
                  }
                  j = j + 1;
          }
  }
  return chkPostValue;
}

/**
 * 方法名:deleteRows
 * 参数:objName Checkbox或radio的名字
 * 返回值:无
 * 方法说明:根据选中的记录删除行,只是隐藏所删除的行
 * 调用示例如下:deleteRows(objName)
 */
function deleteRows(objName){
  var objChk;
  for(var i=0;i<getElementLen(objName);i++)
  {
          objChk=getObj(objName,i);
          if(objChk.checked&&(!objChk.disabled))
          {
                   eval("document.all.dataRow"+i).style.display = "none";
          }
  }
  return "1";
}

/**
 * 方法名:deleteRow
 * 参数:删除一行 obj:行对象；isHiddenRow:
 * 返回值:无
 * 方法说明:清空行里控件的值并根据条件是否隐藏行
 * 调用示例如下:deleteRow(obj,isHiddenRow)
 */
function deleteRow(obj,isHiddenRow)
{
  var cell = obj.parentElement;//取this父对象为CELL
  var row = cell.parentElement; //取cell父对象为ROW
  clearRow(row);//清除行中text的值
  if (isHiddenRow==true){
  	hideRow(row);//隐藏行
  }
  return true;
}

/**
 * 方法名:clearRow
 * 参数: obj:行对象
 * 返回值:无
 * 方法说明:清除一行中所有text的值
 * 调用示例如下:clearRow(obj)
 */
function clearRow(obj)
{
  var row= obj;
  var cellchildren;
   for (var j=0; j < row.cells.length; j++) {
       cellchildren = row.cells(j).children;
	    for(var m=0;m<cellchildren.length;m++)  {
	       var child = cellchildren(m);
	    	if (child.tagName=="INPUT") {
	    		if (child.name.indexOf("_lookupTableTitle_") < 0) {
	        		child.value = "";
	        	}
       		}
       		
       		//日期控件clear方法
       		if(child.className != 'undefined' && child.className == 'DPFrame') {
	          child.lastChild.value = "";
	        }
	        
	        //lookup控件clear方法
	        /*if( child.tagName == "INPUT" && child.lookupObject != 'undefined' && child.lookupObject){
	          child.lookupObject.onClean();
	        }*/
       	}
     }
     
     if(typeof UniEXT != 'undefined') {
     	var array = Ext.DomQuery.select('INPUT[extTagName=Lookup]', obj);
     	for(var i=0; i<array.length; i++) {
     		if(array[i].lookupObject)
     			array[i].lookupObject.onClean();
     	}
     }
	return true;
}

/**
 * 方法名:showRow
 * 参数: obj:行对象
 * 返回值:无
 * 方法说明:显示一行
 * 调用示例如下:showRow(obj)
 */
function showRow(obj)
{
   obj.style.display = "";
   return true;
}

/**
 * 方法名:hideRow
 * 参数: obj:行对象
 * 返回值:无
 * 方法说明:隐藏一行
 * 调用示例如下:hideRow(obj)
 */
function hideRow(obj)
{
  obj.style.display = "none";
  return true;
}

/**
 * 方法名:getAlldata
 * 参数:obj Form对象
 * 返回值:字符串
 * 方法说明:得到From中所有元素的NAME和值，并组成GET请求中要求的[name]=[value]&...[name]=[value]串
 * 调用示例如下:getAlldata(document.all.form[0])
 */
function getAlldata(obj){
    var data = "";
    for (i=0; i<obj.length; i++ ){
        if ( obj(i).type != "submit" && obj(i).type != "reset" && obj(i).type != "button"){
            if( obj(i).type == "select-multiple"){
                for(j=0; j<obj(i).length;j++){
                    if (obj(i).options[j].selected ){
                        data = data+obj(i).name+"="+replaceStr(obj(i).options[j].value)+"&";
                    }
                }
            }else if(obj(i).type =="radio" || obj(i).type =="checkbox"){
                if (obj(i).checked){
                    data=data+obj(i).name+"="+replaceStr(obj(i).value)+"&";

                }
            }else{
                data=data+obj(i).name+"="+replaceStr(obj(i).value)+"&";
            }
        }
    }
    return data.substr(0, data.length-1);
}

/**
 * 方法名:getChineseName
 * 参数:this 要获得当前输入对象的引用
 * 返回值:字符串
 * 方法说明:用来获得当前输入对象前面对应的中文名称
 * 调用示例如下:getChineseName(this)
 */
function getChineseName(objIn){
	var objParentTd = objIn.parentElement;
	if(objParentTd.tagName != "TD"){
		 objParentTd = objIn.parentElement.parentElement;
	}
	if((objParentTd.previousSibling != undefined) ||(objParentTd.previousSibling != null)){
		return objParentTd.previousSibling.innerText;
	}
	else{
		return "";
	}
}

/**
 * 方法名:getCaret
 * 参数:this 要获得当前输入对象的引用
 * 返回值:数字
 * 方法说明:取当前光标的位置
 * 调用示例如下:getCaret(this)
 */
function getCaret(textbox)
{
 var control = document.activeElement;
 textbox.focus();
 var rang = document.selection.createRange();
 rang.setEndPoint("StartToStart",textbox.createTextRange());
 control.focus();
 return rang.text.length;
}

/**
 * 方法名:getWholeTime
 * 参数:name 要获得当前输入对象的名字
 * 返回值:无
 * 方法说明:设置当前整个时间控件的值
 * 调用示例如下:getWholeTime(name)
 */
function getWholeTime(name)
{
  setObjValue(name,getObjValue(name+"_date") + " " + getObjValue(name+"_hms"));
}
/**---------------------------取值函数结束---------------------------------------*/




/**---------------------------操作函数开始---------------------------------------*/


/**
 * 方法名:execProc
 * 参数:procName 存储过程名;args 调用参数
 * 返回值:字符串类型，多返回值以逗号分割。如果调用出错，返回-1。
 * 方法说明:利用xmlhttp方式到后台去调用存储过程
 * 调用示例如下:execProc("PRC_GET_ROW_ID_1","2004-11-19:DATE:INT,DATE")
 */
function execProc(procName,args)
{
   var xml = new ActiveXObject("MSXML2.XMLHTTP.4.0");
   postPara="doWhat=executeProcedure&args="+procName+":"+args
   xml.open("POST", "../../../../CommonAction.do?", false);
   xml.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded");
   xml.send(URLEncoding(postPara));
   return xml.responseText;

}


/**
 * 方法名:execUpdate
 * 参数:sql SQL语句
 * 返回值:字符串类型，返回0表示执行成功，返回1表示执行失败。如果调用出错，返回-1。
 * 方法说明:执行更新操作SQL函数;sql 要执行的SQL,只支持更新操作SQL,如增加、删除、修改，使用SQL 语法
 * 调用示例如下:execUpdate("INSERT INTO AD_LOV_CODE(row_id,lov_code) VALUES ('1234567','123466')")
 */
function execUpdate(sql)
{
   var xml = new ActiveXObject("MSXML2.XMLHTTP.4.0");
   eval("sql=sql.replace( /"+"="+"/g, '"+EQUAL_FLAG+"')");

   postPara="doWhat=executeUpdate&args="+sql;
   xml.open("POST", "../../../../CommonAction.do?", false);
   xml.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded");
   xml.send(URLEncoding(postPara));

   return xml.responseText;

}


/**
 * 方法名:fhiddenifLookupTB
 * 参数:无
 * 返回值:无
 * 方法说明:用于隐藏页面上的lookup的iframe.
 * 调用示例如下:fhiddenifLookupTB()
 */
function fhiddenifLookupTB()
{
  document.all.ifLookupTB.style.visibility = 'hidden';
  document.all.ifLookupTB.style.pixelTop = 1;
  document.all.ifLookupTB.style.pixelLeft = 1;
  document.all.ifLookupTB.style.pixelHeight = 1;
  document.all.ifLookupTB.style.pixelWidth = 1;
}


/**
 * 方法名:validDocStatus
 * 参数:无
 * 返回值:页面状态值true 或者 false
 * 方法说明:当页面以POST方式进行提交时,可以通过此方法,判断页面状态
 * 调用示例如下:Var status = validDocStatus(); Status 为 true or false
 */
function validDocStatus()
{
  if(document.readyState=="loading")
  {
     alert("程序正在处理，请等待程序处理结束！");
     return false;
  }
  return true;
}


/**
 * 方法名:fhiddenParifLookupTB
 * 参数:无
 * 返回值:无
 * 方法说明:用于隐藏页面上的lookup的iframe.并且清除页面上iframe里面的页面
 * 调用示例如下:fhiddenParifLookupTB()
 */
function fhiddenParifLookupTB()
{
  parent.document.all.ifLookupTB.style.visibility = 'hidden';
  parent.document.all.ifLookupTB.style.pixelTop = 1;
  parent.document.all.ifLookupTB.style.pixelLeft = 1;
  parent.document.all.ifLookupTB.style.pixelHeight = 1;
  parent.document.all.ifLookupTB.style.pixelWidth = 1;
  parent.document.all.ifLookupTB.src='';
}


/**
 * 方法名:fLookupTB
 * 参数:objSender 要显示iframe的页面控件;strUrl 要显示在iframe里面的strUrl;width 显示的iframe的页面的长度;height 显示的iframe的页面的高度
 * 返回值:无
 * 方法说明:用于显示页面上的lookup的iframe
 * 调用示例如下:fLookupTB(this," http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do",400,300)
 */
function fLookupTB(objSender,strUrl,width,height){
var top = objSender.offsetTop+objSender.offsetHeight;
var left = objSender.offsetLeft;
if (document.all.ifLookupTB.style.visibility == 'hidden')
  {
  document.all.ifLookupTB.src =strUrl;
  document.all.ifLookupTB.style.pixelWidth = 300;
  document.all.ifLookupTB.style.pixelHeight = 300;
  for (objSender=objSender.offsetParent; objSender != null; objSender=objSender.offsetParent) {
    top = objSender.offsetTop + top;
    left = objSender.offsetLeft + left;
  }
  document.all.ifLookupTB.style.pixelTop= top;
  document.all.ifLookupTB.style.pixelLeft = left;
  document.all.ifLookupTB.style.visibility = '';
  document.all.ifLookupTB.focus();
  }
  else
  {
  document.all.ifLookupTB.style.visibility = 'hidden';
  document.all.ifLookupTB.style.pixelTop = 1;
  document.all.ifLookupTB.style.pixelLeft = 1;
  document.all.ifLookupTB.style.pixelHeight = 1;
  document.all.ifLookupTB.style.pixelWidth = 1;
  }
}


/**
 * 方法名:fhiddenifListBox
 * 参数:无
 * 返回值:无
 * 方法说明:用于隐藏页面上listBox的iframe
 * 调用示例如下:fhiddenifListBox()
 */
function fhiddenifListBox()
{
  document.all.ifListBox.style.visibility = 'hidden';
  document.all.ifListBox.style.pixelTop = 1;
  document.all.ifListBox.style.pixelLeft = 1;
  document.all.ifListBox.style.pixelHeight = 1;
  document.all.ifListBox.style.pixelWidth = 1;
}


/**
 * 方法名:fhiddenParifListBox
 * 参数:无
 * 返回值:无
 * 方法说明:用于隐藏页面上listBox的iframe,并且清除iframe里面的页面
 * 调用示例如下:fhiddenParifListBox()
 */
function fhiddenParifListBox()
{
  parent.document.all.ifListBox.style.visibility = 'hidden';
  parent.document.all.ifListBox.style.pixelTop = 1;
  parent.document.all.ifListBox.style.pixelLeft = 1;
  parent.document.all.ifListBox.style.pixelHeight = 1;
  parent.document.all.ifListBox.style.pixelWidth = 1;
  parent.document.all.ifListBox.src='';
}


/**
 * 方法名:fListBox
 * 参数:objSender 要显示iframe的页面控件;strUrl Iframe里面所显示的页面;width Iframe的宽度;height Iframe的高度
 * 返回值:无
 * 方法说明:显示页面上的listBox的iframe
 * 调用示例如下:fListBox(this," http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do",400,200)
 */
function fListBox(objSender,strUrl,width,height)
{
var top = objSender.offsetTop+objSender.offsetHeight;
var left = objSender.offsetLeft;
if (document.all.ifListBox.style.visibility == 'hidden')
  {
  document.all.ifListBox.src =strUrl;
  document.all.ifListBox.style.pixelWidth = width;
  document.all.ifListBox.style.pixelHeight = height;
  for (objSender=objSender.offsetParent; objSender != null; objSender=objSender.offsetParent) {
    top = objSender.offsetTop + top;
    left = objSender.offsetLeft + left;
  }
  document.all.ifListBox.style.pixelTop= top;
  document.all.ifListBox.style.pixelLeft = left;
  document.all.ifListBox.style.visibility = '';
  document.all.ifListBox.focus();
  }
  else
  {
  document.all.ifListBox.style.visibility = 'hidden';
  document.all.ifListBox.style.pixelTop = 1;
  document.all.ifListBox.style.pixelLeft = 1;
  document.all.ifListBox.style.pixelHeight = 1;
  document.all.ifListBox.style.pixelWidth = 1;
  }
}



/**
 * 方法名:getShowRowCount
 * 参数:obj 表对象
 * 返回值:总行数
 * 方法说明:当前表格中,去掉隐藏行后的总行数
 * 调用示例如下:getShowRowCount(obj)
 */
function getShowRowCount(obj)
{
  var table = eval(obj);
  var maxShow=0;
  for (i=0; i < table.rows.length; i++)
     {
   		var t= table.rows(i);
   		if (t.style.display != "none")
   		  maxShow=maxShow+1;
     }
   return  maxShow;
}


/**
 * 方法名:sumCol
 * 参数:obj 要汇总的表格的名字;prefix 前缀: 要汇总列的列名的前缀;sumColName 汇总列的列名;setColName 存放汇总值的列名;nDec 汇总值的精度
 * 返回值:无
 * 方法说明:汇总指定表格中的指定sumColName的值到setColName
 * 调用示例如下:sumCol("dataTable","orderDetail","quantOrder","totQuantOrder",0)
 */
function sumCol(obj,prefix,sumColName,setColName,nDec)
{
   var colname ="";
   var nRow;		// Various table stats
   var table;				// Table object
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
	for (var i=0; i<nRow; i++)
	{
      if(prefix!="")
      {
        colname = prefix+"[" + i + "]." + sumColName;
      }
      colValue = document.forms[0].elements[colname].value;
      if (checkNumber(colValue))
        {
          if (colValue == "") { colValue =0;}
          sumValue = parseFloat(sumValue) + parseFloat(colValue);
         }
      else
      	{
          sumValue = -1;
          break;
        }
    }
   document.forms[0].elements[setColName].value =  FormatNumber(parseFloat(sumValue),nDec);
}


/**
 * 方法名:setFocus
 * 参数:prefix 列名的前缀;id 第几行;col 列名
 * 返回值:无
 * 方法说明:移动光标到表格的指定行的,指定的字段
 * 调用示例如下:setFocus("orderDetail",id,"quantOrder")
 */
function setFocus(prefix,id,col)
{

    var colname ="";
    if((id>=0)&&(prefix!=""))
      colname = prefix+"[" + id + "]." + col;
    else
      colname = col;
    var focusControl = document.forms[0].elements[colname];

    if (typeof(focusControl)!="object")
         return false;
    if (focusControl.type == "hidden")
        return false;
    try{
    focusControl.focus();
    if (focusControl.tagName=="INPUT")
      focusControl.select();
    }
    catch(e){

        }

    return true;
}


/**
 * 方法名:httpGet
 * 参数:http Xmlhttp对象;url 要检测页面的URL
 * 返回值:整个页面的HTML或者为空字符串
 * 方法说明:利用xmlhttp对象去判断相应的URL所指向的页面,是否存在
 * 调用示例如下:httpGet(xmlhttp," http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do")
 */
function httpGet(http,url)
{
   var strRet = "";
   if(url.length!=0)
   {
        http.open("GET",url,false);
        http.send();
        strRet = http.responseText;
    }
    strRet = trimNC(strRet);
    if (strRet.length==0)
	{
		 alert("系统查询失败！");
         return "";
	}
    return strRet;
}

/**
 * 方法名:openDialog
 * 参数:WINurl 窗口里页面的url;WINwidth 窗口的宽度;WINheight 窗口的高度;xyPosition 打开窗口位置
 * 返回值:无
 * 方法说明:指定弹出位置打开模态窗口 xyPosition 为 0时, 在屏幕中央打开模态窗口 xyPosition 不为 0 时,在事件源附近打开模态窗口
 * 调用示例如下:openDialog(" http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do",400,300,0)
 */
function openDialog(WINurl,WINwidth,WINheight,xyPosition)
{
 if(xyPosition==0)//屏幕中央
   {
    showx = (window.screen.availWidth  - WINwidth)/2;
    showy = (window.screen.availHeight - WINheight)/2;
   }
 else//事件附近
   {
	   showx = event.screenX - event.offsetX - 4 - WINwidth ; // + deltaX;
	   showy = event.screenY - event.offsetY + 18; // + deltaY;
	  }
	newWINwidth = WINwidth + 4 + 18;
	var features =
		'dialogWidth:'  + newWINwidth  + 'px;' +
		'dialogHeight:' + WINheight + 'px;' +
		'dialogLeft:'   + showx     + 'px;' +
		'dialogTop:'    + showy     + 'px;' +
		'directories:no; localtion:no; menubar:no; status=no; toolbar=no;scrollbars:yes;Resizeable=no';
	var vDialog = window.showModalDialog(WINurl, " ", features);
	return vDialog;
}

/**
 * 方法名:ExportExcel
 * 参数:无
 * 返回值:无
 * 方法说明:利用华表的CELL组件,导出为excel
 * 调用示例如下:ExportExcel()
 */
function ExportExcel()
{
  var cell1;
  cell1=document.all("objCellID");
  cell1.DoExportExcelFile("");

}


/**
 * 方法名:onprint
 * 参数:无
 * 返回值:无
 * 方法说明:利用华表的CELL组件,进行打印
 * 调用示例如下:onprint()
 */
function onprint()
{
  var cell1;
  cell1=document.all("objCellID");
  cell1.DoPrint(1);
}

/**
 * 方法名:onprintpreview
 * 参数:无
 * 返回值:无
 * 方法说明:利用华表的CELL组件,进行打印预览
 * 调用示例如下:onprintpreview()
 */
function onprintpreview()
{
  var cell1;
  cell1=document.all("objCellID");
  cell1.DoPrintPreview(1);
}

/**
 * 方法名:affixmanage
 * 参数:无
 * 返回值:无
 * 方法说明:附件管理按钮方法：用于传递参数，打开模态窗口
 * 调用示例如下:affixmanage()
 */
function affixmanage(){
  	//判断是否选中记录；
  	if(hasSelectedRecord('chk'))
    	{
              	//获取主表隐藏字段的值；
              	main_table_code = getObjValue("main_table_code");
              	//获取选中记录的row_id值；
		record_id = getCheckedValue('chk');
  		str = "table_code=" + main_table_code + "&record_id=" + record_id
              	//打开附件管理的模态窗口；
              	window.showModalDialog('../../../../lightclient/services/filemgr/FilemanagerList.do?'+str,self,'help:no;status:no;dialogWidth:' + (availWidthScreen-availWidthScreenDifference)
    		+'px;dialogHeight:' + (availHeightScreen-availHeightScreenDifference) + 'px;');
    	}
    	else{
        	alert("请选择记录！");
    	}
}

/**
 * 方法名:setInputFocus
 * 参数:objName 要置焦的控件的名字
 * 返回值:无
 * 方法说明:给指定控件置焦点
 * 调用示例如下:setInputFocus("objName")
 */
function setInputFocus(objName){
  	var obj = eval("document.all('" + objName + "')");
    if(obj.style.display == "none") {
    }else {
      obj.focus();
    }

}

/**
 * 方法名:tabChange
 * 参数:tabIndex 要切换的tab页数;tabTotal Tab页的总数
 * 返回值:无
 * 方法说明:用于定制的多tab明细之间的切换
 * 调用示例如下:tabChange(3,5)
 */
function tabChange(tabIndex,tabTotal) {
	var obj = eval("document.all.tab" + tabIndex);

	for(var i=1;i<tabTotal+1;i++){
		eval("document.all.tab" + i).style.display='none';
	}
	obj.style.display='';
	return;
}


/**
 * 方法名:onRowMouseOver
 * 参数:trHandle 行对象
 * 返回值:无
 * 方法说明:当鼠标移动到某一行时，改变这一行所有的元素的背景色
 * 调用示例如下:onRowMouseOver(trHandle) trHandle为要改变变背景色的行对象引用
 */
function onRowMouseOver(trHandle){
  trHandle.style.backgroundColor='#F1F1F1';
  var td = trHandle.cells;

  for(var i = 0;i<td.length;i++){
    var objsInTD = td[i].childNodes;
    for(var j = 0;j<objsInTD.length;j++){
    	try{
      	  objsInTD[j].style.backgroundColor ='#F1F1F1' ;
	}catch(e){

	}
    }
  }
}

/**
 * 方法名:onRowMouseOut
 * 参数:trHandle 行对象
 * 返回值:无
 * 方法说明:当鼠标离开某一行时，恢复这一行所有的元素的背景色
 * 调用示例如下:onRowMouseOut(trHandle) trHandle为要恢复背景色的行对象的引用
 */
function onRowMouseOut(trHandle){
  trHandle.style.backgroundColor='';
  var td = trHandle.cells;

  for(var i = 0;i<td.length;i++){
    var objsInTD = td[i].childNodes;
    for(var j = 0;j<objsInTD.length;j++){
    	try{
      	  objsInTD[j].style.backgroundColor ='' ;
	}catch(e){

	}
    }
  }
  }

/**
 * 方法名:sortGrid
 * 参数:obj 要排序的图标对象;fName 要排序的控件的名字;mode 页面的类型是view 还是 edit
 * 返回值: 无
 * 方法说明:对grid 进行页面的当页排序
 * 调用示例如下:sortGrid(this,"userName","view")
 */
function sortGrid(obj,fName,mode) {
   var objGridTable = document.all.dataTable;
   var objAllRows = objGridTable.rows;
   if(obj.alt=='升序') {
     for(var i = 1; i < objGridTable.rows.length;i++) {
       for(var j = 1; j < objGridTable.rows.length-i; j++) {
     	 if(getGridCompareValue(objAllRows,j,fName,mode) > getGridCompareValue(objAllRows,j+1,fName,mode)) {
     	   objGridTable.moveRow(j,j+1);
     	 }
        }
     }
     obj.alt="降序";
     obj.src=ctx + "/images/sortDown.gif";
   }else if(obj.alt=='降序') {
     for(var i = 1; i < objGridTable.rows.length;i++) {
       for(var j = 1; j < objGridTable.rows.length-i; j++) {
         if(getGridCompareValue(objAllRows,j,fName,mode) < getGridCompareValue(objAllRows,j+1,fName,mode)) {
           objGridTable.moveRow(j,j+1);
     	  }
       }
      }
      obj.alt="升序";
      obj.src=ctx + "/images/sortUp.gif";
   }
}


/**
 * 方法名:string2date
 * 参数:strDate 要格式化的字符串
 * 返回值:Date类型
 * 方法说明:将一个字符串格式的日期转变为日期形式
 * 调用示例如下:string2date("2004/2/9")
 */
function string2date(strDate)
{
    var dateArray;
    var backDate;

    dateArray=strDate.split("/");
    backDate=new Date();
    backDate.setFullYear(dateArray[0],dateArray[1],dateArray[2]);
    return backDate;
}


/**
 * 方法名:getTrimText
 * 参数:textfield 控件text对象
 * 返回值:无
 * 方法说明:过滤掉控件text的前后空格，并返回新值
 * 调用示例如下:getTrimText(textfield) textfield为要过滤的对象
 */
function getTrimText(textfield)
{
  var value = textfield.value;
  textfield.value = trim(value);

  return textfield.value;
}

/**
 * 方法名:setMainFocus
 * 参数:col 为要置焦的对象
 * 返回值:无
 * 方法说明:用户按回车键时,设置光标到下一个控件,置焦.
 * 调用示例如下:setMainFocus(col) col为要置焦的对象
 */
function setMainFocus(col)
{
   var keyCode=window.event.keyCode;
   if(keyCode==13||window.event.type=='propertychange')
   {
      var obj=document.getElementById(col);
      if(obj)
      {
          if(obj.tagName=='IMG'){
            obj.click();
          }else{
            obj.focus();
          }
      }
   }
}

/**
 * 方法名:disableTable
 * 参数:obj 要disable的表对象
 * 返回值:无
 * 方法说明:将表格中的所有行,列都disable使用户不能选择
 * 调用示例如下:disableTable(obj) obj为表对象
 */
function disableTable(obj)
{
  var table;
  if (obj  != "")	table = eval(obj);  // Assumes that the obj is THE OBJECT
  else return false;
  if (table == null) return false;;  // Check whether it's an object
  if (table.tagName != "TABLE") return false;;  // Check whether it's a table
  for (i=0; i < table.rows.length; i++) {
        for (j=0; j < table.rows(i).cells.length; j++) {
            disableRow(table.rows(i));
        }
   }
   return true;
}

/**
 * 方法名:disableRow
 * 参数:obj 行对象引用
 * 返回值:无
 * 方法说明:将一行中所有input 控件disable.
 * 调用示例如下:disableRow(obj),obj为行对象引用
 */
function disableRow(obj)
{
  var row= obj;
  var cellchildren;
   for (j=0; j < row.cells.length; j++) {
       cellchildren = row.cells(j).children;
	    for(m=0;m<cellchildren.length;m++)  {
	       var child = cellchildren(m);
	    	if (child.tagName=="INPUT") {
            child.disabled=true;
       		}
       	}
     }
	return true;
}


/**
 * 方法名:clearTable
 * 参数:obj 要清除值的表对象
 * 返回值:无
 * 方法说明:清除表格中所有text域的值
 * 调用示例如下:clearTable(obj),obj为表对象引用
 */
function clearTable(obj)
{
  var table;
  if (obj  != "")	table = eval(obj);  // Assumes that the obj is THE OBJECT
  else return false;
  if (table == null) return false;;  // Check whether it's an object
  if (table.tagName != "TABLE") return false;;  // Check whether it's a table
  for (i=0; i < table.rows.length; i++) {
        for (j=0; j < table.rows(i).cells.length; j++) {
            clearRow(table.rows(i));
        }
   }
   return true;
}

/**
 * 方法名:enterToTab
 * 参数:无
 * 返回值:无
 * 方法说明:将回车键转换成TAB
 * 调用示例如下:enterToTab()
 */
function enterToTab(){
  if(event.srcElement.type != 'button' && event.srcElement.type != 'textarea' && event.keyCode == 13){
    event.keyCode = 9;
  }
}

/**
 * 方法名:changeCheckboxDisplayValue
 * 参数:obj 对象的控件;checkValue 选中时的值;unCheckValue 不选中时的值
 * 返回值:无
 * 方法说明:改变隐藏控件的值
 * 调用示例如下:changeCheckboxHiddenValue(this,1,0)
 */
function changeCheckboxHiddenValue(obj,checkValue,unCheckValue) {
	var objhidden = document.getElementById(obj.name.replace("checkbox_", ""));
	if(obj.checked == true) {
		objhidden.value = checkValue;
	}
	if(obj.checked == false) {
		objhidden.value = unCheckValue;
	}
}

/**
 * 方法名:Checkbox_OnPropertyChange
 * 参数:obj 对象的控件;checkValue 选中时的值;unCheckValue 不选中时的值
 * 返回值:无
 * 方法说明:改变checkbox的选择状态
 * 调用示例如下:Checkbox_OnPropertyChange(this,1,0)
 */
function Checkbox_OnPropertyChange(obj,checkValue,unCheckValue) {

	var objdisplay ;
    objdisplay = document.getElementById("checkbox_" + obj.name);
	if (obj.value == checkValue) {
		objdisplay.checked = true;
	}
	if (obj.value == unCheckValue) {
		objdisplay.checked = false;
	}

}

/**
 * 方法名:selectToInput
 * 参数:obj 对象的控件
 * 返回值:无
 * 方法说明:当SELECT控件为只读时,使得select控件值与隐藏的input域里的值同步
 * 调用示例如下:selectToInput(this)
 */
function selectToInput(obj) {
  var objOption;
  for (i=0; i< obj.options.length; i++)
    if(obj.options(i).value == obj.value){
      objOption = obj.options(i);
    }
  var objCode = document.getElementById(obj.name.replace("sel_", ""));
  var objName = document.getElementById("dis_" + obj.name.replace("sel_",""));

  objCode.value = objOption.value;
  objName.value = objOption.text;

}

/**
 * 方法名:codeInputToSelect
 * 参数:obj 对象的控件;
 * 返回值:无
 * 方法说明:当SELECT控件为只读时,使得隐藏的input域里的值与select控件值同步
 * 调用示例如下:codeInputToSelect(this)
 */
function codeInputToSelect(obj) {

  var objOption;
  if (obj.name.indexOf("].")>0) {
  	  var strNames = obj.name.split("].");
  	  objSel = document.getElementById(strNames[0]+"]."+"sel_"+strNames[1]);
      objName= document.getElementById(strNames[0]+"]."+"dis_" + strNames[1]);
  }else{
  	  objSel = document.getElementById("sel_"+obj.name);
      objName= document.getElementById("dis_" + obj.name);
  }

  for (i=0; i< objSel.options.length; i++)
    if(objSel.options(i).value == obj.value){
      objOption = objSel.options(i);
    }
	if (objOption != null) {
		objSel.value = objOption.value;
	  objName.value = objOption.text;
	}
	if (objOption == null) {
		alert("隐藏控件的值与下拉框里的值不对应!!! ");
	}

}

/**
 * 方法名:radioInputToRadio
 * 参数:obj 对象的控件;
 * 返回值:无
 * 方法说明:使得隐藏的input域里的值与radiogroup控件值同步
 * 调用示例如下:radioInputToRadio(this)
 */
function radioInputToRadio(obj) {

	var objName = obj.name;
	var objRadios;
	var disObj;

    if (obj.name.indexOf("].")>0) {
  	  var strNames = obj.name.split("].");
  	  objRadios = document.all("radio_"+strNames[0]+"]." + strNames[1]);
	  disObj = document.getElementById(strNames[0]+"]."+"dis_" + strNames[1]);
    }else{
  	  objRadios = document.all("radio_"+objName);
	  disObj = document.getElementById("dis_"+objName);
	}

	var radioObj;
	var flag = false;
	for(var i=0;i<objRadios.length;i++){
	  radioObj = objRadios(i);
	  if (radioObj.value==obj.value) {
	  	radioObj.checked = true;
	  	disObj.value = radioObj.nextSibling.innerHTML;
	  	flag = true;
	  	break;
	  }else {
	  	//alert("没有批配的值!!!");
	  }
	}
	if (flag == false) {
		alert("没有批配的值!!!");
	}

}

/**
 * 方法名:radioToRadioInput
 * 参数:obj 对象的控件;
 * 返回值:无
 * 方法说明:使得radiogroup控件值与隐藏的input域里的值同步
 * 调用示例如下:radioToRadioInput(this)
 */
function radioToRadioInput(obj) {
	//return true;
	var objName = obj.name;
	var objInput = document.getElementById(objName.replace("radio_",""));

	var disObj;
    if (obj.name.indexOf("].")>0) {
  	  var strNames = obj.name.replace("radio_","").split("].");
  	  disObj = document.getElementById(strNames[0]+"]."+"dis_" + strNames[1]);

    }else{
  	  disObj = document.getElementById("dis_"+objName.replace("radio_",""));
	}
	objInput.value = obj.value;
	disObj.value = obj.nextSibling.innerHTML;
}
/**
 * 方法名:checkboxTocheckboxInput
 * 参数:obj 对象的控件;
 * 返回值:无
 * 方法说明:使得checkboxgroup控件值与隐藏的input域里的值同步
 * 调用示例如下:checkboxTocheckboxInput(this)
 */
function checkboxTocheckboxInput(obj) {

	var objName = obj.name;
	var objInput = document.getElementById(objName.replace("checkbox_",""));

    var disObj;
    if (obj.name.indexOf("].")>0) {
  	  var strNames = obj.name.replace("checkbox_","").split("].");
  	  disObj = document.getElementById(strNames[0]+"]."+"dis_" + strNames[1]);

    }else{
  	  disObj = document.getElementById("dis_"+objName.replace("checkbox_",""));
	}

	var objs = document.all(objName);
	var checkboxObj;
	var strValue = "";
	var strName = "";
	for(var i=0;i<objs.length;i++) {
		checkboxObj = objs(i);
		if (checkboxObj.checked == true) {
			strValue = strValue +","+ checkboxObj.value;
			strName = strName +","+ checkboxObj.nextSibling.innerHTML;
		}
	}

	strValue = strValue.substr(1,strValue.length-1);
	strName = strName.substr(1,strName.length-1);
	objInput.value = strValue;
	disObj.value = strName;
}

/**
 * 方法名:checkboxInputTocheckbox
 * 参数:obj 对象的控件;
 * 返回值:无
 * 方法说明:使得隐藏的input域里的值与checkboxgroup控件值同步
 * 调用示例如下:checkboxInputTocheckbox(this)
 */
function checkboxInputTocheckbox(obj) {
	var objName = obj.name;
	var objs = document.all("checkbox_"+objName);
	var disObj = document.getElementById("dis_"+objName);

    if (obj.name.indexOf("].")>0) {
  	  var strNames = obj.name.split("].");
  	  objs = document.all(strNames[0]+"]."+"checkbox_" + strNames[1]);
	  disObj = document.getElementById(strNames[0]+"]."+"dis_" + strNames[1]);
    }else{
  	  objs = document.all("checkbox_"+objName);
	  disObj = document.getElementById("dis_"+objName);
	}


	var strValues = obj.value.split(',');
	var checkboxObj;
	var flag = false;
	var strName = "";
	for(var j=0;j<objs.length;j++){
		objs(j).checked = false;
	}
	for (var i= 0;i<strValues.length;i++) {
		for(var j=0;j<objs.length;j++){
	    checkboxObj = objs(j);
	    if(strValues[i] == checkboxObj.value) {
	    	checkboxObj.checked = true;
	    	strName = strName + "," + checkboxObj.nextSibling.innerHTML;
	    	//alert(strValues[i]);
	    	break;
	    }
	  }
	}
	strName = strName.substr(1,strName.length-1);
	disObj.value = strName;
	if (flag == false) {
	//	alert("没有批配的值!!!");
	}

}
/**
 * 方法名:exec
 * 参数:url 提交的路径;postPara 传递的参数
 * 返回值:xmlhttp.responseText 状态标志位
 * 方法说明:将postPara作为传递的参数,调用url
 * 调用示例如下:exec("xxxAcition?",postPara)
 */
function exec(url,postPara)
{

  //var xmlhttp = new ActiveXObject("MSXML2.XMLHTTP.4.0");
  xmlhttp.open("POST", url, false);
  xmlhttp.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
  xmlhttp.send(postPara);
  return xmlhttp.responseText;
}
/**
 * 方法名:xmlInvoke
 * 参数:url 提交的路径
 * 返回值:returnText 
 * 方法说明:xmlHttp调用的通用函数
 * 
 */
function xmlInvoke(url) {
    var xmlObj;
    try {
          xmlObj = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch(e) {
        try{
            xmlObj = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch(e) {
            try{
               xmlObj = window.XMLHttpRequest();
            }
            catch(e) {
            }
         }
     }
     xmlObj.open("GET", url, false);
     xmlObj.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");  //设置content type，作为表单数据发送
     xmlObj.send();
     var returnText = xmlObj.responseText;
     return returnText;
}

function parseGrid(title){
	var maintbl = document.getElementById("maintbl");
	var vdata = [];
	var rl = maintbl.rows.length;
	for (i=1; i < rl; i++) {
		var cl = maintbl.rows(i).cells.length;
		var o = new Object();
        for (j=1; j < cl; j++) {
             var vt =    maintbl.rows(i).cells(j).innerHTML;
             o[title[j]]=vt;
        }
       vdata.push(o);
   }
   return vdata;
}

function sortByColumn(columnName){	
	    var url = window.location.href;
	    if(document.forms[0].action!=null&&document.forms[0].action!="")
	    	url = document.forms[0].action;
	    if(url.search("sortFieldName") < 0){
	    	if(url.split("?").length>0)
	    	   url += "&sortFieldName=" + columnName;
	    	else
	    	   url += "?&sortFieldName=" + columnName;
	    }//the parameter sortFieldName is not found in the query string        
	    if(url.search(new RegExp("(sortFieldName=).*&")) > 0){  //sortFieldName is not the last parameter in query string
	        document.forms[0].action = url.replace(new RegExp("(sortFieldName=).*&"), "sortFieldName=" + columnName + "&");
	    }
	    else
		    document.forms[0].action = url.replace(new RegExp("(sortFieldName=).*"), "sortFieldName=" + columnName);
	    
	    document.forms[0].submit();
}

//--base64
var base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var base64DecodeChars = new Array(
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
    52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
    -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
    15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
    -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
    41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
    
function encodeto64(str) {
  str = utf16to8(str);
  str = base64encode(str);
  return str;
}

function utf16to8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for(i = 0; i < len; i++) {
 c = str.charCodeAt(i);
 if ((c >= 0x0001) && (c <= 0x007F)) {
     out += str.charAt(i);
 } else if (c > 0x07FF) {
     out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
     out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
     out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
 } else {
     out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
     out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
 }
    }
   
    return out;
}

function base64encode(str) {
    var out, i, len;
    var c1, c2, c3;

    len = str.length;
    i = 0;
    out = "";
    while(i < len) {
 c1 = str.charCodeAt(i++) & 0xff;
 if(i == len)
 {
     out += base64EncodeChars.charAt(c1 >> 2);
     out += base64EncodeChars.charAt((c1 & 0x3) << 4);
     out += "==";
     break;
 }
 c2 = str.charCodeAt(i++);
 if(i == len)
 {
     out += base64EncodeChars.charAt(c1 >> 2);
     out += base64EncodeChars.charAt(((c1 & 0x3)<< 4) | ((c2 & 0xF0) >> 4));
     out += base64EncodeChars.charAt((c2 & 0xF) << 2);
     out += "=";
     break;
 }
 c3 = str.charCodeAt(i++);
 out += base64EncodeChars.charAt(c1 >> 2);
 out += base64EncodeChars.charAt(((c1 & 0x3)<< 4) | ((c2 & 0xF0) >> 4));
 out += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >>6));
 out += base64EncodeChars.charAt(c3 & 0x3F);
    }
    return out;
}

function fShowMsg(strMsg,autoHidden)
{
  var icon=1;
  var msg="没有返回信息！";
  icon  = strMsg.split(':')[0];
  msg = strMsg.split(':')[1];
  if(icon.length<1)
  {
    icon = 4;
    msg = strMsg;
  }
  fShowMessage(icon,msg,autoHidden)
}
function fShowMessage(icon,strMsg,autoHidden)
{
  if(strMsg.length>0)
  {
      dlblShowMessage.style.visibility='visible';
      dlblShowMessage.style.left=(window.screen.width*0.4)/2+100;
      dlblShowMessage.style.top=document.body.scrollTop+160;
      lblShowMessage1.innerHTML=strMsg;

      document.all.chenggong.style.display = 'none';
      document.all.chucuo.style.display = 'none';
      document.all.info.style.display = 'none';
      document.all.yanzhongcuowu.style.display = 'none';
      document.all.working.style.display = 'none';
      document.all.closediv.style.display = 'none';
      if (icon==1) document.all.chenggong.style.display = '';
      if (icon==2) document.all.chucuo.style.display = '';
      if (icon==3) document.all.info.style.display = '';
      if (icon==4) document.all.yanzhongcuowu.style.display = '';
      if (icon==5)
      {
        document.all.info.style.display = '';
        document.all.working.style.display = '';
        autoHidden = 0 ;
      }
  if ((autoHidden==1)&&(icon!=4))
  {
       if (document.images)
        {
            parselimit=limit.split(":");
            parselimit=parselimit[0]*60+parselimit[1]*1+1;
        }
         fTimeHidden()
  }
  else if(icon !=5) document.all.closediv.style.display = '';
  }
}

function fHiddenMessage()
{
  dlblShowMessage.style.visibility='hidden';
}
function fTimeHidden()
{
    if (!document.images)    return;
    if (parselimit==1)
        fHiddenMessage()
    else{
        parselimit-=1;
        curmin=Math.floor(parselimit/60);
        cursec=parselimit%60;
        if (curmin!=0)
            curtime=curmin+"分"+cursec+"秒！"
        else
            curtime=cursec+"秒！";
        lblShowSeconds.innerHTML=curtime;
//        window.status=curtime;
        setTimeout("fTimeHidden()",1000);
    }
}

function fShowMessage1(strMsg)
{
  dlblShowMessage.style.visibility='visible';
  dlblShowMessage.style.left=(window.screen.width*0.4)/2+20;
  dlblShowMessage.style.top=document.body.scrollTop+160;
  lblShowMessage1.outerHTML=strMsg;
}


function checkNumberPlusFiliale(str){
 var i;
    var len = str.length;
    var chkStr = "-1234567890,.";
    if (len == 1) {
	if (chkStr.indexOf(str.charAt(i)) < 0) {
	    return false;
	}
    } else {
	if ((chkStr.indexOf(str.charAt(0)) < 0) || ((str.charAt(0) == "0")&&(str.charAt(1)!="."))) {
	    return false;
	}
	 for (i = 1; i < len; i++) {
		if (chkStr.indexOf(str.charAt(i)) < 0) {
			    return false;
		}
	}
    }
    return true;
}

//数字格式化函数
function FormatNumber(srcStr,nAfterDot){
    var srcStr,nAfterDot;
    var resultStr,nTen;
    srcStr = ""+srcStr+"";
    var strLen = srcStr.length;
    dotPos = srcStr.indexOf(".",0);
    if (dotPos == -1){
       if (nAfterDot==0) return  srcStr;
        resultStr = srcStr+".";
        for (i=0;i<nAfterDot;i++){
            resultStr = resultStr+"0";
        }
        return resultStr;
    } else {
         if ((strLen - dotPos - 1) > nAfterDot){
              nAfter = dotPos + nAfterDot + 1;
              nTen =1;
              for(j=0;j<nAfterDot;j++){
                   nTen = nTen*10;
              }
              resultStr = Math.round(parseFloat(srcStr)*nTen)/nTen;
                  return resultStr;
          }else{
              resultStr = srcStr;
              for (i=0;i<(nAfterDot - strLen + dotPos + 1);i++){
                  resultStr = resultStr+"0";
              }
              return resultStr;
          }
     }
 }

//GRID面板扩展折叠
function grid_display(obj) {
	var gridExpandFlag = getObjValue("gridExpandFlag");
	var displayType = "";
	if (gridExpandFlag == "1") {
		displayType = "none";
		setObjValue("gridExpandFlag","0");
		obj.src = ctx + "/images/expand_arrow.jpg";
		obj.alt = "展开";
		window.lcfGridTable.style.display = displayType;
	}else {
		displayType = "";
		setObjValue("gridExpandFlag","1");
		obj.src = ctx + "/images/pucker_arrow.jpg";
		obj.alt = "折叠";
		window.lcfGridTable.style.display = displayType;
	}

}

//多GRID面板扩展折叠
function mult_grid_display(obj) {
	var multGridExpandFlag = getObjValue("multGridExpandFlag");
	var displayType = "";
	if (multGridExpandFlag == "1") {
		displayType = "none";
		setObjValue("multGridExpandFlag","0");
		obj.src = ctx + "/images/expand_arrow.jpg";
		obj.alt = "展开";
		window.multGridTable.style.display = displayType;
	}else {
		displayType = "";
		setObjValue("multGridExpandFlag","1");
		obj.src = ctx + "/images/pucker_arrow.jpg";
		obj.alt = "折叠";
		window.multGridTable.style.display = displayType;
	}

}


//单面板扩展折叠
function pannel_display(obj,lineName){
	var lineNameValue = getObjValue(lineName + "_line");
        var lineNameFlag = getObjValue(lineName + "_flag");
        var begin_tr = lineNameValue.split(",")[0];
        var end_tr = lineNameValue.split(",")[1];
        var displayType = "";
        if(lineNameFlag == "1"){
          displayType = "none";
          setObjValue(lineName + "_flag","0");
          obj.src =ctx + "/images/expand_arrow.jpg";
          obj.alt = "展开";
        }
        else{
          displayType = "";
          setObjValue(lineName + "_flag","1")
          obj.src =ctx + "/images/pucker_arrow.jpg";
          obj.alt = "折叠";
        }
        for(var i=parseInt(begin_tr);i<parseInt(end_tr);i++){
        	 window.table_form.rows(i).style.display = displayType;
        }
}


//全部面板扩展
function pannel_Expand_all() {
  if(document.all.panel_display_all_img != undefined) {
    pannel_Expand_all_has_allExpandButton();
  }
  if(document.all.gridImg != undefined) {
    window.lcfGridTable.style.display = "";
  }

}
//全部面板扩展有全展按钮时
function pannel_Expand_all_has_allExpandButton() {
        var obj = document.all.panel_display_all_img;
	var allPannelRows = getObjValue("allPannelRows");
        var allPannelRows_flag = getObjValue("allPannelRows_flag");
        var allPannelRowsArray = allPannelRows.split(";");
        displayType = "";
        setObjValue("allPannelRows_flag","1");
        obj.src =ctx + "/images/all_pucker_arrow.jpg";
        obj.alt = "全部折叠";
        for(var i=1;i<allPannelRowsArray.length;i++){
         	var lineName = allPannelRowsArray[i].split(",")[0];
            	var begin_tr = allPannelRowsArray[i].split(",")[1];
               	var end_tr = allPannelRowsArray[i].split(",")[2];
                eval("document.all." + lineName + "_img").src = ctx + "/images/pucker_arrow.jpg";
                eval("document.all." + lineName + "_img").alt = "折叠";
                setObjValue(lineName + "_flag","1");
                for(var j=parseInt(begin_tr);j<parseInt(end_tr);j++){
                	window.table_form.rows(j).style.display = displayType;
                }
        }
        var gridExpandFlag = getObjValue("gridExpandFlag");
        if (gridExpandFlag == "null") {
        }else {

          displayType = "";
	  setObjValue("gridExpandFlag","1");
	  document.all.gridImg.src = ctx + "/images/pucker_arrow.jpg";
          document.all.gridImg.alt = "折叠";
	  window.lcfGridTable.style.display = displayType;

        }
        var multGridExpandFlag = getObjValue("multGridExpandFlag");
        if (multGridExpandFlag == "null") {
        }else {

          displayType = "";
	  setObjValue("multGridExpandFlag","1");
	  document.all.multGridImg.src = ctx + "/images/pucker_arrow.jpg";
	  document.all.multGridImg.alt = "折叠";
	  window.multGridTable.style.display = displayType;
          }

}

//全部面板扩展折叠
function pannel_display_all(obj){
	var allPannelRows = getObjValue("allPannelRows");
        var allPannelRows_flag = getObjValue("allPannelRows_flag");
        var allPannelRowsArray = allPannelRows.split(";");

        if(allPannelRows_flag == "1"){
          displayType = "none";
          setObjValue("allPannelRows_flag","0");
          obj.src =ctx + "/images/all_expand_arrow.jpg";
          obj.alt = "全部展开";
        }
        else{
          displayType = "";
          setObjValue("allPannelRows_flag","1");
          obj.src =ctx + "/images/all_pucker_arrow.jpg";
          obj.alt = "全部折叠";
        }
        for(var i=1;i<allPannelRowsArray.length;i++){
          	var lineName = allPannelRowsArray[i].split(",")[0];
            	var begin_tr = allPannelRowsArray[i].split(",")[1];
               	var end_tr = allPannelRowsArray[i].split(",")[2];

		if(allPannelRows_flag == "1"){
                  	eval("document.all." + lineName + "_img").src = ctx + "/images/expand_arrow.jpg";
                      	eval("document.all." + lineName + "_img").alt = "展开";
                      	setObjValue(lineName + "_flag","0");
		}
                else{
                  	eval("document.all." + lineName + "_img").src = ctx + "/images/pucker_arrow.jpg";
                      	eval("document.all." + lineName + "_img").alt = "折叠";
                  	setObjValue(lineName + "_flag","1");
                }
                for(var j=parseInt(begin_tr);j<parseInt(end_tr);j++){
                	window.table_form.rows(j).style.display = displayType;
                }
        }
        var gridExpandFlag = getObjValue("gridExpandFlag");
        if (gridExpandFlag == "null") {
        }else {
        	if(allPannelRows_flag == "1") {
        		displayType = "none";
			setObjValue("gridExpandFlag","0");
			document.all.gridImg.src = ctx + "/images/expand_arrow.jpg";
			document.all.gridImg.alt = "展开";
			window.lcfGridTable.style.display = displayType;
        	}else {
        		displayType = "";
			setObjValue("gridExpandFlag","1");
			document.all.gridImg.src = ctx + "/images/pucker_arrow.jpg";
			document.all.gridImg.alt = "折叠";
			window.lcfGridTable.style.display = displayType;
        	}
        }
        var multGridExpandFlag = getObjValue("multGridExpandFlag");
        if (multGridExpandFlag == "null") {
        }else {
        	if(allPannelRows_flag == "1") {
        		displayType = "none";
			setObjValue("multGridExpandFlag","0");
			document.all.multGridImg.src = ctx + "/images/expand_arrow.jpg";
			document.all.multGridImg.alt = "展开";
			window.multGridTable.style.display = displayType;
        	}else {
        		displayType = "";
			setObjValue("multGridExpandFlag","1");
			document.all.multGridImg.src = ctx + "/images/pucker_arrow.jpg";
			document.all.multGridImg.alt = "折叠";
			window.multGridTable.style.display = displayType;
        	}
        }
}

/**
* 唯一性校验
* para:code		编码，数据库表字段名
* para:value		值，需要校验的值
* para:tableName	表名
* para:condition	做校验的查询条件
* para:action		当前操作类型（“edit”,"add"）
* para:id		如果是修改的时候，则需要传入检验值
* para:ctx		上下文根
*/
function singleValue(code,value,tableName,condition,action,id,ctx)
{
  var codeCondition = "";
  var valueCondition = "";
  if (typeof(code) == "object")
  {
          var codeArraySize = code.length;
          for (var i=0;i<codeArraySize;i++)
          {
		  codeCondition = codeCondition + "&code=" + code[i];
		  valueCondition = valueCondition + "&value=" + value[i];
          }
  }
  else
  {
	  codeCondition = codeCondition + "&code="+code;
	  valueCondition = valueCondition + "&value="+value;
  }
  var postPara = "1=1"
          + codeCondition
          + valueCondition
          + "&id=" + id
          + "&action="+action
          + "&tableName="+tableName
          + "&condition="+condition
  var xml = new ActiveXObject("MSXML2.XMLHTTP.4.0");
  var myWindowOpener = window.dialogArguments;
  xml.open("POST",
      ctx+"/css4/common/biz/bizUtil/SingleValueQuery.do?" + postPara, false)
  xml.send();
  var returnText = xml.responseText;
  if (returnText == "" || returnText !="0")
  	return false;
  else
  	return true;
}

//控制控件中字符串的长度  需要调用的控件方法是onpropertychange,使用于控制各类文本编辑控件的字符串长度
function textLengthControl(obj,len)
{
    if(obj.value.length>len)
    {
        alert("你录入的数据超出了该字段的限定长度!");
        obj.value=obj.value.substring(0,len);
    }
}



function oneRowBack() {
 if(document.all("dataTable").rows.length==2){
   document.all("chk")[0].checked = true;
   commonSelectDate("one");
 }
}



//在GRID进行页面排序时,取比较的字段值
function getGridCompareValue(objOldAllData,i,fName,mode) {
   var k = objOldAllData[i].id;
   k = trim(k.substr("dataRow".length,k.length-1));
   if(mode=='VIEW') {
     return trim(eval("objOldAllData["+i+"].all."+fName+k+".innerHTML"));
   }else {
	 var objName = "DATA["+k+"]."+fName;
     var obj = eval("objOldAllData["+i+"].all(objName)");
     return obj.value;
   }
}
function selectAllFile(obj)
//全选orderAmount字段文字
{
          obj.select();
}

//add by jialiang
//获取科目树型结构返回值
/*
方法名：getTreeInfo
参数：companyId 公司序号
            fiscalYear 会计年度
            element_id code和id的页面控件名称
            element_name 科目名称的页面控件名称
            returnType  返回值类型    1 id  2  name 3 code  4 id+name  5 code+name   6 只有末级科目可用
             isMultiTree 树型结构 y 多选 n 单选    默认为单选
             fiscalYearElement 如果fiscalYear需要在前台控制的情况下填入页面控件名称
             filter  过滤条件 ，过滤取得会计科目的种类
*/
function getTreeInfo(contextName,companyId,fiscalYear,element_id,element_name,returnType,isMultiTree,fiscalYearElement,filter) {
      var returnValue ='';
      if(fiscalYear==''){
           fiscalYear = document.getElementById(fiscalYearElement).value;
      }
      //多选树
     if(isMultiTree == 'y'){
          returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/MultiTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&filter="+filter,returnType,"status=0"); //status＝0的作用是去掉边框
     }
     //单选树
     else{

         if(filter==null){
            filter = "";
         }
         returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/RadioTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&filter="+filter,returnType,"status=0");
     }
     //返回值为空
     if(returnValue==null) returnValue='';
     //返回值科目id code
     if(returnType == 1||returnType ==3|| returnType ==6){
          document.getElementById(element_id).value = returnValue;
     }
     //返回值科目名称
     if(returnType == 2){
     alert(returnValue);
          document.getElementById(element_name).value = returnValue;
     }
     //返回值4: id＋name,5: code+name
      if(returnType ==4||returnType ==5 ){
      var returnArray = returnValue.split(",");
      var count ;
      var tempId='';
      var tempName='';
      for(count = 0;count<returnArray.length-1;count+=2){
      tempId += returnArray[count]+',';
      tempName += returnArray[count+1]+',';
      }
       document.getElementById(element_id).value =tempId.substring(0,tempId.length-1);
       document.getElementById(element_name).value = tempName.substring(0,tempName.length-1);
     }
}
//获取控制域科目树型结构返回值
/*
方法名：getControlAreaTreeInfo
参数：  controlAreaId 控制域 id
             companyId 公司序号
             fiscalYear 会计年度
             includeSelf_YN 是否包含自身
            element_id code和id的页面控件名称
            element_name 科目名称的页面控件名称
            returnType  返回值类型    1 id  2  name 3 code  4 id+name  5 code+name   7  id +code
            isMultiTree 树型结构 y 多选 n 单选    默认为单选
            fiscalYearElement 如果fiscalYear需要在前台控制的情况下填入页面控件名称
            filter  过滤条件 ，过滤取得会计科目的种类
*/
function getControlAreaTreeInfo(contextName,controlAreaId,companyId,fiscalYear,includeSelf_YN,element_id,element_name,returnType,isMultiTree,fiscalYearElement){
      var returnValue ='';
      if(fiscalYear==''){
           fiscalYear = document.getElementById(fiscalYearElement).value;
      }
      //多选树
     if(isMultiTree == 'y'){
          returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/ControlAreaMultiTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&controlAreaId="+controlAreaId+"&includeSelf_YN="+includeSelf_YN,returnType,"status=0"); //status＝0的作用是去掉边框
     }
     //单选树
     else{
         returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/ControlAreaTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&controlAreaId="+controlAreaId+"&includeSelf_YN="+includeSelf_YN,returnType,"status=0"); //status＝0的作用是去掉边框
     }
     //返回值为空
     if(returnValue==null) returnValue='';
     //返回值科目id code
     if(returnType == 1||returnType ==3){
          document.getElementById(element_id).value = returnValue;
     }
     //返回值科目名称
     if(returnType == 2){
     alert(returnValue);
          document.getElementById(element_name).value = returnValue;
     }
     //返回值4: id＋name,5: code+name;6:id+code
      if(returnType ==4||returnType ==5||returnType==7){
      var returnArray = returnValue.split(",");
      var count ;
      var tempId='';
      var tempName='';
      for(count = 0;count<returnArray.length-1;count+=2){
      tempId += returnArray[count]+',';
      tempName += returnArray[count+1]+',';
      }
       document.getElementById(element_id).value =tempId.substring(0,tempId.length-1);
       document.getElementById(element_name).value = tempName.substring(0,tempName.length-1);
     }
}
//只允许在text框中输入字母和数字
function ValidInput(){
    if((event.keyCode>=32&&event.keyCode<48)||(event.keyCode>57&&event.keyCode<65)||(event.keyCode>90&&event.keyCode<97)||(event.keyCode>122&&event.keyCode<127))
    {
        event.returnValue =false;
    }
}
//add by jialiang
//弹出窗口树型结构
/*
方法名：getLookupTree
参数：
     tagType 查询树信息时select所需要的字段名称,前四个必须是id,name.parentId,findId
                    后面是返回值可以任意添加但是必须和arrayPagePara对应,参数格式为
     arrayPagePara 回填树信息的页面控件名称,和arrayTreePara对应,参数格式 a@b@c
     treeType      扩充属性,一般不需要
*/
function getLookupTree(contextPath,tagType,condition,arrayPagePara,treeType)
{
     var returnValue = "";
     returnValue =  window.showModalDialog(contextPath+"/mpc/util/tree/LookUpTreeFrame.jsp?tagType="+tagType+"&condition="+condition+"&treeType="+treeType,"status=0"); //status＝0的作用是去掉边框
     var arrayPage =  arrayPagePara.split('@');
     var arrayReturnValue = returnValue.split('@');
     for(var count = 0;count<arrayReturnValue.length;count++){
       document.getElementById(arrayPage[count]).value = arrayReturnValue[count];
     }
}
/**
*单选弹出树型结构控件前台实现
*/
function treePopupRadioTreeWindow(url,args,width,height,returnRelation){
    var showx = event.screenX - event.offsetX - 4 - 210 ; // + deltaX;
	var showy = event.screenY - event.offsetY -150; // + deltaY;
	var urlStr = url;
	var paramArray = url.split('&');
	var changeWhereValue = '';
	for(var i=0;i<paramArray.length;i++){
	    var paramSecondArray = paramArray[i].split('=');
	    if(paramSecondArray[0]=='onChangeWhere'){
           changeWhereValue = paramSecondArray[1];
            //modify by jialiang at 2006-06-27  添加 当onchangeWhere方法返回值为"-1"时onclick失效功能
           if(eval(changeWhereValue+"()")=='-1'){
                return false;
           }
           urlStr += "&onChangeWhereValue="+eval(changeWhereValue+"()");
	    }
	}
    //window.open(urlStr);
   var retval = window.showModalDialog(urlStr,args,"dialogWidth:"+width+"px; dialogHeight:"+height+"px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;help=no;");
    if(retval!=null&&retval!=''){
        var arrayPage =  returnRelation.split('@');
        var arrayReturnValue = retval.split('@');
        //循环每次取arrayPage的column与arrayReturnValue中的column比较如果相同则把arrayReturnValue中
        //column对应的值放入以arrayPage中pageElement为名字的页面元素中
        for(var k = 0;k<=arrayPage.length-2;k=k+2){
            for(var count = 0;count<arrayReturnValue.length-2;count=count+2){
                if(arrayPage[k]==arrayReturnValue[count]){
                    document.getElementById(arrayPage[k+1]).value = arrayReturnValue[count+1];
                    break;
                }
            }
        }
    }
 }
/**
*多选弹出树型结构控件前台实现
*/
function treePopupMultiTreeWindow(url,args,width,height,returnRelation){
    var showx = event.screenX - event.offsetX - 4 - 210 ; // + deltaX;
	var showy = event.screenY - event.offsetY -150; // + deltaY;
    var urlStr = url;
	var paramArray = url.split('&');
	var changeWhereValue = '';
	for(var i=0;i<paramArray.length;i++){
	    var paramSecondArray = paramArray[i].split('=');
	    if(paramSecondArray[0]=='onChangeWhere'){
           changeWhereValue = paramSecondArray[1];
           //modify by jialiang at 2006-06-27  添加 当onchangeWhere方法返回值为"-1"时onclick失效功能
           if(eval(changeWhereValue+"()")=='-1'){
                return false;
           }
           urlStr += "&onChangeWhereValue="+eval(changeWhereValue+"()");
	    }
	}
    var retval = window.showModalDialog(urlStr,args,"dialogWidth:"+width+"px; dialogHeight:"+height+"px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;help=no;");
    if(retval!=null&&retval!=''){
        //arrayPage为页面元素名称数组column@pageElement
        var arrayPage = returnRelation.split('@');
        //arrayReturnValue为返回值数组
        var arrayReturnValue = retval.split('@');
        //清空所有元素
        for(var k = 0;k<=arrayPage.length-2;k=k+2){
            document.getElementById(arrayPage[k+1]).value = "";
        }
        //循环每次取arrayPage的column与arrayReturnValue中的column比较如果相同则把arrayReturnValue中
        //column对应的值放入以arrayPage中pageElement为名字的页面元素中
        for(var k = 0;k<=arrayPage.length-2;k=k+2){
            for(var count = 0;count<=arrayReturnValue.length-2;count=count+2){
                if(arrayPage[k]==arrayReturnValue[count]){
                    //第一次放值时页面元素为空
                    if(document.getElementById(arrayPage[k+1]).value==''){
                        document.getElementById(arrayPage[k+1]).value = arrayReturnValue[count+1];
                    }else{
                        document.getElementById(arrayPage[k+1]).value = document.getElementById(arrayPage[k+1]).value+","+arrayReturnValue[count+1];
                    }
                }
            }
        }
    }
}

//查询面板的收缩功能函数－－add by liuxiaoyan
function query_panel_display(obj) {
	var displayType = "";
	//var src=obj.src;
	//var prefix=src.substring(0,src.indexOf("query"));
	if(document.all.showtable.value.length>0){
		displayType = "none";
		//document.all.push_up.src = prefix+"query_down_arrowhead2.gif";
		//document.all.push_up.alt = "展开";
		document.all.queryPanelTable.style.display = displayType;
		document.all.showtable.value='';
	}else {
		displayType = "";
		//document.all.push_up.src =prefix+"query_up_arrowhead2.gif";
		//document.all.push_up.alt = "折叠";
		document.all.queryPanelTable.style.display = displayType;
		document.all.showtable.value='visible';
	}
	//added by xiaxiaotao  2005/12/12
    // if a html should resize, resize it auto.
	if(window.onresize)
	window.onresize();
	//added by xiaxiaotao  2005/12/12
}

function grid_display(obj) {
	var displayType = "";
	if(document.all.showtable.value.length>0){
		displayType = "none";
		document.all.push_up.src = ctx+"/images/push_down_c1.gif";
		document.all.push_up_td.title = "展开";
		document.all.queryPanelTable.style.display = displayType;
		document.all.showtable.value='';
	}else {
		displayType = "";
		document.all.push_up.src = ctx+"/images/push_up_c1.gif";
		document.all.push_up_td.title = "折叠";
		document.all.queryPanelTable.style.display = displayType;
		document.all.showtable.value='visible';
	}
	try
	{
        resizeTable();
        window.onresize=  resizeTable;
    }
    catch(e)
    {
    }
}

//加上确认对话框,businessName为对象名字，如资产卡片，凭证记录？confirmName为执行的动作，如删除？复核？结账？
function AF_confirm(businessName,confirmName){

  return window.confirm("是否确认"+confirmName+"选中的"+businessName+"？");

}

//用于在onblur事件时,检验文本框中的字符个数
function objCheckLen(obj,maxLength){
  var len = strLength(obj.value);
  if(len > maxLength){
  	alert("输入应小于允许的最大长度" + maxLength);
    obj.focus();
    obj.select();
  }
}
//用于在保存时,检验文本框中的字符个数
function objCheckLen(obj){
  var len = strLength(obj.value);
  var maxLength = obj.maxLength;
  if(len > maxLength){
    return false;
  }
  return true;
}

/**
 * 验证text和textarea的长度是否正确
 * @添加日期:2005.06.09
 */
function validateData(){
    var checks = self.document.forms[0];
    for(var i=0;i< checks.elements.length;i++){
        if(checks.elements[i].type=="text") {
            var len = strLength(checks.elements[i].value);
            var maxLength = checks.elements[i].maxLength;
            if(len > maxLength){
                alert("输入应小于允许的最大长度" + maxLength+"个字符!");
                checks.elements[i].focus();
                checks.elements[i].select();
                return false;
            }
        }
        if(checks.elements[i].tagName=="TEXTAREA"){
            var len = strLength(checks.elements[i].value);
            var maxLength = document.getElementById(checks.elements[i].name+"_maxLength").value;
            if(len > maxLength)  {
                alert("输入应小于允许的最大长度" + maxLength+"个字符!");
                checks.elements[i].focus();
                checks.elements[i].select();
                return false;
            }
        }
    }
    return true;
}

//***********************************uniflow start******************************************//
   // JavaScript Documentfunction
function setClass(eleName,clsName)
{
 //document.all(eleName).className = clsName;
}

//common button refresh
function refresh()
{
  var url = window.location.href;

  var index = url.indexOf("?");
  if(index!=-1)
    location.href = url.substring(0,index);
  else
    location.href = url;
}


//****************************** uniflow end *******************************************//
//
function adjustPageSet(cell, breakRow, rows){
  cell.PrintSetBottomTitle(rows-1, rows);
  cell.PrintRange(2, 1, cell.GetCols(0), cell.GetRows(0));
  cell.InsertRow(breakRow, 1, 0);
  cell.DeleteRow(breakRow, 1, 0);
}
//
function parseString(str){
	if(str == "")
		return 0;
	if(str == "-")
		return 0;
	var arr = str.split(",");
	var returnValue = "";
	for(i=0;i<arr.length;i++){
		returnValue += arr[i];
	}
	return parseFloat(returnValue);
}

//
function formatNumber(number){
    var str            = number.toString();
    var pattern = '#,###.00';
    var strInt;
    var strFloat;
    var formatInt;
    var formatFloat;
    if(/\./g.test(pattern)){
        formatInt        = pattern.split('.')[0];
        formatFloat        = pattern.split('.')[1];
    }else{
        formatInt        = pattern;
        formatFloat        = null;
    }

    if(/\./g.test(str)){
        if(formatFloat!=null){
            var tempFloat    = Math.round(parseFloat('0.'+str.split('.')[1])*Math.pow(10,formatFloat.length))/Math.pow(10,formatFloat.length);
            strInt        = (Math.floor(number)+Math.floor(tempFloat)).toString();
            strFloat    = /\./g.test(tempFloat.toString())?tempFloat.toString().split('.')[1]:'0';
        }else{
            strInt        = Math.round(number).toString();
            strFloat    = '0';
        }
    }else{
        strInt        = str;
        strFloat    = '0';
    }
    if(formatInt!=null){
        var outputInt    = '';
        var zero        = formatInt.match(/0*$/)[0].length;
        var comma        = null;
        if(/,/g.test(formatInt)){
            comma        = formatInt.match(/,[^,]*/)[0].length-1;
        }
        var newReg        = new RegExp('(\\d{'+comma+'})','g');

        if(strInt.length<zero){
            outputInt        = new Array(zero+1).join('0')+strInt;
            outputInt        = outputInt.substr(outputInt.length-zero,zero)
        }else{
            outputInt        = strInt;
        }

        var
        outputInt            = outputInt.substr(0,outputInt.length%comma)+outputInt.substring(outputInt.length%comma).replace(newReg,(comma!=null?',':'')+'$1')
        outputInt            = outputInt.replace(/^,/,'');

        strInt    = outputInt;
    }

    if(formatFloat!=null){
        var outputFloat    = '';
        var zero        = formatFloat.match(/^0*/)[0].length;

        if(strFloat.length<zero){
            outputFloat        = strFloat+new Array(zero+1).join('0');
            //outputFloat        = outputFloat.substring(0,formatFloat.length);
            var outputFloat1    = outputFloat.substring(0,zero);
            var outputFloat2    = outputFloat.substring(zero,formatFloat.length);
            outputFloat        = outputFloat1+outputFloat2.replace(/0*$/,'');
        }else{
            outputFloat        = strFloat.substring(0,formatFloat.length);
        }

        strFloat    = outputFloat;
    }else{
        if(pattern!='' || (pattern=='' && strFloat=='0')){
            strFloat    = '';
        }
    }
	if(strInt+(strFloat==''?'':'.'+strFloat)=='0.00')
		return "-";
    return strInt+(strFloat==''?'':'.'+strFloat);
}

//校验Email
function checkEmail(email)
{
     if(email.indexOf("@")<0||email.indexOf(".")<0)
     {
         return false;
     }
    return true;
}

//校验手机号码
function checkMobile(mobile)
{
    if(mobile.length!=11)
    {
        return false;
    }

    if(!checkPInteger(mobile))
    {
        return false;
    }
    return true;
}


//检查电话数字
function checkTelNumber(str) {
    var i;
    var len = str.length;
    var chkStr = "-1234567890";
    if (len == 1) {
       if (chkStr.indexOf(str.charAt(i)) < 0) {
	       return false;
       }
     } else {
	     if (str.charAt(0) == "-" || str.charAt(len-1) == "-") {
	      return false;
	   }
	     for (i = 1; i < len; i++) {
		    if (chkStr.indexOf(str.charAt(i)) < 0) {
			    return false;
		  }
	   }
    }
    return true;
}


//add by chenxj 20050518
//汇总指定sumColName的值到指定顶表的某行某列
// obj 表；prefix前缀；nDec 格式化小数点 保留位数
//例：sumCol("dataTable","orderDetail","quantOrder","TableNmae",0,4,0)
function sumTableCol(obj,prefix,sumColName,setTableName,row,col,nDec)
{
   var colname ="";
   var nRow;		// Various table stats
   var table;				// Table object
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
	for (var i=0; i<nRow; i++)
	{
      if(prefix!="")
      {
        colname = prefix+"[" + i + "]." + sumColName;
      }
      colValue = document.forms[0].elements[colname].value;
      if (checkNumber(colValue))
        {
          if (colValue == "") { colValue =0;}
          sumValue = parseFloat(sumValue) + parseFloat(colValue);
         }
      else
      	{
          sumValue = -1;
          break;
        }
    }
    var setTable = eval(setTableName);
    setTable.rows(row).cells(col).innerText=FormatNumber(parseFloat(sumValue),nDec);
}

function httpGetNR(http,url)
{
   var strRet = "";
   if(url.length!=0)
   {
        http.open("GET",url,false);
        http.send();
        strRet = http.responseText;
    }
    strRet = trimNR(strRet);
    if (strRet.length==0)
	{
         return "";
	}
    return strRet;
}

//截取字符串前后的空字符回车符和换行符
function trimNR(strValue)
{
	var  i=0;
	var intLen;
	if (strValue.length == 0)return ""
	while (i == 0)
	  {
	    i = strValue.indexOf("\r",0);
	    strValue=strValue.replace("\r","")
	  }
    i=0;
	while (i == 0)
	  {
	    i = strValue.indexOf("\n",0);
	    strValue=strValue.replace("\n","")
	  }
	return strValue;
}

//检查两个日期比较
function checkDateCompare(obj1,obj2)
{
 var d1=obj1.value;
 var d2=obj2.value;
 if(d1.length!=0&&d2.length!=0)
   {
    var flag = false;
    if(parseInt(d1.split('-')[0])<=parseInt(d2.split('-')[0]))
       if(parseInt(d1.split('-')[1])<=parseInt(d2.split('-')[1]))
          if(parseInt(d1.split('-')[2])<=parseInt(d2.split('-')[2]))
             flag = true;
    if(flag)
       return true;
    else
       alert('起始日期大于终止日期！');
   }
 else
     return true;
}

//叛断是否为一整数
function isPostiveInt(_str)
	{
		str=trim(_str);
    	var i,j;
    	var len = str.length;
    	if(len==0) return false;
    	var first_check_str = "+123456789";
    	var check_str = "1234567890";
    	if(len==1)
    	{
			if(check_str.indexOf(str.charAt(i))<0) return false;
    	}
    	else
    	{
			if((first_check_str.indexOf(str.charAt(0))<0) || (str.charAt(0)=="0")) return false;
	 		for(i=1;i<len;i++) if(check_str.indexOf(str.charAt(i))<0) return false;
    	}
    	return true;
	}



//==============================================================
//判断是否有复选框被选择
	function hasSelectedRecord(objName)
	{
		var objChk;
		var elementLengh=getElementLen(objName);
		for(var i=0;i<elementLengh;i++)
		{
			objChk=getObj(objName,i);
			if(objChk.checked&&(!objChk.disabled))
			{
				return true;
			}
		}
		return false;
	}

//判断是否有复选框被选择
	function hasOneRecord(objName)
	{
		var objChk;
		var returnval=0;
		var j=0;
		var elementLengh=getElementLen(objName);
		for(var i=0;i<elementLengh;i++)
		{
			objChk=getObj(objName,i);
			if(objChk.checked&&(!objChk.disabled))
			{
				j++;
				returnval=objChk.value;
			}
		}
		if (j==1)
			return returnval;
		else
			return -1;
	}

//全选
	function selectAll(objName)
	{
		var objChk;
		var elementLengh=getElementLen(objName);
		for(var i=0;i<elementLengh;i++)
		{
			objChk=getObj(objName,i);
			if((!objChk.disabled))
			{
				if(objChk.checked)
				{
					objChk.checked=false;
				}
				else
				{
					objChk.checked=true;
				}
			}
		}
	}

	//获取某一表单元素数组的长度
	function getElementLen(elementName)
	{
	  var obj=document.all(elementName);
	  if(!(typeof(obj)=="object"))return 0;
	  if(obj==null)
	    return 0;
      var len=obj.length;
      if(typeof(len)=="undefined")
      {
	     len=1;
      }
      return len;
	}
//从表单对象数组中获取表单对象
	function getObj(objName,index)
	{
	  var obj=document.all(objName);
	  if(!(typeof(obj)=="object"))return '';
	  var len=obj.length;
	  if(!(typeof(len)=="undefined"))
	  {
		 //obj=eval("document.all."+objName+"["+index+"]");
		  obj=document.getElementsByName(objName)[ index];//hejin modify 当页面只有一条记录时，可能会返回undefined类型，而不是复选框类型
	  }
	  return obj;
	}

function openWindow(url, name, width, height) {
	var status = "width="+width+",height="+height+",fullscreen=no,status=no,toolbar=no,menubar=no,resizable=no,scrollbar=no,location=no,titlebar=no"
	window.open(url, name, status);
}


/**
 * 显示操作进度提示信息
 */
function showOperationProgress(operationName){
	var msgw,msgh,bordercolor;
	msgw=400;//提示窗口的宽度
	msgh=100;//提示窗口的高度
	titleheight=25 //提示窗口标题高度
	bordercolor="#336699";//提示窗口的边框颜色
	titlecolor="#99CCFF";//提示窗口的标题颜色

	var sWidth,sHeight;
	sWidth=document.body.offsetWidth;
	sHeight=document.body.offsetHeight;//screen.height;

	var bgObj=document.createElement("div");
	bgObj.setAttribute('id','op_bgDiv');
	bgObj.style.position="absolute";
	bgObj.style.top="0";
	bgObj.style.background="#777";
	bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	bgObj.style.opacity="0.6";
	bgObj.style.left="0";
	bgObj.style.width="100%"; //sWidth + "px";
	bgObj.style.height="100%"; //sHeight + "px";
	//alert(sWidth + "," + sHeight);
	bgObj.style.zIndex = "10001";
	document.body.appendChild(bgObj);

	var bgfObj=document.createElement("iframe");
	bgfObj.setAttribute('id','op_bgframe');
	bgfObj.style.position="absolute";
	bgfObj.style.top="0";
	//bgfObj.style.background="#777";
	//bgfObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	bgfObj.style.opacity="0.6";
	bgfObj.style.left="0";
	bgfObj.style.width="100%"; //sWidth + "px";
	bgfObj.style.height="100%"; //sHeight + "px";
	//alert(sWidth + "," + sHeight);
	bgfObj.style.zIndex = "10000";
	bgObj.appendChild(bgfObj);

	var msgObj=document.createElement("div")
	msgObj.setAttribute("id","op_msgDiv");
	msgObj.setAttribute("align","center");
	msgObj.style.background="white";
	msgObj.style.border="1px solid " + bordercolor;
	msgObj.style.position = "absolute";
	msgObj.style.left = "50%";
	msgObj.style.top = "50%";
	msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	msgObj.style.marginLeft = "-225px" ;
	msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
	msgObj.style.width = msgw + "px";
	msgObj.style.height =msgh + "px";
	msgObj.style.textAlign = "center";
	msgObj.style.lineHeight ="25px";
	msgObj.style.zIndex = "10002";

	var title=document.createElement("h4");
	title.setAttribute("id","op_msgTitle");
	title.setAttribute("align","right");
	title.style.margin="0";
	title.style.padding="3px";
	title.style.background=bordercolor;
	title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
	title.style.opacity="0.75";
	title.style.border="1px solid " + bordercolor;
	title.style.height="18px";
	title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
	title.style.color="white";
	title.style.cursor="pointer";
	/**
	title.innerHTML="关闭";
	title.onclick=function(){
		document.body.removeChild(bgObj);
		document.getElementById("msgDiv").removeChild(title);
    	document.body.removeChild(msgObj);
    }
	*/
	document.body.appendChild(msgObj);
	document.getElementById("op_msgDiv").appendChild(title);
	var txt=document.createElement("p");
	txt.style.margin="1em 0"
	txt.setAttribute("id","op_msgTxt");
	txt.innerHTML=operationName+"中，请稍后......";
	document.getElementById("op_msgDiv").appendChild(txt);
}

function showMessageHint(msg, exception){
	var exFlag = exception!="" && exception!=null;
	var msgw,msgh,bordercolor;
	msgw=400;//提示窗口的宽度
	msgh=200;//提示窗口的高度
	titleheight=25 //提示窗口标题高度
	bordercolor="#336699";//提示窗口的边框颜色
	titlecolor="#99CCFF";//提示窗口的标题颜色

	var sWidth,sHeight;
	sWidth=document.body.offsetWidth;
	sHeight=document.body.offsetHeight;//screen.height;

	var bgObj=document.createElement("div");
	bgObj.setAttribute('id','mh_bgDiv');
	bgObj.setAttribute("align","center");
	bgObj.style.background="white";
	bgObj.style.border="1px solid " + bordercolor;
	bgObj.style.position = "absolute";
	bgObj.style.left = "50%";
	bgObj.style.top = "50%";
	bgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	bgObj.style.marginLeft = "-225px" ;
	bgObj.style.marginTop = -100+document.documentElement.scrollTop+"px";
	bgObj.style.width = msgw + "px";
	bgObj.style.height =msgh + "px";
	bgObj.style.textAlign = "center";
	bgObj.style.lineHeight ="25px";
	bgObj.style.zIndex = "10001";

	document.body.appendChild(bgObj);

	var bgfObj=document.createElement("iframe");
	bgfObj.setAttribute('id','mh_bgframe');
	bgfObj.style.position="absolute";
	bgfObj.style.top="0";
	//bgfObj.style.background="#777";
	//bgfObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	bgfObj.style.opacity="0.6";
	bgfObj.style.left="0";
	bgfObj.style.width="100%"; //sWidth + "px";
	bgfObj.style.height="100%"; //sHeight + "px";
	//alert(sWidth + "," + sHeight);
	bgfObj.style.zIndex = "10000";
	bgObj.appendChild(bgfObj);

	var msgObj=document.createElement("div")
	msgObj.setAttribute("id","mh_msgDiv");
	msgObj.setAttribute("align","center");
	msgObj.style.background="white";
	msgObj.style.border="1px solid " + bordercolor;
	msgObj.style.position = "absolute";
	msgObj.style.left = "50%";
	msgObj.style.top = "50%";
	msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	msgObj.style.marginLeft = "-225px" ;
	msgObj.style.marginTop = -100+document.documentElement.scrollTop+"px";
	msgObj.style.width = msgw + "px";
	msgObj.style.height =msgh + "px";
	msgObj.style.textAlign = "center";
	msgObj.style.lineHeight ="25px";
	msgObj.style.zIndex = "10002";
	msgObj.onclick = function(){
	  title.onclick();
	}

	var title=document.createElement("h4");
	title.setAttribute("id","mh_msgTitle");
	title.setAttribute("align","left");
	title.style.margin="0";
	title.style.padding="3px";
	title.style.background=bordercolor;
	title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
	title.style.opacity="0.75";
	title.style.border="1px solid " + bordercolor;
	title.style.height="18px";
	title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
	title.style.color="white";
	title.style.cursor="pointer";

	title.innerHTML="系统信息";
	title.onclick=function(){
		document.body.removeChild(bgObj);
		document.getElementById("mh_msgDiv").removeChild(title);
    	document.body.removeChild(msgObj);
    }
    
	document.body.appendChild(msgObj);
	document.getElementById("mh_msgDiv").appendChild(title);
	var txt=document.createElement("p");
	txt.style.margin="1em 0"
	txt.setAttribute("id","mh_msgTxt");
	txt.innerHTML=msg;
	document.getElementById("mh_msgDiv").appendChild(txt);
	if(exFlag) {
		var txt_ex=document.createElement("div");
		//txt_ex.style.margin="1em 0"
		txt_ex.setAttribute("id","mh_msgTxt_ex");
		txt_ex.style.width="100%"; //sWidth + "px";
		txt_ex.style.height="100%"; //sHeight + "px";
    	txt_ex.style.overflowX="auto";
    	txt_ex.style.overflowY="scroll";
		txt_ex.innerHTML="<PRE>" + exception + "</PRE>";
		document.getElementById("mh_msgDiv").appendChild(txt_ex);
	}
}

//屏蔽键盘事件F5
function   hidKey()   {
  if   (event.keyCode==116)   {
    event.keyCode=0;
    event.returnValue=false;
  }
}


function StrLen(str){
	if(str == null)
		return 0;
	var str1 = trim(str);
	if(str1 == "")
		return 0;
	var result = 0;
	for(var i = 0;i<str1.length;i++){
		if(str1.charCodeAt(i)>256)
			result += 2;
		else
			result++;
	}
	return result;
}

/**
 * 方法名:ajaxInvokeClass
 * className:类名，实现platform.framework.ajax.AFAjax接口
 * contextPath:当前路径
 * paramStr:请求参数
 */
function ajaxInvokeClass(contextPath,className,paramStr) {
    paramStr = paramStr + "&implcls="+className;
    var invokeAction = contextPath+"/ajax?"+paramStr;
    return xmlInvoke(invokeAction);
}

/*是否唯一性检查
参数：应用上下文，表名，字段名，字段值，当前行号(如无，传-1)
返回：true/false
*/
function isUniqueValue(contextPath,tableName,columnName,value,rowid)
{
	var className = "com.handao.platform.framework.util.AFUniqueVerify";
	var paramStr = "tableName="+tableName+"&columnName="+columnName+"&value="+encodeto64(value)+"&rowid="+rowid;
    var result = ajaxInvokeClass(contextPath,className,paramStr);
    return result == 'Y';
}
function isUniqueValueDefault(tableName,columnName,value,rowid)
{
	return isUniqueValue(_sys_ctx,tableName,columnName,value,rowid);
}
