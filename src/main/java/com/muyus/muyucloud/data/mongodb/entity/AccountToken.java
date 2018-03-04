package com.muyus.muyucloud.data.mongodb.entity;

import org.mongodb.morphia.annotations.Property;

import java.util.Date;

/**
 * AccountToken
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/6
 */
public class AccountToken {
    /**
     * 令牌
     */
    private String value;
    /**
     * token过期时间
     */
    @Property("expire_time")
    private Date expireTime;
    /**
     * token刷新时间
     */
    @Property("refresh_time")
    private Date refreshTime;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }
}
