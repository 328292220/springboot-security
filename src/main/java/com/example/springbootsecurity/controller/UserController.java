package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张新
 * @title: UserController
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1610:23
 */

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
 
    @GetMapping
    public String user(Model model) {
        model.addAttribute("title", "欢迎来到用户界面");
        model.addAttribute("userList", userService.list());
        return "user";
    }
}

