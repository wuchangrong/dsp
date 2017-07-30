package com.handao.platform.sm.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.sm.login.bo.LoginBO;
import com.handao.platform.sm.login.vo.UserVO;
import com.handao.platform.sm.userOnline.UserOnlineManager;

import config.Configuration;

/**
 * 1  用户身份验证成功！
 * 0  无法登陆(系统被关闭)
 * -1 密码不正确！
 * -2 用户不存在/或处于非正常状态
 * -3 数据库异常
 */
public class LoginHandleImpl implements LoginHandle {
   private static LoginHandle loginHandle = new LoginHandleImpl();
      
   public static LoginHandle getInstance() {
      return loginHandle;
   }

   private LoginHandleImpl() {
   }

   public LoginResultBean loginHandle(HttpServletRequest request, HttpServletResponse response) {
      //取得页面登陆信息
      String userCode = (request.getParameter("userID") == null ? "" : request.getParameter("userID").trim());
      String passWord = (request.getParameter("passwd") == null ? "" : request.getParameter("passwd").trim());

      //初始化一个登陆反馈信息的bean
      LoginResultBean loginResultBean = new LoginResultBean();

      //如果登陆用户不是super，而且系统状态为关闭状态的话，不允许用户登陆。
      if(userCode != null && !userCode.equals("super") && "close".equals(Configuration.getInstance().getSYSTEM_STATE())) {
         loginResultBean.setResultCode("0");
         loginResultBean.setResultDescribe("系统已被管理员关闭，无法登陆！");
         return loginResultBean;
      }
      //构造userBean对象，以便进行用户身份验证
      UserVO userVO = new UserVO();
      userVO.setUser_code(userCode);
      userVO.setPassword(passWord);
      
      LoginBO loginBO = new LoginBO();
      UserVO resultVO = loginBO.checkUser(userVO);

      if(resultVO != null && "1".equals(resultVO.getResultFlag())) {
         //如果只能单点登陆，而且该用户已经登陆了的话，则不允许用户再登陆。
         if(!Configuration.getInstance().isMUTIL_LOGIN() && UserOnlineManager.getInstance().isExistInOnlineList(resultVO.getRow_id())) {
            UserOnlineManager.getInstance().shutdownUserByUserId(resultVO.getRow_id());
            loginResultBean.setResultCode("0");
            loginResultBean.setResultDescribe("该用户一台计算机上登陆了，不允许重复登陆！");
            return loginResultBean;
         }
         //设置验证成功信息
         loginResultBean.setResultCode(resultVO.getResultFlag());
         loginResultBean.setResultDescribe(resultVO.getResultMsg());
         //成功登陆的初始化
         loginSuccessInit(resultVO, request, response);
      }
      else {
         String resultFlag = resultVO == null ? "0" : resultVO.getResultFlag();
         String resultDescribe = resultVO == null ? "无法连接到数据库进行身份验证！" : resultVO.getResultMsg();
         loginResultBean.setResultCode(resultFlag);
         loginResultBean.setResultDescribe(resultDescribe);
      }
      return loginResultBean;
   }

   //登陆成功的初始化
   private void loginSuccessInit(UserVO resultVO, HttpServletRequest request, HttpServletResponse response) {
      try {
         //初始化会话
         UserToken userToken = initSession(resultVO, request);
         UserOnlineManager.getInstance().putUserOnlineContainer(userToken, request.getSession());
         // 向登陆日志中写入登陆信息
//         OpLogModule logModule = new OpLogModule();
//         logModule.moduleInitialize(null);
//         long logId = logModule.writeOpLog(userToken, -1);
//         userToken.setLogId(logId); //设置userToken的登陆日志Id，以便查询该登陆所作的操作
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //登陆成功后初始化会话操作
   private UserToken initSession(UserVO userVO, HttpServletRequest request) {
      UserToken userToken = new UserToken();
      //身份验证通过，在会话中设置产品平台相关的用户信息
      userToken.setUserId(userVO.getRow_id()); //设置用户ID
      userToken.setUserCode(userVO.getUser_code()); //设置用户代码
      userToken.setUserName(userVO.getUser_name()); //设置用户名称
      userToken.setAttrFlag(userVO.getAttr_flag()); //用户性质
      userToken.setSessionId(request.getSession().getId()); //记录SessionId
      userToken.setFromMachineIP(request.getRemoteAddr()); //登录机器的IP
      userToken.setFromMachineName(request.getRemoteHost()); //登录机器名称
      userToken.setCompanyId(userVO.getCompany_id()); //用户默认公司ID
      userToken.setPersonId(userVO.getPerson_id()); //用户默认人员ID
      userToken.setCompanyName(userVO.getCompany_name());
      userToken.setDeptId(userVO.getDivision_id());
      //用户信息放入session
      HttpSession session = request.getSession();
      session.setAttribute("userToken", userToken);
      return userToken;
   }
}