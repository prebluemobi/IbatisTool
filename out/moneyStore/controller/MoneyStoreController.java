package com.bluemobi.www.security.discover.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.www.data.model.discover.MoneyStore;
import com.bluemobi.www.page.PageInfo;
import com.bluemobi.www.security.base.controller.BaseController;
import com.bluemobi.www.security.discover.service.MoneyStoreService;
import com.bluemobi.www.utils.UUIDUtil;

/**
 * 
* @ClassName: MoneyStoreController 
* @Description: 发现控制层 
* @author lip 
* @date 2016-09-14 07:16:19 
* @Copyright：上海科匠信息科技有限公司 2015
 */
@Controller
public class MoneyStoreController extends BaseController {
	@Resource
	private MoneyStoreService service;

	@RequestMapping(value = "discover/moneyStoreList")
	public String moneyStoreList(HttpServletRequest request,
			HttpServletResponse response) {
		return "discover/money_store_list";
	}

	@RequestMapping(value = "discover/moneyStoreAjaxPage")
	@ResponseBody
	public PageInfo<MoneyStore> moneyStoreAjaxPage(HttpServletRequest request,
			HttpServletResponse response, MoneyStore info, Integer page,
			Integer rows) {
		PageInfo<MoneyStore> pageInfo = new PageInfo<MoneyStore>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "discover/moneyStoreAjaxAll")
	@ResponseBody
	public List<MoneyStore> moneyStoreAjaxAll(HttpServletRequest request,
			HttpServletResponse response, MoneyStore info, Integer page,
			Integer rows) {
		List<MoneyStore> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "discover/moneyStoreAjaxSave")
	@ResponseBody
	public Map<String,Object> moneyStoreAjaxSave(HttpServletRequest request,
			HttpServletResponse response, MoneyStore info) {
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

	@RequestMapping(value = "discover/moneyStoreAjaxDelete")
	@ResponseBody
	public Map<String,Object> moneyStoreAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, MoneyStore info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
