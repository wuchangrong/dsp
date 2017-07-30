package com.handao.dsp.md.directory.direaut.dao;

import java.util.HashMap;

import com.handao.dsp.md.directory.direaut.vo.DireautDetailVO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */  
public class DireautDetailDAO extends AFBizDAO {
	
	/**
	 * @desc 返回当前DAO在SQLMap中的命名空间
	 * @return String
	 * @author
	 */
    protected String getNameSpace() {
        return "dsp.md.directory.direaut.DireautDetail";
    }

    //按目录路径删除授权数据
    //参数：是否包括子目录（true包括），指定路径
    //返回：删除成功true
    public boolean deleteByRoleAndPath(Long roleID,boolean isSubdir,String path) throws AFDAOException{
    	HashMap map=null;
    	if (path.length()<1 || path==null)
    		return false;
    	if (isSubdir)
    		path=path+"%";
    	map=new HashMap();
    	map.put("ROLE_ID", roleID);
    	map.put("DIRPATH", path);
    	try{
    		return daoCommand.sm_delete(getNameSpace()+".[delete-by-map]", map);
    	}
    	catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
    
    //按目录路径插入授权数据
    //参数：是否包括子目录（true包括），指定路径
    //返回：删除成功true
    public boolean insertByPath(long userID,boolean isSubdir,String path,DireautDetailVO vo) throws AFDAOException{
    	HashMap map=null;
    	if (path.length()<1 || path==null)
    		return false;
    	if (isSubdir)
    		path=path+"%";
    	map=new HashMap();
    	map.put("USER_ID", new Long(userID));
    	map.put("ROLE_ID", new Long(vo.getROLE_ID()));
    	map.put("RIGHADD", vo.getRIGHADD());
    	map.put("RIGHDEL", vo.getRIGHDEL());
    	map.put("RIGHEDI", vo.getRIGHEDI());
    	map.put("RIGHVIE", vo.getRIGHVIE());
    	map.put("RIGHAUD", vo.getRIGHAUD());
    	map.put("DIRPATH", path);
    	try{
    		return daoCommand.sm_insert(getNameSpace()+".[insert-by-path]", map);
    	}
    	catch(Exception ex) {
            throw new AFDAOException(ex);
        }
    }
    
}