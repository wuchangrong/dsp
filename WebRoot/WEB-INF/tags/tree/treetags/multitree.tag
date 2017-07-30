<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ tag pageEncoding="gbk" %> 

<%@ attribute name="id" required="true" %>
<%@ attribute name="apply2" required="true" %>
<%@ attribute name="sqlid" required="true" %>
<%@ attribute name="expandlevel" %>
<%@ attribute name="onselect" %>
<%@ attribute name="leafflag" %>
<%@ attribute name="value" %>
<%@ attribute name="rootvisible"  %>
<%@ attribute name="leafselectonly" %>
<%@ attribute name="cascadeselect" %>
<%@ attribute name="nodeselectable" %>

<script>
var ${id} = null;

Ext.onReady(function(){

//×ÓTAGÊµÏÖ
var baseConditions = [];
var treeNodeBaseAttrs = null;
var sortInfo = null;


var rootvisible    =  ${(empty rootvisible)    ? 'false': rootvisible}   ;
var leafselectonly =  ${(empty leafselectonly) ? 'false': leafselectonly};
var cascadeselect  =  ${(empty cascadeselect)  ? 'true' : cascadeselect} ;
var nodeselectable =  ${(empty nodeselectable) ? 'null' : nodeselectable};

<jsp:doBody/>

${id} = new UniEXT.tree.MultiTree ({
    applyTo:'${apply2}',
    sqlID:'${sqlid}',
    expandLevel:'${expandLevel}',
    leafNodeFlag : '${leafflag}',
    onSelect : '${onselect}',
    treeNodeBaseAttrs : treeNodeBaseAttrs,
    sortInfo : sortInfo,
    baseConditions : baseConditions,
    value : '${value}',
    rootVisible : rootvisible,
    onlyLeafNodeSelectable : leafselectonly,
    cascadeSelect : cascadeselect,
    nodeSelectable : nodeselectable
});

if(typeof ${id}_init != 'undefined') {
	${id}_init();
}

});

</script>