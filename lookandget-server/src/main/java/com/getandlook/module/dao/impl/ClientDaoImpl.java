package com.getandlook.module.dao.impl;

import com.getandlook.module.dao.interfaces.ClientDao;
import com.getandlook.module.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public void create(Client client) {
        template.save(client);
    }

    @Override
    public Client findById(Integer id) {
        return template.get(Client.class, id);
    }
}
