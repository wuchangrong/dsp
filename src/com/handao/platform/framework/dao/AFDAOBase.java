package com.handao.platform.framework.dao;

public class AFDAOBase implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public AFDAOCommand daoCommand = null;

    public AFDAOBase() {
        daoCommand = new AFDAOCommand();
    }
}