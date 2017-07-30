package com.handao.dsp.md.codelist.vo;

import java.sql.Date;
import com.handao.platform.framework.vo.AFValueObject;

public class CodelistDetailVO extends AFValueObject {

    /*************************************** field ***************************************/
    private String list_CODE_NAME;  //名称
    private String list_CODE_VALUE;  //值
    private String list_COMMENTS;  //说明
    private long list_CREATED_BY;  //创建人:系统字段。
    private Date list_CREATED_TIME;  //创建时间:系统字段。
    private long list_LAST_UPD_BY;  //修改人:系统字段。
    private Date list_LAST_UPD_TIME;  //修改时间:系统字段。
    private int list_MODIFICATION_NUM;  //修改次数:系统字段。
    private String list_REMARKS;  //备注
    private long list_ROW_ID;  //ROW_ID:系统字段。
    private String list_SORT_CODE;  //排序码
    private String list_STATUS;  //状态:0 有效，1 停用。
    private String list_TYPE_CODE;  //分类代码
    private String code_LOV_NAME;  //
    private long list_TYPE_ID;
    private String list_IS_DEFAULT;

    /**
     * @return list_IS_DEFAULT 的get方法
     */
    public String getList_IS_DEFAULT()
    {
        return list_IS_DEFAULT;
    }

    /**
     * @param list_IS_DEFAULT 的 set方法
     */
    public void setList_IS_DEFAULT(String list_IS_DEFAULT)
    {
        this.list_IS_DEFAULT = list_IS_DEFAULT;
    }

    /**
     * @return list_TYPE_ID 的get方法
     */
    public long getList_TYPE_ID()
    {
        return list_TYPE_ID;
    }

    /**
     * @param list_TYPE_ID 的 set方法
     */
    public void setList_TYPE_ID(long list_TYPE_ID)
    {
        this.list_TYPE_ID = list_TYPE_ID;
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

    public long getList_CREATED_BY() {
        return list_CREATED_BY;
    }

    public void setList_CREATED_BY(long list_CREATED_BY) {
        this.list_CREATED_BY = list_CREATED_BY;
    }

    public Date getList_CREATED_TIME() {
        return list_CREATED_TIME;
    }

    public void setList_CREATED_TIME(Date list_CREATED_TIME) {
        this.list_CREATED_TIME = list_CREATED_TIME;
    }

    public long getList_LAST_UPD_BY() {
        return list_LAST_UPD_BY;
    }

    public void setList_LAST_UPD_BY(long list_LAST_UPD_BY) {
        this.list_LAST_UPD_BY = list_LAST_UPD_BY;
    }

    public Date getList_LAST_UPD_TIME() {
        return list_LAST_UPD_TIME;
    }

    public void setList_LAST_UPD_TIME(Date list_LAST_UPD_TIME) {
        this.list_LAST_UPD_TIME = list_LAST_UPD_TIME;
    }

    public int getList_MODIFICATION_NUM() {
        return list_MODIFICATION_NUM;
    }

    public void setList_MODIFICATION_NUM(int list_MODIFICATION_NUM) {
        this.list_MODIFICATION_NUM = list_MODIFICATION_NUM;
    }

    public String getList_REMARKS() {
        return list_REMARKS;
    }

    public void setList_REMARKS(String list_REMARKS) {
        this.list_REMARKS = list_REMARKS;
    }

    public long getList_ROW_ID() {
        return list_ROW_ID;
    }

    public void setList_ROW_ID(long list_ROW_ID) {
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

}