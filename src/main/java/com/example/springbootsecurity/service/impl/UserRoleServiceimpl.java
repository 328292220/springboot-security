package com.example.springbootsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootsecurity.domain.SysUserRole;
import com.example.springbootsecurity.mapper.SysUserRoleMapper;
import com.example.springbootsecurity.service.UserRoleService;
import com.example.springbootsecurity.service.UserService;
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
public class UserRoleServiceimpl extends ServiceImpl<SysUserRoleMapper,SysUserRole> implements UserRoleService {
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<SysUserRole> listByUserId(int id) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",id);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(queryWrapper);
        return sysUserRoles;
    }
}
