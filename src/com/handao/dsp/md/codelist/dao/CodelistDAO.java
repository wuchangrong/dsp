package com.handao.dsp.md.codelist.dao;

import com.handao.platform.framework.biz.dao.AFBizDAO;

public class CodelistDAO extends AFBizDAO {

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰDAO��SQLMap�е������ռ�
     * @return String
     */
    protected String getNameSpace() {
        return "dsp.md.codelist.Codelist";
    }

}