package com.dekequan.library.core.annotation.po;
import java.lang.annotation.*;

/**
 * 定义PO类的键类型
 * @Author 佘俊
 * @Date 2016/9/18 22:41
 * @email shejun1123@163.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ID {

	/**
	 * 主键数据类型，默认整数型
	 * @return
	 */
	int type() default com.dekequan.library.core.annotation.po.PUBVALUE.TABLE_ID_TYPE_INTEGER;
	
}
