package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 2023/7/20 15:38
 */
public class CookieSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cookie
        javax.servlet.http.Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + c.getValue());
        }

        Cookie cookie = new Cookie("name", "刘纯");   //设置值
        cookie.setMaxAge(10);   //设置过期时间
        resp.addCookie(cookie);//存cookie


        //获取session
        HttpSession session = req.getSession();
        session.setAttribute("name", "liuchun"); //给session存东西
        Object name = session.getAttribute("name");//获取session的值 注意类型不是string 一般存什么类型，取出就什么类型
        session.removeAttribute("name"); //删除session

        String id = session.getId();    //获取session_id

        session.isNew(); //是不是新创建的session
    }
}
