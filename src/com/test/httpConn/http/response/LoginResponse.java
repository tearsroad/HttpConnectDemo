/*
 * 类文件名:  GetQrCodeResponse.java
 * 著作版权:  深圳市易商云电子商务有限公司 Copyright 2012-2022, E-mail: hongxiang_luo@esyto.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  罗洪祥
 * 创建时间:  2015年9月11日
 * 功能版本:  V001Z0001
 */
package com.test.httpConn.http.response;

import org.json.JSONException;
import org.json.JSONObject;

import com.test.httpConn.http.ErrorCode;
import com.test.httpConn.http.request.ClientResult;

/**
 * 登录解析
 * 
 * @author   罗洪祥
 * @version  V001Z0001
 * @date     2015年9月11日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class LoginResponse extends Response
{
    private String token;
    private String companyCode;
    private String companyName;
    private String shopCode;
    private String shopName;
    private String userName;
    private String shopLogoImage;
    private String shopLogoImageUrl;
    private String account;
    private int duty;
    private String userImage;
    private String userImageUrl;
    private String failNum;//密码错误次数
    private String disableTimes;//停用时间
    public String companyLogoImage;
    public String companyLogoImageUrl;//商户头像
    public String lastLoginTime;//上次登录时间
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
        if(isConnectedSuccess())
        try {
            String inputJson = getResultJson();
            JSONObject jsonObject = new JSONObject(inputJson);
            
            if(isSuccess()){
                token = jsonObject.getString("token");
                companyCode = jsonObject.getString("companyCode");
                companyName = jsonObject.getString("companyName");
                shopCode = jsonObject.getString("shopCode");
                shopName = jsonObject.getString("shopName");
                userName = jsonObject.getString("userName");
                account = jsonObject.getString("account");
                duty = Integer.valueOf(jsonObject.getString("duty"));
                userImage = jsonObject.getString("userImage");
                userImageUrl = jsonObject.getString("userImageUrl");
                companyLogoImage = jsonObject.getString("companyLogoImage");
                companyLogoImageUrl = jsonObject.getString("companyLogoImageUrl");
                lastLoginTime = getJsonStr(jsonObject, "lastLoginTime");
                shopLogoImage = jsonObject.getString("shopLogoImage");
                shopLogoImageUrl = jsonObject.getString("shopLogoImageUrl");
                res = true;
            }else{
                if(ErrorCode.PWD_ERROR.equals(getCode())){
                    failNum = jsonObject.getString("failNum");
                }
                if(ErrorCode.USERSTOP_ERROR.equals(getCode())){
                    disableTimes = jsonObject.getString("disableTimes");
                }
            }
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
	private String getJsonStr(JSONObject jsonObject, String lastLoginTime) throws JSONException {
		if(jsonObject.has(lastLoginTime)){
			return jsonObject.getString(lastLoginTime);
		}
		else
		{
			return "";
		}
	}
    /**
     * 获取 token
     * @return 返回 token
     */
    public String getToken()
    {
        return token;
    }
    /**
     * 获取 companyCode
     * @return 返回 companyCode
     */
    public String getCompanyCode()
    {
        return companyCode;
    }
    /**
     * 设置 companyCode
     * @param 对companyCode进行赋值
     */
    public void setCompanyCode(String companyCode)
    {
        this.companyCode = companyCode;
    }
    /**
     * 获取 companyName
     * @return 返回 companyName
     */
    public String getCompanyName()
    {
        return companyName;
    }
    /**
     * 设置 companyName
     * @param 对companyName进行赋值
     */
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    /**
     * 获取 shopCode
     * @return 返回 shopCode
     */
    public String getShopCode()
    {
        return shopCode;
    }
    /**
     * 设置 shopCode
     * @param 对shopCode进行赋值
     */
    public void setShopCode(String shopCode)
    {
        this.shopCode = shopCode;
    }
    /**
     * 获取 shopName
     * @return 返回 shopName
     */
    public String getShopName()
    {
        return shopName;
    }
    /**
     * 设置 shopName
     * @param 对shopName进行赋值
     */
    public void setShopName(String shopName)
    {
        this.shopName = shopName;
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
     * 获取 duty
     * @return 返回 duty
     */
    public int getDuty()
    {
        return duty;
    }
    /**
     * 设置 duty
     * @param 对duty进行赋值
     */
    public void setDuty(int duty)
    {
        this.duty = duty;
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
    /**
     * 获取 failNum
     * @return 返回 failNum
     */
    public String getFailNum()
    {
        return failNum;
    }
    /**
     * 设置 failNum
     * @param 对failNum进行赋值
     */
    public void setFailNum(String failNum)
    {
        this.failNum = failNum;
    }
    /**
     * 获取 disableTimes
     * @return 返回 disableTimes
     */
    public String getDisableTimes()
    {
        return disableTimes;
    }
    /**
     * 设置 disableTimes
     * @param 对disableTimes进行赋值
     */
    
    public void setDisableTimes(String disableTimes)
    {
        this.disableTimes = disableTimes;
    }
	public String getCompanyLogoImage() {
		return companyLogoImage;
	}
	public void setCompanyLogoImage(String companyLogoImage) {
		this.companyLogoImage = companyLogoImage;
	}
	public String getCompanyLogoImageUrl() {
		return companyLogoImageUrl;
	}
	public void setCompanyLogoImageUrl(String companyLogoImageUrl) {
		this.companyLogoImageUrl = companyLogoImageUrl;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
    /**
     * 获取 shopLogoImage
     * @return 返回 shopLogoImage
     */
    public String getShopLogoImage()
    {
        return shopLogoImage;
    }
    /**
     * 设置 shopLogoImage
     * @param 对shopLogoImage进行赋值
     */
    public void setShopLogoImage(String shopLogoImage)
    {
        this.shopLogoImage = shopLogoImage;
    }
    /**
     * 获取 shopLogoImageUrl
     * @return 返回 shopLogoImageUrl
     */
    public String getShopLogoImageUrl()
    {
        return shopLogoImageUrl;
    }
    /**
     * 设置 shopLogoImageUrl
     * @param 对shopLogoImageUrl进行赋值
     */
    public void setShopLogoImageUrl(String shopLogoImageUrl)
    {
        this.shopLogoImageUrl = shopLogoImageUrl;
    }
    
    
    
}
