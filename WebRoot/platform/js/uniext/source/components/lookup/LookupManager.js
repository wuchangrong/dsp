/**
 * @class static UniEXT.lookup.LookupManager
 * lookup������,���ڹ���lookup��ض���
 */
UniEXT.lookup.LookupManager = function() {
	/**
	 * @var private
	 * ����DataWindow��Map
	 * @type Object
	 * @default {}
	 */
	var winMap = {};
	
	return {
	
		/**
		 * @func public static
		 * ����ָ��id��ȡDataWindow����
		 * @param {String} cacheID
		 * @return {UniEXT.lookup.DataWindow}
		 */
		getDataWindow : function(cacheID) {
			return winMap[cacheID];
		},
		
		/**
		 * @func public static
		 * ����DataWindow����
		 * @param {String} cacheID
		 * @param {UniEXT.lookup.DataWindow} winObj
		 */
		cacheDataWindow : function(cacheID, winObj) {
			winMap[cacheID] = winObj;
		},
		
		/**
		 * @func public static
		 * ����ָ��id���DataWindow����
		 * @param {String} cacheID
		 */
		clean : function(cacheID) {
			if(winMap[cacheID]) {
				winMap[cacheID].destroy();
				winMap[cacheID] = null;
				delete winMap[cacheID];
			}
		},
		
		/**
		 * @func public static
		 * �������DataWindow����
		 */
		cleanAll : function() {
			for(var a in winMap) {
				this.clean(a);
			}
			winMap = {};
		},
		
		/**
		 * @func public static
		 * ����winconfig����GridWindow
		 * @param winCfg ����window�Ĳ���,������ָ�����������Ѿ�encode��jsonstring��decode(���ڴ����ҳ�洫��Array�ᵼ�����ʹ��������)
		 * @param arrayAttrParams ��Ҫ��jsonstring decode�Ĳ�����
		 * @return UniEXT.lookup.GridWindow
		 */		
		genGridWindow : function(winCfg, arrayAttrParams) {
			return new UniEXT.lookup.GridWindow(this.decodeArrayAttr(winCfg, arrayAttrParams));
		},
		
		/**
		 * @func public static
		 * ����winconfig����GridWindow,������ָ�����������Ѿ�encode��jsonstring��decode(���ڴ����ҳ�洫��Array�ᵼ�����ʹ��������)
		 * @param winCfg ����window�Ĳ���
		 * @param arrayAttrParams ��Ҫ��jsonstring decode�Ĳ�����
		 * @return UniEXT.lookup.TreeWindow
		 */		
		genTreeWindow : function(winCfg, arrayAttrParams) {
			return new UniEXT.lookup.TreeWindow(this.decodeArrayAttr(winCfg, arrayAttrParams));
		},

		/**
		 * @func private
		 * ��winconfig��ָ����������decode
		 * @param winCfg ����window�Ĳ���
		 * @param arrayAttrParams ��Ҫ��jsonstring decode�Ĳ�����
		 * @return {Object} winCfg
		 */
		decodeArrayAttr : function(winCfg, arrayAttrParams) {
    		for(var i=0; i<arrayAttrParams.length; i++) {
    			var v = UniEXT.decode(winCfg[arrayAttrParams[i]]);
    			winCfg[arrayAttrParams[i]] = v;
    		}
    		return winCfg;	
		}
	};
	
}();
