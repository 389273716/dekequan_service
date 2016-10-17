package com.dekequan.service.permissions.impl;

import org.springframework.stereotype.Service;

import com.dekequan.orm.permissions.Role;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.permissions.RoleService;

/**
 * 
 * @author 唐太明
 * @date 2016年10月18日 上午12:57:28
 * @version 1.0
 */
@Service("roleServiceImpl")
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

	public Integer saveRole(Role role) {
		return super.save(role);
	}

}
