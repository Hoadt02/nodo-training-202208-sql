package edu.hanoi.DAO.impl;

import edu.hanoi.DAO.UserDAO;
import edu.hanoi.model.Group;
import edu.hanoi.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDAO")
public class UserDAOimpl implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAOimpl.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(user);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save user " + user.getUsername() + " done !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }
    @Override
    public List<User> list(Integer group) {
        Session session = sessionFactory.getObject().openSession();
        Query query = null;
        try {
            if (group == null || group < 0){
                query = session.createQuery("from User");
                return query.list();
            }
            query = session.createQuery("from User where groupId = :groupId");
            query.setParameter("groupId",group);
            return query.list();
        }  finally {
            session.close();
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(User.class ,username);
    }
}
