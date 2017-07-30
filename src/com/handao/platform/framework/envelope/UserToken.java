package com.handao.platform.framework.envelope;

public class UserToken implements AFUserToken
{
	private static final long serialVersionUID = 1L;
	private int userId;//用户ID
    private String userCode;//用户代码
    private String userName;//用户名称
    private String password;
    private String attrFlag;//用户属性，[0]-普通用户;[1]-系统管理员;[2]-超级用户;[3]-测试用户
    private String sessionId;  //此次登陆的sessionId。
    private String fromMachineIP;//用户登录机器IP
    private String fromMachineName;//用户登录机器名称
    
    private int companyId;//用户所在公司ID
    private int deptId;//部门id
    private int personId;//人员ID，如果用户不是人员则返回-1
    private String companyName;//公司名称

    private int logId = -1;      //登陆日志Id

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserCode()
    {
        return userCode;
    }

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getAttrFlag()
    {
        return attrFlag;
    }

    public void setAttrFlag(String attrFlag)
    {
        this.attrFlag = attrFlag;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getFromMachineIP()
    {
        return fromMachineIP;
    }

    public void setFromMachineIP(String fromMachineIP)
    {
        this.fromMachineIP = fromMachineIP;
    }

    public String getFromMachineName()
    {
        return fromMachineName;
    }

    public void setFromMachineName(String fromMachineName)
    {
        this.fromMachineName = fromMachineName;
    }

    public int getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(int companyId)
    {
        this.companyId = companyId;
    }

    public int getPersonId()
    {
        return personId;
    }

    public void setPersonId(int personId)
    {
        this.personId = personId;
    }

   public String getPassword() {
      return password;
   }
   
   public void setPassword(String password) {
      this.password = password;
   }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}