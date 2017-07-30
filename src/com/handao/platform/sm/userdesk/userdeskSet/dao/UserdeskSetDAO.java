package com.handao.platform.sm.userdesk.userdeskSet.dao;

import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.util.exception.AFDAOException;

public class UserdeskSetDAO extends AFBizDAO {

    /**
	 * 字段功能描述
	 */
	private static final long serialVersionUID = 1L;

	/**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace() {
        return "common.userdesk.userdeskSet.userdeskSet.UserdeskSet";
    }
    
    
    /**
     * 
     * 方法描述:根据用户id取桌面的模块组
     *
     * @param userID
     * @return
     * @throws AFDAOException
     * date:Mar 23, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchGroup(long userID)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		String s_ROLE_ID=String.valueOf(userID);
    		
    		cc.put("m_ROLE_ID", AFDataFormat.toLong(s_ROLE_ID));
    		
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-group-by-userid]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    /**
     * 
     * 方法描述:根据分组取模块
     *
     * @param groupID
     * @return
     * @throws AFDAOException
     * date:Mar 23, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchProgram(long groupID)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		//String s_GROUP_ID=String.valueOf(groupID);
    		
    		
    		cc.put("d_GROUP_ID", new Long(groupID));
    		
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-program-by-group]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    public List doSearchMessage(long companyID)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		String CompanyID=String.valueOf(companyID);
    		
    		cc.put("CompanyID", AFDataFormat.toLong(CompanyID));
    		
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-message-by-company]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    /**
     * 
     * 方法描述:查询日报
     *
     * @param groupID
     * @return
     * @throws AFDAOException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchDayReport(String queryYear)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();    		
    		long value=0;
    		cc.put("d_GROUP_ID", new Long(value));
    		cc.put("queryYear", queryYear);
    		
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-day-report]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    /**
     * 
     * 方法描述:查询周报
     *
     * @return
     * @throws AFDAOException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchWeekReport(String queryYear)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		
    		long value=0;
    		cc.put("d_GROUP_ID", new Long(value));
    		cc.put("queryYear", queryYear);
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-week-report]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    
    /**
     * 
     * 方法描述:查询专项报告
     *
     * @return
     * @throws AFDAOException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchUploadReport()
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		
    		long value=0;
    		cc.put("d_GROUP_ID", new Long(value));
    		
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-upload-report]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    
    /**
     * 
     * 方法描述:查询消息
     *
     * @param userID
     * @return
     * @throws AFDAOException
     * date:Aug 6, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchMgs(long userID)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();

    		
    		cc.put("userID", new Long(userID));
    		
		    return daoCommand.sm_searchList(getNameSpace() + "." + "[search-msg-by-userid]", cc);
    	}
    	catch(Exception ex)
    	{
    		throw new AFDAOException(ex);
    	}
	}
    
    
    
    /**
     * 
     * 方法描述:删除发送地址表记录
     *
     * @param message_id
     * @param empID
     * @return
     * @throws AFDAOException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public boolean deleteMsgAddress(long message_id,long empID)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		cc.put("message_id", new Long(message_id));
    		cc.put("empID", new Long(empID));
    		
    		return daoCommand.sm_delete(getNameSpace() + "." + "[delete-msg-address]", cc);
		}
		catch(Exception ex)
		{
			throw new AFDAOException(ex);
		}
	}
    
    /**
     * 
     * 方法描述:修改传递日志表记录为已读
     *
     * @param message_id
     * @param empID
     * @return
     * @throws AFDAOException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public boolean updateMsgArc(long message_id,long empID)
    throws AFDAOException
	{
    	try
    	{	
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		cc.put("message_id", new Long(message_id));
    		cc.put("empID", new Long(empID));
    		
    		return daoCommand.sm_update(getNameSpace() + "." + "[update-msg-address-arc]", cc);
		}
		catch(Exception ex)
		{
			throw new AFDAOException(ex);
		}
	}
    
    /**
     * 
     * 方法描述:查询该队列里是否还有发送地址的记录
     *
     * @param message_id
     * @return
     * @throws AFDAOException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchMsgAddress(long message_id)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		cc.put("message_id", new Long(message_id));
    		
    		return daoCommand.sm_searchList(getNameSpace() + "." + "[search-msg-address]", cc);
    	}
	    catch(Exception ex)
		{
			throw new AFDAOException(ex);
		}
	}
    
    /**
     * 
     * 方法描述:删除消息队列表记录
     *
     * @param message_id
     * @return
     * @throws AFDAOException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public boolean deleteMsgQueue(long message_id)
    throws AFDAOException
	{
    	try
    	{
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		cc.put("message_id", new Long(message_id));
    		
    		return daoCommand.sm_delete(getNameSpace() + "." + "[delete-msg-queue]", cc);
		}
		catch(Exception ex)
		{
			throw new AFDAOException(ex);
		}
	}
    
    /**
     * 
     * 方法描述:修改消息归档表位已读
     *
     * @param message_id
     * @return
     * @throws AFDAOException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public boolean updateMsgArc(long message_id)
    throws AFDAOException
	{
    	try
    	{	
    		AFSearchCustomerCondition cc=new AFSearchCustomerCondition();
    		cc.put("message_id", new Long(message_id));
    		
    		return daoCommand.sm_update(getNameSpace() + "." + "[pdate-msg-arc]", cc);
		}
		catch(Exception ex)
		{
			throw new AFDAOException(ex);
		}
	}

}