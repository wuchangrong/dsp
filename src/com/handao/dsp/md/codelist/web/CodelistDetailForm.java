package com.handao.dsp.md.codelist.web;

import org.apache.commons.lang.StringUtils;

import com.handao.dsp.md.codelist.vo.CodelistDetailVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;

public class CodelistDetailForm extends AFForm {
    /*************************************** field ***************************************/
    private String list_CODE_NAME;  //����
    private String list_CODE_VALUE;  //ֵ
    private String list_COMMENTS;  //˵��
    private String list_CREATED_BY;  //������:ϵͳ�ֶΡ�
    private String list_CREATED_TIME;  //����ʱ��:ϵͳ�ֶΡ�
    private String list_LAST_UPD_BY;  //�޸���:ϵͳ�ֶΡ�
    private String list_LAST_UPD_TIME;  //�޸�ʱ��:ϵͳ�ֶΡ�
    private String list_MODIFICATION_NUM;  //�޸Ĵ���:ϵͳ�ֶΡ�
    private String list_REMARKS;  //��ע
    private String list_ROW_ID;  //ROW_ID:ϵͳ�ֶΡ�
    private String list_SORT_CODE;  //������
    private String list_STATUS;  //״̬:0 ��Ч��1 ͣ�á�
    private String list_TYPE_CODE;  //�������
    private String code_LOV_NAME;  //
    private String list_IS_DEFAULT;

    /**
     * @return list_IS_DEFAULT ��get����
     */
    public String getList_IS_DEFAULT()
    {
        return list_IS_DEFAULT;
    }

    /**
     * @param list_IS_DEFAULT �� set����
     */
    public void setList_IS_DEFAULT(String list_IS_DEFAULT)
    {
        this.list_IS_DEFAULT = list_IS_DEFAULT;
    }

    public String getList_CODE_NAME() {
        return list_CODE_NAME;
    }

    public void setList_CODE_NAME(String list_CODE_NAME) {
        this.list_CODE_NAME = list_CODE_NAME;
    }

    public String getList_CODE_VALUE() {
        return list_CODE_VALUE;
    }

    public void setList_CODE_VALUE(String list_CODE_VALUE) {
        this.list_CODE_VALUE = list_CODE_VALUE;
    }

    public String getList_COMMENTS() {
        return list_COMMENTS;
    }

    public void setList_COMMENTS(String list_COMMENTS) {
        this.list_COMMENTS = list_COMMENTS;
    }

    public String getList_CREATED_BY() {
        return list_CREATED_BY;
    }

    public void setList_CREATED_BY(String list_CREATED_BY) {
        this.list_CREATED_BY = list_CREATED_BY;
    }

    public String getList_CREATED_TIME() {
        return list_CREATED_TIME;
    }

    public void setList_CREATED_TIME(String list_CREATED_TIME) {
        this.list_CREATED_TIME = list_CREATED_TIME;
    }

    public String getList_LAST_UPD_BY() {
        return list_LAST_UPD_BY;
    }

    public void setList_LAST_UPD_BY(String list_LAST_UPD_BY) {
        this.list_LAST_UPD_BY = list_LAST_UPD_BY;
    }

    public String getList_LAST_UPD_TIME() {
        return list_LAST_UPD_TIME;
    }

    public void setList_LAST_UPD_TIME(String list_LAST_UPD_TIME) {
        this.list_LAST_UPD_TIME = list_LAST_UPD_TIME;
    }

    public String getList_MODIFICATION_NUM() {
        return list_MODIFICATION_NUM;
    }

    public void setList_MODIFICATION_NUM(String list_MODIFICATION_NUM) {
        this.list_MODIFICATION_NUM = list_MODIFICATION_NUM;
    }

    public String getList_REMARKS() {
        return list_REMARKS;
    }

    public void setList_REMARKS(String list_REMARKS) {
        this.list_REMARKS = list_REMARKS;
    }

    public String getList_ROW_ID() {
        return list_ROW_ID;
    }

    public void setList_ROW_ID(String list_ROW_ID) {
        this.list_ROW_ID = list_ROW_ID;
    }

    public String getList_SORT_CODE() {
        return list_SORT_CODE;
    }

    public void setList_SORT_CODE(String list_SORT_CODE) {
        this.list_SORT_CODE = list_SORT_CODE;
    }

    public String getList_STATUS() {
        return list_STATUS;
    }

    public void setList_STATUS(String list_STATUS) {
        this.list_STATUS = list_STATUS;
    }

    public String getList_TYPE_CODE() {
        return list_TYPE_CODE;
    }

    public void setList_TYPE_CODE(String list_TYPE_CODE) {
        this.list_TYPE_CODE = list_TYPE_CODE;
    }

    public String getCode_LOV_NAME() {
        return code_LOV_NAME;
    }

    public void setCode_LOV_NAME(String code_LOV_NAME) {
        this.code_LOV_NAME = code_LOV_NAME;
    }




    /*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "WMS_BASE_CODELIST_CodelistDetailForm";
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��EAPDataFormat.parseString()��������ת��
     * @return EAPValueObject
     */
    public AFValueObject transform() {
        CodelistDetailVO vo = new CodelistDetailVO();
        vo.setList_CODE_NAME(AFDataFormat.parseString(list_CODE_NAME, vo.getList_CODE_NAME()));
        vo.setList_CODE_VALUE(AFDataFormat.parseString(list_CODE_VALUE, vo.getList_CODE_VALUE()));
        vo.setList_COMMENTS(AFDataFormat.parseString(list_COMMENTS, vo.getList_COMMENTS()));
        vo.setList_CREATED_BY(AFDataFormat.parseString(list_CREATED_BY, vo.getList_CREATED_BY()));
        vo.setList_CREATED_TIME(AFDataFormat.parseString(list_CREATED_TIME, vo.getList_CREATED_TIME()));
        vo.setList_LAST_UPD_BY(AFDataFormat.parseString(list_LAST_UPD_BY, vo.getList_LAST_UPD_BY()));
        vo.setList_LAST_UPD_TIME(AFDataFormat.parseString(list_LAST_UPD_TIME, vo.getList_LAST_UPD_TIME()));
        vo.setList_MODIFICATION_NUM(AFDataFormat.parseString(list_MODIFICATION_NUM, vo.getList_MODIFICATION_NUM()));
        vo.setList_REMARKS(AFDataFormat.parseString(list_REMARKS, vo.getList_REMARKS()));
        vo.setList_ROW_ID(AFDataFormat.parseString(list_ROW_ID, vo.getList_ROW_ID()));
        vo.setList_SORT_CODE(AFDataFormat.parseString(list_SORT_CODE, vo.getList_SORT_CODE()));
        vo.setList_STATUS(AFDataFormat.parseString(list_STATUS, vo.getList_STATUS()));
        vo.setList_TYPE_CODE(AFDataFormat.parseString(list_TYPE_CODE, vo.getList_TYPE_CODE()));
        vo.setCode_LOV_NAME(AFDataFormat.parseString(code_LOV_NAME, vo.getCode_LOV_NAME()));
        vo.setList_IS_DEFAULT(AFDataFormat.parseString(list_IS_DEFAULT, vo.getList_IS_DEFAULT()));

        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        CodelistDetailVO vo = (CodelistDetailVO)_vo;
        list_CODE_NAME = AFDataFormat.toString(vo.getList_CODE_NAME());
        list_CODE_VALUE = AFDataFormat.toString(vo.getList_CODE_VALUE());
        list_COMMENTS = AFDataFormat.toString(vo.getList_COMMENTS());
        list_CREATED_BY = AFDataFormat.toString(vo.getList_CREATED_BY());
        list_CREATED_TIME = AFDataFormat.toString(vo.getList_CREATED_TIME());
        list_LAST_UPD_BY = AFDataFormat.toString(vo.getList_LAST_UPD_BY());
        list_LAST_UPD_TIME = AFDataFormat.toString(vo.getList_LAST_UPD_TIME());
        list_MODIFICATION_NUM = AFDataFormat.toString(vo.getList_MODIFICATION_NUM());
        list_REMARKS = AFDataFormat.toString(vo.getList_REMARKS());
        list_ROW_ID = AFDataFormat.toString(vo.getList_ROW_ID());
        list_SORT_CODE = AFDataFormat.toString(vo.getList_SORT_CODE());
        list_STATUS = AFDataFormat.toString(vo.getList_STATUS());
        list_TYPE_CODE = AFDataFormat.toString(vo.getList_TYPE_CODE());
        code_LOV_NAME = AFDataFormat.toString(vo.getCode_LOV_NAME());
        list_IS_DEFAULT = AFDataFormat.toString(vo.getList_IS_DEFAULT());

    }

    /**
     * [������󷽷�ʵ��]
     * ��ʼ��������
     */
    public void initialize() {
        list_CODE_NAME = "";
        list_CODE_VALUE = "";
        list_COMMENTS = "";
        list_CREATED_BY = "";
        list_CREATED_TIME = "";
        list_LAST_UPD_BY = "";
        list_LAST_UPD_TIME = "";
        list_MODIFICATION_NUM = "";
        list_REMARKS = "";
        list_ROW_ID = "";
        list_SORT_CODE = "";
        list_STATUS = "";
        list_TYPE_CODE = "";
        code_LOV_NAME = "";
        list_IS_DEFAULT = "N";

    }

    /**
     * [���෽����д]
     * �жϵ�ǰ�������Ƿ���Ч
     * һ��Ϊ�ӱ����д�÷���
     * @return boolean
     */
    public boolean isValidate() {
        return StringUtils.isNotEmpty(list_CODE_VALUE);
    }

}