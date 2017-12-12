package com.getandlook.service.security;


import com.getandlook.module.dao.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Володимир Майборода on 11.10.2017.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.getandlook.module.domain.User user = userDao.findByUsername(username);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        grantedAuthoritySet.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new User(user.getUsername(), user.getPassword(), grantedAuthoritySet);
    }
}
