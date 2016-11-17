package com.bluemobi.www.data.dao.discover.impl;
import org.springframework.stereotype.Component;
import com.bluemobi.www.data.dao.BaseDaoImpl;
import com.bluemobi.www.data.dao.discover.MoneyStoreDao;
import com.bluemobi.www.data.model.discover.MoneyStore;
/**
 * 
 * @author mew
 *
 */
@Component
public class MoneyStoreDaoImpl extends BaseDaoImpl<MoneyStore> implements MoneyStoreDao{
	public MoneyStoreDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}