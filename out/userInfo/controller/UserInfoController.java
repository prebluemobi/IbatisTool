package com.bluemobi.www.security.discover.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.www.data.model.discover.UserInfo;
import com.bluemobi.www.page.PageInfo;
import com.bluemobi.www.security.base.controller.BaseController;
import com.bluemobi.www.security.discover.service.UserInfoService;
import com.bluemobi.www.utils.UUIDUtil;

/**
 * 
* @ClassName: UserInfoController 
* @Description: 发现控制层 
* @author lip 
* @date 2016-11-17 13:52:43 
* @Copyright：上海科匠信息科技有限公司 2015
 */
@Controller
public class UserInfoController extends BaseController {
	@Resource
	private UserInfoService service;

	@RequestMapping(value = "discover/userInfoList")
	public String userInfoList(HttpServletRequest request,
			HttpServletResponse response) {
		return "discover/user_info_list";
	}

	@RequestMapping(value = "discover/userInfoAjaxPage")
	@ResponseBody
	public PageInfo<UserInfo> userInfoAjaxPage(HttpServletRequest request,
			HttpServletResponse response, UserInfo info, Integer page,
			Integer rows) {
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "discover/userInfoAjaxAll")
	@ResponseBody
	public List<UserInfo> userInfoAjaxAll(HttpServletRequest request,
			HttpServletResponse response, UserInfo info, Integer page,
			Integer rows) {
		List<UserInfo> results= service.selectAll(info);
		return results; 
	}
	
	@RequestMapping(value = "discover/userInfoAjaxSave")
	@ResponseBody
	public Map<String,Object> userInfoAjaxSave(HttpServletRequest request,
			HttpServletResponse response, UserInfo info) {
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

	@RequestMapping(value = "discover/userInfoAjaxDelete")
	@ResponseBody
	public Map<String,Object> userInfoAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, UserInfo info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getJsonResult(result,"操作成功", "删除失败！");
	}
}
