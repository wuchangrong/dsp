/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.form.BasicForm=function(B,A){Ext.apply(this,A);this.items=new Ext.util.MixedCollection(false,function(C){return C.id||(C.id=Ext.id())});this.addEvents({beforeaction:true,actionfailed:true,actioncomplete:true});if(B){this.initEl(B)}Ext.form.BasicForm.superclass.constructor.call(this)};Ext.extend(Ext.form.BasicForm,Ext.util.Observable,{timeout:30,activeAction:null,trackResetOnLoad:false,initEl:function(A){this.el=Ext.get(A);this.id=this.el.id||Ext.id();this.el.on("submit",this.onSubmit,this);this.el.addClass("x-form")},getEl:function(){return this.el},onSubmit:function(A){A.stopEvent()},isValid:function(){var A=true;this.items.each(function(B){if(!B.validate()){A=false}});return A},isDirty:function(){var A=false;this.items.each(function(B){if(B.isDirty()){A=true;return false}});return A},doAction:function(B,A){if(typeof B=="string"){B=new Ext.form.Action.ACTION_TYPES[B](this,A)}if(this.fireEvent("beforeaction",this,B)!==false){this.beforeAction(B);B.run.defer(100,B)}return this},submit:function(A){this.doAction("submit",A);return this},load:function(A){this.doAction("load",A);return this},updateRecord:function(B){B.beginEdit();var A=B.fields;A.each(function(C){var D=this.findField(C.name);if(D){B.set(C.name,D.getValue())}},this);B.endEdit();return this},loadRecord:function(A){this.setValues(A.data);return this},beforeAction:function(A){var B=A.options;if(B.waitMsg){if(this.waitMsgTarget===true){this.el.mask(B.waitMsg,"x-mask-loading")}else{if(this.waitMsgTarget){this.waitMsgTarget=Ext.get(this.waitMsgTarget);this.waitMsgTarget.mask(B.waitMsg,"x-mask-loading")}else{Ext.MessageBox.wait(B.waitMsg,B.waitTitle||this.waitTitle||"Please Wait...")}}}},afterAction:function(A,C){this.activeAction=null;var B=A.options;if(B.waitMsg){if(this.waitMsgTarget===true){this.el.unmask()}else{if(this.waitMsgTarget){this.waitMsgTarget.unmask()}else{Ext.MessageBox.updateProgress(1);Ext.MessageBox.hide()}}}if(C){if(B.reset){this.reset()}Ext.callback(B.success,B.scope,[this,A]);this.fireEvent("actioncomplete",this,A)}else{Ext.callback(B.failure,B.scope,[this,A]);this.fireEvent("actionfailed",this,A)}},findField:function(B){var A=this.items.get(B);if(!A){this.items.each(function(C){if(C.isFormField&&(C.dataIndex==B||C.id==B||C.getName()==B)){A=C;return false}})}return A||null},markInvalid:function(G){if(G instanceof Array){for(var C=0,A=G.length;C<A;C++){var B=G[C];var D=this.findField(B.id);if(D){D.markInvalid(B.msg)}}}else{var E,F;for(F in G){if(typeof G[F]!="function"&&(E=this.findField(F))){E.markInvalid(G[F])}}}return this},setValues:function(C){if(C instanceof Array){for(var D=0,A=C.length;D<A;D++){var B=C[D];var E=this.findField(B.id);if(E){E.setValue(B.value);if(this.trackResetOnLoad){E.originalValue=E.getValue()}}}}else{var F,G;for(G in C){if(typeof C[G]!="function"&&(F=this.findField(G))){F.setValue(C[G]);if(this.trackResetOnLoad){F.originalValue=F.getValue()}}}}return this},getValues:function(B){var A=Ext.lib.Ajax.serializeForm(this.el.dom);if(B===true){return A}return Ext.urlDecode(A)},clearInvalid:function(){this.items.each(function(A){A.clearInvalid()});return this},reset:function(){this.items.each(function(A){A.reset()});return this},add:function(){this.items.addAll(Array.prototype.slice.call(arguments,0));return this},remove:function(A){this.items.remove(A);return this},render:function(){this.items.each(function(A){if(A.isFormField&&!A.rendered&&document.getElementById(A.id)){A.applyToMarkup(A.id)}});return this},applyToFields:function(A){this.items.each(function(B){Ext.apply(B,A)});return this},applyIfToFields:function(A){this.items.each(function(B){Ext.applyIf(B,A)});return this}});Ext.BasicForm=Ext.form.BasicForm;