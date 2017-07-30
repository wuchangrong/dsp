package com.handao.dsp.sb.visit.visitrecord.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class VisitRecordSearchForm extends AFSearchForm{
    
	private String ROW_ID; 
	private String CUSTOMER_CODE;  //客户代码
	private String CUSTOMER_DESC ;  //客户名称
	private String CUSTOMER_TEL;  //电话
	private String VISIT_TYPE;  //拜访形式 1回访客户  2介绍产品  3走访客户  4接待客户
	private String IS_USING;  //是否有效
	private String STATUS;  //状态:0 初始，1 提交  2回访。	
	private String VISIT_DATE ;  //拜访日期
	private String VISIT_DATE_B = "";  //拜访日期开始
	private String VISIT_DATE_E = "";  //拜访日期结束	

	public String getROW_ID() {
	    return ROW_ID;
    }

	public void setROW_ID(String row_id) {
		ROW_ID = row_id;
	}		
	public String getCUSTOMER_CODE() {
		return CUSTOMER_CODE;
	}

	public void setCUSTOMER_CODE(String customer_code) {
		CUSTOMER_CODE = customer_code;
	}

	public String getCUSTOMER_DESC() {
		return CUSTOMER_DESC;
	}

	public void setCUSTOMER_DESC(String customer_desc) {
		CUSTOMER_DESC = customer_desc;
	}

	public String getCUSTOMER_TEL() {
		return CUSTOMER_TEL;
	}

	public void setCUSTOMER_TEL(String customer_tel) {
		CUSTOMER_TEL = customer_tel;
	}

	public String getVISIT_TYPE() {
		return VISIT_TYPE;
	}

	public void setVISIT_TYPE(String visit_type) {
		VISIT_TYPE = visit_type;
	}

	public String getIS_USING() {
		return IS_USING;
	}

	public void setIS_USING(String is_using) {
		IS_USING = is_using;
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
        System.out.println("ccccccccccccccccccccccccccccccccccccccccc==="+CUSTOMER_CODE);
        cc.put("ROW_ID", AFDataFormat.toInt(ROW_ID));
        cc.put("CUSTOMER_CODE", CUSTOMER_CODE);
        cc.put("CUSTOMER_DESC", CUSTOMER_DESC);
        cc.put("CUSTOMER_TEL", CUSTOMER_TEL);
        cc.put("VISIT_TYPE", VISIT_TYPE);
        cc.put("IS_USING", IS_USING);
        cc.put("STATUS", STATUS);
        cc.put("VISIT_DATE", AFDataFormat.toDate(VISIT_DATE));
        cc.put("VISIT_DATE_B", AFDataFormat.toDate(VISIT_DATE_B));
        cc.put("VISIT_DATE_E", AFDataFormat.toDate(VISIT_DATE_E));
        
        return cc;
    }


}