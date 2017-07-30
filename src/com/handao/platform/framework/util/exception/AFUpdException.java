package com.handao.platform.framework.util.exception;

public class AFUpdException extends AFException {
	private static final long serialVersionUID = 1L;

	public AFUpdException() {
        super();
    }

    public AFUpdException(Exception e) {
        super(e);
    }

    public AFUpdException(String msg) {
        super(msg);
    }
}