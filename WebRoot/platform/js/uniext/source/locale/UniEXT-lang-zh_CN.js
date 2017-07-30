if(Ext.LoadMask) {
	Ext.LoadMask.prototype.msg = "请稍候...";
}

if(UniEXT.lookup.DataWindow) {
	UniEXT.apply(UniEXT.lookup.DataWindow.prototype, {
		filterDisplay  : "在此输入条件进行过滤",
		confirmBtnText : "确认",
	    cancelBtnText  : "关闭"
    });
}

