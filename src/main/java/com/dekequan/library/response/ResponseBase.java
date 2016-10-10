package com.dekequan.library.response;

/**
 * <p>返回结果基类</p>
 * @author TTM
 * @date 2016年8月25日 下午9:51:39
 * @version 1.0
 */
public class ResponseBase<T> {

	private Integer re;			//返回结果吗
	
	private String msg;			//返回结果
	
	private T data;				//返回数据

	public Integer getRe() {
		return re;
	}

	public void setRe(Integer re) {
		this.re = re;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
