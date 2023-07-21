package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2023/7/20 10:18
 * <p>
 * 创建一个helloservlet 来进行测试
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletInputStream servletInputStream = req.getInputStream(); //输入
        resp.setContentType("text/html;charset=UTF-8");   //设置 大写utf-8字符输出

        PrintWriter printWriter = resp.getWriter(); //输出
        printWriter.println("你好啊");

        //重定向
        //resp.sendRedirect("https://www.baidu.com");

        //共享数据
       /* ServletContext context = this.getServletContext();
        context.setAttribute("name", "张三");

        context.getAttribute("name");*/
    }
}
