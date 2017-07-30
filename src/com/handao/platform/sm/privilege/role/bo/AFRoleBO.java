package com.handao.platform.sm.privilege.role.bo;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.bo.AFBizCompositeBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.bo.AFBOProvider;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.privilege.role.dao.AFRoleDAO;
import com.handao.platform.sm.privilege.role.vo.AFRoleProgramVO;
import com.handao.platform.sm.privilege.role.vo.AFRoleUserVO;
import com.handao.platform.sm.privilege.role.vo.AFRoleVO;

public class AFRoleBO extends AFBizCompositeBO {

	private AFRoleDAO dao_AFRole = (AFRoleDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.privilege.role.dao.AFRoleDAO");
	private AFRoleProgramBO bo_AFRoleProgram = (AFRoleProgramBO)AFBOProvider.getBOByClass("com.handao.platform.sm.privilege.role.bo.AFRoleProgramBO");
	private AFRoleUserBO bo_AFRoleUser = (AFRoleUserBO)AFBOProvider.getBOByClass("com.handao.platform.sm.privilege.role.bo.AFRoleUserBO");
	
	public AFRoleBO() {
        this.addListener(new AFBizBOListenerImpl() {

            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                ((AFRoleVO)vo).setSmr_ROW_ID(AFIDFactory.getNextID());
                return true;
            }

        });
    }
	
	protected AFBizBO[] getDetailBO() {
		return new AFBizBO[] {bo_AFRoleProgram,bo_AFRoleUser};
	}

	protected AFBizBO getOperateBO(String detailVOCLass) {
		if(AFRoleProgramVO.class.getName().equals(detailVOCLass)){
			return bo_AFRoleProgram;
		}else if(AFRoleUserVO.class.getName().equals(detailVOCLass)){
			return bo_AFRoleUser;
		}else{
			return null;
		}
        
	}

	protected AFBizDAO getActiveDAO() {
		// TODO Auto-generated method stub
		return dao_AFRole;
	}

	public AFPage doSearchPage(AFUserToken userToken, AFSearchCondition sc, AFPage page) throws AFBOException {
        try {
            if(listener != null)
                listener.beforeSearch(userToken, sc);
            //1.获得用户的类型
            String attributeFlag = ((UserToken)userToken).getAttrFlag();
            
            //2.根据不同的用户类型，调用不同的dao
            AFPage result = null;
            if("2".equals(attributeFlag)){  //超级用户
            	result = ((AFRoleDAO)this.getActiveDAO()).doSearchPageByConditionWhenSuper(page, sc.getCustomerCondition());
            }else if("1".equals(attributeFlag)){  //管理员，后面有了组织模块后，需要进行修改
            	result = ((AFRoleDAO)this.getActiveDAO()).doSearchPageByConditionWhenAdmin(page, sc.getCustomerCondition());
            }else if("0".equals(attributeFlag)){  //普通用户
            	result = this.getActiveDAO().doSearchPageByCondition(page, sc.getCustomerCondition());
            }else if("3".equals(attributeFlag)){  //测试员
            	result = ((AFRoleDAO)this.getActiveDAO()).doSearchPageByConditionWhenDebug(page, sc.getCustomerCondition());
            }
            if(listener != null)
                listener.afterSearch(userToken, sc, page);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public boolean doInsert(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeInsert(userToken, vo);

            if(result)
                result = this.getActiveDAO().doInsertByVO(vo);

            if(result && listener!=null)
                result = listener.afterInsert(userToken, vo);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public boolean doUpdate(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = listener.beforeUpdate(userToken, vo);

            if(result)
                result = this.getActiveDAO().doUpdateByVO(vo);

            if(result && listener!=null)
                result = listener.afterUpdate(userToken, vo);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	public boolean doAssignProgram(AFUserToken userToken, long roleId, long[] moduleIds) throws AFBOException {
        try {
            boolean result = true;

            //删除该角色现有的所有模块
            if(result){
            	result = result && bo_AFRoleProgram.doDeleteByMaster(roleId);
            }
            
            //重新分配模块
            for(int i = 0; i < moduleIds.length; i ++){
            	if(result){
            		AFRoleProgramVO roleProgramVo = new AFRoleProgramVO();
            		roleProgramVo.setSmrp_ROLE_ID(roleId);
            		roleProgramVo.setSmrp_PROGRAM_ID(moduleIds[i]);
            		result = result && bo_AFRoleProgram.doInsert(userToken, roleProgramVo);
            	}
            }
            
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

	public AFValueObject doFind(AFUserToken userToken, long id) throws AFBOException {
        try {
            if(listener != null)
                listener.beforeFind(userToken, id);
            AFRoleVO vo = (AFRoleVO)this.getActiveDAO().doFindById(id);

            if(vo != null) {
                String attributeFlag = ((UserToken)userToken).getAttrFlag();
                List list = new ArrayList();
                if("2".equals(attributeFlag)){  //超级用户
                	list = bo_AFRoleUser.doSearchListByMasterIdWhenSuper(id);
                }else if("1".equals(attributeFlag)){  //管理员，后面有了组织模块后，需要进行修改
                	list = bo_AFRoleUser.doSearchListByMasterIdWhenAdmin(id);
                }else if("0".equals(attributeFlag)){  //普通用户
                	list = bo_AFRoleUser.doSearchListByMasterIdWhenOrdinary(id);
                }else if("3".equals(attributeFlag)){  //测试员
                	list = bo_AFRoleUser.doSearchListByMasterIdWhenDebug(id);
                }
                vo.setDl_AFAvailableUser(list);
                
                AFBizBO[] bo = this.getDetailBO();
                for(int i = 0; i < bo.length; i++) {
                    List detailList = bo[i].doSearchByMaster(id);
                    vo.setDetailList(getDetailVOClass(detailList), detailList);
                }
            }

            if(listener != null)
                listener.afterFind(userToken, id, vo);
            return vo;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	
	private String getDetailVOClass(List list) {
        if(list!=null && list.size()!=0) {
            for(int i=0; i<list.size(); i++) {
                AFValueObject vo = (AFValueObject)list.get(i);
                if(vo != null)
                    return vo.getClass().getName();
            }
        }
        return "";
    }

	public boolean doAssignUser(AFUserToken userToken, long roleId, long[] userIds) throws AFBOException {
        try {
            boolean result = true;

            //删除该角色现有的所有用户
            if(result){
            	result = result && bo_AFRoleUser.doDeleteByMaster(roleId);
            }
            
            //重新分配模块
            for(int i = 0; i < userIds.length; i ++){
            	if(result){
            		AFRoleUserVO roleUserVo = new AFRoleUserVO();
            		roleUserVo.setSmur_ROW_ID(AFIDFactory.getNextID());
            		roleUserVo.setSmur_ROLE_ID(roleId);
            		roleUserVo.setSmur_USER_ID(userIds[i]);
            		result = result && bo_AFRoleUser.doInsert(userToken, roleUserVo);
            	}
            }
            
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
	/**
     * 新增，修改时判断角色代码是否存在
     * @param role_code,row_id
     * @return List
     */
    public List retrieveRoleCode(String role_code, String row_id) throws AFBOException {
        try {
        	List result = dao_AFRole.retrieveRoleCode(role_code, row_id);
            return result;
        } catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
    /**
     * 新增，修改时判断角色名称是否存在
     *  @param role_code,row_id
     *  @return List
     */
    public List retrieveRoleName(String role_name, String row_id) throws AFBOException {
        try {
        	List result = dao_AFRole.retrieveRoleName(role_name, row_id);
            return result;
        } catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
}