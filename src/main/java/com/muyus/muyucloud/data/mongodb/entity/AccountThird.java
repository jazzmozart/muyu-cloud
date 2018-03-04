package com.muyus.muyucloud.data.mongodb.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

/**
 * Account
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/6
 */
@Entity(value = "account_third", noClassnameStored = true)
@Indexes({
        @Index(fields = {@Field(value = "accountId")})
})
public class AccountThird {
    /**
     * ID
     */
    @Id
    private ObjectId id;
    /**
     * 用户
     */
    @Property("account_id")
    private String accountId;
    /**
     * 手机号
     */
    @Property("oauth_id")
    private String oauthId;
    /**
     * 渠道
     */
    private String channel;
    /**
     * 连接token
     */
    @Property("access_token")
    private String accessToken;
    /**
     * 刷新token
     */
    @Property("refresh_token")
    private String refreshToken;
    /**
     * 状态
     * 0 无效
     * 1 有效
     */
    private int status;
    /**
     * 应用
     */
    private String app;
    /**
     * 注册时间
     */
    @Property("register_time")
    private Date registerTime;
    /**
     * token过期时间
     */
    @Property("expire_time")
    private Date expireTime;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
