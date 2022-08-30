package edu.hanoi.DAO;

import edu.hanoi.model.Group;

import java.util.List;

public interface GroupDAO {
    public void insert(Group group);

    public List<Group> list();

    public void delete(int id);

    public void update(Group group);

    public Group get(Integer id);
}
