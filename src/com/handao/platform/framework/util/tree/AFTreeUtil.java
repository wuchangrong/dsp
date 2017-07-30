package com.handao.platform.framework.util.tree;

import com.handao.platform.framework.dao.AFDAOCommand;
import com.handao.platform.framework.util.AFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AFTreeUtil
{

    public AFTreeUtil()
    {
    }

    public static List getDataBySql(String dbkey, String sql, long rootId, boolean isCheckboxTree)
    {
        AFDAOCommand command = new AFDAOCommand();
        List data = null;
        try
        {
            data = command.sm_searchList(dbkey, "framework.util.tree.select-by-sql", sql);
        }
        catch(SQLException e)
        {
            logger.logError(e);
        }
        data = buildTree(rootId, data);
        return data;
    }

    public static List getDataBySqlIdWithNodeHandler(String dbkey, String statementName, Object parameterObject, AFTreeNodeHandler nodeHandler, long parentNodeID)
    {
        AFDAOCommand command = new AFDAOCommand();
        List data = null;
        try
        {
            command.sm_searchWithRowHandler(statementName, parameterObject, nodeHandler);
            data = nodeHandler.getList();
        }
        catch(SQLException e)
        {
            logger.logError(e);
        }
        data = buildTree(parentNodeID, data);
        return data;
    }

    public static List buildTree(long parentNodeID, List data)
    {
        if(data == null || data.size() == 0)
            return data;
        List list = new ArrayList();
        for(int i = 0; i < data.size();)
        {
            AFTreeNode node = (AFTreeNode)data.get(i);
            if(parentNodeID == node.getPid())
            {
                list.add(node);
                data.remove(node);
                addNode(node, data);
            } else
            {
                i++;
            }
        }

        return list;
    }

    private static void addNode(AFTreeNode pNode, List data)
    {
        for(int i = 0; i < data.size(); i++)
        {
            AFTreeNode node = (AFTreeNode)data.get(i);
            if(node.isChildren(pNode))
            {
                pNode.addChildren(node);
                node.setParent(pNode);
                if(!node.isLeaf())
                    addNode(node, data);
            }
        }

    }

    private static AFLogger logger;

    static 
    {
        logger = AFLogger.getLogger(com.handao.platform.framework.util.tree.AFTreeUtil.class);
    }
}
