package com.handao.platform.framework.ajax.json.tree;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.handao.platform.framework.ajax.json.AFJsonHelper;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.util.tree.AFTreeNodeHandler;
import com.handao.platform.framework.util.tree.AFTreeUtil;


public class AFJsonTree extends com.handao.platform.framework.ajax.json.AFJsonTree {
	
	protected List getData(HttpServletRequest request) {
		
        String dbkey = AFJsonHelper.getDbkey(request);
        String sqlID = AFJsonHelper.getSqlId(request);
        long parentNodeID = AFJsonHelper.getParentNodeID(request);
        AFPage page = AFJsonHelper.getPage(request);
        Map param = AFJsonHelper.getSqlParameter(page, AFJsonHelper.getBaseCondition(request), AFJsonHelper.getFilterCondition(request));
        AFTreeNodeHandler nodeHandler = new AFTreeNodeHandler(AFJsonHelper.getLeafFlagValue(request));
        List list =AFTreeUtil.getDataBySqlIdWithNodeHandler(dbkey, sqlID, param, nodeHandler, parentNodeID);
        return list;
	}
}