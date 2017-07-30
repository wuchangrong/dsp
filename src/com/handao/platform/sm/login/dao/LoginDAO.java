package com.handao.platform.sm.login.dao;

import java.util.List;
import java.util.Map;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.util.exception.AFDAOException;
import com.handao.platform.sm.login.vo.UserVO;

public class LoginDAO extends AFBizDAO{
	private static final long serialVersionUID = 1L;
	
    private AFLogger logger = AFLogger.getLogger(this.getClass());	

    protected String getNameSpace() {
        return "common.sm.login";
    }    
    /**
     * 根据客户代码，返回指定的客户信息
     */
    public UserVO getUser(String userCode) throws AFDAOException{
        try {
            List result = daoCommand.sm_searchList("",this.getNameSpace()+".[get-user-by-code]",userCode);
            if(result == null || result.size() == 0)
            	return null;
            else
            	return (UserVO)result.get(0);
        } catch(Exception ex) {
        	logger.logError(ex);
            throw new AFDAOException(ex);
        }
    }
    /**
     * 方法描述:取回用户指定级别
     */
    public List getUserPrivilegeByLevel(Map param) throws AFDAOException{
        try {
            return daoCommand.sm_searchList("",this.getNameSpace()+".[get-user-privilege-by-level]",param);
        } catch(Exception ex) {
        	logger.logError(ex);
            throw new AFDAOException(ex);
        }    	
    }
}
