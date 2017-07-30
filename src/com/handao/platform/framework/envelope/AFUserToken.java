package com.handao.platform.framework.envelope;

import java.io.Serializable;

public interface AFUserToken extends Serializable {

    public int getUserId();

    public String getUserCode();

    public String getUserName();
}