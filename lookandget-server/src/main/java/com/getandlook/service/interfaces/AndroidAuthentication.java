package com.getandlook.service.interfaces;

import com.getandlook.module.dto.UserDto;

/**
 * Created by Володимир Майборода on 16.12.2017.
 */
public interface AndroidAuthentication {

    String login(UserDto userDto);

    String signUp( UserDto userDto);
}
