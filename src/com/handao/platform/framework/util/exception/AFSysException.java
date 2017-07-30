package com.handao.platform.framework.util.exception;

public class AFSysException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	protected Exception mChainedException = null;

    public AFSysException() {
        super();
    }

    public AFSysException(String msg) {
        super(msg);
    }

    public AFSysException(Exception e) {
        super("Chained Exception: "+e);
        mChainedException = e;
    }

    public Exception getChainedException() {
        return mChainedException;
    }

    public void setChainedException(Exception e) {
        mChainedException = e;
    }
}