package com.bluemobi.www.data.dao.discover;

import com.bluemobi.www.data.dao.BaseDao;
import com.bluemobi.www.data.model.discover.MoneyStore;
/**
 * 数据访问接口
 *
 */
public interface MoneyStoreDao extends BaseDao<MoneyStore>{
	public String sqlNameSpace=MoneyStoreDao.class.getName();
}