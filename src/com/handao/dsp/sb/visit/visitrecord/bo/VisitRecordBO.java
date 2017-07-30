package com.handao.dsp.sb.visit.visitrecord.bo;

import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFAdvancedString;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.dsp.sb.visit.visitrecord.dao.VisitRecordDAO;
import com.handao.dsp.sb.visit.visitrecord.vo.VisitRecordVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class VisitRecordBO extends AFBizBO {

    private VisitRecordDAO dao_VisitRecord = (VisitRecordDAO)AFDAOProvider.getDAOByClass(
    "com.handao.dsp.sb.visit.visitrecord.dao.VisitRecordDAO");   

	  public VisitRecordBO(){		
		  this.addListener(new AFBizBOListenerImpl(){
            /**
             * [AFBizBOListenerImpl类方法复写]
             */		  	
			  public boolean beforeInsert(AFUserToken userToken,AFValueObject vo){
				    ((VisitRecordVO)vo).setROW_ID(AFIDFactory.getNextID());
				    ((VisitRecordVO)vo).setCREATED_BY(userToken.getUserId());
				    ((VisitRecordVO)vo).setIS_USING("Y");
				    ((VisitRecordVO)vo).setSTATUS("0");				    
				    return true;
			  }
			  
			  public boolean beforeUpdate(AFUserToken userToken,AFValueObject vo){
			  	  ((VisitRecordVO)vo).setLAST_UPD_BY(userToken.getUserId());
				    return true;
			  }
			  
			  public void beforeSearch(AFUserToken userToken,AFSearchCondition sc){

			  }	
			  
			  public void afterSearch(AFUserToken userToken, AFSearchCondition sc, AFPage page) {
				  List list =page.getList();
				  for (int i =0 ;i<list.size(); i++){
					  VisitRecordVO vo = (VisitRecordVO)list.get(i);
					  
					  String origin_flag = AFAdvancedString.trim(vo.getORIGIN_FLAG()).equals("")?"0":vo.getORIGIN_FLAG();
					  switch (Integer.parseInt(origin_flag)) {
						  case 0: vo.setORIGIN_FLAG_DESC("录入"); break;
						  case 1: vo.setORIGIN_FLAG_DESC("短信"); break;
						  default: vo.setORIGIN_FLAG_DESC("未知");
					  }					  
				  }
			  }
			  			  
		  });
	  }
	
   /**
	* 根据vo更新status
    * 
	* @return boolean
	*/   	  
    public boolean doUpdateStatusByVO(AFUserToken userToken, AFValueObject vo) throws AFBOException {
	    try {
	        boolean result = dao_VisitRecord.doUpdateStatusByVO(vo);;

	        return result;
	    }
	    catch (Exception ex) {
	        throw new AFBOException(ex);
	    }
    }  
    
    protected AFBizDAO getActiveDAO(){
		  return dao_VisitRecord;
	  }	
	
}