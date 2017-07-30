package com.handao.dsp.md.directory.direaut.web;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFCompositeForm;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

import com.handao.dsp.md.directory.direaut.vo.DireautVO;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class DireautForm extends AFCompositeForm implements AFSearchOperation {

    /*************************************** field ***************************************/
	private String ROW_ID = "";  //ROW_ID

	public String getROW_ID(){
		return ROW_ID;
	}

	public void setROW_ID(String row_id){
		ROW_ID = row_id;
	}

 

	



    /*************************************** implement ***************************************/
    /**
     * [������󷽷�ʵ��]
     * ���ر�����
     * @return String
     */
    public String getFormName() {
        return "md_directory_DireautForm";
    }

    /**
     * [������󷽷�ʵ��]
     * ���ݵ�ǰ�����ɶ�Ӧ���ݶ���(VO)
     * ����ʹ��AFDataFormat.parseString()��������ת��
     * @return AFValueObject
     */
    public AFValueObject transform() {
        DireautVO vo = new DireautVO();
        vo.setDetailList_DireautDetail(this.transformDetail(dl_DireautDetail));

        return vo;
    }

    /**
     * [������󷽷�ʵ��]
     * ����������ݶ���(VO)��Ӧ����ǰ��
     * ����ʹ��AFDataFormat.toString()��������ת��
     */
    public void transform(AFValueObject _vo) {
        DireautVO vo = (DireautVO)_vo;
        
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
        dl_DireautDetail = this.transformDetail(vo.getDetailList_DireautDetail(), DireautDetailForm.class.getName());

    }

    /**
     * [������󷽷�ʵ��]
     * ��ʼ��������
     */
    public void initialize() {
		ROW_ID = "" ;


    }
    
    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ����������ϸ�б�
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_DireautDetail};
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
    	searchForm = new DireautSearchForm();
    }        

    /*************************************** customer ***************************************/
    private DireautSearchForm searchForm = new DireautSearchForm();

    private List dl_DireautDetail = new ArrayList();

    public List getDetailList_DireautDetail() {
        return dl_DireautDetail;
    }

    public void setDetailList_DireautDetail(List dl_DireautDetail) {
        this.dl_DireautDetail = dl_DireautDetail;
    }

    public int getDetailSize_DireautDetail() {
        return getDetailSize(dl_DireautDetail);
    }


    /**
     * [��ܵ����Զ��巽��]
     * ����������ȡInvoicenoticDetail��
     * @param index int
     * @return AFForm
     */
    public AFForm getDetailForm_DireautDetail(int index) {
        return getDetailForm(dl_DireautDetail, index, DireautDetailForm.class.getName());
    }

}