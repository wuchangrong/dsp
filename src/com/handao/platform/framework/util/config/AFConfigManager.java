package com.handao.platform.framework.util.config;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.handao.platform.framework.util.AFLogger;

public class AFConfigManager {
    private AFLogger logger = AFLogger.getLogger(AFConfigManager.class);

    private static AFConfigManager manager = null;

    private AFScriptConfig scriptConfig = null;

    private AFStyleConfig styleConfig = null;

    private ServletContext sc = null;

    void setServletContext(ServletContext sc) {
        this.sc = sc;
    }

    private AFConfigManager() {
        scriptConfig = new AFScriptConfig();
        styleConfig = new AFStyleConfig();
    }

    public static AFConfigManager getInstance() {
        if(manager == null) {
            manager = new AFConfigManager();
        }
        return manager;
    }

    void init(String configFilePath) {
        DocumentBuilder db = null;
        Document doc = null;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(sc.getResourceAsStream(configFilePath));
            Node configNode = doc.getChildNodes().item(0);
            for(int i = 0, j = configNode.getChildNodes().getLength(); i < j; i++) {
                Node node = configNode.getChildNodes().item(i);
                if("sqlmap-config".equals(node.getNodeName())) {
                    initSqlMapConfig(node);
                    continue;
                }
                if("style-config".equals(node.getNodeName())) {
                    initStyleConfig(node);
                    continue;
                }
                if("script-config".equals(node.getNodeName())) {
                    initScriptConfig(node);
                    continue;
                }
            }
        } catch(ParserConfigurationException pcEx) {
            pcEx.printStackTrace();
        } catch(SAXException saxEx) {
            saxEx.printStackTrace();
        } catch(IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    private void initSqlMapConfig(Node node_SqlMap) {
        logger.logInfo("Loading SqlMap Config");
        boolean flag = true;
        try {
            NodeList nodeList_Param = node_SqlMap.getChildNodes();
            for(int i = 0, j = nodeList_Param.getLength(); i < j; i++) {
                Node node_Param = nodeList_Param.item(i);
                if("sqlmap".equals(node_Param.getNodeName())) {
                    NamedNodeMap paraNameMap = node_Param.getAttributes();
                    if(paraNameMap != null) {
                        String dbkey = paraNameMap.getNamedItem("dbkey").getNodeValue();
                        String dbtype = paraNameMap.getNamedItem("dbtype").getNodeValue();
                        String filePath = paraNameMap.getNamedItem("filePath").getNodeValue();
                        String isDefault = paraNameMap.getNamedItem("default") == null ? "false" : paraNameMap.getNamedItem("default").getNodeValue();
                        AFSqlMapConfig.addSqlMapConfig(dbkey, dbtype, filePath, isDefault, sc);
                    }
                }
            }
        } catch(Exception ex) {
            flag = false;
            logger.logInfo(ex);
        }
        logger.logInfo(flag ? "SqlMap config OK" : "SqlMap config Error");
    }

    private void initStyleConfig(Node node_Style) {

        NamedNodeMap nameMap_Style = node_Style.getAttributes();
        String currentStyle = nameMap_Style.getNamedItem("currentStyle").getNodeValue();
        String stylePath = nameMap_Style.getNamedItem("stylePath").getNodeValue();
        String imgPath = nameMap_Style.getNamedItem("imgPath").getNodeValue();
        String cssPath = nameMap_Style.getNamedItem("cssPath").getNodeValue();
        styleConfig.setCurrentStyle(currentStyle);
        styleConfig.setStylePath(stylePath);
        styleConfig.setImgPath(imgPath);
        styleConfig.setCssPath(cssPath);
        NodeList nodeList_File = node_Style.getChildNodes();
        for(int i = 0, j = nodeList_File.getLength(); i < j; i++) {
            Node node_File = nodeList_File.item(i);

            if("file".equals(node_File.getNodeName())) {
                NamedNodeMap paraNameMap = node_File.getAttributes();
                if(paraNameMap != null) {
                    styleConfig.addConfig(paraNameMap.getNamedItem("src").getNodeValue(), paraNameMap.getNamedItem("scope").getNodeValue());
                }
            }
        }
        styleConfig.init();
    }

    private void initScriptConfig(Node node_Script) {
        NodeList nodeList_File = node_Script.getChildNodes();
        for(int i = 0, j = nodeList_File.getLength(); i < j; i++) {
            Node node_File = nodeList_File.item(i);
            if("file".equals(node_File.getNodeName())) {
                NamedNodeMap paraNameMap = node_File.getAttributes();
                if(paraNameMap != null) {
                    scriptConfig.addConfig(paraNameMap.getNamedItem("src").getNodeValue(), paraNameMap.getNamedItem("scope").getNodeValue());
                }
            }
        }
        scriptConfig.init();
    }

    public AFScriptConfig getJSConfig() {
        return scriptConfig;
    }

    public AFStyleConfig getStyleConfig() {
        return styleConfig;
    }
}