package com.dekequan.service;

import com.dekequan.orm.User;

/**
 * 
 * <p>
 * 用户业务层接口
 * </p>
 * 
 * @author TTM
 * @date 2016年8月28日 上午1:38:33
 * @version 1.0
 */
public interface UserService {

	public abstract User query();
	
	public abstract boolean save(User user);
	
}
