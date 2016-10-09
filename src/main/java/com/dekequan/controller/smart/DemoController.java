package com.dekequan.controller.smart;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dekequan.base.ResponseBase;
import com.dekequan.library.utils.Json;
import com.dekequan.library.utils.Print;
import com.dekequan.orm.smart.Demo;
import com.dekequan.service.smart.DemoService;

@Controller
@RequestMapping(value = "/v1/demo")
public class DemoController {

	@Autowired
	private DemoService demoServiceImpl;
	
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	@ResponseBody
	public String findById() {
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		Demo partDemo = demoServiceImpl.findById(1);
		Print.print(partDemo);
		return Json.toJson(partResponseBase);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
	public String save() {
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		Demo partDemo = new Demo();
		partDemo.setName("舍俊");
		partDemo.setAge(22);
		Integer partId = demoServiceImpl.saveDemo(partDemo);
		System.out.println("ttm | " + partId);
		return Json.toJson(partResponseBase);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public String update() {
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		Demo partDemo = new Demo();
		partDemo = demoServiceImpl.findDemoById(1);
		Print.print(partDemo);
		partDemo.setName("修改舍俊");
		Print.print(partDemo);
		Integer partId = demoServiceImpl.updateDemo(partDemo);
		System.out.println("ttm | " + partId);
		return Json.toJson(partResponseBase);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable(value = "id") Integer id) {
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		System.out.println("ttm | 传入数据 ---> " + id);
		Demo partDemo = demoServiceImpl.findById(id);
		System.out.println("ttm | 查询数据 ---> " + Json.toJson(partDemo));
		if (partDemo != null) {
			int partId = demoServiceImpl.deleteDemoById(partDemo.getDemoId());
			System.out.println("ttm | 删除数据 ---> " + partId);
		} else {
			System.out.println("ttm | 查询数据为空...");
		}
		return Json.toJson(partResponseBase);
	}
	
}
