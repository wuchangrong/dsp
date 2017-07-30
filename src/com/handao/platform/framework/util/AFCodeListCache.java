package com.handao.platform.framework.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handao.platform.framework.dao.AFDAOCommand;
import com.handao.platform.framework.vo.AFSelectListVO;

public class AFCodeListCache {
	private static final String SYS_PARAM_TYPE = "SYS_PARAM"; 
	
	private static Map codeMap = null;
	private static AFLogger logger = AFLogger.getLogger(AFCodeListCache.class);

	private AFCodeListCache() {
	}

	/**
	 * 清空缓存
	 */
	synchronized public static void clearCache() {
		if (codeMap != null)
			codeMap.clear();
		codeMap = null;
	}

	/**
	 * 初始化缓存
	 */
	private static void initCache() {
		codeMap = new HashMap();
		// 装载code-list数据
		AFDAOCommand daoCommand = new AFDAOCommand();
		List list = null;
		try {
			list = daoCommand.sm_searchList("framework.util.select.select-all");
		} catch (Exception e) {
			e.printStackTrace();
			logger.logError("Execute sql error:framework.util.select.select-all");
		}
		if (list == null)
			return;

		for (int i = 0; i < list.size(); i++) {
			AFSelectListVO selectVO = (AFSelectListVO) list.get(i);
			List tempList = (List) codeMap.get(selectVO.getList_code());
			if (tempList == null) {
				tempList = new ArrayList();
				codeMap.put(selectVO.getList_code(), tempList);
			}
			tempList.add(selectVO);
		}
	}

	/**
	 * 获取list_code对应的列表
	 * @param strListCode
	 * @return
	 */
	synchronized public static List getSelectListByListCode(String strListCode) {
		if (codeMap == null) {
			initCache();
		}
		List result = (List)codeMap.get(strListCode);
		if(result == null)
			result = new ArrayList();
		return result;
	}
	/**
	 * 获取系统参数
	 * @param paramCode
	 * @return
	 */
	public static String getSysParam(String paramCode){
		List sysParamList = AFCodeListCache.getSelectListByListCode(AFCodeListCache.SYS_PARAM_TYPE);
		String result = "";
		if(sysParamList == null)
			return result;
		
		for(int i = 0;i<sysParamList.size();i++){
			AFSelectListVO selectVO = (AFSelectListVO) sysParamList.get(i);
			if(paramCode.equals(selectVO.getCode())){
				result = selectVO.getName();
				break;
			}
		}
		return result;
	}

	// 执行SQL
	public static ArrayList getSelectListBySql(String sql) {
		AFDAOCommand daoCommand = new AFDAOCommand();
		ArrayList list = null;
		try {
			list = (ArrayList) daoCommand.sm_searchList("framework.util.select.select-by-sql", (Object) sql);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.logError("Execute sql error:" + sql);
			list = new ArrayList();
		}
		return list;
	}

	// 执行指定SQLID
	public static ArrayList getSelectListBySqlId(String sqlId) {
		AFDAOCommand daoCommand = new AFDAOCommand();
		ArrayList list = new ArrayList();
		try {
			List tempList = (List) daoCommand.sm_searchList(sqlId);
			for (int i = 0; i < tempList.size(); i++) {
				Map item = (Map) tempList.get(i);

				AFSelectListVO vo = new AFSelectListVO();
				vo.setCode((String) item.get("CODE"));
				vo.setName((String) item.get("NAME"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.logError("Execute sql error:" + sqlId);
		}
		return list;
	}
	/**
	 * 方法描述:通过listCode，返回codeName映射
	 */
	public static Map getCodeNameMapByListCode(String listCode){
		return AFCodeListCache.transferList(AFCodeListCache.getSelectListByListCode(listCode));
	}
	/**
	 * 方法描述:通过sql，返回codeName映射,sql语句中，需包含CODE,NAME
	 */	
	public static Map getCodeNameMapBySql(String sql){
		return AFCodeListCache.transferList(AFCodeListCache.getSelectListBySql(sql));
	}
	/**
	 * 方法描述:通过sqlId，返回codeName映射,sql语句中，需包含CODE,NAME
	 */
	public static Map getCodeNameMapBySqlId(String sqlId){
		return AFCodeListCache.transferList(AFCodeListCache.getSelectListBySqlId(sqlId));		
	}
	/**
	 * List(AFSelectVO)-->Map(code,name))
	 */
	private static Map transferList(List list){
		Map result = new HashMap();
		if(list != null){
			for(int i = 0;i<list.size();i++){
				AFSelectListVO selectVO = (AFSelectListVO) list.get(i);	
				result.put(selectVO.getCode(), selectVO.getName());
			}
		}
		return result;
	}
}