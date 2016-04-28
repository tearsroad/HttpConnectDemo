/*
 * 类文件名:  GetQrCodeResponse.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月11日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http.response;

import org.json.JSONObject;

import com.test.httpConn.http.request.ClientResult;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年9月11日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GetPersonalMsgResponse extends Response
{
    private String userName;
    private String province;
    private String city;
    private String account;
    private String sex;
    private String birthday;
    private String userImage;
    private String nickName;
    private String userImageUrl;
    /**
     * 重载方法
     * @param result
     * @return
     */
    @Override
    public boolean parseResult(ClientResult result)
    {
        // TODO Auto-generated method stub
        boolean res = parseCR(result);
        if(isSuccess())
        try {
            String inputJson = getResultJson();
            JSONObject jsonObject = new JSONObject(inputJson);
            userName = jsonObject.getString("userName");
            account = jsonObject.getString("account");
            sex = jsonObject.getString("sex");
            birthday = jsonObject.getString("birthday");
            province = jsonObject.getString("province");
            city = jsonObject.getString("city");
            userImage = jsonObject.getString("userImage");
            nickName = jsonObject.getString("nickName");
            userImageUrl = jsonObject.getString("userImageUrl");
            res = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            res = false;
            setIsSuccess(false);
            setResultCode("002");
            setResultDesc("解析失败");
            return false;
        }
        return res;
    }
    /**
     * 获取 userName
     * @return 返回 userName
     */
    public String getUserName()
    {
        return userName;
    }
    /**
     * 设置 userName
     * @param 对userName进行赋值
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    /**
     * 获取 province
     * @return 返回 province
     */
    public String getProvince()
    {
        return province;
    }
    /**
     * 设置 province
     * @param 对province进行赋值
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    /**
     * 获取 city
     * @return 返回 city
     */
    public String getCity()
    {
        return city;
    }
    /**
     * 设置 city
     * @param 对city进行赋值
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     * 获取 account
     * @return 返回 account
     */
    public String getAccount()
    {
        return account;
    }
    /**
     * 设置 account
     * @param 对account进行赋值
     */
    public void setAccount(String account)
    {
        this.account = account;
    }
    /**
     * 获取 sex
     * @return 返回 sex
     */
    public String getSex()
    {
        return sex;
    }
    /**
     * 设置 sex
     * @param 对sex进行赋值
     */
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    /**
     * 获取 birthday
     * @return 返回 birthday
     */
    public String getBirthday()
    {
        return birthday;
    }
    /**
     * 设置 birthday
     * @param 对birthday进行赋值
     */
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }
    /**
     * 获取 userImage
     * @return 返回 userImage
     */
    public String getUserImage()
    {
        return userImage;
    }
    /**
     * 设置 userImage
     * @param 对userImage进行赋值
     */
    public void setUserImage(String userImage)
    {
        this.userImage = userImage;
    }
    /**
     * 获取 nickName
     * @return 返回 nickName
     */
    public String getNickName()
    {
        return nickName;
    }
    /**
     * 设置 nickName
     * @param 对nickName进行赋值
     */
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }
    /**
     * 获取 userImageUrl
     * @return 返回 userImageUrl
     */
    public String getUserImageUrl()
    {
        return userImageUrl;
    }
    /**
     * 设置 userImageUrl
     * @param 对userImageUrl进行赋值
     */
    public void setUserImageUrl(String userImageUrl)
    {
        this.userImageUrl = userImageUrl;
    }
    
}
