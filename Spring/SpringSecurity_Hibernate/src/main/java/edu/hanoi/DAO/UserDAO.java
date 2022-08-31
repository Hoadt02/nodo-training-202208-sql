package edu.hanoi.DAO;

import edu.hanoi.model.Group;
import edu.hanoi.model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserDAO {

    public void insert(User user);

    public List<User> list(Integer group);

    public User get(String username);
}
