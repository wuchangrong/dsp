package com.handao.platform.framework.web.jsp;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import org.apache.struts.util.ResponseUtils;

import com.handao.platform.framework.util.AFLogger;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.platform.framework.web.AFForm;

public class AFSearchUtil {
    private AFLogger logger = AFLogger.getLogger(AFSearchUtil.class);

    private static HashMap clazzMap = new HashMap();

    public PageContext pageContext = null;

    public static DecimalFormat df = new DecimalFormat("#########0.00##");

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    public AFSearchUtil(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    /**
     * Get value from a value object
     * @param vo  Data container.
     * @param fieldName attribute of vo
     * @return String, the value of the attribute in vo.
     */
    public String getValueFromBean(AFValueObject vo, String fieldName) {
        Method method;
        Object object;
        try {
            Class clazz = vo.getClass();
            Class[] args = new Class[0];
            method = clazz.getMethod(getMethodName(fieldName), args);
            object = method.invoke(vo, args);
            if(object!=null) {
                String typeName = clazz.getDeclaredField(fieldName).getType().toString();
                if("double".equals(typeName)) {
                    return df.format(((Double)object));
                } else {
                    return object.toString();
                }
            } else {
                return "";
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            method = null;
            object = null;
        }
        return "";
    }

    /**
     * Get value from a value object
     * @param form  Data container.
     * @param fieldName attribute of vo
     * @return String, the value of the attribute in vo.
     */
    public String getValueFromBean(AFForm form, String fieldName) {
        try {
            Class clazz = form.getClass();
            Class[] args = new Class[0];
            Method method = clazz.getMethod(getMethodName(fieldName), args);
            Object object = method.invoke(form, args);
            if(object!=null) {
                return object.toString();
            } else {
                return "";
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Get value from a value object
     * @param vo  Data container.
     * @param fieldName attribute of vo
     * @param processClassName Class Name to be process the value, the class must impliments ValueProcess.
     * @return String, the value of the attribute in vo.
     */
    public String getValueFromBean(AFValueObject vo, String fieldName, AFValueProcess valueProcess) {

        String value = "";
        try {
            Class _class = vo.getClass();
            Method method = _class.getMethod(getMethodName(fieldName), null);
            Object object = method.invoke(vo, null);
            if(object != null) {
                String typeName = _class.getDeclaredField(fieldName).getType().toString();
                if(String.class.toString().equals(typeName)) {
                    value = ResponseUtils.filter((String)object);
                } else if(double.class.toString().equals(typeName)) {
                    value = df.format(((Double)object));
                } else {
                    value = object.toString();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if(valueProcess != null)
        	return valueProcess.process(value);
        return value;
    }

    /**
     * Get value from a value object
     * @param form  Data container.
     * @param fieldName attribute of vo
     * @param processClassName Class Name to be process the value, the class must impliments ValueProcess.
     * @return String, the value of the attribute in vo.
     */
    public String getValueFromBean(AFForm form, String fieldName, String processClassName) {
        String result = getValueFromBean(form, fieldName);
        result = processValue(result, processClassName);
        //result = AFStringUtil.parseHtml(result);
        return ResponseUtils.filter(result);
    }

    //get Class from HashMap.
    private Class getClassFromMap(String className) {
        if(clazzMap==null) {
            clazzMap = new HashMap();
        }
        return(Class)clazzMap.get(className);
    }

    //put Class to HashMap.
    private void putClassToMap(String className, Class clazz) {
        if(clazzMap==null) {
            clazzMap = new HashMap();
        }
        clazzMap.put(className, clazz);
    }

    private Class getClassObject(String className) {
        Class clazz = null;
        if(className == null || "".equals(className.trim())) {
            return null;
        }
        try {
            clazz = getClassFromMap(className);
            if(clazz==null) {
                clazz = Class.forName(className);
                putClassToMap(className, clazz);
            }
        } catch(Exception e) {
            logger.logError("can't found process class!");
        }
        return clazz;
    }

    private String getMethodName(String fieldName) {
        return "get"+processNameToUpperCase(fieldName);
    }

    private String processNameToUpperCase(String name) {
        if(name==null||"".equals(name.trim())) {
            return "";
        }
        String first = name.substring(0, 1);
        return name.replaceFirst(first, first.toUpperCase());
    }

    private String processValue(String value, String processClassName) {
        String result = value;
        AFValueProcess valueProcess;
        Class clazz;
        try {
            clazz = getClassObject(processClassName);
            if(clazz!=null) {
                valueProcess = (AFValueProcess)clazz.newInstance();
                valueProcess.setPageContext(pageContext);
                result = valueProcess.process(value);
            }
        } catch(Exception e) {
            logger.logError("can't create Process Class instance.");
        } finally {
            clazz = null;
            valueProcess = null;
        }
        return result;
    }
}