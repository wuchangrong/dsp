package com.handao.platform.sm.privilege.user.bo;

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
import com.handao.platform.framework.vo.AFCompositeValueObject;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.privilege.role.vo.AFRoleUserVO;
import com.handao.platform.sm.privilege.user.dao.AFUserAuthorizationDAO;
import com.handao.platform.sm.privilege.user.vo.AFUserRoleVO;
import com.handao.platform.sm.privilege.user.vo.AFUserVO;

public class AFUserAuthorizationBO extends AFBizCompositeBO {

    private AFUserAuthorizationDAO dao_UserAuthorization = (AFUserAuthorizationDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.privilege.user.dao.AFUserAuthorizationDAO");
    private AFUserRoleBO bo_AFUserRole = (AFUserRoleBO)AFBOProvider.getBOByClass("com.handao.platform.sm.privilege.user.bo.AFUserRoleBO");
    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�DAO
     * @return AFBizDAO
     */
    protected AFBizDAO  getActiveDAO() {
        return dao_UserAuthorization;
    }
   
    public AFUserAuthorizationBO() {
        this.addListener(new AFBizBOListenerImpl() {
            /**
             * [AFBizBOListenerImpl�෽����д]
             * ����ǰҵ���߼��ӿ�
             * �������Ψһ��У��
             * �����������
             * @param userToken AFUserToken
             * @param vo AFValueObject
             * @return boolean
             */
        	
        	 public void afterSearch(AFUserToken userToken, AFSearchCondition sc, AFPage page) {
        	        List list = page.getList();
        	        if(list!=null && list.size()!=0) {
        	            for(int i=0, j=list.size(); i<j; i++) {
        	                AFUserVO vo = (AFUserVO)list.get(i);
        	                String cert_yn = vo.getCert_yn();
        	                String using_flag = vo.getUsing_flag();
        	                if("N".equals(cert_yn)){
        	                	vo.setCert_yn_name("��");
        	                }else if("Y".equals(cert_yn)){
        	                	vo.setCert_yn_name("��");
        	                }
        	                
        	                if("2".equals(using_flag)){
        	                	vo.setUsing_flag_name("ͣ��");
        	                }else if("1".equals(using_flag)){
        	                	vo.setUsing_flag_name("����");
        	                }else if("0".equals(using_flag)){
        	                	vo.setUsing_flag_name("δ����");
        	                }
        	            }
        	        }
        	    }

        	 public void afterFind(AFUserToken userToken, long id, AFValueObject vo){
        		 AFUserVO eapuservo = (AFUserVO)vo;
        		 String cert_yn = eapuservo.getCert_yn();
        		 String attr_flag = eapuservo.getAttr_flag();
        		 if("N".equals(cert_yn)){
        			 eapuservo.setCert_yn_name("������֤");
	                }else if("Y".equals(cert_yn)){
	                	eapuservo.setCert_yn_name("��֤");
	                }
        		 
        		 if("2".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("�����û�");
        		 }else if("1".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("ϵͳ����Ա");
        		 }else if("0".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("��ͨ�û�");
        		 }else if("3".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("����Ա");
        		 }
        		 //������֤����
        		 eapuservo.setPasswordJudge(eapuservo.getPassword());
        		 
        	 }
        
        });
    }

  //2008-12-29 modify by ludj start
	public AFValueObject doFindAssignRole(AFUserToken userToken, long id) throws AFBOException {
        try {
        	AFUserVO vo = (AFUserVO)this.getActiveDAO().doFindById(id);

            if(vo != null) {
                String attributeFlag = ((UserToken)userToken).getAttrFlag();
                List list = new ArrayList();
                List availableList = new ArrayList();//��ѡ
                if("2".equals(attributeFlag)){  //�����û�
                	list = bo_AFUserRole.doSearchListByMasterIdWhenSuper(id);
                	availableList = bo_AFUserRole.doSearchAvailableListByMasterIdWhenOrdinary(id);
                }else if("1".equals(attributeFlag)){  //����Ա������������֯ģ�����Ҫ�����޸�
                	list = bo_AFUserRole.doSearchListByMasterIdWhenAdmin(id);
                	availableList = bo_AFUserRole.doSearchAvailableListByMasterIdWhenOrdinary(id);
                }else if("0".equals(attributeFlag)){  //��ͨ�û�
                	list = bo_AFUserRole.doSearchListByMasterIdWhenOrdinary(id);
                	availableList = bo_AFUserRole.doSearchAvailableListByMasterIdWhenOrdinary(id);
                }else if("3".equals(attributeFlag)){  //����Ա
                	list = bo_AFUserRole.doSearchListByMasterIdWhenDebug(id);
                	availableList = bo_AFUserRole.doSearchAvailableListByMasterIdWhenDebug(id);
                }
                vo.setDl_AFUserRole(list);
                vo.setDl_AFAvailableRole(availableList);
                
            }
            return vo;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

	public boolean doAssignRole(AFUserToken userToken, long userId, long[] roleIds) throws AFBOException {
        try {
            boolean result = true;

            //ɾ���ý�ɫ���е������û�
            if(result){
            	result = result && bo_AFUserRole.doDeleteByMaster(userId);
            }
            
            //���·���ģ��
            for(int i = 0; i < roleIds.length; i ++){
            	if(result){
            		AFUserRoleVO userRoleVO = new AFUserRoleVO();
            		userRoleVO.setSmur_ROW_ID(AFIDFactory.getNextID());
            		userRoleVO.setSmur_USER_ID(userId);
            		userRoleVO.setSmur_ROLE_ID(roleIds[i]);
            		result = result && bo_AFUserRole.doInsert(userToken, userRoleVO);
            	}
            }
            
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }

	protected AFBizBO[] getDetailBO() {
		return new AFBizBO[] {bo_AFUserRole};
	}


	protected AFBizBO getOperateBO(String detailVOCLass) {
		if(AFRoleUserVO.class.getName().equals(detailVOCLass)){
			return bo_AFUserRole;
		}else{
			return null;
		}
	}

	public AFValueObject doFind(AFUserToken userToken, long id) throws AFBOException {
		  try {
		      if(listener != null)
	          listener.beforeFind(userToken, id);
		      AFCompositeValueObject vo = (AFCompositeValueObject)this.getActiveDAO().doFindById(id);

		     if(listener != null)
		         listener.afterFind(userToken, id, vo);
		     
		     
		      return vo;
		  }
		  catch (Exception ex) {
		      throw new AFBOException(ex);
		  }
		}

}