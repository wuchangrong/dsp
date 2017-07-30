package com.handao.dsp.md.company.bo;

import com.handao.dsp.md.company.dao.CompanyDAO;
import com.handao.dsp.md.company.vo.CompanyVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;

public class CompanyBO extends AFBizBO {

    private CompanyDAO dao_Company = (CompanyDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.company.dao.CompanyDAO");

    public CompanyBO() {
        this.addListener(new AFBizBOListenerImpl() {
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                ((CompanyVO)vo).setCPN_ROW_ID(AFIDFactory.getNextID());
                ((CompanyVO)vo).setCPN_CREATED_BY(userToken.getUserId());
                ((CompanyVO)vo).setCPN_LAST_UPD_BY(userToken.getUserId());
                return true;
            }
            
            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo)
            {
                ((CompanyVO)vo).setCPN_LAST_UPD_BY(userToken.getUserId());
                return true;
            }

        });
    }

    /**
     * [父类抽象方法实现]
     * 返回当前活动DAO
     * @return AFBizDAO
     */
    protected AFBizDAO getActiveDAO() {
        return dao_Company;
    }
}