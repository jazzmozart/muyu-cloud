package com.muyus.muyucloud.data.mongodb.dao;

import com.muyus.muyucloud.data.mongodb.entity.Article;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountDAO
 *
 * @author: WangHui
 * @email: adan_wang @dingyuegroup.cn
 * @date: 2018 /2/7
 */
@Repository
public class ArticleDAO extends BasicDAO<Article, ObjectId> {

    /**
     * Instantiates a new Account dao.
     *
     * @param datastore the write datastore
     */
    protected ArticleDAO(@Autowired Datastore datastore) {
        super(datastore);
    }

    public List<Article> getNewArticle(){
        Query<Article> query = createQuery();
        query.order("-create_time");

        return find(query).asList();

    }

}
