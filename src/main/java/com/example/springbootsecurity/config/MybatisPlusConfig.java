package com.example.springbootsecurity.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 张新
 * @title: MybatisPlusConfig
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1610:45
 */
@EnableTransactionManagement
@Configuration
//扫描的mapper文件路径
@MapperScan(value = "com.example.springbootsecurity.mapper")
public class MybatisPlusConfig {
        /**
         * 分页插件
         */
        @Bean
        public PaginationInterceptor paginationInterceptor() {
                return new PaginationInterceptor();
        }
}

