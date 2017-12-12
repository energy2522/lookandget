package com.getandlook.service.impl;

import com.getandlook.module.dao.interfaces.ClientDao;
import com.getandlook.module.dao.interfaces.TypeContentDao;
import com.getandlook.module.domain.Client;
import com.getandlook.module.domain.ContentOfClient;
import com.getandlook.module.domain.TypeContent;
import com.getandlook.service.interfaces.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Path("/admin/find")
@Service
public class FindServiceImpl implements FindService {
    @Autowired
    private TypeContentDao typeContentDao;

    @Autowired
    private ClientDao clientDao;

    @Override
    public boolean isExistsTypeContent(String name) {
        if (typeContentDao.getByName(name) == null) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public TypeContent findTypeContentByName(String name) {
        return typeContentDao.getByName(name);
    }

    @Override
    public ContentOfClient findContentOfClient(TypeContent typeContent, Client client) {
        return null;
    }

    @Override
    public Client findClientById(Integer id) {
        return clientDao.findById(id);
    }

    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Client> findByUserId() {
        return clientDao.findByUserId(2);
    }
}
