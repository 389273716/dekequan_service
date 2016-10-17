package com.dekequan.service.permissions;

import com.dekequan.orm.permissions.RoleModule;

/**
 * 
 * @author 唐太明
 * @date 2016年10月17日 上午1:32:45
 * @version 1.0
 */
public interface RoleModuleService {

	/**
	 * 保存用户 - 模块 数据
	 * @param roleModule
	 * @return
	 */
	public abstract Integer saveRoleModule(RoleModule roleModule);
	
}
