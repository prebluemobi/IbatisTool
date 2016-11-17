package com.tywy.sc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tywy.sc.base.service.BaseServiceImpl;
import com.tywy.sc.data.dao.${table.className}Dao;
import com.tywy.sc.data.model.${table.className};
import com.tywy.sc.services.${table.className}Service;

@Service
public class ${table.className}ServiceImpl extends BaseServiceImpl<${table.className}> implements ${table.className}Service{

	@Autowired
	private ${table.className}Dao ${table.classNameL}Dao;
	
	@Autowired
	public void setBaseDao() {
	   super.setBaseDao(${table.classNameL}Dao);
	}
	
}