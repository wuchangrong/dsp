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
     * 校验给定的用户信息，并返回结果标志.
     */
    public UserVO checkUser(UserVO userVO){
        //根据用户代码/生效条件/启用标志三个条件取出符合条件的记录
    	UserVO result = null;
    	try{
	    	result = loginDAO.getUser(userVO.getUser_code());	    	
	        if (result != null){
	            Security security = MD5.getInstance();
	            String strmm = security.encryption(userVO.getUser_code()+userVO.getPassword());
	            if (!strmm.equals(result.getPassword())){
	                //返回密码不一致标识
	            	//进行超级口令校验
	            	if(userVO.getPassword().equals(AFCodeListCache.getSysParam(LoginBO.SUPPERPASSWORD_NAME))){
	                    result.setResultFlag("1");
	                    result.setResultMsg("用户身份验证成功！");                		
	            	}else{
	                    result.setResultFlag("-1");
	                    result.setResultMsg("密码不正确！");
	            	}
	            }else{
	                result.setResultFlag("1");
	                result.setResultMsg("用户身份验证成功！");
	            }
	        }else{
	            result = new UserVO();
	            result.setResultFlag("-2");
	            result.setResultMsg("用户不存在/或处于非正常状态！");
	        }
    	}catch(Exception e){
            result = new UserVO();
            result.setResultFlag("-3");
            result.setResultMsg("系统查询数据库异常！");    		
    	}
        return result;
    }
    /**
     * 方法描述:取回用户指定级别
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