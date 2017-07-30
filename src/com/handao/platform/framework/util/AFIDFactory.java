package com.handao.platform.framework.util;

import com.handao.platform.framework.dao.AFIDFactoryDAO;

public class AFIDFactory {

    public static int getNextID(String dbkey) {
        AFIDFactoryDAO ifo = new AFIDFactoryDAO();
        return ifo.getNextID(dbkey);
    }
    
    public static int getNextID() {
        return getNextID(null);
    }

}