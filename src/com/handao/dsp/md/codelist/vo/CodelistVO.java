package com.handao.dsp.md.codelist.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.vo.AFCompositeValueObject;

public class CodelistVO extends AFCompositeValueObject {

    /*************************************** field ***************************************/
    private String type_COMMENTS;  //˵��
    private long type_CREATED_BY;  //������:ϵͳ�ֶΡ�
    private Date type_CREATED_TIME;  //����ʱ��:ϵͳ�ֶΡ�
    private long type_LAST_UPD_BY;  //�޸���:ϵͳ�ֶΡ�
    private Date type_LAST_UPD_TIME;  //�޸�ʱ��:ϵͳ�ֶΡ�
    private int type_MODIFICATION_NUM;  //�޸Ĵ���:ϵͳ�ֶΡ�
    private long type_ROW_ID;  //ROW_ID:ϵͳ�ֶΡ�
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

    public long getType_CREATED_BY() {
        return type_CREATED_BY;
    }

    public void setType_CREATED_BY(long type_CREATED_BY) {
        this.type_CREATED_BY = type_CREATED_BY;
    }

    public Date getType_CREATED_TIME() {
        return type_CREATED_TIME;
    }

    public void setType_CREATED_TIME(Date type_CREATED_TIME) {
        this.type_CREATED_TIME = type_CREATED_TIME;
    }

    public long getType_LAST_UPD_BY() {
        return type_LAST_UPD_BY;
    }

    public void setType_LAST_UPD_BY(long type_LAST_UPD_BY) {
        this.type_LAST_UPD_BY = type_LAST_UPD_BY;
    }

    public Date getType_LAST_UPD_TIME() {
        return type_LAST_UPD_TIME;
    }

    public void setType_LAST_UPD_TIME(Date type_LAST_UPD_TIME) {
        this.type_LAST_UPD_TIME = type_LAST_UPD_TIME;
    }

    public int getType_MODIFICATION_NUM() {
        return type_MODIFICATION_NUM;
    }

    public void setType_MODIFICATION_NUM(int type_MODIFICATION_NUM) {
        this.type_MODIFICATION_NUM = type_MODIFICATION_NUM;
    }

    public long getType_ROW_ID() {
        return type_ROW_ID;
    }

    public void setType_ROW_ID(long type_ROW_ID) {
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
     * ���ص�ǰ���ݶ���(VO)��������ϸ�б�
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_CodelistDetail};
    }

    /**
     * [������󷽷�ʵ��]
     * ����ָ����VOClass������ϸ�б�
     * @param detailVOClass String
     * @param dList List
     */
    public void setDetailList(String detailVOClass, List dList) {
        if(CodelistDetailVO.class.getName().equals(detailVOClass)) {
            dl_CodelistDetail = dList;
            return;
        }
    }

    /*************************************** customer ***************************************/
    private List dl_CodelistDetail = new ArrayList();

    public List getDetailList_CodelistDetail() {
        return dl_CodelistDetail;
    }

    public void setDetailList_CodelistDetail(List dl_CodelistDetail) {
        this.dl_CodelistDetail = dl_CodelistDetail;
    }
}