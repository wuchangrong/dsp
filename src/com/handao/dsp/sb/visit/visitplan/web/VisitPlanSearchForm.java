package com.handao.dsp.sb.visit.visitplan.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
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
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��EAPSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��AFDataFormat�������������ת��
     * @return EAPSearchCustomerCondition
     */	    
    public AFSearchCustomerCondition getCustomCondition(){
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("ROW_ID", AFDataFormat.toInt(ROW_ID));
        //cc.put("STATUS", STATUS);  
        return cc;
    }
}