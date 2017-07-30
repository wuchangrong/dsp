package com.handao.platform.framework.util.exception;

public class AFDAOException extends AFSysException {
	private static final long serialVersionUID = 1L;

	public AFDAOException(Exception e) {
        super(e);
    }

    public AFDAOException(String pMsg) {
        super(pMsg);
    }

    public AFDAOException() {
        super();
    }

}