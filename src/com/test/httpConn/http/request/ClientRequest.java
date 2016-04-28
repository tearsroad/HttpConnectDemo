/*
 * 类文件名:  ClientRequest.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月14日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http.request;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求参数封装类
 * 
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年9月14日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ClientRequest
{
    private Map<String, String> fieldData;  // 数据字段
    private String restPath;
    
    public ClientRequest(String restPath){
        this.restPath = restPath;
        fieldData = new HashMap<String, String>();
    }
    
    public void addParam(String name, String value){
        if(value==null)
            value="";
        fieldData.put(name, value);
    }
    public void addParam(String name, int value){
        fieldData.put(name, value+"");
    }
    /**
     * 获取 fieldData
     * @return 返回 fieldData
     */
    public Map<String, String> getFieldData()
    {
        return fieldData;
    }
    /**
     * 设置 fieldData
     * @param 对fieldData进行赋值
     */
    public void setFieldData(Map<String, String> fieldData)
    {
        this.fieldData = fieldData;
    }
    /**
     * 获取 restPath
     * @return 返回 restPath
     */
    public String getRestPath()
    {
        return restPath;
    }
    /**
     * 设置 restPath
     * @param 对restPath进行赋值
     */
    public void setRestPath(String restPath)
    {
        this.restPath = restPath;
    }
  
}
