package com.muyus.muyucloud.data.mongodb.dao;

import com.muyus.muyucloud.data.mongodb.entity.AccountLocal;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * AccountLocalDAO
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/7
 */
@Repository
public class AccountLocalDAO extends BasicDAO<AccountLocal, ObjectId> {

    protected AccountLocalDAO(@Autowired Datastore datastore) {
        super(datastore);
    }

    public AccountLocal findByPhoneNumber(String phoneNumber) {
        Query<AccountLocal> query = createQuery();
        query.field("phoneNumber").equal(phoneNumber);
        return findOne(query);
    }
}
