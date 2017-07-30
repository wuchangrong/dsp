package com.handao.platform.sm.userOnline.bean;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.handao.platform.framework.vo.AFValueObject;

public class UserOnlineBean extends AFValueObject{
	
	private static final long serialVersionUID = 1L;
	
	private long userId;
    private String userCode;
    private String userName;
    private String loginIP;
    private Date loginDate;
    private String loginDateTime;
    private String insistTime;
    private String sessionId;
    private HttpSession session;

    private List opLogList;
  private String entityName;
  private String roleName;

    //清空日志操作记录
    public void clearOpLogList()
    {
        if(opLogList!=null)
        {
            opLogList.removeAll(opLogList);
            opLogList = null;
        }
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(String loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getInsistTime() {
        return insistTime;
    }

    public void setInsistTime(String insistTime) {
        this.insistTime = insistTime;
    }

    public List getOpLogList() {
        return opLogList;
    }

    public void setOpLogList(List opLogList) {
        this.opLogList = opLogList;
    }
  public String getEntityName()
  {
    return entityName;
  }
  public void setEntityName(String entityName)
  {
    this.entityName = entityName;
  }
  public String getRoleName()
  {
    return roleName;
  }
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
}