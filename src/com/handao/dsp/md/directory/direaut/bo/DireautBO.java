package com.handao.dsp.md.directory.direaut.bo;

import java.util.List;

import sun.text.CompactShortArray.Iterator;

import com.handao.dsp.md.directory.direaut.vo.DireautDetailVO;
import com.handao.dsp.md.directory.direaut.vo.DireautVO;
import com.handao.dsp.md.directory.directoryman.dao.DirectoryDAO;
import com.handao.dsp.md.directory.directoryman.vo.DirectoryVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizCompositeBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFValueObject;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 16, 2010</p>
 * @author wucr
 * @version $Revision
 */

public class DireautBO extends AFBizCompositeBO{	
	
	private DireautDetailBO bo_DireautDetail = (DireautDetailBO)AFBOProvider.getBOByClass(
	         "com.handao.dsp.md.directory.direaut.bo.DireautDetailBO");
    
    /**
	 * @desc ���ص�ǰ�DAO
	 * @return AFBizDAO
	 * @author liguozhi
	 */
    protected AFBizDAO getActiveDAO(){
        return null;
    }

    /**
	 * @desc ���ص�ǰBO����BO��
	 * @return AFBizBO[]
	 * @author liguozhi
	 */
    protected AFBizBO[] getDetailBO(){
        return new AFBizBO[] {bo_DireautDetail};
    }

    /**
	 * @desc ����ָ��VOClass���ض�Ӧ�Ĳ���BO
	 * @param  detailVOClass
	 * @return AFBizBO
	 * @author liguozhi
	 */
    protected AFBizBO getOperateBO(String detailVOClass){        
    	if(DireautDetailVO.class.getName().equals(detailVOClass)){
            return bo_DireautDetail;
        }
        return null;
    }
	
    //ȡĿ¼��Ȩ�����������Ȩ�Լ�δ��Ȩ�ģ�
    public AFValueObject doFind(AFUserToken userToken, long id) throws AFBOException {
        try {
        	DireautVO vo = new DireautVO();
            List list = bo_DireautDetail.doSearchByMaster(id);
            vo.setDetailList(DireautDetailVO.class.getName(), list);
            return vo;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

    //������Ȩ��Ϣ
    //��ɾ����ǰĿ¼���������Ŀ¼����Ȩ���ݣ��ٲ����µ���Ȩ����
    public boolean updatePermisson(UserToken userToken,DireautVO vo,long currentDirID, boolean isSubdir )
    {
    	boolean rc=false;
    	DirectoryDAO ddao=new DirectoryDAO();
    	DirectoryVO dvo=(DirectoryVO)ddao.doFindById(currentDirID);
    	DireautDetailVO detailVO=null;
    	if (dvo!=null){
    		//ɾ����ǰĿ¼����ȫ����Ŀ¼��ȫ����Ȩ����
    		rc=bo_DireautDetail.deletePermission(null,isSubdir, dvo.getPATH());
    		if (rc){
    			for(int i=0;i<vo.getDetailList_DireautDetail().size();i++){
    				detailVO=(DireautDetailVO)vo.getDetailList_DireautDetail().get(i);
    				if ("N".equals(detailVO.getRIGHADD()) && 
    						"N".equals(detailVO.getRIGHDEL()) && 
    						"N".equals(detailVO.getRIGHEDI()) && 
    						"N".equals(detailVO.getRIGHVIE()) && 
    						"N".equals(detailVO.getRIGHAUD()) )
    					continue;
    				rc=bo_DireautDetail.addPermission(userToken, isSubdir, dvo.getPATH(),detailVO );
    			}
    		}
    	}
    	return rc;
    }
    
    //������Ȩ��Ϣ
    //ɾ����ǰĿ¼���������Ŀ¼����Ȩ����
    public boolean revokePermisson(UserToken userToken,long roleID,long currentDirID, boolean isSubdir )
    {
    	boolean rc=false;
    	DirectoryDAO ddao=new DirectoryDAO();
    	DirectoryVO dvo=(DirectoryVO)ddao.doFindById(currentDirID);
    	DireautDetailVO detailVO=null;
    	if (dvo!=null){
    		rc=bo_DireautDetail.deletePermission(new Long(roleID),isSubdir, dvo.getPATH());
    	}
    	return rc;
    }    
}