package com.example.springbootsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootsecurity.domain.SysUserRole;

import java.util.List;

/**
 * @author 张新
 * @title: UserRoleService
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/16 15:07
 */
public interface UserRoleService extends IService<SysUserRole> {
    List<SysUserRole> listByUserId(int id);
}
