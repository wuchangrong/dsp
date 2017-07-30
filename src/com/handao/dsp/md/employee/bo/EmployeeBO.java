package com.handao.dsp.md.employee.bo;

import com.handao.dsp.md.employee.dao.EmployeeDAO;
import com.handao.dsp.md.employee.vo.EmployeeVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;

public class EmployeeBO extends AFBizBO {

    private EmployeeDAO dao_Employee = (EmployeeDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.employee.dao.EmployeeDAO");

    public EmployeeBO() {
        this.addListener(new AFBizBOListenerImpl() {
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                ((EmployeeVO)vo).setEMP_ROW_ID(AFIDFactory.getNextID());
                ((EmployeeVO)vo).setEMP_CREATED_BY(userToken.getUserId());
                ((EmployeeVO)vo).setEMP_LAST_UPD_BY(userToken.getUserId());
                return true;
            }
            
            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo)
            {
                ((EmployeeVO)vo).setEMP_LAST_UPD_BY(userToken.getUserId());
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
        return dao_Employee;
    }
}