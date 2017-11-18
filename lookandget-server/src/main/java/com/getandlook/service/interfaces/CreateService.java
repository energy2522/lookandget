package com.getandlook.service.interfaces;

import com.getandlook.module.domain.Client;
import com.getandlook.module.domain.ContentOfClient;
import com.getandlook.module.domain.TypeContent;
import com.getandlook.module.dto.ContentOfClientDto;
import com.getandlook.module.dto.UserDto;

import java.util.Map;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

public interface CreateService {

    boolean createUser(UserDto user);

    void createContentFotClient(ContentOfClient contentOfClient);

    void createClient(Client client);

    void createTypeContent(TypeContent typeContent);

}
