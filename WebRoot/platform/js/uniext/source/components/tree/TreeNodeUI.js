/**
 * @class UniEXT.lookup.TreeNodeUI
 * @extends Ext.tree.TreeNodeUI
 * 
 */
UniEXT.tree.TreeNodeUI = Ext.extend(Ext.tree.TreeNodeUI, {


	
	needFormatAttrs : ['text','href'],
	
	/**
	 * @func private
	 * 对node的text/href进行修改
	 * @overwrite Ext.tree.TreeNodeUI.render
	 */
    render : function(bulkRender){
    	this.formatNodeAttr(this.node);
        UniEXT.tree.TreeNodeUI.superclass.render.call(this, bulkRender);
    },
    
    formatNodeAttr : function(node) {
    	var regExp = /{.*?}/;
    	for(var i=0; i<this.needFormatAttrs.length; i++) {
    		var attrValue = eval('node.attributes.'+this.needFormatAttrs[i]);
    		if(attrValue && regExp.test(attrValue)) {
    			attrValue = new Ext.Template(attrValue);
    		}
    		if(attrValue && attrValue.applyTemplate) { //如果是模版
    			attrValue = attrValue.applyTemplate(node.attributes);
				eval('node.attributes.'+this.needFormatAttrs[i]+'=attrValue');
				eval('node.'+this.needFormatAttrs[i]+'=attrValue');
    		}
    	}
    	//alert(node.isLeaf() + "," + node.attributes.leaf);
        /*
    	for(var i=0; i<this.needFormatAttrs.length; i++) {
    		var attrValue = eval('node.attributes.'+this.needFormatAttrs[i]);
			if(attrValue) {
				while(this.regExp.test(attrValue)) {
					attrValue = attrValue.replace(this.regExp, function(a, b, c) {
						return eval('node.attributes.' + a.substring(1, a.length-1));
					});
				}
				eval('node.attributes.'+this.needFormatAttrs[i]+'=attrValue');
				eval('node.'+this.needFormatAttrs[i]+'=attrValue');
			}
    	}*/
    },
    
    focusTreeEL : function() {
    	this.node.getOwnerTree().getTreeEl().focus();
    }
});