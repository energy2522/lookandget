package com.getandlook.service.security;

/**
 * Created by Володимир Майборода on 11.10.2017.
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
