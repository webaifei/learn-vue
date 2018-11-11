package controller;

import dao.TodoDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/home")
public class Home extends javax.servlet.http.HttpServlet {
    private TodoDao dao;
    public Home() {
        super();
        dao = new TodoDao();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("todos", dao.getAllTodos());
//        request.setAttribute("name", "hello jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
}
