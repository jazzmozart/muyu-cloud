package com.muyus.muyucloud.view.api.controller;

import com.muyus.muyucloud.view.api.vo.AccountVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * AccountController
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @ApiOperation(value = "获取帐号")
    @GetMapping(path = "")
    public AccountVO index(){
        System.out.println("-------------");
        AccountVO accountVO = new AccountVO();
        return accountVO;
    }

}
