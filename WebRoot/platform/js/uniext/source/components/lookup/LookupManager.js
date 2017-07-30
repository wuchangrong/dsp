/**
 * @class static UniEXT.lookup.LookupManager
 * lookup管理类,用于管理lookup相关对象
 */
UniEXT.lookup.LookupManager = function() {
	/**
	 * @var private
	 * 储存DataWindow用Map
	 * @type Object
	 * @default {}
	 */
	var winMap = {};
	
	return {
	
		/**
		 * @func public static
		 * 根据指定id获取DataWindow缓存
		 * @param {String} cacheID
		 * @return {UniEXT.lookup.DataWindow}
		 */
		getDataWindow : function(cacheID) {
			return winMap[cacheID];
		},
		
		/**
		 * @func public static
		 * 缓存DataWindow对象
		 * @param {String} cacheID
		 * @param {UniEXT.lookup.DataWindow} winObj
		 */
		cacheDataWindow : function(cacheID, winObj) {
			winMap[cacheID] = winObj;
		},
		
		/**
		 * @func public static
		 * 根据指定id清楚DataWindow缓存
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
		 * 清除所有DataWindow缓存
		 */
		cleanAll : function() {
			for(var a in winMap) {
				this.clean(a);
			}
			winMap = {};
		},
		
		/**
		 * @func public static
		 * 根据winconfig生成GridWindow
		 * @param winCfg 生成window的参数,并根据指定参数名将已经encode的jsonstring再decode(用于处理跨页面传递Array会导致类型错误的问题)
		 * @param arrayAttrParams 需要将jsonstring decode的参数名
		 * @return UniEXT.lookup.GridWindow
		 */		
		genGridWindow : function(winCfg, arrayAttrParams) {
			return new UniEXT.lookup.GridWindow(this.decodeArrayAttr(winCfg, arrayAttrParams));
		},
		
		/**
		 * @func public static
		 * 根据winconfig生成GridWindow,并根据指定参数名将已经encode的jsonstring再decode(用于处理跨页面传递Array会导致类型错误的问题)
		 * @param winCfg 生成window的参数
		 * @param arrayAttrParams 需要将jsonstring decode的参数名
		 * @return UniEXT.lookup.TreeWindow
		 */		
		genTreeWindow : function(winCfg, arrayAttrParams) {
			return new UniEXT.lookup.TreeWindow(this.decodeArrayAttr(winCfg, arrayAttrParams));
		},

		/**
		 * @func private
		 * 将winconfig内指定参数进行decode
		 * @param winCfg 生成window的参数
		 * @param arrayAttrParams 需要将jsonstring decode的参数名
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
