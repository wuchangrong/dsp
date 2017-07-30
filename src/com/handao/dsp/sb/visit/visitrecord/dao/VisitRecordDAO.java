package com.handao.dsp.sb.visit.visitrecord.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitRecordDAO extends AFBizDAO{

    /**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace(){
        return "dsp.sb.visit.visitrecord.VisitRecord";
    }
    
    /**
     * 根据vo更新status
     * 
     * @return boolean
     */    
    public boolean doUpdateStatusByVO(AFValueObject vo) throws AFDAOException {
        try {
            return daoCommand.sm_update(this.getNameSpace()+".[update-status-by-vo]", vo);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }    
}