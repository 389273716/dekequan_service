/**
 * 
 */
package com.dekequan.library.message;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dekequan.library.utils.HttpClientHelper;

/**
 * @author qzr
 *
 */
public class MessageDemo {
	private static final String YUN_PIAN_API_KEY  = "50b14e5d476041cc84b574e3377e4ac7";
	private static final String YUN_PIAN_URL = "https://sms.yunpian.com/v2/sms/single_send.json";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String mobile = "15211636823";
		String text = "【的客圈】亲爱的用户，您的验证码是123456。欢迎使用！";
		String res = postMessage(text, mobile);
		System.out.println(res);
	}
	/**
	 * 
	 * @param text
	 * @param mobile
	 * @return
	 */
	private static String postMessage(String text, String mobile){
		HttpClientHelper httpClientHelper = HttpClientHelper.getHttpClientHelper();
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", YUN_PIAN_API_KEY);
		params.put("mobile", mobile);
		params.put("text", text);
		String res = "";
		try {
			res = httpClientHelper.post(YUN_PIAN_URL, params);
		} catch (IOException e) {
			e.printStackTrace();
			res = e.getMessage();
		}
		return res;
	}
}
