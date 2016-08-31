package com.dekequan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dekequan.base.ResponseBase;
import com.dekequan.library.Json;
import com.dekequan.library.UserUtil;
import com.dekequan.orm.User;
import com.dekequan.service.UserService;

/**
 * @author qzr
 *
 */
@Controller
@RequestMapping(value = "/v1/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 注册接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
	@ResponseBody
	public String register(String request) {
		HashMap<String, Object> reqMap = (HashMap<String, Object>) Json.fromJson(request, HashMap.class);
		String userName = reqMap.get("userName").toString();
		String password = reqMap.get("password").toString();
		String code = reqMap.get("code").toString();
		// 校验验证码
		if (!"success".equals(UserUtil.checkCode(code))) {
			return Json.toJson(userService.constructCheckCodeError());
		}
		User user = userService.register(userName, password);
		
		return Json.toJson(userService.constructResultRegister(user));
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam(value = "request") String request) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^request: 登录" + request);
		Map<String, Object> requestJson = (Map<String, Object>) Json.fromJson(request, Map.class);
		String userName = requestJson.get("userName") == null ? null : (String) requestJson.get("userName");
		String password = requestJson.get("password") == null ? null : (String) requestJson.get("password");
		User partUser = userService.login(userName, password);
		ResponseBase<Map<String, Object>> partResponseBase = userService.constructResultLogin(partUser);
		return Json.toJson(partResponseBase);
	}

}
