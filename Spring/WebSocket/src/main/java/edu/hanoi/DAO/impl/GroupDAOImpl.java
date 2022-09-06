package edu.hanoi.DAO.impl;

import edu.hanoi.DAO.GroupDAO;
import edu.hanoi.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    @Qualifier("sessionFactory")
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Group> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from Group");
            return query.list();
        }finally {
            session.close();
        }
    }
}
