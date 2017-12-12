package com.getandlook.module.dto;

import com.getandlook.module.domain.Role;
import com.getandlook.module.domain.User;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

public class UserDto {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        Role role = new Role();
        role.setId(roleId);

        return new User(getUsername(), getPassword(), role);
    }
}
