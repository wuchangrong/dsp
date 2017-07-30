package com.handao.dsp.sb.visit.visitrecord.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitRecordVO extends AFValueObject{
	
	private int ROW_ID;  //行号
	private int CREATED_BY;  //创建人
	private Date CREATED_TIME;  //创建时间
	private int LAST_UPD_BY;  //最近修改人
	private Date LAST_UPD_TIME;  //最近修改时间
	private int MODIFICATION_NUM;  //修改次数
	private int COMPANY_ID;  //公司标识
	private int DEPT_ID;  //部门标识
	private Date VISIT_DATE;  //拜访日期
	private int VISITOR_ID;  //拜访人ID
	private String VISITOR_NAME = "";  //拜访人姓名
	private int CUSTOMER_ID;  //客户ID
	private String CUSTOMER_CODE = "";  //客户代码
	private String CUSTOMER_DESC = "";  //客户名称
	private String CUSTOMER_TEL = "";  //电话
	private String CUSTOMER_ADDR = ""; //地址
	private String VISIT_TYPE = "";  //拜访形式 1回访客户  2介绍产品  3走访客户  4接待客户
	private String PRD_DESC = "";  //推荐产品
	private double PRD_PRICE;  //推荐价格
	private String EXISTING_PRD = "";  //客户现有产品
	private String VISIT_RESULT = "";  //拜访结果
	private String RET_VISIT_STATE = "";  //回访情况
	private String ORIGIN_FLAG = "";  //数据来源标志  0 录入  1短信
	private String REMARK = "";  //备注
	private String IS_USING = "";  //是否有效
	private String RESERVE1 = "";
	private String RESERVE2 = "";
	private String RESERVE3 = "";
	private String STATUS = "";  //状态:0 初始，1 提交  2回访。

	private String ORIGIN_FLAG_DESC = "";

	public int getROW_ID(){
		return ROW_ID;
	}

	public void setROW_ID(int row_id){
		ROW_ID = row_id;
	}

	public int getCREATED_BY(){
		return CREATED_BY;
	}

	public void setCREATED_BY(int created_by){
		CREATED_BY = created_by;
	}

	public Date getCREATED_TIME(){
		return CREATED_TIME;
	}

	public void setCREATED_TIME(Date created_time){
		CREATED_TIME = created_time;
	}

	public int getLAST_UPD_BY(){
		return LAST_UPD_BY;
	}

	public void setLAST_UPD_BY(int last_upd_by){
		LAST_UPD_BY = last_upd_by;
	}

	public Date getLAST_UPD_TIME(){
		return LAST_UPD_TIME;
	}

	public void setLAST_UPD_TIME(Date last_upd_time){
		LAST_UPD_TIME = last_upd_time;
	}

	public int getMODIFICATION_NUM(){
		return MODIFICATION_NUM;
	}

	public void setMODIFICATION_NUM(int modification_num){
		MODIFICATION_NUM = modification_num;
	}

	public int getCOMPANY_ID(){
		return COMPANY_ID;
	}

	public void setCOMPANY_ID(int company_id){
		COMPANY_ID = company_id;
	}

	public int getDEPT_ID(){
		return DEPT_ID;
	}

	public void setDEPT_ID(int dept_id){
		DEPT_ID = dept_id;
	}

	public Date getVISIT_DATE(){
		return VISIT_DATE;
	}

	public void setVISIT_DATE(Date visit_date){
		VISIT_DATE = visit_date;
	}

	public int getVISITOR_ID(){
		return VISITOR_ID;
	}

	public void setVISITOR_ID(int visitor_id){
		VISITOR_ID = visitor_id;
	}

	public String getVISITOR_NAME(){
		return VISITOR_NAME;
	}

	public void setVISITOR_NAME(String visitor_name){
		VISITOR_NAME = visitor_name;
	}

	public int getCUSTOMER_ID(){
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(int customer_id){
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

	public String getCUSTOMER_ADDR() {
		return CUSTOMER_ADDR;
	}

	public void setCUSTOMER_ADDR(String customer_addr) {
		CUSTOMER_ADDR = customer_addr;
	}
	
	public String getVISIT_TYPE(){
		return VISIT_TYPE;
	}

	public void setVISIT_TYPE(String visit_type){
		VISIT_TYPE = visit_type;
	}

	public String getPRD_DESC(){
		return PRD_DESC;
	}

	public void setPRD_DESC(String prd_desc){
		PRD_DESC = prd_desc;
	}

	public double getPRD_PRICE(){
		return PRD_PRICE;
	}

	public void setPRD_PRICE(double prd_price){
		PRD_PRICE = prd_price;
	}

	public String getEXISTING_PRD(){
		return EXISTING_PRD;
	}

	public void setEXISTING_PRD(String existing_prd){
		EXISTING_PRD = existing_prd;
	}

	public String getVISIT_RESULT(){
		return VISIT_RESULT;
	}

	public void setVISIT_RESULT(String visit_result){
		VISIT_RESULT = visit_result;
	}

	public String getRET_VISIT_STATE(){
		return RET_VISIT_STATE;
	}

	public void setRET_VISIT_STATE(String ret_visit_state){
		RET_VISIT_STATE = ret_visit_state;
	}

	public String getORIGIN_FLAG(){
		return ORIGIN_FLAG;
	}

	public void setORIGIN_FLAG(String origin_flag){
		ORIGIN_FLAG = origin_flag;
	}

	public String getREMARK(){
		return REMARK;
	}

	public void setREMARK(String remark){
		REMARK = remark;
	}

	public String getIS_USING(){
		return IS_USING;
	}

	public void setIS_USING(String is_using){
		IS_USING = is_using;
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

	public String getSTATUS(){
		return STATUS;
	}

	public void setSTATUS(String status){
		STATUS = status;
	}

	public String getORIGIN_FLAG_DESC() {
		return ORIGIN_FLAG_DESC;
	}

	public void setORIGIN_FLAG_DESC(String origin_flag_desc) {
		ORIGIN_FLAG_DESC = origin_flag_desc;
	}




	
}