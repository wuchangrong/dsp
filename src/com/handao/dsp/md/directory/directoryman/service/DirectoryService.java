package com.handao.dsp.md.directory.directoryman.service;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.dsp.md.directory.directoryman.bo.DirectoryBO;
import com.handao.platform.framework.biz.service.AFBizService;
import com.handao.platform.framework.bo.AFBOProvider;

/**
 * <p>application name:��������ƽ̨</p>
 * <p>application describing:</p>
 * <p>Copyright��Copyright 2010 ��Ȩ���С�</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */

public class DirectoryService extends AFBizService {

   private DirectoryBO bo_Directory = (DirectoryBO)AFBOProvider.getBOByClass(
    "com.handao.dsp.md.directory.directoryman.bo.DirectoryBO");

    /**
     * [������󷽷�ʵ��]
     * ���ص�ǰ�BO
     * @return AFBizBO
     */
    protected AFBizBO getActiveBO(){
        return bo_Directory;
    }
	
}