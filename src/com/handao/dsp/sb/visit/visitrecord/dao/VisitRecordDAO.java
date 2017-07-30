package com.handao.dsp.sb.visit.visitrecord.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitRecordDAO extends AFBizDAO{

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace(){
        return "dsp.sb.visit.visitrecord.VisitRecord";
    }
    
    /**
     * ����vo����status
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