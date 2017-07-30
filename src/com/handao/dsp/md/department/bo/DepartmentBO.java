package com.handao.dsp.md.department.bo;

import com.handao.dsp.md.department.dao.DepartmentDAO;
import com.handao.dsp.md.department.vo.DepartmentVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;

public class DepartmentBO extends AFBizBO {

    private DepartmentDAO dao_Department = (DepartmentDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.department.dao.DepartmentDAO");

    public DepartmentBO() {
        this.addListener(new AFBizBOListenerImpl() {
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                ((DepartmentVO)vo).setDEPT_ROW_ID(AFIDFactory.getNextID());
                DepartmentVO deptVO = (DepartmentVO)vo;
                deptVO.setDEPT_CREATED_BY(userToken.getUserId());
                deptVO.setDEPT_LAST_UPD_BY(userToken.getUserId());
                return true;
            }

			public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo)
			{
                DepartmentVO deptVO = (DepartmentVO)vo;
                deptVO.setDEPT_LAST_UPD_BY(userToken.getUserId());
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
        return dao_Department;
    }
}