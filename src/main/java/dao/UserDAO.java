package dao;

import models.User;
import java.util.List;

public interface UserDAO {
    List<User> getAll();

    User getById(int id);

    User getByUsername(String username);

    User authenticate(String username, String password);

    boolean save(User user);

    boolean update(User user);

    boolean delete(int id);
}
