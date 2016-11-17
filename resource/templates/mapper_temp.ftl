<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace必须指向Dao接口 -->
<mapper namespace="com.tywy.sc.data.dao.${table.className}Dao">

<#assign str="#{">
<#assign end="}">
	<resultMap id="colomnResult" type="com.tywy.sc.data.model.${table.className}">
<#list table.pkCloums as pk>
		<id property="${pk.cloumName}" column="${pk.cloumName}" />
</#list>
<#list table.cloums as c>
<#list table.pkCloums as pk>
<#if c.cloumName != pk.cloumName>
		<result property="${c.cloumName}" column="${c.cloumName}" />
</#if>
</#list>
</#list>
	</resultMap>
	<!-- 动态sql -->
	<sql id="colomnResult">
		<![CDATA[
	    <#list table.cloums as c>
	     ${c.cloumName}<#if c_has_next>,</#if>
		</#list>
	 ]]>
	</sql>
	<insert id="insert">
	   insert into ${table.tabelName}  
	   <trim prefix="(" suffix=")" suffixOverrides=",">
	   		<#list table.cloums as c>
			     <if test="${c.cloumName}!=null">${c.cloumName},</if>
			</#list>
		</trim>
	   	<trim prefix="values(" suffix=")" suffixOverrides=",">
	   		<#list table.cloums as c>
			     <if test="${c.cloumName}!=null">${str}${c.cloumName}${end},</if>
			</#list>
		</trim>
	</insert>

	<update id="update">
	   update ${table.tabelName} 
	   <set>
			<#list table.cloums as c>
			     <if test="${c.cloumName}!=null">${c.cloumName}=${str}${c.cloumName}${end},</if>
			</#list>
		</set>
		where 
	   <#list table.pkCloums as pk>
	   		<#if pk_index!=0> and</#if> ${pk.cloumName}=${str}${pk.cloumName}${end} 
	   </#list>
	</update>

	<delete id="delete">
	   delete from
	     ${table.tabelName} 
	   where 
	   <#list table.pkCloums as pk>
	   <#if pk_index!=0> and</#if> ${pk.cloumName}=${str}${pk.cloumName}${end} 
	   </#list>
	</delete>

	<select id="selectEntity" resultMap="colomnResult">
	   select 
	<include refid="colomnResult" /> 
	   from ${table.tabelName}
	  <where>
		<#list table.cloums as pk>
				<if test=" ${pk.cloumName} != null and ${pk.cloumName} != '' ">
					and ${pk.cloumName}=${str}${pk.cloumName}${end} 
				</if>
			 </#list>
		</where>
	</select>
	
	<!-- 根据条件信息 -->
	<select id="selectAll"  resultMap="colomnResult">
		select
		<include refid="colomnResult" /> 
		<![CDATA[
			from ${table.tabelName}
		]]>
		<where>
			<#list table.cloums as pk>
				<if test=" ${pk.cloumName} != null and ${pk.cloumName} != '' ">
					and ${pk.cloumName}=${str}${pk.cloumName}${end} 
				</if>
			 </#list>
		</where>
		<if test="sort != null">
				order by ${r'${sort}'} ${r'${order}'}
		</if>
	</select>
	<!-- 根据条件查询数量 -->
	<select id="selectCount"  resultType="int">

		select count(id) from ${table.tabelName}
		<where>
			<#list table.cloums as pk>
				<if test=" ${pk.cloumName} != null and ${pk.cloumName} != '' ">
					and ${pk.cloumName}=${str}${pk.cloumName}${end} 
				</if>
			 </#list>
		</where>
	</select>
	<!-- 根据主键查询信息 -->
	<select id="selectById"  resultMap="colomnResult">
		select
		<include refid="colomnResult" /> 
		<![CDATA[
			from ${table.tabelName} where 
			
			 <#list table.pkCloums as pk>
			   	<#if pk_index!=0> and</#if> ${pk.cloumName}=${str}${pk.cloumName}${end} 
			  </#list>
		]]>
		
	</select>
	
	<!-- 批量删除 -->
	<select id="selectByIds" parameterType="java.util.List" resultMap="colomnResult">
		select
		<include refid="colomnResult" /> 
		 from ${table.tabelName} where id in
		<foreach item="idList" index="index" collection="list" open="(" separator="," close=")">
  			${r'#{idList}'}
 		</foreach>
	</select>
		
	<!-- 批量删除 -->
	<delete id="batchDelete" parameterType="java.util.List">
		delete from ${table.tabelName} where id in
		<foreach item="idList" index="index" collection="list" open="(" separator="," close=")">
  			${r'#{idList}'}
 		</foreach>
	</delete>
	
	<!-- 批量修改 -->
	<update id="batchUpdate" parameterType="java.util.HashMap">
		update ${table.tabelName}
		<set>
			<#list table.cloums as c>
			     <if test="${c.cloumName}!=null">${c.cloumName}=${str}${c.cloumName}${end},</if>
			</#list>
		</set>
		where id in
		<foreach item="idList" index="index" collection="list" open="(" separator="," close=")">
  			${r'#{idList}'}
 		</foreach>
	</update>
</mapper> 