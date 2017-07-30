package com.handao.dsp.md.directory.direaut.bo;

import com.handao.dsp.md.directory.direaut.dao.DireautDetailDAO;
import com.handao.dsp.md.directory.direaut.vo.DireautDetailVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.UserToken;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */
public class DireautDetailBO extends AFBizBO {

    private DireautDetailDAO dao_DireautDetail = (DireautDetailDAO)AFDAOProvider.getDAOByClass(
             "com.handao.dsp.md.directory.direaut.dao.DireautDetailDAO");

    /**
	 * @desc 返回当前活动DAO
	 * @param AFUserToken，AFValueObject
	 * @return AFBizDAO
	 * @author 
	 */
    protected AFBizDAO getActiveDAO(){
        return dao_DireautDetail;
    }
    
    //删除授权数据
    //参数：角色ID（如果为null，则删除所有角色的数据），是否包括子目录，指定路径
    public boolean deletePermission(Long roleID,boolean isSubdir,String path){
    	return dao_DireautDetail.deleteByRoleAndPath(roleID,isSubdir, path);
    }
    
    //新增授权数据
    public boolean addPermission(UserToken userToken,boolean isSubdir,String path,DireautDetailVO vo){
    	return dao_DireautDetail.insertByPath(userToken.getUserId(),isSubdir, path,vo);
    }
    
}