package com.handao.dsp.md.directory.directoryman.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

import com.handao.dsp.md.directory.directoryman.vo.DirectoryVO;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */
public class DirectoryForm extends AFForm implements AFSearchOperation {

    /*************************************** field ***************************************/
	private String ROW_ID = "";  //�к�
	private String CREATED_BY = "";  //������
	private String CREATED_TIME = "";  //����ʱ��
	private String LAST_UPD_BY = "";  //�޸���
	private String LAST_UPD_TIME = "";  //�޸�ʱ��
	private String MODIFICATION_NUM = "";  //�޸Ĵ���
	private String DIR_CODE = "";  //����
	private String DIR_NAME = "";  //����
	private String DIRECLA_CODE = "";  //Ŀ¼����
	private String DIRELEV_NO = "";  //����
	private String PARENT_DIR = "";  //�ϼ�Ŀ¼
	private String PATH = "";  //·��
	private String REMARK = "";  //��ע
	private String ICONBIG_URL = "";  //��ͼ��
	private String ICONSMA_URL = "";  //Сͼ��
	private String ISVALID = "";  //�Ƿ���Ч

	private String ISVALID_VALUE="";//�Ƿ���Ч����
	private String PARENT_DIR_NAME="";//�ϼ�Ŀ¼����
	private String DIRECLA_VALUE="";//Ŀ¼��������

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
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "md_directory_DirectoryForm";
    }

    /**
     * [�ӿڷ���ʵ��]
     * ���ز�ѯ��
     * @return AFSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }
    
    //��ʼ��searchForm
    public void initSearchForm(){
    	searchForm = new DirectorySearchForm();
    }        

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��AFDataFormat.parseString()��������ת��
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
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
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