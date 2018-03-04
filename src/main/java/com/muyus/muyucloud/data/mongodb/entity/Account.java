package com.muyus.muyucloud.data.mongodb.entity;

import org.mongodb.morphia.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Account
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/6
 */
@Entity(value = "account", noClassnameStored = true)
@Indexes({
        @Index(fields = {@Field(value = "phoneNumber")})
})
public class Account {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 手机号
     */
    @Property("phone_number")
    private String phoneNumber;
    /**
     * 别名
     */
    private String alias;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别
     */
    private String sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 应用
     */
    private String app;
    /**
     * 角色
     */
    private List<AccountRole> roles;
    /**
     * 状态
     * 0 无效
     * 1 有效
     */
    private int status;
    /**
     * 手机端令牌
     */
    @Property("app_token")
    private AccountToken appToken;
    /**
     * web端令牌
     */
    @Property("web_token")
    private AccountToken webToken;

    /**
     * 注册时间
     */
    @Property("register_time")
    private Date registerTime;
    /**
     * 更新时间
     */
    @Property("update_time")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public List<AccountRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AccountRole> roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AccountToken getAppToken() {
        return appToken;
    }

    public void setAppToken(AccountToken appToken) {
        this.appToken = appToken;
    }

    public AccountToken getWebToken() {
        return webToken;
    }

    public void setWebToken(AccountToken webToken) {
        this.webToken = webToken;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
