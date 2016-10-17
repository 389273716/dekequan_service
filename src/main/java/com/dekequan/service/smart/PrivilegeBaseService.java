package com.dekequan.service.smart;

public interface PrivilegeBaseService {

	/**
	 * 获取菜单/模块
	 * @param userId
	 * @param visitedModule
	 * @param visitedResource
	 * @return
	 */
	public String getModuleTree(Integer userId,String visitedModule,String visitedResource);
	
}
