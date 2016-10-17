package com.dekequan.service.permissions;

import com.dekequan.orm.permissions.UserRole;

/**
 * 
 * <p>
 * 介绍 用户 - 角色 业务层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月17日 上午12:56:09
 * @version 1.0
 */
public interface UserRoleService {

	/**
	 * 保存
	 * @param userRole
	 * @return
	 */
	public abstract Integer saveUserRole(UserRole userRole);
	
}
