package com.example.springbootsecurity.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 张新
 * @title: VerifyCondeFilter
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/1116:51
 */
@Component
public class VerifyCodeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("TestFilter,"+request.getRequestURI());

        //执行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
