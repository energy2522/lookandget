package com.getandlook.service.interfaces;

import com.getandlook.module.domain.Client;
import com.getandlook.module.dto.ContentOfClientDto;
import com.getandlook.module.dto.UserDto;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

public interface CreateService {

    boolean createUser(UserDto user);

    void createContentFotClient(ContentOfClientDto contentOfClient);

    void createClient(Client client);

}
