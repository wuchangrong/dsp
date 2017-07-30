/**
 * @class CheckboxGridSelectionModel
 * @extends Ext.grid.CheckboxSelectionModel
 * 
 */
UniEXT.lookup.CheckboxGridSelectionModel = Ext.extend(Ext.grid.CheckboxSelectionModel, {
    handleMouseDown : function(g, rowIndex, e){
        if(e.button !== 0 || this.isLocked()){
            return;
        };
        var view = this.grid.getView();
        if(e.shiftKey && this.last !== false){
            var last = this.last;
            this.selectRange(last, rowIndex, true);
            this.last = last; // reset the last
            view.focusRow(rowIndex);
        }else{
            var isSelected = this.isSelected(rowIndex);
            if(isSelected){
                this.deselectRow(rowIndex);
            }else if(!isSelected || this.getCount() > 1){
                this.selectRow(rowIndex, true);
                view.focusRow(rowIndex);
            }
        }
    }
});

/**
 * @class UniEXT.lookup.GridWindow
 * @extends UniEXT.lookup.DataWindow
 * 
 */
UniEXT.lookup.GridWindow = Ext.extend(UniEXT.lookup.DataWindow, {
	/**
	 * @func private
	 * ��ʼ���¼�
	 * ���store��load�¼�,Ĭ��ѡ�е�һ�м�¼
	 * ��ӵ�ѡgrid��rowdblclick�¼�,˫������ѡ�м�¼���رմ���
	 * @overwrite UniEXT.lookup.DataWindow.initEvents	 
	 */    
	initEvents : function() {
		UniEXT.lookup.GridWindow.superclass.initEvents.call(this);
		//this.store.on('load', this.focusFirstRecord.createDelegate(this, [this.grid]));
	    if(this.singleSelect) {
	    	this.grid.on('rowdblclick', this.returnAndClose.createDelegate(this, [true]));
	    }
	    this.grid.on('keypress', function(e) {
	    	if(e.ENTER == e.getKey()) {
	    		this.returnAndClose(true);
	    	}
	    }, this);
	},

    /**
     * @func private
     * 
     * @overwrite UniEXT.lookup.DataWindow.destroy
     */
    destroy : function(){
    	this.filterField.destroy();
    	this.store.destroy();
    	this.grid.destroy();
        UniEXT.lookup.GridWindow.superclass.destroy.call(this);
    },
    
	/**
	 * @func private
	 * ��ʼ��GridWindow,��ӱ��ؼ�,����,��ҳ��
	 * @implement UniEXT.lookup.DataWindow.initContainer
	 */
    initContainer : function() {
   		this.store = new Ext.data.Store({
	        autoLoad: true,
	        proxy: new Ext.data.ScriptTagProxy({url: this.dataURL}),
	        reader: new Ext.data.JsonReader(this.storeCfg.meta, this.storeCfg.recordType),
	        remoteSort: this.pageSize>0,
	        sortInfo: this.sortInfo,
	        baseParams: {
	            lookupcode: this.lookupCode,
	            sqlid: this.sqlID,
	            dbkey: this.dbkey,
	            pagesize: this.pageSize,
	            implcls: this.implClass,
	            fcondition: [],
	            bcondition: UniEXT.encode(this.baseConditions)
	        }
	    });
	    
	    var sm = null;
	    if(this.singleSelect) {
	    	sm = new Ext.grid.RowSelectionModel({singleSelect:this.singleSelect});
	    } else {
	    	sm = new UniEXT.lookup.CheckboxGridSelectionModel();
	    	this.columnModel = new Array(sm).concat(this.columnModel);
	    }

		this.filterField = new Ext.form.TextField({
	        width : 250,
	        emptyText : this.filterParam.display ? this.filterParam.display : this.filterDisplay,
			//custom ��¼���һ�ι�������
	        lastValue : '',
	        //custom ������DelayedTask
	        filterTask : new Ext.util.DelayedTask(this.onFilter, this),
	        listeners : {
	        	render: function(f){
	        		this.el.on('keyup', this.fireFilterTask.createDelegate(this, []));
	        	}
	        },
		    fireFilterTask : function() {
		    	this.filterTask.delay(500);
		    }
	    });

	    this.grid = new Ext.grid.GridPanel({
	        region : 'center',
	        enableColumnMove : false,
	        enableHdMenu : false,
	        border : false,
	        autoScroll : true,
	        store : this.store,
	        cm : new Ext.grid.ColumnModel(this.columnModel),
	        sm : sm,
	        trackMouseOver : true,
	        loadMask : {/*msg:'�����У����Ժ�...', */removeMask:(!this.pageSize>0)},
	        viewConfig : {forceFit:true, enableRowBody:true},
	        tbar : [this.filterField],
	        bbar : this.genPagingToolbar()
	    });
	    this.add(this.grid);
    },

    /**
     * @func public
     * @implement UniEXT.lookup.DataWindow.getValues
     * @return {Mixed} like Ext.data.Record[] or Ext.tree.TreeNode[]
     */
    getValues : function() {
    	return this.grid.getSelectionModel().getSelections();
    },
    	
	/**
	 * @func private
	 * ����pageSize�ж��Ƿ����ɷ�ҳ��
	 * @return {Ext.PagingToolbar}
	 */
	genPagingToolbar : function() {
        if(this.pageSize > 0){
            return new Ext.PagingToolbar({
                pageSize : this.pageSize,
                store : this.store,
                displayInfo : true,
                /*beforePageText : "ҳ",
                afterPageText : " �� {0}",
                displayMsg : '��ʾ {0}-{1} �� {2}',
                emptyMsg : '�޼�¼',*/
                paramNames : {start:'start', limit:'pagesize'}
            });
        };
	},
	
	/**
	 * @func private
	 * ѡ�б���һ��
	 */
    /*focusFirstRecord : function() {
        this.grid.getSelectionModel().selectFirstRow();
    },*/
	
	/**
	 * @func private
	 * ���ݹ��˴���
	 * ����pageSize�ֱ����Զ�̹��˻򱾵ع���
	 */
	onFilter : function() {
		var value = this.filterField.getValue();
        if(this.filterField.lastValue == value) {
            this.filterField.focus();
            return;
        }
        this.filterField.lastValue = value;

        if(this.pageSize > 0) {
            this.remoteFilter(value);
        } else {
            this.localFilter(value);
        }
	},
	
	/**
	 * @func private
	 * Զ�����ݹ���
	 * @param {String} value
	 */
    remoteFilter : function(value) {
        var fc = null;
        if(value != '') {
            var fields = this.filterParam.fields;
            var obj = new Array();
            for(var i=0; i<fields.length; i++) {
            	var temp = this.formatMatchString(value,fields[i].matchType);
                obj[i] = {param:fields[i].name, value:UniEXT.util.Base64.encode64Plus(temp)};
            }
            fc = UniEXT.encode(obj);
        }
        Ext.apply(this.store.baseParams, {fcondition:fc});
        this.store.load({params:{start:0}});
    },
    
	/**
	 * @func private
	 * ΪԶ�̹����ṩʽ�����ƥ��ֵ
	 * @param {String} value
	 * @param {String} matchType
	 * @return {String} value after format
	 */
    formatMatchString : function(value, matchType) {
		switch (matchType) {
		   case '=' :
		       return value;
		   case '*%' :
		       return value + '%';
		   case '%*' :
		       return '%' + value;		       
		   case '%*%' :
		       return '%' + value + '%';
		}
    },

	/**
	 * @func private
	 * �������ݹ���
	 * @param {String} value
	 */
    localFilter : function(value) {
    	if(value == '') {
    		this.store.clearFilter(false);
    	}else {
    	    
	        this.store.filterBy(function(record, id) {
	            //var regExp = new RegExp('^' + Ext.escapeRe(value), 'i');
	            var fields = this.filterParam.fields;
	            for(var i=0; i<fields.length; i++) {
	            	var regExp = this.getValueMatcher(value, fields[i].matchType);
	                if(regExp.test(record.get(fields[i].name))) {
	                    return true;
	                }
	            }
	            return false;
	        }, this);
        }
        //this.focusFirstRecord();
    }
    

    

});





/**
 * @class UniEXT.lookup.GridLookupField
 * @extends UniEXT.lookup.PopupLookupField
 * 
 */
UniEXT.lookup.GridLookupField = Ext.extend(UniEXT.lookup.PopupLookupField, {

    /**
     * @var cfg.winTitle
     * ���������ݴ��ڱ���
     * @type String
     * @default 'Grid Lookup'
     */        
    winTitle : 'Grid Lookup',

    /**
     * @var cfg.columnModel
     * ����ColumnModel
     * @type Array see Ext.grid.ColumnModel
     * @default null
     */ 
    columnModel : null,
    
    /**
     * @var cfg.pageSize
     * ����ÿҳ��ʾ��
     * @type Number
     * @default 15
     */     
    pageSize : 15,

    /**
     * @var cfg.storeCfg
     * ����store���config,����meta��ӦExt.data.JsonReader.meta���ݸ�ʽ,recordType��ӦExt.data.JsonReader.recordType
     * @type Object like {meta: {root: 'data', totalProperty: 'total', id: 'row_id'}, recordType: []}
     * @default null
     */
    storeCfg : null,
    
    /**
     * @var private
     * GridLookup���ݹ���javaʵ����
     * @type String
     * @default 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup',
     */
    implClass : 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup',
        
    /**
     * @func private
     * ��ʼ��GridLookup
     * @overwrite UniEXT.lookup.PopupLookupField.initComponent
     */
    initComponent : function() {
        UniEXT.lookup.GridLookupField.superclass.initComponent.call(this);
    	this.addWLAttrMapping([
    		{wa:'columnModel', la:'columnModel'},
    		{wa:'storeCfg', la:'storeCfg'}, 
    		{wa:'pageSize', la:'pageSize'}
    	]);
    },
    
    /**
     * @func private
     * @implement UniEXT.lookup.PopupLookupField.genDataWindow
     * @param {Object} winCfg
     * @param {Object} winOpenWith
     * @return {UniEXT.lookup.GridWindow}
     */
    genDataWindow : function(winCfg, winOpenWith) {
        var win = null;
    	if(winOpenWith != null) {
    	    var p = ['columnModel', 'baseConditions', 'filterParam', 'storeCfg'];
    		winCfg = this.encodeArrayAttr(winCfg, p);
    		win = winOpenWith.UniEXT.lookup.LookupManager.genGridWindow(winCfg, p);
    	}
    	else {
    		win = new UniEXT.lookup.GridWindow(winCfg);
    	}
    	return win;
    },
    
    /**
     * @func private
     * @implement UniEXT.lookup.LookupField.formatValue
     * @param {Mixed} datadefine dataELMapping.data String or Template
     * @param {Mixed} values like Ext.data.Record or Ext.tree.TreeNode
     */
    formatValue : function(datadefine, values) {
    	if(typeof datadefine == 'string') {
    		return values.get(datadefine);
    	}
    	if(typeof datadefine=='object' && datadefine.applyTemplate) {
    		return datadefine.applyTemplate(values.data);
    	}
    	alert('��Ч��dataELMapping����!');
    }
});