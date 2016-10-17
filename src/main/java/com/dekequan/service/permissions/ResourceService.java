package com.dekequan.service.permissions;

import java.util.List;

import com.dekequan.orm.permissions.Resource;

/**
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午9:58:43
 * @version 1.0
 */
public interface ResourceService {

	/**
	 * 当前用户 对应模块下的所有功能
	 * @param moduleFlags
	 * @param userId
	 * @return
	 */
	public abstract List<Resource> findResourceListByModuleFlag(List<String> moduleFlags, Integer userId);
	
	/**
	 * 保存功能
	 * @param resource
	 * @return
	 */
	public abstract Integer saveResouce(Resource resource);
	
}
