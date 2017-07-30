package com.handao.dsp.sb.daily.route.web;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.util.AFDataFormat;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFCompositeForm;
import com.handao.platform.framework.web.AFForm;
import com.handao.platform.framework.web.AFSearchForm;
import com.handao.platform.framework.web.AFSearchOperation;

import com.handao.dsp.sb.daily.route.vo.RouteDailyVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 15, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class RouteDailyForm extends AFCompositeForm implements AFSearchOperation {

    /*************************************** field ***************************************/
	private String ROW_ID = "";  //行号
	private String CREATED_BY = "";  //创建人
	private String CREATED_TIME = "";  //创建时间
	private String LAST_UPD_BY = "";  //最近修改人
	private String LAST_UPD_TIME = "";  //最近修改时间
	private String MODIFICATION_NUM = "";  //修改次数
	private String COMPANY_ID = "";  //公司标识
	private String DEPT_ID = "";  //部门标识
	private String VISIT_DATE = "";  //拜访日期
	private String REPORT_EMP = "";  //填报人
	private String REMARK = "";  //备注
	private String RESERVE1 = "";
	private String RESERVE2 = "";
	private String RESERVE3 = "";
	private String IS_USING = "";  //是否有效
	private String STATUS = "";  //状态:0 初始，1 提交  2完成。

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

	public String getCOMPANY_ID(){
		return COMPANY_ID;
	}

	public void setCOMPANY_ID(String company_id){
		COMPANY_ID = company_id;
	}

	public String getDEPT_ID(){
		return DEPT_ID;
	}

	public void setDEPT_ID(String dept_id){
		DEPT_ID = dept_id;
	}

	public String getVISIT_DATE(){
		return VISIT_DATE;
	}

	public void setVISIT_DATE(String visit_date){
		VISIT_DATE = visit_date;
	}

	public String getREPORT_EMP(){
		return REPORT_EMP;
	}

	public void setREPORT_EMP(String report_emp){
		REPORT_EMP = report_emp;
	}

	public String getREMARK(){
		return REMARK;
	}

	public void setREMARK(String remark){
		REMARK = remark;
	}

	public String getRESERVE1(){
		return RESERVE1;
	}

	public void setRESERVE1(String reserve1){
		RESERVE1 = reserve1;
	}

	public String getRESERVE2(){
		return RESERVE2;
	}

	public void setRESERVE2(String reserve2){
		RESERVE2 = reserve2;
	}

	public String getRESERVE3(){
		return RESERVE3;
	}

	public void setRESERVE3(String reserve3){
		RESERVE3 = reserve3;
	}

	public String getIS_USING(){
		return IS_USING;
	}

	public void setIS_USING(String is_using){
		IS_USING = is_using;
	}

	public String getSTATUS(){
		return STATUS;
	}

	public void setSTATUS(String status){
		STATUS = status;
	}

 

	



    /*************************************** implement ***************************************/
    /**
     * [父类抽象方法实现]
     * 返回表单名称
     * @return String
     */
    public String getFormName() {
        return "sb_daily_RouteDailyForm";
    }

    /**
     * [父类抽象方法实现]
     * 根据当前表单生成对应数据对象(VO)
     * 建议使用AFDataFormat.parseString()进行类型转换
     * @return AFValueObject
     */
    public AFValueObject transform() {
        RouteDailyVO vo = new RouteDailyVO();
        
		vo.setROW_ID(AFDataFormat.parseString(ROW_ID, vo.getROW_ID()));
		vo.setCREATED_BY(AFDataFormat.parseString(CREATED_BY, vo.getCREATED_BY()));
		vo.setCREATED_TIME(AFDataFormat.parseString(CREATED_TIME, vo.getCREATED_TIME()));
		vo.setLAST_UPD_BY(AFDataFormat.parseString(LAST_UPD_BY, vo.getLAST_UPD_BY()));
		vo.setLAST_UPD_TIME(AFDataFormat.parseString(LAST_UPD_TIME, vo.getLAST_UPD_TIME()));
		vo.setMODIFICATION_NUM(AFDataFormat.parseString(MODIFICATION_NUM, vo.getMODIFICATION_NUM()));
		vo.setCOMPANY_ID(AFDataFormat.parseString(COMPANY_ID, vo.getCOMPANY_ID()));
		vo.setDEPT_ID(AFDataFormat.parseString(DEPT_ID, vo.getDEPT_ID()));
		vo.setVISIT_DATE(AFDataFormat.parseString(VISIT_DATE, vo.getVISIT_DATE()));
		vo.setREPORT_EMP(AFDataFormat.parseString(REPORT_EMP, vo.getREPORT_EMP()));
		vo.setREMARK(AFDataFormat.parseString(REMARK, vo.getREMARK()));
		vo.setRESERVE1(AFDataFormat.parseString(RESERVE1, vo.getRESERVE1()));
		vo.setRESERVE2(AFDataFormat.parseString(RESERVE2, vo.getRESERVE2()));
		vo.setRESERVE3(AFDataFormat.parseString(RESERVE3, vo.getRESERVE3()));
		vo.setIS_USING(AFDataFormat.parseString(IS_USING, vo.getIS_USING()));
		vo.setSTATUS(AFDataFormat.parseString(STATUS, vo.getSTATUS()));

		vo.setDetailList_RouteDailyDetail(this.transformDetail(dl_RouteDailyDetail));
        return vo;
    }

    /**
     * [父类抽象方法实现]
     * 将传入的数据对象(VO)对应到当前表单
     * 建议使用AFDataFormat.toString()进行类型转换
     */
    public void transform(AFValueObject _vo) {
        RouteDailyVO vo = (RouteDailyVO)_vo;
        
		ROW_ID = AFDataFormat.toString((vo.getROW_ID()));
		CREATED_BY = AFDataFormat.toString((vo.getCREATED_BY()));
		CREATED_TIME = AFDataFormat.toString((vo.getCREATED_TIME()));
		LAST_UPD_BY = AFDataFormat.toString((vo.getLAST_UPD_BY()));
		LAST_UPD_TIME = AFDataFormat.toString((vo.getLAST_UPD_TIME()));
		MODIFICATION_NUM = AFDataFormat.toString((vo.getMODIFICATION_NUM()));
		COMPANY_ID = AFDataFormat.toString((vo.getCOMPANY_ID()));
		DEPT_ID = AFDataFormat.toString((vo.getDEPT_ID()));
		VISIT_DATE = AFDataFormat.toString((vo.getVISIT_DATE()));
		REPORT_EMP = AFDataFormat.toString((vo.getREPORT_EMP()));
		REMARK = AFDataFormat.toString((vo.getREMARK()));
		RESERVE1 = AFDataFormat.toString((vo.getRESERVE1()));
		RESERVE2 = AFDataFormat.toString((vo.getRESERVE2()));
		RESERVE3 = AFDataFormat.toString((vo.getRESERVE3()));
		IS_USING = AFDataFormat.toString((vo.getIS_USING()));
		STATUS = AFDataFormat.toString((vo.getSTATUS()));


		dl_RouteDailyDetail = this.transformDetail(vo.getDetailList_RouteDailyDetail(), RouteDailyDetailForm.class.getName());
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
		COMPANY_ID = "" ;
		DEPT_ID = "" ;
		VISIT_DATE = "" ;
		REPORT_EMP = "" ;
		REMARK = "" ;
		RESERVE1 = "" ;
		RESERVE2 = "" ;
		RESERVE3 = "" ;
		IS_USING = "" ;
		STATUS = "" ;


    }
    
    /**
     * [父类抽象方法实现]
     * 返回当前表单的所有明细列表
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_RouteDailyDetail};
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
    	searchForm = new RouteDailySearchForm();
    }        

    /*************************************** customer ***************************************/
    private RouteDailySearchForm searchForm = new RouteDailySearchForm();

    private List dl_RouteDailyDetail = new ArrayList();

    public List getDetailList_RouteDailyDetail() {
        return dl_RouteDailyDetail;
    }

    public void setDetailList_RouteDailyDetail(List dl_RouteDailyDetail) {
        this.dl_RouteDailyDetail = dl_RouteDailyDetail;
    }

    public int getDetailSize_RouteDailyDetail() {
        return getDetailSize(dl_RouteDailyDetail);
    }


    /**
     * [框架调用自定义方法]
     * 根据索引获取InvoicenoticDetail表单
     * @param index int
     * @return AFForm
     */
    public AFForm getDetailForm_RouteDailyDetail(int index) {
        return getDetailForm(dl_RouteDailyDetail, index, RouteDailyDetailForm.class.getName());
    }

}