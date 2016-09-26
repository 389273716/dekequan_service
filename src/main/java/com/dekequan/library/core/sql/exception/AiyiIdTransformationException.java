package com.dekequan.library.core.sql.exception;

/**
 * 内部异常类：表示数据库中自增ID达到了Long类型，而实体类中ID为Integer类型时发生的类型转换异常
 * 解决方案：实体类中将int提升为long
 * @Author 佘俊
 * @Date 2016/9/18 22:45
 * @email shejun1123@163.com
 */

public class AiyiIdTransformationException extends Exception {

	public AiyiIdTransformationException(String message) {
		// TODO Auto-generated constructor stub
		 super(message);
	}

	private static final long serialVersionUID = 1L;

}
