package com.handao.dsp.md.directory.direaut.web;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;

import com.handao.dsp.md.directory.direaut.vo.DireautDetailVO;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class DireautDetailForm extends AFForm {
    /*************************************** field ***************************************/
	private String ROW_ID = "";  //�к�
	private String CREATED_BY = "";  //������
	private String CREATED_TIME = "";  //����ʱ��
	private String LAST_UPD_BY = "";  //����޸���
	private String LAST_UPD_TIME = "";  //����޸�ʱ��
	private String MODIFICATION_NUM = "";  //�޸Ĵ���
	private String DIRECTORY_ID = "";
	private String ROLE_ID = "";
	private String RIGHADD = "";
	private String RIGHDEL = "";
	private String RIGHEDI = "";
	private String RIGHVIE = "";
	private String RIGHAUD = "";
	
	private String ROLE_NAME="";
	
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

	public String getDIRECTORY_ID(){
		return DIRECTORY_ID;
	}

	public void setDIRECTORY_ID(String directory_id){
		DIRECTORY_ID = directory_id;
	}

	public String getROLE_ID(){
		return ROLE_ID;
	}

	public void setROLE_ID(String role_id){
		ROLE_ID = role_id;
	}

	public String getRIGHADD(){
		return RIGHADD;
	}

	public void setRIGHADD(String righadd){
		RIGHADD = righadd;
	}

	public String getRIGHDEL(){
		return RIGHDEL;
	}

	public void setRIGHDEL(String righdel){
		RIGHDEL = righdel;
	}

	public String getRIGHEDI(){
		return RIGHEDI;
	}

	public void setRIGHEDI(String righedi){
		RIGHEDI = righedi;
	}

	public String getRIGHVIE(){
		return RIGHVIE;
	}

	public void setRIGHVIE(String righvie){
		RIGHVIE = righvie;
	}

	public String getRIGHAUD(){
		return RIGHAUD;
	}

	public void setRIGHAUD(String righaud){
		RIGHAUD = righaud;
	}

    public String getROLE_NAME() {
		return ROLE_NAME;
	}

	public void setROLE_NAME(String role_name) {
		ROLE_NAME = role_name;
	}

	/*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "md_directory_DireautDetailForm";
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��AFDataFormat.parseString()��������ת��
     * @return AFValueObject
     */
    public AFValueObject transform() {
        DireautDetailVO vo = new DireautDetailVO();
		vo.setROW_ID(AFDataFormat.parseString(ROW_ID, vo.getROW_ID()));
		vo.setCREATED_BY(AFDataFormat.parseString(CREATED_BY, vo.getCREATED_BY()));
		vo.setCREATED_TIME(AFDataFormat.parseString(CREATED_TIME, vo.getCREATED_TIME()));
		vo.setLAST_UPD_BY(AFDataFormat.parseString(LAST_UPD_BY, vo.getLAST_UPD_BY()));
		vo.setLAST_UPD_TIME(AFDataFormat.parseString(LAST_UPD_TIME, vo.getLAST_UPD_TIME()));
		vo.setMODIFICATION_NUM(AFDataFormat.parseString(MODIFICATION_NUM, vo.getMODIFICATION_NUM()));
		vo.setDIRECTORY_ID(AFDataFormat.parseString(DIRECTORY_ID, vo.getDIRECTORY_ID()));
		vo.setROLE_ID(AFDataFormat.parseString(ROLE_ID, vo.getROLE_ID()));
		vo.setRIGHADD(AFDataFormat.parseString(RIGHADD, vo.getRIGHADD()));
		vo.setRIGHDEL(AFDataFormat.parseString(RIGHDEL, vo.getRIGHDEL()));
		vo.setRIGHEDI(AFDataFormat.parseString(RIGHEDI, vo.getRIGHEDI()));
		vo.setRIGHVIE(AFDataFormat.parseString(RIGHVIE, vo.getRIGHVIE()));
		vo.setRIGHAUD(AFDataFormat.parseString(RIGHAUD, vo.getRIGHAUD()));
		vo.setROLE_NAME(AFDataFormat.parseString(ROLE_NAME, vo.getROLE_NAME()));

        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        DireautDetailVO vo = (DireautDetailVO)_vo;
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
		CREATED_BY = AFDataFormat.toString((vo.getCREATED_BY()));
		CREATED_TIME = AFDataFormat.toString((vo.getCREATED_TIME()));
		LAST_UPD_BY = AFDataFormat.toString((vo.getLAST_UPD_BY()));
		LAST_UPD_TIME = AFDataFormat.toString((vo.getLAST_UPD_TIME()));
		MODIFICATION_NUM = AFDataFormat.toString((vo.getMODIFICATION_NUM()));
		DIRECTORY_ID = AFDataFormat.toString((vo.getDIRECTORY_ID()));
		ROLE_ID = AFDataFormat.toString((vo.getROLE_ID()));
		RIGHADD = AFDataFormat.toString((vo.getRIGHADD()));
		RIGHDEL = AFDataFormat.toString((vo.getRIGHDEL()));
		RIGHEDI = AFDataFormat.toString((vo.getRIGHEDI()));
		RIGHVIE = AFDataFormat.toString((vo.getRIGHVIE()));
		RIGHAUD = AFDataFormat.toString((vo.getRIGHAUD()));
		ROLE_NAME = AFDataFormat.toString((vo.getROLE_NAME()));

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
		DIRECTORY_ID = "" ;
		ROLE_ID = "" ;
		RIGHADD = "" ;
		RIGHDEL = "" ;
		RIGHEDI = "" ;
		RIGHVIE = "" ;
		RIGHAUD = "" ;
		ROLE_NAME="";
    }

    /**
     * [���෽����д]
     * �жϵ�ǰ�������Ƿ���Ч
     * һ��Ϊ�ӱ����д�÷���
     * @return boolean
     */
    public boolean isValidate() {
        return true;
    }

}