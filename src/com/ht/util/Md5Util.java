package com.ht.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Util {
	
	//根据盐值   密码 和加密次数加密   密码
	public String getmd5password(String username,String password,Integer count) {
		
		//shiro提供的md5加密方法
		SimpleHash simpleHash = new SimpleHash("MD5", password, username, 1);
		return simpleHash.toString();
	}
	
	
}
