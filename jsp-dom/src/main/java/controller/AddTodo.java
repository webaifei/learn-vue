package controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/addTodo")
public class AddTodo extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 获取参数
        // 检验 参数
        // 构建对象
        // 插入到数据库

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/admin/404.jsp").forward(request, response);
    }
}
