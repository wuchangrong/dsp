package com.handao.dsp.sb.visit.visitrecord.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 11, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class VisitRecordVO extends AFValueObject{
	
	private int ROW_ID;  //�к�
	private int CREATED_BY;  //������
	private Date CREATED_TIME;  //����ʱ��
	private int LAST_UPD_BY;  //����޸���
	private Date LAST_UPD_TIME;  //����޸�ʱ��
	private int MODIFICATION_NUM;  //�޸Ĵ���
	private int COMPANY_ID;  //��˾��ʶ
	private int DEPT_ID;  //���ű�ʶ
	private Date VISIT_DATE;  //�ݷ�����
	private int VISITOR_ID;  //�ݷ���ID
	private String VISITOR_NAME = "";  //�ݷ�������
	private int CUSTOMER_ID;  //�ͻ�ID
	private String CUSTOMER_CODE = "";  //�ͻ�����
	private String CUSTOMER_DESC = "";  //�ͻ�����
	private String CUSTOMER_TEL = "";  //�绰
	private String CUSTOMER_ADDR = ""; //��ַ
	private String VISIT_TYPE = "";  //�ݷ���ʽ 1�طÿͻ�  2���ܲ�Ʒ  3�߷ÿͻ�  4�Ӵ��ͻ�
	private String PRD_DESC = "";  //�Ƽ���Ʒ
	private double PRD_PRICE;  //�Ƽ��۸�
	private String EXISTING_PRD = "";  //�ͻ����в�Ʒ
	private String VISIT_RESULT = "";  //�ݷý��
	private String RET_VISIT_STATE = "";  //�ط����
	private String ORIGIN_FLAG = "";  //������Դ��־  0 ¼��  1����
	private String REMARK = "";  //��ע
	private String IS_USING = "";  //�Ƿ���Ч
	private String RESERVE1 = "";
	private String RESERVE2 = "";
	private String RESERVE3 = "";
	private String STATUS = "";  //״̬:0 ��ʼ��1 �ύ  2�طá�

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