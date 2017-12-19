package com.getandlook.service.impl;

import com.getandlook.module.dto.UserDto;
import com.getandlook.service.interfaces.AndroidAuthentication;
import com.getandlook.service.interfaces.CreateService;
import com.getandlook.service.security.SecurityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 * Created by Володимир Майборода on 16.12.2017.
 */
@Service
@RequestMapping("/android")
public class AndroidAuthenticationImpl implements AndroidAuthentication {
    private static final Logger LOG = LogManager.getLogger(AndroidAuthenticationImpl.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CreateService createService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @Override
    public @ResponseBody String login(@RequestBody UserDto userDto) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        LOG.info("authentication user with login = {} and password = {}", username, password);
        try {
            securityService.autoLogin(username, password);
        } catch (Exception e) {
            LOG.info("wrong authentication !!!");
            return "error";
        }

        return "success";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody String signUp(@RequestBody UserDto userDto) {
        userDto.setRoleId(2);

        LOG.info("registration user with next params login = {}, password = {}, email = {}", userDto.getUsername(),
                userDto.getPassword(), userDto.getEmail());

        try {
            createService.createUser(userDto);
        } catch (Exception e) {
            LOG.error("can't save user!!! ERROR");
            return "error";
        }

        try {
            securityService.autoLogin(userDto.getUsername(), userDto.getPassword());
        } finally {
            return "success";
        }


    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public @ResponseBody String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "success";
    }
}
