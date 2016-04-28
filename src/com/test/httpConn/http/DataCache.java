package com.test.httpConn.http;


public class DataCache {
    public String UserPhoneNbr;//手机号
    public String UserPhonePwd;//密码
    public String companyCode;//商户号
    public String companyName;
    public String companyLogoImage;
    public String companyLogoImageUrl;//商户头像
    public String shopCode;
    public String shopName;
    public String userName;
    public int duty;
    public String userImage;
    public String userImageUrl;
    public String BILLS_MID;//银联商户ID
    public String BILLS_TID;//银联商户TID
    public String token ;
    public String lastLoginTime;//上次登录时间
    public String shopLogoImage;
    public String shopLogoImageUrl;
    public DataCache(){
        reSet();
    }
    public void reSet(){
        UserPhoneNbr = null;
        UserPhonePwd = null;
        companyCode = null;
        companyName = null;
        shopCode = null;
        shopName = null;
        userName = null;
        token = null;
        BILLS_MID = null;
        BILLS_TID = null;
        lastLoginTime = null;
        companyLogoImage = null;
        companyLogoImageUrl = null;
        userImage = null;
        userImageUrl = null;
        shopLogoImage = null;
        shopLogoImageUrl = null;
    }
    /**
     * 判断用户登录信息是否还存在
     * 
     * @author   罗洪祥
     * @version  V001Z0001
     * @date     2015年11月11日
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public boolean isLoginYet(){
        return (UserPhoneNbr != null);
    }
    public boolean isTokenAvailable(){
        return (token != null);
    }
}
