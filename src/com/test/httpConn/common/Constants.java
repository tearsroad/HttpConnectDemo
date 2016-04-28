/*
 * 类文件名:  Constants.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月11日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.common;

import android.os.Environment;

/**
 * 信息配置
 * 
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年9月11日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Constants
{
    public final static String HTTP_OK = "200";//服务器连接成功
    public final static String OK = "0";//平台数据成功
    
    //文件缓存地址
    public final static String PATH_FILE = Environment.getExternalStorageDirectory()
        .getPath() + "/ec2client";
    
    //权限
    public final static int DUTY_BOSS = 1;
    public final static int DUTY_SHOP = 2;
    public final static int DUTY_STAFF = 3;
    
    //全民付插件包名
    public final static String QUANMIN_PCK="com.chinaums.mposplugin";
    public final static String QUANMIN_NAME="mposplugin_phone_release_2_4_1";//版本更新通过这个字段比大小
    public final static int pluginType = 0;// 0 手机版 1 平板版
    public final static int environment = 1;// 0 测试环境 1 生产环境
    
}
