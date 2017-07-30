/**---------------------------ȫ�ֳ������忪ʼ-----------------------------------*/

/**
 * ������:�и�����ʾ������ɫ
 * ����˵��:�������˫��ѡ��GRID������ʱ,�г��ֳ�������ʾ�ı�����ɫ.
 */
var VAR_HighLightColor = "#00bfff";

/**
 * ������:Grid�Ǳ༭ģʽʱ���зָ��
 * ����˵��:Grid�ǿɱ༭ʱ,�ύʱ��Ҫ��GRID�е������ݽ���,ƴ���ַ���,�˳������ڶ���,��ƴ��ʱ�ķָ��
 */
var ROW_SPLIT_FLAG = "\"\\;";

/**
 * ������:Grid�Ǳ༭ģʽʱ���зָ��
 * ����˵��:Grid�ǿɱ༭ʱ,�ύʱ��Ҫ��GRID�е������ݽ���,ƴ���ַ���,�˳������ڶ���,��ƴ��ʱ�ķָ��.
 */
var COL_SPLIT_FLAG = "\"\\,";

/**
 * ������:����XMLHTTP����
 * ����˵��:����ȫ��xmlhttp����,�����й�ͨ��JS�п��Ե���.
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
 * ������:�Ⱥ��滻����
 * ����˵��:��ִ�и��²���SQL����,�����滻SQL�е�=��
 */
var EQUAL_FLAG = "<equal>";

/**
 * ������:�ָ���ؼ���־λ����ѭ������
 * ����˵��:�ڴ��ָ���ؼ���,����ѭ�����õı�־λ
 */
var spoint = "true";

/**
 * ������:dateCompare
 * ����:date1 ��ʼ����;date2 ��ֹ����;msg Ҫ��ʾ���ַ�����Ϣ
 * ����ֵ:true or false
 * ����˵��:У���������ڻ�ʱ��Ƚ�,Ҫ���һ�����ڻ�ʱ��ҪС�ڵڶ������ڻ�ʱ��.
 * ����ʾ������:dateCompare("2004-12-08","2004-10-10"," ��ʼ����ҪС�ڽ�ֹ����")
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
 * ������:checkNumberPlus
 * ����:str ҪУ����ַ���
 * ����ֵ:true or false
 * ����˵��:У���ַ���,�ǲ���ȫ�������������
 * ����ʾ������:checkNumberPlus("232323")
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
 * ������:checkInteger
 * ����:str ҪУ����ַ���
 * ����ֵ:true or false
 * ����˵��:У������
 * ����ʾ������:checkInteger("2222");
 */
function checkInteger(str) {
    if(checkNumberPlus(str)) {
        return str.indexOf('.') < 0;
    }
	return false;
}

/**
 * ������:checkPNumber
 * ����:str ҪУ����ַ���
 * ����ֵ:true or false
 * ����˵��:У������
 * ����ʾ������:checkPNumber("232.22");
 */
function checkPNumber(str) {
	if(checkNumberPlus(str)) {
		return str.indexOf('-') < 0;
	}
	return false;
}

/**
 * ������:checkPInteger
 * ����:str ҪУ����ַ���
 * ����ֵ:true or false
 * ����˵��:У��������
 * ����ʾ������:checkPInteger("2222")
 */
function checkPInteger(str) {
	if(checkInteger(str)) {
		return str.indexOf('-') < 0;
	}
	return false;
}

/**
 * ������:onlyNumber
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:���������������ΪNumber,ֻ�����������ֺ�С����,����.
 * ����ʾ������:onlyNumber(obj)
 */
function onlyNumber(obj){
	var checkStr = obj.value;

    if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57))|| (window.event.keyCode == 13) || (window.event.keyCode == 46)|| (window.event.keyCode == 45)))
   	{
       window.event.keyCode = 0 ;
       return false;
    }

  	if(window.event!=null){
      		//��һλ����������С���㡰.��
      		if(checkStr == null || checkStr=="" ){
                	if(window.event.keyCode == 46)
                        	window.event.keyCode = 0 ;
                }
                //�����һλ�Ǹ��ţ��ڶ�λ��ֹ���롰.��
                if(checkStr=="-"){
                        if(window.event.keyCode == 46)
                                window.event.keyCode = 0 ;
                }
                //�����һλ���븺�ţ�����λ���������븺�š�-��
                if(checkStr.indexOf("-")>-1 || checkStr.length>1){
                        if(window.event.keyCode == 45)
                                window.event.keyCode = 0 ;
                }
                //����Ѿ����롰.����������λ���������롰.��
                if(checkStr.indexOf(".")>-1){
                        if(window.event.keyCode == 46)
                                window.event.keyCode = 0 ;
                }
  	}
    return true;
}


/**
 * ������:isInNumber
 * ����:str �ַ���
 * ����ֵ:true or false
 * ����˵��:�ж��ַ��Ƿ����-1234567890.֮��
 * ����ʾ������:isInNumber(str)
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
 * ������:validNumber
 * ����:obj ��������;colSize ���ֵ��ܳ���;precision С��λ�ĳ���
 * ����ֵ:true or false
 * ����˵��:У�������������Ϊ�Ϸ���Number
 * ����ʾ������:validNumber(this,8,3)
 */
function validNumber(obj,colSize,precision){
	var checkStr = obj.value;
        if(checkNumber(checkStr) == false) {
          obj.focus();
          return false;
        }
        colSize = parseInt(colSize);
        precision = parseInt(precision);
        var m = checkStr.length;                      //����ֵ��λ��
        var n = checkStr.indexOf(".");                //��.����λ��
        var k = checkStr.indexOf("-");                //��-����λ��
        var j;                                        //��������
        var i;                                        //С������

	//�������ֵ�к��С�.������ȡ����ֵ���������ȣ�
 	if(n > -1){
           	//�������ֵ�к��С�����
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
           	//�������ֵ�к��С�����
           	if(k > -1){
  			j = m - 1;
           	}
                else{
                  	j = m;
                }
                i = 0;
 	}
      	//��������ֵ���������Ⱥ�С������
      	if((j > colSize - precision) || (i > precision)){
                alert(checkStr + "�ľ��Ȳ�����Ҫ����������С�ڵ���" + (colSize - precision) + "��С������С�ڵ���" + precision + "��");
                obj.focus();
                return false
      	}
        return true;
}


/**
 * ������:onlyCalendar
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:���������������Ϊ����:��1999-02-07
 * ����ʾ������:onlyCalendar(this)
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
              	//����ַ�����δ�ﵽ��λ��7λ���������롰-������֮��������롰-��
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
 * ������:validCalendar
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:У�������������Ϊ�Ϸ�������
 * ����ʾ������:validCalendar(this)
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
                        	alert(checkStr + "�ĸ�ʽ������Ҫ���·���1-12֮�䣡");
                              	obj.focus();
                        	return false;
                        }
                        if(day > 31 || day ==0){
                        	alert(checkStr + "�ĸ�ʽ������Ҫ������1-31֮�䣡");
                              	obj.focus();
                        	return false;
                        }
                        else if((month == 2 || month == 4 || month ==6 || month ==9 || month ==11) && day == 31){
                          	alert(checkStr + "�ĸ�ʽ������" + month + "����31�գ�");
                              	obj.focus();
                        	return false;
                        }
                        else if(month == 2  && day == 30){
                          	alert(checkStr + "�ĸ�ʽ������"+year+"��" +month+"����30�գ�");
                              	obj.focus();
                        	return false;
                        }
                        else if((year%100==0)&&(year%400!=0) && month == 2  && day == 29){
                          	alert(checkStr + "�ĸ�ʽ������"+year+"��" +month+"����29�գ�");
                              	obj.focus();
                        	return false;
                        }
                        else if((year%4)!=0 && month == 2  && day == 29){
                          	alert(checkStr + "�ĸ�ʽ������"+year+"��" +month+"����29�գ�");
                              	obj.focus();
                        	return false;
                        }
          	}
              	else{
                 	alert(checkStr + "�ĸ�ʽ������Ҫ��YYYY-MM-DD��");
                      	obj.focus();
                        return false;
              	}
        }
   return true;
}


/**
 * ������:onlyTime
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:����Time�����е�ʱ�������������Ϊʱ��
 * ����ʾ������:onlyTime(this)
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
              	//����ַ�����δ�ﵽ2��5λ���������롰:������֮��������롰:��
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
 * ������:validTimeDate
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:У��Time�����е�ʱ���������������Ϊ�Ϸ���ʱ����
 * ����ʾ������:validTimeDate(this)
 */
function validTimeDate(obj){
  	var hidden_name = obj.name.substr(0,obj.name.indexOf("_date"));     //��ȡ�����ֶε�����
    var checkStr = obj.value;                                           //���������ֵ
    var hms_value = getObjValue(hidden_name + "_hms")                   //ʱ�������ֵ

    //���������������ݺϷ���Ȼ���ж����������������Ƿ�Ϊ�գ�Ȼ�����ж�ʱ�������������Ƿ�Ϊ�գ�
  	if(true){
            	//�����������ֵ��Ϊ�ղ���ʱ�������ֵ��Ϊ�գ����������ֶε�ֵ�������������ֶε�ֵΪ��ֵ��
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
 * ������:validHMS
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:У��Time�����е�ʱ���������������Ϊ�Ϸ���ʱ����
 * ����ʾ������:validHMS(this)
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
                        	alert(checkStr + "�ĸ�ʽ������Ҫ��Сʱ��00-23֮�䣡");
                              	obj.focus();
                        	return false;
                        }
                        if(minute > 59){
                        	alert(checkStr + "�ĸ�ʽ������Ҫ�������00-59֮�䣡");
                              	obj.focus();
                        	return false;
                        }
                        if(second > 59){
                        	alert(checkStr + "�ĸ�ʽ������Ҫ������00-59֮�䣡");
                              	obj.focus();
                        	return false;
                        }
          	}
              	else{
                 	alert(checkStr + "�ĸ�ʽ������Ҫ��HH:MI:SS��");
                      	obj.focus();
                        return false;
              	}
        }
        return true;
}


/**
 * ������:validTime
 * ����:obj ��������
 * ����ֵ:true or false
 * ����˵��:У��Time�����е�ʱ���������������Ϊ�Ϸ���ʱ���룬�����������ֶε�ֵ
 * ����ʾ������:validTime(this)
 */
function validTime(obj){
  	var hidden_name = obj.name.substr(0,obj.name.indexOf("_hms"));      //��ȡ�����ֶε�����
    var checkStr = obj.value;                                           //ʱ�������ֵ
    var date_value = getObjValue(hidden_name + "_date")                 //���������ֵ

     //���ʱ������������ݺϷ���Ȼ���ж�ʱ���������������Ƿ�Ϊ�գ�Ȼ�����ж����������������Ƿ�Ϊ�գ�
  	if(validHMS(obj)){
        //���ʱ��������ֵ��Ϊ�ղ������ڵ�����ֵ��Ϊ�գ����������ֶε�ֵ�������������ֶε�ֵΪ��ֵ��
        if(!(checkStr == null || checkStr == "" ) && !(date_value == null || date_value=="" )){
            getWholeTime(hidden_name);
        }
        else{
            setObjValue(hidden_name,"");
        }
  	}
    return true;
}

//У��Time(û����)�����е�ʱ�������������Ϊ�Ϸ���ʱ���룬�����������ֶε�ֵ��
function validTimeNS(obj){
var hidden_name = obj.name.substr(0,obj.name.indexOf("_hms"));      //��ȡ�����ֶε�����
var checkStr = obj.value;                                           //ʱ�������ֵ
var date_value = getObjValue(hidden_name + "_date")                 //���������ֵ

//���ʱ������������ݺϷ���Ȼ���ж�ʱ���������������Ƿ�Ϊ�գ�Ȼ�����ж����������������Ƿ�Ϊ�գ�
if(validHM(obj)){
   //���ʱ��������ֵ��Ϊ�ղ������ڵ�����ֵ��Ϊ�գ����������ֶε�ֵ�������������ֶε�ֵΪ��ֵ��
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


//У��Time(û����)�����е�ʱ�������������Ϊ�Ϸ���ʱ���룻
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
                     alert(checkStr + "�ĸ�ʽ������Ҫ��Сʱ��00-23֮�䣡");
                           obj.focus();
                     return false;
                    }
                    if(minute > 59){
                     alert(checkStr + "�ĸ�ʽ������Ҫ�������00-59֮�䣡");
                           obj.focus();
                     return false;
                    }
       }
           else{
              alert(checkStr + "�ĸ�ʽ������Ҫ��HH:MI��");
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
		alert("ʱ���ʽ�Ƿ���");
		obj.focus();
		return false;
	}
}

/**--------------------------------У��ʱ�����룬������end---------------------------��/

/**
 * ������:validFormText
 * ����:name Ҫ�жϵĿؼ�������;isMustInput �Ƿ��Ǳ�����
 * ����ֵ:true or false
 * ����˵��:�ж�form���ı��ؼ��Ƿ�������������
 * ����ʾ������:validFormText(name,"true")
 */
function validFormText(name,isMustInput) {
  //��ȡ��������ı��ؼ�������ֵ
  TextValue = getObjValue(name);
  //�������ֵ�ؼ�����
  if(isMustInput == "false") {
    return true;
  }
  if(isMustInput == "true" && TextValue==""){
     	alert("������ֵ��");
        setInputFocus(name);
        return false;
  }
  return true;
}

/**
 * ������:validGridText
 * ����:name Ҫ�жϵĿؼ�������;isMustInput �Ƿ��Ǳ�����
 * ����ֵ:true or false
 * ����˵��:�ж�grid���ı��ؼ��Ƿ��������õı��������
 * ����ʾ������:validGridText(name,"true")
 */
function validGridText(name,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //��ȡobjTable������

        //ѭ���жϣ��������ʾ���Ͳ���Ϊ��none���������validFromText������
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
 * ������:validFormNumber
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;isMustInput �Ƿ����
 * ����ֵ:true or false
 * ����˵��:�ж�form����ֵ�ؼ��Ƿ��������õ����ֵ����Сֵ�ͱ��������
 * ����ʾ������:validFormNumber(name,100,1,"true")
 */
function validFormNumber(name,maxValue,minValue,isMustInput){
  	//��ȡ��������ֵ������ֵ��
  	numberValue = parseFloat(getObjValue(name));
    maxValue = parseFloat(maxValue);
    minValue = parseFloat(minValue);

    //�������ֵ�ؼ�����
     if(isMustInput == "true" && isNaN(numberValue)){
        	alert("������ֵ��");
              	setInputFocus(name);
              	return false;
      	}
      	else if(!isNaN(numberValue)){
         	if(!isNaN(maxValue) && numberValue > maxValue){
                	alert("�������ֵ����������������ֵ��");
              		setInputFocus(name);
                      	return false;
         	}
              	if(!isNaN(minValue) && numberValue < minValue){
                	alert("�������ֵС�������������Сֵ��");
              		setInputFocus(name);
                      	return false;
         	}
      	}
      	return true;
}


/**
 * ������:validGridNumber
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;isMustInput �Ƿ����
 * ����ֵ:true or false
 * ����˵��:�ж�grid����ֵ�ؼ��Ƿ��������õ����ֵ����Сֵ�ͱ��������
 * ����ʾ������:validGridNumber(name,100,1,"false")
 */
function validGridNumber(name,maxValue,minValue,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //��ȡobjTable������

        //ѭ���жϣ��������ʾ���Ͳ���Ϊ��none���������validFormNumber������
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
 * ������:validFormDate
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;isMustInput �Ƿ����
 * ����ֵ:true or false
 * ����˵��:�ж�form�����ڿؼ��Ƿ��������õ����ֵ����Сֵ�ͱ��������
 * ����ʾ������:validFormDate (name,"2004-09-01","2004-08-09","false")
 */
function validFormDate(name,maxValue,minValue,isMustInput){
	//��ȡ�����������ڵ�����ֵ��
  	dateValue = getObjValue(name);

      	//��������ڿؼ�����
      	if(isMustInput == "true" && dateValue ==""){
        	alert("���������ڣ�");
              	setInputFocus(name);
              	return false;
      	}
      	else if(dateValue !=""){
         	if(maxValue !="" && dateValue > maxValue){
                	alert("����������ڴ������������������ڣ�");
              		setInputFocus(name);
                      	return false;
         	}
              	if(minValue !="" && dateValue < minValue){
                	alert("�����������С�������������С���ڣ�");
              		setInputFocus(name);
                      	return false;
         	}
      	}
      	return true;
}

/**
 * ������:validGridDate
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;isMustInput �Ƿ����
 * ����ֵ:true or false
 * ����˵��:�ж�grid�����ڿؼ��Ƿ��������õ����ֵ����Сֵ�ͱ��������
 * ����ʾ������:validGridDate (name,"2004-09-01","2004-08-09","false")
 */
function validGridDate(name,maxValue,minValue,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //��ȡobjTable������

    //ѭ���жϣ��������ʾ���Ͳ���Ϊ��none���������validFormDate������
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
 * ������:validFormTime
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;isMustInput �Ƿ����
 * ����ֵ:true or false
 * ����˵��:�ж�form��ʱ��ؼ��Ƿ��������õ����ֵ����Сֵ�ͱ��������
 * ����ʾ������:validFormTime (name,"2004-09-01 23:22:22","2004-08-09 23:22:22","false")
 */
function validFormTime(name,maxValue,minValue,isMustInput){
	//��ȡ��������ʱ�������ֵ��
  	timeValue = getObjValue(name);

      	//��������ڿؼ�����
      	if(isMustInput == "true" && timeValue ==""){
        	alert("������ʱ�䣡");
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
                	alert("�������ʱ�����������������ʱ�䣡");
              		setInputFocus(name);
                      	return false;
         	}
              	if(minValue != "" && timeValue < minValue){
                	alert("�������ʱ��С�������������Сʱ�䣡");
              		setInputFocus(name);
                      	return false;
         	}
      	}
      	return true;
}

/**
 * ������:validGridTime
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;isMustInput �Ƿ����
 * ����ֵ:true or false
 * ����˵��:�ж�grid��ʱ��ؼ��Ƿ��������õ����ֵ����Сֵ�ͱ��������
 * ����ʾ������:validGridTime (name,"2004-09-01 23:22:22","2004-08-09 23:22:22","false")
 */
function validGridTime(name,maxValue,minValue,isMustInput){
	var objTable = eval("dataTable");
	var strTableTotalRows = objTable.rows.length;    //��ȡobjTable������

        //ѭ���жϣ��������ʾ���Ͳ���Ϊ��none���������validFormTime������
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
 * ������:GetDay
 * ����:varYear �������;varMonth �������
 * ����ֵ:����,�µ�����
 * ����˵��:����,�����,��ø���,�µ�����
 * ����ʾ������:GetDay("2000", "2")Ϊ29��
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
 * ������:validateDate
 * ����:year �������;month �������;day �������
 * ����ֵ:true or false
 * ����˵��:У�����ڵ�����λ,��,��Ϊ��λ����һλ.
 * ����ʾ������:validateDate("2000", "2", "31")
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
 * ������:checkValidate
 * ����:msg �������;element ҳ��Ԫ������
 * ����ֵ:false or ��
 * ����˵��:У��ҳ���ĳ���ؼ��Ƿ�Ϊ������.���У��ʧ�ܷ���false,��������ʾ��
 * ����ʾ������:checkValidate(msg,element)
 */
function checkValidate(msg,element)
{
    if(document.getElementById(element).value==null||document.getElementById(element).value=='')
    {
        alert('������'+msg) ;
        return false;
    }
}

/**
 * ������:objCheckLen2
 * ����:obj ��������;maxLength �ַ�������
 * ����ֵ:��
 * ����˵��:������onblur�¼�ʱ,�����ı����е��ַ�����
 * ����ʾ������:objCheckLen2(obj,maxLength)
 */
function objCheckLen2(obj,maxLength){
  var len = StrLen(obj.value);
  if(len > maxLength){
	 alert("���볬�����������!!!");
  	//alert("{" + getChineseName(obj) + "}������" + len + "�֣������������" + maxLength + "�֣�");
    obj.focus();
    //obj.select();
  }
}

/**
 * ������:objCheckLen2_onkeypress
 * ����:obj ��������;maxLength �ַ�������
 * ����ֵ:��
 * ����˵��:������onkeypress�¼�ʱ,�����ı����е��ַ�����
 * ����ʾ������:objCheckLen2_onkeypress(obj,maxLength)
 */
function objCheckLen2_onkeypress(obj,maxLength){

  var len = StrLen(obj.value);
  if(len >= maxLength){
	window.event.keyCode = 0 ;
  	//alert("{" + getChineseName(obj) + "}������" + len + "�֣������������" + maxLength + "�֣�");
    obj.focus();
    //obj.select();
  }
}

/**
 * ������:validNumber2
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;minexp ��Сֵ�ȽϷ���;maxexp ���ֵ�ȽϷ���;validate �����־λ
 * ����ֵ:true or false
 * ����˵��:�ж���ֵ�ؼ��Ƿ��������õ����ֵ����Сֵ
 * ����ʾ������:validNumber2(name,100,1,"<",">","true")
 */
function validNumber2(obj,minValue,minexp,maxValue,maxexp,validate){
  	//��ȡ��������ֵ������ֵ��
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
                alert("�������ֵ����������������ֵ��");
                obj.focus();
				return false;
			  }
		  }
		  if(maxexp=="<="){
			  if(numberValue > maxValue){
			    alert("�������ֵ����������������ֵ��");
				obj.focus();
				return false;
			  }
		  }
	  }
	  if (!isNaN(minValue)){
		  if(minexp==">") {
			  if(numberValue <= minValue){
                alert("�������ֵС�������������Сֵ��");
                obj.focus();
				return false;
			  }
		  }
		  if(minexp==">="){
			  if(numberValue < minValue){
				 alert("�������ֵС�������������Сֵ��");
				 obj.focus();
				 return false;
			  }
		  }
	  }
    }
    return true;
}

/**
 * ������:validNumber3
 * ����:name �ؼ�������;maxValue ���ֵ;minValue ��Сֵ;
 * ����ֵ:true or false
 * ����˵��:�ж���ֵ�ؼ��Ƿ��������õ����ֵ����Сֵ,רΪ���ָ���Ŀؼ�ʹ��,����ȡ���ؿؼ���ֵ
 * ����ʾ������:validNumber3(name,100,1,"<",">","true")
 */
function validNumber3(obj,minValue,minexp,maxValue,maxexp,validate){
  	//��ȡ��������ֵ������ֵ��
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
                alert("�������ֵ����������������ֵ��");
                obj.focus();
				return false;
			  }
		  }
		  if(maxexp=="<="){
			  if(numberValue > maxValue){
			    alert("�������ֵ����������������ֵ��");
				obj.focus();
				return false;
			  }
		  }
	  }
	  if (!isNaN(minValue)){
		  if(minexp==">") {
			  if(numberValue <= minValue){
                alert("�������ֵС�������������Сֵ��");
                obj.focus();
				return false;
			  }
		  }
		  if(minexp==">="){
			  if(numberValue < minValue){
				 alert("�������ֵС�������������Сֵ��");
				 obj.focus();
				 return false;
			  }
		  }
	  }
    }
    return true;
}

/**
 * ������:onlyInteger
 * ����:obj �ؼ��Ķ�������
 * ����ֵ:�� or false
 * ����˵��:��ֵ�ؼ�ֻ������������,�͸���,�س�
 * ����ʾ������:onlyInteger(this)
 */
function onlyInteger(obj){
	var checkStr = obj.value;
  //alert(checkStr);
  if ( !(((window.event.keyCode >= 48) && (window.event.keyCode <= 57))|| (window.event.keyCode == 13) || (window.event.keyCode == 45))){
       window.event.keyCode = 0 ;
       return false;
  }

  if(window.event!=null){
  	//����ֻ���ڵ�һλ
  	if (window.event.keyCode == 45){
  		if(checkStr!="" && getCaret(obj) != 0) {
  			window.event.keyCode = 0
  			//alert("����ֻ���ڵ�һλ!!!");
  		}
  	}

  }
    return true;
}


/**
 * ������:onlyDouble
 * ����:obj �ؼ��Ķ�������
 * ����ֵ:true or false
 * ����˵��:������ֵ�ؼ�ֻ������������,�͸���,�س�,С����
 * ����ʾ������:onlyDouble(this)
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
  		//alert("��һλ����������С���㡰.��!!!");
  	}
  	//����ֻ���ڵ�һλ
  	if (window.event.keyCode == 45){
      if(checkStr!="" && getCaret(obj) != 0) {
  			window.event.keyCode = 0
  			//alert("����ֻ���ڵ�һλ!!!");
  		}
  	}
    //��һλ����������С���㡰.��
    if(checkStr == null || checkStr=="" ){
      if(window.event.keyCode == 46)
        window.event.keyCode = 0 ;
    }
    //�����һλ�Ǹ��ţ��ڶ�λ��ֹ���롰.��
    if(checkStr=="-"){
      if(window.event.keyCode == 46)
        window.event.keyCode = 0 ;
    }

    //����Ѿ����롰.����������λ���������롰.��
    if(checkStr.indexOf(".")>-1){
      if(window.event.keyCode == 46)
        window.event.keyCode = 0 ;
    }
  }
  return true;
}

/**
 * ������:checkNumber
 * ����:str �ؼ��Ķ���ֵ
 * ����ֵ:true or false
 * ����˵��:У�鸡����ֵ�ؼ�ֻ������������,�͸���,�س�,С����
 * ����ʾ������:checkNumber(obj.value)
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
 * ������:formatIntegerToSepInteger
 * ����:this �ؼ�����
 * ����ֵ:��
 * ����˵��:��ʽ������Ϊ���ָ��������
 * ����ʾ������:formatIntegerToSepInteger(this)
 */
function formatIntegerToSepInteger(money) {
		var dValue = money.value;
		money.value = doMoneyGroup(dValue);
   	sPoint = false;
   	document.getElementById(money.name.replace("money_", "")).value = dValue;
   	sPoint = true;
}


/**
 * ������:formatSepIntegerToInteger
 * ����:money �ؼ�����
 * ����ֵ:��
 * ����˵��:��ʽ�����ָ��������Ϊ����
 * ����ʾ������:formatSepIntegerToInteger(this)
 */
function formatSepIntegerToInteger(money) {
//	var d = money.value.replace(",", "");
//updated by liu.cj �޸ĵ������ǧ�ַ�����һ��������ȫȥ��������
   var d = money.value;
   while(d.indexOf(',') >=0)
   {
		d = d.replace(",", "");
   }
    money.value = d;
}

/**
 * ������:IntegerToSepInteger_OnPropertyChange
 * ����:money �ؼ�����
 * ����ֵ:��
 * ����˵��:�����ڴ��ָ�������κ͸�����,�����ؿؼ���ֵ�ı����Ժ�,ȥ��Ӧ������ʾ�ؼ���ֵ
 * ����ʾ������:IntegerToSepInteger_OnPropertyChange(this)
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
 * ������:doMoneyGroup
 * ����:value Ҫ�ӷָ�����ַ���
 * ����ֵ:�ַ���
 * ����˵��:�ӷָ��
 * ����ʾ������:doMoneyGroup(100000)Ϊ100,000
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
 * ������:validNumber_sep
 * ����:obj ��������;colSize ���ֵ��ܳ���;precision С��λ�ĳ���
 * ����ֵ:true or false
 * ����˵��:У�������������Ϊ�Ϸ���Number,ר�ô��ָ���Ŀؼ�ʹ��
 * ����ʾ������:validNumber_sep(this,8,3)
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
        var m = checkStr.length;                      //����ֵ��λ��
        var n = checkStr.indexOf(".");                //��.����λ��
        var k = checkStr.indexOf("-");                //��-����λ��
        var j;                                        //��������
        var i;                                        //С������

	//�������ֵ�к��С�.������ȡ����ֵ���������ȣ�
 	if(n > -1){
           	//�������ֵ�к��С�����
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
           	//�������ֵ�к��С�����
           	if(k > -1){
  			j = m - 1;
           	}
                else{
                  	j = m;
                }
                i = 0;
 	}
      	//��������ֵ���������Ⱥ�С������
      	if((j > colSize - precision) || (i > precision)){
                alert(checkStr + "�ľ��Ȳ�����Ҫ����������С�ڵ���" + (colSize - precision) + "��С������С�ڵ���" + precision + "��");
                obj.focus();
                return false
      	}
        return true;
}
/**---------------------------У�麯������---------------------------------------*/





/**---------------------------���㺯����ʼ---------------------------------------*/

/**
 * ������:mpcFormatNumber
 * ����:srcStr Ҫ���и�ʽ�����ַ���;nAfterDot ƽ������λ��һ��","�ָ�
 * ����ֵ:��ʽ������ַ���
 * ����˵��:���ַ������и�ʽ��,����λ��һ��","�ָ�
 * ����ʾ������:Var Str1 = mpcFormatNumber("10000000",3) Str1��ֵΪ "10,000,000";
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
 * ������:putUniqueSql
 * ����:fieldCode �ֶδ���;inputValue �ֶ�ֵ;fieldType ƴ������;relation �ȽϹ�ϵ
 * ����ֵ:ƴ�Ӻõ�sql���
 * ����˵��:���ڸ����ֶ�����ƴSQL���
 * fieldTypeΪ1,2,3
 * "1"��ʾinputValueΪ�ַ���ֵ
 * "2"��ʾinputValueΪ��ֵ
 * "3"��ʾinputValueΪ����
 * ����ʾ������:Var str1 = putUniqueSql("rowid","1001","1","=") Str1 Ϊ rowed = '1001'
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
 * ������:.trim()
 * ����:��
 * ����ֵ:��ȥ�����ҿո���ַ���
 * ����˵��:����js�е�string���͵�ԭ�ͺ���,����ȥ�����ҿո�
 * ����ʾ������:Var String1 = "  sdsd   ";String1.trim();
 */
String.prototype.trim = function()
{
    return this.replace(/(^[\s|��]*)|([\s|��]*$)/g, "");
}

/**
 * ������:ltrim
 * ����:s ��ȥ�ո���ַ���
 * ����ֵ:��ȥ����ո���ַ���
 * ����˵��:ȥ��ո�
 * ����ʾ������:ltrim("   ssss")
 */
function ltrim(s){
 return s.replace( /^\s*/, "");
}

/**
 * ������:rtrim
 * ����:s ��ȥ�ո���ַ���
 * ����ֵ:��ȥ���ҿո���ַ���
 * ����˵��:ȥ�ҿո�
 * ����ʾ������:rtrim("ssss   ")
 */
function rtrim(s){
 return s.replace( /\s*$/, "");
}

/**
 * ������:trim
 * ����:s ��ȥ�ո���ַ���
 * ����ֵ:��ȥ�����ҿո���ַ���
 * ����˵��:ȥ�ַ��������ҿո�
 * ����ʾ������:trim("  ssssssss  ")
 */
function trim(s){
 return rtrim(ltrim(s));
}

/**
 * ������:trimNC
 * ����:s ����ȡ�ַ���
 * ����ֵ:��ȡ����ַ���
 * ����˵��:��ȡ�ַ���ǰ��Ŀ��ַ��س����ͻ��з�
 * ����ʾ������:trimNC("sd
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
 * ������:replaceStr
 * ����:str ���û����ַ���
 * ����ֵ:���û�����ַ���
 * ����˵��:��GET���������ύʱ,���������ַ����û�
 * ����ʾ������:replaceStr("sdsd=+-sdsd")
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
 * ������:strLength
 * ����:s ��Ҫ�õ����ȵ��ַ���
 * ����ֵ:�õ����ַ�������
 * ����˵��:�õ�һ���ַ����ĳ���,��ʾ�ĳ���,һ�����ֻ��պ��ĳ���Ϊ2,Ӣ���ַ�����Ϊ1
 * ����ʾ������:strLength("����112")ֵΪ7
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



/**---------------------------���㺯������---------------------------------------*/






/**---------------------------ȡֵ������ʼ---------------------------------------*/

/**
 * ������:getClientSysDate
 * ����:��
 * ����ֵ:���ؿͻ��˵�ϵͳ����
 * ����˵��:��ÿͻ��˵�ϵͳ���� ;������֮����"-"����
 * ����ʾ������:getClientSysDate()
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
 * ������:getClientSysTime
 * ����:��
 * ����ֵ:��ÿͻ��˵�ϵͳʱ��;������֮����"-"����,ʱ����֮����":"����
 * ����˵��:���ؿͻ��˵�ϵͳʱ��
 * ����ʾ������:getClientSysTime()
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
 * ������:getCheckedValue
 * ����:objName grid�е�radio��checkbox������
 * ����ֵ:�ַ���
 * ����˵��:���grid�е�radio��checkbox��ֵ�������radio�򷵻�һ���ַ����������checkbox�򷵻ض���ַ������м��ö��Ÿ�����
 * ����ʾ������:getCheckedValue(document.all.checkbox)
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
 * ������:getCheckedIndex
 * ����:objName grid�е�radio��checkbox������
 * ����ֵ:�ַ���
 * ����˵��:��ñ�ѡ��radio��checkbox������,�����radio�򷵻�һ�������������checkbox�򷵻����������м��ö��Ÿ�����
 * ����ʾ������:getCheckedIndex(document.all.checkbox)
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
 * ������:getObjValue
 * ����:objName ���������
 * ����ֵ:���ȥ�����ҿո���ֵ
 * ����˵��:���ҳ���������ֵ,����ȥ�����ҿո�
 * ����ʾ������:getObjValue("rowId")
 */
function getObjValue(objName)
{
	//alert();
	var obj = eval("document.all('" + objName + "')");
        if(obj == null) return "null";
      	return obj.value.trim();
}

/**
 * ������:getObjInnerHtml
 * ����:objName ���������
 * ����ֵ:�����innerHTMLֵ
 * ����˵��:���ҳ����id��innerHTMLֵ,���innerHTMLֵ�а���label��ȡlabel�е�innerHTMLֵ��
 * ����ʾ������:getObjInnerHtml("userName")
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
 * ������:getCellValue
 * ����:checkObjName Checkbox������;cellObjName �е��ֶε�����
 * ����ֵ:�ֶε�ֵ
 * ����˵��:���ҳ��table�б�ѡ�����б����ֶ�ֵ��ֵ������ǵ�ѡ�򷵻�һ���ַ���������Ƕ�ѡ�򷵻ض���ַ������м��ö��Ÿ���;
 * ����ʾ������:getCellValue("checkboxName","userName")
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
 * ������:getSelectObjName
 * ����:objName ���������
 * ����ֵ:�������ʾֵ
 * ����˵��:���ҳ����select�������ʾֵ
 * ����ʾ������:getSelectObjName("����������")
 */
function getSelectObjName(objName)
{
	var obj = eval("document.all('" + objName + "')");
      	var selfSelectedIndex = obj.selectedIndex;
      	selectObjName = obj[selfSelectedIndex].innerHTML;
      	if(selectObjName == "��ѡ��"){
                selectObjName = "&nbsp;";
      	}
      	return selectObjName;
}

/**
 * ������:getObjType
 * ����:objName ���������
 * ����ֵ:���������
 * ����˵��:���ҳ�������������
 * ����ʾ������:getObjType(objName)
 */
function getObjType(objName)
{
	var obj = eval("document.all('" + objName + "')");
    return obj.type;
}

/**
 * ������:getObjDisplayValue
 * ����:objName ���������
 * ����ֵ:�������ʾֵ
 * ����˵��:���ҳ�����������ʾֵ��ĿǰרΪ��������޸�
 * ����ʾ������:getObjDisplayValue(objName)
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
 * ������:setObjValue
 * ����:objName Ҫ��ֵ���������;objNameValue Ҫ����ֵ
 * ����ֵ:��
 * ����˵��:����ҳ���������ֵ
 * ����ʾ������:setObjValue(objName,objNameValue)
 */
function setObjValue(objName,objNameValue)
{
	var obj = eval("document.all('" + objName + "')");
	if(!(typeof(obj)=="object"))return '';
	obj.value = objNameValue;
}

/**
 * ������:setNoChecked
 * ����:objName Radio������
 * ����ֵ:��
 * ����˵��:ʹ��grid�е�radio������ѡ��
 * ����ʾ������:setNoChecked(objName)
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
 * ������:getPostValue
 * ����:objName Checkbox��radio������
 * ����ֵ:�ַ���
 * ����˵��:���ѡ�ж����postֵ,�����radio���ص���ֵ�������checkbox���ض���ö��Ÿ�����ֵ
 * ����ʾ������:getPostValue(objName)
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
 * ������:deleteRows
 * ����:objName Checkbox��radio������
 * ����ֵ:��
 * ����˵��:����ѡ�еļ�¼ɾ����,ֻ��������ɾ������
 * ����ʾ������:deleteRows(objName)
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
 * ������:deleteRow
 * ����:ɾ��һ�� obj:�ж���isHiddenRow:
 * ����ֵ:��
 * ����˵��:�������ؼ���ֵ�����������Ƿ�������
 * ����ʾ������:deleteRow(obj,isHiddenRow)
 */
function deleteRow(obj,isHiddenRow)
{
  var cell = obj.parentElement;//ȡthis������ΪCELL
  var row = cell.parentElement; //ȡcell������ΪROW
  clearRow(row);//�������text��ֵ
  if (isHiddenRow==true){
  	hideRow(row);//������
  }
  return true;
}

/**
 * ������:clearRow
 * ����: obj:�ж���
 * ����ֵ:��
 * ����˵��:���һ��������text��ֵ
 * ����ʾ������:clearRow(obj)
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
       		
       		//���ڿؼ�clear����
       		if(child.className != 'undefined' && child.className == 'DPFrame') {
	          child.lastChild.value = "";
	        }
	        
	        //lookup�ؼ�clear����
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
 * ������:showRow
 * ����: obj:�ж���
 * ����ֵ:��
 * ����˵��:��ʾһ��
 * ����ʾ������:showRow(obj)
 */
function showRow(obj)
{
   obj.style.display = "";
   return true;
}

/**
 * ������:hideRow
 * ����: obj:�ж���
 * ����ֵ:��
 * ����˵��:����һ��
 * ����ʾ������:hideRow(obj)
 */
function hideRow(obj)
{
  obj.style.display = "none";
  return true;
}

/**
 * ������:getAlldata
 * ����:obj Form����
 * ����ֵ:�ַ���
 * ����˵��:�õ�From������Ԫ�ص�NAME��ֵ�������GET������Ҫ���[name]=[value]&...[name]=[value]��
 * ����ʾ������:getAlldata(document.all.form[0])
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
 * ������:getChineseName
 * ����:this Ҫ��õ�ǰ������������
 * ����ֵ:�ַ���
 * ����˵��:������õ�ǰ�������ǰ���Ӧ����������
 * ����ʾ������:getChineseName(this)
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
 * ������:getCaret
 * ����:this Ҫ��õ�ǰ������������
 * ����ֵ:����
 * ����˵��:ȡ��ǰ����λ��
 * ����ʾ������:getCaret(this)
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
 * ������:getWholeTime
 * ����:name Ҫ��õ�ǰ������������
 * ����ֵ:��
 * ����˵��:���õ�ǰ����ʱ��ؼ���ֵ
 * ����ʾ������:getWholeTime(name)
 */
function getWholeTime(name)
{
  setObjValue(name,getObjValue(name+"_date") + " " + getObjValue(name+"_hms"));
}
/**---------------------------ȡֵ��������---------------------------------------*/




/**---------------------------����������ʼ---------------------------------------*/


/**
 * ������:execProc
 * ����:procName �洢������;args ���ò���
 * ����ֵ:�ַ������ͣ��෵��ֵ�Զ��ŷָ������ó�������-1��
 * ����˵��:����xmlhttp��ʽ����̨ȥ���ô洢����
 * ����ʾ������:execProc("PRC_GET_ROW_ID_1","2004-11-19:DATE:INT,DATE")
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
 * ������:execUpdate
 * ����:sql SQL���
 * ����ֵ:�ַ������ͣ�����0��ʾִ�гɹ�������1��ʾִ��ʧ�ܡ�������ó�������-1��
 * ����˵��:ִ�и��²���SQL����;sql Ҫִ�е�SQL,ֻ֧�ָ��²���SQL,�����ӡ�ɾ�����޸ģ�ʹ��SQL �﷨
 * ����ʾ������:execUpdate("INSERT INTO AD_LOV_CODE(row_id,lov_code) VALUES ('1234567','123466')")
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
 * ������:fhiddenifLookupTB
 * ����:��
 * ����ֵ:��
 * ����˵��:��������ҳ���ϵ�lookup��iframe.
 * ����ʾ������:fhiddenifLookupTB()
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
 * ������:validDocStatus
 * ����:��
 * ����ֵ:ҳ��״ֵ̬true ���� false
 * ����˵��:��ҳ����POST��ʽ�����ύʱ,����ͨ���˷���,�ж�ҳ��״̬
 * ����ʾ������:Var status = validDocStatus(); Status Ϊ true or false
 */
function validDocStatus()
{
  if(document.readyState=="loading")
  {
     alert("�������ڴ�����ȴ������������");
     return false;
  }
  return true;
}


/**
 * ������:fhiddenParifLookupTB
 * ����:��
 * ����ֵ:��
 * ����˵��:��������ҳ���ϵ�lookup��iframe.�������ҳ����iframe�����ҳ��
 * ����ʾ������:fhiddenParifLookupTB()
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
 * ������:fLookupTB
 * ����:objSender Ҫ��ʾiframe��ҳ��ؼ�;strUrl Ҫ��ʾ��iframe�����strUrl;width ��ʾ��iframe��ҳ��ĳ���;height ��ʾ��iframe��ҳ��ĸ߶�
 * ����ֵ:��
 * ����˵��:������ʾҳ���ϵ�lookup��iframe
 * ����ʾ������:fLookupTB(this," http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do",400,300)
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
 * ������:fhiddenifListBox
 * ����:��
 * ����ֵ:��
 * ����˵��:��������ҳ����listBox��iframe
 * ����ʾ������:fhiddenifListBox()
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
 * ������:fhiddenParifListBox
 * ����:��
 * ����ֵ:��
 * ����˵��:��������ҳ����listBox��iframe,�������iframe�����ҳ��
 * ����ʾ������:fhiddenParifListBox()
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
 * ������:fListBox
 * ����:objSender Ҫ��ʾiframe��ҳ��ؼ�;strUrl Iframe��������ʾ��ҳ��;width Iframe�Ŀ��;height Iframe�ĸ߶�
 * ����ֵ:��
 * ����˵��:��ʾҳ���ϵ�listBox��iframe
 * ����ʾ������:fListBox(this," http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do",400,200)
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
 * ������:getShowRowCount
 * ����:obj �����
 * ����ֵ:������
 * ����˵��:��ǰ�����,ȥ�������к��������
 * ����ʾ������:getShowRowCount(obj)
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
 * ������:sumCol
 * ����:obj Ҫ���ܵı�������;prefix ǰ׺: Ҫ�����е�������ǰ׺;sumColName �����е�����;setColName ��Ż���ֵ������;nDec ����ֵ�ľ���
 * ����ֵ:��
 * ����˵��:����ָ������е�ָ��sumColName��ֵ��setColName
 * ����ʾ������:sumCol("dataTable","orderDetail","quantOrder","totQuantOrder",0)
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
 * ������:setFocus
 * ����:prefix ������ǰ׺;id �ڼ���;col ����
 * ����ֵ:��
 * ����˵��:�ƶ���굽����ָ���е�,ָ�����ֶ�
 * ����ʾ������:setFocus("orderDetail",id,"quantOrder")
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
 * ������:httpGet
 * ����:http Xmlhttp����;url Ҫ���ҳ���URL
 * ����ֵ:����ҳ���HTML����Ϊ���ַ���
 * ����˵��:����xmlhttp����ȥ�ж���Ӧ��URL��ָ���ҳ��,�Ƿ����
 * ����ʾ������:httpGet(xmlhttp," http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do")
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
		 alert("ϵͳ��ѯʧ�ܣ�");
         return "";
	}
    return strRet;
}

/**
 * ������:openDialog
 * ����:WINurl ������ҳ���url;WINwidth ���ڵĿ��;WINheight ���ڵĸ߶�;xyPosition �򿪴���λ��
 * ����ֵ:��
 * ����˵��:ָ������λ�ô�ģ̬���� xyPosition Ϊ 0ʱ, ����Ļ�����ģ̬���� xyPosition ��Ϊ 0 ʱ,���¼�Դ������ģ̬����
 * ����ʾ������:openDialog(" http://localhost:6767/t4new/tr/cheque/checkIn/CheckInList.do",400,300,0)
 */
function openDialog(WINurl,WINwidth,WINheight,xyPosition)
{
 if(xyPosition==0)//��Ļ����
   {
    showx = (window.screen.availWidth  - WINwidth)/2;
    showy = (window.screen.availHeight - WINheight)/2;
   }
 else//�¼�����
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
 * ������:ExportExcel
 * ����:��
 * ����ֵ:��
 * ����˵��:���û����CELL���,����Ϊexcel
 * ����ʾ������:ExportExcel()
 */
function ExportExcel()
{
  var cell1;
  cell1=document.all("objCellID");
  cell1.DoExportExcelFile("");

}


/**
 * ������:onprint
 * ����:��
 * ����ֵ:��
 * ����˵��:���û����CELL���,���д�ӡ
 * ����ʾ������:onprint()
 */
function onprint()
{
  var cell1;
  cell1=document.all("objCellID");
  cell1.DoPrint(1);
}

/**
 * ������:onprintpreview
 * ����:��
 * ����ֵ:��
 * ����˵��:���û����CELL���,���д�ӡԤ��
 * ����ʾ������:onprintpreview()
 */
function onprintpreview()
{
  var cell1;
  cell1=document.all("objCellID");
  cell1.DoPrintPreview(1);
}

/**
 * ������:affixmanage
 * ����:��
 * ����ֵ:��
 * ����˵��:��������ť���������ڴ��ݲ�������ģ̬����
 * ����ʾ������:affixmanage()
 */
function affixmanage(){
  	//�ж��Ƿ�ѡ�м�¼��
  	if(hasSelectedRecord('chk'))
    	{
              	//��ȡ���������ֶε�ֵ��
              	main_table_code = getObjValue("main_table_code");
              	//��ȡѡ�м�¼��row_idֵ��
		record_id = getCheckedValue('chk');
  		str = "table_code=" + main_table_code + "&record_id=" + record_id
              	//�򿪸��������ģ̬���ڣ�
              	window.showModalDialog('../../../../lightclient/services/filemgr/FilemanagerList.do?'+str,self,'help:no;status:no;dialogWidth:' + (availWidthScreen-availWidthScreenDifference)
    		+'px;dialogHeight:' + (availHeightScreen-availHeightScreenDifference) + 'px;');
    	}
    	else{
        	alert("��ѡ���¼��");
    	}
}

/**
 * ������:setInputFocus
 * ����:objName Ҫ�ý��Ŀؼ�������
 * ����ֵ:��
 * ����˵��:��ָ���ؼ��ý���
 * ����ʾ������:setInputFocus("objName")
 */
function setInputFocus(objName){
  	var obj = eval("document.all('" + objName + "')");
    if(obj.style.display == "none") {
    }else {
      obj.focus();
    }

}

/**
 * ������:tabChange
 * ����:tabIndex Ҫ�л���tabҳ��;tabTotal Tabҳ������
 * ����ֵ:��
 * ����˵��:���ڶ��ƵĶ�tab��ϸ֮����л�
 * ����ʾ������:tabChange(3,5)
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
 * ������:onRowMouseOver
 * ����:trHandle �ж���
 * ����ֵ:��
 * ����˵��:������ƶ���ĳһ��ʱ���ı���һ�����е�Ԫ�صı���ɫ
 * ����ʾ������:onRowMouseOver(trHandle) trHandleΪҪ�ı�䱳��ɫ���ж�������
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
 * ������:onRowMouseOut
 * ����:trHandle �ж���
 * ����ֵ:��
 * ����˵��:������뿪ĳһ��ʱ���ָ���һ�����е�Ԫ�صı���ɫ
 * ����ʾ������:onRowMouseOut(trHandle) trHandleΪҪ�ָ�����ɫ���ж��������
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
 * ������:sortGrid
 * ����:obj Ҫ�����ͼ�����;fName Ҫ����Ŀؼ�������;mode ҳ���������view ���� edit
 * ����ֵ: ��
 * ����˵��:��grid ����ҳ��ĵ�ҳ����
 * ����ʾ������:sortGrid(this,"userName","view")
 */
function sortGrid(obj,fName,mode) {
   var objGridTable = document.all.dataTable;
   var objAllRows = objGridTable.rows;
   if(obj.alt=='����') {
     for(var i = 1; i < objGridTable.rows.length;i++) {
       for(var j = 1; j < objGridTable.rows.length-i; j++) {
     	 if(getGridCompareValue(objAllRows,j,fName,mode) > getGridCompareValue(objAllRows,j+1,fName,mode)) {
     	   objGridTable.moveRow(j,j+1);
     	 }
        }
     }
     obj.alt="����";
     obj.src=ctx + "/images/sortDown.gif";
   }else if(obj.alt=='����') {
     for(var i = 1; i < objGridTable.rows.length;i++) {
       for(var j = 1; j < objGridTable.rows.length-i; j++) {
         if(getGridCompareValue(objAllRows,j,fName,mode) < getGridCompareValue(objAllRows,j+1,fName,mode)) {
           objGridTable.moveRow(j,j+1);
     	  }
       }
      }
      obj.alt="����";
      obj.src=ctx + "/images/sortUp.gif";
   }
}


/**
 * ������:string2date
 * ����:strDate Ҫ��ʽ�����ַ���
 * ����ֵ:Date����
 * ����˵��:��һ���ַ�����ʽ������ת��Ϊ������ʽ
 * ����ʾ������:string2date("2004/2/9")
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
 * ������:getTrimText
 * ����:textfield �ؼ�text����
 * ����ֵ:��
 * ����˵��:���˵��ؼ�text��ǰ��ո񣬲�������ֵ
 * ����ʾ������:getTrimText(textfield) textfieldΪҪ���˵Ķ���
 */
function getTrimText(textfield)
{
  var value = textfield.value;
  textfield.value = trim(value);

  return textfield.value;
}

/**
 * ������:setMainFocus
 * ����:col ΪҪ�ý��Ķ���
 * ����ֵ:��
 * ����˵��:�û����س���ʱ,���ù�굽��һ���ؼ�,�ý�.
 * ����ʾ������:setMainFocus(col) colΪҪ�ý��Ķ���
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
 * ������:disableTable
 * ����:obj Ҫdisable�ı����
 * ����ֵ:��
 * ����˵��:������е�������,�ж�disableʹ�û�����ѡ��
 * ����ʾ������:disableTable(obj) objΪ�����
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
 * ������:disableRow
 * ����:obj �ж�������
 * ����ֵ:��
 * ����˵��:��һ��������input �ؼ�disable.
 * ����ʾ������:disableRow(obj),objΪ�ж�������
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
 * ������:clearTable
 * ����:obj Ҫ���ֵ�ı����
 * ����ֵ:��
 * ����˵��:������������text���ֵ
 * ����ʾ������:clearTable(obj),objΪ���������
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
 * ������:enterToTab
 * ����:��
 * ����ֵ:��
 * ����˵��:���س���ת����TAB
 * ����ʾ������:enterToTab()
 */
function enterToTab(){
  if(event.srcElement.type != 'button' && event.srcElement.type != 'textarea' && event.keyCode == 13){
    event.keyCode = 9;
  }
}

/**
 * ������:changeCheckboxDisplayValue
 * ����:obj ����Ŀؼ�;checkValue ѡ��ʱ��ֵ;unCheckValue ��ѡ��ʱ��ֵ
 * ����ֵ:��
 * ����˵��:�ı����ؿؼ���ֵ
 * ����ʾ������:changeCheckboxHiddenValue(this,1,0)
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
 * ������:Checkbox_OnPropertyChange
 * ����:obj ����Ŀؼ�;checkValue ѡ��ʱ��ֵ;unCheckValue ��ѡ��ʱ��ֵ
 * ����ֵ:��
 * ����˵��:�ı�checkbox��ѡ��״̬
 * ����ʾ������:Checkbox_OnPropertyChange(this,1,0)
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
 * ������:selectToInput
 * ����:obj ����Ŀؼ�
 * ����ֵ:��
 * ����˵��:��SELECT�ؼ�Ϊֻ��ʱ,ʹ��select�ؼ�ֵ�����ص�input�����ֵͬ��
 * ����ʾ������:selectToInput(this)
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
 * ������:codeInputToSelect
 * ����:obj ����Ŀؼ�;
 * ����ֵ:��
 * ����˵��:��SELECT�ؼ�Ϊֻ��ʱ,ʹ�����ص�input�����ֵ��select�ؼ�ֵͬ��
 * ����ʾ������:codeInputToSelect(this)
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
		alert("���ؿؼ���ֵ�����������ֵ����Ӧ!!! ");
	}

}

/**
 * ������:radioInputToRadio
 * ����:obj ����Ŀؼ�;
 * ����ֵ:��
 * ����˵��:ʹ�����ص�input�����ֵ��radiogroup�ؼ�ֵͬ��
 * ����ʾ������:radioInputToRadio(this)
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
	  	//alert("û�������ֵ!!!");
	  }
	}
	if (flag == false) {
		alert("û�������ֵ!!!");
	}

}

/**
 * ������:radioToRadioInput
 * ����:obj ����Ŀؼ�;
 * ����ֵ:��
 * ����˵��:ʹ��radiogroup�ؼ�ֵ�����ص�input�����ֵͬ��
 * ����ʾ������:radioToRadioInput(this)
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
 * ������:checkboxTocheckboxInput
 * ����:obj ����Ŀؼ�;
 * ����ֵ:��
 * ����˵��:ʹ��checkboxgroup�ؼ�ֵ�����ص�input�����ֵͬ��
 * ����ʾ������:checkboxTocheckboxInput(this)
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
 * ������:checkboxInputTocheckbox
 * ����:obj ����Ŀؼ�;
 * ����ֵ:��
 * ����˵��:ʹ�����ص�input�����ֵ��checkboxgroup�ؼ�ֵͬ��
 * ����ʾ������:checkboxInputTocheckbox(this)
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
	//	alert("û�������ֵ!!!");
	}

}
/**
 * ������:exec
 * ����:url �ύ��·��;postPara ���ݵĲ���
 * ����ֵ:xmlhttp.responseText ״̬��־λ
 * ����˵��:��postPara��Ϊ���ݵĲ���,����url
 * ����ʾ������:exec("xxxAcition?",postPara)
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
 * ������:xmlInvoke
 * ����:url �ύ��·��
 * ����ֵ:returnText 
 * ����˵��:xmlHttp���õ�ͨ�ú���
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
     xmlObj.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");  //����content type����Ϊ�����ݷ���
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
  var msg="û�з�����Ϣ��";
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
            curtime=curmin+"��"+cursec+"�룡"
        else
            curtime=cursec+"�룡";
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

//���ָ�ʽ������
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

//GRID�����չ�۵�
function grid_display(obj) {
	var gridExpandFlag = getObjValue("gridExpandFlag");
	var displayType = "";
	if (gridExpandFlag == "1") {
		displayType = "none";
		setObjValue("gridExpandFlag","0");
		obj.src = ctx + "/images/expand_arrow.jpg";
		obj.alt = "չ��";
		window.lcfGridTable.style.display = displayType;
	}else {
		displayType = "";
		setObjValue("gridExpandFlag","1");
		obj.src = ctx + "/images/pucker_arrow.jpg";
		obj.alt = "�۵�";
		window.lcfGridTable.style.display = displayType;
	}

}

//��GRID�����չ�۵�
function mult_grid_display(obj) {
	var multGridExpandFlag = getObjValue("multGridExpandFlag");
	var displayType = "";
	if (multGridExpandFlag == "1") {
		displayType = "none";
		setObjValue("multGridExpandFlag","0");
		obj.src = ctx + "/images/expand_arrow.jpg";
		obj.alt = "չ��";
		window.multGridTable.style.display = displayType;
	}else {
		displayType = "";
		setObjValue("multGridExpandFlag","1");
		obj.src = ctx + "/images/pucker_arrow.jpg";
		obj.alt = "�۵�";
		window.multGridTable.style.display = displayType;
	}

}


//�������չ�۵�
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
          obj.alt = "չ��";
        }
        else{
          displayType = "";
          setObjValue(lineName + "_flag","1")
          obj.src =ctx + "/images/pucker_arrow.jpg";
          obj.alt = "�۵�";
        }
        for(var i=parseInt(begin_tr);i<parseInt(end_tr);i++){
        	 window.table_form.rows(i).style.display = displayType;
        }
}


//ȫ�������չ
function pannel_Expand_all() {
  if(document.all.panel_display_all_img != undefined) {
    pannel_Expand_all_has_allExpandButton();
  }
  if(document.all.gridImg != undefined) {
    window.lcfGridTable.style.display = "";
  }

}
//ȫ�������չ��ȫչ��ťʱ
function pannel_Expand_all_has_allExpandButton() {
        var obj = document.all.panel_display_all_img;
	var allPannelRows = getObjValue("allPannelRows");
        var allPannelRows_flag = getObjValue("allPannelRows_flag");
        var allPannelRowsArray = allPannelRows.split(";");
        displayType = "";
        setObjValue("allPannelRows_flag","1");
        obj.src =ctx + "/images/all_pucker_arrow.jpg";
        obj.alt = "ȫ���۵�";
        for(var i=1;i<allPannelRowsArray.length;i++){
         	var lineName = allPannelRowsArray[i].split(",")[0];
            	var begin_tr = allPannelRowsArray[i].split(",")[1];
               	var end_tr = allPannelRowsArray[i].split(",")[2];
                eval("document.all." + lineName + "_img").src = ctx + "/images/pucker_arrow.jpg";
                eval("document.all." + lineName + "_img").alt = "�۵�";
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
          document.all.gridImg.alt = "�۵�";
	  window.lcfGridTable.style.display = displayType;

        }
        var multGridExpandFlag = getObjValue("multGridExpandFlag");
        if (multGridExpandFlag == "null") {
        }else {

          displayType = "";
	  setObjValue("multGridExpandFlag","1");
	  document.all.multGridImg.src = ctx + "/images/pucker_arrow.jpg";
	  document.all.multGridImg.alt = "�۵�";
	  window.multGridTable.style.display = displayType;
          }

}

//ȫ�������չ�۵�
function pannel_display_all(obj){
	var allPannelRows = getObjValue("allPannelRows");
        var allPannelRows_flag = getObjValue("allPannelRows_flag");
        var allPannelRowsArray = allPannelRows.split(";");

        if(allPannelRows_flag == "1"){
          displayType = "none";
          setObjValue("allPannelRows_flag","0");
          obj.src =ctx + "/images/all_expand_arrow.jpg";
          obj.alt = "ȫ��չ��";
        }
        else{
          displayType = "";
          setObjValue("allPannelRows_flag","1");
          obj.src =ctx + "/images/all_pucker_arrow.jpg";
          obj.alt = "ȫ���۵�";
        }
        for(var i=1;i<allPannelRowsArray.length;i++){
          	var lineName = allPannelRowsArray[i].split(",")[0];
            	var begin_tr = allPannelRowsArray[i].split(",")[1];
               	var end_tr = allPannelRowsArray[i].split(",")[2];

		if(allPannelRows_flag == "1"){
                  	eval("document.all." + lineName + "_img").src = ctx + "/images/expand_arrow.jpg";
                      	eval("document.all." + lineName + "_img").alt = "չ��";
                      	setObjValue(lineName + "_flag","0");
		}
                else{
                  	eval("document.all." + lineName + "_img").src = ctx + "/images/pucker_arrow.jpg";
                      	eval("document.all." + lineName + "_img").alt = "�۵�";
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
			document.all.gridImg.alt = "չ��";
			window.lcfGridTable.style.display = displayType;
        	}else {
        		displayType = "";
			setObjValue("gridExpandFlag","1");
			document.all.gridImg.src = ctx + "/images/pucker_arrow.jpg";
			document.all.gridImg.alt = "�۵�";
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
			document.all.multGridImg.alt = "չ��";
			window.multGridTable.style.display = displayType;
        	}else {
        		displayType = "";
			setObjValue("multGridExpandFlag","1");
			document.all.multGridImg.src = ctx + "/images/pucker_arrow.jpg";
			document.all.multGridImg.alt = "�۵�";
			window.multGridTable.style.display = displayType;
        	}
        }
}

/**
* Ψһ��У��
* para:code		���룬���ݿ���ֶ���
* para:value		ֵ����ҪУ���ֵ
* para:tableName	����
* para:condition	��У��Ĳ�ѯ����
* para:action		��ǰ�������ͣ���edit��,"add"��
* para:id		������޸ĵ�ʱ������Ҫ�������ֵ
* para:ctx		�����ĸ�
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

//���ƿؼ����ַ����ĳ���  ��Ҫ���õĿؼ�������onpropertychange,ʹ���ڿ��Ƹ����ı��༭�ؼ����ַ�������
function textLengthControl(obj,len)
{
    if(obj.value.length>len)
    {
        alert("��¼������ݳ����˸��ֶε��޶�����!");
        obj.value=obj.value.substring(0,len);
    }
}



function oneRowBack() {
 if(document.all("dataTable").rows.length==2){
   document.all("chk")[0].checked = true;
   commonSelectDate("one");
 }
}



//��GRID����ҳ������ʱ,ȡ�Ƚϵ��ֶ�ֵ
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
//ȫѡorderAmount�ֶ�����
{
          obj.select();
}

//add by jialiang
//��ȡ��Ŀ���ͽṹ����ֵ
/*
��������getTreeInfo
������companyId ��˾���
            fiscalYear ������
            element_id code��id��ҳ��ؼ�����
            element_name ��Ŀ���Ƶ�ҳ��ؼ�����
            returnType  ����ֵ����    1 id  2  name 3 code  4 id+name  5 code+name   6 ֻ��ĩ����Ŀ����
             isMultiTree ���ͽṹ y ��ѡ n ��ѡ    Ĭ��Ϊ��ѡ
             fiscalYearElement ���fiscalYear��Ҫ��ǰ̨���Ƶ����������ҳ��ؼ�����
             filter  �������� ������ȡ�û�ƿ�Ŀ������
*/
function getTreeInfo(contextName,companyId,fiscalYear,element_id,element_name,returnType,isMultiTree,fiscalYearElement,filter) {
      var returnValue ='';
      if(fiscalYear==''){
           fiscalYear = document.getElementById(fiscalYearElement).value;
      }
      //��ѡ��
     if(isMultiTree == 'y'){
          returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/MultiTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&filter="+filter,returnType,"status=0"); //status��0��������ȥ���߿�
     }
     //��ѡ��
     else{

         if(filter==null){
            filter = "";
         }
         returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/RadioTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&filter="+filter,returnType,"status=0");
     }
     //����ֵΪ��
     if(returnValue==null) returnValue='';
     //����ֵ��Ŀid code
     if(returnType == 1||returnType ==3|| returnType ==6){
          document.getElementById(element_id).value = returnValue;
     }
     //����ֵ��Ŀ����
     if(returnType == 2){
     alert(returnValue);
          document.getElementById(element_name).value = returnValue;
     }
     //����ֵ4: id��name,5: code+name
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
//��ȡ�������Ŀ���ͽṹ����ֵ
/*
��������getControlAreaTreeInfo
������  controlAreaId ������ id
             companyId ��˾���
             fiscalYear ������
             includeSelf_YN �Ƿ��������
            element_id code��id��ҳ��ؼ�����
            element_name ��Ŀ���Ƶ�ҳ��ؼ�����
            returnType  ����ֵ����    1 id  2  name 3 code  4 id+name  5 code+name   7  id +code
            isMultiTree ���ͽṹ y ��ѡ n ��ѡ    Ĭ��Ϊ��ѡ
            fiscalYearElement ���fiscalYear��Ҫ��ǰ̨���Ƶ����������ҳ��ؼ�����
            filter  �������� ������ȡ�û�ƿ�Ŀ������
*/
function getControlAreaTreeInfo(contextName,controlAreaId,companyId,fiscalYear,includeSelf_YN,element_id,element_name,returnType,isMultiTree,fiscalYearElement){
      var returnValue ='';
      if(fiscalYear==''){
           fiscalYear = document.getElementById(fiscalYearElement).value;
      }
      //��ѡ��
     if(isMultiTree == 'y'){
          returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/ControlAreaMultiTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&controlAreaId="+controlAreaId+"&includeSelf_YN="+includeSelf_YN,returnType,"status=0"); //status��0��������ȥ���߿�
     }
     //��ѡ��
     else{
         returnValue =  window.showModalDialog(contextName+"/mpc/util/tree/ControlAreaTreeFrame.jsp?fiscalYear="+fiscalYear+"&companyId="+companyId+"&controlAreaId="+controlAreaId+"&includeSelf_YN="+includeSelf_YN,returnType,"status=0"); //status��0��������ȥ���߿�
     }
     //����ֵΪ��
     if(returnValue==null) returnValue='';
     //����ֵ��Ŀid code
     if(returnType == 1||returnType ==3){
          document.getElementById(element_id).value = returnValue;
     }
     //����ֵ��Ŀ����
     if(returnType == 2){
     alert(returnValue);
          document.getElementById(element_name).value = returnValue;
     }
     //����ֵ4: id��name,5: code+name;6:id+code
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
//ֻ������text����������ĸ������
function ValidInput(){
    if((event.keyCode>=32&&event.keyCode<48)||(event.keyCode>57&&event.keyCode<65)||(event.keyCode>90&&event.keyCode<97)||(event.keyCode>122&&event.keyCode<127))
    {
        event.returnValue =false;
    }
}
//add by jialiang
//�����������ͽṹ
/*
��������getLookupTree
������
     tagType ��ѯ����Ϣʱselect����Ҫ���ֶ�����,ǰ�ĸ�������id,name.parentId,findId
                    �����Ƿ���ֵ����������ӵ��Ǳ����arrayPagePara��Ӧ,������ʽΪ
     arrayPagePara ��������Ϣ��ҳ��ؼ�����,��arrayTreePara��Ӧ,������ʽ a@b@c
     treeType      ��������,һ�㲻��Ҫ
*/
function getLookupTree(contextPath,tagType,condition,arrayPagePara,treeType)
{
     var returnValue = "";
     returnValue =  window.showModalDialog(contextPath+"/mpc/util/tree/LookUpTreeFrame.jsp?tagType="+tagType+"&condition="+condition+"&treeType="+treeType,"status=0"); //status��0��������ȥ���߿�
     var arrayPage =  arrayPagePara.split('@');
     var arrayReturnValue = returnValue.split('@');
     for(var count = 0;count<arrayReturnValue.length;count++){
       document.getElementById(arrayPage[count]).value = arrayReturnValue[count];
     }
}
/**
*��ѡ�������ͽṹ�ؼ�ǰ̨ʵ��
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
            //modify by jialiang at 2006-06-27  ��� ��onchangeWhere��������ֵΪ"-1"ʱonclickʧЧ����
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
        //ѭ��ÿ��ȡarrayPage��column��arrayReturnValue�е�column�Ƚ������ͬ���arrayReturnValue��
        //column��Ӧ��ֵ������arrayPage��pageElementΪ���ֵ�ҳ��Ԫ����
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
*��ѡ�������ͽṹ�ؼ�ǰ̨ʵ��
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
           //modify by jialiang at 2006-06-27  ��� ��onchangeWhere��������ֵΪ"-1"ʱonclickʧЧ����
           if(eval(changeWhereValue+"()")=='-1'){
                return false;
           }
           urlStr += "&onChangeWhereValue="+eval(changeWhereValue+"()");
	    }
	}
    var retval = window.showModalDialog(urlStr,args,"dialogWidth:"+width+"px; dialogHeight:"+height+"px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;help=no;");
    if(retval!=null&&retval!=''){
        //arrayPageΪҳ��Ԫ����������column@pageElement
        var arrayPage = returnRelation.split('@');
        //arrayReturnValueΪ����ֵ����
        var arrayReturnValue = retval.split('@');
        //�������Ԫ��
        for(var k = 0;k<=arrayPage.length-2;k=k+2){
            document.getElementById(arrayPage[k+1]).value = "";
        }
        //ѭ��ÿ��ȡarrayPage��column��arrayReturnValue�е�column�Ƚ������ͬ���arrayReturnValue��
        //column��Ӧ��ֵ������arrayPage��pageElementΪ���ֵ�ҳ��Ԫ����
        for(var k = 0;k<=arrayPage.length-2;k=k+2){
            for(var count = 0;count<=arrayReturnValue.length-2;count=count+2){
                if(arrayPage[k]==arrayReturnValue[count]){
                    //��һ�η�ֵʱҳ��Ԫ��Ϊ��
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

//��ѯ�����������ܺ�������add by liuxiaoyan
function query_panel_display(obj) {
	var displayType = "";
	//var src=obj.src;
	//var prefix=src.substring(0,src.indexOf("query"));
	if(document.all.showtable.value.length>0){
		displayType = "none";
		//document.all.push_up.src = prefix+"query_down_arrowhead2.gif";
		//document.all.push_up.alt = "չ��";
		document.all.queryPanelTable.style.display = displayType;
		document.all.showtable.value='';
	}else {
		displayType = "";
		//document.all.push_up.src =prefix+"query_up_arrowhead2.gif";
		//document.all.push_up.alt = "�۵�";
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
		document.all.push_up_td.title = "չ��";
		document.all.queryPanelTable.style.display = displayType;
		document.all.showtable.value='';
	}else {
		displayType = "";
		document.all.push_up.src = ctx+"/images/push_up_c1.gif";
		document.all.push_up_td.title = "�۵�";
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

//����ȷ�϶Ի���,businessNameΪ�������֣����ʲ���Ƭ��ƾ֤��¼��confirmNameΪִ�еĶ�������ɾ�������ˣ����ˣ�
function AF_confirm(businessName,confirmName){

  return window.confirm("�Ƿ�ȷ��"+confirmName+"ѡ�е�"+businessName+"��");

}

//������onblur�¼�ʱ,�����ı����е��ַ�����
function objCheckLen(obj,maxLength){
  var len = strLength(obj.value);
  if(len > maxLength){
  	alert("����ӦС���������󳤶�" + maxLength);
    obj.focus();
    obj.select();
  }
}
//�����ڱ���ʱ,�����ı����е��ַ�����
function objCheckLen(obj){
  var len = strLength(obj.value);
  var maxLength = obj.maxLength;
  if(len > maxLength){
    return false;
  }
  return true;
}

/**
 * ��֤text��textarea�ĳ����Ƿ���ȷ
 * @�������:2005.06.09
 */
function validateData(){
    var checks = self.document.forms[0];
    for(var i=0;i< checks.elements.length;i++){
        if(checks.elements[i].type=="text") {
            var len = strLength(checks.elements[i].value);
            var maxLength = checks.elements[i].maxLength;
            if(len > maxLength){
                alert("����ӦС���������󳤶�" + maxLength+"���ַ�!");
                checks.elements[i].focus();
                checks.elements[i].select();
                return false;
            }
        }
        if(checks.elements[i].tagName=="TEXTAREA"){
            var len = strLength(checks.elements[i].value);
            var maxLength = document.getElementById(checks.elements[i].name+"_maxLength").value;
            if(len > maxLength)  {
                alert("����ӦС���������󳤶�" + maxLength+"���ַ�!");
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

//У��Email
function checkEmail(email)
{
     if(email.indexOf("@")<0||email.indexOf(".")<0)
     {
         return false;
     }
    return true;
}

//У���ֻ�����
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


//���绰����
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
//����ָ��sumColName��ֵ��ָ�������ĳ��ĳ��
// obj ��prefixǰ׺��nDec ��ʽ��С���� ����λ��
//����sumCol("dataTable","orderDetail","quantOrder","TableNmae",0,4,0)
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

//��ȡ�ַ���ǰ��Ŀ��ַ��س����ͻ��з�
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

//����������ڱȽ�
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
       alert('��ʼ���ڴ�����ֹ���ڣ�');
   }
 else
     return true;
}

//�Ѷ��Ƿ�Ϊһ����
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
//�ж��Ƿ��и�ѡ��ѡ��
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

//�ж��Ƿ��и�ѡ��ѡ��
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

//ȫѡ
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

	//��ȡĳһ��Ԫ������ĳ���
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
//�ӱ����������л�ȡ������
	function getObj(objName,index)
	{
	  var obj=document.all(objName);
	  if(!(typeof(obj)=="object"))return '';
	  var len=obj.length;
	  if(!(typeof(len)=="undefined"))
	  {
		 //obj=eval("document.all."+objName+"["+index+"]");
		  obj=document.getElementsByName(objName)[ index];//hejin modify ��ҳ��ֻ��һ����¼ʱ�����ܻ᷵��undefined���ͣ������Ǹ�ѡ������
	  }
	  return obj;
	}

function openWindow(url, name, width, height) {
	var status = "width="+width+",height="+height+",fullscreen=no,status=no,toolbar=no,menubar=no,resizable=no,scrollbar=no,location=no,titlebar=no"
	window.open(url, name, status);
}


/**
 * ��ʾ����������ʾ��Ϣ
 */
function showOperationProgress(operationName){
	var msgw,msgh,bordercolor;
	msgw=400;//��ʾ���ڵĿ��
	msgh=100;//��ʾ���ڵĸ߶�
	titleheight=25 //��ʾ���ڱ���߶�
	bordercolor="#336699";//��ʾ���ڵı߿���ɫ
	titlecolor="#99CCFF";//��ʾ���ڵı�����ɫ

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
	title.innerHTML="�ر�";
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
	txt.innerHTML=operationName+"�У����Ժ�......";
	document.getElementById("op_msgDiv").appendChild(txt);
}

function showMessageHint(msg, exception){
	var exFlag = exception!="" && exception!=null;
	var msgw,msgh,bordercolor;
	msgw=400;//��ʾ���ڵĿ��
	msgh=200;//��ʾ���ڵĸ߶�
	titleheight=25 //��ʾ���ڱ���߶�
	bordercolor="#336699";//��ʾ���ڵı߿���ɫ
	titlecolor="#99CCFF";//��ʾ���ڵı�����ɫ

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

	title.innerHTML="ϵͳ��Ϣ";
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

//���μ����¼�F5
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
 * ������:ajaxInvokeClass
 * className:������ʵ��platform.framework.ajax.AFAjax�ӿ�
 * contextPath:��ǰ·��
 * paramStr:�������
 */
function ajaxInvokeClass(contextPath,className,paramStr) {
    paramStr = paramStr + "&implcls="+className;
    var invokeAction = contextPath+"/ajax?"+paramStr;
    return xmlInvoke(invokeAction);
}

/*�Ƿ�Ψһ�Լ��
������Ӧ�������ģ��������ֶ������ֶ�ֵ����ǰ�к�(���ޣ���-1)
���أ�true/false
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
