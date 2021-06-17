package com.example.springbootsecurity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 张新
 * @title: SysUserRole
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/16 14:53
 */
@Data
@TableName("fnd_user_role")
public class SysUserRole implements Serializable {
    @TableField("role_id")
    private int roleId;
    @TableField("user_id")
    private String userId;
}
