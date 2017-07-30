package com.handao.platform.framework.util.exception;

public class AFException extends Exception {
	private static final long serialVersionUID = 1L;
	
	protected Exception mChainedException = null;

    public AFException() {
        super();
    }

    public AFException(String msg) {
        super(msg);
    }

    public AFException(Exception e) {
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