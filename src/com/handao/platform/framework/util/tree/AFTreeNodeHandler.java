package com.handao.platform.framework.util.tree;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.event.RowHandler;


public class AFTreeNodeHandler implements RowHandler {

	private List list = new ArrayList();
	
	private String leafFlagValue = null;
	
	public AFTreeNodeHandler(String leafFlagValue) {
		super();
		this.leafFlagValue = leafFlagValue;
	}
	
	public void handleRow(Object valueObject) {
		AFTreeNodeMap map = (AFTreeNodeMap)valueObject;
		String leaf = (String)map.get("leaf");
		map.put("leaf", (leafFlagValue.equals(leaf)?Boolean.TRUE:Boolean.FALSE));
	    list.add(valueObject);
	}
	
    public List getList() {
	    return list;
	}
	
	public void setList(List list) {
	    this.list = list;
	}
}