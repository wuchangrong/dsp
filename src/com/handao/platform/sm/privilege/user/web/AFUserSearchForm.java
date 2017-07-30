package com.handao.platform.sm.privilege.user.web;

import com.handao.platform.framework.envelope.AFSearchCustomerCondition;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.web.AFSearchForm;

public class AFUserSearchForm extends AFSearchForm
{
	private static final long serialVersionUID = 1L;
	
	private String company_id;
    private String using_flag;
    private String user_code;
    private String user_name;
    private String inure_date;

    public String getInure_date() {
		return inure_date;
	}

	public void setInure_date(String inureDate) {
		inure_date = inureDate;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUsing_flag() {
        return using_flag;
    }

    public void setUsing_flag(String using_flag) {
        this.using_flag = using_flag;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    
    public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	/**
     * [父类抽象方法实现]
     * 把自定义查询条件封装成AFSearchCustomerCondition，并返回
     * 注意 1：需要将查询字段转化为强类型
     * 注意 2：建议使用AFDataFormat类进行数据类型转换
     * @return AFSearchCustomerCondition
     */
    public AFSearchCustomerCondition getCustomCondition() {
        AFSearchCustomerCondition cc = new AFSearchCustomerCondition();
        cc.put("company_id", AFDataFormat.toLong(company_id));
        cc.put("using_flag", using_flag);
        cc.put("user_code",user_code);
        cc.put("user_name",user_name);
        cc.put("inure_date",AFDataFormat.toDate(inure_date));
        return cc;
    }

}