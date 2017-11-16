package com.getandlook.module.domain;

import javax.persistence.*;

/**
 * Created by Володимир Майборода on 28.10.2017.
 */

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Role() {
    }

    public Role(String name) {

        this.name = name;
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
}
