package com.dekequan.library.core;

/**
 * POJO字段封装类
 * @Author 佘俊
 * @Date 2016/9/18 22:21
 * @email shejun1123@163.com
 */
public class Pram {

    private String file;

    private Object value;

    public Pram(){}
    public Pram(String file, Object value){
        this.file = file;
        this.value = value;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
