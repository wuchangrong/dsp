package com.handao.platform.sm.userdesk.userdeskSet.bo;

import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.bo.AFBizCompositeBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFCompositeValueObject;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.userdesk.userdeskSet.dao.UserdeskSetDAO;
import com.handao.platform.sm.userdesk.userdeskSet.vo.UserdeskSetDetailVO;
import com.handao.platform.sm.userdesk.userdeskSet.vo.UserdeskSetVO;


public class UserdeskSetBO extends AFBizCompositeBO {

    private UserdeskSetDetailBO bo_UserdeskSetDetail = (UserdeskSetDetailBO)AFBOProvider.getBOByClass("com.handao.platform.sm.userdesk.userdeskSet.bo.UserdeskSetDetailBO");

    private UserdeskSetDAO dao_UserdeskSet = (UserdeskSetDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.userdesk.userdeskSet.dao.UserdeskSetDAO");


    public UserdeskSetBO() {
        this.addListener(new AFBizBOListenerImpl() {
            /**
             * [AFBizBOListenerImpl类方法复写]
             * 插入前业务逻辑接口
             * 完成数据唯一性校验
             * 完成主从表的主键设置
             * @param userToken AFUserToken
             * @param vo AFValueObject
             * @return boolean
             */
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                long masterID = AFIDFactory.getNextID();

                UserdeskSetVO masterVO = (UserdeskSetVO)vo;
                masterVO.setM_ROW_ID(masterID);

                List dl_UserdeskSetDetail = masterVO.getDetailList_UserdeskSetDetail();
                for(int i = 0; i < dl_UserdeskSetDetail.size(); i++) {
                    UserdeskSetDetailVO vo_new = (UserdeskSetDetailVO)dl_UserdeskSetDetail.get(i);
                    vo_new.setD_ROW_ID(AFIDFactory.getNextID());
                    vo_new.setD_GROUP_ID(masterID);
                }

                return true;
            }

            /**
             * [AFBizBOListenerImpl类方法复写]
             * 更新前业务逻辑接口
             * 完成主表数据的插入以及从表数据的删除，更新，插入
             * @param userToken AFUserToken
             * @param vo AFValueObject
             * @return boolean
             */
            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo) {
                long masterID = ((UserdeskSetVO)vo).getM_ROW_ID();

                List dl_UserdeskSetDetail_new = ((UserdeskSetVO)vo).getDetailList_UserdeskSetDetail();
                List dl_UserdeskSetDetail_src = bo_UserdeskSetDetail.doSearchByMaster(masterID);
                for(int i = 0; i < dl_UserdeskSetDetail_new.size(); i++) {
                    UserdeskSetDetailVO detailVO_new = (UserdeskSetDetailVO)dl_UserdeskSetDetail_new.get(i);
                    boolean insertFlag = true;
                    for(int j = 0; j < dl_UserdeskSetDetail_src.size(); ) {
                        UserdeskSetDetailVO detailVO_src = (UserdeskSetDetailVO)dl_UserdeskSetDetail_src.get(j);
                        if(detailVO_new.getD_ROW_ID()==detailVO_src.getD_ROW_ID()) {
                            detailVO_new.setVOStatus(AFValueObject.STATUS_MODIFY);
                            dl_UserdeskSetDetail_src.remove(j);
                            insertFlag = false;
                            break;
                        }
                        j++;
                    }
                    if(insertFlag) {
                        detailVO_new.setD_ROW_ID(AFIDFactory.getNextID());
                        detailVO_new.setD_GROUP_ID(masterID);
                        detailVO_new.setVOStatus(AFValueObject.STATUS_NEW);
                    }
                }
                for(int i = 0; i < dl_UserdeskSetDetail_src.size(); i++) {
                    UserdeskSetDetailVO detailVO_src = (UserdeskSetDetailVO)dl_UserdeskSetDetail_src.get(i);
                    detailVO_src.setVOStatus(AFValueObject.STATUS_DELETE);
                    dl_UserdeskSetDetail_new.add(detailVO_src);
                }

                return true;
            }

        });
    }
    
    /**
     * 
     * 方法描述:更新用户定义模块
     *
     * @param userToken
     * @param vo
     * @return
     * @throws AFBOException
     * date:Mar 21, 2009
     * @see: 
     * @author: 高步伦
     */
    public boolean doUserDeskUpdate(AFUserToken userToken, AFValueObject vo)
    throws AFBOException
	{
    	try
    	{
		    boolean result;
		    result = true;
		    if(listener != null)
		        result = listener.beforeUpdate(userToken, vo);
		    if(result)
		        result = getActiveDAO().doUpdateByVO(vo);
		    if(result)
		    {
		        List dList[] = ((AFCompositeValueObject)vo).getDetailList();
		        for(int i = 0; i < dList.length; i++)
		        {
		            AFBizBO detailBO = getOperateBO(getDetailVOClass(dList[i]));
		            if(detailBO == null)
		                continue;
		            
		            result = detailBO.doDeleteByMaster(((UserdeskSetVO)vo).getM_ROW_ID());
		            
		            
		            if(result)
		            {
		            	
		            	for(int m=0;m<dList[i].size();m++)
		            	{
		            		UserdeskSetDetailVO vo_new = (UserdeskSetDetailVO)dList[i].get(m);
		                    vo_new.setD_ROW_ID(AFIDFactory.getNextID());
		                    vo_new.setD_GROUP_ID(((UserdeskSetVO)vo).getM_ROW_ID());
		                    if(vo_new.getVOStatus()!=AFValueObject.STATUS_DELETE)
		                    {
		                    	result = detailBO.doInsert(userToken, vo_new);
		                    }
		            	}
		            }
		            if(!result)
		                break;
		        }
		
		    }
		    if(result && listener != null)
		        result = listener.afterUpdate(userToken, vo);
		    return result;
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}		    
	}
    
    
    


    /**
     * [父类抽象方法实现]
     * 返回当前活动DAO
     * @return AFBizDAO
     */
    protected AFBizDAO getActiveDAO() {
        return dao_UserdeskSet;
    }

    /**
     * [父类抽象方法实现]
     * 返回当前BO的子BO集
     * @return AFBizBO[]
     */
    protected AFBizBO[] getDetailBO() {
        return new AFBizBO[] {bo_UserdeskSetDetail};
    }

    /**
     * [父类抽象方法实现]
     * 根据指定VOClass返回对应的操作BO
     * @param detailVOClass String
     * @return AFBizBO
     */
    protected AFBizBO getOperateBO(String detailVOClass) {
        if(UserdeskSetDetailVO.class.getName().equals(detailVOClass))
            return bo_UserdeskSetDetail;

        return null;
    }
    
    private String getDetailVOClass(List list)
    {
        if(list != null && list.size() != 0)
        {
            for(int i = 0; i < list.size(); i++)
            {
                AFValueObject vo = (AFValueObject)list.get(i);
                if(vo != null)
                    return vo.getClass().getName();
            }

        }
        return "";
    }
    
    
    /**
     * 
     * 方法描述:根据用户id取桌面的模块组
     *
     * @param userID
     * @return
     * @throws AFBOException
     * date:Mar 23, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchGroup(long userID)
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.doSearchGroup(userID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:根据分组取模块
     *
     * @param programID
     * @return
     * @throws AFBOException
     * date:Mar 23, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchProgram(long programID)
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.doSearchProgram(programID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    /**
     * 
     * 方法描述:取公告
     *
     * @param programID
     * @return
     * @throws AFBOException
     * date:Apr 3, 2009
     * @see: 
     * @author: 高步伦
     */
    public List doSearchMessage(long companyID)
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.doSearchMessage(companyID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    
    		
    /**
     * 
     * 方法描述:查询日报
     *
     * @return
     * @throws AFBOException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */		
    public List searchDayReport(String queryYear)
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.searchDayReport(queryYear); 
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询周报
     *
     * @return
     * @throws AFBOException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchWeekReport(String queryYear)
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.searchWeekReport(queryYear);
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询专项报告
     *
     * @return
     * @throws AFBOException
     * date:May 14, 2009
     * @see: 
     * @author: 高步伦
     */
    public List searchUploadReport()
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.searchUploadReport();
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    
    /**
     * 
     * 方法描述:查询消息
     *
     * @param userID
     * @return
     * @throws AFBOException
     * date:Aug 6, 2009
     * @see: 
     * @author: 高步伦 
     */
    public List doSearchMgs(long userID)
    throws AFBOException
    {
    	try
    	{
    		return dao_UserdeskSet.doSearchMgs(userID);
    	}
    	catch(Exception ex)
    	{
    		throw new AFBOException(ex);
    	}	
    }
    
    
    
    
    /**
     * 
     * 方法描述:删除消息队列记录，消息归档表置为已读
     *
     * @param userToken
     * @param message_id
     * @param empID
     * @return
     * @throws AFBOException
     * date:Sep 7, 2009
     * @see: 
     * @author: 高步伦
     */
    public boolean deleteMsgAddress(AFUserToken userToken, long message_id,long empID)
    throws AFBOException
	{
    	try
    	{   
    	    boolean result;
		    result = true;

		    if(result)
		        result = dao_UserdeskSet.deleteMsgAddress(message_id,empID);  //删除发送地址表记录
		    if(result)
		    	result = dao_UserdeskSet.updateMsgArc(message_id,empID);   //修改传递日志表记录为已读
		    
		    List list=dao_UserdeskSet.searchMsgAddress(message_id);   //查询该队列里是否还有发送地址的记录
		    
		    if(list.size()==0 || list==null)
		    {
		    	if(result)
			        result = dao_UserdeskSet.deleteMsgQueue(message_id); //删除消息队列表记录
		    	//if(result)
			    //    result = dao_UserdeskSet.updateMsgArc(message_id);   //修改消息归档表位已读
		    }

		    return result;
		}
		catch(Exception ex)
		{
			throw new AFBOException(ex);
	}
	}
}