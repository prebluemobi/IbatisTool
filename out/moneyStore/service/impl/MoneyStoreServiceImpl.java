package com.bluemobi.www.security.discover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemobi.www.data.dao.discover.MoneyStoreDao;
import com.bluemobi.www.data.model.discover.MoneyStore;
import com.bluemobi.www.security.base.service.impl.BaseServiceImpl;
import com.bluemobi.www.security.discover.service.MoneyStoreService;

@Service
public class MoneyStoreServiceImpl extends BaseServiceImpl<MoneyStore> implements MoneyStoreService{

	@Autowired
	private MoneyStoreDao moneyStoreDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(moneyStoreDao);
	}
	
}