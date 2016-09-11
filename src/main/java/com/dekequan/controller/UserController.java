package com.dekequan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dekequan.base.ResponseBase;
import com.dekequan.base.ResponseRe;
import com.dekequan.library.Json;
import com.dekequan.library.UserUtil;
import com.dekequan.orm.User;
import com.dekequan.service.UserService;

import sun.awt.ModalityEvent;

/**
 * @author qzr
 *
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping(value = "/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private ModelAndView view = new ModelAndView();;

	/**
	 * 注册接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam(value="request") String request) {
		HashMap<String, Object> reqMap = (HashMap<String, Object>) Json.fromJson(request, HashMap.class);
		String userName =null ==  reqMap.get("userName") ? null : (String) reqMap.get("userName");
		String password = null == reqMap.get("password") ? null : (String) reqMap.get("password");
		String code = null == reqMap.get("code") ? null :reqMap.get("code").toString();
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User user, @RequestHeader HttpHeaders headers) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^request: 登录" + Json.toJson(headers));
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^request: 登录" + Json.toJson(user));
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		try {
			User partUser = userService.login(user.getUserName(), user.getPassword());
			partResponseBase = userService.constructResultLogin(partUser);
		} catch (Exception e) {
			return Json.toJson(userService.constructCheckCodeError());
		}
		return Json.toJson(partResponseBase);
	}
	
	/**
	 * 后台登录页面
	 * @return
	 */
	@RequestMapping(value = "/backstage/login", method = RequestMethod.GET)
	public ModelAndView backstageLogin() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^后台登录");
		view.setViewName("/login");
		return view;
	}
	
	/**
	 * 后台登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/backstage/login", method = RequestMethod.POST)
	@ResponseBody
	public String backstageLogin(@RequestParam(value = "account", required = true) String account, @RequestParam(value = "password", required = true) String password) {
		System.out.println("^^^^^^^^^^^^^^^^^^^后台登录");
		System.out.println("account:" + account);
		System.out.println("password:" + password);
		ResponseBase<String> reponse = new ResponseBase<String>();
		reponse.setRe(ResponseRe.RE_SUCCESS);
		reponse.setMsg("SUCCESSS");
		reponse.setData("/v1/user/welcome");
		return Json.toJson(reponse);
	}
	
	/**
	 * 后台欢迎页面
	 * 注意:注意进入这个页面需要登录，零时不加登录验证
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView backstageWelcome() {
		System.out.println("^^^^^^^^^^^^^^^^^^^后台欢迎页面");
		view.setViewName("container/user/container-user");
		return view;
	}
	
}
