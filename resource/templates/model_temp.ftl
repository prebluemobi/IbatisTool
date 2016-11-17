package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

<#if table.tabelName??>
/**
 * ${table.tabelName}实体表(${table.cnName})
 * @author ${author}
 * @date ${date}
 * @project ${projectName}
 */
</#if>
 @SuppressWarnings("serial")
public class ${table.className} extends BaseEntity implements Serializable {
<#list table.cloums as c>
	private ${c.javaType} ${c.cloumName}; <#if c.cnName??>// ${c.cnName}</#if>
</#list>
<#list table.cloums as c>
	<#if c.cnName??>
	/**
     * 获取${c.cnName}属性
     *
     * @return ${c.cloumName}
     */
    </#if>
	public ${c.javaType} get${c.cloumNameU}() {
		return ${c.cloumName};
	}
	
	<#if c.cnName??>
	/**
	 * 设置${c.cnName}属性
	 *
	 * @param ${c.cloumName}
	 */
	</#if>
	public void set${c.cloumNameU}(${c.javaType} ${c.cloumName}) {
		this.${c.cloumName} = ${c.cloumName};
	}
	
</#list>

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("${table.className}");
        <#list table.cloums as c>
        sb.append("<#if c_index==0>{</#if><#if c_index!=0>, </#if>${c.cloumName}=").append(${c.cloumName});
        </#list>
		sb.append('}');
        return sb.toString();
    }
    
}