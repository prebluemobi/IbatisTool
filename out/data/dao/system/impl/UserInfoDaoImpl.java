package com.bluemobi.www.data.dao.discover.impl;
import org.springframework.stereotype.Component;
import com.bluemobi.www.data.dao.BaseDaoImpl;
import com.bluemobi.www.data.dao.discover.UserInfoDao;
import com.bluemobi.www.data.model.discover.UserInfo;
/**
 * 
 * @author mew
 *
 */
@Component
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao{
	public UserInfoDaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}