package com.muyus.muyucloud.service.account;

import com.muyus.muyucloud.data.mongodb.entity.Account;
import com.muyus.muyucloud.data.mongodb.entity.AccountLocal;
import org.springframework.stereotype.Service;

/**
 * AccountService
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Service
public interface AccountService {
    /**
     *
     * 验证用户名
     *
     * @param phoneNumber
     * @return
     */
    AccountLocal findByPhoneNumber(String phoneNumber);

    /**
     *
     * 帐号信息
     *
     * @param id
     * @return
     */
    Account findById(String id);
}
