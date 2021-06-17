package com.example.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张新
 * @title: a
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/11 16:36
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/hello")
    public String Index(){
        return "index";
    }

}
