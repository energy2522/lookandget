package com.getandlook.module.dao.interfaces;

import com.getandlook.module.domain.Advertising;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface AdvertisingDao {

    void create(Advertising advertising);

    Advertising getById(Integer id);
}
