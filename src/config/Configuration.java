package config;
/**
 * ������Ϣ
 */
public class Configuration {	
	private static Configuration instance = new Configuration();
	
	private String APPLICATION_NAME = "������������ƽ̨";
	private String RELOGIN_PAGE = "/relogin.jsp";  //���µ�½ҳ��
	private String ENCODING = "GBK";        	   //Ĭ���ַ���
	private boolean MUTIL_LOGIN = true;            //�Ƿ����¼
	private String SYSTEM_STATE = "open";		   //ϵͳ״̬��open/close��
	private int FIRST_LEVEL_MENU_SHOW_NUM = 10;     //�����˵���ʾ��Ŀ
	private int FIRST_LEVEL_MENU_NUM = 9;          //һ���˵���Ŀ
    private String URI_ENCODING = "iso-8859-1";    //URI����
    private String OPENTAB_MAX = "6";			   //Tabҳ�����
    private String OPENTAB_MAX_MESSAGE;			   //Tabҳ�ﵽ����ʾ��Ϣ
    private String log4jPath = "/config/log4j.xml";
	
	private Configuration(){
		OPENTAB_MAX_MESSAGE = "Tabҳ�ﵽ�����("+OPENTAB_MAX+")";
	}

	public String getRELOGIN_PAGE() {
		return RELOGIN_PAGE;
	}

	public String getENCODING() {
		return ENCODING;
	}

	public boolean isMUTIL_LOGIN() {
		return MUTIL_LOGIN;
	}

	public static Configuration getInstance() {
		return instance;
	}

	public String getSYSTEM_STATE() {
		return SYSTEM_STATE;
	}

	public int getFIRST_LEVEL_MENU_SHOW_NUM() {
		return FIRST_LEVEL_MENU_SHOW_NUM;
	}

	public int getFIRST_LEVEL_MENU_NUM() {
		return FIRST_LEVEL_MENU_NUM;
	}

	public String getURI_ENCODING() {
		return URI_ENCODING;
	}

	public String getOPENTAB_MAX() {
		return OPENTAB_MAX;
	}

	public String getOPENTAB_MAX_MESSAGE() {
		return OPENTAB_MAX_MESSAGE;
	}

	public String getLog4jPath() {
		return log4jPath;
	}

	public String getAPPLICATION_NAME() {
		return APPLICATION_NAME;
	}
	
}
