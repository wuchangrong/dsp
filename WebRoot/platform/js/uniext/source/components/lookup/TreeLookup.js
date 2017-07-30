/**
 * @function UniEXT.lookup.OnlyLeafNodeSelectable
 */
UniEXT.lookup.OnlyLeafNodeSelectable = function(/*Ext.tree.TreeNode*/node, /*Ext.EventObject*/e) {
	return node.isLeaf();
}

/**
 * @function UniEXT.lookup.AllNodeSelectable
 */
UniEXT.lookup.AllNodeSelectable = function(/*Ext.tree.TreeNode*/node, /*Ext.EventObject*/e) {
	return true;
};

/**
 * @class UniEXT.lookup.SingleSelectTreeNodeUI
 * @extends UniEXT.tree.TreeNodeUI
 * 
 */
UniEXT.lookup.SingleSelectTreeNodeUI = Ext.extend(UniEXT.tree.TreeNodeUI, {
	/**
	 * @func private
	 * 修改原UI的实现逻辑
	 * @overwrite Ext.tree.TreeNodeUI.onClick
	 */
    onClick : function(e){
        if(this.fireEvent("beforeclick", this.node, e) !== false){
            e.preventDefault();
            if(this.disabled){
                return;
            }
            this.fireEvent("click", this.node, e);
            this.focusTreeEL();
        }else{
            e.stopEvent();
        }
    },
    
	/**
	 * @func private
	 * 修改原UI的实现逻辑
	 * @overwrite Ext.tree.TreeNodeUI.onDblClick
	 */    
    onDblClick : function(e){
        e.preventDefault();
        if(this.disabled){
            return;
        }
        if(!this.animating && this.node.hasChildNodes()){
            this.node.toggle();
        }
        this.fireEvent("dblclick", this.node, e);
    }
});





/**
 * @class UniEXT.lookup.CheckboxTreeNodeUI
 * @extends UniEXT.tree.TreeNodeUI
 */
UniEXT.lookup.CheckboxTreeNodeUI = Ext.extend(UniEXT.tree.TreeNodeUI, {

	/**
	 * @func private
	 * 修改原UI的实现逻辑,其中checkbox使用img实现
	 * @overwrite Ext.tree.TreeNodeUI.renderElements
	 */
    renderElements : function(n, a, targetNode, bulkRender){
    
        // add some indent caching, this helps performance when rendering a large tree
        this.indentMarkup = n.parentNode ? n.parentNode.ui.getChildIndent() : '';


        var href = a.href ? a.href : Ext.isGecko ? "" : "#";
        var buf = ['<li class="x-tree-node"><div ext:tree-node-id="',n.id,'" class="x-tree-node-el x-tree-node-leaf ', a.cls,'">',
            '<span class="x-tree-node-indent">',this.indentMarkup,"</span>",
            '<img src="', this.emptyIcon, '" class="x-tree-ec-icon x-tree-elbow" />',
            '<img src="', a.icon || this.emptyIcon, '" class="x-tree-node-icon',(a.icon ? " x-tree-node-inline-icon" : ""),(a.iconCls ? " "+a.iconCls : ""),'" unselectable="on" />',
            '<img src="', this.emptyIcon, '" class="x-tree-node-check-none">',
            '<a hidefocus="on" class="x-tree-node-anchor" href="',href,'" tabIndex="1" ',
             a.hrefTarget ? ' target="'+a.hrefTarget+'"' : "", '><span unselectable="on">',n.text,"</span></a></div>",
            '<ul class="x-tree-node-ct" style="display:none;"></ul>',
            "</li>"].join('');

        if(bulkRender !== true && n.nextSibling && n.nextSibling.ui.getEl()){
            this.wrap = Ext.DomHelper.insertHtml("beforeBegin",
                                n.nextSibling.ui.getEl(), buf);
        }else{
            this.wrap = Ext.DomHelper.insertHtml("beforeEnd", targetNode, buf);
        }
        
        this.elNode = this.wrap.childNodes[0];
        this.ctNode = this.wrap.childNodes[1];
        var cs = this.elNode.childNodes;
        this.indentNode = cs[0];
        this.ecNode = cs[1];
        this.iconNode = cs[2];
        this.checkbox = cs[3];
        this.anchor = cs[4];
        this.textNode = cs[4].firstChild;
        
        
        
        this.checkbox.onclick = function(e) {n.getOwnerTree().getSelectionModel().onNodeClick(n, e)};
        /*this.checkbox.onclick = function(e) {
        	var checked = false;
        	if(this.className == 'x-tree-node-check-none') {
        		checked = true;
        	}
        	this.className = checked ? 'x-tree-node-check-all' : 'x-tree-node-check-none';
        	
        	//this.checkbox.className = '';
        	var sm = n.getOwnerTree().getSelectionModel();
        	if(checked) {
        		sm.select(n, e, true);
        	}else {
        		sm.unselect(n);
        	}
        };*/
    },

	/**
	 * @func private
	 * 修改原UI的实现逻辑
	 * @overwrite Ext.tree.TreeNodeUI.onClick
	 */
    onClick : function(e){
        if(this.fireEvent("beforeclick", this.node, e) !== false){
            e.preventDefault();
            if(this.disabled){
                return;
            }
			//this.toggleCheck();
            this.fireEvent("click", this.node, e);
            this.focusTreeEL();
        }else{
            e.stopEvent();
        }
    },

	/**
	 * @func private
	 * 修改原UI的实现逻辑
	 * @overwrite Ext.tree.TreeNodeUI.onDblClick
	 */
    onDblClick : function(e){
        e.preventDefault();
        if(this.disabled){
            return;
        }/*
        if(!this.animating && this.node.hasChildNodes()){
            this.node.toggle();
        }*/
        this.fireEvent("dblclick", this.node, e);
    },

	/**
	 * @func private
	 * 修改原UI的实现逻辑
	 * @overwrite Ext.tree.TreeNodeUI.onSelectedChange
	 */    
    onSelectedChange : function(state){
        if(state){
            this.focus();
            this.addClass("x-tree-selected");
        }else{
            //this.blur();
            this.removeClass("x-tree-selected");
        }
        //this.checkbox.checked = state;
        this.checkbox.className = state ? 'x-tree-node-check-all' : 'x-tree-node-check-none';
    }
});

/**
 * @class UniEXT.lookup.SSTreeSelectionModel
 * @extends Ext.tree.DefaultSelectionModel
 */
UniEXT.lookup.SSTreeSelectionModel = Ext.extend(Ext.tree.DefaultSelectionModel, {
    nodeSelectable : null,
    
    onEnterDown : null,
    
    /*onNodeClick : function(node, e){
    	if(this.selectLogic.nodeSelectable(node, e)) {
        	this.select(node);
        }
    },*/
    
    select : function(node){
    	if(!this.nodeSelectable(node)) {
        	return;
        }
        var last = this.selNode;
        if(last != node && this.fireEvent('beforeselect', this, node, last) !== false){
            if(last){
                last.ui.onSelectedChange(false);
            }
            this.selNode = node;
            node.ui.onSelectedChange(true);
            this.fireEvent("selectionchange", this, node, last);
        }
        return node;
    },
    
    onKeyDown : function(e){
    	if(e.getKey() == e.ENTER) {
    		if(this.onEnterDown != null)
    			this.onEnterDown(e);
    		return;
    	}
    	UniEXT.lookup.SSTreeSelectionModel.superclass.onKeyDown.call(this, e);
    }
});

/**
 * @class UniEXT.lookup.CheckboxTreeSelectionModel
 * @extends Ext.tree.MultiSelectionModel
 */
UniEXT.lookup.CheckboxTreeSelectionModel = Ext.extend(Ext.tree.MultiSelectionModel, {
    nodeSelectable : null,
    
    onEnterDown : null,
    
    cascadeSelect : true, //级联选择标志

    /**
     * @func public
     * Select a node.
     * @param {TreeNode} node The node to select
     * @param {EventObject} e (optional) An event associated with the selection
     * @param {Boolean} keepExisting True to retain existing selections
     * @return {TreeNode} The selected node
     */
    select : function(node, e, keepExisting, upDownFlag){
		if(node.hidden || (node.parentNode==null&&!node.getOwnerTree().rootVisible)) {
			return;
		}
		
		if(!this.nodeSelectable(node, e)) {
			return;
		}
		
        //UniEXT.lookup.CheckboxTreeSelectionModel.superclass.select.call(this, node, e, keepExisting);
    	UniEXT.lookup.CheckboxTreeSelectionModel.superclass.select.call(this, node, e, keepExisting);
	
		if(this.cascadeSelect) {

			var isStartPoint = !upDownFlag;
	        
	        if(('up'==upDownFlag || isStartPoint) && node.parentNode!=null) {
	        	this.select(node.parentNode, e, true, isStartPoint?'up':upDownFlag);
	        }
	
			if('down'==upDownFlag || isStartPoint) {
		        if(!node.expanded) {
		        	node.expand();
		        }
		        if(node.childNodes && node.childNodes.length>0) {
			        for(var i=0; i<node.childNodes.length; i++) {
			        	this.select(node.childNodes[i], e, true, isStartPoint?'down':upDownFlag);
			        }
		        }
			}
		}

        return node;
    },
    
    /**
     * Deselect a node.
     * @param {TreeNode} node The node to unselect
     */
    unselect : function(node){
        if(this.selMap[node.id] && this.cascadeSelect){
        	if(node.childNodes && node.childNodes.length>0) {
		        for(var i=0; i<node.childNodes.length; i++) {
		        	this.unselect(node.childNodes[i]);
		        }
        	}
        }
    	UniEXT.lookup.CheckboxTreeSelectionModel.superclass.unselect.call(this, node);
    },
    
    onNodeClick : function(node, e){
		if(node.isSelected()) {
			this.unselect(node);
		} else {
        	this.select(node, e, true);
        }
    },
    
    onKeyDown : function(e){
    	if(e.getKey() == e.ENTER) {
    		if(this.onEnterDown != null)
    			this.onEnterDown(e);
    	}
    }
    
});



/**
 * @class UniEXT.lookup.TreeWindow
 * @extends UniEXT.lookup.DataWindow
 * 
 */
UniEXT.lookup.TreeWindow = Ext.extend(UniEXT.lookup.DataWindow, {
	/**
	 * @func private
	 * 初始化事件
	 * 添加store的load事件,默认选中第一行记录
	 * 添加单选grid的rowdblclick事件,双击返回选中记录并关闭窗口
	 * @overwrite UniEXT.lookup.DataWindow.initEvents
	 */    
	initEvents : function() {
		UniEXT.lookup.TreeWindow.superclass.initEvents.call(this);

	    /*this.tree.on('keypress', function(e) {
	    	if(e.ENTER == e.getKey()) {
	    		alert(123);//this.returnAndClose(true);
	    	}
	    }, this);*/
		/*
    	if(this.nodeSelectable == null) {
    		this.nodeSelectable = (this.singleSelect && this.onlyLeafNodeSelectable)
    			? new UniEXT.lookup.OnlyLeafNodeSelectable()
    			: new UniEXT.lookup.AllNodeSelectable();
    	}
    	if(this.nodeSelectable.nodeSelectable!=null && (typeof this.nodeSelectable.nodeSelectable=="function")) {
    		this.tree.on('beforeclick', this.nodeSelectable.nodeSelectable);
    	}
	    */
	},

	/**
	 * @func private
	 * @overwrite UniEXT.lookup.DataWindow.destroy
	 */    
    destroy : function(){
    	this.filterField.destroy();
        UniEXT.lookup.TreeWindow.superclass.destroy.call(this);
    },
    
	/**
	 * @func private
	 * 初始化TreeWindow,添加树控件,过滤
	 * @implement UniEXT.lookup.DataWindow.initContainer
	 */
    initContainer : function() {
    	
    	
    	var filtertsk = this.isFilterOnBack?this.reloadTree:this.onFilter;

		this.filterField = new Ext.form.TextField({
	        width : 250,
	        emptyText : this.filterParam.display ? this.filterParam.display : this.filterDisplay,
			//custom 记录最后一次过滤条件
	        lastValue : '',
	        //custom 过滤用DelayedTask
	        filterTask :  new Ext.util.DelayedTask(filtertsk, this),
	        listeners : {
	        	render: function(f){
	        		this.el.on('keyup', this.fireFilterTask.createDelegate(this, []));
	        	}
	        },
		    fireFilterTask : function() {
	        	if (event.keyCode == 13){//改成回车后进行查询
	        		this.filterTask.delay(100);
	        	}
		    	////根据项目需要，将500修改为3000，李甲琰
		    }
	    });
	    
	    var baseAttrs = this.nodeBaseAttrs || {};
	    if(this.singleSelect) {
	    	baseAttrs.uiProvider = UniEXT.lookup.SingleSelectTreeNodeUI;
	    } else {
	    	baseAttrs.checked = false;
			baseAttrs.uiProvider = UniEXT.lookup.CheckboxTreeNodeUI;
	    }
	    
	    
    	var loader = new Ext.tree.TreeLoader({
	        dataUrl: this.dataURL,
	        baseAttrs: baseAttrs,
	        baseParams: {
	            lookupcode: this.lookupCode,
	            sqlid: this.sqlID,
	            dbkey: this.dbkey,
	            implcls: this.implClass,
	            sort: this.sortInfo ? this.sortInfo.field : '',
	            dir: this.sortInfo ? this.sortInfo.direction : '',
	            fcondition: [],
	            bcondition: UniEXT.encode(this.baseConditions),
	            leafflag: this.leafNodeFlag
	        }
	    });
	    
	    
	    this.tree = new Ext.tree.TreePanel({
	    	region:'center',
	    	border: false,
		    autoScroll: true,
		    containerScroll: false,
		    animate: false,
		    rootVisible: this.rootNodeVisible,
		    loader: loader,
		    selModel: this.genTreeSelectionModel(),
		    root: this.root ? this.root : new Ext.tree.AsyncTreeNode({text:'ROOT', draggable:false, id:'-1'}),
			tbar: [this.filterField]
		});
	     
        this.add(this.tree);
    },

    /**
     * @func private
     * @根据节点选择逻辑以及单选多选标志生成SelectionModel
     * @return {SelectionModel}
     */    
    genTreeSelectionModel : function() {
    	if(this.nodeSelectable == null) {
    		this.nodeSelectable = this.onlyLeafNodeSelectable
    			? UniEXT.lookup.OnlyLeafNodeSelectable
    			: UniEXT.lookup.AllNodeSelectable;
    	}
    	var sm = this.singleSelect 
    		? new UniEXT.lookup.SSTreeSelectionModel()
    		: new UniEXT.lookup.CheckboxTreeSelectionModel();

    	sm.nodeSelectable = this.nodeSelectable;
    	sm.onEnterDown = this.returnAndClose.createDelegate(this, [true]);
    	if(!this.singleSelect) {
    		sm.cascadeSelect = this.cascadeSelect;
    	}
    	return sm;
    },
	
    /**
     * @func private
     * @implement UniEXT.lookup.DataWindow.getValues
     * @return {Mixed} like Ext.data.Record[] or Ext.tree.TreeNode[]
     */
    getValues : function() {
   		var sm = this.tree.getSelectionModel();
   		var array = null;
   		if(this.singleSelect) {
   			if(sm.getSelectedNode()) {
   				array = new Array(sm.getSelectedNode());
   			}
   		}else {
   			array = sm.getSelectedNodes();
   		}
   		return array;
    },
    
	/**
	 * @var private
	 * onFilter专用变量,用于储存被过滤的不显示的节点
	 * @type {Array}
	 * @default []
	 */
	hiddenNodes : [],
	
	/**
	 * 刷新整个树
	 */
	reloadTree : function(){
    	var value = this.filterField.getValue();
        if(this.filterField.lastValue == value) {
            if(this.isRefreshSpaceEachTime&&value==''){}
            else{
                this.filterField.focus();
                return;
            }
        }
        
        this.filterField.lastValue = value;
    	
    	var winObj = this;
    	
    	var fields = winObj.filterParam.fields;
    	
    	var loader = this.tree.loader;
    	
    	var conditions = winObj.baseConditions;
    	
    	
    	for(var i=0; i<fields.length; i++) {
        	var condi = winObj.getValueParam(value, fields[i].matchType,fields[i].name);
        	var obj = new Object;
        	obj['param'] = fields[i].name;
        	obj['value'] = condi;
        	conditions.push(obj);
        }
    	
    	conditions.push({param: "TREEFILTER", value : "qtip"});
    	
    	loader.baseParams.bcondition = UniEXT.encode(conditions);
    	
    	this.tree.loader = loader;
    	
        this.tree.root.reload();
    },
    
    /**
     * 取得需要过滤的值,为一个数组
     */
    getValueParam : function(value, matchType, name) {
		switch (matchType) {
		   case '=' :
			   return value;
		   case '*%' :
			   return value+ "%";
		   case '%*' :
			   return "%" + value;
		   case '%*%' :
			   return "%" + value + "%";
		}
    },
	
	/**
	 * @func private
	 * 对树进行本地过滤,第一次过滤由于需要递归展开所有子节点,速度会根据数据量有轻微到严重的影响(下一个版本需要考虑优化)
	 */
	onFilter : function() {
		var value = this.filterField.getValue();
        if(this.filterField.lastValue == value) {
            if(this.isRefreshSpaceEachTime&&value==''){}
            else{
                this.filterField.focus();
                return;
            }
        }
        
        this.filterField.lastValue = value;

		Ext.each(this.hiddenNodes, function(n){
			n.ui.show();
		});
		if(value == ''){
			this.hiddenNodes = [];
			return;
		}
		
		var winObj = this;
		
		var doHidden = function(n) {
			n.ui.hide();
			this.hiddenNodes.push(n);
		};
		
		
		var test = function(node) {
			var fields = winObj.filterParam.fields;
            for(var i=0; i<fields.length; i++) {
            	var regExp = winObj.getValueMatcher(value, fields[i].matchType);
                if(regExp.test(node.attributes[fields[i].name])) {
                    return true;
                }
            }
            return false;
		}
		
		var filterLogic = function(n) {
			if(n.isLeaf()) {
				if(!test(n)) {
					doHidden.call(winObj, n);
				}
			}
			if(n.parentNode!=null && n.nextSibling==null) {
				var allHiddenFlag = true;
				for(var i=0; i<n.parentNode.childNodes.length; i++) {
					if(!n.parentNode.childNodes[i].hidden) {
						allHiddenFlag = false;
						break;
					}
				}
				if(allHiddenFlag && !test(n.parentNode)) {
					doHidden.call(winObj, n.parentNode);
				}
				filterLogic(n.parentNode);
			}
		};

		this.tree.root.cascade(function(n) {
			if(!n.isLeaf() && n.childNodes.length==0) {
				n.expand();
			} else {
				filterLogic(n);
			}
			return true;
		});
	}
});





/**
 * @class UniEXT.lookup.TreeLookupField
 * @extends UniEXT.lookup.PopupLookupField
 * 
 */
UniEXT.lookup.TreeLookupField = Ext.extend(UniEXT.lookup.PopupLookupField, {

    /**
     * @var cfg.winTitle
     * 弹出的数据窗口标题
     * @type String
     * @default 'Tree Lookup'
     */        
    winTitle : 'Tree Lookup',

    /**
     * @var cfg.lookupCode
     * 根据指定lookupCode获取数据库配置生成动态sql语句为lookup提供数据
     * 与sqlID不可同时使用
     * @type String
     * @default ''
     */
    lookupCode : '',
    
    /**
     * @var cfg.dbkey
     * 在多数据源情况下,通过dbkey指定lookupCode/sqlID查询时使用的数据库
     * @type String
     * @default ''
     */
	dbkey : '',

    /**
     * @var cfg.cascadeSelect
     * 多选树级联选择标志,只有当singleSelect为false时才有效
     * @type boolean
     * @default true
     */	
	cascadeSelect : true,
	
    /**
     * @var cfg.leafNodeFlag
     * 节点是否是末级标志的判断值
     * @type String
     * @default 'true'
     */
	leafNodeFlag : 'true',	
	
    /**
     * @var cfg.onlyLeafNodeSelectable
     * 是否只能选择末级节点
     * 该参数只在singleSelect为true的时候才有效
     * @type boolean
     * @default false
     */
    onlyLeafNodeSelectable : false,

    /**
     * @var cfg.rootNode
     * 根节点
     * @type Ext.tree.TreeNode
     * @default null
     */
    rootNode : null,

    /**
     * @var cfg.rootNodeVisible
     * 根节点是否可见
     * @type boolean
     * @default false
     */
    rootNodeVisible : false,
        
    /**
     * @var cfg.nodeSelectable
     * 节点是否可选择逻辑
     * @type UniEXT.lookup.TreeNodeSelectableLogic
     * @default null
     */    
    nodeSelectable : null,
    
    /**
     * @var cfg.nodeBaseAttrs
     * 设置节点基本属性
     * @type Object like {text:'{code}-{name}', href:'/contextPath/a/b/c.do?id={id}'}
     * @default null
     */
    nodeBaseAttrs : null,    
    
    isFilterOnBack : false,
    
    /**
    *如果输入空格是否每次刷新，在一些实时性要求高的场合配置为TRUE
    */
    isRefreshSpaceEachTime : false,

    /**
     * TreeLookup数据供给java实现类
     * @type String
     * @default 'com.handao.platform.framework.ajax.json.lookup.AFJsonTreeLookup'
     */	
    implClass : 'com.handao.platform.framework.ajax.json.lookup.AFJsonTreeLookup',	
	
    	
    /**
     * 由最上级EXTJS父类调用
     * @func private
     * 初始化TreeLookup
     * @overwrite UniEXT.lookup.PopupLookupField.initComponent
     */
    initComponent : function() {
        UniEXT.lookup.TreeLookupField.superclass.initComponent.call(this);//初始化父类容器
    	this.addWLAttrMapping([
    		{wa:'rootNode', la:'rootNode'},
    		{wa:'rootNodeVisible', la:'rootNodeVisible'},
    		{wa:'nodeBaseAttrs', la:'nodeBaseAttrs'},
    		{wa:'onlyLeafNodeSelectable', la:'onlyLeafNodeSelectable'},
    		{wa:'leafNodeFlag', la:'leafNodeFlag'},
    		{wa:'nodeSelectable', la:'nodeSelectable'},
    		{wa:'cascadeSelect', la:'cascadeSelect'},
    		{wa:'isFilterOnBack', la:'isFilterOnBack'},
    		{wa:'isRefreshSpaceEachTime', la:'isRefreshSpaceEachTime'}
    		
    	]);
    },
    
    /**
     * @func private
     * @implement UniEXT.lookup.PopupLookupField.genDataWindow
     * @param {Object} winCfg
     * @param {Object} winOpenWith
     * @return {UniEXT.lookup.TreeWindow}
     */
    genDataWindow : function(winCfg, winOpenWith) {
    	var win = null;
    	if(winOpenWith != null) {
    		var p = ['baseConditions'];
    		winCfg = this.encodeArrayAttr(winCfg, p);
    		win = winOpenWith.UniEXT.lookup.LookupManager.genTreeWindow(winCfg, p);
    	}
    	else {
    		win = new UniEXT.lookup.TreeWindow(winCfg);//将本身属性赋予TreeWindow传回
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
    		return values.attributes[datadefine];
    	}
    	if(typeof datadefine=='object' && datadefine.applyTemplate) {
    		return datadefine.applyTemplate(values.attributes);
    	}
    	alert('无效的dataELMapping设置!');
    }    
});


