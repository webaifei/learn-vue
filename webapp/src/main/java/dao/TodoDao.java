package dao;

import model.Todo;
import sun.dc.pr.PRError;
import utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private Connection connection;

    public TodoDao() {
        this.connection = DbUtil.getConnection();
    }

    /**
     * 添加一条记录
     *
     * @param todo 要添加的记录
     */
    public void addTodo(Todo todo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into todos(title) values (?)");
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新todo
     *
     * @param todo
     */
    public void updateTodo(Todo todo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update todos set status=?, statusDesc=?" + " where id=?");
            preparedStatement.setBoolean(1, todo.isStatus());
            preparedStatement.setString(2, todo.getStatusDesc());
            preparedStatement.setInt(3, todo.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean removeTodoByTitle(String title) {
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from todos where title=?");
            preparedStatement.setString(1, title);
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows == 0 ? false : true;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<Todo>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from todos");
            while (rs.next()) {
                Todo Todo = new Todo();
                Todo.setId(rs.getInt("id"));
                Todo.setTitle(rs.getString("title"));
                Todo.setStatus(rs.getBoolean("status"));
                Todo.setStatusDesc(rs.getString("statusDesc"));
                todos.add(Todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }
}
