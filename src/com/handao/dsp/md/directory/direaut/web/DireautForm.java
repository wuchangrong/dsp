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
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
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
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "md_directory_DireautForm";
    }

    /**
     * [父类抽象方法实现]
     * 根据当前表单生成对应数据对象(VO)
     * 建议使用AFDataFormat.parseString()进行类型转换
     * @return AFValueObject
     */
    public AFValueObject transform() {
        DireautVO vo = new DireautVO();
        vo.setDetailList_DireautDetail(this.transformDetail(dl_DireautDetail));

        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        DireautVO vo = (DireautVO)_vo;
        
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
        dl_DireautDetail = this.transformDetail(vo.getDetailList_DireautDetail(), DireautDetailForm.class.getName());

    }

    /**
     * [父类抽象方法实现]
     * 初始化表单数据
     */
    public void initialize() {
		ROW_ID = "" ;


    }
    
    /**
     * [父类抽象方法实现]
     * 返回当前表单的所有明细列表
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_DireautDetail};
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
     * [框架调用自定义方法]
     * 根据索引获取InvoicenoticDetail表单
     * @param index int
     * @return AFForm
     */
    public AFForm getDetailForm_DireautDetail(int index) {
        return getDetailForm(dl_DireautDetail, index, DireautDetailForm.class.getName());
    }

}