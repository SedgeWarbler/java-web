package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 2023/7/20 14:54
 */
public class Form extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username"); //获取参数
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //可以获取json数据
        ServletInputStream inputStream = req.getInputStream();
        StringBuilder result = new StringBuilder();

        int i;
        while ((i = inputStream.read()) != -1){
            result.append((char) i);
        }

        System.out.println(result);
    }
}
