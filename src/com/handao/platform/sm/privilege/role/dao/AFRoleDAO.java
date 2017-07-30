package com.handao.platform.sm.privilege.role.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.exception.AFDAOException;

public class AFRoleDAO extends AFBizDAO {

	private static final long serialVersionUID = 1L;
	
	protected String getNameSpace() {
		return "common.sm.privilege.role.Role";
	}
	public static final String SQL_SEARCH_BY_CONDITION_WHENSUPER = "[search-by-condition-whensuper]";
	public static final String SQL_SEARCH_BY_CONDITION_WHENADMIN = "[search-by-condition-whenadmin]";
	public static final String SQL_SEARCH_BY_CONDITION_WHENDEBUG = "[search-by-condition-whendebug]";
	public static final String SQL_RETRIEVE_ROLE_CODE = "[retrieve-role-code]";
	public static final String SQL_RETRIEVE_ROLE_NAME = "[retrieve-role-name]";
	//�����û���¼
	public AFPage doSearchPageByConditionWhenSuper(AFPage page, AFSearchCustomerCondition cc) throws AFDAOException {
        try {
            return daoCommand.sm_searchPage(this.getNameSpace()+"."+SQL_SEARCH_BY_CONDITION_WHENSUPER, cc, page);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	//ϵͳ����Ա��¼
	public AFPage doSearchPageByConditionWhenAdmin(AFPage page, AFSearchCustomerCondition cc) throws AFDAOException {
        try {
            return daoCommand.sm_searchPage(this.getNameSpace()+"."+SQL_SEARCH_BY_CONDITION_WHENADMIN, cc, page);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	
	//����Ա��¼
	public AFPage doSearchPageByConditionWhenDebug(AFPage page, AFSearchCustomerCondition cc) throws AFDAOException {
        try {
            return daoCommand.sm_searchPage(this.getNameSpace()+"."+SQL_SEARCH_BY_CONDITION_WHENDEBUG, cc, page);
        } catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
	//����ɫ�����Ƿ��Ѵ���
	public List retrieveRoleCode(String role_code, String row_id) throws AFDAOException
	{
		List result = new ArrayList();
		try
		{
  
			HashMap hashmap = new HashMap();
			hashmap.put("role_code", role_code);
			hashmap.put("row_id", row_id);
			result = daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_RETRIEVE_ROLE_CODE, hashmap);
			return result;
		}catch (Exception e)
		{
			throw new AFDAOException(e);
		}
	}
	//����ɫ�����Ƿ��Ѵ���
	public List retrieveRoleName(String role_name, String row_id) throws AFDAOException
	{
		List result = new ArrayList();
		try
		{
  
			HashMap hashmap = new HashMap();
			hashmap.put("role_name", role_name);
			hashmap.put("row_id", row_id);
			result = daoCommand.sm_searchList(this.getNameSpace()+"."+SQL_RETRIEVE_ROLE_NAME, hashmap);
			return result;
		}catch (Exception e)
		{
			throw new AFDAOException(e);
		}
	}
}