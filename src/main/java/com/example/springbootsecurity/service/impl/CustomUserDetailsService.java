package com.example.springbootsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootsecurity.domain.SysRole;
import com.example.springbootsecurity.domain.SysUserRole;
import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.service.RoleService;
import com.example.springbootsecurity.service.UserRoleService;
import com.example.springbootsecurity.service.UserService;
import com.example.springbootsecurity.util.SessionUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 张新
 * @title: CustomUserDetailsService
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1613:19
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", username);
        User user = userService.getOne(queryWrapper);
 
        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleCode().toUpperCase()));
            user.getRoleCodes().add(role.getRoleCode());
        }
        // 默认先给一个admin角色和user角色
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        //将用户放入session，集群需要放入redis
        SessionUtil.setCurrentUser(user);
        // 返回UserDetails实现类
        return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(), authorities);

    }

}
