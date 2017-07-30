package com.handao.platform.sm.privilege.user.vo;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.vo.AFCompositeValueObject;

public class AFUserVO extends AFCompositeValueObject
{
	private static final long serialVersionUID = 1L;
	
	private long row_id;  //ROW_ID
	private String user_code;  //用户代码
	private String user_name;  //用户名称
	private String attr_flag;  //分类属性标志
	private String attr_flag_name; //分类属性
	private long company_id;  //公司ID
    private long division_id;
	private long person_id;  //人员ID
	private String password;  //密码
	private String passwordJudge; //验证密码
    private String cert_yn;     //证书验证标志
    private String cert_yn_name;//证书验证标志
	private String cert_serialno;  //证书序列号
	private String email;  //电子邮件地址
	private String mobile;  //手机号
	private String contact_phone;  //联系电话
	private String fax;  //传真
	private Date inure_date;  //生效日期
	private Date abate_date;  //失效日期
	private String using_flag;  //启用标志
	private String using_flag_name;//启用标志
	private String remark;  //备注
	private Date create_date;  //创建日期
	private String resultFlag;//检查结果标志，用户返回证书验证结果
	private String resultMsg;//返回结果信息
	private String randomsigndata;
	private String signcert;
	private long create_user_id;
	//伪劣，用于界面显示
	private String company_name;
	private String division_name;
	private String person_name;
	

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public long getDivision_id() {
        return division_id;
    }

    public void setDivision_id(long division_id) {
        this.division_id = division_id;
    }

    public String getPasswordJudge() {
		return passwordJudge;
	}

	public void setPasswordJudge(String passwordJudge) {
		this.passwordJudge = passwordJudge;
	}

	public long getRow_id()
	{
		return row_id;
	}

	public void setRow_id(long row_id)
	{
		this.row_id = row_id;
	}

	public String getUser_code()
	{
		return user_code;
	}

	public void setUser_code(String user_code)
	{
		this.user_code = user_code;
	}

	public String getUser_name()
	{
		return user_name;
	}

	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}

	public String getAttr_flag()
	{
		return attr_flag;
	}

	public void setAttr_flag(String attr_flag)
	{
		this.attr_flag = attr_flag;
	}

	public String getAttr_flag_name() {
		return attr_flag_name;
	}

	public void setAttr_flag_name(String attr_flag_name) {
		this.attr_flag_name = attr_flag_name;
	}

	public long getCompany_id()
	{
		return company_id;
	}

	public void setCompany_id(long company_id)
	{
		this.company_id = company_id;
	}

	public long getPerson_id()
	{
		return person_id;
	}

	public void setPerson_id(long person_id)
	{
		this.person_id = person_id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getCert_serialno()
	{
		return cert_serialno;
	}

	public void setCert_serialno(String cert_serialno)
	{
		this.cert_serialno = cert_serialno;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getContact_phone()
	{
		return contact_phone;
	}

	public void setContact_phone(String contact_phone)
	{
		this.contact_phone = contact_phone;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public Date getInure_date()
	{
		return inure_date;
	}

	public void setInure_date(Date inure_date)
	{
		this.inure_date = inure_date;
	}

	public Date getAbate_date()
	{
		return abate_date;
	}

	public void setAbate_date(Date abate_date)
	{
		this.abate_date = abate_date;
	}

	public String getUsing_flag()
	{
		return using_flag;
	}

	public void setUsing_flag(String using_flag)
	{
		this.using_flag = using_flag;
	}

	
	public String getUsing_flag_name() {
		return using_flag_name;
	}

	public void setUsing_flag_name(String using_flag_name) {
		this.using_flag_name = using_flag_name;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Date getCreate_date()
	{
		return create_date;
	}

	public void setCreate_date(Date create_date)
	{
		this.create_date = create_date;
	}

    public String getCert_yn() {
        return cert_yn;
    }

    public void setCert_yn(String cert_yn) {
        this.cert_yn = cert_yn;
    }

    public String getCert_yn_name()
    {
        return cert_yn_name;
    }

    public void setCert_yn_name(String cert_yn_name)
    {
        this.cert_yn_name = cert_yn_name;
    }

    public String getResultFlag()
    {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag)
    {
        this.resultFlag = resultFlag;
    }

    public String getResultMsg()
    {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg)
    {
        this.resultMsg = resultMsg;
    }

    public String getRandomsigndata()
    {
        return randomsigndata;
    }

    public void setRandomsigndata(String randomsigndata)
    {
        this.randomsigndata = randomsigndata;
    }

    public String getSigncert()
    {
        return signcert;
    }

    public void setSigncert(String signcert)
    {
        this.signcert = signcert;
    }

  private List dl_AFUserRole = new ArrayList();
	private List dl_AFAvailableRole = new ArrayList();

	public List getDl_AFUserRole() {
		return dl_AFUserRole;
	}

	public void setDl_AFUserRole(List dl_AFUserRole) {
		this.dl_AFUserRole = dl_AFUserRole;
	}

	public List getDl_AFAvailableRole() {
		return dl_AFAvailableRole;
	}

	public void setDl_AFAvailableRole(List dl_AFAvailableRole) {
		this.dl_AFAvailableRole = dl_AFAvailableRole;
	}
	
	public List[] getDetailList() {
		return new List[] {dl_AFAvailableRole,dl_AFUserRole};
	}
	public void setDetailList(String detailVOClass, List list) {
	
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public long getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(long create_user_id) {
		this.create_user_id = create_user_id;
	}
		
}
