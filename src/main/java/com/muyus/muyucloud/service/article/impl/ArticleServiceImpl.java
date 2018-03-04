package com.muyus.muyucloud.service.article.impl;

import com.muyus.muyucloud.data.mongodb.dao.ArticleDAO;
import com.muyus.muyucloud.data.mongodb.entity.Article;
import com.muyus.muyucloud.data.oss.repository.ImageRepository;
import com.muyus.muyucloud.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ArticleServiceImpl
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/3/4
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ArticleDAO articleDAO;

    public List<Article> getNewArticle(){
        return articleDAO.getNewArticle();
    }

    @Override
    public String saveImage(String name, byte[] bytes) {

        return imageRepository.upload(name, bytes);

    }

    @Override
    public Article save(String content) {

        Article article = new Article();

        String titleArea = content.substring(0, content.length() > 20 ? 20 : content.length());

        String[] strings = titleArea.split("<[^>]+>");
        if (strings.length > 1){
            article.setTitle(strings[1]);
        }

        article.setContent(content);
        article.setCreateTime(new Date());
        article.setUpdateTime(article.getCreateTime());

        articleDAO.save(article);

        return article;
    }
}
