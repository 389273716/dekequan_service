package com.dekequan.base;
/**
 * 
 * <p>状态码</p>
 * @author TTM
 * @date 2016年8月25日 下午9:57:30
 * @version 1.0
 */
public class ResponseRe {

	public static final Integer RE_SUCCESS = 1;					//成功
	
	public static final Integer RE_FAILURE = -1;				//失败
	
	public static final Integer RE_NO_DATA = 0;					//没有数据
	
	public static final Integer RE_LOGIN = -22;					//重新登录
	
	public static final Integer RE_TOKEN_ERROR = -99;			//获取token失败
	
}
