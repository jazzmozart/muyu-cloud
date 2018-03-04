package com.muyus.muyucloud.data.mongodb.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

/**
 * AccountThird
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/6
 */
@Entity(value = "account_local", noClassnameStored = true)
@Indexes({
        @Index(fields = {@Field(value = "phoneNumber")})
})
public class AccountLocal {
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
    @Property("phone_number")
    private String phoneNumber;
    /**
     * 密码
     */
    private String password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
