package com.yjc.www.util;

public class ValidateUtil {
	
	//验证用户名
	public static boolean isInvalidUserName(String userName){
		if(userName == null || userName.equals("")){
			return true;
		}
		return false;
	}
}
