package com.handao.platform.sm.privilege.user.bo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFPage;
import com.handao.platform.framework.envelope.AFSearchCondition;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.util.security.MD5;
import com.handao.platform.framework.util.security.Security;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.sm.privilege.user.dao.AFUserDAO;
import com.handao.platform.sm.privilege.user.vo.AFUserVO;

public class AFUserBO extends AFBizBO {

    private AFUserDAO dao_User = (AFUserDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.privilege.user.dao.AFUserDAO");
    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�DAO
     * @return AFBizDAO
     */
    protected AFBizDAO  getActiveDAO() {
        return dao_User;
    }
   
    public AFUserBO() {
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
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
            	if (userToken==null)
            		return false;
            	
            	((AFUserVO)vo).setCreate_user_id(userToken.getUserId());
                ((AFUserVO)vo).setRow_id(AFIDFactory.getNextID());
            	
            	//����ǰ���û����ñ�־��Ϊ0
                ((AFUserVO)vo).setUsing_flag("0");
                //����ʱ��Ϊ��ǰʱ��
                Calendar ca = Calendar.getInstance();
            	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            	Date date = Date.valueOf((String)dateFormat.format(ca.getTime()));
            	((AFUserVO)vo).setCreate_date(date);
            	//��������ܺ�������ݿ�
            	Security security = MD5.getInstance();
            	// ���ܺ������
                String strmm = security.encryption(((AFUserVO)vo).getUser_code()+((AFUserVO)vo).getPassword());
                ((AFUserVO)vo).setPassword(strmm);
                
                return true;
            }
        	
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
			public boolean beforeDelete(AFUserToken userToken, long id) {
				AFUserVO vo=(AFUserVO)dao_User.doFindById(id);
				if ("super".equals(vo.getUser_code()))
					return false;
				return super.beforeDelete(userToken, id);
			}

        });
    }

    /**
     * 
     * �޸����á�ͣ�ñ�־
     * 
     */
    public boolean doUsingChange(AFUserToken userToken, long[] idList) throws AFBOException {
        boolean result = false;
        try {

            for(int i = 0; i<idList.length; i++) {
            	AFUserVO vo = (AFUserVO)this.getActiveDAO().doFindById(idList[i]);
            	String using_flag = vo.getUsing_flag();
            	if(using_flag.equals("0") || using_flag.equals("2")){
            		vo.setUsing_flag("1");
            	}else if(using_flag.equals("1")){
            		vo.setUsing_flag("2");
            	}
            		result = dao_User.doUsingChange(userToken,vo);
                if(!result)
                    return false;
            }
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }

    }
    /**
     * 
     * ɾ���û�ʱ�ж��û��Ƿ������
     * 
     */
    public List retrieveUserByCriteria(String row_id) throws AFBOException {
        try {
            List result = dao_User.retrieveUserByCriteria(row_id);
            return result;
        } catch (Exception ex) {
        	throw new AFBOException(ex);
        }
    }
    /**
     * 
     * �������޸�ʱ�ж��û������Ƿ����
     * 
     */
    public List retrieveUserCode(String user_code, String row_id) throws AFBOException {
        try {
        	List result = dao_User.retrieveUserCode(user_code, row_id);
            return result;
        } catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
    /**
     * 
     * �������޸�ʱ�ж��û������Ƿ����
     * 
     */
    public List retrieveUserName(String user_name, String row_id) throws AFBOException {
        try {
        	List result = dao_User.retrieveUserName(user_name, row_id);
            return result;
        } catch (Exception ex) {
            throw new AFBOException(ex);
        }
    }
    //add by cuiliwei for MD5 pass 2009-12-28
    public boolean doUpdate(AFUserToken userToken, AFValueObject vo) throws AFBOException {
        try {
            boolean result = true;
            if(listener != null)
                result = this.beforeUpdate(userToken, vo);

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
    
    public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo) {     
    	List list = dao_User.retrieveUserById(new Long(((AFUserVO)vo).getRow_id()));
    	AFUserVO votemp = null;
    	if(list!=null&&list.size()>0)
    		votemp = (AFUserVO)list.get(0);
    	else
    		return true;
    	if(!votemp.getPassword().equals(((AFUserVO)vo).getPassword())){
    		//��������ܺ�������ݿ�
        	Security security = MD5.getInstance();
        	// ���ܺ������
            String strmm = security.encryption(((AFUserVO)vo).getUser_code()+((AFUserVO)vo).getPassword());
            ((AFUserVO)vo).setPassword(strmm);
    	}   	
        return true;
    }

}