package com.dekequan.controller;

import java.util.HashMap;

import com.dekequan.base.utils.LoginUtil;
import com.google.gson.Gson;
import com.sun.javafx.collections.MappingChange.Map;

/**
 * @author qzr
 *
 */
public class UserController {
	private Gson gson = new Gson();
	/**
	 * 注册接口
	 * @param request
	 * @return
	 */
	public String login (String request){
		HashMap<String,Object> reqMap = gson.fromJson(request, HashMap.class);
		String userName = reqMap.get("userName").toString();
		String passWord = reqMap.get("passWord").toString();
		String code = reqMap.get("code").toString();
		//校验验证码
		if(!"success".equals(LoginUtil.checkCode(code))){
			
		}
		
		return null;
	}
	
}
