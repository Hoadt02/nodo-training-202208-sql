package edu.hanoi.DAO;

import edu.hanoi.model.User;

import java.util.List;

public interface UserDAO {
    public String insert(User user);

    public List<User> list();

    public User get(String username);

    public void delete(String name);

    public void update(User user);
}
