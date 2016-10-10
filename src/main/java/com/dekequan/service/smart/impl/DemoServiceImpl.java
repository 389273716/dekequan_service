package com.dekequan.service.smart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.dao.smart.DemoDao;
import com.dekequan.orm.smart.Demo;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.smart.DemoService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @author 唐太明
 * @date 2016年10月10日 上午1:26:14
 * @version 1.0
 */
@Service("demoServiceImpl")
public class DemoServiceImpl extends AbstractService<Demo> implements DemoService {

	@Autowired
	private DemoDao demoDaoImpl;
	
	public Demo findDemoById(Integer demoId) {
		return demoDaoImpl.findDemoDaoById(demoId);
	}

	public int saveDemo(Demo demo) {
		return save(demo);
	}

	public int updateDemo(Demo demo) {
		return update(demo);
	}

	public int deleteDemoById(Integer demoId) {
		return deleteById(demoId);
	}

	public List<Demo> findDemo(int page, int rows) {
		Example partExample = new Example(Demo.class);
		// 分页查询
		PageHelper.startPage(page, rows);
		return findByQuery(partExample);
	}

}
