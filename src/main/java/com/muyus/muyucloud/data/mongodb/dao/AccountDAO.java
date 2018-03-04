package com.muyus.muyucloud.data.mongodb.dao;

import com.muyus.muyucloud.data.mongodb.entity.Account;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO
 *
 * @author: WangHui
 * @email: adan_wang @dingyuegroup.cn
 * @date: 2018 /2/7
 */
@Repository
public class AccountDAO extends BasicDAO<Account, String> {

    /**
     * Instantiates a new Account dao.
     *
     * @param datastore the write datastore
     */
    protected AccountDAO(@Autowired Datastore datastore) {
        super(datastore);
    }

}
