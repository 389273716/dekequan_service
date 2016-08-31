package com.dekequan.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.base.ResponseBase;
import com.dekequan.base.ResponseRe;
import com.dekequan.dao.UserDao;
import com.dekequan.orm.User;
import com.dekequan.service.UserService;

/**
 * <p>
 * </p>
 * @author TTM
 * @date 2016年8月28日 上午2:01:07
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User querySingleUser(Integer id) {
		return userDao.findUserById(id);
	}
	
	public boolean save(User user) {
		userDao.saveUser(user);
		return true;
	}
	
	/**
	 * 个人接口
	 * @return
	 */
	public ResponseBase<Map<String, Object>> constructResultUserCenter(User user) {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();

		if (user == null) {
			return responseToError();
		}
		
		Integer partRe = ResponseRe.RE_SUCCESS;
		String partMsg = "SUCCESS";
		Map<String, Object> partData = new LinkedHashMap<String, Object>();
		partData.put("userId", user.getUserId());
		partData.put("userName", user.getUserName());
		partData.put("nickName", user.getNickName());
		partData.put("rank", user.getRank());
		partData.put("level", user.getLevel());
		partData.put("img", user.getImg());
		
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(partData);
		return partResponse;
	}

	public User login(String userName, String password) {
		Map<String, String> partQuery = new HashMap<String, String>();
		partQuery.put("userName", userName);
		partQuery.put("password", password);
		User partUser = userDao.findUserByLogin(partQuery);
		return partUser;
	}

	public ResponseBase<Map<String, Object>> constructResultLogin(User user) {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();

		if (user == null) {
			return responseToError();
		}
		
		Integer partRe = ResponseRe.RE_SUCCESS;
		String partMsg = "SUCCESS";
		Map<String, Object> partData = new LinkedHashMap<String, Object>();
		partData.put("token", user.getDkToken());
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(partData);
		return partResponse;
	}

	public ResponseBase<Map<String, Object>> responseToError() {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();

		Integer partRe = ResponseRe.RE_NO_DATA;
		String partMsg = "NO_DATA";
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(new HashMap<String, Object>());
		return partResponse;
	}

}
