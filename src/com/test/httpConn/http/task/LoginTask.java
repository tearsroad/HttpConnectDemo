/*
 * 类文件名:  LoginTask.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月14日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http.task;

import android.content.Context;

import com.test.httpConn.http.request.ClientRequest;
import com.test.httpConn.http.request.ClientResult;
import com.test.httpConn.http.response.LoginResponse;

/**
 * 登录任务
 * 
 * @author 罗洪祥
 * @version V001Z0001
 * @date 2015年9月14日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LoginTask extends BaseTask {
	// 登录加密接口
	private static final String url_left = "/app/companys/login";
	private LoginResponse response;
	private String userName;
	private String userPwd;

	/**
	 * <默认构造函数>
	 */
	public LoginTask(Context context, String userName, String userPwd) {
		super(context);
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	/**
	 * 重载方法
	 * 
	 * @param params
	 * @return
	 */
	@Override
	protected Boolean doInBackground(String... params) {
		response = new LoginResponse();

		ClientResult cResult = client.build(getRequest()).post();
		response.parseResult(cResult);

		return response.isSuccess();
	}

	/**
	 * 重载方法
	 * 
	 * @param rslt
	 */
	@Override
	protected void onPostExecute(Boolean rslt) {
		super.onPostExecute(rslt);
		// 执行完做封装处理，取出自己要的字段

		if (mOnTaskFinished != null) {
			if (rslt) {
				mOnTaskFinished.onSucc(response);
			} else {
				mOnTaskFinished.onFail(response);
			}
		}
	}

	private ClientRequest getRequest() {
		ClientRequest request = new ClientRequest(url_left);
		request.addParam("account", userName);
		request.addParam("password", userPwd);
		return request;
	}
}
