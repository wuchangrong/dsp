package com.handao.dsp.md.directory.directoryman.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */

public class DirectoryVO extends AFValueObject{
	
	private int ROW_ID;  //行号
	private int CREATED_BY;  //创建人
	private Date CREATED_TIME;  //创建时间
	private int LAST_UPD_BY;  //修改人
	private Date LAST_UPD_TIME;  //修改时间
	private int MODIFICATION_NUM;  //修改次数
	private String DIR_CODE = "";  //代码
	private String DIR_NAME = "";  //名称
	private String DIRECLA_CODE = "";  //目录分类
	private int DIRELEV_NO;  //级别
	private int PARENT_DIR;  //上级目录
	private String PATH = "";  //路径
	private String REMARK = "";  //备注
	private String ICONBIG_URL = "";  //大图标
	private String ICONSMA_URL = "";  //小图标
	private String ISVALID = "";  //是否有效

	private String ISVALID_VALUE="";//是否有效名称
	private String PARENT_DIR_NAME="";//上级目录名称
	private String DIRECLA_VALUE="";//目录分类名称

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