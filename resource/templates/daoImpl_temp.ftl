package com.tywy.sc.data.dao.impl;

import org.springframework.stereotype.Component;
import com.tywy.sc.base.BaseDaoImpl;
import com.tywy.sc.data.dao.${table.className}Dao;
import com.tywy.sc.data.model.${table.className};
<#if table.cnName??>
/**
 * ${table.cnName}
 * @author mew
 *
 */
</#if>
@Component
public class ${table.className}DaoImpl extends BaseDaoImpl<${table.className}> implements ${table.className}Dao{
	public ${table.className}DaoImpl(){
		setSql_name_space(sqlNameSpace);
	}
}