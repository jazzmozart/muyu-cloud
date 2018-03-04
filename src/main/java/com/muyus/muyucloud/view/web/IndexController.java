package com.muyus.muyucloud.view.web;

import com.muyus.muyucloud.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * IndexController
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;

    @GetMapping(path = "")
    public String index(Model model){

        model.addAttribute("articles", articleService.getNewArticle());

        return "web/index";
    }
    @GetMapping(path = "/blog")
    public String blog(Model model){

        return "web/blog";
    }
    @GetMapping(path = "/album")
    public String album(Model model){

        return "web/album";
    }
    @GetMapping(path = "/article")
    public String article(Model model){

        return "web/article";
    }

}
