package com.tywy.sc.controller.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.data.model.${table.className};
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.services.${table.className}Service;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: ${table.className}Controller 
* @Description: ${title}控制层 
* @author ${author} 
* @date ${date} 
* @Copyright：${projectName}
 */
@Controller
public class ${table.className}Controller extends BaseController {
	@Resource
	private ${table.className}Service service;

	@RequestMapping(value = "${package}/${table.classNameL}List")
	public String ${table.classNameL}List(HttpServletRequest request,
			HttpServletResponse response) {
		return "${package}/${table.tabelName}_list";
	}

	@RequestMapping(value = "${package}/${table.classNameL}AjaxPage")
	@ResponseBody
	public PageInfo<${table.className}> ${table.classNameL}AjaxPage(HttpServletRequest request,
			HttpServletResponse response, ${table.className} info, Integer page,
			Integer rows) {
		PageInfo<${table.className}> pageInfo = new PageInfo<${table.className}>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "${package}/${table.classNameL}AjaxAll")
	@ResponseBody
	public List<${table.className}> ${table.classNameL}AjaxAll(HttpServletRequest request,
			HttpServletResponse response, ${table.className} info, Integer page,
			Integer rows) {
		List<${table.className}> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "${package}/${table.classNameL}AjaxSave")
	@ResponseBody
	public Map<String,Object> ${table.classNameL}AjaxSave(HttpServletRequest request,
			HttpServletResponse response, ${table.className} info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			result = service.insert(info);
			msg = "保存失败！";
		} else {
			result = service.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}

	@RequestMapping(value = "${package}/${table.classNameL}AjaxDelete")
	@ResponseBody
	public Map<String,Object> ${table.classNameL}AjaxDelete(HttpServletRequest request,
			HttpServletResponse response, ${table.className} info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
