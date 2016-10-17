package com.dekequan.library.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密小工具
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午11:36:44
 * @version 1.0
 */
public class MD5Helper {

	/**
	 * 可以把一段文字转换为MD
	 * Can convert a file to MD5
	 * @param text
	 * @return md5
	 */
	public static String encode(String text){
		try {
		MessageDigest digest = MessageDigest.getInstance("md5");
		byte[] buffer = digest.digest(text.getBytes());
		// byte -128 ---- 127
		StringBuffer sb = new StringBuffer();
		for (byte b : buffer) {
			int a = b & 0xff;
			// Log.d(TAG, "" + a);
			String hex = Integer.toHexString(a);

			if (hex.length() == 1) {
				hex = 0 + hex;
			}
			sb.append(hex);
		}
		return sb.toString();
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return null;
	}

	/***
	 * 任意文件转换成Md5
	 * Can convert a text to MD5
	 * @param inputStream
	 * @return md5
	 */

	public static String encode(InputStream in) {
		try {
			MessageDigest digester = MessageDigest.getInstance("MD5");
			byte[] bytes = new byte[8192];
			int byteCount;
			while ((byteCount = in.read(bytes)) > 0) {
				digester.update(bytes, 0, byteCount);
			}
			byte[] digest = digester.digest();

			// byte -128 ---- 127
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				int a = b & 0xff;
				// Log.d(TAG, "" + a);

				String hex = Integer.toHexString(a);

				if (hex.length() == 1) {
					hex = 0 + hex;
				}

				sb.append(hex);
			}

			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
		}
		return null;
	}


}
