package com.example.springbootsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.mapper.UserMapper;
import com.example.springbootsecurity.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 张新
 * @title: UserServiceImpl
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1610:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
