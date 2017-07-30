package com.handao.dsp.md.directory.directoryman.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */
public class DirectorySearchForm extends AFSearchForm{
    
	private String PARENT_DIR_ID;
	private String PARENT_DIR_NAME;
	private String DIRECLA_CODE;
	
	public String getPARENT_DIR_ID() {
	    return PARENT_DIR_ID;
    }

	public void setPARENT_DIR_ID(String row_id) {
		PARENT_DIR_ID = row_id;
	}	
     
    public String getDIRECLA_CODE() {
		return DIRECLA_CODE;
	}

	public void setDIRECLA_CODE(String direcla_code) {
		DIRECLA_CODE = direcla_code;
	}

	public String getPARENT_DIR_NAME() {
		return PARENT_DIR_NAME;
	}

	public void setPARENT_DIR_NAME(String parent_dir_name) {
		PARENT_DIR_NAME = parent_dir_name;
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
        cc.put("PARENT_DIR_ID", AFDataFormat.toInt(PARENT_DIR_ID));
        cc.put("PARENT_DIR_NAME", PARENT_DIR_NAME);  
        cc.put("DIRECLA_CODE", DIRECLA_CODE);  
        return cc;
    }
}