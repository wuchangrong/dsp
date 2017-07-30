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
 * @class UniEXT.tree.NavTreeUI 
 * @extends UniEXT.tree.TreeNodeUI
 * 
 */
UniEXT.tree.NavTreeUI = Ext.extend(UniEXT.tree.TreeNodeUI, {
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
        }else{
            e.stopEvent();
        }
    },
    
	/**
	 * @func private
	 * 修改原UI的实现逻辑  
     * 暂屏蔽双击事件
	 * @overwrite Ext.tree.TreeNodeUI.onDblClick
	 */    
    onDblClick : function(e){
        e.stopEvent();
    }
});


/**
 * @class UniEXT.tree.NavTree  导航树
 * @extends Ext.tree.TreePanel
 * 
 */
 
UniEXT.tree.NavTree = Ext.extend(Ext.tree.TreePanel, {

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
    rootTitle :'Nav Tree',
    
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
     * @defaultimplClass : 'com.handao.platform.framework.ajax.json.tree.AFJsonTree',
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
     * @var cfg.onlyLeafNodeSelectable
     * 是否只能选择末级节点
     * 该参数只在singleSelect为true的时候才有效
     * @type boolean
     * @default false
     */
    onlyLeafNodeSelectable : false,

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
                UniEXT.tree.NavTree.superclass.initComponent.call(this);
                this.initNodeSelectLogic();
                this.initContainer();
                //add the Evment on click which defined by user
                this.on('click',this.onSelect);
                //deal with the expandlevel
                this.setExpand(this,this.root,this.expandLevel);
              
            },
    /**
	 * @func private
	 * 初始化 节点选择逻辑
	 * 
	 */
	initNodeSelectLogic : function() {
		
    	if(this.nodeSelectable == null) {
    		this.nodeSelectable = (this.onlyLeafNodeSelectable)
    			? new UniEXT.tree.OnlyLeafNodeSelectable()
    			: new UniEXT.tree.AllNodeSelectable();
    	}
    	if(this.nodeSelectable.nodeSelectable!=null && (typeof this.nodeSelectable.nodeSelectable=="function")) {
    		this.on('beforeclick', this.nodeSelectable.nodeSelectable);
    	}
	    
	},
	
	
	tbar:[],
	
	/**
	 * @var private
	 * onFilter专用变量,用于储存被过滤的不显示的节点
	 * @type {Array}
	 * @default []
	 */
	hiddenNodes : [],
	
    
    /**
     * 返回一个匹配数据用的正则表达式
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
    
    isRefreshSpaceEachTime:false,
    
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
		
		var treeObj = this;
		
		var doHidden = function(n) {
			n.ui.hide();
			this.hiddenNodes.push(n);
		};
		
		
		var test = function(node) {
			var fields = treeObj.filterParam.fields;
            for(var i=0; i<fields.length; i++) {
            	var regExp = treeObj.getValueMatcher(value, fields[i].matchType);
                if(regExp.test(node.attributes[fields[i].name])) {
                    return true;
                }
            }
            return false;
		}
		
		var filterLogic = function(n) {
			if(n.isLeaf()) {
				if(!test(n)) {
					doHidden.call(treeObj, n);
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
					doHidden.call(treeObj, n.parentNode);
				}
				filterLogic(n.parentNode);
			}
		};

		this.root.cascade(function(n) {
			if(!n.isLeaf() && n.childNodes.length==0) {
				n.expand();
			} else {
				filterLogic(n);
			}
			return true;
		});
	},

    /**
	 * @func private
	 * 初始化 容器
	 * @overwrite Ext.tree.TreePanel
	 */
    initContainer : function() {
            //Tree RootNode
            var rootNode = new Ext.tree.AsyncTreeNode({text:this.rootTitle, draggable:false, id:this.rootID});
            this.setRootNode(rootNode);

            //Tree Loader
	        var baseAttrs = this.treeNodeBaseAttrs || {};
	    	baseAttrs.uiProvider = UniEXT.tree.NavTreeUI ;
	    	
	    	var dataUrl = this.dataURL==null ? UniEXT.ctxPath+"/ajax" : this.dataURL;

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
            
            this.filterDelayTask = this.onFilter;
            
            
            this.filterField = new Ext.form.TextField({
		        width : 173,
		        emptyText : '',
				//custom 记录最后一次过滤条件
		        lastValue : '',
		        //custom 过滤用DelayedTask
		        filterTask :  new Ext.util.DelayedTask(this.filterDelayTask, this),
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
            
            //construct the tree
            this.width = Ext.getDom(this.applyTo).clientWidth;
            //this.tbar.push(this.filterField);
            this.el = this.applyTo;
            this.loader = loader;
            
            this.render();

      },

    /**
     * @func private
     * 设置树初始展开层数
     * @param TreePanel obj
     * @param RootNode rootNode
     * @param Num level
     * default Ext.emptyFn
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
     * @flag tag
     * 自定义标志 不作为树属性对外使用 用于“是否继续执行”标志
     * default true
     */    
    goOnFlag : true ,
    
    /**
     * @func private
     * 设置树默认选中节点 仅内部使用
     * @param TreePanel  obj
     * @param TreeNode   treeNode
     * @param String     value
     * @param boolean    firstDo
     * @return void
     */    
    setSelectedIner : function (/*TreePanel*/obj,/*TreeNode*/treeNode,/*Node.id*/value,/*boolean*/firstDo){
        if (!firstDo  &&  firstDo!==false)
            obj.goOnFlag = true;
        if (!(obj && treeNode && value.length>0 ))
            return false;
        treeNode.expand(false, false, function(pNode){
            if (obj.getNodeById(value)){
                obj.getNodeById(value).select();
                //alert(obj.getNodeById(value).text);
                obj.goOnFlag = false ;
                return ;
            }else{
                Ext.each(pNode.childNodes, function(node){
                    if (obj.goOnFlag){
                        obj.setSelectedIner(obj,node,value,false);
                    }
                });
            }
        });
    },
    
    /**
     * @func private
     * 设置树默认选中节点 供外部使用
     * @param TreePanel  obj
     * @param String     value
     * @return void
     */   
    setSelected : function (/*TreePanel*/obj,/*Node.id*/value){
        obj.setSelectedIner(obj,obj.getRootNode(),value);
    },
             
    /**
     * @func private
     * 点击节点触发事件函数 (用户自定义)
     * default Ext.emptyFn
     */
    onSelect : Ext.emptyFn

 });
