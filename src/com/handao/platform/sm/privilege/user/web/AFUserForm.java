package com.handao.platform.sm.privilege.user.web;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFCompositeForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;
import com.handao.platform.sm.privilege.user.vo.AFUserVO;

public class AFUserForm extends AFCompositeForm implements AFSearchOperation
{
	private static final long serialVersionUID = 1L;
	
	private String doWhat = null;
	private String doFocus= "user_code";

	private String row_id;  //ROW_ID
	private String user_code;  //�û�����
	private String user_name;  //�û�����
	private String attr_flag;  //�������Ա�־
	private String attr_flag_name; //��������
	private String company_id;  //��˾ID
	private String division_id;  //����ID
	private String person_id;  //��ԱID
	private String password;  //����
	private String passwordJudge;//��֤����
    private String cert_yn;     //֤����֤
    private String cert_yn_name;     //֤����֤
	private String cert_serialno;  //֤�����к�
	private String email;  //�����ʼ���ַ
	private String mobile;  //�ֻ���
	private String contact_phone;  //��ϵ�绰
	private String fax;  //����
	private String inure_date;  //��Ч����
	private String abate_date;  //ʧЧ����
	private String using_flag;  //���ñ�־
	private String using_flag_name;  //���ñ�־
	private String remark;  //��ע
	private String create_date;  //��������
    private String whichModule;//�����ж����ĸ�����ģ����õĲ鿴��ť
    private String temp_password;
    //������ʾα��
    private String company_name;
    private String division_name;
    private String person_name;
    
    public AFUserForm(){
    	initSearchForm();
    }   

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }

    public String getTemp_password() {
        return temp_password;
    }

    public void setTemp_password(String temp_password) {
        this.temp_password = temp_password;
    }

    public String getWhichModule() {
        return whichModule;
    }

    public void setWhichModule(String whichModule) {
        this.whichModule = whichModule;
    }

	public String getRow_id()
	{
		return row_id;
	}

	public void setRow_id(String row_id)
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

	public String getCompany_id()
	{
		return company_id;
	}

	public void setCompany_id(String company_id)
	{
		this.company_id = company_id;
	}

	public String getPerson_id()
	{
		return person_id;
	}

	public void setPerson_id(String person_id)
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

	
	public String getPasswordJudge() {
		return passwordJudge;
	}

	public void setPasswordJudge(String passwordJudge) {
		this.passwordJudge = passwordJudge;
	}

	
	public String getCert_yn_name() {
		return cert_yn_name;
	}

	public void setCert_yn_name(String cert_yn_name) {
		this.cert_yn_name = cert_yn_name;
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

	public String getInure_date()
	{
		return inure_date;
	}

	public void setInure_date(String inure_date)
	{
		this.inure_date = inure_date;
	}

	public String getAbate_date()
	{
		return abate_date;
	}

	public void setAbate_date(String abate_date)
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

	public String getCreate_date()
	{
		return create_date;
	}

	public void setCreate_date(String create_date)
	{
		this.create_date = create_date;
	}


    public String getDoWhat()
    {
        return doWhat;
    }

    public void setDoWhat(String doWhat)
    {
        this.doWhat = doWhat;
    }

	public String getDoFocus()
	{
		return doFocus;
	}

	public void setDoFocus(String doFocus)
	{
		this.doFocus = doFocus;
	}

	
    public String getCert_yn() {
        return cert_yn;
    }

    public void setCert_yn(String cert_yn) {
        this.cert_yn = cert_yn;
    }

   /*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "SM_PRIVILEGE_USER_AFUserForm";
    }

    /**
     * [�ӿڷ���ʵ��]
     * ���ز�ѯ��
     * @return AFSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��AFDataFormat.parseString()��������ת��
     * @return AFValueObject
     */
    public AFValueObject transform() {
        AFUserVO vo = new AFUserVO();
        vo.setRow_id(AFDataFormat.parseString(row_id, vo.getRow_id()));
        vo.setUser_code(AFDataFormat.parseString(user_code, vo.getUser_code()));
        vo.setUser_name(AFDataFormat.parseString(user_name, vo.getUser_name()));
        vo.setAttr_flag(AFDataFormat.parseString(attr_flag, vo.getAttr_flag()));
        vo.setAttr_flag_name(AFDataFormat.parseString(attr_flag_name, vo.getAttr_flag_name()));
        vo.setCompany_id(AFDataFormat.parseString(company_id, vo.getCompany_id()));
        vo.setDivision_id(AFDataFormat.parseString(division_id, vo.getDivision_id()));
        vo.setPerson_id(AFDataFormat.parseString(person_id, vo.getPerson_id()));
        vo.setPassword(AFDataFormat.parseString(password, vo.getPassword()));
        vo.setPasswordJudge(AFDataFormat.parseString(passwordJudge, vo.getPasswordJudge()));
        vo.setCert_yn(AFDataFormat.parseString(cert_yn, vo.getCert_yn()));
        vo.setCert_yn_name(AFDataFormat.parseString(cert_yn_name, vo.getCert_yn_name()));
        vo.setCert_serialno(AFDataFormat.parseString(cert_serialno, vo.getCert_serialno()));
        vo.setEmail(AFDataFormat.parseString(email, vo.getEmail()));
        vo.setMobile(AFDataFormat.parseString(mobile, vo.getMobile()));
        vo.setContact_phone(AFDataFormat.parseString(contact_phone, vo.getContact_phone()));
        vo.setFax(AFDataFormat.parseString(fax, vo.getFax()));
        vo.setInure_date(AFDataFormat.parseString(inure_date, vo.getInure_date()));
        vo.setAbate_date(AFDataFormat.parseString(abate_date, vo.getAbate_date()));
        vo.setUsing_flag(AFDataFormat.parseString(using_flag, vo.getUsing_flag()));
        vo.setUsing_flag_name(AFDataFormat.parseString(using_flag_name, vo.getUsing_flag_name()));
        vo.setCreate_date(AFDataFormat.parseString(create_date, vo.getCreate_date()));
        vo.setRemark(AFDataFormat.parseString(remark, vo.getRemark()));   
        
        vo.setDl_AFUserRole(this.transformDetail(dl_AFUserRole));
        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        AFUserVO vo = (AFUserVO)_vo;
        row_id = AFDataFormat.toString(vo.getRow_id());
        user_code = AFDataFormat.toString(vo.getUser_code());
        user_name = AFDataFormat.toString(vo.getUser_name());
        attr_flag = AFDataFormat.toString(vo.getAttr_flag());
        attr_flag_name = AFDataFormat.toString(vo.getAttr_flag_name());
        company_id = AFDataFormat.toString(vo.getCompany_id());
        division_id = AFDataFormat.toString(vo.getDivision_id());
        person_id = AFDataFormat.toString(vo.getPerson_id());
        password = AFDataFormat.toString(vo.getPassword());
        passwordJudge = AFDataFormat.toString(vo.getPasswordJudge());
        cert_yn = AFDataFormat.toString(vo.getCert_yn());
        cert_yn_name = AFDataFormat.toString(vo.getCert_yn_name());
        cert_serialno = AFDataFormat.toString(vo.getCert_serialno());
        email = AFDataFormat.toString(vo.getEmail());
        mobile = AFDataFormat.toString(vo.getMobile());
        contact_phone = AFDataFormat.toString(vo.getContact_phone());
        fax = AFDataFormat.toString(vo.getFax());
        inure_date = AFDataFormat.toString(vo.getInure_date());
        abate_date = AFDataFormat.toString(vo.getAbate_date());
        using_flag = AFDataFormat.toString(vo.getUsing_flag());
        using_flag_name = AFDataFormat.toString(vo.getUsing_flag_name());
        create_date = AFDataFormat.toString(vo.getCreate_date());
        remark = AFDataFormat.toString(vo.getRemark());
        //α��
        company_name = vo.getCompany_name();
        division_name = vo.getDivision_name();
        person_name = vo.getPerson_name();        

        dl_AFUserRole = this.transformDetail(vo.getDl_AFUserRole(), AFUserRoleForm.class.getName());
		dl_AFAvailableRole = this.transformDetail(vo.getDl_AFAvailableRole(), AFUserRoleForm.class.getName());
    }

    /**
     * [������󷽷�ʵ��]
     * ��ʼ��������
     */
    public void initialize() {
    	row_id = "";
    	user_code = "";
    	user_name = "";
    	attr_flag = "";
    	attr_flag_name = "";
    	company_id = "";
    	division_id = "";
    	person_id = "";
    	password = "";
    	passwordJudge = "";
    	cert_yn = "";
    	cert_yn_name = "";
    	cert_serialno = "";
    	email = "";
    	mobile = "";
    	contact_phone = "";
    	fax = "";
    	inure_date = "";
    	abate_date = "";
    	using_flag = "";
    	using_flag_name = "";
    	create_date = "";
    	remark = "";
    }

    /*************************************** customer ***************************************/
    private AFUserSearchForm searchForm = null;
    //��ʼ��searchForm
    public void initSearchForm(){
    	searchForm = new AFUserSearchForm();
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
		return new List[] {dl_AFUserRole};
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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

	
	
}

