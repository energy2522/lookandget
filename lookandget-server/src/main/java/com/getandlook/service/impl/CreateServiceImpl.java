package com.getandlook.service.impl;

import com.getandlook.module.dao.interfaces.ClientDao;
import com.getandlook.module.dao.interfaces.UserDao;
import com.getandlook.module.domain.Client;
import com.getandlook.module.dto.ContentOfClientDto;
import com.getandlook.module.dto.UserDto;
import com.getandlook.service.interfaces.CreateService;
import com.getandlook.service.interfaces.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

@Path("/admin/create")
@Service
public class CreateServiceImpl implements CreateService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private FindService findService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ClientDao clientDao;

    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Override
    public boolean createUser(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDao.create(user.getUser());

        return true;
    }

    @Override
    public void createContentFotClient(ContentOfClientDto contentOfClient) {
        //TODO
    }

    @Transactional
    @Override
    public void createClient(Client client) {
        clientDao.create(client);
    }

}
