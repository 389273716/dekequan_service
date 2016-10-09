package com.dekequan.dao.user.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.dekequan.dao.user.UserDao;
import com.dekequan.orm.user.SimpleUser;
import com.dekequan.orm.user.User;

/**
 * @Author 佘俊
 * @Date 2016/9/21 23:47
 * @email shejun1123@163.com
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User selectOne(User record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> select(User record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCount(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectByExample(Object example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCountByExample(Object example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(Object example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(User record, Object example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExampleSelective(User record, Object example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectByRowBounds(User record, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByLogin(Map<String, String> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserExpireTime(Map<String, String> query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(Map<String, Object> query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SimpleUser fetchSimpleUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleUser fetchSimpleUserByToken(String dkToken) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
