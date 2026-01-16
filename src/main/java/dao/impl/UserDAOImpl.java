package dao.impl;

import dao.UserDAO;
import models.User;
import utils.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private DatabaseUtil dbUtil;

    public UserDAOImpl() {
        this.dbUtil = new DatabaseUtil();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        ResultSet rs = dbUtil.executeSelect("SELECT * FROM users");
        try {
            while (rs != null && rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        ArrayList<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        ResultSet rs = dbUtil.executeSelect("SELECT * FROM users WHERE id = ?", params);
        try {
            if (rs != null && rs.next()) {
                return extractUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByUsername(String username) {
        ArrayList<String> params = new ArrayList<>();
        params.add(username);
        ResultSet rs = dbUtil.executeSelect("SELECT * FROM users WHERE username = ?", params);
        try {
            if (rs != null && rs.next()) {
                return extractUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User authenticate(String username, String password) {
        ArrayList<String> params = new ArrayList<>();
        params.add(username);
        params.add(password);
        ResultSet rs = dbUtil.executeSelect("SELECT * FROM users WHERE username = ? AND password = ?", params);
        try {
            if (rs != null && rs.next()) {
                return extractUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        // Assuming role is added to DB schema
        ArrayList<String> params = new ArrayList<>();
        params.add(user.getName());
        params.add(user.getUsername());
        params.add(user.getPassword());
        params.add(user.getRole());

        String sql = "INSERT INTO users (name, username, password, role) VALUES (?, ?, ?, ?)";
        return dbUtil.execute(sql, params);
    }

    @Override
    public boolean update(User user) {
        ArrayList<String> params = new ArrayList<>();
        params.add(user.getName());
        params.add(user.getUsername());
        params.add(user.getPassword());
        params.add(user.getRole());
        params.add(String.valueOf(user.getId()));

        String sql = "UPDATE users SET name = ?, username = ?, password = ?, role = ? WHERE id = ?";
        return dbUtil.execute(sql, params);
    }

    @Override
    public boolean delete(int id) {
        ArrayList<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        return dbUtil.execute("DELETE FROM users WHERE id = ?", params);
    }

    private User extractUser(ResultSet rs) throws Exception {
        // Handle new role column safely (might not exist yet if DB not migrated)
        String role = "cashier";
        try {
            role = rs.getString("role");
            if (role == null)
                role = "cashier";
        } catch (Exception e) {
            // Column might not exist yet
        }

        Timestamp ts = rs.getTimestamp("created_at");
        // Handling older schema where created_at might be 5th column or named
        // differently
        // Existing code used index 5 for timestamp
        if (ts == null) {
            try {
                ts = rs.getTimestamp(5);
            } catch (Exception e) {
            }
        }

        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password"),
                role,
                ts != null ? ts.toLocalDateTime() : null);
    }
}
