if(Ext.LoadMask) {
	Ext.LoadMask.prototype.msg = "���Ժ�...";
}

if(UniEXT.lookup.DataWindow) {
	UniEXT.apply(UniEXT.lookup.DataWindow.prototype, {
		filterDisplay  : "�ڴ������������й���",
		confirmBtnText : "ȷ��",
	    cancelBtnText  : "�ر�"
    });
}

