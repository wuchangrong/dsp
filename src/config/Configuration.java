package config;
/**
 * 配置信息
 */
public class Configuration {	
	private static Configuration instance = new Configuration();
	
	private String APPLICATION_NAME = "华柳分销服务平台";
	private String RELOGIN_PAGE = "/relogin.jsp";  //重新登陆页面
	private String ENCODING = "GBK";        	   //默认字符集
	private boolean MUTIL_LOGIN = true;            //是否多点登录
	private String SYSTEM_STATE = "open";		   //系统状态（open/close）
	private int FIRST_LEVEL_MENU_SHOW_NUM = 10;     //顶级菜单显示数目
	private int FIRST_LEVEL_MENU_NUM = 9;          //一级菜单数目
    private String URI_ENCODING = "iso-8859-1";    //URI编码
    private String OPENTAB_MAX = "6";			   //Tab页最大数
    private String OPENTAB_MAX_MESSAGE;			   //Tab页达到数提示消息
    private String log4jPath = "/config/log4j.xml";
	
	private Configuration(){
		OPENTAB_MAX_MESSAGE = "Tab页达到最大数("+OPENTAB_MAX+")";
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
