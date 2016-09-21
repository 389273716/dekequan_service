package com.dekequan.library.utils;

import com.dekequan.library.core.WherePrams;

import java.io.Serializable;

/**
 * 查询工具条件类
 * @Author 佘俊
 * @Date 2016/9/18 22:31
 * @email shejun1123@163.com
 */
public class QueryHelper {
    public static final String EQ = "=";
    public static final String NE = "<>";
    public static final String LIKE = "like";
    public static final String GT = ">";
    public static final String LT = "<";
    public static final String IN = "in";

    public static WherePrams where(String file, String where, Serializable value){
        return new WherePrams(file , where , value);
    }

    public static WherePrams createDefault(){
        return new WherePrams(null, null, null);
    }
}
