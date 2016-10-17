package com.dekequan.service.permissions.impl;

import org.springframework.stereotype.Service;

import com.dekequan.orm.permissions.RoleModule;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.permissions.RoleModuleService;

/**
 * 
 * @author 唐太明
 * @date 2016年10月18日 上午1:00:39
 * @version 1.0
 */
@Service("roleModuleServiceImpl")
public class RoleModuleServiceImpl extends AbstractService<RoleModule> implements RoleModuleService {

	public Integer saveRoleModule(RoleModule roleModule) {
		return super.save(roleModule);
	}

}
