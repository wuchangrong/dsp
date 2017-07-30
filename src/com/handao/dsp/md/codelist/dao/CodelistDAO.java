package com.handao.dsp.md.codelist.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class CodelistDAO extends AFBizDAO {

    /**
     * [父类抽象方法实现]
     * 返回当前DAO在SQLMap中的命名空间
     * @return String
     */
    protected String getNameSpace() {
        return "dsp.md.codelist.Codelist";
    }

}