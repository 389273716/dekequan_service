package com.dekequan.service.user.impl;

import org.springframework.stereotype.Service;

import com.dekequan.orm.user.AdminUser;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.user.AdminUserService;

@Service("adminUserServiceImpl")
public class AdminUserServiceImpl extends AbstractService<AdminUser> implements AdminUserService {

	public Integer saveAdminUser(AdminUser adminUser) {
		return super.save(adminUser);
	}

}
