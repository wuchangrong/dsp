package com.handao.dsp.md.supplier.bo;

import com.handao.dsp.md.supplier.dao.SupplierDAO;
import com.handao.dsp.md.supplier.vo.SupplierVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;

public class SupplierBO extends AFBizBO {

    private SupplierDAO dao_Supplier = (SupplierDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.supplier.dao.SupplierDAO");

    public SupplierBO() {
        this.addListener(new AFBizBOListenerImpl() {
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                ((SupplierVO)vo).setSUP_ROW_ID(AFIDFactory.getNextID());
                ((SupplierVO)vo).setSUP_CREATED_BY(userToken.getUserId());
                ((SupplierVO)vo).setSUP_LAST_UPD_BY(userToken.getUserId());
                return true;
            }
            
            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo)
            {
                ((SupplierVO)vo).setSUP_LAST_UPD_BY(userToken.getUserId());
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
        return dao_Supplier;
    }
}