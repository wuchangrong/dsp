package com.handao.platform.framework.envelope;

import java.io.Serializable;

public class AFResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private int intValue = -1;

    private boolean booleanValue = false;

    private String resultMessageKey = null;

    private String exceptionMessage = null;

    private Exception exception = null;

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getResultMessageKey() {
        return resultMessageKey;
    }

    public void setResultMessageKey(String resultMessageKey) {
        this.resultMessageKey = resultMessageKey;
    }
    
    public String getExceptionMessage() {
        if(exceptionMessage == null || "".equals(exceptionMessage)) {
            exceptionMessage = this.getExceptionMessageByException();
        }
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    private String getExceptionMessageByException() {
        StringBuffer sb = new StringBuffer();
        if(this.exception != null) {
            StackTraceElement[] trace = exception.getStackTrace();
            String ex = "Caused by: " + exception;
            ex = ex.replaceAll("\\r", "\\\\r");
            ex = ex.replaceAll("\\n", "\\\\n");
            ex = ex.replaceAll("\\t", "\\\\t");
            sb.append(ex);

            for(int i = 0; i < trace.length; i++)
                sb.append("\\r\\n\\tat " + trace[i]);
        }
        return sb.toString();
    }

}