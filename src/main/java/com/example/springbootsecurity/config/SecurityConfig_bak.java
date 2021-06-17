//package com.example.springbootsecurity.config;
//
//import com.example.springbootsecurity.filter.VerifyCodeFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * @author 张新
// * @title: a
// * @projectName springboot-security
// * @description: Java配置用户名/密码
// * @date 2021/6/1116:46
// */
////@Configuration
//public class SecurityConfig_bak extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder passwordEncoder = passwordEncoder();
//        String encode = passwordEncoder.encode("123456");
//        String encode2 = passwordEncoder.encode("123456");
//        //下面这两行配置表示在内存中配置了两个用户
//        auth.inMemoryAuthentication()
//                .withUser("admin").roles("admin").password(encode)
//                .and()
//                .withUser("zhangxin").roles("user").password(encode2);
//    }
//
//    //密码的加密方式
//    //@Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    VerifyCodeFilter verifyCodeFilter;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
//        http.authorizeRequests()//开启登录配置
//            .antMatchers("/hello").hasRole("admin")//表示访问 /hello 这个接口，需要具备 admin 这个角色
//            .anyRequest().authenticated()//表示剩余的其他接口，登录之后就能访问
//            .and()
//            //修改Spring Security默认的登陆界面
//            .formLogin()
//            //定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
//            .loginPage("/login")
//            //登录处理接口
//            .loginProcessingUrl("/doLogin")
//            //定义登录时，用户名的 key，默认为 username
//            //.usernameParameter("uname")
//            //定义登录时，用户密码的 key，默认为 password
//            //.passwordParameter("passwd")
//            //登录成功的处理器
//            .successHandler(new AuthenticationSuccessHandler() {
//                @Override
//                public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write("success");
//                    out.flush();
//                }
//            })
//            .failureHandler(new AuthenticationFailureHandler() {
//                @Override
//                public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write("fail");
//                    out.flush();
//                }
//            })
//            .permitAll()//和表单登录相关的接口统统都直接通过
//            .and()
//            .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessHandler(new LogoutSuccessHandler() {
//                @Override
//                public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write("logout success");
//                    out.flush();
//                }
//            })
//            .permitAll()
//            .and()
//            .httpBasic()
//            .and()
//            .csrf().disable();
//    }
//
//}
