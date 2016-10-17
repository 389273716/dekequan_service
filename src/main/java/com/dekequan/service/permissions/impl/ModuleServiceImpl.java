package com.dekequan.service.permissions.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.dao.permissions.ModuleDao;
import com.dekequan.orm.permissions.Module;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.permissions.ModuleService;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @author 唐太明
 * @date 2016年10月16日 下午6:05:27
 * @version 1.0
 */
@Service("moduleServiceImpl")
public class ModuleServiceImpl extends AbstractService<Module> implements ModuleService {

	@Autowired
	private ModuleDao moduleDaoImpl;
	
	public List<Module> findModuleList() {
		Example partExample = new Example(Module.class);
		return super.findByQuery(partExample);
	}

	public List<Module> findModuleListByUser(Integer userId) {
		return moduleDaoImpl.findModuleListByUserId(userId);
	}

	public Integer saveModule(Module module) {
		return super.save(module);
	}

	public Integer updateModule(Module module) {
		return super.update(module);
	}

	public Integer deleteModuleById(Integer moduleId) {
		return super.deleteById(moduleId);
	}

}
