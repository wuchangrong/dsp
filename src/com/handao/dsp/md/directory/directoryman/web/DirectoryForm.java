package com.handao.dsp.md.directory.directoryman.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

import com.handao.dsp.md.directory.directoryman.vo.DirectoryVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */
public class DirectoryForm extends AFForm implements AFSearchOperation {

    /*************************************** field ***************************************/
	private String ROW_ID = "";  //行号
	private String CREATED_BY = "";  //创建人
	private String CREATED_TIME = "";  //创建时间
	private String LAST_UPD_BY = "";  //修改人
	private String LAST_UPD_TIME = "";  //修改时间
	private String MODIFICATION_NUM = "";  //修改次数
	private String DIR_CODE = "";  //代码
	private String DIR_NAME = "";  //名称
	private String DIRECLA_CODE = "";  //目录分类
	private String DIRELEV_NO = "";  //级别
	private String PARENT_DIR = "";  //上级目录
	private String PATH = "";  //路径
	private String REMARK = "";  //备注
	private String ICONBIG_URL = "";  //大图标
	private String ICONSMA_URL = "";  //小图标
	private String ISVALID = "";  //是否有效

	private String ISVALID_VALUE="";//是否有效名称
	private String PARENT_DIR_NAME="";//上级目录名称
	private String DIRECLA_VALUE="";//目录分类名称

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

	public String getDIRELEV_NO(){
		return DIRELEV_NO;
	}

	public void setDIRELEV_NO(String direlev_no){
		DIRELEV_NO = direlev_no;
	}

	public String getPARENT_DIR(){
		return PARENT_DIR;
	}

	public void setPARENT_DIR(String parent_dir){
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

	/*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "md_directory_DirectoryForm";
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
    	searchForm = new DirectorySearchForm();
    }        

    /**
     * [父类抽象方法实现]
     * 根据当前表单生成对应数据对象(VO)
     * 建议使用AFDataFormat.parseString()进行类型转换
     * @return AFValueObject
     */
    public AFValueObject transform() {
        DirectoryVO vo = new DirectoryVO();
        
		vo.setROW_ID(AFDataFormat.parseString(ROW_ID, vo.getROW_ID()));
		vo.setCREATED_BY(AFDataFormat.parseString(CREATED_BY, vo.getCREATED_BY()));
		vo.setCREATED_TIME(AFDataFormat.parseString(CREATED_TIME, vo.getCREATED_TIME()));
		vo.setLAST_UPD_BY(AFDataFormat.parseString(LAST_UPD_BY, vo.getLAST_UPD_BY()));
		vo.setLAST_UPD_TIME(AFDataFormat.parseString(LAST_UPD_TIME, vo.getLAST_UPD_TIME()));
		vo.setMODIFICATION_NUM(AFDataFormat.parseString(MODIFICATION_NUM, vo.getMODIFICATION_NUM()));
		vo.setDIR_CODE(AFDataFormat.parseString(DIR_CODE, vo.getDIR_CODE()));
		vo.setDIR_NAME(AFDataFormat.parseString(DIR_NAME, vo.getDIR_NAME()));
		vo.setDIRECLA_CODE(AFDataFormat.parseString(DIRECLA_CODE, vo.getDIRECLA_CODE()));
		vo.setDIRELEV_NO(AFDataFormat.parseString(DIRELEV_NO, vo.getDIRELEV_NO()));
		vo.setPARENT_DIR(AFDataFormat.parseString(PARENT_DIR, vo.getPARENT_DIR()));
		vo.setPATH(AFDataFormat.parseString(PATH, vo.getPATH()));
		vo.setREMARK(AFDataFormat.parseString(REMARK, vo.getREMARK()));
		vo.setICONBIG_URL(AFDataFormat.parseString(ICONBIG_URL, vo.getICONBIG_URL()));
		vo.setICONSMA_URL(AFDataFormat.parseString(ICONSMA_URL, vo.getICONSMA_URL()));
		vo.setISVALID(AFDataFormat.parseString(ISVALID, vo.getISVALID()));

        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        DirectoryVO vo = (DirectoryVO)_vo;
        
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
		CREATED_BY = AFDataFormat.toString((vo.getCREATED_BY()));
		CREATED_TIME = AFDataFormat.toString((vo.getCREATED_TIME()));
		LAST_UPD_BY = AFDataFormat.toString((vo.getLAST_UPD_BY()));
		LAST_UPD_TIME = AFDataFormat.toString((vo.getLAST_UPD_TIME()));
		MODIFICATION_NUM = AFDataFormat.toString((vo.getMODIFICATION_NUM()));
		DIR_CODE = AFDataFormat.toString((vo.getDIR_CODE()));
		DIR_NAME = AFDataFormat.toString((vo.getDIR_NAME()));
		DIRECLA_CODE = AFDataFormat.toString((vo.getDIRECLA_CODE()));
		DIRELEV_NO = AFDataFormat.toString((vo.getDIRELEV_NO()));
		PARENT_DIR = AFDataFormat.toString((vo.getPARENT_DIR()));
		PATH = AFDataFormat.toString((vo.getPATH()));
		REMARK = AFDataFormat.toString((vo.getREMARK()));
		ICONBIG_URL = AFDataFormat.toString((vo.getICONBIG_URL()));
		ICONSMA_URL = AFDataFormat.toString((vo.getICONSMA_URL()));
		ISVALID = AFDataFormat.toString((vo.getISVALID()));

		ISVALID_VALUE=AFDataFormat.toString((vo.getISVALID_VALUE()));
		PARENT_DIR_NAME=AFDataFormat.toString((vo.getPARENT_DIR_NAME()));
		DIRECLA_VALUE=AFDataFormat.toString((vo.getDIRECLA_VALUE()));
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
		DIR_CODE = "" ;
		DIR_NAME = "" ;
		DIRECLA_CODE = "" ;
		DIRELEV_NO = "" ;
		PARENT_DIR = "" ;
		PATH = "" ;
		REMARK = "" ;
		ICONBIG_URL = "" ;
		ICONSMA_URL = "" ;
		ISVALID = "" ;


    }

    /*************************************** customer ***************************************/
    private DirectorySearchForm searchForm = new DirectorySearchForm();

}