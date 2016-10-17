package com.dekequan.service.permissions;

import com.dekequan.orm.permissions.RoleResource;

/**
 * 
 * @author 唐太明
 * @date 2016年10月18日 上午12:15:23
 * @version 1.0
 */
public interface RoleResourceService {

	/**
	 * 保存角色 功能关系
	 * @param roleResource
	 * @return
	 */
	public abstract Integer saveRoleResource(RoleResource roleResource);
	
}
