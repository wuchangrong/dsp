package com.handao.platform.framework.web.jsp;

public class AFField {
    public static final int SHOW_TYPE_LABEL = 0;
    public static final int SHOW_TYPE_CHECKBOX = 1;
    public static final int SHOW_TYPE_HREF = 2;
    public static final int SHOW_TYPE_HIDDENINPUT = 3;
    public static final int SHOW_TYPE_TEXT = 4;
    public static final int SHOW_TYPE_PERCENT = 5;
    public static final int SHOW_TYPE_SEPDOUBLE = 6;
    public static final int SHOW_TYPE_OPRATION = 7;  //add by wucr

    public static final int TOTAL_TYPE_NO = -1;
    public static final int TOTAL_TYPE_SUM = 0;
    public static final int TOTAL_TYPE_COUNT = 1;
    public static final int TOTAL_TYPE_AVG = 2;
    public static final int TOTAL_TYPE_SUBTOTAL = 3; //用于交叉表小计
    public static final int TOTAL_TYPE_SUMSUBTOTAL = 4; //用于交叉表合计，小计

    //end
    private String name; //attribute name of the bean to be list
    private String key; //message key at MessageMapping, show as table head label.
    private String width; // the width of this field column width at the table.
    private String align = "left"; //value's align,
    private int showType = SHOW_TYPE_LABEL; //the type of value show, the value should be constant: SHOW_TYPE_...
    private String processClass; // if some value want other process, such as: ID --> DESC , set the Process Clas here, the Class must extends ValueProcess.
    private int totalType = TOTAL_TYPE_NO; //the type of value total, the value should be constant: TOTAL_TYPE_...
    private String totalLable = "";
    private String functionName = "";
    private int size = 5; //当类型为SHOW_TYPE_TEXT时，需指编辑框的大小
    private String oprationBtn = "modify,delete"; //add by wucr
    //
    private AFValueProcess valueProcess = null;
        
    //CHECKBOX
    public AFField(String name, String key, String width, String align, int showType,
            String processClass) {
            this.name = name;
            this.key = key;
            this.width = width;
            this.showType = showType;
            this.processClass = processClass;
            this.align = align;
   }
    
    //常用
    public AFField(String name, String key, String width, String align, String processClass,
        String totalLable) {
        this.name = name;
        this.key = key;
        this.width = width;
        this.processClass = processClass;
        this.align = align;
        this.totalLable = totalLable;
        //
        if(this.processClass != null || !"".equals(this.processClass)){
        	try{
        		this.valueProcess = (AFValueProcess)Class.forName(this.processClass).newInstance();
        	}catch(Exception e){}
        }
    }

    //常用
    public AFField(String name, String key, String width, String align, String processClass,
        String totalLable,AFValueProcess valueProcess) {
    	
    	this(name,key,width,align,processClass,totalLable);
    	if(valueProcess != null)
    		this.valueProcess = valueProcess;
    }    
    //userlist 用
    public AFField(String name, String key, String width, String align, String processClass) {
            this.name = name;
            this.key = key;
            this.width = width;
            this.processClass = processClass;
            this.align = align;
        }    
    
    //有用 传函数名 查看明细
    public AFField(String name, String key, String width, String align, int showType,
        String functionName, String processClass) {
        this.name = name;
        this.key = key;
        this.width = width;
        this.showType = showType;
        this.processClass = processClass;
        this.align = align;
        this.functionName = functionName;
    }


    // add by wucr  增加操作列
    public AFField(String name, String width, int showType,String oprationBtn)
    {
        this.align = "center";
        this.name = name;
        this.width = width;
        this.showType = showType;
        this.oprationBtn = oprationBtn;
    }    
     
    public String getOprationBtn()
    {
        return oprationBtn;
    }

    public void setOprationBtn(String oprationBtn)
    {
        this.oprationBtn = oprationBtn;
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public int getTotalType() {
        return totalType;
    }

    public void setTotalType(int totalType) {
        this.totalType = totalType;
    }

    public String getTotalLable() {
        return totalLable;
    }

    public void setTotalLable(String totalLable) {
        this.totalLable = totalLable;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

	public AFValueProcess getValueProcess() {
		return valueProcess;
	}
}