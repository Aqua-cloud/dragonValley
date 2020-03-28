package com.yjc.www.util;

public class ValidateUtil {

    //验证账号密码是否为空
    public static boolean isInvalid(String password, String account) {
        if (account == null || account.equals("") || password == null || password.equals("")) {
            return true;
        }
        return false;
    }

}
