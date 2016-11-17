package com.tywy.sc.data.dao;

import com.tywy.sc.base.BaseDao;
import com.tywy.sc.data.model.${table.className};
<#if table.cnName??>
/**
 * ${table.cnName}数据访问接口
 *
 */
</#if>
public interface ${table.className}Dao extends BaseDao<${table.className}>{
	public String sqlNameSpace=${table.className}Dao.class.getName();
}