package com.muyus.muyucloud.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * AccountConfiguration
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/8
 */
@Configuration
@EnableConfigurationProperties({AccountProperties.class})
public class AccountConfiguration {
    @Autowired
    private AccountProperties accountProperties;

    @Bean
    public Algorithm init(){
        try {
            return Algorithm.RSA256(getPublicKey(), getPrivateKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    private RSAPublicKey getPublicKey() throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(accountProperties.getPublicKey().getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    private RSAPrivateKey getPrivateKey() throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(accountProperties.getPrivateKey().getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKey privateKey = (RSAPrivateKey)keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
}
