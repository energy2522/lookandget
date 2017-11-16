package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.TypeContentDao;
import com.getandlook.module.domain.TypeContent;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class TypeContentDaoImpl implements TypeContentDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public TypeContent getByName(String name) {
        List<TypeContent> list = (List<TypeContent>) template.findByCriteria(DetachedCriteria.
                forClass(TypeContent.class).add(Restrictions.eq("name", name)));

        if (list.isEmpty() || list == null) {
            return null;
        } else {
            return DataAccessUtils.uniqueResult(list);
        }
    }

    @Override
    public void create(TypeContent typeContent) {
        template.save(typeContent);
    }
}
