package com.dekequan.library.message;

import com.dekequan.library.utils.HttpClientHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author qzr
 *
 */
public class MessageHelper {
    private static final String YUN_PIAN_API_KEY  = "50b14e5d476041cc84b574e3377e4ac7";
    private static final String YUN_PIAN_URL = "https://sms.yunpian.com/v2/sms/single_send.json";
    private static MessageHelper messageHelper = new MessageHelper();
    
    public static MessageHelper getMessageHelper(){
    	return messageHelper;
    }
    /**
     * 根据手机号和短信内容发送验证码
     * @param text
     * @param mobile
     * @return
     */
    public static String postMessage(String text, String mobile){
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
    /**
     * 根据验证码生成短信内容
     * @param code
     * @return
     */
    public static String generateMessageBycode(String code){
    	String messageModel = "【的客圈】亲爱的用户，您的验证码是#code#。欢迎使用！";
    	return messageModel.replace("#code#", code);
    }
}
