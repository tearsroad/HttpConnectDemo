package com.test.httpConn.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.test.httpConn.R;
/**
 * 小工具类
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年9月18日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Toolkits {
    private static final String TAG = "Toolkits";
	 /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }  
    /**
     * 重新根据子item的高度和个数设置listview的高度
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {  
        ListAdapter listAdapter = listView.getAdapter();   
        if (listAdapter == null) {  
            // pre-condition  
            return;  
        }  
  
        int totalHeight = 0;  
        for (int i = 0; i < listAdapter.getCount(); i++) {  
            View listItem = listAdapter.getView(i, null, listView);  
            listItem.measure(0, 0);  
            totalHeight += listItem.getMeasuredHeight();  
        }  
  
        ViewGroup.LayoutParams params = listView.getLayoutParams();  
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));  
        listView.setLayoutParams(params);  
    }  
    private static String getCurAppVer(Context context) {
        String verName = "1";
        try {
            verName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return  verName;
    }
    /**
     * 
     * 内部版本号
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年9月11日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static String getCurAppVerName(Context context) {
        String verCode = getCurAppVer(context);
        String verName = verCode;
//        try {
//            verName = verCode.charAt(0) + "." + verCode.charAt(1) + "." + verCode.charAt(2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return verName;
    }
    /**
     * 
     * 获取手机信息，系统版本
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年9月11日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static String getPhoneModelLong() {
        String phonemodel = android.os.Build.MANUFACTURER + " "
                + android.os.Build.MODEL;
        phonemodel = phonemodel.replace("&", "_");// 兼容<"&" 字符在xml中是特殊字符,必须转化>
        return phonemodel;
    }
    /**
     * 
     * 获取渠道号
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年9月11日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static String getChannelId(Context context) {
        String result = "channel0";
        try {
            ApplicationInfo appinfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            Bundle bundle = appinfo.metaData;
            result = bundle.getString("APP_CHANNEL_ID");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    /** 
     * 将ip的整数形式转换成ip形式 
     *  
     * @param ipInt 
     * @return 
     */  
    public static String int2ip(int ipInt) {  
        StringBuilder sb = new StringBuilder();  
        sb.append(ipInt & 0xFF).append(".");  
        sb.append((ipInt >> 8) & 0xFF).append(".");  
        sb.append((ipInt >> 16) & 0xFF).append(".");  
        sb.append((ipInt >> 24) & 0xFF);  
        return sb.toString();  
    }  
  
    /** 
     * 获取当前ip地址 
     *  
     * @param context 
     * @return 
     */  
    public static String getLocalIpAddress(Context context) {  
        try {  
            
            WifiManager wifiManager = (WifiManager) context  
                    .getSystemService(Context.WIFI_SERVICE);  
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();  
            int i = wifiInfo.getIpAddress();  
            return int2ip(i);  
        } catch (Exception ex) {  
            return " 获取IP出错鸟!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();  
        }  
        // return null;  
    }  
    /**
     * 获取手机MEID
     * 
     * @return
     */
    public static String getIMEI(Context context) {
        try {
            TelephonyManager telMgr;
            telMgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String meid = telMgr.getDeviceId();
            if (meid == null) {
                meid = "";
            }
            return meid;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    /** 
     * 获取外网的IP(要访问Url，要放到后台线程里处理) 
     *  
     * @Title: GetNetIp 
     * @Description: 
     * @param @return 
     * @return String 
     * @throws 
     */  
    public static String GetNetIp() {  
        URL infoUrl = null;  
        InputStream inStream = null;  
        String ipLine = "";  
        HttpURLConnection httpConnection = null;  
        try {  
            infoUrl = new URL("http://ip168.com/");  
            URLConnection connection = infoUrl.openConnection();  
            httpConnection = (HttpURLConnection) connection;  
            int responseCode = httpConnection.getResponseCode();  
            if (responseCode == HttpURLConnection.HTTP_OK) {  
                inStream = httpConnection.getInputStream();  
                BufferedReader reader = new BufferedReader(  
                        new InputStreamReader(inStream, "utf-8"));  
                StringBuilder strber = new StringBuilder();  
                String line = null;  
                while ((line = reader.readLine()) != null)  
                    strber.append(line + "\n");  
  
                Pattern pattern = Pattern  
                        .compile("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");  
                Matcher matcher = pattern.matcher(strber.toString());  
                if (matcher.find()) {  
                    ipLine = matcher.group();  
                }  
            }  
  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                inStream.close();  
                httpConnection.disconnect();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return ipLine;  
    }  
    /**
     * 获取手机状态栏高度
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年9月30日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static int getStatusHeight(Activity activity){
        int statusHeight = 0;
        Rect localRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        statusHeight = localRect.top;
        if (0 == statusHeight){
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(
                    localClass.getField("status_bar_height").get(
                        localObject).toString());
                statusHeight = activity.getResources(
                    ).getDimensionPixelSize(i5);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, "status height:"+statusHeight);
        return statusHeight;
    }
    /**
     * double数据格式化，保留两位小数
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年10月10日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static String doubleFormat(double double_value){
        try{
            DecimalFormat df = new DecimalFormat("#####0.00");  
            return df.format(double_value);  
        }catch(Exception e){
            e.printStackTrace();
            return "0.00";
        }
    }
    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())
                    && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isAppOnBackground(Context context){
        return (Toolkits.isAppOnForeground(context) == false|| Toolkits.isScreenOn(context) == false);
    }
    public static boolean isScreenOn(Context context) {
        PowerManager pm = (PowerManager) context
                .getSystemService(Context.POWER_SERVICE);
        return pm.isScreenOn();
    }
    /**
     * 验证手机号
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年10月22日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static boolean isMobileNO(String mobiles) {
        if(isStrEmpty(mobiles))return false;
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }
    /**
     * 验证字符串是否为空
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年10月22日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static boolean isStrEmpty(String str) {
        if(str==null||"".equals(str))return true;
        return false;
    }
    /**
     * 获取view的高度
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年11月6日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static int getViewHight(View myview){
        int w = View.MeasureSpec.makeMeasureSpec(0,
            View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        myview.measure(w, h);
        int height = myview.getMeasuredHeight();
        int width = myview.getMeasuredWidth();
        return height;
    }
    /**
     * 获取view的高度
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年11月6日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static int getViewWidth(View myview){
        int w = View.MeasureSpec.makeMeasureSpec(0,
            View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        myview.measure(w, h);
        int height = myview.getMeasuredHeight();
        int width = myview.getMeasuredWidth();
        return width;
    }
    /**
     * 通过包名判断是否安装了app
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年11月6日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public static boolean isPkgInstalled(Context context, String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        android.content.pm.ApplicationInfo info = null;
        try {
            info = context.getPackageManager().getApplicationInfo(packageName, 0);
            return info != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
    /**
     * 转化单位分为元
     * 
     * @param lfen
     * @return
     */
    public static String fen2Yuan(long lfen)
    {
        long lyuan = lfen / 100;
        long lxiaoshu = lfen % 100;
        if (lxiaoshu < 10)
        {
            return lyuan + ".0" + lxiaoshu;
        }
        else
        {
            return lyuan + "." + lxiaoshu;
        }
    }
    
}
