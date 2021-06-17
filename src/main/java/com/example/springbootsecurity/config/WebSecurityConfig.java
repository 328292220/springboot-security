package com.example.springbootsecurity.config;

import com.example.springbootsecurity.service.impl.CustomUserDetailsService;
import com.example.springbootsecurity.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 张新
 * @title: WebSecurity 配置类
 * @projectName springboot-security
 * @description: 该类的三个注解分别是标识该类是配置类、开启 Security 服务、开启全局 Securtiy 注解。
 * 首先将我们自定义的 userDetailsService 注入进来，在 configure() 方法中使用 auth.userDetailsService() 方法替换掉默认的 userDetailsService。
 * @date 2021/6/1613:53
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用SpringScurity提供的默认登录页面，访问/login时转到登录页面
        //http.formLogin();
        //http.logout().logoutSuccessUrl("/");
        http.authorizeRequests()
                //不需要身份认证
                .antMatchers("/", "/index", "/login").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
                //拥有某种角色才能访问
                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                // 需要登录才能访问
                .anyRequest().authenticated()
                .and()
                // 设置登录页
                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                // 设置登录成功页
                .defaultSuccessUrl("/success")
                // 自定义登录用户名和密码参数，默认为username和password
                // .usernameParameter("username")
                // .passwordParameter("password")
                .and()
                .logout().logoutSuccessHandler(new LogoutSuccessHandler(){
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        SessionUtil.removeCurrentUser();
                    }
                }).permitAll();

        // 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }


}