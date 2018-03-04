package com.muyus.muyucloud.data.oss;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OssConfiguration
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Configuration
@EnableConfigurationProperties({OssProperties.class})
public class OssConfiguration {

    private final ApplicationContext applicationContext;
    private final OssProperties ossProperties;

    public OssConfiguration(ApplicationContext applicationContext, OssProperties ossProperties) {
        this.applicationContext = applicationContext;
        this.ossProperties = ossProperties;
    }

    @Bean
    public OSSClient getClient(){
        OSSClient ossClient = new OSSClient(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());

        return ossClient;
    }
}
