package com.dekequan.library.storage;

public class Temp {

	public static void main(String[] args) {
		QiniuStorage partQiniu = QiniuStorage.getQiniuStorage();
		String token = partQiniu.fetchDefaulKey();
		System.out.println("ttm | token ---> " + token);
	}
	
}
