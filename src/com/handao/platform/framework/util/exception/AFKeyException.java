package com.handao.platform.framework.util.exception;

import java.util.ArrayList;

public class AFKeyException extends AFException {
	private static final long serialVersionUID = 1L;
	
	ArrayList mMsgKeyList = new ArrayList();

    public ArrayList getMsgKeyList() {
        return mMsgKeyList;
    }

    public String getMsgKeyText() {
        String line = "";
        for(int i = 0; i<mMsgKeyList.size(); i++) {
            line = line+mMsgKeyList.get(i);
        }
        return line;
    }

    public void setMsgKey(String msgKey) {
        mMsgKeyList.add(msgKey);
    }

    public void clear() {
        mMsgKeyList = null;
        mMsgKeyList = new ArrayList();
    }
}