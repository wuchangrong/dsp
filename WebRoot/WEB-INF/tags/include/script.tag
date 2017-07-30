<%String ctx = ((javax.servlet.http.HttpServletRequest)request).getContextPath(); %>
<%-- import extjs2.0 --%>
<script type="text/javascript" src="<%=ctx%>/platform/js/ext2.0/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/ext2.0/ext-all-debug.js"></script>

<script>
Ext.ctxPath = '<%=ctx%>';
</script>

<%-- import UniEXT --%>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/UniEXT.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/tree/Tree.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/tree/TreeNodeUI.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/tree/NavTree.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/tree/MultiTree.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/lookup/Lookup.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/lookup/GridLookup.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/lookup/TreeLookup.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/lookup/FastLookup.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/components/lookup/LookupManager.js"></script>

<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/util/Base64.js"></script>

<%-- import zh_CN --%>
<script type="text/javascript" src="<%=ctx%>/platform/js/ext2.0/build/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=ctx%>/platform/js/uniext/source/locale/UniEXT-lang-zh_CN.js"></script>
