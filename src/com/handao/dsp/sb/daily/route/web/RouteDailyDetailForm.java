package com.handao.dsp.sb.daily.route.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;

import com.handao.dsp.sb.daily.route.vo.RouteDailyDetailVO;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailyDetailForm extends AFForm {
    /*************************************** field ***************************************/
	private String ROW_ID = "";  //�к�
	private String CREATED_BY = "";  //������
	private String CREATED_TIME = "";  //����ʱ��
	private String LAST_UPD_BY = "";  //����޸���
	private String LAST_UPD_TIME = "";  //����޸�ʱ��
	private String MODIFICATION_NUM = "";  //�޸Ĵ���
	private String DAILY_ID = "";  //�ձ�ID
	private String COMPANY_ID = "";  //��˾��ʶ
	private String DEPT_ID = "";  //���ű�ʶ
	private String VISIT_DATE = "";  //�ݷ�����
	private String EMP_ID = "";  //�ݷ���ID
	private String EMP_NAME = "";  //�ݷ�������
	private String BEGIN_TIME = "";  //��ʼʱ��
	private String END_TIME = "";  //��ֹʱ��
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

	public String getDAILY_ID(){
		return DAILY_ID;
	}

	public void setDAILY_ID(String daily_id){
		DAILY_ID = daily_id;
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

	public String getEMP_ID(){
		return EMP_ID;
	}

	public void setEMP_ID(String emp_id){
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



    /*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "sb_daily_RouteDailyDetailForm";
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��AFDataFormat.parseString()��������ת��
     * @return AFValueObject
     */
    public AFValueObject transform() {
        RouteDailyDetailVO vo = new RouteDailyDetailVO();
		vo.setROW_ID(AFDataFormat.parseString(ROW_ID, vo.getROW_ID()));
		vo.setCREATED_BY(AFDataFormat.parseString(CREATED_BY, vo.getCREATED_BY()));
		vo.setCREATED_TIME(AFDataFormat.parseString(CREATED_TIME, vo.getCREATED_TIME()));
		vo.setLAST_UPD_BY(AFDataFormat.parseString(LAST_UPD_BY, vo.getLAST_UPD_BY()));
		vo.setLAST_UPD_TIME(AFDataFormat.parseString(LAST_UPD_TIME, vo.getLAST_UPD_TIME()));
		vo.setMODIFICATION_NUM(AFDataFormat.parseString(MODIFICATION_NUM, vo.getMODIFICATION_NUM()));
		vo.setDAILY_ID(AFDataFormat.parseString(DAILY_ID, vo.getDAILY_ID()));
		vo.setCOMPANY_ID(AFDataFormat.parseString(COMPANY_ID, vo.getCOMPANY_ID()));
		vo.setDEPT_ID(AFDataFormat.parseString(DEPT_ID, vo.getDEPT_ID()));
		vo.setVISIT_DATE(AFDataFormat.parseString(VISIT_DATE, vo.getVISIT_DATE()));
		vo.setEMP_ID(AFDataFormat.parseString(EMP_ID, vo.getEMP_ID()));
		vo.setEMP_NAME(AFDataFormat.parseString(EMP_NAME, vo.getEMP_NAME()));
		vo.setBEGIN_TIME(AFDataFormat.parseString(BEGIN_TIME, vo.getBEGIN_TIME()));
		vo.setEND_TIME(AFDataFormat.parseString(END_TIME, vo.getEND_TIME()));
		vo.setCAR_NO(AFDataFormat.parseString(CAR_NO, vo.getCAR_NO()));
		vo.setCITY(AFDataFormat.parseString(CITY, vo.getCITY()));
		vo.setCOUNTY(AFDataFormat.parseString(COUNTY, vo.getCOUNTY()));
		vo.setTOWNS(AFDataFormat.parseString(TOWNS, vo.getTOWNS()));
		vo.setVILLAGE(AFDataFormat.parseString(VILLAGE, vo.getVILLAGE()));
		vo.setVISIT_TYPE(AFDataFormat.parseString(VISIT_TYPE, vo.getVISIT_TYPE()));
		vo.setRESERVE1(AFDataFormat.parseString(RESERVE1, vo.getRESERVE1()));
		vo.setRESERVE2(AFDataFormat.parseString(RESERVE2, vo.getRESERVE2()));
		vo.setRESERVE3(AFDataFormat.parseString(RESERVE3, vo.getRESERVE3()));
		vo.setIS_USING(AFDataFormat.parseString(IS_USING, vo.getIS_USING()));
		vo.setSTATUS(AFDataFormat.parseString(STATUS, vo.getSTATUS()));

        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        RouteDailyDetailVO vo = (RouteDailyDetailVO)_vo;
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
		CREATED_BY = AFDataFormat.toString((vo.getCREATED_BY()));
		CREATED_TIME = AFDataFormat.toString((vo.getCREATED_TIME()));
		LAST_UPD_BY = AFDataFormat.toString((vo.getLAST_UPD_BY()));
		LAST_UPD_TIME = AFDataFormat.toString((vo.getLAST_UPD_TIME()));
		MODIFICATION_NUM = AFDataFormat.toString((vo.getMODIFICATION_NUM()));
		DAILY_ID = AFDataFormat.toString((vo.getDAILY_ID()));
		COMPANY_ID = AFDataFormat.toString((vo.getCOMPANY_ID()));
		DEPT_ID = AFDataFormat.toString((vo.getDEPT_ID()));
		VISIT_DATE = AFDataFormat.toString((vo.getVISIT_DATE()));
		EMP_ID = AFDataFormat.toString((vo.getEMP_ID()));
		EMP_NAME = AFDataFormat.toString((vo.getEMP_NAME()));
		BEGIN_TIME = AFDataFormat.toString((vo.getBEGIN_TIME()));
		END_TIME = AFDataFormat.toString((vo.getEND_TIME()));
		CAR_NO = AFDataFormat.toString((vo.getCAR_NO()));
		CITY = AFDataFormat.toString((vo.getCITY()));
		COUNTY = AFDataFormat.toString((vo.getCOUNTY()));
		TOWNS = AFDataFormat.toString((vo.getTOWNS()));
		VILLAGE = AFDataFormat.toString((vo.getVILLAGE()));
		VISIT_TYPE = AFDataFormat.toString((vo.getVISIT_TYPE()));
		RESERVE1 = AFDataFormat.toString((vo.getRESERVE1()));
		RESERVE2 = AFDataFormat.toString((vo.getRESERVE2()));
		RESERVE3 = AFDataFormat.toString((vo.getRESERVE3()));
		IS_USING = AFDataFormat.toString((vo.getIS_USING()));
		STATUS = AFDataFormat.toString((vo.getSTATUS()));

    }

    /**
     * [������󷽷�ʵ��]
     * ��ʼ��������
     */
    public void initialize() {
		ROW_ID = "" ;
		CREATED_BY = "" ;
		CREATED_TIME = "" ;
		LAST_UPD_BY = "" ;
		LAST_UPD_TIME = "" ;
		MODIFICATION_NUM = "" ;
		DAILY_ID = "" ;
		COMPANY_ID = "" ;
		DEPT_ID = "" ;
		VISIT_DATE = "" ;
		EMP_ID = "" ;
		EMP_NAME = "" ;
		BEGIN_TIME = "" ;
		END_TIME = "" ;
		CAR_NO = "" ;
		CITY = "" ;
		COUNTY = "" ;
		TOWNS = "" ;
		VILLAGE = "" ;
		VISIT_TYPE = "" ;
		RESERVE1 = "" ;
		RESERVE2 = "" ;
		RESERVE3 = "" ;
		IS_USING = "" ;
		STATUS = "" ;

    }

    /**
     * [���෽����д]
     * �жϵ�ǰ�������Ƿ���Ч
     * һ��Ϊ�ӱ����д�÷���
     * @return boolean
     */
    public boolean isValidate() {
    	if (EMP_NAME != null  && !EMP_NAME.equals(""))
            return true;
    	else 
    		return false;
    }

}