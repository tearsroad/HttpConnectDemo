package com.test.httpConn.http;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {
    public static int NETWORK_ERROR = 651;
    public static int CONNECT_ERROR = 1;
    public static int JSON_ERROR = 2;
    
    public static String PWD_ERROR = "8810008";//密码错误
    public static String USERLOCKED_ERROR = "8810020";//账号锁定
    public static String USERSTOP_ERROR = "8810025";//账号停用
	private static Map<String, String> errorMap = new HashMap<String, String>();
	
	private static void initMap(){
		if(errorMap != null && errorMap.size() == 0){
		    errorMap.put(String.valueOf(NETWORK_ERROR),"无网络连接！");
		    errorMap.put(String.valueOf(CONNECT_ERROR),"连接服务器异常，请稍后再试！");
		    
			errorMap.put(String.valueOf(JSON_ERROR),"请求参数错误或消息体解析失败。");
			errorMap.put("3","操作失败");
			errorMap.put("101","用户名密码不匹配");
			errorMap.put("102","用户名已存在");
			errorMap.put("103","旧密码不正确");
			errorMap.put("107","用户名不存在");
		}
	}
	public static String get(int key){
	    String skey = String.valueOf(key);
        initMap();
        if(errorMap.containsKey(skey)){
            return errorMap.get(skey);
        }
        else {
            return "";
        }
    }
	public static String get(String key){
		initMap();
		if(errorMap.containsKey(key)){
			return errorMap.get(key);
		}
		else {
			return "";
		}
	}
}
