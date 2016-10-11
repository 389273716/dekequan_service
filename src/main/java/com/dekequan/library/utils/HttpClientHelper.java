package com.dekequan.library.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * <p>
 * 介绍:请求基类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月10日 下午9:30:33
 * @version 1.0
 */
public class HttpClientHelper {

	private static final String CHARSET_UTF8 = "UTF-8";

	private static final String CHARSET_GBK = "GBK";

	private static CloseableHttpClient httpClient;

	private static HttpClientHelper instance = new HttpClientHelper();

	private HttpClientHelper() {
		httpClient = getCloseableHttpClient();
	}

	public static HttpClientHelper getHttpClientHelper() {
		return instance;
	}

	/**
	 * 获取httpclien，关于httpclient的设置可以在这里进行
	 * 
	 * @return
	 */
	private CloseableHttpClient getCloseableHttpClient() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		return httpclient;
	}

	/**
	 * 将传入的键/值对参数转换为NameValuePair参数集
	 *
	 * @param paramsMap
	 *            参数集, 键/值对
	 * @return NameValuePair参数集
	 */
	private List<NameValuePair> getParamsList(Map<String, String> paramsMap) {
		if (paramsMap == null || paramsMap.size() == 0) {
			return new ArrayList<NameValuePair>();
		}

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> map : paramsMap.entrySet()) {
			params.add(new BasicNameValuePair(map.getKey(), map.getValue()));
		}
		return params;
	}

	/**
	 * get方法
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public String get(String url) throws IOException {
		return get(url, null);
	}

	/**
	 * get方法，参数需自己构建到url中
	 * 
	 * @param url
	 *            地址
	 * @param charset
	 *            默认utf8，可为空
	 * @return
	 * @throws IOException
	 */
	public String get(String url, String charset) throws IOException {
		if (url == null || url.isEmpty()) {
			return null;
		}

		charset = (charset == null ? CHARSET_UTF8 : charset);
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = null;
		String res = null;
		try {
			response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();

			System.out.println("ttm | ~~~~~~~~~~~~~~~~~~~~~~~request:" + url);
			res = EntityUtils.toString(entity, charset);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return res;
	}

	/**
	 * post方法
	 * 
	 * @param url
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public String post(String url, Map<String, String> map) throws IOException {
		return post(url, map, CHARSET_UTF8);
	}

	/**
	 * post方法
	 * 
	 * @param url
	 *            地址
	 * @param paramsMap
	 * @param charset
	 *            默认utf8，可为空
	 * @return
	 * @throws IOException
	 */
	public String post(String url, Map<String, String> paramsMap, String charset) throws IOException {
		if (url == null || url.isEmpty()) {
			return null;
		}

		List<NameValuePair> params = getParamsList(paramsMap);
		UrlEncodedFormEntity formEntity = null;
		HttpPost post = null;
		CloseableHttpResponse response = null;
		String res = null;
		try {
			charset = (charset == null ? CHARSET_UTF8 : charset);
			formEntity = new UrlEncodedFormEntity(params, charset);
			post = new HttpPost(url);
			post.setHeader("Content-Type", "application/x-www-form-urlencoded");
			post.setHeader("Accept", "application/json;charset=utf-8");
			
			System.out.println("ttm | ~~~~~~~~~~~~~~~~~~~~~~~request:" + url);
			System.out.println("ttm | ~~~~~~~~~~~~~~~~~~~~~~~requestJson:" + Json.toJson(paramsMap));
			post.setEntity(formEntity);
			response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				res = EntityUtils.toString(entity);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return res;
	}

}
