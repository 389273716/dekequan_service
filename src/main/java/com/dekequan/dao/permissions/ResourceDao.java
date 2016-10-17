package com.dekequan.dao.permissions;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dekequan.library.dao.AbstractDao;
import com.dekequan.orm.permissions.Resource;

/**
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午9:52:15
 * @version 1.0
 */
public interface ResourceDao extends AbstractDao<Resource> {

	/**
	 * 对应模块下 当前登录用户的功能
	 * @param moduleFlags
	 * @param userId
	 * @return
	 */
	public abstract List<Resource> findResourceListByModuleFlag(@Param("moduleFlags") List<String> moduleFlags, @Param("userId") Integer userId);
	
	/**
	 * 查询所有功能
	 * @return
	 */
	public abstract List<Resource> findResourceList();
	
}
