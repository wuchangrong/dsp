package com.handao.platform.framework.util.tree;


public interface AFTreeNode
{

    public abstract long getId();

    public abstract long getPid();

    public abstract boolean isLeaf();

    public abstract boolean isChildren(AFTreeNode eaptreenode);

    public abstract void addChildren(AFTreeNode eaptreenode);
    
    /**
     * …Ë÷√∏∏Ω⁄µ„
     *
     * @param eaptreenode
     * @see: 
     */
    public abstract void setParent(AFTreeNode eaptreenode);
}
