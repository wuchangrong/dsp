
Ext.BLANK_IMAGE_URL = Ext.ctxPath + '/platform/js/uniext/resources/images/s.gif';

UniEXT = {}

for(var a in Ext) {
	UniEXT[a] = Ext[a];
}



UniEXT.namespace('UniEXT.tree','UniEXT.lookup','UniEXT.util');

UniEXT.QuickTips.init();