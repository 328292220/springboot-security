package com.example.springbootsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootsecurity.domain.SysRole;
import com.example.springbootsecurity.domain.SysUserRole;
import com.example.springbootsecurity.mapper.SysRoleMapper;
import com.example.springbootsecurity.mapper.SysUserRoleMapper;
import com.example.springbootsecurity.service.RoleService;
import com.example.springbootsecurity.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张新
 * @title: UserRoleServiceimpl
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/16 15:08
 */
@Service
public class RoleServiceimpl extends ServiceImpl<SysRoleMapper, SysRole> implements RoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public SysRole selectById(int roleId) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        SysRole sysRole = sysRoleMapper.selectOne(queryWrapper);
        return sysRole;
    }
}
