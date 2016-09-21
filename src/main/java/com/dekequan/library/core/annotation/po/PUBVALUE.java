package com.dekequan.library.core.annotation.po;

/**
 * 定义公共值得约束类
 * @Author 佘俊
 * @Date 2016/9/18 22:41
 * @email shejun1123@163.com
 */
public class PUBVALUE {

	/**
	 * FieldName注解中默认的name值
	 */
	public static final String FIELD_NAME_DEFAUL_VALUE = "_nullName_this_is_default";
	
	/**
	 * ID注解中type值得类型，该字段表示整数型自增Id
	 */
	public static final int TABLE_ID_TYPE_INTEGER = 0;
	
	/**
	 * ID注解中type值得类型，该字段表示String型UUID
	 */
	public static final int TABLE_ID_TYPE_UUID = 1;
	
}
