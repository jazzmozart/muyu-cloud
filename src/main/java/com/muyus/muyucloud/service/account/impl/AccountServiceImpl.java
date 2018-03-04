package com.muyus.muyucloud.service.account.impl;

import com.muyus.muyucloud.data.mongodb.dao.AccountDAO;
import com.muyus.muyucloud.data.mongodb.dao.AccountLocalDAO;
import com.muyus.muyucloud.data.mongodb.entity.Account;
import com.muyus.muyucloud.data.mongodb.entity.AccountLocal;
import com.muyus.muyucloud.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountServiceImpl
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountLocalDAO accountLocalDAO;
    @Autowired
    AccountDAO accountDAO;

    @Override
    public AccountLocal findByPhoneNumber(String phoneNumber) {
        return accountLocalDAO.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Account findById(String id) {
        return accountDAO.get(id);
    }
}
