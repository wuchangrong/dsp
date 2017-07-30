package com.handao.dsp.sb.visit.visitplan.bo;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.dsp.sb.visit.visitplan.dao.VisitPlanDAO;
import com.handao.dsp.sb.visit.visitplan.vo.VisitPlanVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class VisitPlanBO extends AFBizBO {

    private VisitPlanDAO dao_VisitPlan = (VisitPlanDAO)AFDAOProvider.getDAOByClass(
    "com.handao.dsp.sb.visit.visitplan.dao.VisitPlanDAO");   

	  public VisitPlanBO(){		
		  this.addListener(new AFBizBOListenerImpl(){
            /**
             * [AFBizBOListenerImpl类方法复写]
             */		  	
			  public boolean beforeInsert(AFUserToken userToken,AFValueObject vo){
				    ((VisitPlanVO)vo).setROW_ID(AFIDFactory.getNextID());
				    ((VisitPlanVO)vo).setCREATED_BY(userToken.getUserId());
				    return true;
			  }
			  
			  public boolean beforeUpdate(AFUserToken userToken,AFValueObject vo){
			  	  ((VisitPlanVO)vo).setLAST_UPD_BY(userToken.getUserId());
				    return true;
			  }
		  });
	  }
	
    protected AFBizDAO getActiveDAO(){
		  return dao_VisitPlan;
	  }	
	
}