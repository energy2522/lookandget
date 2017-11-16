package com.getandlook.service.interfaces;

import com.getandlook.module.domain.TypeContent;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface FindService {

    boolean isExistsTypeContent(String name);

    TypeContent findTypeContentByName(String name);
}
