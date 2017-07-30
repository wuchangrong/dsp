package com.handao.platform.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AFReflectUtil {

    private static final AFLogger logger = AFLogger.getLogger(AFReflectUtil.class);

    public static void setFieldValue(Object target, String fname, Class ftype, Object fvalue) {
        if(target == null || fname == null || "".equals(fname) || (fvalue != null && !ftype.isAssignableFrom(fvalue.getClass()))) {
            return;
        }
        Class _class = target.getClass();
        try {
            Field field = _class.getDeclaredField(fname);
            if(!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            field.set(target, fvalue);
        } catch(Exception fe) {
            logger.logDebug(fe);
        }
    }

    public static Object getAttribute(Object target, String fname, Class ftype) {
        if(target == null || fname == null || "".equals(fname)) {
            return null;
        }
        Class _class = target.getClass();
        try {
            Field field = _class.getDeclaredField(fname);
            if(!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            return field.get(target);
        } catch(Exception fe) {
            logger.logDebug(fe);
        }
        return null;
    }
}