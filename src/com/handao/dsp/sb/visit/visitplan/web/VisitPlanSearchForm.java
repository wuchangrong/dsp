package com.handao.dsp.sb.visit.visitplan.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class VisitPlanSearchForm extends AFSearchForm{
    
	private String ROW_ID;     
	
	public String getROW_ID() {
	    return ROW_ID;
    }

	public void setROW_ID(String row_id) {
		ROW_ID = row_id;
	}	
     
    /**
     * [父类抽象方法实现]
     * 把自定义查询条件封装成EAPSearchCustomerCondition，并返回
     * 注意 1：需要将查询字段转化为强类型
     * 注意 2：建议使用AFDataFormat类进行数据类型转换
     * @return EAPSearchCustomerCondition
     */	    
    public AFSearchCustomerCondition getCustomCondition(){
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("ROW_ID", AFDataFormat.toInt(ROW_ID));
        //cc.put("STATUS", STATUS);  
        return cc;
    }
}