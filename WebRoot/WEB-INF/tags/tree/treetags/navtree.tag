<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ tag pageEncoding="gbk" %> 

<%@ attribute name="id" required="true" %>
<%@ attribute name="apply2" required="true" %>
<%@ attribute name="sqlid" required="true" %>
<%@ attribute name="expandlevel" %>
<%@ attribute name="onselect" %>
<%@ attribute name="leafflag" %>
<%@ attribute name="onlyleafselectable" %>

<script>
var ${id} = null;

Ext.onReady(function(){

var baseConditions = [];
var treeNodeBaseAttrs = null;
var sortInfo = null;

<jsp:doBody/>

${id} = new UniEXT.tree.NavTree ({
    applyTo:'${apply2}',
    sqlID:'${sqlid}',
    expandLevel:${expandlevel},
    leafNodeFlag : '${leafflag}',
    onSelect : ${onselect},
    onlyLeafNodeSelectable : ${onlyleafselectable},
    treeNodeBaseAttrs : treeNodeBaseAttrs,
    sortInfo : sortInfo,
    autoScroll : true,
    baseConditions:baseConditions
});

if(typeof ${id}_init != 'undefined') {
	${id}_init();
}

});

</script>