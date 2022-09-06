package edu.hanoi.DAO.impl;

import edu.hanoi.DAO.UserDAO;
import edu.hanoi.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            Serializable value = session.save(user);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save user " + user.getUsername() + " done !");
            return value.toString();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return null;
    }
    @Override
    public List<User> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from User order by age desc ");
            return query.list();
        }finally {
            session.close();
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
       try {
           return session.get(User.class ,username);
       }finally {
           session.close();
       }
    }

    @Override
    public void delete(String name) {
        Session session = sessionFactory.getObject().openSession();
        User user = get(name);
        try {
            if (user != null){
                session.getTransaction().begin();
                session.delete(user);
                session.flush();
                session.getTransaction().commit();
                LOGGER.info("Delete user " + name + " done !");
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
