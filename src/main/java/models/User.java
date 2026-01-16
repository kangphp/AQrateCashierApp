package models;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String role; // 'admin' or 'cashier'
    private LocalDateTime created_at;

    public User(int id, String name, String username, String password, String role, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.created_at = created_at;
    }

    public User(int id, String name, String username, String password, LocalDateTime created_at) {
        this(id, name, username, password, "cashier", created_at); // Default to cashier
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsernameS(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Created At: %s",
                getId(),
                getName(),
                getUsername(),
                getCreatedAt());
    }

}
