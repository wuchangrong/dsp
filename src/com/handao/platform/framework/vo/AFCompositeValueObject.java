package com.handao.platform.framework.vo;

import java.util.List;

public abstract class AFCompositeValueObject extends AFValueObject {

    public abstract List[] getDetailList();

    public abstract void setDetailList(String detailVOClass, List dList);


}