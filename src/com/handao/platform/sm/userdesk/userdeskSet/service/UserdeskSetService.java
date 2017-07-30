package com.handao.platform.sm.userdesk.userdeskSet.service;

import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.biz.service.AFBizServiceHandleImpl;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFRequest;
import com.handao.platform.framework.envelope.AFResponse;
import com.handao.platform.framework.envelope.AFResult;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.util.exception.AFServiceException;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.userdesk.userdeskSet.bo.UserdeskSetBO;

public class UserdeskSetService extends AFBizService {

    /**
	 * 字段功能描述
	 */
	private static final long serialVersionUID = 1L;
	private UserdeskSetBO bo_UserdeskSet = (UserdeskSetBO)AFBOProvider.getBOByClass("com.handao.platform.sm.userdesk.userdeskSet.bo.UserdeskSetBO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO() {
        return bo_UserdeskSet;
    }
    
    
    
    public void doUpdate(AFRequest AFReq, AFResponse AFResp)
    throws AFServiceException
	{
	    commonBizInvoke(AFReq, AFResp, new AFBizServiceHandleImpl(true) {
	
	        public boolean process(AFRequest AFReq, AFResponse AFResp)
	        {
	            boolean result = false;
	            AFBizBO bo = getActiveBO();
	            if(bo != null)
	                result = bo_UserdeskSet.doUserDeskUpdate(AFReq.getUserToken(), (AFValueObject)AFReq.getDefaultData());
	            AFResult AFResult = AFResp.getResult();
	            AFResult.setBooleanValue(result);
	            AFResult.setResultMessageKey(result ? "AF.operation.save.success" : "AF.operation.save.faile");
	            return result;
	        }
	
	    }
	);
	}
    
    
    /**
     * 
     * 方法描述:根据用户id取桌面的模块组
     *
     * @param userID
     * @return
     * @throws AFBOException
     * date:May 12, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchGroup(long userID)
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.doSearchGroup(userID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
   /**
    * 
    * 方法描述:取公告
    *
    * @param companyID
    * @return
    * @throws AFBOException
    * date:May 12, 2009
    * @see: 
    * @author: 高步伦
    */
    public List doSearchMessage(long companyID)
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.doSearchMessage(companyID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:根据分组取模块
     *
     * @param programID
     * @return
     * @throws AFBOException
     * date:May 12, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchProgram(long programID)
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.doSearchProgram(programID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询日报
     *
     * @return
     * @throws AFServiceException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchDayReport(String queryYear)
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.searchDayReport(queryYear); 
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询周报
     *
     * @return
     * @throws AFServiceException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchWeekReport(String queryYear)
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.searchWeekReport(queryYear);
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询专项报告
     *
     * @return
     * @throws AFServiceException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchUploadReport()
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.searchUploadReport();
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询消息
     *
     * @param userId
     * @return
     * @throws AFServiceException
     * date:Aug 6, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchMgs(long userId)
    throws AFServiceException
    {
    	try
    	{
    		return bo_UserdeskSet.doSearchMgs(userId);
    	}
    	catch(Exception ex)
    	{
    		throw new AFServiceException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:删除消息队列记录，消息归档表置为已读
     *
     * @param AFReq
     * @param AFResp
     * @throws AFServiceException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public void deleteMsgAddress(AFRequest AFReq, AFResponse AFResp)
    throws AFServiceException
	{
	    commonBizInvoke(AFReq, AFResp, new AFBizServiceHandleImpl(true) {
	
	        public boolean process(AFRequest AFReq, AFResponse AFResp)
	        {
	            boolean result = false;
	            AFBizBO bo = getActiveBO();
	            if(bo != null)
	            {
	            	long message_id=Long.parseLong((String)AFReq.getData("message_id"));
	            	long empID=Long.parseLong((String)AFReq.getData("empID"));
	            	
	                result = bo_UserdeskSet.deleteMsgAddress(AFReq.getUserToken(),message_id,empID);
	            }
	            AFResult AFResult = AFResp.getResult();
	            AFResult.setBooleanValue(result);
	            AFResult.setResultMessageKey(result ? "AF.operation.delete.success" : "AF.operation.delete.faile");
	            return result;
	        }
	
	    }
	);
	}
    
    
    /**
     * 
     * 方法描述:调用存储过程生成事件消息
     *
     * @param AFReq
     * @param AFResp
     * @throws AFServiceException
     * date:Sep 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public void callMsgPro(AFRequest AFReq, AFResponse AFResp)
    throws AFServiceException
	{
	    commonBizInvoke(AFReq, AFResp, new AFBizServiceHandleImpl(true) {
	
	        public boolean process(AFRequest AFReq, AFResponse AFResp)
	        {
	            boolean result = true;
//	            MsgRegistersBO bo = new MsgRegistersBO();
//	            if(bo != null)
//	            {
//	            	String s_ORG_ID=(String)AFReq.getData("s_ORG_ID");
//	                String s_BUSS_ID=(String)AFReq.getData("s_BUSS_ID");       
//	                long s_USER_ID=Long.parseLong((String)AFReq.getData("s_USER_ID"));
//	                String s_MSG_CODE=(String)AFReq.getData("s_MSG_CODE");
//	                String s_SEND_EMP_ID=(String)AFReq.getData("s_SEND_EMP_ID");
//	                String IS_VARCHAR=(String)AFReq.getData("IS_VARCHAR");
//	            	
//	                 bo.callMsgEvent(s_ORG_ID, s_BUSS_ID, s_USER_ID, s_MSG_CODE, s_SEND_EMP_ID, IS_VARCHAR);
//	            }
//	            AFResult AFResult = AFResp.getResult();
//	            AFResult.setBooleanValue(result);
//	            AFResult.setResultMessageKey(result ? "AF.operation.delete.success" : "AF.operation.delete.faile");
	            return result;
	        }
	
	    }
	);
	}
}