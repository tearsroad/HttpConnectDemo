/*
 * 类文件名:  Client.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月14日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.test.httpConn.common.MyApplication;
import com.test.httpConn.common.NetworkUtil;
import com.test.httpConn.http.ErrorCode;

/**
 * 网络请求客户端
 * 
 * @author 罗洪祥
 * @version V001Z0001
 * @date 2015年9月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Client {
	private String apiUrl;
	private ClientRequest clientRequest;
	private Context mContext;
	private ClientResult clientResult;
	private int timeOut = 30*1000;//30s
	public Client(Context context, String apiUrl) {
		this.apiUrl = apiUrl;
		this.mContext = context;
	}

	/**
	 * 绑定请求参数
	 * 
	 * @author 罗洪祥
	 * @version V001Z0001
	 * @date 2015年9月15日
	 * @see [相关类/方法]
	 * @since [产品/模块版本]
	 */
	public Client build(ClientRequest clientRequest) {
		this.clientRequest = clientRequest;
		this.clientRequest.addParam("token", MyApplication.mDataCache.token);
		return this;
	}

	/**
	 * post请求，返回结果，需要在子线程中运行
	 * 
	 * @author 罗洪祥
	 * @version V001Z0001
	 * @date 2015年9月15日
	 * @see [相关类/方法]
	 * @since [产品/模块版本]
	 */
	public ClientResult post() {
		clientResult = new ClientResult();
		if (!NetworkUtil.isNetworkAvailable(mContext)) {
			clientResult.setResultCode(ErrorCode.NETWORK_ERROR);
			clientResult.setResultDesc(ErrorCode.get(ErrorCode.NETWORK_ERROR));
			return clientResult;
		}
		// 第一步，创建HttpPost对象
		String url = apiUrl + clientRequest.getRestPath();// "http://192.168.0.70:8888/com.ec2.ecp.ui/app/trans";//apiUrl+clientRequest.getRestPath();
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		// BufferedReader bufferedReader = null;
		StringBuffer responseResult = new StringBuffer();
		HttpURLConnection httpURLConnection = null;
		String json;
		try {
			json = getJsonResquest(clientRequest.getRestPath());
			Log.e("client", "url：" + url);
			Log.e("client", " 请求参数：" + json);
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			httpURLConnection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			httpURLConnection.setRequestProperty("Accept", "application/json");
			httpURLConnection.setRequestProperty("Content-Type",
					"application/json; charset=UTF-8");
			httpURLConnection.setConnectTimeout(timeOut);
			// httpURLConnection.setRequestProperty("Content-Length", String
			// .valueOf(json.length()));
			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			printWriter = new PrintWriter(httpURLConnection.getOutputStream());
			// 发送请求参数
			printWriter.write(json);
			// flush输出流的缓冲
			printWriter.flush();
			// 根据ResponseCode判断连接是否成功
			int responseCode = httpURLConnection.getResponseCode();
			// 定义BufferedReader输入流来读取URL的ResponseData
			bufferedReader = new BufferedReader(new InputStreamReader(
					httpURLConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				responseResult.append(line);
			}
			Log.e("client", "返回参数：" + responseResult.toString());
			clientResult.setResultCode(responseCode);
			String result = getJsonResponse(responseResult.toString());
			clientResult.setResult(result);
		} catch (Exception e) {
			Log.e("test", "send post request error!" + e);
			clientResult.setResultCode(ErrorCode.CONNECT_ERROR);
			clientResult.setResultDesc(ErrorCode.get(ErrorCode.CONNECT_ERROR));
		} finally {
			httpURLConnection.disconnect();
			try {
				if (printWriter != null) {
					printWriter.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			httpURLConnection = null;

		}

		return clientResult;
	}

	/**
	 * 请求数据封装
	 * 
	 * @author 罗洪祥
	 * @version V001Z0001
	 * @date 2015年9月15日
	 * @see [相关类/方法]
	 * @since [产品/模块版本]
	 */
	private String getJsonResquest(String url) throws JSONException {
		Map<String, String> map = clientRequest.getFieldData();
		JSONObject obj = new JSONObject();
		String urlcontent = "";
		for (String key : map.keySet()) {
			obj.put(key, map.get(key));
		}
		JSONObject json = new JSONObject();
		json.put("request_text", obj.toString());
		return json.toString();
	}


	private String getJsonResponse(String result) {
		JSONObject json;
		String jsonResult = null;
		try {
			json = new JSONObject(result);
			jsonResult = json.getString("response_text");// json.getString("response_text");
		} catch (JSONException e) {
			e.printStackTrace();
			clientResult.setResultCode(ErrorCode.JSON_ERROR);
			clientResult.setResultDesc(ErrorCode.get(ErrorCode.JSON_ERROR));
		}
		return jsonResult;
	}
}
