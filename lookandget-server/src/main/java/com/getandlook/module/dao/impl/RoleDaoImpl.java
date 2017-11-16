package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.RoleDao;
import com.getandlook.module.domain.Role;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public List<Role> getAllRole() {
        return (List<Role>) template.findByCriteria(DetachedCriteria.forClass(Role.class));
    }

    @Override
    public void create(Role role) {
        template.save(role);
    }
}
