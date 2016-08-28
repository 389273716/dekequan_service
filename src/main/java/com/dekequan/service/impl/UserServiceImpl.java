package com.dekequan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.dao.UserDao;
import com.dekequan.orm.User;
import com.dekequan.service.UserService;

/**
 * <p>
 * </p>
 * 
 * @author TTM
 * @date 2016年8月28日 上午2:01:07
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User query() {
		return null;
	}

	public boolean save(User user) {
		userDao.save(user);
		return true;
	}

}
