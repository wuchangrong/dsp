package com.handao.dsp.md.directory.directoryman.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */

public class DirectoryVO extends AFValueObject{
	
	private int ROW_ID;  //�к�
	private int CREATED_BY;  //������
	private Date CREATED_TIME;  //����ʱ��
	private int LAST_UPD_BY;  //�޸���
	private Date LAST_UPD_TIME;  //�޸�ʱ��
	private int MODIFICATION_NUM;  //�޸Ĵ���
	private String DIR_CODE = "";  //����
	private String DIR_NAME = "";  //����
	private String DIRECLA_CODE = "";  //Ŀ¼����
	private int DIRELEV_NO;  //����
	private int PARENT_DIR;  //�ϼ�Ŀ¼
	private String PATH = "";  //·��
	private String REMARK = "";  //��ע
	private String ICONBIG_URL = "";  //��ͼ��
	private String ICONSMA_URL = "";  //Сͼ��
	private String ISVALID = "";  //�Ƿ���Ч

	private String ISVALID_VALUE="";//�Ƿ���Ч����
	private String PARENT_DIR_NAME="";//�ϼ�Ŀ¼����
	private String DIRECLA_VALUE="";//Ŀ¼��������

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

	public String getDIR_CODE(){
		return DIR_CODE;
	}

	public void setDIR_CODE(String dir_code){
		DIR_CODE = dir_code;
	}

	public String getDIR_NAME(){
		return DIR_NAME;
	}

	public void setDIR_NAME(String dir_name){
		DIR_NAME = dir_name;
	}

	public String getDIRECLA_CODE(){
		return DIRECLA_CODE;
	}

	public void setDIRECLA_CODE(String direcla_code){
		DIRECLA_CODE = direcla_code;
	}

	public int getDIRELEV_NO(){
		return DIRELEV_NO;
	}

	public void setDIRELEV_NO(int direlev_no){
		DIRELEV_NO = direlev_no;
	}

	public int getPARENT_DIR(){
		return PARENT_DIR;
	}

	public void setPARENT_DIR(int parent_dir){
		PARENT_DIR = parent_dir;
	}

	public String getPATH(){
		return PATH;
	}

	public void setPATH(String path){
		PATH = path;
	}

	public String getREMARK(){
		return REMARK;
	}

	public void setREMARK(String remark){
		REMARK = remark;
	}

	public String getICONBIG_URL(){
		return ICONBIG_URL;
	}

	public void setICONBIG_URL(String iconbig_url){
		ICONBIG_URL = iconbig_url;
	}

	public String getICONSMA_URL(){
		return ICONSMA_URL;
	}

	public void setICONSMA_URL(String iconsma_url){
		ICONSMA_URL = iconsma_url;
	}

	public String getISVALID(){
		return ISVALID;
	}

	public void setISVALID(String isvalid){
		ISVALID = isvalid;
	}

	public String getISVALID_VALUE() {
		return ISVALID_VALUE;
	}

	public void setISVALID_VALUE(String isvalid_value) {
		ISVALID_VALUE = isvalid_value;
	}

	public String getPARENT_DIR_NAME() {
		return PARENT_DIR_NAME;
	}

	public void setPARENT_DIR_NAME(String parent_dir_name) {
		PARENT_DIR_NAME = parent_dir_name;
	}

	public String getDIRECLA_VALUE() {
		return DIRECLA_VALUE;
	}

	public void setDIRECLA_VALUE(String direcla_value) {
		DIRECLA_VALUE = direcla_value;
	}


	
}