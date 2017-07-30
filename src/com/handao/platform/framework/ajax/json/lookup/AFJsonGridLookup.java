package com.handao.platform.framework.ajax.json.lookup;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.handao.platform.framework.ajax.json.AFJsonHelper;
import com.handao.platform.framework.ajax.json.AFJsonList;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.util.lookup.AFLookupUtil;

public class AFJsonGridLookup extends AFJsonList {

	protected AFPage getData(HttpServletRequest request) {		
        String dbkey = AFJsonHelper.getDbkey(request);
        String sqlID = AFJsonHelper.getSqlId(request);
        AFPage page = AFJsonHelper.getPage(request);
    	Map param = AFJsonHelper.getSqlParameter(page, AFJsonHelper.getBaseCondition(request), AFJsonHelper.getFilterCondition(request));
        page = AFLookupUtil.getDataBySqlId(dbkey, page, sqlID, param);

        return page;
    }
    
}