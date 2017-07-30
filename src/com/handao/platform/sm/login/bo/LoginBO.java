package com.handao.platform.sm.login.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.util.AFCodeListCache;
import com.handao.platform.framework.util.security.MD5;
import com.handao.platform.framework.util.security.Security;
import com.handao.platform.sm.login.dao.LoginDAO;
import com.handao.platform.sm.login.vo.UserVO;

public class LoginBO extends AFBizBO{
	private static final String SUPPERPASSWORD_NAME = "SUPPERPASSWORD";
	
    private LoginDAO loginDAO = (LoginDAO)AFDAOProvider.getDAOByClass("com.handao.platform.sm.login.dao.LoginDAO");

    protected AFBizDAO getActiveDAO() {
        return loginDAO;
    }
    /**
     * У��������û���Ϣ�������ؽ����־.
     */
    public UserVO checkUser(UserVO userVO){
        //�����û�����/��Ч����/���ñ�־��������ȡ�����������ļ�¼
    	UserVO result = null;
    	try{
	    	result = loginDAO.getUser(userVO.getUser_code());	    	
	        if (result != null){
	            Security security = MD5.getInstance();
	            String strmm = security.encryption(userVO.getUser_code()+userVO.getPassword());
	            if (!strmm.equals(result.getPassword())){
	                //�������벻һ�±�ʶ
	            	//���г�������У��
	            	if(userVO.getPassword().equals(AFCodeListCache.getSysParam(LoginBO.SUPPERPASSWORD_NAME))){
	                    result.setResultFlag("1");
	                    result.setResultMsg("�û������֤�ɹ���");                		
	            	}else{
	                    result.setResultFlag("-1");
	                    result.setResultMsg("���벻��ȷ��");
	            	}
	            }else{
	                result.setResultFlag("1");
	                result.setResultMsg("�û������֤�ɹ���");
	            }
	        }else{
	            result = new UserVO();
	            result.setResultFlag("-2");
	            result.setResultMsg("�û�������/���ڷ�����״̬��");
	        }
    	}catch(Exception e){
            result = new UserVO();
            result.setResultFlag("-3");
            result.setResultMsg("ϵͳ��ѯ���ݿ��쳣��");    		
    	}
        return result;
    }
    /**
     * ��������:ȡ���û�ָ������
     */    
    public List getUserPrivilegeByLevel(long userId,int levelNum,String orderByField){
    	Map param = new HashMap();
    	param.put("userId", new Long(userId));
    	param.put("levelNum", new Integer(levelNum));
    	param.put("orderByField", orderByField);
    	try{
    		return loginDAO.getUserPrivilegeByLevel(param);
    	}catch(Exception e){
    		return null;
    	}
    }
}