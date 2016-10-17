package com.dekequan.service.permissions.impl;

import org.springframework.stereotype.Service;

import com.dekequan.orm.permissions.UserRole;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.permissions.UserRoleService;

/**
 * 
 * <p>
 * 介绍 业务实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月17日 上午12:58:42
 * @version 1.0
 */
@Service("userRoleServiceImpl")
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

	public Integer saveUserRole(UserRole userRole) {
		return super.save(userRole);
	}

}
