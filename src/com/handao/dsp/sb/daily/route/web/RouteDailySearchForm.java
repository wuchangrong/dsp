package com.handao.dsp.sb.daily.route.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailySearchForm extends AFSearchForm{
    
    private String ROW_ID;     
	private String STATUS;  //״̬
	private String VISIT_DATE ;  //�ݷ�����
	private String VISIT_DATE_B = "";  //�ݷ����ڿ�ʼ
	private String VISIT_DATE_E = "";  //�ݷ����ڽ���	  
   
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
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��EAPSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��AFDataFormat�������������ת��
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