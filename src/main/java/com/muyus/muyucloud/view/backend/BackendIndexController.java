package com.muyus.muyucloud.view.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * IndexController
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Controller
@RequestMapping("/backend")
public class BackendIndexController {

    @GetMapping(path = "")
    public String index(Model model){

        model.addAttribute("time", new Date());

        return "backend/index";
    }
    @GetMapping(path = "/login")
    public String login(Model model){

        return "backend/login";
    }
    @GetMapping(path = "/editor")
    public String editor(Model model){

        return "backend/editor";
    }
}
