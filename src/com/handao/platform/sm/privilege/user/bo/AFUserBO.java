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
     * [父类抽象方法实现]
     * 返回当前活动DAO
     * @return AFBizDAO
     */
    protected AFBizDAO  getActiveDAO() {
        return dao_User;
    }
   
    public AFUserBO() {
        this.addListener(new AFBizBOListenerImpl() {
            /**
             * [AFBizBOListenerImpl类方法复写]
             * 插入前业务逻辑接口
             * 完成数据唯一性校验
             * 完成主键设置
             * @param userToken AFUserToken
             * @param vo AFValueObject
             * @return boolean
             */
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
            	if (userToken==null)
            		return false;
            	
            	((AFUserVO)vo).setCreate_user_id(userToken.getUserId());
                ((AFUserVO)vo).setRow_id(AFIDFactory.getNextID());
            	
            	//插入前，用户启用标志设为0
                ((AFUserVO)vo).setUsing_flag("0");
                //创建时间为当前时间
                Calendar ca = Calendar.getInstance();
            	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            	Date date = Date.valueOf((String)dateFormat.format(ca.getTime()));
            	((AFUserVO)vo).setCreate_date(date);
            	//将密码加密后存入数据库
            	Security security = MD5.getInstance();
            	// 加密后的密码
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
        	                	vo.setCert_yn_name("否");
        	                }else if("Y".equals(cert_yn)){
        	                	vo.setCert_yn_name("是");
        	                }
        	                
        	                if("2".equals(using_flag)){
        	                	vo.setUsing_flag_name("停用");
        	                }else if("1".equals(using_flag)){
        	                	vo.setUsing_flag_name("启用");
        	                }else if("0".equals(using_flag)){
        	                	vo.setUsing_flag_name("未启用");
        	                }
        	            }
        	        }
        	    }

        	 public void afterFind(AFUserToken userToken, long id, AFValueObject vo){
        		 AFUserVO eapuservo = (AFUserVO)vo;
        		 String cert_yn = eapuservo.getCert_yn();
        		 String attr_flag = eapuservo.getAttr_flag();
        		 if("N".equals(cert_yn)){
        			 eapuservo.setCert_yn_name("不需验证");
	                }else if("Y".equals(cert_yn)){
	                	eapuservo.setCert_yn_name("验证");
	                }
        		 
        		 if("2".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("超级用户");
        		 }else if("1".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("系统管理员");
        		 }else if("0".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("普通用户");
        		 }else if("3".equals(attr_flag)){
        			 eapuservo.setAttr_flag_name("测试员");
        		 }
        		 //设置验证密码
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
     * 修改启用、停用标志
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
     * 删除用户时判断用户是否已审核
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
     * 新增，修改时判断用户代码是否存在
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
     * 新增，修改时判断用户名称是否存在
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
    		//将密码加密后存入数据库
        	Security security = MD5.getInstance();
        	// 加密后的密码
            String strmm = security.encryption(((AFUserVO)vo).getUser_code()+((AFUserVO)vo).getPassword());
            ((AFUserVO)vo).setPassword(strmm);
    	}   	
        return true;
    }

}