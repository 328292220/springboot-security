package com.example.springbootsecurity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 张新
 * @title: SysRole
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/16 15:22
 */
@Data
@TableName("fnd_role")
public class SysRole implements Serializable {
    @TableField("role_id")
    private int roleId;
    @TableField("role_code")
    private String roleCode;
    @TableField("role_name")
    private String roleName;
}
