package com.handao.platform.framework.util.exception;

public class AFTranRollBackException extends AFTranAppException {
	private static final long serialVersionUID = 1L;

	public AFTranRollBackException(String str) {
        super(str);
    }

    public AFTranRollBackException() {
        super();
    }

    public AFTranRollBackException(Exception e) {
        super(e);
    }

}