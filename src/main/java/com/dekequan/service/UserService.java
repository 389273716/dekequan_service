package com.dekequan.service;

import java.util.Map;

import com.dekequan.base.ResponseBase;
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

	/**
	 * 用户id
	 * 
	 * @param id
	 * @return
	 */
	public abstract User querySingleUser(Integer id);

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 */
	public abstract boolean save(User user);

	/**
	 * 构建
	 * 
	 * @param user
	 * @return
	 */
	public abstract ResponseBase<Map<String, Object>> constructResultUserCenter(User user);
	
	/**
	 * 用户登录
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public abstract User login(String userName, String password);
	
	/**
	 * 构建登录
	 * @param user
	 * @return
	 */
	public abstract ResponseBase<Map<String, Object>> constructResultLogin(User user);

}
