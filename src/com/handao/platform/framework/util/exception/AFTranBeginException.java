package com.handao.platform.framework.util.exception;

public class AFTranBeginException extends AFTranAppException {
	private static final long serialVersionUID = 1L;

	public AFTranBeginException(String str) {
        super(str);
    }

    public AFTranBeginException() {
        super();
    }

    public AFTranBeginException(Exception e) {
        super(e);
    }

}