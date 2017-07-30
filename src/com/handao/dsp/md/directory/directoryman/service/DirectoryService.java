package com.handao.dsp.md.directory.directoryman.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.dsp.md.directory.directoryman.bo.DirectoryBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */

public class DirectoryService extends AFBizService {

   private DirectoryBO bo_Directory = (DirectoryBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.md.directory.directoryman.bo.DirectoryBO");

    /**
     * [父类抽象方法实现]
     * 返回当前活动BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO(){
        return bo_Directory;
    }
	
}