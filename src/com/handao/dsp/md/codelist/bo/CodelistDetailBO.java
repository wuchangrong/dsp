package com.handao.dsp.md.codelist.bo;

import com.handao.dsp.md.codelist.dao.CodelistDetailDAO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;

public class CodelistDetailBO extends AFBizBO {

    private CodelistDetailDAO dao_CodelistDetail = (CodelistDetailDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.codelist.dao.CodelistDetailDAO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动DAO
     * @return EAPBizDAO
     */
    protected AFBizDAO getActiveDAO() {
        return dao_CodelistDetail;
    }

}