package com.handao.dsp.md.directory.direaut.vo;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import com.handao.platform.framework.vo.AFCompositeValueObject;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */ 

public class DireautVO extends AFCompositeValueObject{
	
	private long ROW_ID;  //ROW_ID

	public long getROW_ID(){
		return ROW_ID;
	}

	public void setROW_ID(long row_id){
		ROW_ID = row_id;
	}


	
    /*************************************** customer ***************************************/
    private List dl_DireautDetail = new ArrayList();

    public List getDetailList_DireautDetail() {
        return dl_DireautDetail; 
    }

    public void setDetailList_DireautDetail(List dl_DireautDetail) {
        this.dl_DireautDetail = dl_DireautDetail;
    }

    /*************************************** implement ***************************************/	
    /**
     * [父类抽象方法实现]
     * 返回当前数据对象(VO)的所有明细列表
     * @return List[]
     */
    public List[] getDetailList() {
        return new List[] {dl_DireautDetail};
    }

    /**
     * [父类抽象方法实现]
     * 根据指定的VOClass设置明细列表
     * @param detailVOClass String
     * @param dList List
     */
    public void setDetailList(String detailVOClass, List dList) {
        if(DireautDetailVO.class.getName().equals(detailVOClass)) {
            dl_DireautDetail = dList;
            return;
        }
    }
    
}