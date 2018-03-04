package com.muyus.muyucloud.service.article;

import com.muyus.muyucloud.data.mongodb.entity.Article;

import java.util.List;

/**
 * ArticleService
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/3/4
 */
public interface ArticleService {
    /**
     *
     * 存储图片
     *
     * @param name
     * @param bytes
     * @return String
     */
    String saveImage(String name, byte[] bytes);

    /**
     * 保存文章
     *
     * @param content
     * @return
     */
    Article save(String content);

    /**
     *
     * @return
     */
    List<Article> getNewArticle();
}
