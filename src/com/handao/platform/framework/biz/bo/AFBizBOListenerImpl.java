package com.handao.platform.framework.biz.bo;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.vo.AFValueObject;

public class AFBizBOListenerImpl implements AFBizBOListener{
    public AFBizBOListenerImpl() {
    }

    public void beforeSearch(AFUserToken userToken, AFSearchCondition sc) {
    }

    public void afterSearch(AFUserToken userToken, AFSearchCondition sc, AFPage page) {
    }

    public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
        return true;
    }

    public boolean afterInsert(AFUserToken userToken, AFValueObject vo) {
        return true;
    }

    public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo) {
        return true;
    }

    public boolean afterUpdate(AFUserToken userToken, AFValueObject vo) {
        return true;
    }

    public boolean beforeDelete(AFUserToken userToken, long id) {
        return true;
    }

    public boolean afterDelete(AFUserToken userToken, long id) {
        return true;
    }


    public void beforeFind(AFUserToken userToken, long id) {
    }

    public void afterFind(AFUserToken userToken, long id, AFValueObject vo) {
    }

}