package com.handao.platform.sm.userdesk.userdeskSet.vo;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFSearchVO;


public class UserdeskSetSearchVO extends AFSearchVO {


    private String m_GROUP_CODE;  //�������
    private String m_GROUP_NAME;  //��������
    private String m_ROLE_ID;  //�û�ID
    
    /**
     * [������󷽷�ʵ��]
     * ���Զ����ѯ������װ��AFSearchCustomerCondition��������
     * ע�� 1����Ҫ����ѯ�ֶ�ת��Ϊǿ����
     * ע�� 2������ʹ��AFDataFormat�������������ת��
     * @return AFSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();

        cc.put("m_GROUP_CODE", m_GROUP_CODE);
        cc.put("m_GROUP_NAME", m_GROUP_NAME);
        cc.put("m_ROLE_ID", AFDataFormat.toLong(m_ROLE_ID));
        return cc;
    }

	public String getM_GROUP_CODE() {
		return m_GROUP_CODE;
	}

	public void setM_GROUP_CODE(String m_group_code) {
		m_GROUP_CODE = m_group_code;
	}

	public String getM_GROUP_NAME() {
		return m_GROUP_NAME;
	}

	public void setM_GROUP_NAME(String m_group_name) {
		m_GROUP_NAME = m_group_name;
	}

	public String getM_ROLE_ID() {
		return m_ROLE_ID;
	}

	public void setM_ROLE_ID(String m_role_id) {
		m_ROLE_ID = m_role_id;
	}
   
   

}