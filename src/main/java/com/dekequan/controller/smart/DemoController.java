package com.dekequan.controller.smart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dekequan.library.exception.DefaultExceptionHandler;
import com.dekequan.library.response.ResponseBase;
import com.dekequan.library.utils.Json;
import com.dekequan.library.utils.Print;
import com.dekequan.orm.smart.Demo;
import com.dekequan.service.smart.DemoService;

/**
 * 
 * @author 唐太明
 * @date 2016年10月10日 上午1:26:50
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/v1/demo")
public class DemoController {

	@Autowired
	private DemoService demoServiceImpl;

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String findById(@PathVariable(value = "id") Integer id) throws Exception {
		ResponseBase<Map<String, Object>> partResponseBase = new ResponseBase<Map<String, Object>>();
		System.out.println("ttm | 获取id ---> " + id);
		Demo partDemo = demoServiceImpl.findDemoById(id);
		if (partDemo == null) {
			throw new Exception("异常...");
		}
		Print.print(partDemo);
		return Json.toJson(partResponseBase);
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
	public String save() {
		ResponseBase<Map<String, Object>> partResponseBase = new ResponseBase<Map<String, Object>>();
		for (int x = 0; x < 30; x++) {
			Demo partDemo = new Demo();
			partDemo.setName("舍俊 - " + System.currentTimeMillis());
			partDemo.setAge(22 + (++x));
			System.out.println("ttm | save ---> " + Json.toJson(partDemo));
			Integer partId = demoServiceImpl.saveDemo(partDemo);
			System.out.println("ttm | " + partId);
		}
		return Json.toJson(partResponseBase);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public String update() {
		ResponseBase<Map<String, Object>> partResponseBase = new ResponseBase<Map<String, Object>>();
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
		ResponseBase<Map<String, Object>> partResponseBase = new ResponseBase<Map<String, Object>>();
		System.out.println("ttm | 传入数据 ---> " + id);
		Demo partDemo = demoServiceImpl.findDemoById(id);
		System.out.println("ttm | 查询数据 ---> " + Json.toJson(partDemo));
		if (partDemo != null) {
			int partId = demoServiceImpl.deleteDemoById(partDemo.getDemoId());
			System.out.println("ttm | 删除数据 ---> " + partId);
		} else {
			System.out.println("ttm | 查询数据为空...");
		}
		return Json.toJson(partResponseBase);
	}
	
	@RequestMapping(value = "/select/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	public String selectPage(@PathVariable(value = "pageSize") Integer pageSize) {
		ResponseBase<Map<String, Object>> partResponseBase = new ResponseBase<Map<String, Object>>();
		int rows = 3;
		System.out.println("ttm | 当前页:" + pageSize + " 每页显示数量:" + rows);
		List<Demo> partDemoList = demoServiceImpl.findDemo(pageSize, rows);
		if (!CollectionUtils.isEmpty(partDemoList)) {
			System.out.println("ttm | 查询数据数量:" + partDemoList.size());
			System.out.println("ttm | 显示数据:" + Json.toJson(partDemoList));
		} else {
			System.out.println("ttm | 查询数据为空...");
		}
		return Json.toJson(partResponseBase);
	}

}
