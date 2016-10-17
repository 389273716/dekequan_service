package com.dekequan.dao.permissions;

import java.util.List;

import com.dekequan.library.dao.AbstractDao;
import com.dekequan.orm.permissions.Module;

/**
 * 
 * @author 唐太明
 * @date 2016年10月16日 下午5:41:47
 * @version 1.0
 */
public interface ModuleDao extends AbstractDao<Module> {

	/**
	 * 查询当前用户 模块权限
	 * @param userId
	 * @return
	 */
	public abstract List<Module> findModuleListByUserId(Integer userId);
	
	/**
	 * 查询所有模块
	 * @return
	 */
	public abstract List<Module> findModuleList();
	
}
