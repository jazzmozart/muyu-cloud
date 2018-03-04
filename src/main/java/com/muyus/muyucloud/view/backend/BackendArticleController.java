package com.muyus.muyucloud.view.backend;

import com.muyus.muyucloud.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * BackendArticleController
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/3/4
 */
@Controller
@RequestMapping("/backend")
public class BackendArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping(path = "/article")
    public String article(String content){

        System.out.println(content);


        articleService.save(content);

        return "backend/index";
    }
    @PostMapping(path = "/article/images")
    @ResponseBody
    public Map<String, String> images(MultipartFile upload){

        try {

            String url = articleService.saveImage(upload.getOriginalFilename(), upload.getBytes());

            Map<String, String> map = new LinkedHashMap<>();
            map.put("fileName", upload.getOriginalFilename());
            map.put("uploaded", "1");
            map.put("url", url);

            return map;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
