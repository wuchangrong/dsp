package com.handao.platform.framework.util.tree;

import java.util.*;

public class AFTreeNodeMap extends HashMap implements AFTreeNode
{
	private static final long serialVersionUID = 1L;
	/**
     * ¸¸½Úµã
     */
    private AFTreeNode parent;
    
    public AFTreeNode getParent()
    {
        return parent;
    }

    public AFTreeNodeMap()
    {
    }

    public Object put(Object key, Object value)
    {
        return super.put(key.toString().toLowerCase(), value);
    }

    public boolean isLeaf()
    {
        return ((Boolean) get("leaf")).booleanValue();
    }

    public long getId()
    {
        return Long.parseLong(String.valueOf(get("id")));
    }

    public long getPid()
    {
        return Long.parseLong(String.valueOf(get("pid")));
    }

    public boolean isChildren(AFTreeNode p)
    {
        return getPid() == p.getId();
    }

    public void addChildren(AFTreeNode node)
    {
        List children = (List) get("children");
        if (children == null)
        {
            children = new ArrayList();
            put("children", children);
        }
        children.add(node);
    }

    /**
     * {@inheritDoc}
     *
     * @param eaptreenode
     * @see: 
     */
    public void setParent(AFTreeNode eaptreenode)
    {
        this.parent = eaptreenode;
    }
}