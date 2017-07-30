package com.handao.dsp.md.directory.direaut.bo;

import com.handao.dsp.md.directory.direaut.dao.DireautDetailDAO;
import com.handao.dsp.md.directory.direaut.vo.DireautDetailVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.UserToken;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class DireautDetailBO extends AFBizBO {

    private DireautDetailDAO dao_DireautDetail = (DireautDetailDAO)AFDAOProvider.getDAOByClass(
             "com.handao.dsp.md.directory.direaut.dao.DireautDetailDAO");

    /**
	 * @desc ���ص�ǰ�DAO
	 * @param AFUserToken��AFValueObject
	 * @return AFBizDAO
	 * @author 
	 */
    protected AFBizDAO getActiveDAO(){
        return dao_DireautDetail;
    }
    
    //ɾ����Ȩ����
    //��������ɫID�����Ϊnull����ɾ�����н�ɫ�����ݣ����Ƿ������Ŀ¼��ָ��·��
    public boolean deletePermission(Long roleID,boolean isSubdir,String path){
    	return dao_DireautDetail.deleteByRoleAndPath(roleID,isSubdir, path);
    }
    
    //������Ȩ����
    public boolean addPermission(UserToken userToken,boolean isSubdir,String path,DireautDetailVO vo){
    	return dao_DireautDetail.insertByPath(userToken.getUserId(),isSubdir, path,vo);
    }
    
}