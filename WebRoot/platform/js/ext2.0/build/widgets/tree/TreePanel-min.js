/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.tree.TreePanel=Ext.extend(Ext.Panel,{rootVisible:true,animate:Ext.enableFx,lines:true,enableDD:false,hlDrop:Ext.enableFx,pathSeparator:"/",initComponent:function(){Ext.tree.TreePanel.superclass.initComponent.call(this);if(!this.eventModel){this.eventModel=new Ext.tree.TreeEventModel(this)}this.nodeHash={};if(this.root){this.setRootNode(this.root)}this.addEvents({"append":true,"remove":true,"move":true,"insert":true,"beforeappend":true,"beforeremove":true,"beforemove":true,"beforeinsert":true,"beforeload":true,"load":true,"textchange":true,"beforeexpandnode":true,"beforecollapsenode":true,"expandnode":true,"disabledchange":true,"collapsenode":true,"beforeclick":true,"click":true,"checkchange":true,"dblclick":true,"contextmenu":true,"beforechildrenrendered":true,"startdrag":true,"enddrag":true,"dragdrop":true,"beforenodedrop":true,"nodedrop":true,"nodedragover":true});if(this.singleExpand){this.on("beforeexpandnode",this.restrictExpand,this)}},proxyNodeEvent:function(C,B,A,G,F,E,D){if(C=="collapse"||C=="expand"||C=="beforecollapse"||C=="beforeexpand"){C=C+"node"}return this.fireEvent(C,B,A,G,F,E,D)},getRootNode:function(){return this.root},setRootNode:function(A){this.root=A;A.ownerTree=this;A.isRoot=true;this.registerNode(A);if(!this.rootVisible){A.ui=new Ext.tree.RootTreeNodeUI(A)}return A},getNodeById:function(A){return this.nodeHash[A]},registerNode:function(A){this.nodeHash[A.id]=A},unregisterNode:function(A){delete this.nodeHash[A.id]},toString:function(){return"[Tree"+(this.id?" "+this.id:"")+"]"},restrictExpand:function(A){var B=A.parentNode;if(B){if(B.expandedChild&&B.expandedChild.parentNode==B){B.expandedChild.collapse()}B.expandedChild=A}},getChecked:function(A,B){B=B||this.root;var C=[];var D=function(){if(this.attributes.checked){C.push(!A?this:(A=="id"?this.id:this.attributes[A]))}};B.cascade(D);return C},getEl:function(){return this.el},getLoader:function(){return this.loader},expandAll:function(){this.root.expand(true)},collapseAll:function(){this.root.collapse(true)},getSelectionModel:function(){if(!this.selModel){this.selModel=new Ext.tree.DefaultSelectionModel()}return this.selModel},expandPath:function(F,A,G){A=A||"id";var D=F.split(this.pathSeparator);var C=this.root;if(C.attributes[A]!=D[1]){if(G){G(false,null)}return }var B=1;var E=function(){if(++B==D.length){if(G){G(true,C)}return }var H=C.findChild(A,D[B]);if(!H){if(G){G(false,C)}return }C=H;H.expand(false,false,E)};C.expand(false,false,E)},selectPath:function(E,A,F){A=A||"id";var C=E.split(this.pathSeparator);var B=C.pop();if(C.length>0){var D=function(H,G){if(H&&G){var I=G.findChild(A,B);if(I){I.select();if(F){F(true,I)}}else{if(F){F(false,I)}}}else{if(F){F(false,I)}}};this.expandPath(C.join(this.pathSeparator),A,D)}else{this.root.select();if(F){F(true,this.root)}}},getTreeEl:function(){return this.body},onRender:function(B,A){Ext.tree.TreePanel.superclass.onRender.call(this,B,A);this.el.addClass("x-tree");this.innerCt=this.body.createChild({tag:"ul",cls:"x-tree-root-ct "+(this.lines?"x-tree-lines":"x-tree-no-lines")})},initEvents:function(){Ext.tree.TreePanel.superclass.initEvents.call(this);if(this.containerScroll){Ext.dd.ScrollManager.register(this.body)}if((this.enableDD||this.enableDrop)&&!this.dropZone){this.dropZone=new Ext.tree.TreeDropZone(this,this.dropConfig||{ddGroup:this.ddGroup||"TreeDD",appendOnly:this.ddAppendOnly===true})}if((this.enableDD||this.enableDrag)&&!this.dragZone){this.dragZone=new Ext.tree.TreeDragZone(this,this.dragConfig||{ddGroup:this.ddGroup||"TreeDD",scroll:this.ddScroll})}this.getSelectionModel().init(this)},afterRender:function(){Ext.tree.TreePanel.superclass.afterRender.call(this);this.root.render();if(!this.rootVisible){this.root.renderChildren()}},onDestroy:function(){if(this.rendered){this.body.removeAllListeners();Ext.dd.ScrollManager.unregister(this.body);if(this.dropZone){this.dropZone.unreg()}if(this.dragZone){this.dragZone.unreg()}}this.root.destroy();this.nodeHash=null;Ext.tree.TreePanel.superclass.onDestroy.call(this)}});Ext.reg("treepanel",Ext.tree.TreePanel);