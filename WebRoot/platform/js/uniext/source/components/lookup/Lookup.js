/**
 * @class abstract UniEXT.lookup.DataWindow
 * @extends Ext.Window
 * ����ʽLookup�ĵ������ݴ���
 */
UniEXT.lookup.DataWindow = function(config) {

	//��cacheID��Ϊ��,��window��closeAction����Ϊ'hide'(Ĭ��ֵΪ'close')
	if(config.cacheID && config.cacheID!=null) {
		config.closeAction = 'hide';
	}
	
	UniEXT.lookup.DataWindow.superclass.constructor.call(this, config);
};

Ext.extend(UniEXT.lookup.DataWindow, Ext.Window, {


    /**
     * @var private
     * ���ڹرշ�ʽ
     * @type String
     * @default 'close'
     */
    closeAction : 'close',
    
    /**
     * @var private
     * �����������ַ�ʽ
     * @type String
     * @default 'border'
     */      
    layout: 'border',

    /**
     * @var private
     * ���ݴ����Ƿ�ģ̬����
     * @type boolean
     * @default true
     */
    modal : true,

    /**
     * @var private
     * ���ݴ����Ƿ�ɹر�
     * @type boolean
     * @default true
     */    
    closable : true,
    
    /**
     * @var private
     * lookup����
     * @type UniEXT.lookup.LookupField
     * @default null
     */    
    parent : null,

    /**
     * @var private
     * ��ѯ�����Ĭ����ʾ
     * @type String
     * @default '�ڴ������������й���'
     */        
    filterDisplay: '�ڴ������������й���',
    
    
    confirmBtnText: 'ȷ��',
    
    cancelBtnText: '�ر�',
    

	/**
	 * @func private
	 * ��ʼ��DataWindow,������������Լ���ť
	 * @overwrite Ext.Window.initComponent
	 */
    initComponent : function() {
    	UniEXT.lookup.DataWindow.superclass.initComponent.call(this);
        this.initContainer();
        this.initButtons();
    },

    /**
     * @func private
     * ����������
     * @overwrite Ext.Window.destroy
     */
    destroy : function(){
    	this.parent = null;
    	delete this.parent;
        UniEXT.lookup.DataWindow.superclass.destroy.call(this);
    },
	            
    /**
     * @func private
     * ��ʼ����ť
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
	 * ���������ڵ�ѡ���������õ�lookup�в��رմ���
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
	 * Ϊ�������ݹ����ṩ��Ӧ��������ʽ
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
	 * �������ݴ��ڵ�����lookup����
	 * @param {UniEXT.lookup.PopupLookupField} lookupObj
	 */
	setParent : function(lookupObj) {
		this.parent = lookupObj;
	},

    /**
     * @func abstract
     * ����gridѡ�е�record�����treeѡ�е�node����
     * @return {Mixed} like Ext.data.Record[] or Ext.tree.TreeNode[]
     */
    getValues : Ext.emptyFn,
    
    
    /**
     * @func abstract
     * ������������,�������
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
     * ����ָ��lookupCode��ȡ���ݿ��������ɶ�̬sql���Ϊlookup�ṩ����
     * ��sqlID����ͬʱʹ��
     * @type String
     * @default null
     */
    lookupCode : null,
    
    /**
     * @var cfg.sqlID
     * ����ָ��sqlID��ȡsql-map-config���õ�sql���Ϊlookup�ṩ����
     * ��lookupCode����ͬʱʹ��
     * @type String
     * @default null
     */
    sqlID : null,

    /**
     * @var cfg.implClass
     * ��ȡlookup���ݵ�java�ӿ�ʵ����,һ������²���Ҫ��д
     * @type String
     * @default null
     */
    implClass : null,
    
    /**
     * @var cfg.dbkey
     * �ڶ�����Դ�����,ͨ��dbkeyָ��lookupCode/sqlID��ѯʱʹ�õ����ݿ�
     * @type String
     * @default null
     */
    dbkey : null,
        
    /**
     * @var cfg.dataURL
     * Ϊ��ǰlookup�ṩ���ݵ�URL
     * @type String
     * @default null
     */
    dataURL : null,
    
    /**
     * @var cfg.dataELMapping
     * ѡ��lookup���ݺ�,��ѡ�����ݵĸ�����/���Ե�ֵ����dataELMapping���õ���Ӧ�Ŀؼ���
     * @type Array like [{data:'CODE', el:'el_code'}, {data:'NAME', el:'el_name'}]
     * @default null
     */
    dataELMapping : null,
    
    /**
     * @var cfg.baseConditions
     * lookup���ݵĳ�ʼ��ѯ����
     * @type Array like [{param:'DELETED_FLAG',value:'Y'}, {param:'CODE',value:'1001%'}]
     * @default null
     */
    baseConditions : null,
    
    /**
     * @var cfg.sortInfo
     * lookup���ݵĳ�ʼ��������
     * @type Object like {field:'CODE', direction:'ASC|DESC'}
     * @default null
     */    
	sortInfo : null, 

    /**
     * @var cfg.filterParam
     * ������������
     * @type Object like {display:'�ڴ������������й���', fields:[{name:'PROGRAM_CODE',matchType:'%*'}, {name:'PROGRAM_NAME',matchType:'%*%'}]}
     * @default null
     */
    filterParam : null,	

    /**
     * @var cfg.cleanAlwaysShow
     * �����ť�Ƿ�������ʾ
     * @type boolean
     * @default false
     */
	cleanAlwaysShow : false,

    /**
     * @var private
     * �ؼ�����
     * @type Number
     * @default 150px
     */
	width : 150,
	
    
    /**
     * @var private
     * ��ťһ��CSS��ʽ
     * @type String
     * @default 'x-form-clear-trigger'
     */
	trigger1Class : 'x-form-clear-trigger',
	
    /**
     * @var private
     * ��ť����CSS��ʽ
     * @type String
     * @default 'x-form-search-trigger'
     */	
    trigger2Class : 'x-form-search-trigger',

    /**
     * @func private
     * ��д���෽��,������������
     * Lookup�ؼ��ϼ�dom�ڵ������ʼ����ʱ��stype.display='none'��֮����㽫�ϼ�dom�ڵ��Ϊ��ʾ,LookupҲʼ���޷���ʾ.(�ο��ӱ��ڵ�Lookup)���ø��д�����������
     * @overwrite Ext.form.TwinTriggerField.initTrigger
     */
    initTrigger : function(){
    	UniEXT.lookup.LookupField.superclass.initTrigger.call(this);
    	this.wrap.setStyle('overflow', 'visible');
    },

    /**
     * @func private
     * ��ʼ��Lookup�ؼ�
     * @overwrite Ext.form.TwinTriggerField.initComponent
     */
    initComponent : function() {
    	this.dataURL = this.dataURL==null ? UniEXT.ctxPath+"/ajax" : this.dataURL;
    	this.checkDataELMapping(this.dataELMapping);
        UniEXT.lookup.LookupField.superclass.initComponent.call(this);
        var baseComp = Ext.getDom(this.applyTo);
        baseComp.extTagName = 'Lookup'; //����extTagNameΪ'Lookup'
        baseComp.lookupObject = this; //��Lookup�������õ�domԪ����
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
     * ���dataELMapping,����ʽΪ����ģ�嶨��,��תΪģ��
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
     * ����BaseConditions
     * @param {Array} array like [{param:'DELETED_FLAG',value:'Y'}, {param:'CODE',value:'1001%'}]
     */
    setBaseConditions : function(/*Array*/array) {
        this.baseConditions = array;
    },

    /**
     * @func public
     * ���BaseConditions
     */
    cleanBaseConditions : function() {
        this.baseConditions = null;
    },
    
    /**
     * @func public
     * ��ȡ��ǰLookup������ֵ
     * @return String
     */
    getHiddenValue : function() {
    	return Ext.getDom(this.hiddenID).value;
    },
    
    /**
     * @func public
     * ����setvalues��������ü���,�������Ĭ��ʵ��onSetValues����
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
     * ����dataELMapping�����������������õ���Ӧ�Ŀؼ���,����lookup���Ͳ�ͬ,������record�����node����
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
     * ��Ӧclean��ť,����beforeclean��afterclean
     */
    clean : function() {
    	if(this.fireEvent("beforeclean", this) !== false) {
    		this.onClean();
    		this.fireEvent("afterclean", this);
    	}
    },
    
    /**
     * @func private
     * ����dataELMapping��տؼ�����
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
     * ����dataELMapping��data���Ը�ʽ������
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
     * ���������ݴ��ڿ��
     * @type Number
     * @default 350
     */
    winWidth : 350,
    
    /**
     * @var cfg.winHeight
     * ���������ݴ��ڸ߶�
     * @type Number
     * @default 454
     */
    winHeight : 454,
    
    /**
     * @var cfg.winTitle
     * ���������ݴ��ڸ߶�
     * @type String
     * @default 'Popup Lookup'
     */        
    winTitle : 'Popup Lookup',
    
    /**
     * @var cfg.winOpenWith
     * ָ����ǰlookup�Ĵ��ڵ���ҳ��
     * @type Object
     * @default null
     */
    winOpenWith : null,
        
    /**
     * @var cfg.singleSelect
     * ����lookup���ݵ�ѡ/��ѡ
     * @type boolean
     * @default true
     */
    singleSelect : true,

    /**
     * @var cfg.cacheID
     * ����lookup��datawindow�Ƿ񻺴�,����������lookupͨ��lookupmanager��ȡ��window,��Ϊnull�򲻻���
     * @type String
     * @default null
     */
    cacheID : null,
    
    /**
     * @var private
     * �Զ���ؼ��Ƿ�ֻ��
     * @type boolean
     * @default true
     */
    //readOnly : true,

    /**
     * @var private
     * WindowAttr��LookupAttr��Mapping,���ݸ�mapping��lookup�ڶ�����ϳ�Window��Config������DataWindowʹ��
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
     * ��ʼ��Lookup�ؼ�
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
	 * ��ʼ���¼�,��ӻس���������
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
     * ��������λ����
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
     * ��Ӧpopup��ť,����beforepopup
     */
    popup : function() {
    	if(this.fireEvent("beforepopup", this) !== false) {
    		var win = this.onPopup();
    		this.fireEvent("afterpopup", this, win);
    	}
    },
    
    /**
     * @func private
     * ����DataWindow����λ��
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
     * winconfig��ָ������encode(Ϊ�˽����ͬ���ڼ䴫��Array���ͻ����ƫ�������)
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
     * ����һ���µ�DataWindow
     * @param {Object} winCfg
     * @param {Object} winOpenWith
     * @return {UniEXT.lookup.DataWindow}
     */
    genDataWindow : Ext.emptyFn
    
});


