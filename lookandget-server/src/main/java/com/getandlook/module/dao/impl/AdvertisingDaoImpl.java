package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.AdvertisingDao;
import com.getandlook.module.domain.Advertising;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class AdvertisingDaoImpl implements AdvertisingDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public void create(Advertising advertising) {
        template.save(advertising);
    }

    @Override
    public Advertising getById(Integer id) {
        return (Advertising) template.load(Advertising.class.getSimpleName(), id);
    }
}
