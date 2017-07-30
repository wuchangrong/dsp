package com.handao.platform.framework.util.exception;

public class AFBOException extends AFSysException {
	private static final long serialVersionUID = 1L;

	public AFBOException(Exception e) {
        super(e);
    }

    public AFBOException(String pMsg) {
        super(pMsg);
    }

}