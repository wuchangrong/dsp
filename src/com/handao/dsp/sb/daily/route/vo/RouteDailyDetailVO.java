package com.handao.dsp.sb.daily.route.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailyDetailVO extends AFValueObject{
    
	private int ROW_ID;  //�к�
	private int CREATED_BY;  //������
	private Date CREATED_TIME;  //����ʱ��
	private int LAST_UPD_BY;  //����޸���
	private Date LAST_UPD_TIME;  //����޸�ʱ��
	private int MODIFICATION_NUM;  //�޸Ĵ���
	private int DAILY_ID;  //�ձ�ID
	private int COMPANY_ID;  //��˾��ʶ
	private int DEPT_ID;  //���ű�ʶ
	private Date VISIT_DATE;  //�ݷ�����
	private int EMP_ID;  //�ݷ���ID
	private String EMP_NAME = "";  //�ݷ�������
	private String BEGIN_TIME;  //��ʼʱ��
	private String END_TIME;  //��ֹʱ��
	private String CAR_NO = "";  //���ƺ�
	private String CITY = "";  //��
	private String COUNTY = "";  //��
	private String TOWNS = "";  //��
	private String VILLAGE = "";  //��
	private String VISIT_TYPE = "";  //�ݷ���ʽ 1�طÿͻ�  2���ܲ�Ʒ  3�߷ÿͻ�  4�Ӵ��ͻ�
	private String RESERVE1 = "";
	private String RESERVE2 = "";
	private String RESERVE3 = "";
	private String IS_USING = "";  //�Ƿ���Ч
	private String STATUS = "";  //״̬:0 ��ʼ��1 �ύ  2��ɡ�

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

	public int getDAILY_ID(){
		return DAILY_ID;
	}

	public void setDAILY_ID(int daily_id){
		DAILY_ID = daily_id;
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

	public int getEMP_ID(){
		return EMP_ID;
	}

	public void setEMP_ID(int emp_id){
		EMP_ID = emp_id;
	}

	public String getEMP_NAME(){
		return EMP_NAME;
	}

	public void setEMP_NAME(String emp_name){
		EMP_NAME = emp_name;
	}

	public String getBEGIN_TIME(){
		return BEGIN_TIME;
	}

	public void setBEGIN_TIME(String begin_time){
		BEGIN_TIME = begin_time;
	}

	public String getEND_TIME(){
		return END_TIME;
	}

	public void setEND_TIME(String end_time){
		END_TIME = end_time;
	}

	public String getCAR_NO(){
		return CAR_NO;
	}

	public void setCAR_NO(String car_no){
		CAR_NO = car_no;
	}

	public String getCITY(){
		return CITY;
	}

	public void setCITY(String city){
		CITY = city;
	}

	public String getCOUNTY(){
		return COUNTY;
	}

	public void setCOUNTY(String county){
		COUNTY = county;
	}

	public String getTOWNS(){
		return TOWNS;
	}

	public void setTOWNS(String towns){
		TOWNS = towns;
	}

	public String getVILLAGE(){
		return VILLAGE;
	}

	public void setVILLAGE(String village){
		VILLAGE = village;
	}

	public String getVISIT_TYPE(){
		return VISIT_TYPE;
	}

	public void setVISIT_TYPE(String visit_type){
		VISIT_TYPE = visit_type;
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

    
}