package com.dekequan.service.permissions;

import java.util.List;

import com.dekequan.orm.permissions.Module;

/**
 * 
 * <p>
 * 介绍： 模块Service
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月16日 下午5:59:16
 * @version 1.0
 */
public interface ModuleService {

	/**
	 * 查询所有 模块
	 * @return
	 */
	public abstract List<Module> findModuleList();
	
	/**
	 * 查询当前用户 模块权限
	 * @param userId
	 * @return
	 */
	public abstract List<Module> findModuleListByUser(Integer userId);
	
	/**
	 * 保存模块
	 * @param module
	 * @return
	 */
	public abstract Integer saveModule(Module module);
	
	/**
	 * 修改模块信息
	 * @param module
	 * @return
	 */
	public abstract Integer updateModule(Module module);
	
	/**
	 * 模块id 删除模块
	 * @param moduleId
	 * @return
	 */
	public abstract Integer deleteModuleById(Integer moduleId);
	
}
