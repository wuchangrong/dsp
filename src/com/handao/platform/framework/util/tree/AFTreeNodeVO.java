package com.handao.platform.framework.util.tree;

import java.util.ArrayList;
import java.util.List;

import com.handao.platform.framework.vo.AFValueObject;

public abstract class AFTreeNodeVO extends AFValueObject implements AFTreeNode {

	private long id;
	
	private long pid;
	
	private List children;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}
	
	public long getPid() {
		return this.pid;
	}
	
	public void setChildren(List children) {
		this.children = children;
	}
	
	public List getChildren() {
		return this.children;
	}
	
	public void addChildren(AFTreeNode vo) {
		if(children == null)
			children = new ArrayList();
		children.add(vo);
	}

    public boolean isChildren(AFTreeNode p) {
    	return this.getPid() == p.getId();
    }
    
	public abstract boolean isLeaf();

}