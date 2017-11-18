package com.getandlook.service.impl;

import com.getandlook.module.dao.interfaces.ClientDao;
import com.getandlook.module.dao.interfaces.ContentOfClientDao;
import com.getandlook.module.dao.interfaces.TypeContentDao;
import com.getandlook.module.dao.interfaces.UserDao;
import com.getandlook.module.domain.Client;
import com.getandlook.module.domain.ContentOfClient;
import com.getandlook.module.domain.TypeContent;
import com.getandlook.module.dto.ContentOfClientDto;
import com.getandlook.module.dto.UserDto;
import com.getandlook.module.image.impl.ImageProcessingByAmazon;
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
import java.util.Map;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

@Path("/admin/create")
@Service
public class CreateServiceImpl implements CreateService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private TypeContentDao typeContentDao;

    @Autowired
    private ContentOfClientDao contentOfClientDao;

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
    public void createContentFotClient(ContentOfClient contentOfClient) {
        ContentOfClient temp = contentOfClientDao.findByClientAndContent(contentOfClient.getClient().getId(),
                contentOfClient.getTypeContent().getName());

        if (temp == null) {
            contentOfClientDao.create(contentOfClient);
        } else {
            temp.setSurprise(temp.getSurprise() + contentOfClient.getSurprise());
            temp.setSadness(temp.getSadness() + contentOfClient.getSadness());
            temp.setNeutral(temp.getNeutral() + contentOfClient.getNeutral());
            temp.setHappiness(temp.getHappiness() + contentOfClient.getHappiness());
            temp.setFear(temp.getFear() + contentOfClient.getFear());
            temp.setDisgust(temp.getDisgust() + contentOfClient.getDisgust());
            temp.setContempt(temp.getContempt() + contentOfClient.getContempt());
            temp.setAnger(temp.getAnger() + contentOfClient.getAnger());
            temp.setMap(contentOfClient.getMap());
            temp.setMostEmotion(ImageProcessingByAmazon.getMostEmotion(temp.getMap()));

            contentOfClientDao.create(temp);
        }
    }

    @Transactional
    @Override
    public void createClient(Client client) {
        clientDao.create(client);
    }

    @Override
    public void createTypeContent(TypeContent typeContent) {
        typeContentDao.create(typeContent);
    }

}
