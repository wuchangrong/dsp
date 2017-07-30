package com.handao.dsp.md.warehouse.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.handao.platform.framework.biz.dao.AFBizDAO;
import com.handao.platform.framework.util.exception.AFDAOException;

public class WarehouseDAO extends AFBizDAO
{

	protected String getNameSpace()
	{
		return "dsp.md.warehouse.Warehouse";
	}

	public List doReturnMsg(HashMap map) throws AFDAOException
	{
		List result = null;
		try
		{
			result = daoCommand.sm_searchList(getNameSpace() + "."
					+ (String)map.get("sqlname"), map);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;

	}

}