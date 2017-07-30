package com.handao.platform.framework.biz.bo;

import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.vo.AFValueObject;

public interface AFBizBOListener {

    public void beforeSearch(AFUserToken userToken, AFSearchCondition sc);

    public void afterSearch(AFUserToken userToken, AFSearchCondition sc, AFPage page);

    public boolean beforeInsert(AFUserToken userToken, AFValueObject vo);

    public boolean afterInsert(AFUserToken userToken, AFValueObject vo);

    public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo);

    public boolean afterUpdate(AFUserToken userToken, AFValueObject vo);

    public boolean beforeDelete(AFUserToken userToken, long id);

    public boolean afterDelete(AFUserToken userToken, long id);

    public void beforeFind(AFUserToken userToken, long id);

    public void afterFind(AFUserToken userToken, long id, AFValueObject vo);
}