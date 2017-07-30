package com.handao.platform.sm.privilege.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.exception.AFDAOException;
import com.handao.platform.framework.vo.AFValueObject;

public class AFUserDAO extends AFBizDAO {

	private static final long serialVersionUID = 1L;
	
	public static final String SQL_CHANGE_BY_VO = "[change-by-vo]";
	public static final String SQL_CHECK = "[check-user-using]";
	public static final String SQL_RETRIEVE_USER_CODE = "[retrieve-user-code]";
	public static final String SQL_RETRIEVE_USER_NAME = "[retrieve-user-name]";
	public static final String SQL_RETRIEVE_USER_CODE_ROW_ID = "[retrieve-user-code-row-id]";
	public static final String SQL_RETRIEVE_USER_NAME_ROW_ID = "[retrieve-user-name-row-id]";
    /**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace() {
        return "common.sm.privilege.user.User";
    }
 
    public boolean doUsingChange(AFUserToken userToken,AFValueObject vo) throws AFDAOException {
        try {
            return daoCommand.sm_update(this.getNameSpace()+"."+SQL_CHANGE_BY_VO, vo);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
    
    public List retrieveUserByCriteria(String row_id) throws AFDAOException
    {
        List result = new ArrayList();
        try
        {
      
            HashMap hashmap = new HashMap();
            hashmap.put("row_id", row_id);
            result = daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_CHECK, hashmap);
            return result;
        }catch (Exception e)
        {
        	 throw new AFDAOException(e);
        }
    }
    
	
	public List retrieveUserCode(String user_code, String row_id) throws AFDAOException
	{
		List result = new ArrayList();
		try
		{
  
			HashMap hashmap = new HashMap();
			hashmap.put("user_code", user_code);
			hashmap.put("row_id", row_id);
			result = daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_RETRIEVE_USER_CODE, hashmap);
			return result;
		}catch (Exception e)
		{
			throw new AFDAOException(e);
		}
	}
	public List retrieveUserById(Long row_id) throws AFDAOException
	{
		List result = new ArrayList();
		try
		{
			result = daoCommand.sm_searchList(this.getNameSpace()+".[find-by-id]", row_id);
			return result;
		}catch (Exception e)
		{
			throw new AFDAOException(e);
		}
	}
	public List retrieveUserName(String user_name, String row_id) throws AFDAOException
	{
		List result = new ArrayList();
		try
		{
  
			HashMap hashmap = new HashMap();
			hashmap.put("user_name", user_name);
			hashmap.put("row_id", row_id);
			result = daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_RETRIEVE_USER_NAME, hashmap);
			return result;
		}catch (Exception e)
		{
			throw new AFDAOException(e);
		}
	}
}