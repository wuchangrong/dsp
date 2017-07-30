package com.handao.platform.framework.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.exception.AFDAOException;

public class AFIDFactoryDAO extends AFDAOBase {
	private static final long serialVersionUID = 1L;
	AFLogger logger = AFLogger.getLogger(AFIDFactoryDAO.class);

    public int getNextID(String dbkey) throws AFDAOException {
        int next = -1;
        try {
            Map map = new HashMap();
            map.put("id", null);
            daoCommand.sm_execProcedure(dbkey, "framework.util.idfactory.get-next-id", map);
            next = ((Number)map.get("id")).intValue();
        }
        catch (SQLException ex) {
            throw new AFDAOException(ex);
        }
        return next;
    }
}