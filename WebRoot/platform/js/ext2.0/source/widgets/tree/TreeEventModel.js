/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.tree.TreeEventModel = function(tree){
    this.tree = tree;
    this.tree.on('render', this.initEvents, this);
}

Ext.tree.TreeEventModel.prototype = {
    initEvents : function(){
        var el = this.tree.getTreeEl();
        el.on('click', this.delegateClick, this);
        el.on('dblclick', this.delegateDblClick, this);
        el.on('contextmenu', this.delegateContextMenu, this);
    },

    getNode : function(e){
        var t;
        if(t = e.getTarget('.x-tree-node-el', 10)){
            var id = Ext.fly(t, '_treeEvents').getAttributeNS('ext', 'tree-node-id');
            if(id){
                return this.tree.getNodeById(id);
            }
        }
        return null;
    },

    getNodeTarget : function(e){
        var t = e.getTarget('.x-tree-node-icon', 1);
        if(!t){
            t = e.getTarget('a.x-tree-node-anchor', 4);
        }
        return t;
    },

    delegateClick : function(e, t){
        if(!this.beforeEvent(e)){
            return;
        }

        if(e.getTarget('input[type=checkbox]', 1)){
            this.onCheckboxClick(e, this.getNode(e));
        }
        else if(e.getTarget('.x-tree-ec-icon', 1)){
            this.onIconClick(e, this.getNode(e));
        }
        else if(this.getNodeTarget(e)){
            this.onNodeClick(e, this.getNode(e));
        }
    },

    delegateDblClick : function(e, t){
        if(this.beforeEvent(e) && this.getNodeTarget(e)){
            this.onNodeDblClick(e, this.getNode(e));
        }
    },

    delegateContextMenu : function(e, t){
        if(this.beforeEvent(e) && this.getNodeTarget(e)){
            this.onNodeContextMenu(e, this.getNode(e));
        }
    },

    onNodeClick : function(e, node){
        node.ui.onClick(e);
    },

    onIconClick : function(e, node){
        node.ui.ecClick(e);
    },

    onCheckboxClick : function(e, node){
        node.ui.onCheckChange(e);
    },

    onNodeDblClick : function(e, node){
        node.ui.onDblClick(e);
    },

    onNodeContextMenu : function(e, node){
        node.ui.onContextMenu(e);
    },

    beforeEvent : function(e){
        if(this.disabled){
            e.stopEvent();
            return false;
        }
        return true;
    },

    disable: function(){
        this.disabled = true;
    },

    enable: function(){
        this.disabled = false;
    }
};