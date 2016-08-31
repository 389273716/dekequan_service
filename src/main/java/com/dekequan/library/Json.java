package com.dekequan.library;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * <p>Json 工具</p>
 * @author TTM
 * @date 2016年8月31日 下午9:36:51
 * @version 1.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Json {

	public static String toJson(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		String result = "";
		try {
			objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
			result = objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Object fromJson(String requestStr, Class clazz) {
		if (StringUtils.isEmpty(requestStr))
			return null;
		ObjectMapper objectMapper = new ObjectMapper();
		Object object = null;
		try {
			object = objectMapper.readValue(requestStr, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
}
