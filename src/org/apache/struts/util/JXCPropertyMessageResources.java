package org.apache.struts.util;

import java.util.Locale;

public class JXCPropertyMessageResources extends PropertyMessageResources{
	private static final long serialVersionUID = 1L;

	public JXCPropertyMessageResources(MessageResourcesFactory factory, String config)
    {
        super(factory, config);
    }

    public JXCPropertyMessageResources(MessageResourcesFactory factory, String config, boolean returnNull)
    {
        super(factory, config, returnNull);
    }


    public String getMessage(Locale locale, String key){
        locale = locale==null?Locale.CHINA:locale;
        String localeKey = localeKey(locale);
        String originalKey = messageKey(localeKey, key);
        String messageKey = null;
        String message = null;
        int underscore = 0;
        boolean addIt = false;  
        
        while(true){
            loadLocale(localeKey);
            messageKey = messageKey(localeKey, key);
            synchronized(messages){
                message = getMessageInfo(localeKey,messageKey);
                if(message != null)
                {
                    if(addIt)
                        messages.put(originalKey, message);
                    return (message);
                }
            }

            addIt = true;
            underscore = localeKey.lastIndexOf("_");
            if(underscore < 0)
                break;
            localeKey = localeKey.substring(0, underscore);

        }

        if(!defaultLocale.equals(locale))
        {
            localeKey = localeKey(defaultLocale);
            messageKey = messageKey(localeKey, key);
            loadLocale(localeKey);
            synchronized(messages)
            {
                message = getMessageInfo(localeKey,messageKey);
                if(message != null)
                {
                    if(addIt)
                        messages.put(originalKey, message);
                    return (message);
                }
            }
        }

        localeKey = "";
        messageKey = messageKey(localeKey, key);
        loadLocale(localeKey);
        synchronized(messages){
            message = getMessageInfo(localeKey,messageKey);
            if(message != null)
            {
                if(addIt)
                    messages.put(originalKey, message);
                return (message);
            }
        }

        if(returnNull)
            return (null);
        else
            return ("???" + messageKey(locale, key) + "???");

    }

    private String getMessageInfo(String localeKey, String msgKey){
        String result = "";
        try
        {
            String msg = (String)messages.get(msgKey);

            if(msg == null)
            {
                return msg;
            }

            if(localeKey == null || localeKey.trim().equals(""))
            {
                byte[] b = msg.getBytes("iso-8859-1");
                result = new String(b);
            } else
            {
                result = msg;
            }
            return result;
        } catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
