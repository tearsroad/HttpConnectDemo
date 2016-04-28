/*
 * 类文件名:  MyEncoder.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年10月14日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 格式转换
 * 
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年10月14日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class MyEncoder
{
    public static String getEncoderStr(String str){
        if(str==null||"".equals(str)){
            return "";
        }
        String result = null;
        try
        {
            result = URLEncoder.encode(str, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
