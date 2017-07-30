/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.tree.TreeEditor=function(A,B){B=B||{};var C=B.events?B:new Ext.form.TextField(B);Ext.tree.TreeEditor.superclass.constructor.call(this,C);this.tree=A;if(!A.rendered){A.on("render",this.initEditor,this)}else{this.initEditor(A)}};Ext.extend(Ext.tree.TreeEditor,Ext.Editor,{alignment:"l-l",autoSize:false,hideEl:false,cls:"x-small-editor x-tree-editor",shim:false,shadow:"frame",maxWidth:250,editDelay:350,initEditor:function(A){A.on("beforeclick",this.beforeNodeClick,this);A.getTreeEl().on("mousedown",this.hide,this);this.on("complete",this.updateNode,this);this.on("beforestartedit",this.fitToTree,this);this.on("startedit",this.bindScroll,this,{delay:10});this.on("specialkey",this.onSpecialKey,this)},fitToTree:function(B,C){var E=this.tree.getTreeEl().dom,D=C.dom;if(E.scrollLeft>D.offsetLeft){E.scrollLeft=D.offsetLeft}var A=Math.min(this.maxWidth,(E.clientWidth>20?E.clientWidth:E.offsetWidth)-Math.max(0,D.offsetLeft-E.scrollLeft)-5);this.setSize(A,"")},triggerEdit:function(A){this.completeEdit();this.editNode=A;this.startEdit(A.ui.textNode,A.text)},bindScroll:function(){this.tree.getTreeEl().on("scroll",this.cancelEdit,this)},beforeNodeClick:function(B,C){var A=(this.lastClick?this.lastClick.getElapsed():0);this.lastClick=new Date();if(A>this.editDelay&&this.tree.getSelectionModel().isSelected(B)){C.stopEvent();this.triggerEdit(B);return false}},updateNode:function(A,B){this.tree.getTreeEl().un("scroll",this.cancelEdit,this);this.editNode.setText(B)},onHide:function(){Ext.tree.TreeEditor.superclass.onHide.call(this);if(this.editNode){this.editNode.ui.focus()}},onSpecialKey:function(C,B){var A=B.getKey();if(A==B.ESC){B.stopEvent();this.cancelEdit()}else{if(A==B.ENTER&&!B.hasModifier()){B.stopEvent();this.completeEdit()}}}});