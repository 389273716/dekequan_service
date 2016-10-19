package com.dekequan.library.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring 注册类
 * @author 唐太明
 * @date 2016年10月18日 上午5:27:05
 * @version 1.0
 */
public class SpringContextHelper implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext ac) {
		applicationContext = ac;
	}

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> requiredType) {
		checkApplicationContext();
		return applicationContext.getBean(requiredType);
	}

	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
	}

}
