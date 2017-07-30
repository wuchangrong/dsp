package com.handao.platform.framework.util;

import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.xml.DOMConfigurator;

import config.Configuration;

public class AFLogger implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Logger mLogger = null;
    protected static boolean isInitialized = false;

    private static String resource = Configuration.getInstance().getLog4jPath();

    public static AFLogger getLogger(Class callerClass) {
        if(!isInitialized) {
            isInitialized = true;
            URL configFileResource = AFLogger.class.getResource(resource);
            DOMConfigurator.configure(configFileResource.getFile());
        }
        Logger logger = Logger.getLogger(callerClass.getName());
        return new AFLogger(logger);
    }

    public AFLogger(Logger pLogger) {
        mLogger = pLogger;
    }

    public void logDebug(Object message) {
        log(Level.toLevel(Priority.DEBUG_INT), message);
    }

    public void logDebug(Object message, Throwable t) {
        log(Level.toLevel(Priority.DEBUG_INT), message, t);
    }

    public void logError(Object message) {
        log(Level.toLevel(Priority.ERROR_INT), message);
    }

    public void logError(Object message, Throwable t) {
        log(Level.toLevel(Priority.ERROR_INT), message, t);
    }

    public void logFatal(Object message) {
        log(Level.toLevel(Priority.FATAL_INT), message);
    }

    public void logFatal(Object message, Throwable t) {
        log(Level.toLevel(Priority.FATAL_INT), message, t);
    }

    public void logWarning(Object message) {
        log(Level.toLevel(Priority.WARN_INT), message);
    }

    public void logWarning(Object message, Throwable t) {
        log(Level.toLevel(Priority.WARN_INT), message, t);
    }

    public void logInfo(Object message) {
        log(Level.toLevel(Priority.INFO_INT), message);
    }

    public void logInfo(Object message, Throwable t) {
        log(Level.toLevel(Priority.INFO_INT), message, t);
    }

    protected void log(Priority priority, Object message) {
        mLogger.log(priority, message);
    }

    protected void log(Priority priority, Object message, Throwable t) {
        mLogger.log(priority, message, t);
    }

}