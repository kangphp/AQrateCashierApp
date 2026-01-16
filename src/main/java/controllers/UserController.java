package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.*;
import models.User;

public class UserController {
    private dao.UserDAO userDAO;

    public UserController() {
        this.userDAO = new dao.impl.UserDAOImpl();
    }

    public ArrayList<User> getAll() {
        return new ArrayList<>(userDAO.getAll());
    }

    public User getById(int user_id) {
        return userDAO.getById(user_id);
    }

    public Boolean update(String user_id, String name, String username, String password, String role) {
        User user = new User(Integer.parseInt(user_id), name, username, password, role, null);
        return userDAO.update(user);
    }

    public Boolean delete(String user_id) {
        return userDAO.delete(Integer.parseInt(user_id));
    }

    public Boolean insert(User pengguna) {
        return userDAO.save(pengguna);
    }

    public User getLogin(String username, String password) {
        return userDAO.authenticate(username, password);
    }

    public void close() {
        // DAO manages connection internally or we can add close method to DAO if needed
        // For now, DatabaseUtil inside DAO handles it per query or we rely on
        // GC/connection pooling later
    }

}
