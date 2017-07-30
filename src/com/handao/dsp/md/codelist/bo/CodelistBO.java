package com.handao.dsp.md.codelist.bo;

import java.util.List;

import com.handao.dsp.md.codelist.dao.CodelistDAO;
import com.handao.dsp.md.codelist.vo.CodelistDetailVO;
import com.handao.dsp.md.codelist.vo.CodelistVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.bo.AFBizCompositeBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;

public class CodelistBO extends AFBizCompositeBO {

    private CodelistDetailBO bo_CodelistDetail = (CodelistDetailBO)AFBOProvider.getBOByClass("com.handao.dsp.md.codelist.bo.CodelistDetailBO");

    private CodelistDAO dao_Codelist = (CodelistDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.codelist.dao.CodelistDAO");


    public CodelistBO() {
        this.addListener(new AFBizBOListenerImpl() {
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                long masterID = AFIDFactory.getNextID();
                CodelistVO masterVO = (CodelistVO)vo;
                masterVO.setType_ROW_ID(masterID);
                masterVO.setType_CREATED_BY(userToken.getUserId());
                masterVO.setType_LAST_UPD_BY(userToken.getUserId());

                List dl_CodelistDetail = masterVO.getDetailList_CodelistDetail();
                for(int i = 0; i < dl_CodelistDetail.size(); i++) {
                    CodelistDetailVO vo_new = (CodelistDetailVO)dl_CodelistDetail.get(i);
                    vo_new.setList_ROW_ID(AFIDFactory.getNextID());
                    vo_new.setList_TYPE_CODE(masterVO.getType_TYPE_CODE());
                    vo_new.setList_CREATED_BY(userToken.getUserId());
                    vo_new.setList_LAST_UPD_BY(userToken.getUserId());
                    vo_new.setList_TYPE_ID(masterID);
                }

                return true;
            }

            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo) {
                long masterID = ((CodelistVO)vo).getType_ROW_ID();

                List dl_CodelistDetail_new = ((CodelistVO)vo).getDetailList_CodelistDetail();
                List dl_CodelistDetail_src = bo_CodelistDetail.doSearchByMaster(masterID);
                ((CodelistVO)vo).setType_LAST_UPD_BY(userToken.getUserId());
                for(int i = 0; i < dl_CodelistDetail_new.size(); i++) {
                    CodelistDetailVO detailVO_new = (CodelistDetailVO)dl_CodelistDetail_new.get(i);
                    detailVO_new.setList_LAST_UPD_BY(userToken.getUserId());
                    detailVO_new.setList_TYPE_CODE(((CodelistVO)vo).getType_TYPE_CODE());
                    boolean insertFlag = true;
                    for(int j = 0; j < dl_CodelistDetail_src.size(); ) {
                        CodelistDetailVO detailVO_src = (CodelistDetailVO)dl_CodelistDetail_src.get(j);
                        if(detailVO_new.getList_ROW_ID()==detailVO_src.getList_ROW_ID()) {
                            detailVO_new.setVOStatus(AFValueObject.STATUS_MODIFY);
                            dl_CodelistDetail_src.remove(j);
                            insertFlag = false;
                            break;
                        }
                        j++;
                    }
                    if(insertFlag) {
                        detailVO_new.setList_ROW_ID(AFIDFactory.getNextID());
                        detailVO_new.setVOStatus(AFValueObject.STATUS_NEW);
                        detailVO_new.setList_CREATED_BY(userToken.getUserId());
                        detailVO_new.setList_TYPE_ID(masterID);
                    }
                }
                for(int i = 0; i < dl_CodelistDetail_src.size(); i++) {
                    CodelistDetailVO detailVO_src = (CodelistDetailVO)dl_CodelistDetail_src.get(i);
                    detailVO_src.setVOStatus(AFValueObject.STATUS_DELETE);
                    dl_CodelistDetail_new.add(detailVO_src);
                }

                return true;
            }

        });
    }


    /**
     * [父类抽象方法实现]
     * 返回当前活动DAO
     * @return AFBizDAO
     */
    protected AFBizDAO getActiveDAO() {
        return dao_Codelist;
    }

    /**
     * [父类抽象方法实现]
     * 返回当前BO的子BO集
     * @return AFBizBO[]
     */
    protected AFBizBO[] getDetailBO() {
        return new AFBizBO[] {bo_CodelistDetail};
    }

    /**
     * [父类抽象方法实现]
     * 根据指定VOClass返回对应的操作BO
     * @param detailVOClass String
     * @return AFBizBO
     */
    protected AFBizBO getOperateBO(String detailVOClass) {
        if(CodelistDetailVO.class.getName().equals(detailVOClass))
            return bo_CodelistDetail;

        return null;
    }
}