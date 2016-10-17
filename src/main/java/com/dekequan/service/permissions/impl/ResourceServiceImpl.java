package com.dekequan.service.permissions.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.dao.permissions.ResourceDao;
import com.dekequan.orm.permissions.Resource;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.permissions.ResourceService;

/**
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午10:15:33
 * @version 1.0
 */
@Service("resourceServiceImpl")
public class ResourceServiceImpl extends AbstractService<Resource> implements ResourceService {

	@Autowired
	private ResourceDao resourceDaoImpl;
	
	public List<Resource> findResourceListByModuleFlag(List<String> moduleFlags, Integer userId) {
		return resourceDaoImpl.findResourceListByModuleFlag(moduleFlags, userId);
	}

	public Integer saveResouce(Resource resource) {
		return super.save(resource);
	}

	
}
