package com.test.httpConn;

import com.test.httpConn.common.MyApplication;
import com.test.httpConn.http.OnTaskFinished;
import com.test.httpConn.http.response.GetPersonalMsgResponse;
import com.test.httpConn.http.response.LoginResponse;
import com.test.httpConn.http.task.GetPersonalMsgTask;
import com.test.httpConn.http.task.LoginTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView tvMsg; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvMsg = (TextView) findViewById(R.id.tv_msg);
	}
	//登录
	public void onclick_login(View v){
		login();
	}
	//通过token获取用户信息
	public void onclick_getMsg(View v){
		getUserMsgByToken();
	}
	//让token失效
	public void onclick_cleartoken(View v){
		clearToken();
	}
	private void showMsg(String msg){
		tvMsg.setText(msg);
	}
	private void login(){
		LoginTask task = new LoginTask(this, "18030024119", "123456");
		task.setProgressVisiable(true);
		task.setOnTaskFinished(new OnTaskFinished() {
			
			@Override
			public void onSucc(Object obj) {
				// TODO Auto-generated method stub
				showMsg("登录成功");
				LoginResponse response = (LoginResponse)obj;
				MyApplication.mDataCache.token = response.getToken();
			}
			
			@Override
			public void onFail(Object obj) {
				// TODO Auto-generated method stub
				LoginResponse response = (LoginResponse)obj;
				showMsg("登录失败,"+response.getResultDesc());
				
			}
		});
		task.execute();
	}
	
	private void getUserMsgByToken(){
		GetPersonalMsgTask task = new GetPersonalMsgTask(this);
		task.setProgressVisiable(true);
		task.setOnTaskFinished(new OnTaskFinished() {
			
			@Override
			public void onSucc(Object obj) {
				// TODO Auto-generated method stub
				showMsg("获取信息成功");
			}
			
			@Override
			public void onFail(Object obj) {
				// TODO Auto-generated method stub
				GetPersonalMsgResponse response = (GetPersonalMsgResponse)obj;
				showMsg("获取信息失败,"+response.getResultDesc());
				
			}
		});
		task.execute();
	}
	
	private void clearToken(){
		MyApplication.mDataCache.token = "0";
	}

}
