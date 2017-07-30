package com.handao.dsp.sb.visit.visitrecord.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class VisitRecordSearchForm extends AFSearchForm{
    
	private String ROW_ID; 
	private String CUSTOMER_CODE;  //�ͻ�����
	private String CUSTOMER_DESC ;  //�ͻ�����
	private String CUSTOMER_TEL;  //�绰
	private String VISIT_TYPE;  //�ݷ���ʽ 1�طÿͻ�  2���ܲ�Ʒ  3�߷ÿͻ�  4�Ӵ��ͻ�
	private String IS_USING;  //�Ƿ���Ч
	private String STATUS;  //״̬:0 ��ʼ��1 �ύ  2�طá�	
	private String VISIT_DATE ;  //�ݷ�����
	private String VISIT_DATE_B = "";  //�ݷ����ڿ�ʼ
	private String VISIT_DATE_E = "";  //�ݷ����ڽ���	

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
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��EAPSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��AFDataFormat�������������ת��
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