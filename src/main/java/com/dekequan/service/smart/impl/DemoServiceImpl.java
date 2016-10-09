package com.dekequan.service.smart.impl;

import org.springframework.stereotype.Service;

import com.dekequan.orm.smart.Demo;
import com.dekequan.service.base.AbstractService;
import com.dekequan.service.smart.DemoService;

@Service("demoServiceImpl")
public class DemoServiceImpl extends AbstractService<Demo> implements DemoService {

	
	public Demo findDemoById(Integer demoId) {
		return findById(demoId);
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

}
