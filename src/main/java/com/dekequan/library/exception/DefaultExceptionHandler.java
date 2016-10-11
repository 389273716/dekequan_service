package com.dekequan.library.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.dekequan.library.response.ResponseRe;

/**
 * 
 * <p>
 * 介绍:全局异常处理基类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月11日 下午10:41:03
 * @version 1.0
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("ttm | ---> " + ex.getMessage());
		ex.printStackTrace();
		
		ModelAndView partView = new ModelAndView();
		MappingJackson2JsonView partJsonView = new MappingJackson2JsonView();
		String partMsg = "请求异常...";
		Map<String, Object> partError = new HashMap<String, Object>();
		partError.put("re", ResponseRe.RE_FAILURE);
		partError.put("msg", partMsg);
		partError.put("data", new HashMap<String, Object>());
		partView.addAllObjects(partError);
		partView.setView(partJsonView);
		return partView;
	}

}
