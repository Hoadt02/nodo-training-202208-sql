package edu.hanoi.DAO.impl;

import edu.hanoi.DAO.GroupDAO;
import edu.hanoi.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;


@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    private final static Logger LOGGER = Logger.getLogger(GroupDAO.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(group);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save group " + group.getName() + " done!");
            System.out.println(sessionFactory + ": Insert group " + group);
        }finally {
            session.close();
        }
    }

    @Override
    public List<Group> list(String name) {
        Session session = sessionFactory.getObject().openSession();
        Query query;
        try {
            if (name == null || name.length() < 1){
                query = session.createQuery( "from Group");
                return query.getResultList();
            }else {
                query = session.createQuery("from Group where name like :name");
                query.setParameter("name", "%" + name + "%");
                return query.getResultList();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getObject().openSession();
        Group group = session.get(Group.class, id);
        if (group == null) return;
        try {
            session.getTransaction().begin();
            session.delete(group);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Delete group " + group.getName() + " done!");
            System.out.println(sessionFactory + ": Delete group " + group);
        }finally {
            session.close();
        }
    }

    @Override
    public void update(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.merge(group);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Update group " + group.getName() + " done!");
            System.out.println(sessionFactory + ": Update group " + group);
        }finally {
            session.close();
        }
    }

    @Override
    public Group get(Integer id) {
        Session session = sessionFactory.getObject().openSession();
        Group group = session.get(Group.class, id);
        session.close();
        return group;
    }
}
