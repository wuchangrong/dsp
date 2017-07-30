package com.handao.dsp.md.codelist.web;

import java.util.ArrayList;
import java.util.List;

import com.handao.dsp.md.codelist.vo.CodelistVO;
import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFCompositeForm;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

public class CodelistForm extends AFCompositeForm implements AFSearchOperation {

    /*************************************** field ***************************************/
    private String type_COMMENTS;  //˵��
    private String type_CREATED_BY;  //������:ϵͳ�ֶΡ�
    private String type_CREATED_TIME;  //����ʱ��:ϵͳ�ֶΡ�
    private String type_LAST_UPD_BY;  //�޸���:ϵͳ�ֶΡ�
    private String type_LAST_UPD_TIME;  //�޸�ʱ��:ϵͳ�ֶΡ�
    private String type_MODIFICATION_NUM;  //�޸Ĵ���:ϵͳ�ֶΡ�
    private String type_ROW_ID;  //ROW_ID:ϵͳ�ֶΡ�
    private String type_STATUS;  //״̬:0 ��Ч��1 ͣ�á�
    private String type_TYPE_CODE;  //�������
    private String type_TYPE_NAME;  //��������
    private String code_LOV_NAME;  //

    public String getType_COMMENTS() {
        return type_COMMENTS;
    }

    public void setType_COMMENTS(String type_COMMENTS) {
        this.type_COMMENTS = type_COMMENTS;
    }

    public String getType_CREATED_BY() {
        return type_CREATED_BY;
    }

    public void setType_CREATED_BY(String type_CREATED_BY) {
        this.type_CREATED_BY = type_CREATED_BY;
    }

    public String getType_CREATED_TIME() {
        return type_CREATED_TIME;
    }

    public void setType_CREATED_TIME(String type_CREATED_TIME) {
        this.type_CREATED_TIME = type_CREATED_TIME;
    }

    public String getType_LAST_UPD_BY() {
        return type_LAST_UPD_BY;
    }

    public void setType_LAST_UPD_BY(String type_LAST_UPD_BY) {
        this.type_LAST_UPD_BY = type_LAST_UPD_BY;
    }

    public String getType_LAST_UPD_TIME() {
        return type_LAST_UPD_TIME;
    }

    public void setType_LAST_UPD_TIME(String type_LAST_UPD_TIME) {
        this.type_LAST_UPD_TIME = type_LAST_UPD_TIME;
    }

    public String getType_MODIFICATION_NUM() {
        return type_MODIFICATION_NUM;
    }

    public void setType_MODIFICATION_NUM(String type_MODIFICATION_NUM) {
        this.type_MODIFICATION_NUM = type_MODIFICATION_NUM;
    }

    public String getType_ROW_ID() {
        return type_ROW_ID;
    }

    public void setType_ROW_ID(String type_ROW_ID) {
        this.type_ROW_ID = type_ROW_ID;
    }

    public String getType_STATUS() {
        return type_STATUS;
    }

    public void setType_STATUS(String type_STATUS) {
        this.type_STATUS = type_STATUS;
    }

    public String getType_TYPE_CODE() {
        return type_TYPE_CODE;
    }

    public void setType_TYPE_CODE(String type_TYPE_CODE) {
        this.type_TYPE_CODE = type_TYPE_CODE;
    }

    public String getType_TYPE_NAME() {
        return type_TYPE_NAME;
    }

    public void setType_TYPE_NAME(String type_TYPE_NAME) {
        this.type_TYPE_NAME = type_TYPE_NAME;
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
        return "WMS_BASE_CODELIST_CodelistForm";
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��EAPDataFormat.parseString()��������ת��
     * @return EAPValueObject
     */
    public AFValueObject transform() {
        CodelistVO vo = new CodelistVO();
        vo.setType_COMMENTS(AFDataFormat.parseString(type_COMMENTS, vo.getType_COMMENTS()));
        vo.setType_CREATED_BY(AFDataFormat.parseString(type_CREATED_BY, vo.getType_CREATED_BY()));
        vo.setType_CREATED_TIME(AFDataFormat.parseString(type_CREATED_TIME, vo.getType_CREATED_TIME()));
        vo.setType_LAST_UPD_BY(AFDataFormat.parseString(type_LAST_UPD_BY, vo.getType_LAST_UPD_BY()));
        vo.setType_LAST_UPD_TIME(AFDataFormat.parseString(type_LAST_UPD_TIME, vo.getType_LAST_UPD_TIME()));
        vo.setType_MODIFICATION_NUM(AFDataFormat.parseString(type_MODIFICATION_NUM, vo.getType_MODIFICATION_NUM()));
        vo.setType_ROW_ID(AFDataFormat.parseString(type_ROW_ID, vo.getType_ROW_ID()));
        vo.setType_STATUS(AFDataFormat.parseString(type_STATUS, vo.getType_STATUS()));
        vo.setType_TYPE_CODE(AFDataFormat.parseString(type_TYPE_CODE, vo.getType_TYPE_CODE()));
        vo.setType_TYPE_NAME(AFDataFormat.parseString(type_TYPE_NAME, vo.getType_TYPE_NAME()));
        vo.setCode_LOV_NAME(AFDataFormat.parseString(code_LOV_NAME, vo.getCode_LOV_NAME()));

        vo.setDetailList_CodelistDetail(this.transformDetail(dl_CodelistDetail));
        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        CodelistVO vo = (CodelistVO)_vo;
        type_COMMENTS = AFDataFormat.toString(vo.getType_COMMENTS());
        type_CREATED_BY = AFDataFormat.toString(vo.getType_CREATED_BY());
        type_CREATED_TIME = AFDataFormat.toString(vo.getType_CREATED_TIME());
        type_LAST_UPD_BY = AFDataFormat.toString(vo.getType_LAST_UPD_BY());
        type_LAST_UPD_TIME = AFDataFormat.toString(vo.getType_LAST_UPD_TIME());
        type_MODIFICATION_NUM = AFDataFormat.toString(vo.getType_MODIFICATION_NUM());
        type_ROW_ID = AFDataFormat.toString(vo.getType_ROW_ID());
        type_STATUS = AFDataFormat.toString(vo.getType_STATUS());
        type_TYPE_CODE = AFDataFormat.toString(vo.getType_TYPE_CODE());
        type_TYPE_NAME = AFDataFormat.toString(vo.getType_TYPE_NAME());
        code_LOV_NAME = AFDataFormat.toString(vo.getCode_LOV_NAME());

        dl_CodelistDetail = this.transformDetail(vo.getDetailList_CodelistDetail(), CodelistDetailForm.class.getName());
    }

    /**
     * [������󷽷�ʵ��]
     * ��ʼ��������
     */
    public void initialize() {
        type_COMMENTS = "";
        type_CREATED_BY = "";
        type_CREATED_TIME = "";
        type_LAST_UPD_BY = "";
        type_LAST_UPD_TIME = "";
        type_MODIFICATION_NUM = "";
        type_ROW_ID = "";
        type_STATUS = "";
        type_TYPE_CODE = "";
        type_TYPE_NAME = "";
        code_LOV_NAME = "";

    }

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ����������ϸ�б�
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_CodelistDetail};
    }

    /**
     * [�ӿڷ���ʵ��]
     * ���ز�ѯ��
     * @return EAPSearchForm
     */
    public AFSearchForm getSearchForm() {
        return searchForm;
    }

    /*************************************** customer ***************************************/
    private CodelistSearchForm searchForm = new CodelistSearchForm();

    private List dl_CodelistDetail = new ArrayList();

    public List getDetailList_CodelistDetail() {
        return dl_CodelistDetail;
    }

    public void setDetailList_CodelistDetail(List dl_CodelistDetail) {
        this.dl_CodelistDetail = dl_CodelistDetail;
    }

    public int getDetailSize_CodelistDetail() {
        return getDetailSize(dl_CodelistDetail);
    }


    /**
     * [��ܵ����Զ��巽��]
     * ����������ȡCodelistDetail��
     * @param index int
     * @return EAPForm
     */
    public AFForm getDetailForm_CodelistDetail(int index) {
        return getDetailForm(dl_CodelistDetail, index, CodelistDetailForm.class.getName());
    }

	public void initSearchForm() {
        type_COMMENTS = "";
        type_CREATED_BY = "";
        type_CREATED_TIME = "";
        type_LAST_UPD_BY = "";
        type_LAST_UPD_TIME = "";
        type_MODIFICATION_NUM = "";
        type_ROW_ID = "";
        type_STATUS = "";
        type_TYPE_CODE = "";
        type_TYPE_NAME = "";
        code_LOV_NAME = "";		
	}
    
    

}