package com.handao.dsp.sb.visit.visitplan.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

import com.handao.dsp.sb.visit.visitplan.vo.VisitPlanVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 17, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class VisitPlanForm extends AFForm implements AFSearchOperation {

    /*************************************** field ***************************************/
	private String ROW_ID = "";  //行号
	private String CREATED_BY = "";  //创建人
	private String CREATED_TIME = "";  //创建时间
	private String LAST_UPD_BY = "";  //最近修改人
	private String LAST_UPD_TIME = "";  //最近修改时间
	private String MODIFICATION_NUM = "";  //修改次数
	private String COMPANY_ID = "";  //公司标识
	private String DEPT_ID = "";  //部门标识
	private String VISIT_DATE = "";  //拜访日期
	private String VISITOR_ID = "";  //拜访人ID
	private String VISITOR_NAME = "";  //拜访人姓名
	private String CUSTOMER_ID = "";  //客户ID
	private String CUSTOMER_CODE = "";  //客户代码
	private String CUSTOMER_DESC = "";  //客户名称
	private String CUSTOMER_TEL = "";  //客户电话
	private String SUBJECT = "";  //拜访主题
	private String VISIT_TYPE = "";  //拜访形式 1回访客户  2介绍产品  3走访客户  4接待客户
	private String WORK_CONTENT = "";  //拜访内容
	private String FEEDBACK = "";  //情况反馈
	private String RESERVE1 = "";
	private String RESERVE2 = "";
	private String RESERVE3 = "";
	private String IS_USING = "";  //是否有效
	private String STATUS = "";  //状态:0 初始，1 提交 2 反馈  3完成。

	public String getROW_ID(){
		return ROW_ID;
	}

	public void setROW_ID(String row_id){
		ROW_ID = row_id;
	}

	public String getCREATED_BY(){
		return CREATED_BY;
	}

	public void setCREATED_BY(String created_by){
		CREATED_BY = created_by;
	}

	public String getCREATED_TIME(){
		return CREATED_TIME;
	}

	public void setCREATED_TIME(String created_time){
		CREATED_TIME = created_time;
	}

	public String getLAST_UPD_BY(){
		return LAST_UPD_BY;
	}

	public void setLAST_UPD_BY(String last_upd_by){
		LAST_UPD_BY = last_upd_by;
	}

	public String getLAST_UPD_TIME(){
		return LAST_UPD_TIME;
	}

	public void setLAST_UPD_TIME(String last_upd_time){
		LAST_UPD_TIME = last_upd_time;
	}

	public String getMODIFICATION_NUM(){
		return MODIFICATION_NUM;
	}

	public void setMODIFICATION_NUM(String modification_num){
		MODIFICATION_NUM = modification_num;
	}

	public String getCOMPANY_ID(){
		return COMPANY_ID;
	}

	public void setCOMPANY_ID(String company_id){
		COMPANY_ID = company_id;
	}

	public String getDEPT_ID(){
		return DEPT_ID;
	}

	public void setDEPT_ID(String dept_id){
		DEPT_ID = dept_id;
	}

	public String getVISIT_DATE(){
		return VISIT_DATE;
	}

	public void setVISIT_DATE(String visit_date){
		VISIT_DATE = visit_date;
	}

	public String getVISITOR_ID(){
		return VISITOR_ID;
	}

	public void setVISITOR_ID(String visitor_id){
		VISITOR_ID = visitor_id;
	}

	public String getVISITOR_NAME(){
		return VISITOR_NAME;
	}

	public void setVISITOR_NAME(String visitor_name){
		VISITOR_NAME = visitor_name;
	}

	public String getCUSTOMER_ID(){
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(String customer_id){
		CUSTOMER_ID = customer_id;
	}

	public String getCUSTOMER_CODE(){
		return CUSTOMER_CODE;
	}

	public void setCUSTOMER_CODE(String customer_code){
		CUSTOMER_CODE = customer_code;
	}

	public String getCUSTOMER_DESC(){
		return CUSTOMER_DESC;
	}

	public void setCUSTOMER_DESC(String customer_desc){
		CUSTOMER_DESC = customer_desc;
	}

	public String getCUSTOMER_TEL(){
		return CUSTOMER_TEL;
	}

	public void setCUSTOMER_TEL(String customer_tel){
		CUSTOMER_TEL = customer_tel;
	}

	public String getSUBJECT(){
		return SUBJECT;
	}

	public void setSUBJECT(String subject){
		SUBJECT = subject;
	}

	public String getVISIT_TYPE(){
		return VISIT_TYPE;
	}

	public void setVISIT_TYPE(String visit_type){
		VISIT_TYPE = visit_type;
	}

	public String getWORK_CONTENT(){
		return WORK_CONTENT;
	}

	public void setWORK_CONTENT(String work_content){
		WORK_CONTENT = work_content;
	}

	public String getFEEDBACK(){
		return FEEDBACK;
	}

	public void setFEEDBACK(String feedback){
		FEEDBACK = feedback;
	}

	public String getRESERVE1(){
		return RESERVE1;
	}

	public void setRESERVE1(String reserve1){
		RESERVE1 = reserve1;
	}

	public String getRESERVE2(){
		return RESERVE2;
	}

	public void setRESERVE2(String reserve2){
		RESERVE2 = reserve2;
	}

	public String getRESERVE3(){
		return RESERVE3;
	}

	public void setRESERVE3(String reserve3){
		RESERVE3 = reserve3;
	}

	public String getIS_USING(){
		return IS_USING;
	}

	public void setIS_USING(String is_using){
		IS_USING = is_using;
	}

	public String getSTATUS(){
		return STATUS;
	}

	public void setSTATUS(String status){
		STATUS = status;
	}

 


    /*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "sb_visit_VisitPlanForm";
    }

    /**
     * [接口方法实现]
     * 返回查询表单
     * @return AFSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }
    
    //初始化searchForm
    public void initSearchForm(){
    	searchForm = new VisitPlanSearchForm();
    }        

    /**
     * [父类抽象方法实现]
     * 根据当前表单生成对应数据对象(VO)
     * 建议使用AFDataFormat.parseString()进行类型转换
     * @return AFValueObject
     */
    public AFValueObject transform() {
        VisitPlanVO vo = new VisitPlanVO();
        
		vo.setROW_ID(AFDataFormat.parseString(ROW_ID, vo.getROW_ID()));
		vo.setCREATED_BY(AFDataFormat.parseString(CREATED_BY, vo.getCREATED_BY()));
		vo.setCREATED_TIME(AFDataFormat.parseString(CREATED_TIME, vo.getCREATED_TIME()));
		vo.setLAST_UPD_BY(AFDataFormat.parseString(LAST_UPD_BY, vo.getLAST_UPD_BY()));
		vo.setLAST_UPD_TIME(AFDataFormat.parseString(LAST_UPD_TIME, vo.getLAST_UPD_TIME()));
		vo.setMODIFICATION_NUM(AFDataFormat.parseString(MODIFICATION_NUM, vo.getMODIFICATION_NUM()));
		vo.setCOMPANY_ID(AFDataFormat.parseString(COMPANY_ID, vo.getCOMPANY_ID()));
		vo.setDEPT_ID(AFDataFormat.parseString(DEPT_ID, vo.getDEPT_ID()));
		vo.setVISIT_DATE(AFDataFormat.parseString(VISIT_DATE, vo.getVISIT_DATE()));
		vo.setVISITOR_ID(AFDataFormat.parseString(VISITOR_ID, vo.getVISITOR_ID()));
		vo.setVISITOR_NAME(AFDataFormat.parseString(VISITOR_NAME, vo.getVISITOR_NAME()));
		vo.setCUSTOMER_ID(AFDataFormat.parseString(CUSTOMER_ID, vo.getCUSTOMER_ID()));
		vo.setCUSTOMER_CODE(AFDataFormat.parseString(CUSTOMER_CODE, vo.getCUSTOMER_CODE()));
		vo.setCUSTOMER_DESC(AFDataFormat.parseString(CUSTOMER_DESC, vo.getCUSTOMER_DESC()));
		vo.setCUSTOMER_TEL(AFDataFormat.parseString(CUSTOMER_TEL, vo.getCUSTOMER_TEL()));
		vo.setSUBJECT(AFDataFormat.parseString(SUBJECT, vo.getSUBJECT()));
		vo.setVISIT_TYPE(AFDataFormat.parseString(VISIT_TYPE, vo.getVISIT_TYPE()));
		vo.setWORK_CONTENT(AFDataFormat.parseString(WORK_CONTENT, vo.getWORK_CONTENT()));
		vo.setFEEDBACK(AFDataFormat.parseString(FEEDBACK, vo.getFEEDBACK()));
		vo.setRESERVE1(AFDataFormat.parseString(RESERVE1, vo.getRESERVE1()));
		vo.setRESERVE2(AFDataFormat.parseString(RESERVE2, vo.getRESERVE2()));
		vo.setRESERVE3(AFDataFormat.parseString(RESERVE3, vo.getRESERVE3()));
		vo.setIS_USING(AFDataFormat.parseString(IS_USING, vo.getIS_USING()));
		vo.setSTATUS(AFDataFormat.parseString(STATUS, vo.getSTATUS()));

        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        VisitPlanVO vo = (VisitPlanVO)_vo;
        
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
		CREATED_BY = AFDataFormat.toString((vo.getCREATED_BY()));
		CREATED_TIME = AFDataFormat.toString((vo.getCREATED_TIME()));
		LAST_UPD_BY = AFDataFormat.toString((vo.getLAST_UPD_BY()));
		LAST_UPD_TIME = AFDataFormat.toString((vo.getLAST_UPD_TIME()));
		MODIFICATION_NUM = AFDataFormat.toString((vo.getMODIFICATION_NUM()));
		COMPANY_ID = AFDataFormat.toString((vo.getCOMPANY_ID()));
		DEPT_ID = AFDataFormat.toString((vo.getDEPT_ID()));
		VISIT_DATE = AFDataFormat.toString((vo.getVISIT_DATE()));
		VISITOR_ID = AFDataFormat.toString((vo.getVISITOR_ID()));
		VISITOR_NAME = AFDataFormat.toString((vo.getVISITOR_NAME()));
		CUSTOMER_ID = AFDataFormat.toString((vo.getCUSTOMER_ID()));
		CUSTOMER_CODE = AFDataFormat.toString((vo.getCUSTOMER_CODE()));
		CUSTOMER_DESC = AFDataFormat.toString((vo.getCUSTOMER_DESC()));
		CUSTOMER_TEL = AFDataFormat.toString((vo.getCUSTOMER_TEL()));
		SUBJECT = AFDataFormat.toString((vo.getSUBJECT()));
		VISIT_TYPE = AFDataFormat.toString((vo.getVISIT_TYPE()));
		WORK_CONTENT = AFDataFormat.toString((vo.getWORK_CONTENT()));
		FEEDBACK = AFDataFormat.toString((vo.getFEEDBACK()));
		RESERVE1 = AFDataFormat.toString((vo.getRESERVE1()));
		RESERVE2 = AFDataFormat.toString((vo.getRESERVE2()));
		RESERVE3 = AFDataFormat.toString((vo.getRESERVE3()));
		IS_USING = AFDataFormat.toString((vo.getIS_USING()));
		STATUS = AFDataFormat.toString((vo.getSTATUS()));

    }

    /**
     * [父类抽象方法实现]
     * 初始化表单数据
     */
    public void initialize() {
		ROW_ID = "" ;
		CREATED_BY = "" ;
		CREATED_TIME = "" ;
		LAST_UPD_BY = "" ;
		LAST_UPD_TIME = "" ;
		MODIFICATION_NUM = "" ;
		COMPANY_ID = "" ;
		DEPT_ID = "" ;
		VISIT_DATE = "" ;
		VISITOR_ID = "" ;
		VISITOR_NAME = "" ;
		CUSTOMER_ID = "" ;
		CUSTOMER_CODE = "" ;
		CUSTOMER_DESC = "" ;
		CUSTOMER_TEL = "" ;
		SUBJECT = "" ;
		VISIT_TYPE = "" ;
		WORK_CONTENT = "" ;
		FEEDBACK = "" ;
		RESERVE1 = "" ;
		RESERVE2 = "" ;
		RESERVE3 = "" ;
		IS_USING = "" ;
		STATUS = "" ;


    }

    /*************************************** customer ***************************************/
    private VisitPlanSearchForm searchForm = new VisitPlanSearchForm();

}