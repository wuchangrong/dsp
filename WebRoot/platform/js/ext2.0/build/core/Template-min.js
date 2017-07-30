/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.Template=function(E){var B=arguments;if(E instanceof Array){E=E.join("")}else{if(B.length>1){var C=[];for(var D=0,A=B.length;D<A;D++){if(typeof B[D]=="object"){Ext.apply(this,B[D])}else{C[C.length]=B[D]}}E=C.join("")}}this.html=E;if(this.compiled){this.compile()}};Ext.Template.prototype={applyTemplate:function(B){if(this.compiled){return this.compiled(B)}var A=this.disableFormats!==true;var E=Ext.util.Format,C=this;var D=function(G,I,L,H){if(L&&A){if(L.substr(0,5)=="this."){return C.call(L.substr(5),B[I],B)}else{if(H){var K=/^\s*['"](.*)["']\s*$/;H=H.split(",");for(var J=0,F=H.length;J<F;J++){H[J]=H[J].replace(K,"$1")}H=[B[I]].concat(H)}else{H=[B[I]]}return E[L].apply(E,H)}}else{return B[I]!==undefined?B[I]:""}};return this.html.replace(this.re,D)},set:function(A,B){this.html=A;this.compiled=null;if(B){this.compile()}return this},disableFormats:false,re:/\{([\w-]+)(?:\:([\w\.]*)(?:\((.*?)?\))?)?\}/g,compile:function(){var fm=Ext.util.Format;var useF=this.disableFormats!==true;var sep=Ext.isGecko?"+":",";var fn=function(m,name,format,args){if(format&&useF){args=args?","+args:"";if(format.substr(0,5)!="this."){format="fm."+format+"("}else{format="this.call(\""+format.substr(5)+"\", ";args=", values"}}else{args="";format="(values['"+name+"'] == undefined ? '' : "}return"'"+sep+format+"values['"+name+"']"+args+")"+sep+"'"};var body;if(Ext.isGecko){body="this.compiled = function(values){ return '"+this.html.replace(/\\/g,"\\\\").replace(/(\r\n|\n)/g,"\\n").replace(/'/g,"\\'").replace(this.re,fn)+"';};"}else{body=["this.compiled = function(values){ return ['"];body.push(this.html.replace(/\\/g,"\\\\").replace(/(\r\n|\n)/g,"\\n").replace(/'/g,"\\'").replace(this.re,fn));body.push("'].join('');};");body=body.join("")}eval(body);return this},call:function(C,B,A){return this[C](B,A)},insertFirst:function(B,A,C){return this.doInsert("afterBegin",B,A,C)},insertBefore:function(B,A,C){return this.doInsert("beforeBegin",B,A,C)},insertAfter:function(B,A,C){return this.doInsert("afterEnd",B,A,C)},append:function(B,A,C){return this.doInsert("beforeEnd",B,A,C)},doInsert:function(C,E,B,A){E=Ext.getDom(E);var D=Ext.DomHelper.insertHtml(C,E,this.applyTemplate(B));return A?Ext.get(D,true):D},overwrite:function(B,A,C){B=Ext.getDom(B);B.innerHTML=this.applyTemplate(A);return C?Ext.get(B.firstChild,true):B.firstChild}};Ext.Template.prototype.apply=Ext.Template.prototype.applyTemplate;Ext.DomHelper.Template=Ext.Template;Ext.Template.from=function(B,A){B=Ext.getDom(B);return new Ext.Template(B.value||B.innerHTML,A||"")};