package com.example.springbootsecurity.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 张新
 * @title: CustomPasswordEncoder
 * @projectName springboot-security
 * @description: 密码加密器，因为我们数据库是明文存储的，所以明文返回即可
 * @date 2021/6/1613:51
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {
 
        @Override
        public String encode(CharSequence charSequence) {
                return charSequence.toString();
        }
 
        @Override
        public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
        }

}
