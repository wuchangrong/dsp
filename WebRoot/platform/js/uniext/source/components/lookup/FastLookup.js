/**
 * @class UniEXT.lookup.FastLookupField
 * @extends UniEXT.lookup.LookupField
 * 
 */
UniEXT.lookup.FastLookupField = Ext.extend(UniEXT.lookup.LookupField, {


	
    /**
     * @var private
     * GridLookup数据供给java实现类
     * @type String
     * @default 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup'
     */
    implClass : 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup',
    
    /**
     * @var cfg.storeCfg
     * 表格的store相关config,其中meta对应Ext.data.JsonReader.meta数据格式,recordType对应Ext.data.JsonReader.recordType
     * @type Object like {meta: {root: 'data', totalProperty: 'total', id: 'row_id'}, recordType: []}
     * @default null
     */
    storeCfg : null,

    /**
     * @var cfg.selectedClass
     * 浮动列表选中选中行的样式
     * @type String
     * @default 'x-combo-selected'
     */
	selectedClass: 'x-combo-selected',

    /**
     * @var cfg.displayField
     * 设置浮动列表按照指定列(或模版语言)显示数据.支持模版语言
     * @type String
     * @default null
     */	
	displayField : null,

    /**
     * @var cfg.queryDelay
     * 设置浮动列表弹出延时事件,单位毫秒.该参数直接影响到数据库服务器性能,建议不要小于300
     * @type Number
     * @default 500
     */		
	queryDelay : 500,

    /**
     * @var cfg.pageSize
     * 设置浮动列表是否分页
     * @type Number
     * @default -1
     */		
	pageSize : -1,

    /**
     * @var cfg.listAlign
     * 设置浮动列表弹出定位方式.具体请参见Ext.Element.alignTo方法内描述的参数定义
     * @type Number
     * @default 'tl-bl?'
     */		
	listAlign: 'tl-bl?',
	    
    /**
     * @func private
     * 初始化Lookup控件
     * @overwrite UniEXT.lookup.LookupField.initComponent
     */
    initComponent : function() {
    	this.hideTrigger2 = true;
        UniEXT.lookup.FastLookupField.superclass.initComponent.call(this);
        var v = Ext.getDom(this.applyTo).value
        if(v !== '') {
        	this.lastValue = v;
        }
        this.addEvents({
        	"afterselect" : true,
            "beforeselect" : true,
            "beforecollapse" : true,
            "aftercollapse" : true,
            "beforeexpand" : true,
            "afterexpand" : true,
            "beforeLookup": true
        });
    },

    /**
     * @func private
     * 初始化Lookup控件
     * @overwrite UniEXT.lookup.LookupField.initEvents
     */    
    initEvents : function() {
    	UniEXT.lookup.FastLookupField.superclass.initEvents.call(this);
    	this.el.on('focus', this.initList, this);
    	var lookupTask = new Ext.util.DelayedTask(this.onLookup, this);
		this.el.on('keyup', function(e) {
			if(!e.isSpecialKey()) {
				lookupTask.delay(this.queryDelay);
			};
		}, this);
        this.keyNav = new Ext.KeyNav(this.el, {
            "up" : function(e){
                if(this.isExpanded())
                	this.selectPrev();
            },
			"down" : function(e){
                if(this.isExpanded())
                	this.selectNext();
            },
            "enter" : function(e){
                if(this.isExpanded()) {
					this.onSelect();
				}
				else {
					this.onLookup();
				}
            },
            "esc" : function(e){
                this.collapse();
            },
			scope : this,
			forceKeyDown : false
        });
    },

    /**
     * @func private
     * 初始化弹出浮动层,以及store,datawindow等
     */     
    initList : function() {
    	if(!this.list) {
    		var cls = 'x-combo-list';
            this.list = new Ext.Layer({
                shadow: this.shadow, cls: [cls, ''].join(' '), constrain:false
            });
            
            var lw = this.listWidth || this.wrap.getWidth();
            this.list.setWidth(lw);
            this.list.swallowEvent('mousewheel');
            this.assetHeight = 0;

            if(this.title){
                this.header = this.list.createChild({cls:cls+'-hd', html: this.title});
                this.assetHeight += this.header.getHeight();
            }
			
            this.innerList = this.list.createChild({cls:cls+'-inner'});
            this.innerList.on('mouseover', this.onViewOver, this);
            //this.innerList.on('mousemove', this.onViewMove, this);
            this.innerList.setWidth(lw - this.list.getFrameWidth('lr'))

            if(!this.tpl || this.tpl==null){
                var regExp = /{.*?}/;
    			if(!regExp.test(this.displayField)) {
    				this.displayField = '{' + this.displayField + '}';
    			}
                this.tpl = '<tpl for="."><div class="'+cls+'-item">' + this.displayField + '</div></tpl>';
            }
                        
            this.store = new Ext.data.Store({
		        autoLoad: false,
		        proxy: new Ext.data.ScriptTagProxy({url: this.dataURL}),
		        reader: new Ext.data.JsonReader(this.storeCfg.meta, this.storeCfg.recordType),
		        remoteSort: true,
		        sortInfo: this.sortInfo,
		        baseParams: {
		            sqlid: this.sqlID,
		            dbkey: this.dbkey,
		            pagesize: this.pageSize,
		            implcls: this.implClass,
		            fcondition: [],
		            bcondition: UniEXT.encode(this.baseConditions)
		        }
	    	});
	    	
	    	//this.store.on('beforeload', this.onBeforeLoad, this);
            this.store.on('load', this.onLoad, this);
            this.store.on('loadexception', this.collapse, this);
            
            if(this.pageSize > 0){
                this.footer = this.list.createChild({cls:cls+'-ft'});
                this.pageTb = new Ext.PagingToolbar({
	                pageSize : this.pageSize,
	                store : this.store,
	                displayInfo : true,
	                /*beforePageText : "页",
	                afterPageText : " 共 {0}",
	                displayMsg : '显示 {0}-{1} 共 {2}',
	                emptyMsg : '无记录',*/
	                paramNames : {start:'start', limit:'pagesize'},
                    renderTo:this.footer
                });
                this.assetHeight += this.footer.getHeight();
            }    	
            

            this.view = new Ext.DataView({
                applyTo: this.innerList,
                store: this.store,
                tpl: this.tpl,
                //height : this.listHeight-this.assetHeight,
                singleSelect: true,
                selectedClass: this.selectedClass,
                itemSelector: this.itemSelector || '.' + cls + '-item'
            });

            if(this.listHeight) 
            	this.view.setHeight(this.listHeight-this.assetHeight);
            	   
            this.view.on('click', this.onSelect, this);
    	}
    },

    /**
     * @func private
     * 对应store加载/重新加载数据后,根据返回值弹出或关闭浮动层
     */      
    onLoad : function() {
    	if(this.store.getCount() > 0) {
        	this.expand();
        	this.select(0);
        } else {
        	this.collapse();
        }
    },

    /**
     * @func private
     * 判断Lookup控件输入数据,并根据数据生成filterCondition,并通过store向后台提交
     */    
    onLookup : function() {
		var value = this.getValue();
		if(value == '') {
			this.lastValue = '';
			this.collapse();
			return;
		}
        if(this.lastValue == value) {
            return;
        }
        this.lastValue = value;
        
        //触发beforeLookup事件
        if(this.fireEvent('beforeLookup', this) !== false) {}
        
        var fields = this.filterParam.fields;
        var obj = new Array();
        for(var i=0; i<fields.length; i++) {
        	var temp = this.formatMatchString(value, fields[i].matchType);
            obj[i] = {param:fields[i].name, value:UniEXT.util.Base64.encode64Plus(temp)};
        }
        var fc = UniEXT.encode(obj);
        Ext.apply(this.store.baseParams, {fcondition:fc});
        this.store.load({});
        
    },
    
    // private
    collapseIf : function(e){
        if(!e.within(this.wrap) && !e.within(this.list)){
            this.collapse();
        }
    },

    /**
     * Hides the dropdown list if it is currently expanded. Fires the 'collapse' event on completion.
     */
    collapse : function(){
        if(!this.isExpanded()){
            return;
        }
        if(this.fireEvent('beforecollapse', this) !== false) {
	        this.list.hide();
	        Ext.getDoc().un('mousewheel', this.collapseIf, this);
	        Ext.getDoc().un('mousedown', this.collapseIf, this);
	        this.fireEvent('aftercollapse', this);
        }
    },
    
    /**
     * Expands the dropdown list if it is currently hidden. Fires the 'expand' event on completion.
     */
    expand : function(){
        if(this.isExpanded() || !this.hasFocus){
            return;
        }
        if(this.fireEvent('beforeexpand', this) !== false) {
	        this.list.alignTo(this.wrap, this.listAlign);
	        this.list.show();
	        
	        Ext.getDoc().on('mousewheel', this.collapseIf, this);
	        Ext.getDoc().on('mousedown', this.collapseIf, this);
	        this.fireEvent('afterexpand', this);
        }
    },
    
    isExpanded : function(){
        return this.list && this.list.isVisible();
    },


    /**
     * @func private
     * 监听鼠标在浮动层上的移动事件,将数据自动定位到鼠标指向的行
     */ 
    onViewOver : function(e, t){
        //if(this.inKeyMode){ // prevent key nav and mouse over conflicts
            //return;
        //}
        var item = this.view.findItemFromChild(t);
        if(item){
            var index = this.view.indexOf(item);
            this.select(index, false);
        }
    },

    /**
     * @func private
     * 处理选择事件
     */         
    onSelect : function(onlyFlag) {
    	var index = this.view.getSelectedIndexes()[0];
    	var record = this.store.getAt(index);
    	
        if(this.fireEvent('beforeselect', this, record, index) !== false){
            this.setValues(new Array(record));
            this.collapse();
            this.fireEvent('afterselect', this, record, index);
            this.lastValue = '';
        }    	
    },

    /**
     * @func private
     * 选中指定索引的记录
     */ 
    select : function(index, scrollIntoView){
        this.selectedIndex = index;
        this.view.select(index);
        if(scrollIntoView !== false){
            var el = this.view.getNode(index);
            if(el){
                this.innerList.scrollChildIntoView(el, false);
            }
        }
    },

    /**
     * @func private
     * 选中下一条记录
     */ 
    selectNext : function(){
        var ct = this.store.getCount();
        if(ct > 0){
            if(this.selectedIndex == -1){
                this.select(0);
            }else if(this.selectedIndex < ct-1){
                this.select(this.selectedIndex+1);
            }
        }
    },

    /**
     * @func private
     * 选中上一条记录
     */  
    selectPrev : function(){
        var ct = this.store.getCount();
        if(ct > 0){
            if(this.selectedIndex == -1){
                this.select(0);
            }else if(this.selectedIndex != 0){
                this.select(this.selectedIndex-1);
            }
        }
    },

    /**
     * @func public
     * 设置BaseConditions,如store已经初始化,则将store.baseParams内的bcondition参数一起设置
     * @param {Array} array like [{param:'DELETED_FLAG',value:'Y'}, {param:'CODE',value:'1001%'}]
     */
    setBaseConditions : function(/*Array*/array) {
        UniEXT.lookup.FastLookupField.superclass.setBaseConditions.call(this, array);
        if(this.store) {
        	this.store.baseParams.bcondition = UniEXT.encode(this.baseConditions);
        }
    },

    /**
     * @func public
     * 清空BaseConditions,如store已经初始化,则将store.baseParams内的bcondition参数一起清空
     */
    cleanBaseConditions : function() {
        UniEXT.lookup.FastLookupField.superclass.cleanBaseConditions.call(this);
        if(this.store) {
        	this.store.baseParams.bcondition = '';
        }
    },
        
    formatMatchString : UniEXT.lookup.GridWindow.prototype.formatMatchString,
    
    formatValue : UniEXT.lookup.GridLookupField.prototype.formatValue
})