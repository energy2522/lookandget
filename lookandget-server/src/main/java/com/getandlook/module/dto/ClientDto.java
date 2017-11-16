package com.getandlook.module.dto;

import com.getandlook.module.domain.Client;
import com.getandlook.module.domain.User;

import java.util.Date;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

public class ClientDto {

    private Integer id;

    private String name;

    private Date birthDate;

    private Integer userId;

    public ClientDto(String name, Date birthDate, Integer userId) {
        this.name = name;
        this.birthDate = birthDate;
        this.userId = userId;
    }

    public ClientDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Client getClient() {
        User user = new User();
        user.setId(getUserId());

       return new Client(getName(), getBirthDate(), user);
    }
}
