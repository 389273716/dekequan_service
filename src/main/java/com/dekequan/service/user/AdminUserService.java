package com.dekequan.service.user;

import com.dekequan.orm.user.AdminUser;

/**
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午11:28:18
 * @version 1.0
 */
public interface AdminUserService {

	/**
	 * 保存管理员
	 * @param adminUser
	 * @return
	 */
	public abstract Integer saveAdminUser(AdminUser adminUser);
	
}
