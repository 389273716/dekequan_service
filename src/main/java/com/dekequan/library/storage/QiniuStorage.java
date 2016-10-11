package com.dekequan.library.storage;

import java.awt.geom.QuadCurve2D;

import javax.faces.event.PreValidateEvent;

import org.apache.commons.lang.StringUtils;

import com.qiniu.util.Auth;

/**
 * 
 * <p>
 * 介绍:七牛存储
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月10日 下午11:51:31
 * @version 1.0
 */
public class QiniuStorage {

	private static final String ACCESSKEY = "U1U7-fKO6IAjrxjUtzGWaUKkGGJUEBg7aiB74ZMO";

	private static final String SECRETKEYSPEC = "IptEDH7yRP-FM6ERdZ_EpFPeYEPwFaTzxOI6-yNs";
	
	private static final String BUCKETNAME = "dual";
	
	private static QiniuStorage initSingle = new QiniuStorage();
	
	private QiniuStorage() {}

	public static QiniuStorage getQiniuStorage() {
		return initSingle;
	}
	
	/**
	 * 获取上传Key
	 * @param accesskey
	 * @param secretkeyspec
	 * @return
	 */
	public String fetchUpdateKey(String accesskey, String secretkeyspec) {
		Auth partAuth = null;
		String token = "";
		if (StringUtils.isEmpty(accesskey) 
				&& StringUtils.isEmpty(secretkeyspec)) {
			partAuth = Auth.create(ACCESSKEY, SECRETKEYSPEC);
		} else {
			partAuth = Auth.create(accesskey, secretkeyspec);
		}
		token = partAuth.uploadToken(BUCKETNAME);
		
		return token;
	}
	
	/**
	 * 获取上传默认Key
	 * @return
	 */
	public String fetchDefaulKey() {
		return fetchUpdateKey(null, null);
	}
	
}
