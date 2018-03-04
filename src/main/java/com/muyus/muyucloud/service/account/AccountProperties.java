package com.muyus.muyucloud.service.account;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AccountProperties
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/8
 */
@Data
@ConfigurationProperties(prefix = "spring.account")
public class AccountProperties {
    private String privateKey;
    private String publicKey;
}
