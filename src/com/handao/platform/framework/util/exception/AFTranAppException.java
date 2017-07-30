package com.handao.platform.framework.util.exception;

public class AFTranAppException extends AFDAOException {
	private static final long serialVersionUID = 1L;

    public AFTranAppException(String str) {
        super(str);
    }

    public AFTranAppException() {
        super();
    }

    public AFTranAppException(Exception e) {
        super(e);
    }

}