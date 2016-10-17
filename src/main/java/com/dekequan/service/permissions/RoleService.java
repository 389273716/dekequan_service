package com.dekequan.service.permissions;

import com.dekequan.orm.permissions.Role;

/**
 * 
 * @author 唐太明
 * @date 2016年10月18日 上午12:56:00
 * @version 1.0
 */
public interface RoleService {

	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	public abstract Integer saveRole(Role role);
	
}
