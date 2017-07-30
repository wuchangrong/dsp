package com.handao.platform.framework.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

import com.handao.platform.framework.util.morpher.SqlDateMorpher;
import com.handao.platform.framework.vo.AFValueObject;

public class AFJsonUtil {

	private static AFLogger logger = AFLogger.getLogger(AFJsonUtil.class);
	
	private static NumberProcessor numberProcessor = new NumberProcessor();
	
	private static DateProcessor dateProcessor = new DateProcessor("yyyy-MM-dd");
	private static DateProcessor timeStampProcessor = new DateProcessor("yyyy-MM-dd HH:mm:ss");
	static{
		JSONUtils.getMorpherRegistry().registerMorpher(new SqlDateMorpher(new String[]{"yyyy-MM-dd"}));
	}	
	
	public static JsonConfig getDefaultJsonConfig() {
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(Long.class, numberProcessor);
		jc.registerJsonValueProcessor(BigDecimal.class, numberProcessor);
		jc.registerJsonValueProcessor(Timestamp.class, timeStampProcessor);
		jc.registerJsonValueProcessor(Date.class, dateProcessor);
		return jc;
	}
	
	public static JsonConfig getToAFJsonConfig() {
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(long.class, numberProcessor);		
		jc.registerJsonValueProcessor(Long.class, numberProcessor);
		jc.registerJsonValueProcessor(Long.class, numberProcessor);
		
		jc.registerJsonValueProcessor(BigDecimal.class, numberProcessor);
		jc.registerJsonValueProcessor(Timestamp.class, timeStampProcessor);
		jc.registerJsonValueProcessor(Date.class, dateProcessor);
		return jc;
	}
	
	public static JsonConfig getToJsonObjectConfig() {
		JsonConfig jc = new JsonConfig();
		return jc;
	}
	
	public static JsonConfig getToBeanJsonConfig() {
		JsonConfig jc = new JsonConfig();
		return jc;
	}
	
	public static String toJsonString(List list) {
		try{
			return JSONArray.fromObject(list, getDefaultJsonConfig()).toString();
		}
		catch(Exception e) {
			logger.logDebug(e);
			return "";
		}
	}
	
	public static String toJsonString(Map map) {
		try{
			return JSONObject.fromObject(map, getDefaultJsonConfig()).toString();
		}
		catch(Exception e) {
			logger.logDebug(e);
			return "";
		}		
	}
	
	public static String toJsonString(AFValueObject vo) {
		try{
			return JSONObject.fromObject(vo).toString();
		}
		catch(Exception e) {
			logger.logDebug(e);
			return "";
		}		
	}
	
	public static List toList(String str) {
		try{
			return JSONArray.fromObject(str);
		}
		catch(Exception e) {
			logger.logDebug(e);
			return null;
		}		
	}
	
	public static Map toMap(String str) {
		try{
			return JSONObject.fromObject(str);
		}
		catch(Exception e) {
			logger.logDebug(e);
			return null;
		}		
	}
	
	public static AFValueObject toVO(String str) {
		throw new RuntimeException("AFJsonUtil.toVO not implement!");
	}
}

class NumberProcessor implements JsonValueProcessor {
	
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		throw new RuntimeException("NumberProcessor.processArrayValue not implement!");
	}
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		return String.valueOf(value);
	}
}

class StringProcessor implements JsonValueProcessor{
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		throw new RuntimeException("StringProcessor.processArrayValue not implement!");
	}
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		return value;
//		return JavaScriptUtils.javaScriptEscape((String)value);
	}
}

class DateProcessor implements JsonValueProcessor {
	private static SimpleDateFormat sdf = null;
	
	public DateProcessor(String pattern) {
		sdf = new SimpleDateFormat(pattern);
	}
	
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		throw new RuntimeException("DateProcessor.processArrayValue not implement!");
	}
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		if(value == null) return null;
		return sdf.format(value);
	}
}