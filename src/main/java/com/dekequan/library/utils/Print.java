package com.dekequan.library.utils;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * <p>打印工具</p>
 * @author TTM
 * @date 2016年8月29日 上午12:00:33
 * @version 1.0
 */
public class Print {

	public static void print(Object object) {
		System.out.println("++++++++++++++++++++++++++++++++");
		try {
			Gson gson = (new GsonBuilder()).serializeSpecialFloatingPointValues().serializeNulls().setPrettyPrinting()
					.create();
			System.out.println(gson.toJson(object));
		} catch (Exception e) {
			System.out.println(ToStringBuilder.reflectionToString(object, ToStringStyle.MULTI_LINE_STYLE));
		}
		System.out.println("++++++++++++++++++++++++++++++++");
	}
	
}
