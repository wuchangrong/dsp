package com.handao.dsp.sb.daily.route.bo;

import java.util.List;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.bo.AFBizCompositeBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.dsp.sb.daily.route.dao.RouteDailyDAO;
import com.handao.dsp.sb.daily.route.vo.RouteDailyVO;
import com.handao.dsp.sb.daily.route.vo.RouteDailyDetailVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class RouteDailyBO extends AFBizCompositeBO{	
	
	private RouteDailyDAO dao_RouteDaily = (RouteDailyDAO)AFDAOProvider.getDAOByClass(
	         "com.handao.dsp.sb.daily.route.dao.RouteDailyDAO");
	
	private RouteDailyDetailBO bo_RouteDailyDetail = (RouteDailyDetailBO)AFBOProvider.getBOByClass(
	         "com.handao.dsp.sb.daily.route.bo.RouteDailyDetailBO");
    
    public RouteDailyBO(){
        this.addListener(new AFBizBOListenerImpl(){
       	    /**
        	 * @desc 插入前业务逻辑接口，完成数据唯一性校验，完成主从表的主键设置
        	 * @param AFUserToken，AFValueObject
        	 * @return boolean
        	 * @author liguozhi
        	 */
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo){
            	
            	int masterID = AFIDFactory.getNextID();
            	RouteDailyVO masterVO = (RouteDailyVO)vo;
                masterVO.setROW_ID(masterID);
                masterVO.setCREATED_BY(userToken.getUserId());
                masterVO.setIS_USING("Y");
                masterVO.setSTATUS("0");
                List dl_RouteDailyDetail = masterVO.getDetailList_RouteDailyDetail();
                
                for(int i=0; i<dl_RouteDailyDetail.size(); i++){
                	RouteDailyDetailVO vo_new = (RouteDailyDetailVO)dl_RouteDailyDetail.get(i);
                    //vo_new.setROW_ID(AFIDFactory.getNextID());
                    vo_new.setDAILY_ID(masterID);
                    vo_new.setCREATED_BY(userToken.getUserId());
                    vo_new.setCOMPANY_ID(masterVO.getCOMPANY_ID());
                    vo_new.setDEPT_ID(masterVO.getDEPT_ID());
                    vo_new.setVISIT_DATE(masterVO.getVISIT_DATE());
                    vo_new.setIS_USING(masterVO.getIS_USING());
                    vo_new.setSTATUS(masterVO.getSTATUS());
                    logger.logDebug("vo_new.getBEGIN_TIME()=="+vo_new.getBEGIN_TIME());
                }
                return true;
            }

            /**
        	 * @desc 更新前业务逻辑，完成主表数据的插入以及从表数据的删除，更新，插入
        	 * @param AFUserToken，AFValueObject
        	 * @return boolean
        	 * @author liguozhi
        	 */
            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo){
                
            	RouteDailyVO masterVO = (RouteDailyVO)vo;
            	int masterID = masterVO.getROW_ID();
            	((RouteDailyVO)vo).setLAST_UPD_BY(userToken.getUserId());
                List dl_RouteDailyDetail_new = ((RouteDailyVO)vo).getDetailList_RouteDailyDetail();
                List dl_RouteDailyDetail_src = bo_RouteDailyDetail.doSearchByMaster(masterID);
                for(int i = 0; i < dl_RouteDailyDetail_new.size(); i++){
                	RouteDailyDetailVO detailVO_new = (RouteDailyDetailVO)dl_RouteDailyDetail_new.get(i);
                	logger.logDebug("vo_new.getBEGIN_TIME()=="+detailVO_new.getBEGIN_TIME());
                    boolean insertFlag = true;
                    for(int j = 0; j < dl_RouteDailyDetail_src.size();){
                    	RouteDailyDetailVO detailVO_src = (RouteDailyDetailVO)dl_RouteDailyDetail_src.get(j);
                        if(detailVO_new.getROW_ID()==detailVO_src.getROW_ID()){
                            detailVO_new.setVOStatus(AFValueObject.STATUS_MODIFY);
                            detailVO_new.setLAST_UPD_BY(userToken.getUserId());
                            dl_RouteDailyDetail_src.remove(j);
                            insertFlag = false;
                            break;
                        }
                        j++;
                    }
                    if(insertFlag){
                        //detailVO_new.setROW_ID(AFIDFactory.getNextID());
                        detailVO_new.setDAILY_ID(masterID);
                        detailVO_new.setLAST_UPD_BY(userToken.getUserId());
                        detailVO_new.setCOMPANY_ID(masterVO.getCOMPANY_ID());
                        detailVO_new.setDEPT_ID(masterVO.getDEPT_ID());
                        detailVO_new.setVISIT_DATE(masterVO.getVISIT_DATE());
                        detailVO_new.setIS_USING(masterVO.getIS_USING());
                        detailVO_new.setSTATUS(masterVO.getSTATUS());                        
                        detailVO_new.setVOStatus(AFValueObject.STATUS_NEW);
                    }
                }
                for(int i = 0; i < dl_RouteDailyDetail_src.size(); i++) {
                	RouteDailyDetailVO detailVO_src = (RouteDailyDetailVO)dl_RouteDailyDetail_src.get(i);
                    detailVO_src.setVOStatus(AFValueObject.STATUS_DELETE);
                    dl_RouteDailyDetail_new.add(0,detailVO_src);
                }
                return true;
            }
        });
    }

    /**
	 * @desc 返回当前活动DAO
	 * @return AFBizDAO
	 * @author liguozhi
	 */
    protected AFBizDAO getActiveDAO(){
        return dao_RouteDaily;
    }

    /**
	 * @desc 返回当前BO的子BO集
	 * @return AFBizBO[]
	 * @author liguozhi
	 */
    protected AFBizBO[] getDetailBO(){
        return new AFBizBO[] {bo_RouteDailyDetail};
    }

    /**
	 * @desc 根据指定VOClass返回对应的操作BO
	 * @param  detailVOClass
	 * @return AFBizBO
	 * @author liguozhi
	 */
    protected AFBizBO getOperateBO(String detailVOClass){        
    	if(RouteDailyDetailVO.class.getName().equals(detailVOClass)){
            return bo_RouteDailyDetail;
        }
        return null;
    }
	
    
}