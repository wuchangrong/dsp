package com.handao.dsp.md.warehouse.bo;

import java.util.HashMap;
import java.util.List;

import com.handao.dsp.md.warehouse.dao.WarehouseDAO;
import com.handao.dsp.md.warehouse.vo.WarehouseVO;
import com.handao.platform.framework.biz.bo.AFBizBO;
import com.handao.platform.framework.biz.bo.AFBizBOListenerImpl;
import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.dao.AFDAOProvider;
import com.handao.platform.framework.envelope.AFUserToken;
import com.handao.platform.framework.util.AFIDFactory;
import com.handao.platform.framework.util.exception.AFBOException;
import com.handao.platform.framework.vo.AFValueObject;


public class WarehouseBO extends AFBizBO {

    private WarehouseDAO dao_Warehouse = (WarehouseDAO)AFDAOProvider.getDAOByClass("com.handao.dsp.md.warehouse.dao.WarehouseDAO");
       
    public WarehouseBO() {
        this.addListener(new AFBizBOListenerImpl() {
            public boolean beforeInsert(AFUserToken userToken, AFValueObject vo) {
                ((WarehouseVO)vo).setWH_ROW_ID(AFIDFactory.getNextID());
                ((WarehouseVO)vo).setCREATED_BY(userToken.getUserId());
                ((WarehouseVO)vo).setLAST_UPD_BY(userToken.getUserId());
                return true;
            }
            
            public boolean beforeUpdate(AFUserToken userToken, AFValueObject vo)
            {
                ((WarehouseVO)vo).setLAST_UPD_BY(userToken.getUserId());
                return true;
            }

        });
    }
    
    public List doReturnMsg(AFUserToken userToken, HashMap map) {
    	try {
    		List result = dao_Warehouse.doReturnMsg(map);
            return result;
        }
        catch (Exception ex) {
            throw new AFBOException(ex);
        }  
        
    }

    protected AFBizDAO getActiveDAO() {
        return dao_Warehouse;
    }
}