package com.handao.dsp.sb.daily.route.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailySearchForm extends AFSearchForm{
    
    private String ROW_ID;     
	private String STATUS;  //状态
	private String VISIT_DATE ;  //拜访日期
	private String VISIT_DATE_B = "";  //拜访日期开始
	private String VISIT_DATE_E = "";  //拜访日期结束	  
   
	public String getROW_ID() {
	    return ROW_ID;
    }

	public void setROW_ID(String row_id) {
		ROW_ID = row_id;
	}		
  
	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String status) {
		STATUS = status;
	}
	
	public String getVISIT_DATE() {
		return VISIT_DATE;
	}

	public void setVISIT_DATE(String visit_date) {
		VISIT_DATE = visit_date;
	}
	
	public String getVISIT_DATE_B() {
		return VISIT_DATE_B;
	}

	public void setVISIT_DATE_B(String visit_date_b) {
		VISIT_DATE_B = visit_date_b;
	}

	public String getVISIT_DATE_E() {
		return VISIT_DATE_E;
	}

	public void setVISIT_DATE_E(String visit_date_e) {
		VISIT_DATE_E = visit_date_e;
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
        cc.put("STATUS", STATUS);
        cc.put("VISIT_DATE", AFDataFormat.toDate(VISIT_DATE));
        cc.put("VISIT_DATE_B", AFDataFormat.toDate(VISIT_DATE_B));
        cc.put("VISIT_DATE_E", AFDataFormat.toDate(VISIT_DATE_E));
        return cc;
    }
}