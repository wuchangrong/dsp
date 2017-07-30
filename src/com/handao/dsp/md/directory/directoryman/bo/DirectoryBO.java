package com.handao.dsp.md.directory.directoryman.bo;

import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.vo.AFValueObject;
import com.handao.dsp.md.directory.directoryman.dao.DirectoryDAO;
import com.handao.dsp.md.directory.directoryman.vo.DirectoryVO;

/**
 * <p>application name:分销管理平台</p>
 * <p>application describing:</p>
 * <p>Copyright：Copyright 2010 版权所有。</p>
 * <p>company:handaowang</p>
 * <p>time:July 14, 2010</p>
 * @author cg
 * @version $Revision
 */ 

public class DirectoryBO extends AFBizBO {

	private DirectoryDAO dao_Directory = (DirectoryDAO)AFDAOProvider.getDAOByClass(
	"com.handao.dsp.md.directory.directoryman.dao.DirectoryDAO");   

	public DirectoryBO(){		
		this.addListener(new AFBizBOListenerImpl(){
			/**
			 * [AFBizBOListenerImpl类方法复写]
			 */		  	
			public boolean beforeInsert(AFUserToken userToken,AFValueObject vo){
				//根目录只能系统创建（部署时）
				if ("root".equals(((DirectoryVO)vo).getDIR_CODE())){
					return false;
				}
				if (((DirectoryVO)vo).getPARENT_DIR()<1)
					return false;				    
				DirectoryVO pvo=(DirectoryVO)dao_Directory.doFindById(((DirectoryVO)vo).getPARENT_DIR());

				((DirectoryVO)vo).setROW_ID(AFIDFactory.getNextID());
				((DirectoryVO)vo).setCREATED_BY(userToken.getUserId());
				((DirectoryVO)vo).setLAST_UPD_BY(userToken.getUserId());
				((DirectoryVO)vo).setPATH(pvo.getPATH()+"/"+((DirectoryVO)vo).getDIR_CODE());
				return true;
			}

			public boolean beforeUpdate(AFUserToken userToken,AFValueObject vo){
				if ("root".equals(((DirectoryVO)vo).getDIR_CODE())){
					return false;
				}
				if (((DirectoryVO)vo).getPARENT_DIR()<1)
					return false;
				DirectoryVO pvo=(DirectoryVO)dao_Directory.doFindById(((DirectoryVO)vo).getPARENT_DIR());
				((DirectoryVO)vo).setLAST_UPD_BY(userToken.getUserId());
				((DirectoryVO)vo).setPATH(pvo.getPATH()+"/"+((DirectoryVO)vo).getDIR_CODE());
				return true;
			}
		});
	}

	protected AFBizDAO getActiveDAO(){
		return dao_Directory;
	}	

}