package controller;

import com.alibaba.fastjson.JSON;
import dao.TodoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/removeTodo")
public class ServletRemoveTodo extends HttpServlet {
    private TodoDao dao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao = new TodoDao();
        Map ret = new HashMap();

        //返回响应
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //获取参数
        String title = request.getParameter("title");
        //校验
        if(title != null  && !title.equals("")) {
            //执行删除
            boolean res = dao.removeTodoByTitle(title);
            // 删除成功
            if(res) {
                ret.put("code", 1);
                ret.put("data", null);
                ret.put("status", "ok");
            } else {
                ret.put("code", 0);
                ret.put("data", null);
                ret.put("status", "fail");
            }
        } else {
            ret.put("code", 0);
            ret.put("data", null);
            ret.put("status", "fail");
        }


        String retString = JSON.toJSONString(ret);
        OutputStream out = response.getOutputStream();
        out.write(retString.getBytes("UTF-8"));
        out.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/404.jsp").forward(request, response);
    }
}
