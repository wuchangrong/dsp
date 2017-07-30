package com.handao.dsp.sb.daily.route.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailyDetailVO extends AFValueObject{
    
	private int ROW_ID;  //行号
	private int CREATED_BY;  //创建人
	private Date CREATED_TIME;  //创建时间
	private int LAST_UPD_BY;  //最近修改人
	private Date LAST_UPD_TIME;  //最近修改时间
	private int MODIFICATION_NUM;  //修改次数
	private int DAILY_ID;  //日报ID
	private int COMPANY_ID;  //公司标识
	private int DEPT_ID;  //部门标识
	private Date VISIT_DATE;  //拜访日期
	private int EMP_ID;  //拜访人ID
	private String EMP_NAME = "";  //拜访人姓名
	private String BEGIN_TIME;  //起始时间
	private String END_TIME;  //截止时间
	private String CAR_NO = "";  //车牌号
	private String CITY = "";  //市
	private String COUNTY = "";  //县
	private String TOWNS = "";  //镇
	private String VILLAGE = "";  //乡
	private String VISIT_TYPE = "";  //拜访形式 1回访客户  2介绍产品  3走访客户  4接待客户
	private String RESERVE1 = "";
	private String RESERVE2 = "";
	private String RESERVE3 = "";
	private String IS_USING = "";  //是否有效
	private String STATUS = "";  //状态:0 初始，1 提交  2完成。

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