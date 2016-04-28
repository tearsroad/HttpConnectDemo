/*
 * 类文件名:  MyApplication.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月11日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.common;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import com.test.httpConn.MainActivity;
import com.test.httpConn.http.DataCache;

/**
 * @ClassName: MyApplication 
 * @Description: 系统application
 * @author 罗洪祥 luohx@esyto.com 
 * @date 2016年4月28日 下午8:47:17 
 *
 */
public class MyApplication extends Application
{
    private static String TAG = "MyApplication";
    public static String mUserAgent;
    private static Context mContext;
    public static DataCache mDataCache;
    @Override
    public void onCreate()
    {
        super.onCreate();
        mContext = getApplicationContext();
        mDataCache = new DataCache();
    }
    
}
