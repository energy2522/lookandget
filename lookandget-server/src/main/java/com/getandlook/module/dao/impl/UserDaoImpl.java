package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.UserDao;
import com.getandlook.module.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public User findByUsername(String username) {
        return (User) DataAccessUtils.uniqueResult(template.find("from User u where u.username = ?",
                username));

    }

    @Transactional
    @Override
    public void create(User user) {
        template.save(user);
    }
}
