package com.handao.platform.sm.userdesk.userdeskSet.vo;


import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.vo.AFCompositeValueObject;

public class UserdeskSetVO extends AFCompositeValueObject {

    /**
	 * �ֶι�������
	 */
	private static final long serialVersionUID = 1L;
	/*************************************** field ***************************************/
    private long m_ROW_ID;  //ϵͳ�ֶΣ������¼ʱ�Զ����ɣ����ݿ�����ֵΨһ��
    private long m_CREATED_BY;  //ϵͳ�ֶΣ������¼���û�ID��
    private long m_LAST_UPD_BY;  //ϵͳ�ֶΣ����һ���޸ļ�¼���û�ID��
    private String m_GROUP_CODE="";  //�������
    private String m_GROUP_NAME="";  //��������
    private String m_LABEL="";  //����: ��ʾ�����֡�
    private int m_DISP_NO;  //��ʾ˳���: ������ʾ���������ݡ�
    private String m_VISIABLE="";  //�Ƿ���ʾ
    private int m_LINE_NUM;  //����
    private int m_COL_NUM;  //����
    private String m_STATUS="";  //״̬: ������
    private long m_ROLE_ID;  //�û�ID

   



    public long getM_ROW_ID() {
		return m_ROW_ID;
	}

	public void setM_ROW_ID(long m_row_id) {
		m_ROW_ID = m_row_id;
	}

	public long getM_CREATED_BY() {
		return m_CREATED_BY;
	}

	public void setM_CREATED_BY(long m_created_by) {
		m_CREATED_BY = m_created_by;
	}

	public long getM_LAST_UPD_BY() {
		return m_LAST_UPD_BY;
	}

	public void setM_LAST_UPD_BY(long m_last_upd_by) {
		m_LAST_UPD_BY = m_last_upd_by;
	}

	public String getM_GROUP_CODE() {
		return m_GROUP_CODE;
	}

	public void setM_GROUP_CODE(String m_group_code) {
		m_GROUP_CODE = m_group_code;
	}

	public String getM_GROUP_NAME() {
		return m_GROUP_NAME;
	}

	public void setM_GROUP_NAME(String m_group_name) {
		m_GROUP_NAME = m_group_name;
	}

	public String getM_LABEL() {
		return m_LABEL;
	}

	public void setM_LABEL(String m_label) {
		m_LABEL = m_label;
	}

	public int getM_DISP_NO() {
		return m_DISP_NO;
	}

	public void setM_DISP_NO(int m_disp_no) {
		m_DISP_NO = m_disp_no;
	}

	public String getM_VISIABLE() {
		return m_VISIABLE;
	}

	public void setM_VISIABLE(String m_visiable) {
		m_VISIABLE = m_visiable;
	}

	public int getM_LINE_NUM() {
		return m_LINE_NUM;
	}

	public void setM_LINE_NUM(int m_line_num) {
		m_LINE_NUM = m_line_num;
	}

	public int getM_COL_NUM() {
		return m_COL_NUM;
	}

	public void setM_COL_NUM(int m_col_num) {
		m_COL_NUM = m_col_num;
	}

	public String getM_STATUS() {
		return m_STATUS;
	}

	public void setM_STATUS(String m_status) {
		m_STATUS = m_status;
	}

	public long getM_ROLE_ID() {
		return m_ROLE_ID;
	}

	public void setM_ROLE_ID(long m_role_id) {
		m_ROLE_ID = m_role_id;
	}

	/*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ���ݶ���(VO)��������ϸ�б�
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_UserdeskSetDetail};
    }

    /**
     * [������󷽷�ʵ��]
     * ����ָ����VOClass������ϸ�б�
     * @param detailVOClass String
     * @param dList List
     */
    public void setDetailList(String detailVOClass, List dList) {
        if(UserdeskSetDetailVO.class.getName().equals(detailVOClass)) {
            dl_UserdeskSetDetail = dList;
            return;
        }
    }

    /*************************************** customer ***************************************/
    private List dl_UserdeskSetDetail = new ArrayList();

    public List getDetailList_UserdeskSetDetail() {
        return dl_UserdeskSetDetail;
    }

    public void setDetailList_UserdeskSetDetail(List dl_UserdeskSetDetail) {
        this.dl_UserdeskSetDetail = dl_UserdeskSetDetail;
    }
}