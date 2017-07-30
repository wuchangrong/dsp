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
	 * 初始化事件
	 * 添加store的load事件,默认选中第一行记录
	 * 添加单选grid的rowdblclick事件,双击返回选中记录并关闭窗口
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
	 * 初始化GridWindow,添加表格控件,过滤,分页等
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
			//custom 记录最后一次过滤条件
	        lastValue : '',
	        //custom 过滤用DelayedTask
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
	        loadMask : {/*msg:'加载中，请稍候...', */removeMask:(!this.pageSize>0)},
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
	 * 根据pageSize判断是否生成分页条
	 * @return {Ext.PagingToolbar}
	 */
	genPagingToolbar : function() {
        if(this.pageSize > 0){
            return new Ext.PagingToolbar({
                pageSize : this.pageSize,
                store : this.store,
                displayInfo : true,
                /*beforePageText : "页",
                afterPageText : " 共 {0}",
                displayMsg : '显示 {0}-{1} 共 {2}',
                emptyMsg : '无记录',*/
                paramNames : {start:'start', limit:'pagesize'}
            });
        };
	},
	
	/**
	 * @func private
	 * 选中表格第一行
	 */
    /*focusFirstRecord : function() {
        this.grid.getSelectionModel().selectFirstRow();
    },*/
	
	/**
	 * @func private
	 * 数据过滤处理
	 * 根据pageSize分别调用远程过滤或本地过滤
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
	 * 远程数据过滤
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
	 * 为远程过滤提供式化后的匹配值
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
	 * 本地数据过滤
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
     * 弹出的数据窗口标题
     * @type String
     * @default 'Grid Lookup'
     */        
    winTitle : 'Grid Lookup',

    /**
     * @var cfg.columnModel
     * 表格的ColumnModel
     * @type Array see Ext.grid.ColumnModel
     * @default null
     */ 
    columnModel : null,
    
    /**
     * @var cfg.pageSize
     * 表格的每页显示数
     * @type Number
     * @default 15
     */     
    pageSize : 15,

    /**
     * @var cfg.storeCfg
     * 表格的store相关config,其中meta对应Ext.data.JsonReader.meta数据格式,recordType对应Ext.data.JsonReader.recordType
     * @type Object like {meta: {root: 'data', totalProperty: 'total', id: 'row_id'}, recordType: []}
     * @default null
     */
    storeCfg : null,
    
    /**
     * @var private
     * GridLookup数据供给java实现类
     * @type String
     * @default 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup',
     */
    implClass : 'com.handao.platform.framework.ajax.json.lookup.AFJsonGridLookup',
        
    /**
     * @func private
     * 初始化GridLookup
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
    	alert('无效的dataELMapping设置!');
    }
});