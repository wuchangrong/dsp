/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.form.Radio=Ext.extend(Ext.form.Checkbox,{inputType:"radio",getGroupValue:function(){return this.el.up("form").child("input[name="+this.el.dom.name+"]:checked",true).value}});Ext.reg("radio",Ext.form.Radio);