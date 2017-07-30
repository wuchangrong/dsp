package com.handao.platform.framework.util.exception;

public class AFServiceException extends AFSysException {
	private static final long serialVersionUID = 1L;

	public AFServiceException(Exception e) {
        super(e);
        e.printStackTrace();
    }

    public AFServiceException(String pMsg) {
        super(pMsg);
    }

}