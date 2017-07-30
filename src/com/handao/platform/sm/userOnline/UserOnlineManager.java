package com.handao.platform.sm.userOnline;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.handao.platform.framework.envelope.UserToken;
import com.handao.platform.framework.util.AFDateUtil;
import com.handao.platform.sm.userOnline.bean.UserOnlineBean;

public class UserOnlineManager
{
    private static UserOnlineManager userOnlineManager = new UserOnlineManager();

    private Map userOnlineContainer = new HashMap();

    private UserOnlineManager()
    {

    }

    public static UserOnlineManager getInstance()
    {
        return userOnlineManager;
    }

    //�ж�ĳ�û��Ƿ��Ѿ������������û��б���
    public boolean isExistInOnlineList(long userId)
    {
        boolean isExist = false;
        Set uOCKeySet = userOnlineContainer.keySet();
        Iterator uOCKeyIte = uOCKeySet.iterator();
        while(uOCKeyIte.hasNext()&&!isExist)
        {
            String userIdStr = uOCKeyIte.next().toString();
            if(Long.parseLong(userIdStr)==userId)
            {
                isExist = true;
            }
        }

        return isExist;
    }

    public void putUserOnlineContainer(UserToken userToken,HttpSession session)
    {
        long userId = userToken.getUserId();
        
        UserOnlineBean userOnlineBean = new UserOnlineBean();
        userOnlineBean.setUserId(userId);
        userOnlineBean.setUserName(userToken.getUserName());
        userOnlineBean.setUserCode(userToken.getUserCode());
        userOnlineBean.setLoginIP(userToken.getFromMachineIP());
        Date date = new Date();
        userOnlineBean.setLoginDate(date);
        userOnlineBean.setLoginDateTime(AFDateUtil.getDateTimeString(date));
        userOnlineBean.setSessionId(session.getId());
        userOnlineBean.setSession(session);

        if(userToken != null){
        	String companyName = userToken.getCompanyName();
        	userOnlineBean.setEntityName(companyName == null?"":companyName);
        }       
        
        if(!userOnlineContainer.containsKey(userId+""))        {
            Map onlineMap = new HashMap();
            onlineMap.put(session.getId()+"",userOnlineBean);
            userOnlineContainer.put(userId+"",onlineMap);
        }
        else
        {
            Map onlineMap = (Map)userOnlineContainer.get(userId+"");
            onlineMap.put(session.getId()+"",userOnlineBean);
        }
    }

    public UserOnlineBean getUserOnlineBean(String sessionId,long logId)
    {
        UserOnlineBean returnUserOnlineBean = null;
        Set uOCKeySet = userOnlineContainer.keySet();
        Iterator uOCKeyIte = uOCKeySet.iterator();
        boolean foundFlag = false;
        while(uOCKeyIte.hasNext()&&!foundFlag)
        {
            String userOnlineMapKey = uOCKeyIte.next().toString();
            Map userOnlineMap = (Map)userOnlineContainer.get(userOnlineMapKey);
            Set userOnlineKeySet = userOnlineMap.keySet();
            Iterator userOnlineIterator = userOnlineKeySet.iterator();
            while(userOnlineIterator.hasNext()&&!foundFlag)
            {
                String userOnlineKey = userOnlineIterator.next().toString();
                if(sessionId.equals(userOnlineKey))
                {
                    foundFlag = true;
                    returnUserOnlineBean = (UserOnlineBean)userOnlineMap.get(userOnlineKey);
                    String insistTime = AFDateUtil.getBetweenTime(returnUserOnlineBean.getLoginDate(),new Date());
                    returnUserOnlineBean.setInsistTime(insistTime);

                    List opLogList = getUserOpLog(returnUserOnlineBean.getUserId(),logId);
                    returnUserOnlineBean.setOpLogList(opLogList);
                }
            }
        }
        return returnUserOnlineBean;
    }

    //����super֮�⣬������е��û���
    public void shutdownAllUser()
    {
        Set uOCKeySet = userOnlineContainer.keySet();
        Iterator uOCKeyIte = uOCKeySet.iterator();
        while(uOCKeyIte.hasNext())
        {
            String userOnlineMapKey = uOCKeyIte.next().toString();
            //�������super�û��Ļ���super�û���userId������1�����������������
            if(!userOnlineMapKey.equals("1"))
            {
                Map userOnlineMap = (Map)userOnlineContainer.get(userOnlineMapKey);
                Set userOnlineKeySet = userOnlineMap.keySet();
                Iterator userOnlineIterator = userOnlineKeySet.iterator();
                while(userOnlineIterator.hasNext())
                {
                    String userOnlineKey = userOnlineIterator.next().toString();

                        UserOnlineBean userOnlineBean = (UserOnlineBean)userOnlineMap.get(userOnlineKey);
                        userOnlineBean.clearOpLogList();        //��ղ�����־
                        if(userOnlineBean.getSession()!=null)
                            userOnlineBean.getSession().invalidate();
                        userOnlineMap.remove(userOnlineKey);
                }
                userOnlineContainer.remove(userOnlineMapKey);
            }
        }
    }

    //����userId�������userId���û���½��������������ڵ����½ʱ��
    //������û��Ѿ���½�ˣ������û��ٴε�½��ʱ��Ҫ���ô˺������Ѿ���½�ĸ��û������
    public void shutdownUserByUserId(long userId)
    {
        if(userOnlineContainer.containsKey(userId+""))
        {
            Map userOnlineMap = (Map)userOnlineContainer.get(userId+"");
            Set userOnlineKeySet = userOnlineMap.keySet();
            Iterator userOnlineIterator = userOnlineKeySet.iterator();
            while(userOnlineIterator.hasNext())
            {
                String userSessionId = userOnlineIterator.next().toString();

                UserOnlineBean userOnlineBean = (UserOnlineBean)userOnlineMap.get(userSessionId);
                userOnlineBean.clearOpLogList();        //��ղ�����־
                if(userOnlineBean.getSession()!=null)
                    userOnlineBean.getSession().invalidate();
                userOnlineMap.remove(userSessionId);
            }
            userOnlineContainer.remove(userId+"");
        }
    }

    //from=1��ʱ����ָSessionListener�е��õ�
    public void shutdownUser(String sessionId,int from)
    {
        Set uOCKeySet = userOnlineContainer.keySet();
        Iterator uOCKeyIte = uOCKeySet.iterator();
        boolean foundFlag = false;
        while(uOCKeyIte.hasNext()&&!foundFlag)
        {
            String userOnlineMapKey = uOCKeyIte.next().toString();
            Map userOnlineMap = (Map)userOnlineContainer.get(userOnlineMapKey);
            Set userOnlineKeySet = userOnlineMap.keySet();
            Iterator userOnlineIterator = userOnlineKeySet.iterator();
            while(userOnlineIterator.hasNext()&&!foundFlag)
            {
                String userOnlineKey = userOnlineIterator.next().toString();
                if(sessionId.equals(userOnlineKey))
                {
                    foundFlag = true;
                    UserOnlineBean userOnlineBean = (UserOnlineBean)userOnlineMap.get(userOnlineKey);
                    userOnlineBean.clearOpLogList();        //��ղ�����־
                    if(userOnlineBean.getSession()!=null&&from!=1)
                        userOnlineBean.getSession().invalidate();
                    userOnlineMap.remove(sessionId);
                    //������û������һ���ø��û�����½���û��Ļ����ڶ���½ʱҪ���ǵ����⣩����ô��Ҫ��userOnlineContainer�н��������
                    if(userOnlineMap.isEmpty())
                        userOnlineContainer.remove(userOnlineMapKey);

                }
            }
        }
    }

    public void shutdownUserList(String[] sessionIds)
    {
        if(sessionIds!=null&&sessionIds.length>0)
        {
            for(int i=0;i<sessionIds.length;i++)
            {
               shutdownUser(sessionIds[i],0);
            }
        }
    }

    private List getUserOpLog(long userId,long logId)
    {
//        OpLogModule opLogModule = new OpLogModule(null);
//
//        //String condition = " OPDATE>="+ReservedField.getDBDate(startDate)+" AND OPTIME>='"+startTime+"'AND OPDATE<="+ReservedField.getDBDate(endDate)+" AND OPTIME<='"+endTime+"' AND LOG_USER_ID = "+userId+" AND DELETED_FLAG='0'";
//        String condition = null;
//
//        condition = "LOG_ID = "+logId+" AND LOG_USER_ID = "+userId+" AND DELETED_FLAG='0' AND PROGRAM_ID>0";
//
//        List opLogList = opLogModule.retrieveOpLogByCriteria(condition);
//        return opLogList;
    	return null;
    }

    //�������������Ա���б�
    public List getUserOnlineList()
    {
        List returnList = new ArrayList();
        Set uOCKeySet = userOnlineContainer.keySet();
        Iterator uOCKeyIte = uOCKeySet.iterator();
        while(uOCKeyIte.hasNext())
        {
            String userOnlineMapKey = uOCKeyIte.next().toString();
            Map userOnlineMap = (Map)userOnlineContainer.get(userOnlineMapKey);
            Set userOnlineKeySet = userOnlineMap.keySet();
            Iterator userOnlineIterator = userOnlineKeySet.iterator();
            while(userOnlineIterator.hasNext()){
                UserOnlineBean userOnlineBean = (UserOnlineBean)userOnlineMap.get(userOnlineIterator.next());
                String insistTime = AFDateUtil.getBetweenTime(userOnlineBean.getLoginDate(),new Date());
                userOnlineBean.setInsistTime(insistTime);
                returnList.add(userOnlineBean);
            }
        }
        return returnList;
    }
}