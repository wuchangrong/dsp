package com.handao.platform.framework.util.exception;

public class AFTranSysException extends AFSysException {
	private static final long serialVersionUID = 1L;

	public AFTranSysException(String str) {
        super(str);
    }

    public AFTranSysException() {
        super();
    }

    public AFTranSysException(Exception e) {
        super(e);
    }

}