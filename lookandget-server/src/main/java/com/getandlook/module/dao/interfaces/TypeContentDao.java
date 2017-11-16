package com.getandlook.module.dao.interfaces;

import com.getandlook.module.domain.TypeContent;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface TypeContentDao {

    TypeContent getByName(String name);

    void create(TypeContent typeContent);
}
