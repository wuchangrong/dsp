package com.handao.dsp.md.directory.directoryman.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
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
     * [父类抽象方法实现]
     * 把自定义查询条件封装成EAPSearchCustomerCondition，并返回
     * 注意 1：需要将查询字段转化为强类型
     * 注意 2：建议使用AFDataFormat类进行数据类型转换
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