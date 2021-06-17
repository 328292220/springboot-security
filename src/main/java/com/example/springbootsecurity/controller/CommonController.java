package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 张新
 * @title: CommonController
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1614:07
 */
@Controller
public class CommonController {
    /**
     * 登录界面
     *
     * @return
     */
    @GetMapping("login")
    private String login() {
        return "login";
    }

    /**
     * 欢迎界面
     *
     * @return
     */
    @GetMapping({"", "index"})
    private String index() {
        return "index";
    }

    /**
     * 管理员欢迎界面
     *
     * @return
     */
    @GetMapping({"admin"})
    private String admin() {
        return "admin";
    }
    /**
     * 用户欢迎界面
     *
     * @return
     */
    @GetMapping({"success"})
    private String success() {
        List<String> roleCodes = SessionUtil.getCurrentUser().getRoleCodes();
        if(roleCodes.contains("admin")){
            return "redirect:/admin";
        }else if (roleCodes.contains("test")){
            return "redirect:/user";
        }else{
            return "index";
        }


    }

}
