package com.bluemobi.www.security.discover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemobi.www.data.dao.discover.UserInfoDao;
import com.bluemobi.www.data.model.discover.UserInfo;
import com.bluemobi.www.security.base.service.impl.BaseServiceImpl;
import com.bluemobi.www.security.discover.service.UserInfoService;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(userInfoDao);
	}
	
}