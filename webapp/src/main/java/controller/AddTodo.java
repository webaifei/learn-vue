package controller;

import com.alibaba.fastjson.JSON;
import dao.TodoDao;
import model.Todo;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addTodo")
public class AddTodo extends javax.servlet.http.HttpServlet {
    private TodoDao dao;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 获取参数
        String title = request.getParameter("title");
        boolean status = false;
        String statusDesc = "未完成";
        Date curDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String createTime = dateFormat.format(curDate);

        TodoDao dao = new TodoDao();
        // 构建对象
        Todo todo = new Todo();

        todo.setTitle(title);
        todo.setStatus(status);
        todo.setStatusDesc(statusDesc);
        todo.setCreateTime(createTime);

        Map ret = new HashMap();

        //返回响应
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");


        // 检验 参数
        if(title != null && !title.equals("")) {
            // 插入到数据库
            dao.addTodo(todo);
            ret.put("code", 1);
            ret.put("data", todo);
            ret.put("status", "ok");
        } else {
            ret.put("code", 0);
            ret.put("data", "fail");
            ret.put("status", "fail");
        }

        String retString = JSON.toJSONString(ret);
        OutputStream out = response.getOutputStream();
        out.write(retString.getBytes("UTF-8"));
        out.flush();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/admin/404.jsp").forward(request, response);
    }
}
