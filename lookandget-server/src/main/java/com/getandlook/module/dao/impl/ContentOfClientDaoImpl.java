package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.ContentOfClientDao;
import com.getandlook.module.domain.ContentOfClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class ContentOfClientDaoImpl implements ContentOfClientDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public void create(ContentOfClient contentOfClient) {
        template.save(contentOfClient);
    }
}
