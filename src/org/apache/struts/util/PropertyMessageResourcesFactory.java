package org.apache.struts.util;

public class PropertyMessageResourcesFactory extends MessageResourcesFactory{
	private static final long serialVersionUID = 1L;

	public MessageResources createResources(String config){
        return new JXCPropertyMessageResources(this, config, this.returnNull);
    }
}
