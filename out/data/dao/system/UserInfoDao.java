package com.bluemobi.www.data.dao.discover;

import com.bluemobi.www.data.dao.BaseDao;
import com.bluemobi.www.data.model.discover.UserInfo;
/**
 * 数据访问接口
 *
 */
public interface UserInfoDao extends BaseDao<UserInfo>{
	public String sqlNameSpace=UserInfoDao.class.getName();
}