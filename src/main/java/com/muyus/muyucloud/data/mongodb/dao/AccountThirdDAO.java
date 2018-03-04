package com.muyus.muyucloud.data.mongodb.dao;

import com.muyus.muyucloud.data.mongodb.entity.AccountThird;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * AccountThirdDAO
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/7
 */
@Repository
public class AccountThirdDAO extends BasicDAO<AccountThird, ObjectId> {

    protected AccountThirdDAO(@Autowired Datastore datastore) {
        super(datastore);
    }
}
