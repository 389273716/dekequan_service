package com.dekequan.library.core.annotation.po;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识某个字段不录入数据库中
 * 标识该注解的字段将没有增删改查的功能。
 * @Author 佘俊
 * @Date 2016/9/18 22:41
 * @email shejun1123@163.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TempField {

	 
}
