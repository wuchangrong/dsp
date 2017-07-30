package com.handao.platform.framework.envelope;

public class UserToken implements AFUserToken
{
	private static final long serialVersionUID = 1L;
	private int userId;//�û�ID
    private String userCode;//�û�����
    private String userName;//�û�����
    private String password;
    private String attrFlag;//�û����ԣ�[0]-��ͨ�û�;[1]-ϵͳ����Ա;[2]-�����û�;[3]-�����û�
    private String sessionId;  //�˴ε�½��sessionId��
    private String fromMachineIP;//�û���¼����IP
    private String fromMachineName;//�û���¼��������
    
    private int companyId;//�û����ڹ�˾ID
    private int deptId;//����id
    private int personId;//��ԱID������û�������Ա�򷵻�-1
    private String companyName;//��˾����

    private int logId = -1;      //��½��־Id

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