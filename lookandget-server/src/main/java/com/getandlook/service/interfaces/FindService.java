package com.getandlook.service.interfaces;

import com.getandlook.module.domain.Client;
import com.getandlook.module.domain.ContentOfClient;
import com.getandlook.module.domain.TypeContent;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface FindService {

    boolean isExistsTypeContent(String name);

    TypeContent findTypeContentByName(String name);

    ContentOfClient findContentOfClient(TypeContent typeContent, Client client);

    Client findClientById(Integer id);

}
