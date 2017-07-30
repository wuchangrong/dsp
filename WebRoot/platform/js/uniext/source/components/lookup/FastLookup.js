/**
 * @class UniEXT.lookup.FastLookupField
 * @extends UniEXT.lookup.LookupField
 * 
 */
UniEXT.lookup.FastLookupField = Ext.extend(UniEXT.lookup.LookupField, {


	
    /**
     * @var private
     * GridLookup���ݹ���javaʵ����
     * @type String
     * @default 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup'
     */
    implClass : 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup',
    
    /**
     * @var cfg.storeCfg
     * ����store���config,����meta��ӦExt.data.JsonReader.meta���ݸ�ʽ,recordType��ӦExt.data.JsonReader.recordType
     * @type Object like {meta: {root: 'data', totalProperty: 'total', id: 'row_id'}, recordType: []}
     * @default null
     */
    storeCfg : null,

    /**
     * @var cfg.selectedClass
     * �����б�ѡ��ѡ���е���ʽ
     * @type String
     * @default 'x-combo-selected'
     */
	selectedClass: 'x-combo-selected',

    /**
     * @var cfg.displayField
     * ���ø����б���ָ����(��ģ������)��ʾ����.֧��ģ������
     * @type String
     * @default null
     */	
	displayField : null,

    /**
     * @var cfg.queryDelay
     * ���ø����б�����ʱ�¼�,��λ����.�ò���ֱ��Ӱ�쵽���ݿ����������,���鲻ҪС��300
     * @type Number
     * @default 500
     */		
	queryDelay : 500,

    /**
     * @var cfg.pageSize
     * ���ø����б��Ƿ��ҳ
     * @type Number
     * @default -1
     */		
	pageSize : -1,

    /**
     * @var cfg.listAlign
     * ���ø����б�����λ��ʽ.������μ�Ext.Element.alignTo�����������Ĳ�������
     * @type Number
     * @default 'tl-bl?'
     */		
	listAlign: 'tl-bl?',
	    
    /**
     * @func private
     * ��ʼ��Lookup�ؼ�
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
     * ��ʼ��Lookup�ؼ�
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
     * ��ʼ������������,�Լ�store,datawindow��
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
	                /*beforePageText : "ҳ",
	                afterPageText : " �� {0}",
	                displayMsg : '��ʾ {0}-{1} �� {2}',
	                emptyMsg : '�޼�¼',*/
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
     * ��Ӧstore����/���¼������ݺ�,���ݷ���ֵ������رո�����
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
     * �ж�Lookup�ؼ���������,��������������filterCondition,��ͨ��store���̨�ύ
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
        
        //����beforeLookup�¼�
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
     * ��������ڸ������ϵ��ƶ��¼�,�������Զ���λ�����ָ�����
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
     * ����ѡ���¼�
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
     * ѡ��ָ�������ļ�¼
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
     * ѡ����һ����¼
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
     * ѡ����һ����¼
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
     * ����BaseConditions,��store�Ѿ���ʼ��,��store.baseParams�ڵ�bcondition����һ������
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
     * ���BaseConditions,��store�Ѿ���ʼ��,��store.baseParams�ڵ�bcondition����һ�����
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