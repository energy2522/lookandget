package com.getandlook.controller;

import com.getandlook.module.dto.UserDto;
import com.getandlook.service.interfaces.CreateService;
import com.getandlook.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Володимир Майборода on 10.12.2017.
 */
@Controller
public class LoginController {
    @Autowired
    private SecurityService securityService;

    @Autowired
    private CreateService createService;

    @RequestMapping(value = {"/", "/check"}, method = RequestMethod.GET)
    public String check() {
        String role;
        String redirect = "redirect: ";
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        role = user.getAuthorities().iterator().next().getAuthority();

        if (role.equals("ROLE_USER")) {
            redirect += "user/main";
        } else {
            redirect += "admin/main";
        }

        return redirect;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request) {
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserDto userDto = new UserDto();
        userDto.setUsername(login);
        userDto.setPassword(password);
        userDto.setEmail(email);
        userDto.setRoleId(2);

        createService.createUser(userDto);

        securityService.autoLogin(login, password);

        return "redirect: main";
    }

    @RequestMapping(value = "/user/main", method = RequestMethod.GET)
    public String goToMainForUser() {
        return "main";
    }

    @RequestMapping(value = "/admin/main", method = RequestMethod.GET)
    public String goToMainForAdmin() {
        return "main";
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


}
