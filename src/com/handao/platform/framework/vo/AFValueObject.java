package com.handao.platform.framework.vo;

import java.util.ArrayList;
import java.util.List;


public abstract class AFValueObject implements java.io.Serializable, Cloneable {
    public static final int STATUS_NEW = 1;
    public static final int STATUS_MODIFY = 2;
    public static final int STATUS_DELETE = 3;

    private int _status = -1;


    public int getVOStatus() {
        return _status;
    }

    public void setVOStatus(int _status) {
        this._status = _status;
    }
    
    public List transExportList() {
    	List list = new ArrayList();
        return list;
    }

}