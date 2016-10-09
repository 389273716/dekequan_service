package com.dekequan.service.smart;

import java.util.List;

import com.dekequan.orm.smart.Demo;
import com.dekequan.service.base.BaseService;

public interface DemoService extends BaseService<Demo> {

	public Demo findDemoById(Integer demoId);
	
	public int saveDemo(Demo demo);
	
	public int updateDemo(Demo demo);
	
	public int deleteDemoById(Integer demoId);
	
	public List<Demo> findDemo(int page, int rows);
	
}
