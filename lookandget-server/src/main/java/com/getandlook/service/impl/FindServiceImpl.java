package com.getandlook.service.impl;

import com.getandlook.module.dao.interfaces.TypeContentDao;
import com.getandlook.module.domain.TypeContent;
import com.getandlook.service.interfaces.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

@Service
public class FindServiceImpl implements FindService {
    @Autowired
    private TypeContentDao typeContentDao;

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
}
