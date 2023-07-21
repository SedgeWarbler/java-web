package com.servlet;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 2023/7/20 11:28
 * <p>
 * 下载文件
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载的文件路径
        //String realPath = this.getServletContext().getRealPath("1.jgp");
        String realPath = "E:\\img\\1.jpg";

        //获取文件名 lastIndexOf字符串最后出现的位置 substring从这个位置开始后面的值
//        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        String fileName = "阿哲.jpg";

        //设置header头  encode设置为utf-8的，如果是中文
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        //获取响应输出对象
        ServletOutputStream stream = resp.getOutputStream();
        //获取下载输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(realPath));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
            stream.write(bytes, 0, len);    //写入缓存区 缓存区的数据输出到客户端
        }

        //关闭资源
        stream.close();
        bufferedInputStream.close();
    }
}
