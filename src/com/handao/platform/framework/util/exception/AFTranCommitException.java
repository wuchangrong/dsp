package com.handao.platform.framework.util.exception;

public class AFTranCommitException extends AFTranAppException {
	private static final long serialVersionUID = 1L;

	public AFTranCommitException(String str) {
        super(str);
    }

    public AFTranCommitException() {
        super();
    }

    public AFTranCommitException(Exception e) {
        super(e);
    }

}