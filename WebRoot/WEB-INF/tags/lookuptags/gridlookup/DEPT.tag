<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ tag pageEncoding="gbk" %>

<%@ attribute name="id" required="true"%>
<%@ attribute name="row_id_pro" required="true" %>
<%@ attribute name="name_pro" required="true" %>
<%@ attribute name="beforepopup"%>
<%@ attribute name="valueChange"%>
<%@ attribute name="width" %>


<%
	String bundleKey = "af";
%>

<script>
var ${id} = null;

Ext.onReady(function(){

var baseConditions = [];
var dataELMapping = [{data:'ROW_ID',el:'${row_id_pro}'},{data:'NAME',el:'${name_pro}'}];
<jsp:doBody/>

${id} = new UniEXT.lookup.GridLookupField({
    hiddenID:'${row_id_pro}',
    applyTo:'${name_pro}',
    sqlID:'common.lookup.gridlookup.dept',
    winTitle:'<bean:message key="common.lookup.dept.title" bundle="<%=bundleKey%>" />',
    pageSize:${pagesize==null?15:pagesize},
    singleSelect:${singleselect==null?'true':singleselect},
    columnModel:[
        {header:'ROW_ID',dataIndex:'ROW_ID',hidden:true},
        {header:'<bean:message key="common.lookup.dept.code" bundle="<%=bundleKey%>" />',dataIndex:'CODE',width:60,sortable:true},
        {header:'<bean:message key="common.lookup.dept.name" bundle="<%=bundleKey%>" />',dataIndex:'NAME',width:60,sortable:true}
    ],
    storeCfg:{
        meta:{root:'data',totalProperty:'totalCount',id:'ROW_ID'},
        recordType:[{name:'ROW_ID'},{name:'CODE'},{name:'NAME'}]
    },
    filterParam:{display:'<bean:message key="common.lookup.filter" bundle="<%=bundleKey%>" />',fields:[{name:'CODE',matchType:'*%'},{name:'NAME',matchType:'%*%'}]},
    sortInfo:{field:'CODE',direction:'ASC'},
    baseConditions:baseConditions,
    dataELMapping:dataELMapping,
    width:${(empty width)?143:width},
    winHeight:350,
    winWidth:320
});
//ÊÂ¼þ
${id}.on('beforepopup', function() {
    if('${beforepopup}' != ''){
      var result = eval('${beforepopup}');
      if(result){
        ${id}.setBaseConditions(result);
        return true;
      }else
        return false;
    }
    else
      return true;
});
${id}.on('afterclean', function() {
    if('${valueChange}' != ''){
       eval('${valueChange}');
    }
});
${id}.on('afterclose', function() {
    if('${valueChange}' != ''){
       eval('${valueChange}');
    }
});
});
</script>