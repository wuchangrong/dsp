package com.handao.dsp.sb.daily.route.vo;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import com.handao.platform.framework.vo.AFCompositeValueObject;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class RouteDailyVO extends AFCompositeValueObject{
	
	private int ROW_ID;  //�к�
	private int CREATED_BY;  //������
	private Date CREATED_TIME;  //����ʱ��
	private int LAST_UPD_BY;  //����޸���
	private Date LAST_UPD_TIME;  //����޸�ʱ��
	private int MODIFICATION_NUM;  //�޸Ĵ���
	private int COMPANY_ID;  //��˾��ʶ
	private int DEPT_ID;  //���ű�ʶ
	private Date VISIT_DATE;  //�ݷ�����
	private String REPORT_EMP = "";  //���
	private String REMARK = "";  //��ע
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

	public String getREPORT_EMP(){
		return REPORT_EMP;
	}

	public void setREPORT_EMP(String report_emp){
		REPORT_EMP = report_emp;
	}

	public String getREMARK(){
		return REMARK;
	}

	public void setREMARK(String remark){
		REMARK = remark;
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


	
    /*************************************** customer ***************************************/
    private List dl_RouteDailyDetail = new ArrayList();

    public List getDetailList_RouteDailyDetail() {
        return dl_RouteDailyDetail; 
    }

    public void setDetailList_RouteDailyDetail(List dl_RouteDailyDetail) {
        this.dl_RouteDailyDetail = dl_RouteDailyDetail;
    }

    /*************************************** implement ***************************************/	
    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ���ݶ���(VO)��������ϸ�б�
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_RouteDailyDetail};
    }

    /**
     * [������󷽷�ʵ��]
     * ����ָ����VOClass������ϸ�б�
     * @param detailVOClass String
     * @param dList List
     */
    public void setDetailList(String detailVOClass, List dList) {
        if(RouteDailyDetailVO.class.getName().equals(detailVOClass)) {
            dl_RouteDailyDetail = dList;
            return;
        }
    }
    
}