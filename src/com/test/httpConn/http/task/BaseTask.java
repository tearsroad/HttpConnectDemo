package com.test.httpConn.http.task;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import com.test.httpConn.http.OnCancel;
import com.test.httpConn.http.OnTaskFinished;
import com.test.httpConn.http.OnTaskStart;
import com.test.httpConn.http.request.Client;

public class BaseTask extends AsyncTask<String, Integer, Boolean> {
	protected Context mContext;
	private ProgressDialog mProgressDialog;
	private String mProgressMsg = "请稍候...";
	private boolean mIsProgressVisiable = false;
	protected OnTaskFinished mOnTaskFinished;
	protected OnTaskStart mOnTaskStart;
	protected OnCancel mOnCancel = null;
	protected Client client;
	public static final String URL = "http://api.esyto.com:9090/esypay";

	
	@SuppressLint("NewApi")
	public BaseTask(Context context) {
		mContext = context;
		mProgressDialog = new ProgressDialog(mContext);
		client = new Client(context,URL);
	}

	public void setProgressVisiable(boolean enable) {
		mIsProgressVisiable = enable;
	}

	public void setProgressMsg(String msg) {
		mProgressMsg = msg;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		try {
			if (mIsProgressVisiable) {
				mProgressDialog
						.setOnCancelListener(new DialogInterface.OnCancelListener() {
							public void onCancel(DialogInterface dialog) {
								cancel(true);
								if (mOnCancel != null) {
									mOnCancel.onClick();
								}
							}
						});

				mProgressDialog.setCancelable(true);
				mProgressDialog.setCanceledOnTouchOutside(false);
				mProgressDialog.setMessage(mProgressMsg);
				mProgressDialog.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Boolean doInBackground(String... params) {
		if(isCancelled()) {
			                return false;
			            }
		return true;
	}

	@Override
	protected void onPostExecute(Boolean rslt) {
		try {
			if (mProgressDialog != null)
				mProgressDialog.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setOnTaskFinished(OnTaskFinished onTaskFinished) {
		mOnTaskFinished = onTaskFinished;
	}

	public void setOnTaskStart(OnTaskStart onTaskStart) {
		mOnTaskStart = onTaskStart;
	}

	public void setOnCancel(OnCancel onCancel) {
		mOnCancel = onCancel;
	}
}
