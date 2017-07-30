package com.handao.dsp.md.directory.directoryman.web;

import com.handao.platform.framework.biz.web.AFBizAction;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */ 

public class DirectoryAction extends AFBizAction{
	
	protected String getServiceName(){
        return "com.handao.dsp.md.directory.directoryman.service.DirectoryService";
    }
}