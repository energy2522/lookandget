package com.getandlook.module.dao.interfaces;

import com.getandlook.module.domain.User;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface UserDao {

    User findByUsername(String username);

    void create(User user);

}
