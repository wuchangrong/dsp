/**
 * @class abstract UniEXT.lookup.DataWindow
 * @extends Ext.Window
 * 弹出式Lookup的弹出数据窗口
 */
UniEXT.lookup.DataWindow = function(config) {

	//如cacheID不为空,则将window的closeAction设置为'hide'(默认值为'close')
	if(config.cacheID && config.cacheID!=null) {
		config.closeAction = 'hide';
	}
	
	UniEXT.lookup.DataWindow.superclass.constructor.call(this, config);
};

Ext.extend(UniEXT.lookup.DataWindow, Ext.Window, {


    /**
     * @var private
     * 窗口关闭方式
     * @type String
     * @default 'close'
     */
    closeAction : 'close',
    
    /**
     * @var private
     * 窗口容器布局方式
     * @type String
     * @default 'border'
     */      
    layout: 'border',

    /**
     * @var private
     * 数据窗口是否模态弹出
     * @type boolean
     * @default true
     */
    modal : true,

    /**
     * @var private
     * 数据窗口是否可关闭
     * @type boolean
     * @default true
     */    
    closable : true,
    
    /**
     * @var private
     * lookup对象
     * @type UniEXT.lookup.LookupField
     * @default null
     */    
    parent : null,

    /**
     * @var private
     * 查询输入框默认显示
     * @type String
     * @default '在此输入条件进行过滤'
     */        
    filterDisplay: '在此输入条件进行过滤',
    
    
    confirmBtnText: '确认',
    
    cancelBtnText: '关闭',
    

	/**
	 * @func private
	 * 初始化DataWindow,添加数据容器以及按钮
	 * @overwrite Ext.Window.initComponent
	 */
    initComponent : function() {
    	UniEXT.lookup.DataWindow.superclass.initComponent.call(this);
        this.initContainer();
        this.initButtons();
    },

    /**
     * @func private
     * 处理窗口销毁
     * @overwrite Ext.Window.destroy
     */
    destroy : function(){
    	this.parent = null;
    	delete this.parent;
        UniEXT.lookup.DataWindow.superclass.destroy.call(this);
    },
	            
    /**
     * @func private
     * 初始化按钮
     */    
    initButtons : function() {
        this.addButton({
	        text: this.confirmBtnText,
	        handler: this.returnAndClose.createDelegate(this, [true])
	    });
	    this.addButton({
	        text: this.cancelBtnText,
	        handler: this.returnAndClose.createDelegate(this, [false])
	    });    
    },

      
	/**
	 * @func private
	 * 将弹出窗口的选中数据设置到lookup中并关闭窗口
	 * @param {boolean} returnable
	 */
    returnAndClose : function(returnable) {
    	if(returnable) {
	        var array = this.getValues();
	        this.parent.setValues(array);
    	}
    	if(this.closeAction == 'close') {
    		this.close();
    	} else {
    		this.hide();
    	}
    },
    
	/**
	 * @func private
	 * 为本地数据过滤提供对应的正则表达式
	 * @param {String} value
	 * @param {String} matchType
	 * @return {String} value after format
	 */
    getValueMatcher : function(value, matchType) {
		switch (matchType) {
		   case '=' :
		       return new RegExp('^' + Ext.escapeRe(value) + '$', 'i');
		   case '*%' :
		       return new RegExp('^' + Ext.escapeRe(value), 'i');
		   case '%*' :
		       return new RegExp(Ext.escapeRe(value) + '$', 'i');
		   case '%*%' :
		       return new RegExp(Ext.escapeRe(value), 'i');
		}
    },
    
	/**
	 * @func private
	 * 设置数据窗口的所属lookup对象
	 * @param {UniEXT.lookup.PopupLookupField} lookupObj
	 */
	setParent : function(lookupObj) {
		this.parent = lookupObj;
	},

    /**
     * @func abstract
     * 返回grid选中的record数组或tree选中的node数组
     * @return {Mixed} like Ext.data.Record[] or Ext.tree.TreeNode[]
     */
    getValues : Ext.emptyFn,
    
    
    /**
     * @func abstract
     * 生成数据容器,如表格或树
     */    
    initContainer : Ext.emptyFn 
    

});





/**
 * @class abstract UniEXT.lookup.LookupField
 * @extends Ext.form.TwinTriggerField
 * 
 */
UniEXT.lookup.LookupField = Ext.extend(Ext.form.TwinTriggerField, {

    /**
     * @var cfg.hiddenID
     * hidden input id
     * @type String
     * @default null
     */
    hiddenID : null,
        
    /**
     * @var cfg.lookupCode
     * 根据指定lookupCode获取数据库配置生成动态sql语句为lookup提供数据
     * 与sqlID不可同时使用
     * @type String
     * @default null
     */
    lookupCode : null,
    
    /**
     * @var cfg.sqlID
     * 根据指定sqlID获取sql-map-config配置的sql语句为lookup提供数据
     * 与lookupCode不可同时使用
     * @type String
     * @default null
     */
    sqlID : null,

    /**
     * @var cfg.implClass
     * 获取lookup数据的java接口实现类,一般情况下不需要复写
     * @type String
     * @default null
     */
    implClass : null,
    
    /**
     * @var cfg.dbkey
     * 在多数据源情况下,通过dbkey指定lookupCode/sqlID查询时使用的数据库
     * @type String
     * @default null
     */
    dbkey : null,
        
    /**
     * @var cfg.dataURL
     * 为当前lookup提供数据的URL
     * @type String
     * @default null
     */
    dataURL : null,
    
    /**
     * @var cfg.dataELMapping
     * 选中lookup数据后,将选中数据的各个列/属性的值根据dataELMapping设置到对应的控件中
     * @type Array like [{data:'CODE', el:'el_code'}, {data:'NAME', el:'el_name'}]
     * @default null
     */
    dataELMapping : null,
    
    /**
     * @var cfg.baseConditions
     * lookup数据的初始查询条件
     * @type Array like [{param:'DELETED_FLAG',value:'Y'}, {param:'CODE',value:'1001%'}]
     * @default null
     */
    baseConditions : null,
    
    /**
     * @var cfg.sortInfo
     * lookup数据的初始排序条件
     * @type Object like {field:'CODE', direction:'ASC|DESC'}
     * @default null
     */    
	sortInfo : null, 

    /**
     * @var cfg.filterParam
     * 过滤用配置项
     * @type Object like {display:'在此输入条件进行过滤', fields:[{name:'PROGRAM_CODE',matchType:'%*'}, {name:'PROGRAM_NAME',matchType:'%*%'}]}
     * @default null
     */
    filterParam : null,	

    /**
     * @var cfg.cleanAlwaysShow
     * 清除按钮是否总是显示
     * @type boolean
     * @default false
     */
	cleanAlwaysShow : false,

    /**
     * @var private
     * 控件长度
     * @type Number
     * @default 150px
     */
	width : 150,
	
    
    /**
     * @var private
     * 按钮一的CSS样式
     * @type String
     * @default 'x-form-clear-trigger'
     */
	trigger1Class : 'x-form-clear-trigger',
	
    /**
     * @var private
     * 按钮二的CSS样式
     * @type String
     * @default 'x-form-search-trigger'
     */	
    trigger2Class : 'x-form-search-trigger',

    /**
     * @func private
     * 复写父类方法,修正以下问题
     * Lookup控件上级dom节点如果初始化的时候stype.display='none'则之后就算将上级dom节点改为显示,Lookup也始终无法显示.(参考从表内的Lookup)设置该行代码解决该问题
     * @overwrite Ext.form.TwinTriggerField.initTrigger
     */
    initTrigger : function(){
    	UniEXT.lookup.LookupField.superclass.initTrigger.call(this);
    	this.wrap.setStyle('overflow', 'visible');
    },

    /**
     * @func private
     * 初始化Lookup控件
     * @overwrite Ext.form.TwinTriggerField.initComponent
     */
    initComponent : function() {
    	this.dataURL = this.dataURL==null ? UniEXT.ctxPath+"/ajax" : this.dataURL;
    	this.checkDataELMapping(this.dataELMapping);
        UniEXT.lookup.LookupField.superclass.initComponent.call(this);
        var baseComp = Ext.getDom(this.applyTo);
        baseComp.extTagName = 'Lookup'; //设置extTagName为'Lookup'
        baseComp.lookupObject = this; //将Lookup对象设置到dom元素中
        this.hideTrigger1 = this.cleanAlwaysShow ? false : baseComp.value === '';
        this.addEvents({
            "beforeclean" : true,
            "afterclean" : true,
            "setvalues" : true
        });
    },


    /**
     * @func private
     * @overwrite UniEXT.lookup.LookupField.destroy
     */
    destroy : function() {
    	var baseComp = Ext.getDom(this.applyTo);
    	baseComp.lookupObject = null;
    	delete baseComp.lookupObject;
        UniEXT.lookup.LookupField.superclass.destroy.call(this);
    },
            
	/**
	 * @func private
	 */
    onTrigger1Click : function() {
        this.clean();
    },
    
    /**
     * @func private
     * 检测dataELMapping,如表达式为含有模板定义,则转为模版
     */
    checkDataELMapping : function(dataELMapping) {
    	if(dataELMapping && dataELMapping!=null && dataELMapping.length>0) {
    		var regExp = /{.*?}/;
    		for(var i=0; i<dataELMapping.length; i++) {
    			var datadefine = dataELMapping[i].data;
    			if(typeof datadefine=='string' && regExp.test(datadefine)) {
    				dataELMapping[i].data = new Ext.Template(datadefine);
    			}
    		}
    	}
    },
            
    /**
     * @func public
     * 设置BaseConditions
     * @param {Array} array like [{param:'DELETED_FLAG',value:'Y'}, {param:'CODE',value:'1001%'}]
     */
    setBaseConditions : function(/*Array*/array) {
        this.baseConditions = array;
    },

    /**
     * @func public
     * 清空BaseConditions
     */
    cleanBaseConditions : function() {
        this.baseConditions = null;
    },
    
    /**
     * @func public
     * 获取当前Lookup的隐藏值
     * @return String
     */
    getHiddenValue : function() {
    	return Ext.getDom(this.hiddenID).value;
    },
    
    /**
     * @func public
     * 如有setvalues监听则调用监听,否则调用默认实现onSetValues方法
     * @param {Mixed} array like Ext.data.Record[] or Ext.tree.TreeNode[]
     */
    setValues : function(array) {
    	if(this.hasListener("setvalues")) {
    		this.fireEvent("setvalues", this, array);
    	} else {
    		this.onSetValues(array);
    	}
    },

    /**
     * @func private
     * 根据dataELMapping将传入数据数组设置到对应的控件中,根据lookup类型不同,可能是record数组或node数组
     * @param {Mixed} array like Ext.data.Record[] or Ext.tree.TreeNode[]
     */
    onSetValues : function(array) {
        if(array && array.length!=0) {
	        for(var i=0; i<this.dataELMapping.length; i++) {
	        	var str = '';
	        	for(var j=0; j<array.length; j++) {
	        		str += this.formatValue(this.dataELMapping[i].data, array[j])+',';
	        	}
	        	str = str.substring(0, str.length-1);
	            Ext.getDom(this.dataELMapping[i].el).value = str;
	        }
            if(!this.cleanAlwaysShow) {
            	this.triggers[0].show();
            }
        }    	
    },

    /**
     * @func public
     * 响应clean按钮,触发beforeclean和afterclean
     */
    clean : function() {
    	if(this.fireEvent("beforeclean", this) !== false) {
    		this.onClean();
    		this.fireEvent("afterclean", this);
    	}
    },
    
    /**
     * @func private
     * 根据dataELMapping清空控件数据
     */
    onClean : function() {
        for(var i=0; i<this.dataELMapping.length; i++) {
            Ext.getDom(this.dataELMapping[i].el).value = '';
        }
        if(!this.cleanAlwaysShow) {
        	this.triggers[0].hide();
       	}

    },
        
    /**
     * @func abstract
     * 根据dataELMapping的data属性格式化数据
     * @param {Mixed} datadefine dataELMapping.data like String or Template
     * @param {Mixed} values like Ext.data.Record or Ext.tree.TreeNode
     * @return String value after format
     */    
    formatValue : Ext.emptyFn

});





/**
 * @class abstract UniEXT.lookup.PopupLookupField
 * @extends UniEXT.lookup.LookupField
 * 
 */
UniEXT.lookup.PopupLookupField = Ext.extend(UniEXT.lookup.LookupField, {
    /**
     * @var cfg.winWidth
     * 弹出的数据窗口宽度
     * @type Number
     * @default 350
     */
    winWidth : 350,
    
    /**
     * @var cfg.winHeight
     * 弹出的数据窗口高度
     * @type Number
     * @default 454
     */
    winHeight : 454,
    
    /**
     * @var cfg.winTitle
     * 弹出的数据窗口高度
     * @type String
     * @default 'Popup Lookup'
     */        
    winTitle : 'Popup Lookup',
    
    /**
     * @var cfg.winOpenWith
     * 指定当前lookup的窗口弹出页面
     * @type Object
     * @default null
     */
    winOpenWith : null,
        
    /**
     * @var cfg.singleSelect
     * 设置lookup数据单选/多选
     * @type boolean
     * @default true
     */
    singleSelect : true,

    /**
     * @var cfg.cacheID
     * 配置lookup的datawindow是否缓存,并可让其他lookup通过lookupmanager获取该window,若为null则不缓存
     * @type String
     * @default null
     */
    cacheID : null,
    
    /**
     * @var private
     * 自定义控件是否只读
     * @type boolean
     * @default true
     */
    //readOnly : true,

    /**
     * @var private
     * WindowAttr与LookupAttr的Mapping,根据该mapping将lookup内对象组合成Window的Config供创建DataWindow使用
     * @type Array like [{wa:'', la:''}, {wa:'', la:''}]
     * @default
     */
    wlAttrMapping : [
    	{wa:'width', la:'winWidth'},
    	{wa:'height', la:'winHeight'},
    	{wa:'title', la:'winTitle'},
    	{wa:'dbkey', la:'dbkey'},
    	{wa:'dataURL', la:'dataURL'},
    	{wa:'lookupCode', la:'lookupCode'},
    	{wa:'sqlID', la:'sqlID'},
    	{wa:'implClass', la:'implClass'},
    	{wa:'cacheID', la:'cacheID'},
    	{wa:'singleSelect', la:'singleSelect'},
    	{wa:'baseConditions', la:'baseConditions'},
    	{wa:'filterParam', la:'filterParam'},
    	{wa:'sortInfo', la:'sortInfo'}
    ],
    
    /**
     * @func private
     * @param {Mixed} Array or Object
     */
    addWLAttrMapping : function(/* Mixed*/arrt) {
    	if(arrt instanceof Array) {
    		this.wlAttrMapping = this.wlAttrMapping.concat(arrt);
    	}
   		else {
   			this.wlAttrMapping.push(arrt);
   		}
    },
    
    /**
     * @func private
     * 初始化Lookup控件
     * @overwrite UniEXT.lookup.LookupField.initComponent
     */
    initComponent : function() {
    	this.readOnly = true;
        UniEXT.lookup.PopupLookupField.superclass.initComponent.call(this);
        this.addEvents({
            "beforepopup" : true,
            "afterclose" : true,
            "afterpopup" : true
        });
    },

	/**
	 * @func private
	 * 初始化事件,添加回车弹出窗口
	 * @overwrite UniEXT.lookup.LookupField.initEvents
	 */
	initEvents : function() {
		UniEXT.lookup.PopupLookupField.superclass.initEvents.call(this);
        this.on('specialkey', function(f, e){
            if(e.getKey() == e.ENTER){
                this.onTrigger2Click();
            }
        }, this);
	},

    /**
     * @func private
     * @overwrite UniEXT.lookup.LookupField.destroy
     */
    destroy : function(){
    	if(this.cacheID != null) {
    		UniEXT.lookup.LookupManager.clean(this.cacheID);
    	}
        UniEXT.lookup.PopupLookupField.superclass.destroy.call(this);
    },


	/**
	 * @func private
	 */
    onTrigger2Click : function() {
        this.popup();
    },
    
    /**
     * @func private
     * 弹出并定位窗口
     */
    onPopup : function() {
    	var cfg = {parent : this};
    	for(i=0; i<this.wlAttrMapping.length; i++) {
    		cfg[this.wlAttrMapping[i].wa] = eval('this.'+this.wlAttrMapping[i].la);
    	}
    	
    	var win = null;
    	if(this.cacheID == null) {
    		win = this.genDataWindow(cfg, this.winOpenWith);
    	} else {
	    	win = UniEXT.lookup.LookupManager.getDataWindow(this.cacheID);
    		if(win == null) {
    			win = this.genDataWindow(cfg, this.winOpenWith);
    			UniEXT.lookup.LookupManager.cacheDataWindow(this.cacheID, win);
    		} else {
    			win.setParent(this);
    		}
    	}
    	if(this.hasListener('afterclose')) {
    		win.on('close', this.fireEvent.createDelegate(this, ['afterclose', win]));
    	}
    	
    	this.setWindowPosition(win, this.winOpenWith).show();
    	return win;
    },
    


    /**
     * @func public
     * 响应popup按钮,触发beforepopup
     */
    popup : function() {
    	if(this.fireEvent("beforepopup", this) !== false) {
    		var win = this.onPopup();
    		this.fireEvent("afterpopup", this, win);
    	}
    },
    
    /**
     * @func private
     * 设置DataWindow弹出位置
     * @param {UniEXT.lookup.DataWindow} win
     * @param {Object} winOpenWith
     * @return {UniEXT.lookup.DataWindow}
     */
    setWindowPosition : function(win, winOpenWith) {
    	if(winOpenWith != null)
    		return win;
    		
    	var bs = Ext.getBody().getSize();
    	var ls = this.getSize();
    	var lp = this.getPosition();
    	
    	if((lp[0]+this.Width-this.winWidth<0 && lp[0]+this.winWidth>bs.width) || 
    	   (lp[1]-this.winHeight<0 && lp[1]+ls.height+this.winHeight>bs.height)) {
    		return win;
    	}
    	
    	var left = 0;
    	var top = 0;
    	
    	left = (bs.width<this.winWidth || lp[0]+this.winWidth<bs.width) 
    		? lp[0] 
    		: (lp[0]+this.width-this.winWidth);
    		
    	top = (bs.height<this.winHeight || lp[1]+ls.height+this.winHeight<bs.height) 
    		? (lp[1]+ls.height) 
    		: (lp[1]-this.winHeight<0 ? lp[1]+ls.height : lp[1]-this.winHeight);
    		
    	return win.setPosition(left, top);
    },
    
    /**
     * @func abstract
     * winconfig中指定参数encode(为了解决不同窗口间传递Array类型会出现偏差的问题)
     * @param {Object} winCfg
     * @param {Object} arrayAttrParams
     * @return {Object} winCfg
     */
    encodeArrayAttr : function(winCfg, arrayAttrParams) {
   		for(var i=0; i<arrayAttrParams.length; i++) {
   			winCfg[arrayAttrParams[i]] = UniEXT.encode(winCfg[arrayAttrParams[i]]);
   		}
   		return winCfg;
    },

    /**
     * @func abstract
     * 生成一个新的DataWindow
     * @param {Object} winCfg
     * @param {Object} winOpenWith
     * @return {UniEXT.lookup.DataWindow}
     */
    genDataWindow : Ext.emptyFn
    
});


