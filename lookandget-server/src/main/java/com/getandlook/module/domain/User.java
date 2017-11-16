package com.getandlook.module.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Володимир Майборода on 28.10.2017.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "login", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Advertising> advertisingList;

    public User() {
    }

    public User(String username, String password, Role role) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.advertisingList = advertisingList;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Advertising> getAdvertisingList() {
        return advertisingList;
    }

    public void setAdvertisingList(List<Advertising> advertisingList) {
        this.advertisingList = advertisingList;
    }
}
