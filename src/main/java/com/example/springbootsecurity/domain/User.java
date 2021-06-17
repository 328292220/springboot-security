package com.example.springbootsecurity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 张新
 * @title: User
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1610:47
 */
@Data
@TableName("fnd_user")
public class User implements Serializable {
    private int id;
    private String name;
    private String account;
    private String password;

    @TableField(select = false)
    private List<String> roleCodes = new ArrayList<>();


}

