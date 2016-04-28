/*
 * 类文件名:  ClientResult.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月14日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http.request;

/**
 * 网络请求返回结果类
 * 
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年9月14日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ClientResult
{
    private int resultCode;
    private String resultDesc;
    private String result;
    /**
     * 获取 resultCode
     * @return 返回 resultCode
     */
    public int getResultCode()
    {
        return resultCode;
    }
    /**
     * 设置 resultCode
     * @param 对resultCode进行赋值
     */
    public void setResultCode(int resultCode)
    {
        this.resultCode = resultCode;
    }
    /**
     * 获取 resultDesc
     * @return 返回 resultDesc
     */
    public String getResultDesc()
    {
        return resultDesc;
    }
    /**
     * 设置 resultDesc
     * @param 对resultDesc进行赋值
     */
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }
    /**
     * 获取 result
     * @return 返回 result
     */
    public String getResult()
    {
        return result;
    }
    /**
     * 设置 result
     * @param 对result进行赋值
     */
    public void setResult(String result)
    {
        this.result = result;
    }
    
}
