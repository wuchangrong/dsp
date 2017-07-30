/**
 * @class abstract UniEXT.tree.TreeNodeSelectableLogic
 * @extends Ext.util.Observable
 */
UniEXT.tree.TreeNodeSelectableLogic = function(config) {
	/**
	 * @func abstract
	 * @param {Ext.tree.TreeNode} node
	 * @param {Ext.EventObject} e 
	 */
	nodeSelectable = Ext.emptyFn;
	
	Ext.apply(this, config);
};
Ext.extend(UniEXT.tree.TreeNodeSelectableLogic, Ext.util.Observable, {
});

/**
 * @class UniEXT.tree.OnlyLeafNodeSelectable
 * @extends UniEXT.tree.TreeNodeSelectableLogic
 */
UniEXT.tree.OnlyLeafNodeSelectable = Ext.extend(UniEXT.tree.TreeNodeSelectableLogic, {

	/**
	 * @func public
	 * @implement UniEXT.tree.TreeNodeSelectableLogic.nodeSelectable
	 * @param {Ext.tree.TreeNode} node
	 * @param {Ext.EventObject} e 
	 */
	nodeSelectable : function(/*Ext.tree.TreeNode*/node, /*Ext.EventObject*/e) {
		return node.isLeaf();
	}
});

/**
 * @class UniEXT.tree.AllNodeSelectable
 * @extends UniEXT.tree.TreeNodeSelectableLogic
 */
UniEXT.tree.AllNodeSelectable = Ext.extend(UniEXT.tree.TreeNodeSelectableLogic, {

	/**
	 * @func public
	 * @implement UniEXT.tree.TreeNodeSelectableLogic.nodeSelectable
	 * @param {Ext.tree.TreeNode} node
	 * @param {Ext.EventObject} e 
	 */
	nodeSelectable : function(/*Ext.tree.TreeNode*/node, /*Ext.EventObject*/e) {
		return true;
	}
});

/**
 * @class UniEXT.tree.CheckboxTreeNodeUI
 * @extends UniEXT.tree.TreeNodeUI
 */
UniEXT.tree.CheckboxTreeNodeUI = Ext.extend(UniEXT.tree.TreeNodeUI, {

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
 * @class UniEXT.tree.AsyncTreeNodeUI
 * @extends EXT.tree.TreeNodeUI
 */
UniEXT.tree.AsyncTreeNodeUI = Ext.extend(UniEXT.tree.TreeNodeUI, {
    onClick : function(e) {
         e.stopEvent();
    }
});

/**
 * @class UniEXT.tree.CheckboxTreeSelectionModel
 * @extends Ext.tree.MultiSelectionModel
 */
UniEXT.tree.CheckboxTreeSelectionModel = Ext.extend(Ext.tree.MultiSelectionModel, {
    selectLogic : null,
    
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
		
		if(!this.selectLogic.nodeSelectable(node, e)) {
			return;
		}

    	UniEXT.tree.CheckboxTreeSelectionModel.superclass.select.call(this, node, e, keepExisting);

        if(this.cascadeSelect) {
		    var isStartPoint = !upDownFlag;

            if(('up'==upDownFlag || isStartPoint) && node.parentNode!=null) {
        	    if (node.parentNode.getDepth()!="0")
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
        if(this.selMap[node.id]){
        	if(node.childNodes && node.childNodes.length>0) {
		        for(var i=0; i<node.childNodes.length; i++) {
		        	this.unselect(node.childNodes[i]);
		        }
        	}
        }
    	UniEXT.tree.CheckboxTreeSelectionModel.superclass.unselect.call(this, node);
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
    },

    /**
     * Select one node.
     * @param {TreeNode} node The node to select
     * @param {EventObject} e (optional) An event associated with the selection
     * @param {Boolean} keepExisting True to retain existing selections
     * @return {TreeNode} The selected node
     */
    oneSelect : function(node, e, keepExisting){
        if(keepExisting !== true){
            this.clearSelections(true);
        }
        if(this.isSelected(node)){
            this.lastSelNode = node;
            return node;
        }
        this.selNodes.push(node);
        this.selMap[node.id] = node;
        this.lastSelNode = node;
        node.ui.onSelectedChange(true);
        this.fireEvent("selectionchange", this, this.selNodes);
        return node;
    },
    
    /**
     * Deselect one node.
     * @param {TreeNode} node The node to unselect
     */
    oneUnselect : function(node){
        if(this.selMap[node.id]){
            node.ui.onSelectedChange(false);
            var sn = this.selNodes;
            var index = -1;
            if(sn.indexOf){
                index = sn.indexOf(node);
            }else{
                for(var i = 0, len = sn.length; i < len; i++){
                    if(sn[i] == node){
                        index = i;
                        break;
                    }
                }
            }
            if(index != -1){
                this.selNodes.splice(index, 1);
            }
            delete this.selMap[node.id];
            this.fireEvent("selectionchange", this, this.selNodes);
        }
    }
    
    
});


/**
 * @class UniEXT.tree.MultiTree  多选树
 * @extends Ext.tree.TreePanel
 * 
 */
 
UniEXT.tree.MultiTree = Ext.extend(Ext.tree.TreePanel, {

    /**
     * @var cfg.rootID
     * 根节点标识
     * @type String
     * @default '-1'
     */
    rootID : '-1',
    
    /**
     * @var cfg.rootTitle
     * 根节点标题
     * @type String
     * @default '树形菜单'
     */       
    rootTitle :'MultiTree',
    
    /**
     * @var cfg.rootVisible
     * 根节点是否显示
     * @type boolean
     * @default true
     */
    rootVisible : true ,
    
    /**
     * @var cfg.applyTo
     * 宣染对象
     * @type String
     * @default ''
     */
    applyTo : '',

    /**
     * @var cfg.lookupCode
     * 根据指定lookupCode获取数据库配置生成动态sql语句为lookup提供数据
     * 与sqlID不可同时使用
     * @type String
     * @default null
     */
    lookupcode : null,

    /**
     * @var cfg.dbkey
     * 在多数据源情况下,通过dbkey指定lookupCode/sqlID查询时使用的数据库
     * @type String
     * @default ''
     */
    dbkey : '',

    /**
     * @var cfg.sqlID
     * 根据指定sqlID获取sql-map-config配置的sql语句为提供数据
     * 与lookupCode不可同时使用
     * @type String
     * @default ''
     */
    sqlID:'',

    /**
     * @var cfg.dataURL
     * 为当前提供数据的URL
     * @type String
     * @default null
     */
    dataUrl : null,

    /**
     * @var cfg.implClass
     * 获取数据的java接口实现类,一般情况下不需要复写
     * @type String
     * @default  'com.handao.platform.framework.ajax.json.tree.AFJsonTree'
     */
    implClass : 'com.handao.platform.framework.ajax.json.tree.AFJsonTree',

    /**
     * @var cfg.baseConditions
     * 数据的初始查询条件
     * @type Array like [{param:'DELETED_FLAG',value:'Y'}, {param:'CODE',value:'1001%'}]
     * @default null
     */
    baseConditions : null,

    /**
     * @var cfg.sortInfo
     * 数据的初始排序条件
     * @type Object like {field:'CODE', direction:'ASC|DESC'}
     * @default null
     */
    sortInfo : null,

    /**
     * @var cfg.treeNodeBaseAttrs
     * 设置节点基本属性
     * @type Object like {text:'{code}-{name}', href:'/contextPath/a/b/c.do?id={id}'}
     * @default null
     */
    treeNodeBaseAttrs :null,

    /**
     * @var cfg.expandLevel
     * 树形展开级别
     * @type Num
     * @default 0
     */
    expandLevel : 0,
    
    /**
     * @var cfg.expandLevel
     * 初使化值
     * @type String which split by ","
     * @default null
     */
    value : null,
    
    /**
     * @var cfg.onlyLeafNodeSelectable
     * 是否只能选择末级节点
     * 该参数只在singleSelect为true的时候才有效
     * @type boolean
     * @default false
     */
    onlyLeafNodeSelectable : false,

    /**
     * @var cfg.cascadeSelect
     * 多选树级联选择标志
     * @type boolean
     * @default true
     */	
	cascadeSelect : true,

    /**
     * @var cfg.nodeSelectable
     * 节点是否可选择逻辑
     * @type UniEXT.tree.TreeNodeSelectableLogic
     * @default null
     */    
    nodeSelectable : null,

    /**
     * @var cfg.autoScroll
     * 滚动条
     * @type boolean
     * @default true
     */
    autoScroll : true,

    /**
     * @var cfg.animate
     * 动画效果
     * @type boolean
     * @default false
     */
    animate : false,

    /**
     * @var cfg.enableDD
     * 允许拖动
     * @type boolean
     * @default false
     */
    enableDD : false,

    /**
     * @var cfg.leafNodeFlag
     * 节点是否是末级标志的判断值
     * @type String
     * @default 'true'
     */
	leafNodeFlag : 'true',

    /**
	 * @func private
	 * 初始化 NavTreePanel
	 * @overwrite Ext.tree.TreePanel
	 */
    initComponent : function(){
                UniEXT.tree.MultiTree.superclass.initComponent.call(this);
                //this.initNodeSelectLogic();
                this.initContainer();
                //add the Evment on click which defined by user
                this.on('click',this.onSelect);
                //deal with the expandlevel
                this.setExpand(this,this.root,this.expandLevel);
                //init the selected node
                this.setInitValue(this,this.root,this.value);
            },

    /**
	 * @func private
	 * 初始化 节点选择逻辑
	 * 
	 */
	initNodeSelectLogic : function() {
	//自定义选择逻辑为空则应用配置逻辑
    	if(this.nodeSelectable == null) {
    		this.nodeSelectable = this.onlyLeafNodeSelectable
    			? new UniEXT.tree.OnlyLeafNodeSelectable()
    			: new UniEXT.tree.AllNodeSelectable();
    	}else{
    	    this.nodeSelectable = new UniEXT.tree.TreeNodeSelectableLogic({
		        nodeSelectable : this.nodeSelectable
            })
    	}
    	
    	if(this.nodeSelectable == null) {
    		this.nodeSelectable = (this.onlyLeafNodeSelectable)
    			? new UniEXT.tree.OnlyLeafNodeSelectable()
    			: new UniEXT.tree.AllNodeSelectable();
    	}
    	var sm = new UniEXT.tree.CheckboxTreeSelectionModel();

    	sm.selectLogic = this.nodeSelectable;
    	sm.cascadeSelect = this.cascadeSelect;

    	return sm;    	
	},

    /**
	 * @func private
	 * 初始化 容器
	 * @overwrite Ext.tree.TreePanel
	 */
    initContainer : function() {
            //Tree RootNode
            var rootNode = new Ext.tree.AsyncTreeNode({text:this.rootTitle, draggable:false, id:this.rootID });
            rootNode.uiProvider = UniEXT.tree.AsyncTreeNode;
            this.setRootNode(rootNode);

            //Tree Loader
	        var baseAttrs = this.treeNodeBaseAttrs || {};
	    	baseAttrs.checked = false;
			baseAttrs.uiProvider = UniEXT.tree.CheckboxTreeNodeUI;
	    	
	    	var dataUrl = this.dataURL==null ? UniEXT.ctxPath+"/ajax" : this.dataURL;
	    	//var dataUrl = this.dataURL ;

            var loader = new Ext.tree.TreeLoader({
                //dataUrl:this.dataUrl,
                dataUrl : dataUrl,
                baseAttrs: baseAttrs,
                baseParams:{
                    lookupcode: this.lookupCode,
                    sqlid: this.sqlID,
                    dbkey: this.dbkey,
                    implcls: this.implClass,
                    sort: this.sortInfo ? this.sortInfo.field : '',
                    dir: this.sortInfo ? this.sortInfo.direction : '',
                    bcondition: Ext.util.JSON.encode(this.baseConditions),
                    leafflag: this.leafNodeFlag
                }
            });
            //construct the tree
            this.width = Ext.getDom(this.applyTo).clientWidth;
            this.el = this.applyTo;
            this.loader = loader;
            this.selModel = this.initNodeSelectLogic();
            this.render();
      },

    /**
     * @func private
     * 设置树初始展开层数
     * @param TreePanel obj
     * @param RootNode rootNode
     * @param Num level
     */
    setExpand: function (/*Tree*/obj,/*RootNode*/ rootNode,/*Num*/level){
        if (level== -1){ 
            //展开级别-1时 树节点全部展开
            obj.expandAll();
        }else if (level>0){
            //递归实现
            rootNode.expand(false, false, function(pNode){
                    Ext.each(pNode.childNodes, function(node){
                        var tempLevel = level;
                        if (tempLevel>1)
                        {
                            node.expand(false);
                        }
                        if (tempLevel > 2){
                            obj.setExpand(obj,node,--tempLevel);
                        }
                    });        
            });
        }
    },

    /**
     * @func private
     * 设置复选树初始选中节点 
     * @param TreePanel obj
     * @param RootNode rootNode
     * @param String value  (split with ',' )
     */
    setInitValue :function (/*Tree Object*/obj,/*RootNode*/rootNode,/*String*/value){
        //if (!(obj && rootNode && value.length==0 ))
        if ((value.length==0 ))
            return;
        //obj.expandAll();
        var valueArr = value.split(",");
	    rootNode.expand(false, false, function(pNode){
	        Ext.each(rootNode.childNodes,function(node){
	        for (var i=0 ; i< valueArr.length ; i++){
	            if (valueArr[i]==node.id){
	                rootNode.getOwnerTree().selModel.oneSelect(node,null,true);
	                valueArr.splice(i,1);
	                break;
	            }
	        }
		    if (!node.isLeaf() && valueArr.length>0){
		        obj.setInitValue(obj,node,valueArr.toString());
		    }
        });
        });
    },

    /**
     * @func private
     * 点击节点触发事件函数 (用户自定义)
     * default Ext.emptyFn
     */
    onSelect : Ext.emptyFn,
    
    /**
     * @func private
     * 获取选中节点数组
     * default Ext.emptyFn
     * return selected nodes Array
     */    
    getSelectedNodes : function (){
        return this.selModel.getSelectedNodes() ;
    },
    
    /**
     * @func private
     * 获取选中节点属性串
     * @param  atrribute  like "id" "text"
     * return selected nodesAtrribute String with ',' split
     */     
    getSelectedAtr:  function (/*TreeNodeAtr*/ atrribute){
        var selectedID = '';
        var selectedNodes = this.selModel.getSelectedNodes() ;
        var selectedNodesLength = selectedNodes.length;
        if (selectedNodesLength>0){
            var selectedID = eval("selectedNodes[0]" + "."+atrribute);
            if (selectedID == undefined)
                return '';
            //selectedID = selectedNodes[0].id ;
            for (var i=1;i<selectedNodesLength;i++)
                selectedID += ","+eval("selectedNodes["+i+"]."+atrribute);
        }
        return selectedID;
    }

 });
