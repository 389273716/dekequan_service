package com.dekequan.service.permissions.impl;

import org.springframework.stereotype.Service;

import com.dekequan.orm.permissions.RoleResource;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.permissions.RoleResourceService;

/**
 * 
 * @author 唐太明
 * @date 2016年10月18日 上午12:17:19
 * @version 1.0
 */
@Service("roleResourceServiceImpl")
public class RoleResourceServiceImpl extends AbstractService<RoleResource> implements RoleResourceService {

	public Integer saveRoleResource(RoleResource roleResource) {
		return super.save(roleResource);
	}

}
