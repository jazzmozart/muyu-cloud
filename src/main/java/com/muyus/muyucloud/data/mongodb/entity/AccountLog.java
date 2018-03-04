package com.muyus.muyucloud.data.mongodb.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

/**
 * AccountLog
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/6
 */
@Entity(value = "account_log", noClassnameStored = true)
@Indexes({
        @Index(fields = {@Field(value = "accountId")})
})
public class AccountLog {
    /**
     * ID
     */
    @Id
    private ObjectId id;
    /**
     * 方式
     */
    private String method;
    /**
     * 用户
     */
    @Property("account_id")
    private String accountId;
    /**
     * 操作IP
     */
    private String ip;
    /**
     * 执行时间
     */
    @Property("create_time")
    private Date createTime;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
