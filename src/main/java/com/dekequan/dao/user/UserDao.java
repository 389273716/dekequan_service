package com.dekequan.dao.user;

import com.dekequan.library.dao.AbstractDao;
import com.dekequan.orm.user.SimpleUser;
import com.dekequan.orm.user.User;

import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

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
public interface UserDao extends AbstractDao<User> {

	
	/**
	 * id 查询数据
	 * @param userId
	 * @return
	 */
	public abstract User findUserById(Integer userId);
	
	/**
	 * 保存用户数据
	 * @param user
	 */
	public abstract void saveUser(User user);
	
	/**
	 * 账号密码查询用户数据
	 * @param query
	 * @return
	 */
	public abstract User findUserByLogin(Map<String, String> query);
	
	/**
	 * 修改失效时间
	 * @param query
	 */
	public abstract void updateUserExpireTime(Map<String, String> query);
	
	/**
	 * 修改个人资料
	 * @param query
	 */
	public abstract void updateUser(Map<String, Object> query);

	public abstract SimpleUser fetchSimpleUserById(Integer userId);
	
	public abstract SimpleUser fetchSimpleUserByToken(String dkToken);
	
}
