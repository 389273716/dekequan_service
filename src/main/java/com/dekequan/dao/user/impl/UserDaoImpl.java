package com.dekequan.dao.user.impl;

import java.util.Map;

import com.dekequan.dao.user.UserDao;
import com.dekequan.library.dao.IBaseDaoImpl;
import com.dekequan.orm.user.SimpleUser;
import com.dekequan.orm.user.User;

/**
 * @Author 佘俊
 * @Date 2016/9/21 23:47
 * @email shejun1123@163.com
 */
public class UserDaoImpl extends IBaseDaoImpl<User, Integer> implements UserDao {
    @Override
    public User findUserById(Integer userId) {
        return get(userId);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findUserByLogin(Map<String, String> query) {
        return null;
    }

    @Override
    public void updateUserExpireTime(Map<String, String> query) {

    }

    @Override
    public void updateUser(Map<String, Object> query) {

    }

    @Override
    public SimpleUser fetchSimpleUserById(Integer userId) {
        return null;
    }

    @Override
    public SimpleUser fetchSimpleUserByToken(String dkToken) {
        return null;
    }

}
