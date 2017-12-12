package com.getandlook.module.dao.interfaces;

import com.getandlook.module.domain.Client;

import java.util.List;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface ClientDao {

    void create(Client client);

    Client findById(Integer id);

    List<Client> findByUserId(Integer id);
}
