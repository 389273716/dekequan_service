package com.dekequan.dao;

import com.dekequan.orm.User;

/**
 * 
 * <p>
 * 用户数据层接口
 * </p>
 * 
 * @author TTM
 * @date 2016年8月28日 上午12:37:54
 * @version 1.0
 */
public interface UserDao {

	/**
	 * id 查询数据
	 * @param id
	 * @return
	 */
	public abstract User findUserById(Integer id);
	
	/**
	 * 保存用户数据
	 * @param user
	 */
	public abstract void save(User user);
	
}
