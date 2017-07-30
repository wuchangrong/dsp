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
 * 1  �û������֤�ɹ���
 * 0  �޷���½(ϵͳ���ر�)
 * -1 ���벻��ȷ��
 * -2 �û�������/���ڷ�����״̬
 * -3 ���ݿ��쳣
 */
public class LoginHandleImpl implements LoginHandle {
   private static LoginHandle loginHandle = new LoginHandleImpl();
      
   public static LoginHandle getInstance() {
      return loginHandle;
   }

   private LoginHandleImpl() {
   }

   public LoginResultBean loginHandle(HttpServletRequest request, HttpServletResponse response) {
      //ȡ��ҳ���½��Ϣ
      String userCode = (request.getParameter("userID") == null ? "" : request.getParameter("userID").trim());
      String passWord = (request.getParameter("passwd") == null ? "" : request.getParameter("passwd").trim());

      //��ʼ��һ����½������Ϣ��bean
      LoginResultBean loginResultBean = new LoginResultBean();

      //�����½�û�����super������ϵͳ״̬Ϊ�ر�״̬�Ļ����������û���½��
      if(userCode != null && !userCode.equals("super") && "close".equals(Configuration.getInstance().getSYSTEM_STATE())) {
         loginResultBean.setResultCode("0");
         loginResultBean.setResultDescribe("ϵͳ�ѱ�����Ա�رգ��޷���½��");
         return loginResultBean;
      }
      //����userBean�����Ա�����û������֤
      UserVO userVO = new UserVO();
      userVO.setUser_code(userCode);
      userVO.setPassword(passWord);
      
      LoginBO loginBO = new LoginBO();
      UserVO resultVO = loginBO.checkUser(userVO);

      if(resultVO != null && "1".equals(resultVO.getResultFlag())) {
         //���ֻ�ܵ����½�����Ҹ��û��Ѿ���½�˵Ļ����������û��ٵ�½��
         if(!Configuration.getInstance().isMUTIL_LOGIN() && UserOnlineManager.getInstance().isExistInOnlineList(resultVO.getRow_id())) {
            UserOnlineManager.getInstance().shutdownUserByUserId(resultVO.getRow_id());
            loginResultBean.setResultCode("0");
            loginResultBean.setResultDescribe("���û�һ̨������ϵ�½�ˣ��������ظ���½��");
            return loginResultBean;
         }
         //������֤�ɹ���Ϣ
         loginResultBean.setResultCode(resultVO.getResultFlag());
         loginResultBean.setResultDescribe(resultVO.getResultMsg());
         //�ɹ���½�ĳ�ʼ��
         loginSuccessInit(resultVO, request, response);
      }
      else {
         String resultFlag = resultVO == null ? "0" : resultVO.getResultFlag();
         String resultDescribe = resultVO == null ? "�޷����ӵ����ݿ���������֤��" : resultVO.getResultMsg();
         loginResultBean.setResultCode(resultFlag);
         loginResultBean.setResultDescribe(resultDescribe);
      }
      return loginResultBean;
   }

   //��½�ɹ��ĳ�ʼ��
   private void loginSuccessInit(UserVO resultVO, HttpServletRequest request, HttpServletResponse response) {
      try {
         //��ʼ���Ự
         UserToken userToken = initSession(resultVO, request);
         UserOnlineManager.getInstance().putUserOnlineContainer(userToken, request.getSession());
         // ���½��־��д���½��Ϣ
//         OpLogModule logModule = new OpLogModule();
//         logModule.moduleInitialize(null);
//         long logId = logModule.writeOpLog(userToken, -1);
//         userToken.setLogId(logId); //����userToken�ĵ�½��־Id���Ա��ѯ�õ�½�����Ĳ���
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //��½�ɹ����ʼ���Ự����
   private UserToken initSession(UserVO userVO, HttpServletRequest request) {
      UserToken userToken = new UserToken();
      //�����֤ͨ�����ڻỰ�����ò�Ʒƽ̨��ص��û���Ϣ
      userToken.setUserId(userVO.getRow_id()); //�����û�ID
      userToken.setUserCode(userVO.getUser_code()); //�����û�����
      userToken.setUserName(userVO.getUser_name()); //�����û�����
      userToken.setAttrFlag(userVO.getAttr_flag()); //�û�����
      userToken.setSessionId(request.getSession().getId()); //��¼SessionId
      userToken.setFromMachineIP(request.getRemoteAddr()); //��¼������IP
      userToken.setFromMachineName(request.getRemoteHost()); //��¼��������
      userToken.setCompanyId(userVO.getCompany_id()); //�û�Ĭ�Ϲ�˾ID
      userToken.setPersonId(userVO.getPerson_id()); //�û�Ĭ����ԱID
      userToken.setCompanyName(userVO.getCompany_name());
      userToken.setDeptId(userVO.getDivision_id());
      //�û���Ϣ����session
      HttpSession session = request.getSession();
      session.setAttribute("userToken", userToken);
      return userToken;
   }
}