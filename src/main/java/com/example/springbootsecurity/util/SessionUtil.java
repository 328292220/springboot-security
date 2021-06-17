package com.example.springbootsecurity.util;

import com.example.springbootsecurity.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author 张新
 * @title: SessionUtil
 * @projectName springboot-security
 * @description: TODO
 * @date 2021/6/16 16:28
 */
public class SessionUtil<T> {
    //获取session
    public static HttpSession getSession(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        return session;
    }
    //从session获取值
    public static Object getvalue(String key){
        return getSession().getAttribute(key);
    }
    //从session设置值
    public static void setvalue(String key,Object value){
        getSession().setAttribute(key,value);
    }
    //设置当前用户
    public static void setCurrentUser(User user) {
        setvalue("currentUser",user);
    }
    //获取当前用户
    public static User getCurrentUser() {
        return (User)getvalue("currentUser");
    }
    //删除当前用户
    public static void removeCurrentUser() {
        getSession().removeAttribute("currentUser");
    }


}
